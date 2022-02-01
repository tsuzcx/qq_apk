package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.ParcelObject;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.TroopConstants.CreditInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TalkBack;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.MsgUtils;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy;
import com.tencent.qphone.base.util.QLog;

@ParcelAnnotation.ParcelObject
public abstract class RecentBaseData
{
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
  
  protected void buildMessageBody(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    RecentRoute.MsgUtils.buildMsgSummaryForMsg(paramContext, paramIMCoreAppRuntime, paramIMCoreMessageStub, paramInt, paramMsgSummary, false, false);
  }
  
  public final void clearUnReadNum()
  {
    this.mUnreadNum = 0;
  }
  
  public void dealDraft(IMCoreAppRuntime paramIMCoreAppRuntime, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.bShowDraft = false;
          paramMsgSummary.mDraft = null;
        } while (this.mDisplayTime > getLastDraftTime());
        paramIMCoreAppRuntime = paramIMCoreAppRuntime.getMessageFacade();
      } while (paramIMCoreAppRuntime == null);
      paramIMCoreAppRuntime = paramIMCoreAppRuntime.getDraftSummaryInfo(getRecentUserUin(), getRecentUserType());
    } while ((paramIMCoreAppRuntime == null) || (TextUtils.isEmpty(paramIMCoreAppRuntime.getSummary())));
    this.mDisplayTime = paramIMCoreAppRuntime.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = RecentRoute.QQTextProxy.generalQQText(paramIMCoreAppRuntime.getSummary(), 3, 16);
  }
  
  public void dealStatus(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    paramIMCoreAppRuntime.getRecentConfig().getRecentStatusIconDispatch().processor(paramIMCoreAppRuntime, this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.getRecentUserType() != getRecentUserType()) || (!TextUtils.equals(paramObject.getRecentUserUin(), getRecentUserUin()))) {
        break;
      }
      return true;
    }
    return bool;
  }
  
  protected void extraUpdate(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = getRecentUserUin();
    }
    if (paramMsgSummary != null)
    {
      this.mLastMsg = paramMsgSummary.parseMsg(paramContext);
      paramIMCoreAppRuntime = this.mLastMsg;
      if ((paramIMCoreAppRuntime == null) || (paramIMCoreAppRuntime.length() <= 168)) {}
    }
    try
    {
      this.mLastMsg = paramIMCoreAppRuntime.subSequence(0, 168);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = TimeManager.getInstance().getMsgDisplayTime(getRecentUserUin(), this.mDisplayTime);
      }
      return;
    }
    catch (Exception paramIMCoreAppRuntime)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramIMCoreAppRuntime.printStackTrace();
        }
      }
    }
  }
  
  public long getFaceExtraFlag()
  {
    return IMCoreConstantsRoute.TroopConstants.CreditInfo.LEVEL_NORMAL;
  }
  
  public abstract long getLastDraftTime();
  
  public abstract long getLastMsgTime();
  
  public final MsgSummary getMsgSummaryTemp()
  {
    if (this.msgSummary == null) {
      this.msgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.msgSummary;
      this.msgSummary.reset();
    }
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
    StringBuilder localStringBuilder;
    if (IMCoreProxyRoute.TalkBack.getTalkBackStatus())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label67;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo).append(",");
      }
      this.mContentDesc = localStringBuilder.toString();
      return;
      label67:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读,");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读,");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
  
  public void printDataItem()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      String str2 = "null";
      String str1 = "null";
      if (!TextUtils.isEmpty(this.mTitleName)) {
        str1 = "lenth=" + this.mTitleName.length();
      }
      if (!TextUtils.isEmpty(this.mLastMsg)) {
        str2 = "lenth=" + this.mLastMsg.length();
      }
      localStringBuilder.append("[").append("type:").append(getRecentUserType()).append(", uin:").append(getRecentUserUin()).append(", unreadNum:").append(this.mUnreadNum).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.mMenuFlag).append(", status:").append(this.mStatus).append(", authenIcon:").append(this.mAuthenIconId).append(", showTime:").append(this.mShowTime).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.mExtraInfo).append(", lastmsgtime:").append(getLastMsgTime()).append(", lastdrafttime:").append(getLastDraftTime()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public abstract void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */