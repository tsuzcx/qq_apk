package com.tencent.mobileqq.activity.recent;

import ahpl;
import ahqv;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aryx;
import ayki;
import ayna;
import bbbd;
import bbcl;
import bbct;
import bbet;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;
import lnr;
import muf;

@ahqv
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
  public static final int STATUS_AV_OTHER_TER_CHATING = 5;
  public static final int STATUS_DEFAULT = 0;
  public static final int STATUS_DRAFT = 4;
  public static final int STATUS_LISTEN_TOGETHER = 6;
  public static final int STATUS_MULTITALK_JOUIN = 2;
  public static final int STATUS_MUTILTALK_NOTJOUIN = 3;
  public static final int STATUS_SHARE_LOCATION = 8;
  public static final int STATUS_SING_TOGETHER = 9;
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
  public boolean mIsGroupVideo;
  public boolean mIsGroupVideoNotify;
  public CharSequence mLastMsg;
  public int mMenuFlag = 0;
  public CharSequence mMsgExtroInfo;
  public int mOnlineStatus;
  public String mPhoneNumber;
  public int mPosition;
  public String mShowTime;
  public int mStatus;
  public String mTitleName;
  public CharSequence mTitleName_cs;
  public int mUnreadFlag = 1;
  public int mUnreadNum;
  protected MsgSummary msgSummary;
  
  public RecentBaseData()
  {
    this.mMenuFlag |= 0x1;
  }
  
  private void a(QQMessageFacade.Message paramMessage, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessage != null) && (1 == paramInt))
    {
      paramQQAppInterface = bbcl.g(paramQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      if ((paramQQAppInterface != null) && (!TextUtils.equals(paramQQAppInterface, paramMessage.nickName)))
      {
        paramMessage.nickName = paramQQAppInterface;
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "processTroopNickName  nickname : " + paramQQAppInterface);
        }
      }
    }
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public final MsgSummary a()
  {
    if (this.msgSummary == null) {
      this.msgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.msgSummary;
      this.msgSummary.a();
    }
  }
  
  public abstract String a();
  
  public void a()
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
      localStringBuilder.append("[").append("type:").append(a()).append(", uin:").append(a()).append(", unreadNum:").append(this.mUnreadNum).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.mMenuFlag).append(", status:").append(this.mStatus).append(", authenIcon:").append(this.mAuthenIconId).append(", showTime:").append(this.mShowTime).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.mExtraInfo).append(", lastmsgtime:").append(a()).append(", lastdrafttime:").append(b()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    int k = a();
    long l;
    int m;
    label137:
    label185:
    Object localObject3;
    label255:
    Object localObject2;
    if ((k == 3000) || (k == 1)) {
      try
      {
        l = Long.parseLong(a());
        m = muf.b(k);
        if (paramQQAppInterface.a().a(m, l) > 0L) {
          if (paramQQAppInterface.a().a(m, l))
          {
            this.mStatus = 2;
            if ((k == 0) && (paramQQAppInterface.a().d(a()))) {
              this.mStatus = 5;
            }
            Object localObject1;
            if (this.mStatus == 0)
            {
              localObject1 = paramQQAppInterface.a();
              if ((localObject1 == null) || (!((QQMessageFacade)localObject1).e(a(), k))) {
                break label526;
              }
              this.mStatus = 4;
            }
            if ((this.mStatus == 0) || (this.mStatus == 8))
            {
              localObject1 = a();
              this.mStatus = 0;
              if (k != 1) {
                break label534;
              }
              if (aryx.b(paramQQAppInterface, (String)localObject1)) {
                this.mStatus = 8;
              }
            }
            if ((this.mStatus == 0) || (this.mStatus == 6))
            {
              localObject1 = a();
              this.mStatus = 0;
              localObject3 = (ListenTogetherManager)paramQQAppInterface.getManager(331);
              if (((k != 3000) && (k != 1)) || (!((ListenTogetherManager)localObject3).a(1, (String)localObject1))) {
                break label557;
              }
              this.mStatus = 6;
            }
            if ((this.mStatus != 4) && ((k == 1) || (k == 0)))
            {
              localObject1 = a();
              if (k != 1) {
                break label582;
              }
              i = 1;
              label288:
              i = ((ayna)paramQQAppInterface.getManager(339)).a(i, (String)localObject1);
              if (((this.mStatus == 0) || (this.mStatus >= i)) && (i != 0)) {
                this.mStatus = i;
              }
            }
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          l = 0L;
          continue;
          this.mStatus = 3;
        }
        localObject2 = paramQQAppInterface.a().a(l, 2);
        if (localObject2 == null) {}
      }
    }
    for (int i = ((lnr)localObject2).a + 0;; i = 0)
    {
      localObject2 = paramQQAppInterface.a().a(l, 10);
      int j = i;
      if (localObject2 != null) {
        j = i + ((lnr)localObject2).a;
      }
      if (j <= 0) {
        break;
      }
      if (paramQQAppInterface.a().a(m, l))
      {
        this.mStatus = 2;
        break;
      }
      this.mStatus = 3;
      break;
      if ((!paramQQAppInterface.c()) || ((paramQQAppInterface.a().e() != 1) && (paramQQAppInterface.a().e() != 2))) {
        break;
      }
      i = paramQQAppInterface.a().f();
      localObject2 = paramQQAppInterface.a().c();
      localObject3 = paramQQAppInterface.a().d();
      if ((k != i) || ((!a().equals(localObject2)) && (!a().equals(localObject3)))) {
        break;
      }
      this.mStatus = 1;
      break;
      label526:
      this.mStatus = 0;
      break label137;
      label534:
      if ((k != 0) || (!aryx.a(paramQQAppInterface, (String)localObject2))) {
        break label185;
      }
      this.mStatus = 8;
      break label185;
      label557:
      if ((k != 0) || (!((ListenTogetherManager)localObject3).a(2, (String)localObject2))) {
        break label255;
      }
      this.mStatus = 6;
      break label255;
      label582:
      i = 2;
      break label288;
    }
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.mTitleName)) {
      this.mTitleName = a();
    }
    if (paramMsgSummary != null)
    {
      this.mLastMsg = paramMsgSummary.a(paramContext);
      if (((this.mLastMsg instanceof SpannableStringBuilder)) && (bbct.b())) {
        this.mLastMsg = ((SpannableStringBuilder)this.mLastMsg).append(" ");
      }
      paramQQAppInterface = this.mLastMsg;
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 168)) {}
    }
    try
    {
      this.mLastMsg = paramQQAppInterface.subSequence(0, 168);
      if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
        this.mShowTime = ahpl.a().a(a(), this.mDisplayTime);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
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
        } while (this.mDisplayTime > b());
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mDisplayTime = paramQQAppInterface.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new ayki(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    a(paramMessage, paramQQAppInterface, paramInt);
    if (paramMessage != null) {}
    for (String str = paramMessage.nickName;; str = null)
    {
      bbet.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, str, false, false);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    return this.mUnreadNum;
  }
  
  public abstract long b();
  
  public final String b()
  {
    return this.mTitleName;
  }
  
  public final void b()
  {
    this.mUnreadNum = 0;
  }
  
  public long c()
  {
    return 5L;
  }
  
  public final void c()
  {
    this.mUnreadNum = 0;
  }
  
  public void d()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.d)
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
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.a() != a()) || (!bbbd.a(paramObject.a(), a()))) {
        break;
      }
      return true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */