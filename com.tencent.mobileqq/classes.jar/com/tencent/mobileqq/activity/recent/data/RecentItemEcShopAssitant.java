package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

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
    if ((this.mExtraInfo != null) && (HardCodeUtil.a(2131910658).equalsIgnoreCase(this.mExtraInfo.toString()))) {
      this.mExtraInfo = "";
    }
  }
  
  private void a(Context paramContext, EcShopAssistantManager paramEcShopAssistantManager, MsgSummary paramMsgSummary, SharedPreferences paramSharedPreferences, int paramInt)
  {
    long l = paramInt;
    if ((l <= this.mDisplayTime) && ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      a(paramContext);
      return;
    }
    this.mDisplayTime = l;
    this.newStrTime = l;
    if (this.mUser != null) {
      this.mUser.lastmsgtime = this.mDisplayTime;
    }
    String str = paramSharedPreferences.getString("str_ecshop_diy", null);
    if (!TextUtils.isEmpty(str))
    {
      paramEcShopAssistantManager.A = true;
      paramMsgSummary.strContent = str;
      paramMsgSummary.suffix = null;
      paramMsgSummary.strPrefix = null;
    }
    else if (TextUtils.isEmpty(paramMsgSummary.suffix))
    {
      paramMsgSummary.strContent = paramContext.getString(2131888818);
      paramMsgSummary.strPrefix = null;
    }
    this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
    if (paramSharedPreferences.contains("PUSH_TYPE_COLOR")) {}
    try
    {
      this.mExtraInfoColor = Color.parseColor(paramSharedPreferences.getString("PUSH_TYPE_COLOR", ""));
    }
    catch (Exception paramMsgSummary)
    {
      label189:
      int i;
      int j;
      int k;
      int m;
      break label189;
    }
    QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
    this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
    if (paramSharedPreferences.getBoolean("folder_reddot", false))
    {
      paramInt = paramSharedPreferences.getInt("last_show_time1", 0);
      i = paramSharedPreferences.getInt("reddot_start", 0);
      j = paramSharedPreferences.getInt("reddot_end", 0);
      k = paramSharedPreferences.getInt("max_reddot_time", 0);
      m = (int)(System.currentTimeMillis() / 1000L);
      if ((m != 0) && (i != 0) && (j != 0) && (k != 0))
      {
        if ((m >= i) && (m <= j) && (m - paramInt < k))
        {
          paramEcShopAssistantManager.B = true;
          if (l > this.mDisplayTime) {
            this.mDisplayTime = l;
          }
          this.mMsgExtroInfo = paramSharedPreferences.getString("PUSH_TYPE_NAME", "");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
        }
        paramEcShopAssistantManager.B = false;
        this.mUnreadNum = 0;
        this.mMsgExtroInfo = "";
      }
    }
    else
    {
      this.mMsgExtroInfo = "";
    }
  }
  
  private void a(EcShopAssistantManager paramEcShopAssistantManager)
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName);
      localStringBuilder.append(",");
      if (this.mUnreadNum > 0)
      {
        int i = paramEcShopAssistantManager.i();
        if ((i != 0) && (!paramEcShopAssistantManager.B)) {
          if (i == 1)
          {
            localStringBuilder.append("有一条未读");
          }
          else if (i == 2)
          {
            localStringBuilder.append("有两条未读");
          }
          else if (i > 0)
          {
            localStringBuilder.append("有");
            localStringBuilder.append(i);
            localStringBuilder.append("条未读,");
          }
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        paramEcShopAssistantManager = new StringBuilder();
        paramEcShopAssistantManager.append(this.mMsgExtroInfo);
        paramEcShopAssistantManager.append(",");
        localStringBuilder.append(paramEcShopAssistantManager.toString());
      }
      if (this.mUnreadNum > 0)
      {
        localStringBuilder.append(this.mShowTime);
      }
      else
      {
        localStringBuilder.append(this.mLastMsg);
        localStringBuilder.append(",");
        localStringBuilder.append(this.mShowTime);
      }
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage, EcShopAssistantManager paramEcShopAssistantManager, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null)
    {
      this.mUnreadNum = paramEcShopAssistantManager.b(paramQQAppInterface);
      this.mDisplayTime = paramMessage.time;
      paramEcShopAssistantManager = paramEcShopAssistantManager.a(paramQQAppInterface, paramMessage.frienduin);
      if (paramMessage != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), paramMsgSummary, paramEcShopAssistantManager, true, false);
        int i = paramMessage.msgtype;
        if ((i == -3006) || (i == -5004))
        {
          paramMsgSummary.suffix = "";
          paramMsgSummary.strContent = "";
          paramEcShopAssistantManager = XMLMessageUtils.a(paramMessage);
          if ((paramEcShopAssistantManager != null) && (paramEcShopAssistantManager.items != null) && (paramEcShopAssistantManager.items.size() != 0))
          {
            paramContext = ((PAMessage.Item)paramEcShopAssistantManager.items.get(0)).title;
            paramQQAppInterface = paramContext;
            if (((PAMessage.Item)paramEcShopAssistantManager.items.get(0)).cover == null)
            {
              paramQQAppInterface = paramContext;
              if (((PAMessage.Item)paramEcShopAssistantManager.items.get(0)).digestList != null)
              {
                paramQQAppInterface = new StringBuilder();
                paramQQAppInterface.append(paramContext);
                paramQQAppInterface.append("：");
                paramQQAppInterface.append((String)((PAMessage.Item)paramEcShopAssistantManager.items.get(0)).digestList.get(0));
                paramQQAppInterface = paramQQAppInterface.toString();
              }
            }
            paramMsgSummary.strContent = paramQQAppInterface;
            return;
          }
          a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, paramMsgSummary);
        }
      }
    }
    else
    {
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
    }
  }
  
  public void a(Context paramContext)
  {
    this.mMsgExtroInfo = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      if (MiniAppConfProcessor.a("MiniAppEcShopNumMsgEnable", 1) == 1) {
        this.mUnreadFlag = 1;
      } else {
        this.mUnreadFlag = 2;
      }
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131888820);
      }
      if (!TextUtils.isEmpty(EcShopAssistantManager.h)) {
        this.mTitleName = EcShopAssistantManager.h;
      }
      Object localObject2 = null;
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      Object localObject3 = paramQQAppInterface.getMessageFacade();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        EcShopData localEcShopData = localEcShopAssistantManager.c();
        localObject1 = localObject2;
        if (localEcShopData != null) {
          localObject1 = ((QQMessageFacade)localObject3).getLastMessage(localEcShopData.mUin, 1008);
        }
      }
      localObject3 = super.getMsgSummaryTemp();
      a(paramQQAppInterface, paramContext, (Message)localObject1, localEcShopAssistantManager, (MsgSummary)localObject3);
      localObject2 = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ecshop_sp");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = paramContext.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      int i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localEcShopAssistantManager.A = false;
      a(paramContext, localEcShopAssistantManager, (MsgSummary)localObject3, (SharedPreferences)localObject1, i);
      a();
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      if ((this.mUnreadNum == 0) && (localEcShopAssistantManager.B)) {
        this.mUnreadNum = 1;
      }
      a(localEcShopAssistantManager);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("first string to show:");
        paramQQAppInterface.append(((MsgSummary)localObject3).strPrefix);
        QLog.i("EcShop", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    this.mStatus = 0;
    Object localObject1 = null;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject2 = paramQQAppInterface.getMessageFacade();
    if (localObject2 == null) {
      return;
    }
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null) {
      localObject1 = localEcShopAssistantManager.c();
    }
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(((EcShopData)localObject1).mUin)) {
        return;
      }
      if (this.mDisplayTime < ((EcShopData)localObject1).mLastDraftTime)
      {
        if (this.newStrTime > ((EcShopData)localObject1).mLastDraftTime) {
          return;
        }
        this.mStatus = 4;
        localObject2 = ((QQMessageFacade)localObject2).getDraftSummaryInfo(((EcShopData)localObject1).mUin, 1008);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())) {
            return;
          }
          this.mDisplayTime = ((DraftSummaryInfo)localObject2).getTime();
          localObject2 = ((DraftSummaryInfo)localObject2).getSummary();
          paramQQAppInterface = localEcShopAssistantManager.a(paramQQAppInterface, ((EcShopData)localObject1).mUin);
          if (paramMsgSummary != null)
          {
            paramMsgSummary.bShowDraft = true;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramQQAppInterface);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append((String)localObject2);
            paramMsgSummary.mDraft = new QQText(((StringBuilder)localObject1).toString(), 3, 16);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */