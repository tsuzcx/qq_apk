package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
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
  
  public static PublicAccountInfo a(QQAppInterface paramQQAppInterface, IPublicAccountDataManager paramIPublicAccountDataManager, String paramString)
  {
    if ((paramIPublicAccountDataManager == null) || (RecentParcelUtil.a(paramQQAppInterface))) {}
    try
    {
      paramQQAppInterface = (PublicAccountInfo)paramIPublicAccountDataManager.findPublicAccountInfo(paramString, true);
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface)
    {
      label25:
      break label25;
    }
    return (PublicAccountInfo)paramIPublicAccountDataManager.findPublicAccountInfo(paramString);
    return (PublicAccountInfo)paramIPublicAccountDataManager.findPublicAccountInfo(paramString);
    return null;
  }
  
  private void a(Context paramContext, Message paramMessage)
  {
    Object localObject;
    if ((paramMessage.lastMsg instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)paramMessage.lastMsg;
      paramMessage = (Message)localObject;
      if (!((MessageForStructing)localObject).mIsParsed)
      {
        ((MessageForStructing)localObject).parse();
        paramMessage = (Message)localObject;
      }
    }
    else if (paramMessage.msgtype == -2011)
    {
      localObject = new MessageForStructing();
      ((MessageForStructing)localObject).msgData = paramMessage.msgData;
      ((MessageForStructing)localObject).parse();
      paramMessage.lastMsg = ((MessageRecord)localObject);
      paramMessage = (Message)localObject;
    }
    else
    {
      paramMessage = null;
    }
    if ((paramMessage != null) && (paramMessage.structingMsg != null))
    {
      this.msgSummary.strContent = paramMessage.structingMsg.mMsgBrief;
      this.msgSummary.suffix = "";
      if ((!TextUtils.isEmpty(paramMessage.structingMsg.mOrangeWord)) && (this.mUnreadNum > 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(paramMessage.structingMsg.mOrangeWord);
        ((StringBuilder)localObject).append("]");
        this.mMsgExtroInfo = ((StringBuilder)localObject).toString();
        a(paramMessage.structingMsg, paramContext);
        this.mExtraInfoColor = -881592;
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
      ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).createCustomQQShopMsgSummary(paramQQAppInterface, this.msgSummary);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    boolean bool;
    if (this.mUnreadNum > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = NickNameManager.a(paramQQAppInterface, paramMessage, bool);
    if (localObject != null) {
      this.msgSummary.strContent = ((CharSequence)localObject);
    }
    localObject = PubAccountTips.a(paramQQAppInterface, this.mUser.uin);
    if ((localObject != null) && (((PubAccountTips.PubAccountTipsMsg)localObject).d == paramMessage.uniseq) && (((PubAccountTips.PubAccountTipsMsg)localObject).b())) {
      ThreadManager.post(new RecentItemPublicAccountChatMsgData.1(this, paramQQAppInterface, (PubAccountTips.PubAccountTipsMsg)localObject), 2, null, false);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Message paramMessage, PublicAccountInfo paramPublicAccountInfo, IPublicAccountDataManager paramIPublicAccountDataManager)
  {
    if ((paramPublicAccountInfo == null) && (paramIPublicAccountDataManager != null))
    {
      paramIPublicAccountDataManager = paramIPublicAccountDataManager.findAccountDetailInfo(this.mUser.uin);
      if (paramIPublicAccountDataManager != null) {
        this.mTitleName = paramIPublicAccountDataManager.getName();
      }
      if (this.isNewKandian) {
        this.mTitleName = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getXinKandianName(paramQQAppInterface, paramQQAppInterface.getApp());
      }
    }
    if (paramPublicAccountInfo != null)
    {
      this.mTitleName = paramPublicAccountInfo.name;
      this.mAuthenIconId = 0;
    }
    else
    {
      this.mAuthenIconId = 0;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin)) {
      this.mTitleName = ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).getDailyMsgBoxName(paramMessage);
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, Context paramContext)
  {
    if ((!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713108))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713113))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713105))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713116))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(HardCodeUtil.a(2131713119))))
    {
      if (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(String.format(paramContext.getString(2131696440), new Object[] { Integer.valueOf(this.mUnreadNum) }))) {}
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
        return false;
      }
      this.mMsgExtroInfo = "";
      this.mExtraInfoColor = 0;
      if (this.isNewKandian)
      {
        if (a(paramQQAppInterface, paramContext, paramQQMessageFacade)) {
          return true;
        }
      }
      else
      {
        if ((!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin)) && (!AppConstants.KANDIAN_DAILY_UIN.equals(this.mUser.uin)))
        {
          if (("2290230341".equals(this.mUser.uin)) && (QZoneHelper.enableQZoneContextBox(paramQQAppInterface)))
          {
            a(paramMessage);
            return false;
          }
          a(paramQQAppInterface, paramMessage);
          return false;
        }
        a(paramContext, paramMessage);
        return false;
      }
    }
    else
    {
      this.msgSummary.strContent = "";
      paramQQMessageFacade = XMLMessageUtils.a(paramMessage);
      if ((paramQQMessageFacade != null) && (paramQQMessageFacade.items != null) && (paramQQMessageFacade.items.size() != 0))
      {
        paramContext = ((PAMessage.Item)paramQQMessageFacade.items.get(0)).title;
        paramQQAppInterface = paramContext;
        if (((PAMessage.Item)paramQQMessageFacade.items.get(0)).cover == null)
        {
          paramQQAppInterface = paramContext;
          if (((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList != null)
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(paramContext);
            paramQQAppInterface.append(": ");
            paramQQAppInterface.append((String)((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList.get(0));
            paramQQAppInterface = paramQQAppInterface.toString();
          }
        }
        this.msgSummary.strContent = paramQQAppInterface;
        return false;
      }
      buildMessageBody(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
    }
    return false;
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
      if ((this.mUnreadNum > 0) && (paramQQAppInterface.structingMsg != null) && (!TextUtils.isEmpty(paramQQAppInterface.structingMsg.mOrangeWord)))
      {
        if (paramQQAppInterface.structingMsg.mOrangeWord.length() >= 8)
        {
          paramQQMessageFacade = new StringBuilder();
          paramQQMessageFacade.append("[");
          paramQQMessageFacade.append(paramQQAppInterface.structingMsg.mOrangeWord.substring(0, 8));
          paramQQMessageFacade.append("]");
          this.mMsgExtroInfo = paramQQMessageFacade.toString();
        }
        else
        {
          paramQQMessageFacade = new StringBuilder();
          paramQQMessageFacade.append("[");
          paramQQMessageFacade.append(paramQQAppInterface.structingMsg.mOrangeWord);
          paramQQMessageFacade.append("]");
          this.mMsgExtroInfo = paramQQMessageFacade.toString();
        }
        a(paramQQAppInterface.structingMsg, paramContext);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      }
      if ((paramQQAppInterface.extInt == 1) && (paramQQAppInterface.extLong == 1)) {
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
    if ((!this.isNewKandian) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.mUser.uin)))
    {
      int i = paramQQAppInterface.getConversationFacade().g(this.mUser.uin, this.mUser.getType());
      if (this.mUnreadNum > 0)
      {
        if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.mUser.uin))
        {
          if (i > 0)
          {
            this.mUnreadNum = 1;
            this.mUnreadFlag = 2;
            return;
          }
          this.mUnreadFlag = 1;
          return;
        }
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
        if (i > 0)
        {
          this.mUnreadNum -= 1;
          this.mUnreadFlag = 1;
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (("2747277822".equals(this.mUser.uin)) && (localIGameMsgManagerService.isInited()))
    {
      if ((localIGameMsgManagerService != null) && (localIGameMsgManagerService.isShowInMsgBox())) {
        return;
      }
      GameMsgUtil.a(paramQQAppInterface, paramMessage, this.msgSummary, this);
    }
  }
  
  private void c()
  {
    if (AppConstants.WEISHI_UIN.equals(this.mUser.uin)) {
      ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportMsgExposure(this, 9);
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
    paramContext = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    a(paramQQAppInterface, paramMessage, a(paramQQAppInterface, paramContext, this.mUser.uin), paramContext);
    b(paramMessage);
    b(paramQQAppInterface, paramMessage);
    a(paramQQAppInterface);
    b(paramQQAppInterface);
    c(paramMessage);
    c();
    ((IWSManager)QRoute.api(IWSManager.class)).preloadData();
    d();
    ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).reportMsgExposure(this);
    c(paramQQAppInterface, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData
 * JD-Core Version:    0.7.0.1
 */