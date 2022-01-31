package com.tencent.mobileqq.activity.recent.data;

import aepx;
import alpo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import aokd;
import baig;
import bdec;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ntw;

public class RecentItemEcShopAssitant
  extends RecentUserBaseData
{
  static final String TAG = "RecentItemEcShopAssitant";
  long newStrTime;
  
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void f()
  {
    if ((this.mExtraInfo != null) && (alpo.a(2131713549).equalsIgnoreCase(this.mExtraInfo.toString()))) {
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
    label30:
    Object localObject2;
    ntw localntw;
    Object localObject3;
    Object localObject1;
    int i;
    if (aokd.a("MiniAppEcShopNumMsgEnable", 1) == 1)
    {
      this.mUnreadFlag = 1;
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131692014);
      }
      if (!TextUtils.isEmpty(ntw.c)) {
        this.mTitleName = ntw.c;
      }
      localObject2 = null;
      localntw = (ntw)paramQQAppInterface.getManager(88);
      localObject3 = paramQQAppInterface.a();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        EcShopData localEcShopData = localntw.a();
        localObject1 = localObject2;
        if (localEcShopData != null) {
          localObject1 = ((QQMessageFacade)localObject3).a(localEcShopData.mUin, 1008);
        }
      }
      localObject3 = super.a();
      if (localObject1 == null) {
        break label963;
      }
      this.mUnreadNum = localntw.a(paramQQAppInterface);
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = localntw.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        bdec.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), (MsgSummary)localObject3, (String)localObject2, true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          ((MsgSummary)localObject3).suffix = "";
          ((MsgSummary)localObject3).strContent = "";
          localObject2 = aepx.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label847;
          }
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
      }
      label276:
      localObject2 = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localntw.d = false;
      if ((i <= this.mDisplayTime) && ((!TextUtils.isEmpty(((MsgSummary)localObject3).strContent)) || (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)))) {
        break label1080;
      }
      long l = i;
      this.mDisplayTime = l;
      this.newStrTime = l;
      if (this.mUser != null) {
        this.mUser.lastmsgtime = this.mDisplayTime;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("str_ecshop_diy", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label976;
      }
      localntw.d = true;
      ((MsgSummary)localObject3).strContent = ((CharSequence)localObject2);
      ((MsgSummary)localObject3).suffix = null;
      ((MsgSummary)localObject3).strPrefix = null;
      label453:
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167006);
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
              localntw.e = true;
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
            if ((this.mUnreadNum == 0) && (localntw.e)) {
              this.mUnreadNum = 1;
            }
            if (AppSetting.c)
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(this.mTitleName).append(",");
              if (this.mUnreadNum > 0)
              {
                i = localntw.a();
                if ((i != 0) && (!localntw.e)) {
                  break label1088;
                }
              }
              if (this.mMsgExtroInfo != null) {
                paramQQAppInterface.append(this.mMsgExtroInfo + ",");
              }
              if (this.mUnreadNum <= 0) {
                break label1145;
              }
              paramQQAppInterface.append(this.mShowTime);
              this.mContentDesc = paramQQAppInterface.toString();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject3).strPrefix);
            return;
            this.mUnreadFlag = 2;
            break label30;
            label847:
            localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
            if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
            {
              localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
              ((MsgSummary)localObject3).strContent = ((CharSequence)localObject1);
              break label276;
            }
            continue;
            label963:
            this.mUnreadNum = 0;
            this.mDisplayTime = 0L;
            break label276;
            label976:
            if (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)) {
              break label453;
            }
            ((MsgSummary)localObject3).strContent = paramContext.getString(2131692011);
            ((MsgSummary)localObject3).strPrefix = null;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167006);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
        }
        localntw.e = false;
        this.mUnreadNum = 0;
        this.mMsgExtroInfo = "";
        continue;
        this.mMsgExtroInfo = "";
        continue;
      }
      label1080:
      a(paramContext);
      continue;
      label1088:
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
        label1145:
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
      ntw localntw;
      do
      {
        do
        {
          return;
          localntw = (ntw)paramQQAppInterface.getManager(88);
          if (localntw != null) {
            localEcShopData = localntw.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.mDisplayTime >= localEcShopData.mLastDraftTime) || (this.newStrTime > localEcShopData.mLastDraftTime));
        this.mStatus = 4;
        localObject = ((QQMessageFacade)localObject).a(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localntw.a(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new baig(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */