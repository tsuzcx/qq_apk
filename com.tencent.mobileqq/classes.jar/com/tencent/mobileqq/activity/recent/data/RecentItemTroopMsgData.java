package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentItemTroopMsgData
  extends RecentItemTroopMsgBaseData
{
  private static final String TAG = "RecentItemTroopMsgData";
  public boolean isForceSetUnreadNumRed = false;
  public boolean mContainsKeyword;
  public long mTroopCreditLevel = 5L;
  public byte troopHonorRich;
  public String troopHonorStr;
  public String troopLuckyCharacter = "";
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    this.mTitleNameCs = new ColorNickText(this.mTitleName, 16).a();
  }
  
  private void a(Context paramContext, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -5021))
    {
      paramMessage = this.mLastMsg.toString();
      paramContext = paramContext.getString(2131697408);
      if (paramMessage.endsWith(paramContext)) {
        this.mLastMsg = paramMessage.subSequence(0, paramMessage.length() - paramContext.length() - 1);
      }
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (AnonymousChatHelper.a(paramMessage))) {
      this.mLastMsg = paramMsgSummary.a(paramContext, AnonymousChatHelper.a(paramMessage), -1);
    }
  }
  
  private void a(Message paramMessage)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {}
    while ((paramMessage == null) || (!android.text.TextUtils.isEmpty(paramMessage.nickName))) {
      return;
    }
    paramMessage.nickName = paramMessage.senderuin;
  }
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary)
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
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = ColorNickManager.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      try
      {
        paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        label217:
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        if (localSpannableString == null) {
          break;
        }
        localSpannableStringBuilder.append(localSpannableString).append(": ");
        localSpannableStringBuilder.append(paramMessage.toString());
        paramMsgSummary.strContent = new QQText(localSpannableStringBuilder, 3, 16);
      }
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
    while (!HiddenChatHelper.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface)) {
      return;
    }
    if (!HiddenChatUtil.a(paramQQAppInterface.getCurrentUin(), paramContext))
    {
      this.mUnreadFlag = 0;
      return;
    }
    this.mUnreadFlag = 3;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramQQAppInterface = QCallFacade.a(paramQQAppInterface, paramMessage.frienduin, paramMessage.istroop, this.mUnreadNum, paramMessage);
      this.mUnreadNum += paramQQAppInterface.a();
      if (paramQQAppInterface.a() > 0) {
        this.mMsgExtroInfo = "";
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
    if ((paramTroopInfo != null) && (paramQQAppInterface.isSupportTroopHonor(this.mUser.uin)))
    {
      this.troopHonorStr = paramTroopInfo.myHonorList;
      this.troopHonorRich = paramTroopInfo.myHonorRichFlag;
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
  
  private void b(Context paramContext, Message paramMessage)
  {
    String str;
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0))
    {
      str = paramContext.getString(2131693215);
      if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
      {
        if (paramMessage.bizType > 0) {
          break label179;
        }
        if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131719041)))) {
          this.mMsgExtroInfo = "";
        }
        if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
        {
          if (this.mExtraInfoColor == 0) {
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
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
      if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) || (!this.mMsgExtroInfo.equals(paramContext.getString(2131719041)))) {
        break;
      }
      this.mLastMsg = "";
      break;
    }
  }
  
  private void b(MsgSummary paramMsgSummary)
  {
    if (((a().msg instanceof TroopReceiptMsg)) && (this.mUnreadNum > 0))
    {
      paramMsgSummary.suffix = "";
      paramMsgSummary.strPrefix = "";
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (AppSetting.d)
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
      localStringBuilder.append(TroopHonorUtils.a(paramQQAppInterface, this.mUser.uin, paramQQAppInterface.getCurrentAccountUin()));
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
        this.mMsgExtroInfo = paramContext.getString(2131719913);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167117);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    this.troopLuckyCharacter = TroopLuckyCharacterUtil.a(paramQQAppInterface, paramTroopInfo);
  }
  
  private void c()
  {
    RecentUser localRecentUser = a();
    if ((localRecentUser != null) && (localRecentUser.msg == null)) {
      localRecentUser.reParse();
    }
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
        localObject = (TroopVideoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
        if ((localObject != null) && (((TroopVideoManager)localObject).a(getRecentUserUin()) == 2)) {
          this.mIsGroupVideoNotify = false;
        }
      }
      if ((this.mIsGroupVideoNotify) && (!bool))
      {
        localObject = String.valueOf(l);
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + TroopUtils.a(paramQQAppInterface, (String)localObject), "", "");
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
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, TroopInfo paramTroopInfo, MsgSummary paramMsgSummary)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramIMCoreMessageStub, paramTroopInfo, paramMsgSummary);
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {}
    for (paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;; paramBaseQQAppInterface = null)
    {
      if ((paramIMCoreMessageStub instanceof Message)) {}
      for (paramIMCoreMessageStub = (Message)paramIMCoreMessageStub;; paramIMCoreMessageStub = null)
      {
        a(paramIMCoreMessageStub);
        a(paramBaseQQAppInterface, paramIMCoreMessageStub);
        buildMessageBody(paramIMCoreMessageStub, this.mUser.getType(), paramBaseQQAppInterface, paramContext, paramMsgSummary);
        a(paramBaseQQAppInterface);
        a(paramBaseQQAppInterface, paramContext);
        a();
        a(paramIMCoreMessageStub, paramMsgSummary);
        b(paramMsgSummary);
        extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
        c(paramBaseQQAppInterface);
        a(paramMsgSummary);
        a(paramBaseQQAppInterface, paramContext, paramMsgSummary);
        b(paramContext, paramIMCoreMessageStub);
        b(paramBaseQQAppInterface, paramContext);
        a(paramContext, paramIMCoreMessageStub, paramMsgSummary);
        c();
        TimeManager.a().a(this.mUser.uin, this.mDisplayTime);
        a(paramTroopInfo);
        a(paramBaseQQAppInterface, paramTroopInfo);
        b(paramBaseQQAppInterface, paramTroopInfo);
        b(paramBaseQQAppInterface);
        a(paramContext, paramIMCoreMessageStub);
        return;
      }
    }
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
      paramMsgSummary = (TroopAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      Object localObject = a().msg;
      bool2 = false;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = new RecentItemTroopMsgData.DealMsgAttentionType(this, paramQQAppInterface, paramContext, 0, paramMsgSummary, localObject, false).a();
    } while (paramQQAppInterface.a());
    int i = paramQQAppInterface.a();
    boolean bool1 = paramQQAppInterface.b();
    for (;;)
    {
      if ((!this.mContainsKeyword) && (bool1)) {
        ReportController.b(null, "dc00898", "", this.mUser.uin, "qq_vip", "0X800A906", 0, 1, 0, "", "", "", "");
      }
      this.mContainsKeyword = bool1;
      if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) || (i <= 0)) {
        break;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
      return;
      if (this.mIsGroupVideoNotify)
      {
        i = 2131167145;
        this.mMsgExtroInfo = paramContext.getString(2131697804);
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
            this.mMsgExtroInfo = paramContext.getString(2131699453);
            j = 2131167145;
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
            this.mMsgExtroInfo = paramContext.getString(2131699386);
            j = 2131167145;
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
                this.mMsgExtroInfo = paramContext.getString(2131699371);
                j = 2131167145;
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
  
  protected boolean a()
  {
    return this.mUser.getType() == 1;
  }
  
  public long getFaceExtraFlag()
  {
    return this.mTroopCreditLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */