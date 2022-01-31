package com.tencent.mobileqq.activity.recent.data;

import acyk;
import ajya;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import aykk;
import bbfh;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import nqn;

public class RecentItemEcShopAssitant
  extends RecentUserBaseData
{
  static final String TAG = "RecentItemEcShopAssitant";
  long newStrTime;
  
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 2;
  }
  
  private void f()
  {
    if ((this.mExtraInfo != null) && (ajya.a(2131713177).equalsIgnoreCase(this.mExtraInfo.toString()))) {
      this.mExtraInfo = "";
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
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = paramContext.getString(2131691959);
    }
    if (!TextUtils.isEmpty(nqn.c)) {
      this.mTitleName = nqn.c;
    }
    Object localObject2 = null;
    nqn localnqn = (nqn)paramQQAppInterface.getManager(88);
    Object localObject3 = paramQQAppInterface.a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      EcShopData localEcShopData = localnqn.a();
      localObject1 = localObject2;
      if (localEcShopData != null) {
        localObject1 = ((QQMessageFacade)localObject3).a(localEcShopData.mUin, 1008);
      }
    }
    localObject3 = super.a();
    int i;
    if (localObject1 != null)
    {
      this.mUnreadNum = localnqn.a(paramQQAppInterface);
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = localnqn.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        bbfh.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), (MsgSummary)localObject3, (String)localObject2, true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          ((MsgSummary)localObject3).suffix = "";
          ((MsgSummary)localObject3).strContent = "";
          localObject2 = acyk.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label824;
          }
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
      }
      label261:
      localObject2 = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localnqn.d = false;
      if ((i <= this.mDisplayTime) && ((!TextUtils.isEmpty(((MsgSummary)localObject3).strContent)) || (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)))) {
        break label1057;
      }
      long l = i;
      this.mDisplayTime = l;
      this.newStrTime = l;
      if (this.mUser != null) {
        this.mUser.lastmsgtime = this.mDisplayTime;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("str_ecshop_diy", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label953;
      }
      localnqn.d = true;
      ((MsgSummary)localObject3).strContent = ((CharSequence)localObject2);
      ((MsgSummary)localObject3).suffix = null;
      ((MsgSummary)localObject3).strPrefix = null;
      label438:
      this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
      if (!((SharedPreferences)localObject1).contains("PUSH_TYPE_COLOR")) {}
    }
    for (;;)
    {
      try
      {
        this.mExtraInfoColor = Color.parseColor(((SharedPreferences)localObject1).getString("PUSH_TYPE_COLOR", ""));
        if (((SharedPreferences)localObject1).getBoolean("folder_reddot", false))
        {
          int j = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
          int k = ((SharedPreferences)localObject1).getInt("reddot_start", 0);
          int m = ((SharedPreferences)localObject1).getInt("reddot_end", 0);
          int n = ((SharedPreferences)localObject1).getInt("max_reddot_time", 0);
          int i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 != 0) && (k != 0) && (m != 0) && (n != 0))
          {
            if ((i1 >= k) && (i1 <= m) && (i1 - j < n))
            {
              localnqn.e = true;
              if (i > this.mDisplayTime) {
                this.mDisplayTime = i;
              }
              this.mMsgExtroInfo = ((SharedPreferences)localObject1).getString("PUSH_TYPE_NAME", "");
            }
          }
          else
          {
            f();
            a(paramQQAppInterface, (MsgSummary)localObject3);
            a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
            if ((this.mUnreadNum == 0) && (localnqn.e)) {
              this.mUnreadNum = 1;
            }
            if (AppSetting.d)
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(this.mTitleName).append(",");
              if (this.mUnreadNum > 0)
              {
                i = localnqn.a();
                if ((i != 0) && (!localnqn.e)) {
                  break label1065;
                }
              }
              if (this.mMsgExtroInfo != null) {
                paramQQAppInterface.append(this.mMsgExtroInfo + ",");
              }
              if (this.mUnreadNum <= 0) {
                break label1122;
              }
              paramQQAppInterface.append(this.mShowTime);
              this.mContentDesc = paramQQAppInterface.toString();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject3).strPrefix);
            return;
            label824:
            localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
            if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
            {
              localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
              ((MsgSummary)localObject3).strContent = ((CharSequence)localObject1);
              break label261;
            }
            continue;
            this.mUnreadNum = 0;
            this.mDisplayTime = 0L;
            break label261;
            label953:
            if (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)) {
              break label438;
            }
            ((MsgSummary)localObject3).strContent = paramContext.getString(2131691956);
            ((MsgSummary)localObject3).strPrefix = null;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
        this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
        }
        localnqn.e = false;
        this.mUnreadNum = 0;
        this.mMsgExtroInfo = "";
        continue;
        this.mMsgExtroInfo = "";
        continue;
      }
      label1057:
      a(paramContext);
      continue;
      label1065:
      if (i == 1)
      {
        paramQQAppInterface.append("有一条未读");
      }
      else if (i == 2)
      {
        paramQQAppInterface.append("有两条未读");
      }
      else if (i > 0)
      {
        paramQQAppInterface.append("有").append(i).append("条未读,");
        continue;
        label1122:
        paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      }
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
      nqn localnqn;
      do
      {
        do
        {
          return;
          localnqn = (nqn)paramQQAppInterface.getManager(88);
          if (localnqn != null) {
            localEcShopData = localnqn.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.mDisplayTime >= localEcShopData.mLastDraftTime) || (this.newStrTime > localEcShopData.mLastDraftTime));
        this.mStatus = 4;
        localObject = ((QQMessageFacade)localObject).a(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localnqn.a(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new aykk(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */