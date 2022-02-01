package com.tencent.mobileqq.activity.recent.data;

import agij;
import aljj;
import allj;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import aomh;
import bapk;
import bapn;
import bdla;
import begq;
import bfwu;
import bfwx;
import bfyd;
import bfzk;
import bgmk;
import bhmb;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfoStub;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nty;

public class RecentItemTroopMsgData
  extends RecentItemTroopMsgBaseData
{
  private static final String TAG = "RecentItemTroopMsgData";
  public boolean isForceSetUnreadNumRed;
  public boolean mContainsKeyword;
  public long mTroopCreditLevel = 5L;
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  public String troopHonorStr;
  public String troopLuckyCharacter = "";
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  private void a()
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    this.mTitleNameCs = new begq(this.mTitleName, 16).a();
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -5021))
    {
      paramMessage = this.mLastMsg.toString();
      paramContext = paramContext.getString(2131697154);
      if (paramMessage.endsWith(paramContext)) {
        this.mLastMsg = paramMessage.subSequence(0, paramMessage.length() - paramContext.length() - 1);
      }
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (nty.a(paramMessage))) {
      this.mLastMsg = paramMsgSummary.parseMsgWithExtraInfo(paramContext, paramContext.getResources().getString(2131696965), -1);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {}
    while ((paramMessage == null) || (!android.text.TextUtils.isEmpty(paramMessage.nickName))) {
      return;
    }
    paramMessage.nickName = paramMessage.senderuin;
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    Object localObject;
    if ((paramMsgSummary.nState == 0) && ((!android.text.TextUtils.isEmpty(paramMsgSummary.strContent)) || (!android.text.TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      localSpannableString = null;
      if (android.text.TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label223;
      }
      String str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!android.text.TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (android.text.TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {
            break label217;
          }
          localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
        }
      }
    }
    for (;;)
    {
      if (!android.text.TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new begq(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = bhmb.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
      return;
      label217:
      localObject = "";
      continue;
      label223:
      localObject = paramMsgSummary.suffix.toString();
    }
  }
  
  private void a(MsgSummary paramMsgSummary)
  {
    if ((paramMsgSummary.bShowDraft) && (a().msg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTroopMsgData.troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
      }
      this.mMsgExtroInfo = "";
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {}
    int i;
    do
    {
      return;
      i = paramQQAppInterface.getTroopMask(this.mUser.uin);
      if ((i == 1) || (this.isForceSetUnreadNumRed))
      {
        this.mUnreadFlag = 1;
        return;
      }
    } while ((i != 2) && (i != 3) && (i != 4));
    this.mUnreadFlag = 3;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {}
    while (!agij.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface)) {
      return;
    }
    if (!aomh.a(paramQQAppInterface.getCurrentUin(), paramContext))
    {
      this.mUnreadFlag = 0;
      return;
    }
    this.mUnreadFlag = 3;
  }
  
  private void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramQQAppInterface = bapk.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0) {
        this.mMsgExtroInfo = "";
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = (bfwu)paramQQAppInterface.getManager(QQManagerFactory.TROOP_HONOR_MANAGER);
    if ((paramTroopInfo != null) && (paramQQAppInterface.b(this.mUser.uin)))
    {
      this.troopHonorStr = paramTroopInfo.myHonorList;
      return;
    }
    this.troopHonorStr = null;
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.mTroopCreditLevel = paramTroopInfo.troopCreditLevel;
      if (this.mTroopCreditLevel == 0L) {
        this.mTroopCreditLevel = 5L;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "RecentItemTroopMsgData->update," + this.mUser.uin + "," + this.mTroopCreditLevel);
      }
    }
  }
  
  private void b()
  {
    RecentUser localRecentUser = a();
    if ((localRecentUser != null) && (localRecentUser.msg == null)) {
      localRecentUser.reParse();
    }
  }
  
  private void b(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    String str;
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0))
    {
      str = paramContext.getString(2131693069);
      if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
      {
        if (paramMessage.bizType > 0) {
          break label179;
        }
        if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131718518)))) {
          this.mMsgExtroInfo = "";
        }
        if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
        {
          if (this.mExtraInfoColor == 0) {
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
          }
          if (!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) {
            break label215;
          }
        }
      }
    }
    label179:
    label215:
    for (paramContext = str;; paramContext = this.mMsgExtroInfo + str)
    {
      this.mMsgExtroInfo = paramContext;
      this.mLastMsg = this.mLastMsg.toString().replace(str, "");
      return;
      if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) || (!this.mMsgExtroInfo.equals(paramContext.getString(2131718518)))) {
        break;
      }
      this.mLastMsg = "";
      break;
    }
  }
  
  private void b(MsgSummary paramMsgSummary)
  {
    if (((a().msg instanceof allj)) && (this.mUnreadNum > 0))
    {
      paramMsgSummary.suffix = "";
      paramMsgSummary.strPrefix = "";
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label130;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString())).append(",").append(this.mShowTime);
      localStringBuilder.append(bfwx.a(paramQQAppInterface, this.mUser.uin, paramQQAppInterface.getCurrentAccountUin()));
      this.mContentDesc = localStringBuilder.toString();
      return;
      label130:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (paramQQAppInterface.b(this.mUser.uin))
    {
      paramQQAppInterface = paramQQAppInterface.a(this.mUser.uin);
      if ((paramQQAppInterface != null) && (!android.text.TextUtils.isEmpty(paramQQAppInterface.memo)) && (!paramQQAppInterface.memoShowed))
      {
        this.mMsgExtroInfo = paramContext.getString(2131719354);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167110);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    this.troopLuckyCharacter = bfyd.a(paramQQAppInterface, paramTroopInfo);
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    try
    {
      l = Long.parseLong(getRecentUserUin());
      this.mIsGroupVideo = paramQQAppInterface.getAVNotifyCenter().c(l);
      boolean bool = this.mIsGroupVideoNotify;
      this.mIsGroupVideoNotify = paramQQAppInterface.getAVNotifyCenter().b(l);
      Object localObject;
      if (this.mIsGroupVideoNotify)
      {
        localObject = (bgmk)paramQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if ((localObject != null) && (((bgmk)localObject).a(getRecentUserUin()) == 2)) {
          this.mIsGroupVideoNotify = false;
        }
      }
      if ((this.mIsGroupVideoNotify) && (!bool))
      {
        localObject = String.valueOf(l);
        bdla.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + TroopUtils.getTroopIdentity(paramQQAppInterface, (String)localObject), "", "");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary.bShowDraft) {}
    boolean bool2;
    do
    {
      do
      {
        return;
        i = 0;
      } while (this.mUser == null);
      paramMsgSummary = (bfzk)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      Object localObject = a().msg;
      bool2 = false;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = new aljj(this, paramQQAppInterface, paramContext, 0, paramMsgSummary, localObject, false).a();
    } while (paramQQAppInterface.a());
    int i = paramQQAppInterface.a();
    boolean bool1 = paramQQAppInterface.b();
    for (;;)
    {
      if ((!this.mContainsKeyword) && (bool1)) {
        bdla.b(null, "dc00898", "", this.mUser.uin, "qq_vip", "0X800A906", 0, 1, 0, "", "", "", "");
      }
      this.mContainsKeyword = bool1;
      if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) || (i <= 0)) {
        break;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
      return;
      if (this.mIsGroupVideoNotify)
      {
        i = 2131167138;
        this.mMsgExtroInfo = paramContext.getString(2131697550);
      }
      int k;
      int j;
      for (;;)
      {
        k = paramMsgSummary.a(this.mUser.uin);
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, navigateMsgType:" + k + ", mUnreadNum:" + this.mUnreadNum);
        }
        if ((k != 17) || (this.mUnreadNum == 0)) {
          break label349;
        }
        paramQQAppInterface = paramMsgSummary.a(this.mUser.uin, 17);
        j = i;
        if (paramQQAppInterface != null)
        {
          j = i;
          if (paramQQAppInterface.size() != 0)
          {
            this.mMsgExtroInfo = paramContext.getString(2131699084);
            j = 2131167138;
            this.mContentDesc = this.mMsgExtroInfo.toString();
          }
        }
        bool1 = false;
        i = j;
        break;
        this.mMsgExtroInfo = "";
        this.mContentDesc = "";
      }
      label349:
      if ((k == 100) && (this.mUnreadNum != 0))
      {
        paramQQAppInterface = paramMsgSummary.a(this.mUser.uin, 100);
        j = i;
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          j = i;
          bool1 = bool2;
          if (paramQQAppInterface.size() != 0)
          {
            this.mMsgExtroInfo = paramContext.getString(2131699039);
            j = 2131167138;
            this.mContentDesc = this.mMsgExtroInfo.toString();
            bool1 = true;
          }
        }
        i = j;
      }
      else
      {
        j = i;
        if (k == 11)
        {
          j = i;
          if (this.mUnreadNum != 0)
          {
            paramQQAppInterface = paramMsgSummary.a(this.mUser.uin, 11);
            j = i;
            if (paramQQAppInterface != null)
            {
              j = i;
              if (paramQQAppInterface.size() != 0)
              {
                this.mMsgExtroInfo = paramContext.getString(2131699025);
                j = 2131167138;
                this.mContentDesc = this.mMsgExtroInfo.toString();
              }
            }
          }
        }
        bool1 = false;
        i = j;
      }
    }
  }
  
  public long getFaceExtraFlag()
  {
    return this.mTroopCreditLevel;
  }
  
  protected boolean isEnableUnreadState()
  {
    return this.mUser.getType() == 1;
  }
  
  protected void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, TroopInfoStub paramTroopInfoStub, MsgSummary paramMsgSummary)
  {
    super.update(paramIMCoreAppRuntime, paramContext, paramIMCoreMessageStub, paramTroopInfoStub, paramMsgSummary);
    if ((paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    for (paramIMCoreAppRuntime = (QQAppInterface)paramIMCoreAppRuntime;; paramIMCoreAppRuntime = null)
    {
      if ((paramIMCoreMessageStub instanceof QQMessageFacade.Message)) {}
      for (paramIMCoreMessageStub = (QQMessageFacade.Message)paramIMCoreMessageStub;; paramIMCoreMessageStub = null)
      {
        if ((paramTroopInfoStub instanceof TroopInfo)) {}
        for (paramTroopInfoStub = (TroopInfo)paramTroopInfoStub;; paramTroopInfoStub = null)
        {
          a(paramIMCoreMessageStub);
          a(paramIMCoreAppRuntime, paramIMCoreMessageStub);
          buildMessageBody(paramIMCoreMessageStub, this.mUser.getType(), paramIMCoreAppRuntime, paramContext, paramMsgSummary);
          a(paramIMCoreAppRuntime);
          a(paramIMCoreAppRuntime, paramContext);
          a();
          a(paramIMCoreMessageStub, paramMsgSummary);
          b(paramMsgSummary);
          extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
          c(paramIMCoreAppRuntime);
          a(paramMsgSummary);
          a(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
          b(paramContext, paramIMCoreMessageStub);
          b(paramIMCoreAppRuntime, paramContext);
          a(paramContext, paramIMCoreMessageStub, paramMsgSummary);
          b();
          TimeManager.getInstance().getMsgDisplayTime(this.mUser.uin, this.mDisplayTime);
          a(paramTroopInfoStub);
          a(paramIMCoreAppRuntime, paramTroopInfoStub);
          b(paramIMCoreAppRuntime, paramTroopInfoStub);
          b(paramIMCoreAppRuntime);
          a(paramContext, paramIMCoreMessageStub);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */