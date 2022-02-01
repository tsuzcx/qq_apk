package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.config.RecentBaseDataConfig;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.ParcelObject;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.basic.TalkBackProxy;
import com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy;
import com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

@ParcelAnnotation.ParcelObject
public abstract class RecentBaseData
{
  public static final int C2C_PROCESSUNREADNUM = 99;
  public static final int MENU_FLAG_AV_A = 12288;
  public static final int MENU_FLAG_AV_C2C = 4096;
  public static final int MENU_FLAG_AV_DIS = 8192;
  public static final int MENU_FLAG_AV_V = 16384;
  public static final int MENU_FLAG_CANCEL_HIDE = 16777216;
  public static final int MENU_FLAG_DEFAULT = 0;
  public static final int MENU_FLAG_DEL = 1;
  public static final int MENU_FLAG_MASK_AV = 61440;
  public static final int MENU_FLAG_MASK_CANCEL_HIDE = 251658240;
  public static final int MENU_FLAG_MASK_DEL = 15;
  public static final int MENU_FLAG_MASK_READSTATE = 983040;
  public static final int MENU_FLAG_MASK_SETTOP = 240;
  public static final int MENU_FLAG_MASK_SUBSCRIBE = 3145728;
  public static final int MENU_FLAG_MASK_TMSGSETTING = 3840;
  public static final int MENU_FLAG_READSTATE_READ = 65536;
  public static final int MENU_FLAG_READSTATE_UNREAD = 131072;
  public static final int MENU_FLAG_SETTOP = 16;
  public static final int MENU_FLAG_SETTOP_CANCEL = 32;
  public static final int MENU_FLAG_SETTOP_JUSTSHOW = 48;
  public static final int MENU_FLAG_SUBSCRIBE = 1048576;
  public static final int MENU_FLAG_TMSGSETING = 256;
  public static final int MENU_FLAG_UNSUBSCRIBE = 2097152;
  public static final int STATUS_AUDIO_TALK = 1;
  public static final int STATUS_AVGAME = 10;
  public static final int STATUS_AV_OTHER_TER_CHATING = 5;
  public static final int STATUS_DEFAULT = 0;
  public static final int STATUS_DRAFT = 4;
  public static final int STATUS_LISTEN_TOGETHER = 6;
  public static final int STATUS_MULTITALK_JOUIN = 2;
  public static final int STATUS_MUTILTALK_NOTJOUIN = 3;
  public static final int STATUS_SHARE_LOCATION = 8;
  public static final int STATUS_SING_TOGETHER = 9;
  public static final int STATUS_STUDY_ROOM = 11;
  public static final int STATUS_WATCH_TOGETHER = 7;
  public static final int TROOP_PROCESSUNREADNUM = 999;
  public static final int UNREAD_MSG_FALG_NUM_VIP = 4;
  public static final int UNREAD_MSG_FLAG_NONE = 0;
  public static final int UNREAD_MSG_FLAG_NUM_BLUE = 3;
  public static final int UNREAD_MSG_FLAG_NUM_RED = 1;
  public static final int UNREAD_MSG_FLAG_RED_DOT = 2;
  public int mAuthenIconId;
  public String mBindId;
  public int mBindType;
  public String mCallingText;
  public String mContentDesc;
  public volatile long mDisplayTime;
  public CharSequence mExtraInfo;
  public int mExtraInfoColor;
  public int mExtraType;
  public boolean mIsGroupVideo = false;
  public boolean mIsGroupVideoNotify = false;
  public CharSequence mLastMsg;
  public int mMenuFlag = 0;
  public CharSequence mMsgExtroInfo;
  public int mOnlineStatus;
  public String mPhoneNumber;
  public int mPosition;
  public String mShowTime;
  public int mStatus;
  public String mTitleName;
  public CharSequence mTitleNameCs;
  public int mUnreadFlag = 1;
  public int mUnreadNum;
  protected MsgSummary msgSummary;
  
  public RecentBaseData()
  {
    this.mMenuFlag |= 0x1;
  }
  
