package com.tencent.mobileqq.activity.recent.data;

import afdj;
import amtj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import apyt;
import bfwr;
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
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ofx;

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
    if ((this.mExtraInfo != null) && (amtj.a(2131712281).equalsIgnoreCase(this.mExtraInfo.toString()))) {
      this.mExtraInfo = "";
    }
  }
  
  private void a(Context paramContext, ofx paramofx, MsgSummary paramMsgSummary, SharedPreferences paramSharedPreferences, int paramInt)
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
        paramofx.d = true;
        paramMsgSummary.strContent = str;
        paramMsgSummary.suffix = null;
        paramMsgSummary.strPrefix = null;
      }
      for (;;)
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167124);
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
                paramofx.e = true;
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
              paramMsgSummary.strContent = paramContext.getString(2131691719);
              paramMsgSummary.strPrefix = null;
            }
          }
        }
        catch (Exception paramMsgSummary)
        {
          for (;;)
          {
            QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167124);
          }
          if (QLog.isColorLevel()) {
            QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
          }
          paramofx.e = false;
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
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, ofx paramofx, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null)
    {
      this.mUnreadNum = paramofx.a(paramQQAppInterface);
      this.mDisplayTime = paramMessage.time;
      paramofx = paramofx.a(paramQQAppInterface, paramMessage.frienduin);
      if (paramMessage != null)
      {
        bfwr.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, paramofx, true, false);
        int i = paramMessage.msgtype;
        if ((i == -3006) || (i == -5004))
        {
          paramMsgSummary.suffix = "";
          paramMsgSummary.strContent = "";
          paramofx = afdj.a(paramMessage);
          if ((paramofx != null) && (paramofx.items != null) && (paramofx.items.size() != 0)) {
            break label140;
          }
          a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, paramMsgSummary);
        }
      }
      return;
      label140:
      paramQQAppInterface = ((PAMessage.Item)paramofx.items.get(0)).title;
      if ((((PAMessage.Item)paramofx.items.get(0)).cover == null) && (((PAMessage.Item)paramofx.items.get(0)).digestList != null)) {
        paramQQAppInterface = paramQQAppInterface + "：" + (String)((PAMessage.Item)paramofx.items.get(0)).digestList.get(0);
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
  
  private void a(ofx paramofx)
  {
    StringBuilder localStringBuilder;
    int i;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      if (this.mUnreadNum > 0)
      {
        i = paramofx.a();
        if ((i != 0) && (!paramofx.e)) {
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
    if (apyt.a("MiniAppEcShopNumMsgEnable", 1) == 1) {}
    for (this.mUnreadFlag = 1;; this.mUnreadFlag = 2)
    {
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131691721);
      }
      if (!TextUtils.isEmpty(ofx.c)) {
        this.mTitleName = ofx.c;
      }
      String str = null;
      ofx localofx = (ofx)paramQQAppInterface.getManager(88);
      Object localObject2 = paramQQAppInterface.getMessageFacade();
      Object localObject1 = str;
      if (localObject2 != null)
      {
        EcShopData localEcShopData = localofx.a();
        localObject1 = str;
        if (localEcShopData != null) {
          localObject1 = ((QQMessageFacade)localObject2).getLastMessage(localEcShopData.mUin, 1008);
        }
      }
      localObject2 = super.getMsgSummaryTemp();
      a(paramQQAppInterface, paramContext, (QQMessageFacade.Message)localObject1, localofx, (MsgSummary)localObject2);
      str = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      int i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localofx.d = false;
      a(paramContext, localofx, (MsgSummary)localObject2, (SharedPreferences)localObject1, i);
      a();
      a(paramQQAppInterface, (MsgSummary)localObject2);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if ((this.mUnreadNum == 0) && (localofx.e)) {
        this.mUnreadNum = 1;
      }
      a(localofx);
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
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (localObject == null) {}
    do
    {
      ofx localofx;
      do
      {
        do
        {
          return;
          localofx = (ofx)paramQQAppInterface.getManager(88);
          if (localofx != null) {
            localEcShopData = localofx.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.mDisplayTime >= localEcShopData.mLastDraftTime) || (this.newStrTime > localEcShopData.mLastDraftTime));
        this.mStatus = 4;
        localObject = ((QQMessageFacade)localObject).getDraftSummaryInfo(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localofx.a(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */