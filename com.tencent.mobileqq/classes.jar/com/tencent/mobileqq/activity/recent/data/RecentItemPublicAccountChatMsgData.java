package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips.PubAccountTipsMsg;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.vas.nicknamemessage.NickNameManager;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RecentItemPublicAccountChatMsgData
  extends RecentItemChatMsgData
{
  private boolean isNewKandian;
  public String mReportKeyBytesOacMsgxtend = "";
  
  public RecentItemPublicAccountChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.isNewKandian = TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN);
    if (this.isNewKandian) {
      this.mUnreadFlag = 2;
    }
  }
  
  public static PublicAccountInfo a(QQAppInterface paramQQAppInterface, PublicAccountDataManager paramPublicAccountDataManager, String paramString)
  {
    PublicAccountInfo localPublicAccountInfo = null;
    if ((paramPublicAccountDataManager == null) || (RecentParcelUtil.a(paramQQAppInterface))) {
      try
      {
        localPublicAccountInfo = paramPublicAccountDataManager.a(paramString, true);
        return localPublicAccountInfo;
      }
      catch (Throwable paramQQAppInterface)
      {
        return paramPublicAccountDataManager.b(paramString);
      }
    }
    return paramPublicAccountDataManager.b(paramString);
  }
  
  private void a(Context paramContext, Message paramMessage)
  {
    Object localObject = null;
    if ((paramMessage.lastMsg instanceof MessageForStructing))
    {
      paramMessage = (MessageForStructing)paramMessage.lastMsg;
      localObject = paramMessage;
      if (!paramMessage.mIsParsed)
      {
        paramMessage.parse();
        localObject = paramMessage;
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((MessageForStructing)localObject).structingMsg != null))
      {
        this.msgSummary.strContent = ((MessageForStructing)localObject).structingMsg.mMsgBrief;
        this.msgSummary.suffix = "";
        if ((!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mOrangeWord)) && (this.mUnreadNum > 0))
        {
          this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject).structingMsg.mOrangeWord + "]");
          a(((MessageForStructing)localObject).structingMsg, paramContext);
          this.mExtraInfoColor = -881592;
        }
      }
      return;
      if (paramMessage.msgtype == -2011)
      {
        localObject = new MessageForStructing();
        ((MessageForStructing)localObject).msgData = paramMessage.msgData;
        ((MessageForStructing)localObject).parse();
        paramMessage.lastMsg = ((MessageRecord)localObject);
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = paramMessage.getExtInfoFromExtStr("qzone_msg_box_promot");
    if (!TextUtils.isEmpty(paramMessage)) {
      this.msgSummary.strContent = paramMessage;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ("3046055438".equals(this.mUser.uin)) {
      EcshopUtils.a(paramQQAppInterface, this.msgSummary);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (this.mUnreadNum > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = NickNameManager.a(paramQQAppInterface, paramMessage, bool);
      if (localObject != null) {
        this.msgSummary.strContent = ((CharSequence)localObject);
      }
      localObject = PubAccountTips.a(paramQQAppInterface, this.mUser.uin);
      if ((localObject != null) && (((PubAccountTips.PubAccountTipsMsg)localObject).d == paramMessage.uniseq) && (((PubAccountTips.PubAccountTipsMsg)localObject).b())) {
        ThreadManager.post(new RecentItemPublicAccountChatMsgData.1(this, paramQQAppInterface, (PubAccountTips.PubAccountTipsMsg)localObject), 2, null, false);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage, PublicAccountInfo paramPublicAccountInfo, PublicAccountDataManager paramPublicAccountDataManager)
  {
    if ((paramPublicAccountInfo == null) && (paramPublicAccountDataManager != null))
    {
      paramPublicAccountDataManager = paramPublicAccountDataManager.a(this.mUser.uin);
      if (paramPublicAccountDataManager != null) {
        this.mTitleName = paramPublicAccountDataManager.name;
      }
      if (this.isNewKandian) {
        this.mTitleName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(paramQQAppInterface, paramQQAppInterface.getApp());
      }
    }
    if (paramPublicAccountInfo != null) {
      this.mTitleName = paramPublicAccountInfo.name;
    }
    for (this.mAuthenIconId = 0;; this.mAuthenIconId = 0)
    {
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin)) {
        this.mTitleName = KandianDailyManager.a(paramMessage);
      }
      return;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, Context paramContext)
  {
    if ((!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713133))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713138))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713130))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713141))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713144))))
    {
      if (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(String.format(paramContext.getString(2131696421), new Object[] { Integer.valueOf(this.mUnreadNum) }))) {}
    }
    else {
      this.mMsgExtroInfo = "";
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage, QQMessageFacade paramQQMessageFacade, int paramInt)
  {
    if ((paramInt != -3006) && (paramInt != -5004))
    {
      buildMessageBody(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
      if ((paramInt == -2025) && (this.mUnreadNum > 0) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.mUser.uin)))
      {
        this.mExtraInfoColor = -881592;
        this.mMsgExtroInfo = paramMessage.msg;
        this.msgSummary.strContent = "";
      }
    }
    for (;;)
    {
      return false;
      this.mMsgExtroInfo = "";
      this.mExtraInfoColor = 0;
      if (this.isNewKandian)
      {
        if (a(paramQQAppInterface, paramContext, paramQQMessageFacade)) {
          return true;
        }
      }
      else if ((AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin)) || (AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin)))
      {
        a(paramContext, paramMessage);
      }
      else if (("2290230341".equals(this.mUser.uin)) && (QZoneHelper.enableQZoneContextBox(paramQQAppInterface)))
      {
        a(paramMessage);
      }
      else
      {
        a(paramQQAppInterface, paramMessage);
        continue;
        this.msgSummary.strContent = "";
        paramQQMessageFacade = XMLMessageUtils.a(paramMessage);
        if ((paramQQMessageFacade != null) && (paramQQMessageFacade.items != null) && (paramQQMessageFacade.items.size() != 0)) {
          break;
        }
        buildMessageBody(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
      }
    }
    paramQQAppInterface = ((PAMessage.Item)paramQQMessageFacade.items.get(0)).title;
    if ((((PAMessage.Item)paramQQMessageFacade.items.get(0)).cover == null) && (((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList != null)) {
      paramQQAppInterface = paramQQAppInterface + "：" + (String)((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList.get(0);
    }
    for (;;)
    {
      this.msgSummary.strContent = paramQQAppInterface;
      break;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade)
  {
    paramQQAppInterface = paramQQMessageFacade.b(this.mUser.uin, this.mUser.getType());
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForStructing)))
    {
      paramQQAppInterface = (MessageForStructing)paramQQAppInterface;
      if (paramQQAppInterface.structingMsg == null) {
        paramQQAppInterface.parse();
      }
      if ((this.mUnreadNum > 0) && (paramQQAppInterface.structingMsg != null) && (!TextUtils.isEmpty(paramQQAppInterface.structingMsg.mOrangeWord))) {
        if (paramQQAppInterface.structingMsg.mOrangeWord.length() < 8) {
          break label169;
        }
      }
      label169:
      for (this.mMsgExtroInfo = ("[" + paramQQAppInterface.structingMsg.mOrangeWord.substring(0, 8) + "]");; this.mMsgExtroInfo = ("[" + paramQQAppInterface.structingMsg.mOrangeWord + "]"))
      {
        a(paramQQAppInterface.structingMsg, paramContext);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167145);
        if ((paramQQAppInterface.extInt != 1) || (paramQQAppInterface.extLong != 1)) {
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  private void b(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.getMessageText() != null))
    {
      this.mDisplayTime = paramMessage.time;
      return;
    }
    this.mDisplayTime = this.mUser.lastmsgtime;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((!this.isNewKandian) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.mUser.uin)))
    {
      i = paramQQAppInterface.getConversationFacade().g(this.mUser.uin, this.mUser.getType());
      if (this.mUnreadNum > 0)
      {
        if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin)) {
          break label87;
        }
        if (i <= 0) {
          break label81;
        }
        this.mUnreadNum = 1;
        this.mUnreadFlag = 2;
      }
    }
    label81:
    label87:
    do
    {
      return;
      this.mUnreadFlag = 1;
      return;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin))
      {
        if (i > 0)
        {
          this.mUnreadFlag = 2;
          return;
        }
        this.mUnreadFlag = 1;
        return;
      }
      if ((this.mUnreadNum == 1) && (i > 0))
      {
        this.mUnreadFlag = 2;
        return;
      }
    } while (i <= 0);
    this.mUnreadNum -= 1;
    this.mUnreadFlag = 1;
  }
  
  private void b(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (("2747277822".equals(this.mUser.uin)) && (GameMsgManager.a()))
    {
      GameMsgManager localGameMsgManager = (GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      if ((localGameMsgManager == null) || (!localGameMsgManager.c())) {}
    }
    else
    {
      return;
    }
    GameMsgUtil.a(paramQQAppInterface, paramMessage, this.msgSummary, this);
  }
  
  private void c()
  {
    if (AppConstants.WEISHI_UIN.equals(this.mUser.uin)) {
      WeishiReportUtil.a(this, 9);
    }
  }
  
  private void c(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.mExJsonObject != null)) {
      this.mReportKeyBytesOacMsgxtend = paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", null);
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage != null) && ("2909288299".equals(this.mUser.uin)) && (this.mUnreadNum > 0))
    {
      String str = paramMessage.getExtInfoFromExtStr("news_has_report");
      if ((TextUtils.isEmpty(str)) || (!"1".equals(str)))
      {
        paramMessage.saveExtInfoToExtStr("news_has_report", "1");
        ThreadManager.getSubThreadHandler().postDelayed(new RecentItemPublicAccountChatMsgData.3(this, paramQQAppInterface), 10000L);
      }
    }
  }
  
  private void d() {}
  
  public Message a()
  {
    return this.msg;
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage)
  {
    if ((paramMessage != null) && (a(paramQQAppInterface, paramContext, paramMessage, paramQQAppInterface.getMessageFacade(), paramMessage.msgtype))) {
      return;
    }
    paramContext = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    a(paramQQAppInterface, paramMessage, a(paramQQAppInterface, paramContext, this.mUser.uin), paramContext);
    b(paramMessage);
    b(paramQQAppInterface, paramMessage);
    a(paramQQAppInterface);
    b(paramQQAppInterface);
    c(paramMessage);
    c();
    ((IWSManager)QRoute.api(IWSManager.class)).preloadData();
    d();
    ReadinjoyReportUtils.a(this);
    c(paramQQAppInterface, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData
 * JD-Core Version:    0.7.0.1
 */