  protected void buildMessageBody(Message paramMessage, int paramInt, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    long l = System.currentTimeMillis();
    MsgUtilsProxy.a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, false, false);
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append(getClass().getName());
      paramMessage.append(" get summary=");
      paramMessage.append(l - System.currentTimeMillis());
      QLog.d("Q.recent.cost", 2, paramMessage.toString());
    }
  }
  
  public final void clearUnReadNum()
  {
    this.mUnreadNum = 0;
  }
  
  public void dealDraft(BaseQQAppInterface paramBaseQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.bShowDraft = false;
    paramMsgSummary.mDraft = null;
    if (this.mDisplayTime > getLastDraftTime()) {
      return;
    }
    paramBaseQQAppInterface = (IMessageFacade)paramBaseQQAppInterface.getRuntimeService(IMessageFacade.class, "");
    if (paramBaseQQAppInterface != null)
    {
      if (!(paramBaseQQAppInterface.getQQMessageFacadeStub() instanceof QQMessageFacadeStub)) {
        return;
      }
      paramBaseQQAppInterface = ((QQMessageFacadeStub)paramBaseQQAppInterface.getQQMessageFacadeStub()).getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
      if (paramBaseQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramBaseQQAppInterface.getSummary())) {
          return;
        }
        this.mDisplayTime = paramBaseQQAppInterface.getTime();
        paramMsgSummary.bShowDraft = true;
        paramMsgSummary.mDraft = QQTextProxy.a(paramBaseQQAppInterface.getSummary(), 3, 16);
      }
    }
  }
  
  public void dealStatus(BaseQQAppInterface paramBaseQQAppInterface)
  {
    RecentBaseDataConfig.a().a(paramBaseQQAppInterface, this);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && ((paramObject instanceof RecentBaseData)))
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.getRecentUserType() == getRecentUserType()) && (TextUtils.equals(paramObject.getRecentUserUin(), getRecentUserUin()))) {
        return true;
      }
    }
    return bool;
  }
  
  protected void extraUpdate(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = getRecentUserUin();
    }
    if (paramMsgSummary != null)
    {
      this.mLastMsg = paramMsgSummary.a(paramContext);
      paramBaseQQAppInterface = this.mLastMsg;
      if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.length() > 168)) {
        try
        {
          this.mLastMsg = paramBaseQQAppInterface.subSequence(0, 168);
        }
        catch (Exception paramBaseQQAppInterface)
        {
          if (QLog.isDevelopLevel()) {
            paramBaseQQAppInterface.printStackTrace();
          }
        }
      }
    }
    if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
      this.mShowTime = TimeManager.a().a(getRecentUserUin(), this.mDisplayTime);
    }
  }
  
  public long getFaceExtraFlag()
  {
    return 5L;
  }
  
  public abstract long getLastDraftTime();
  
  public abstract long getLastMsgTime();
  
  public final MsgSummary getMsgSummaryTemp()
  {
    MsgSummary localMsgSummary = this.msgSummary;
    if (localMsgSummary == null) {
      this.msgSummary = new MsgSummary();
    } else {
      localMsgSummary.a();
    }
    return this.msgSummary;
  }
  
  public abstract int getRecentUserType();
  
  public abstract String getRecentUserUin();
  
  public final String getTitleName()
  {
    return this.mTitleName;
  }
  
  public final int getUnreadNum()
  {
    return this.mUnreadNum;
  }
  
  public boolean isUnreadMsgNumInTabNum()
  {
    return true;
  }
  
  public void makeContentDesc()
  {
    if (TalkBackProxy.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName);
      localStringBuilder.append(",");
      int i = this.mUnreadNum;
      if (i != 0) {
        if (i == 1)
        {
          localStringBuilder.append("有一条未读,");
        }
        else if (i == 2)
        {
          localStringBuilder.append("有两条未读,");
        }
        else if (i > 0)
        {
          localStringBuilder.append("有");
          localStringBuilder.append(this.mUnreadNum);
          localStringBuilder.append("条未读,");
        }
      }
      CharSequence localCharSequence = this.mMsgExtroInfo;
      if (localCharSequence != null)
      {
        localStringBuilder.append(localCharSequence);
        localStringBuilder.append(",");
      }
      this.mContentDesc = localStringBuilder.toString();
    }
  }
  
  public void printDataItem()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      boolean bool = TextUtils.isEmpty(this.mTitleName);
      Object localObject2 = "null";
      Object localObject1;
      if (!bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lenth=");
        ((StringBuilder)localObject1).append(this.mTitleName.length());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "null";
      }
      if (!TextUtils.isEmpty(this.mLastMsg))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lenth=");
        ((StringBuilder)localObject2).append(this.mLastMsg.length());
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder.append("[");
      localStringBuilder.append("type:");
      localStringBuilder.append(getRecentUserType());
      localStringBuilder.append(", uin:");
      localStringBuilder.append(getRecentUserUin());
      localStringBuilder.append(", unreadNum:");
      localStringBuilder.append(this.mUnreadNum);
      localStringBuilder.append(", titleName:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", mMenuFlag:");
      localStringBuilder.append(this.mMenuFlag);
      localStringBuilder.append(", status:");
      localStringBuilder.append(this.mStatus);
      localStringBuilder.append(", authenIcon:");
      localStringBuilder.append(this.mAuthenIconId);
      localStringBuilder.append(", showTime:");
      localStringBuilder.append(this.mShowTime);
      localStringBuilder.append(", lastmsg:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", extrainfo:");
      localStringBuilder.append(this.mExtraInfo);
      localStringBuilder.append(", lastmsgtime:");
      localStringBuilder.append(getLastMsgTime());
      localStringBuilder.append(", lastdrafttime:");
      localStringBuilder.append(getLastDraftTime());
      localStringBuilder.append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  protected void processUnReadNum(int paramInt1, int paramInt2)
  {
    if (this.mUnreadFlag == 3)
    {
      if (this.mUnreadNum <= 0) {
        return;
      }
      if (ABTestController.a().a("message_reminder_layer2_1505_20210618").f())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (this.mUnreadNum > paramInt2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append("+");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.mUnreadNum);
          ((StringBuilder)localObject).append(BaseApplication.getContext().getResources().getString(2131916809));
          localObject = ((StringBuilder)localObject).toString();
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        Object localObject = localStringBuilder.toString();
        this.mExtraInfoColor = paramInt1;
        this.mMsgExtroInfo = ((CharSequence)localObject);
      }
    }
  }
  
  public abstract void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */