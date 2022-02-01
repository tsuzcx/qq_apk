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
  
  private void a(Context paramContext, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -5021))
    {
      paramMessage = this.mLastMsg.toString();
      paramContext = paramContext.getString(2131895200);
      if (paramMessage.endsWith(paramContext)) {
        this.mLastMsg = paramMessage.subSequence(0, paramMessage.length() - paramContext.length() - 1);
      }
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (AnonymousChatHelper.c(paramMessage))) {
      this.mLastMsg = paramMsgSummary.a(paramContext, AnonymousChatHelper.d(paramMessage), -1);
    }
  }
  
  private void a(Message paramMessage)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    if ((paramMessage != null) && (android.text.TextUtils.isEmpty(paramMessage.nickName))) {
      paramMessage.nickName = paramMessage.senderuin;
    }
  }
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    if ((paramMsgSummary.nState == 0) && ((!android.text.TextUtils.isEmpty(paramMsgSummary.strContent)) || (!android.text.TextUtils.isEmpty(paramMsgSummary.suffix))))
    {
      localSpannableString = null;
      if (!android.text.TextUtils.isEmpty(paramMsgSummary.strContent))
      {
        String str = paramMsgSummary.strContent.toString();
        localObject = str;
        if (!android.text.TextUtils.isEmpty(paramMsgSummary.strPrefix))
        {
          localObject = str;
          if (android.text.TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0) {
            if (paramMsgSummary.strContent.length() > paramMsgSummary.strPrefix.length() + 2) {
              localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
            } else {
              localObject = "";
            }
          }
        }
      }
      else
      {
        localObject = paramMsgSummary.suffix.toString();
      }
      if (!android.text.TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).b();
      }
      paramMessage = ColorNickManager.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
    }
    try
    {
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label236:
      break label236;
    }
    Object localObject = new SpannableStringBuilder();
    if (localSpannableString != null) {
      ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
    }
    ((SpannableStringBuilder)localObject).append(paramMessage.toString());
    paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
  }
  
  private void a(MsgSummary paramMsgSummary)
  {
    if ((paramMsgSummary.bShowDraft) && (e().msg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemTroopMsgData.troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
      }
      this.mMsgExtroInfo = "";
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    int i = paramQQAppInterface.getTroopMask(this.mUser.uin);
    if ((i != 1) && (!this.isForceSetUnreadNumRed))
    {
      if ((i == 2) || (i == 3) || (i == 4)) {
        this.mUnreadFlag = 3;
      }
    }
    else {
      this.mUnreadFlag = 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    if (HiddenChatHelper.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface))
    {
      if (!HiddenChatUtil.a(paramQQAppInterface.getCurrentUin(), paramContext))
      {
        this.mUnreadFlag = 0;
        return;
      }
      this.mUnreadFlag = 3;
    }
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
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("RecentItemTroopMsgData->update,");
        paramTroopInfo.append(this.mUser.uin);
        paramTroopInfo.append(",");
        paramTroopInfo.append(this.mTroopCreditLevel);
        QLog.i("troop.credit.act", 2, paramTroopInfo.toString());
      }
    }
  }
  
  private void b(Context paramContext, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgtype == -2025) && (this.mUnreadNum > 0))
    {
      String str = paramContext.getString(2131890709);
      if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
      {
        if (paramMessage.bizType <= 0)
        {
          if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131916263)))) {
            this.mMsgExtroInfo = "";
          }
        }
        else if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131916263)))) {
          this.mLastMsg = "";
        }
        if ((!android.text.TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith(str)))
        {
          if (this.mExtraInfoColor == 0) {
            this.mExtraInfoColor = paramContext.getResources().getColor(2131168153);
          }
          if (android.text.TextUtils.isEmpty(this.mMsgExtroInfo))
          {
            paramContext = str;
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append(this.mMsgExtroInfo);
            paramContext.append(str);
            paramContext = paramContext.toString();
          }
          this.mMsgExtroInfo = paramContext;
          this.mLastMsg = this.mLastMsg.toString().replace(str, "");
        }
      }
    }
  }
  
  private void b(MsgSummary paramMsgSummary)
  {
    if (((e().msg instanceof TroopReceiptMsg)) && (this.mUnreadNum > 0))
    {
      paramMsgSummary.suffix = "";
      paramMsgSummary.strPrefix = "";
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.mTitleName);
      localStringBuilder1.append(",");
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder1.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder1.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder1.append("有");
          localStringBuilder1.append(this.mUnreadNum);
          localStringBuilder1.append("条未读,");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.mMsgExtroInfo);
        localStringBuilder2.append(",");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.mLastMsg.toString()));
      localStringBuilder1.append(",");
      localStringBuilder1.append(this.mShowTime);
      localStringBuilder1.append(TroopHonorUtils.a(paramQQAppInterface, this.mUser.uin, paramQQAppInterface.getCurrentAccountUin()));
      this.mContentDesc = localStringBuilder1.toString();
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (paramQQAppInterface.b(this.mUser.uin))
    {
      paramQQAppInterface = paramQQAppInterface.c(this.mUser.uin);
      if ((paramQQAppInterface != null) && (!android.text.TextUtils.isEmpty(paramQQAppInterface.memo)) && (!paramQQAppInterface.memoShowed))
      {
        this.mMsgExtroInfo = paramContext.getString(2131917246);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131168122);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    this.troopLuckyCharacter = TroopLuckyCharacterUtil.b(paramQQAppInterface, paramTroopInfo);
  }
  
  private void c()
  {
    if (this.mArgsBundle.getBoolean("IS_HOT_CHAT", false)) {
      return;
    }
    this.mTitleNameCs = new ColorNickText(this.mTitleName, 16).b();
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    try
    {
      l = Long.parseLong(getRecentUserUin());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label11:
      boolean bool;
      Object localObject;
      StringBuilder localStringBuilder;
      break label11;
    }
    l = 0L;
    this.mIsGroupVideo = paramQQAppInterface.getAVNotifyCenter().d(l);
    bool = this.mIsGroupVideoNotify;
    this.mIsGroupVideoNotify = paramQQAppInterface.getAVNotifyCenter().c(l);
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopUtils.a(paramQQAppInterface, (String)localObject));
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
  }
  
  private void h()
  {
    RecentUser localRecentUser = e();
    if ((localRecentUser != null) && (localRecentUser.msg == null)) {
      localRecentUser.reParse();
    }
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, TroopInfo paramTroopInfo, MsgSummary paramMsgSummary)
  {
    super.a(paramBaseQQAppInterface, paramContext, paramMessage, paramTroopInfo, paramMsgSummary);
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    } else {
      paramBaseQQAppInterface = null;
    }
    if (!(paramMessage instanceof Message)) {
      paramMessage = null;
    }
    a(paramMessage);
    a(paramBaseQQAppInterface, paramMessage);
    buildMessageBody(paramMessage, this.mUser.getType(), paramBaseQQAppInterface, paramContext, paramMsgSummary);
    a(paramBaseQQAppInterface);
    a(paramBaseQQAppInterface, paramContext);
    c();
    a(paramMessage, paramMsgSummary);
    b(paramMsgSummary);
    extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
    c(paramBaseQQAppInterface);
    a(paramMsgSummary);
    a(paramBaseQQAppInterface, paramContext, paramMsgSummary);
    b(paramContext, paramMessage);
    b(paramBaseQQAppInterface, paramContext);
    a(paramContext, paramMessage, paramMsgSummary);
    h();
    TimeManager.a().a(this.mUser.uin, this.mDisplayTime);
    a(paramTroopInfo);
    a(paramBaseQQAppInterface, paramTroopInfo);
    b(paramBaseQQAppInterface, paramTroopInfo);
    b(paramBaseQQAppInterface);
    a(paramContext, paramMessage);
    if (a()) {
      processUnReadNum(paramContext.getResources().getColor(2131168122), 999);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary.bShowDraft) {
      return;
    }
    int i = 0;
    if (this.mUser == null) {
      return;
    }
    paramMsgSummary = (TroopAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
    Object localObject = e().msg;
    boolean bool = false;
    int j = 2131168153;
    if (localObject != null)
    {
      paramQQAppInterface = new RecentItemTroopMsgData.DealMsgAttentionType(this, paramQQAppInterface, paramContext, 0, paramMsgSummary, localObject, false).d();
      if (paramQQAppInterface.a()) {
        return;
      }
      i = paramQQAppInterface.b();
      bool = paramQQAppInterface.c();
    }
    else
    {
      if (this.mIsGroupVideoNotify)
      {
        this.mMsgExtroInfo = paramContext.getString(2131895583);
        i = 2131168153;
      }
      else
      {
        this.mMsgExtroInfo = "";
        this.mContentDesc = "";
      }
      int k = paramMsgSummary.e(this.mUser.uin);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("dealMsgAttention, navigateMsgType:");
        paramQQAppInterface.append(k);
        paramQQAppInterface.append(", mUnreadNum:");
        paramQQAppInterface.append(this.mUnreadNum);
        QLog.d("RecentItemTroopMsgData", 2, paramQQAppInterface.toString());
      }
      if ((k == 17) && (this.mUnreadNum != 0))
      {
        paramQQAppInterface = paramMsgSummary.b(this.mUser.uin, 17);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
        {
          this.mMsgExtroInfo = paramContext.getString(2131897589);
          this.mContentDesc = this.mMsgExtroInfo.toString();
          i = j;
        }
      }
      else if ((k == 100) && (this.mUnreadNum != 0))
      {
        paramQQAppInterface = paramMsgSummary.b(this.mUser.uin, 100);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
        {
          this.mMsgExtroInfo = paramContext.getString(2131897522);
          this.mContentDesc = this.mMsgExtroInfo.toString();
          bool = true;
          i = j;
        }
      }
      else if ((k == 11) && (this.mUnreadNum != 0))
      {
        paramQQAppInterface = paramMsgSummary.b(this.mUser.uin, 11);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
        {
          this.mMsgExtroInfo = paramContext.getString(2131897507);
          this.mContentDesc = this.mMsgExtroInfo.toString();
          i = j;
        }
      }
    }
    if ((!this.mContainsKeyword) && (bool)) {
      ReportController.b(null, "dc00898", "", this.mUser.uin, "qq_vip", "0X800A906", 0, 1, 0, "", "", "", "");
    }
    this.mContainsKeyword = bool;
    if ((!android.text.TextUtils.isEmpty(this.mMsgExtroInfo)) && (i > 0)) {
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
    }
  }
  
  protected boolean a()
  {
    return f() < 11;
  }
  
  protected boolean b()
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