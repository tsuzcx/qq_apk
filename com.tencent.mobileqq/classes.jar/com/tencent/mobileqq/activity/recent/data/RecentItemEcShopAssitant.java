package com.tencent.mobileqq.activity.recent.data;

import agaw;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import anni;
import aqpv;
import bdnt;
import bgnr;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import oda;

public class RecentItemEcShopAssitant
  extends AbsRecentUserBusinessBaseData
{
  static final String TAG = "RecentItemEcShopAssitant";
  long newStrTime;
  
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    if ((this.mExtraInfo != null) && (anni.a(2131711940).equalsIgnoreCase(this.mExtraInfo.toString()))) {
      this.mExtraInfo = "";
    }
  }
  
  private void a(Context paramContext, oda paramoda, MsgSummary paramMsgSummary, SharedPreferences paramSharedPreferences, int paramInt)
  {
    if ((paramInt > this.mDisplayTime) || ((TextUtils.isEmpty(paramMsgSummary.strContent)) && (TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      long l = paramInt;
      this.mDisplayTime = l;
      this.newStrTime = l;
      if (this.mUser != null) {
        this.mUser.lastmsgtime = this.mDisplayTime;
      }
      String str = paramSharedPreferences.getString("str_ecshop_diy", null);
      if (!TextUtils.isEmpty(str))
      {
        paramoda.d = true;
        paramMsgSummary.strContent = str;
        paramMsgSummary.suffix = null;
        paramMsgSummary.strPrefix = null;
      }
      for (;;)
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
        if (paramSharedPreferences.contains("PUSH_TYPE_COLOR")) {}
        try
        {
          this.mExtraInfoColor = Color.parseColor(paramSharedPreferences.getString("PUSH_TYPE_COLOR", ""));
          if (paramSharedPreferences.getBoolean("folder_reddot", false))
          {
            int i = paramSharedPreferences.getInt("last_show_time1", 0);
            int j = paramSharedPreferences.getInt("reddot_start", 0);
            int k = paramSharedPreferences.getInt("reddot_end", 0);
            int m = paramSharedPreferences.getInt("max_reddot_time", 0);
            int n = (int)(System.currentTimeMillis() / 1000L);
            if ((n != 0) && (j != 0) && (k != 0) && (m != 0))
            {
              if ((n >= j) && (n <= k) && (n - i < m))
              {
                paramoda.e = true;
                if (paramInt > this.mDisplayTime) {
                  this.mDisplayTime = paramInt;
                }
                this.mMsgExtroInfo = paramSharedPreferences.getString("PUSH_TYPE_NAME", "");
              }
            }
            else
            {
              return;
              if (!TextUtils.isEmpty(paramMsgSummary.suffix)) {
                continue;
              }
              paramMsgSummary.strContent = paramContext.getString(2131691671);
              paramMsgSummary.strPrefix = null;
            }
          }
        }
        catch (Exception paramMsgSummary)
        {
          for (;;)
          {
            QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
          }
          if (QLog.isColorLevel()) {
            QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
          }
          paramoda.e = false;
          this.mUnreadNum = 0;
          this.mMsgExtroInfo = "";
          return;
        }
      }
      this.mMsgExtroInfo = "";
      return;
    }
    a(paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, oda paramoda, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null)
    {
      this.mUnreadNum = paramoda.a(paramQQAppInterface);
      this.mDisplayTime = paramMessage.time;
      paramoda = paramoda.a(paramQQAppInterface, paramMessage.frienduin);
      if (paramMessage != null)
      {
        bgnr.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, paramoda, true, false);
        int i = paramMessage.msgtype;
        if ((i == -3006) || (i == -5004))
        {
          paramMsgSummary.suffix = "";
          paramMsgSummary.strContent = "";
          paramoda = agaw.a(paramMessage);
          if ((paramoda != null) && (paramoda.items != null) && (paramoda.items.size() != 0)) {
            break label140;
          }
          a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, paramMsgSummary);
        }
      }
      return;
      label140:
      paramQQAppInterface = ((PAMessage.Item)paramoda.items.get(0)).title;
      if ((((PAMessage.Item)paramoda.items.get(0)).cover == null) && (((PAMessage.Item)paramoda.items.get(0)).digestList != null)) {
        paramQQAppInterface = paramQQAppInterface + "：" + (String)((PAMessage.Item)paramoda.items.get(0)).digestList.get(0);
      }
      for (;;)
      {
        paramMsgSummary.strContent = paramQQAppInterface;
        return;
      }
    }
    this.mUnreadNum = 0;
    this.mDisplayTime = 0L;
  }
  
  private void a(oda paramoda)
  {
    StringBuilder localStringBuilder;
    int i;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      if (this.mUnreadNum > 0)
      {
        i = paramoda.a();
        if ((i != 0) && (!paramoda.e)) {
          break label112;
        }
      }
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      if (this.mUnreadNum <= 0) {
        break label169;
      }
      localStringBuilder.append(this.mShowTime);
    }
    for (;;)
    {
      this.mContentDesc = localStringBuilder.toString();
      return;
      label112:
      if (i == 1)
      {
        localStringBuilder.append("有一条未读");
        break;
      }
      if (i == 2)
      {
        localStringBuilder.append("有两条未读");
        break;
      }
      if (i <= 0) {
        break;
      }
      localStringBuilder.append("有").append(i).append("条未读,");
      break;
      label169:
      localStringBuilder.append(this.mLastMsg).append(",").append(this.mShowTime);
    }
  }
  
  public void a(Context paramContext)
  {
    this.mMsgExtroInfo = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (aqpv.a("MiniAppEcShopNumMsgEnable", 1) == 1) {}
    for (this.mUnreadFlag = 1;; this.mUnreadFlag = 2)
    {
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131691673);
      }
      if (!TextUtils.isEmpty(oda.c)) {
        this.mTitleName = oda.c;
      }
      String str = null;
      oda localoda = (oda)paramQQAppInterface.getManager(88);
      Object localObject2 = paramQQAppInterface.a();
      Object localObject1 = str;
      if (localObject2 != null)
      {
        EcShopData localEcShopData = localoda.a();
        localObject1 = str;
        if (localEcShopData != null) {
          localObject1 = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
        }
      }
      localObject2 = super.getMsgSummaryTemp();
      a(paramQQAppInterface, paramContext, (QQMessageFacade.Message)localObject1, localoda, (MsgSummary)localObject2);
      str = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      int i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localoda.d = false;
      a(paramContext, localoda, (MsgSummary)localObject2, (SharedPreferences)localObject1, i);
      a();
      a(paramQQAppInterface, (MsgSummary)localObject2);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if ((this.mUnreadNum == 0) && (localoda.e)) {
        this.mUnreadNum = 1;
      }
      a(localoda);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject2).strPrefix);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    EcShopData localEcShopData = null;
    this.mStatus = 0;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    do
    {
      oda localoda;
      do
      {
        do
        {
          return;
          localoda = (oda)paramQQAppInterface.getManager(88);
          if (localoda != null) {
            localEcShopData = localoda.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.mDisplayTime >= localEcShopData.mLastDraftTime) || (this.newStrTime > localEcShopData.mLastDraftTime));
        this.mStatus = 4;
        localObject = ((QQMessageFacade)localObject).getDraftSummaryInfo(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localoda.a(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new bdnt(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */