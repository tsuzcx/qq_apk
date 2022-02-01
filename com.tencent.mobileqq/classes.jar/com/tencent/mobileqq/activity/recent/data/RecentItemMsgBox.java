package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemMsgBox
  extends AbsRecentUserBusinessBaseData
{
  public static final String TAG = "Q.msg_box.item_data";
  
  public RecentItemMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private MsgSummary a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage, String paramString)
  {
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    if ((paramMessage.msgtype != -1024) && (paramMessage.msgtype != -4011) && (!DatingUtil.a(paramQQAppInterface, paramMessage)) && (!DatingUtil.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())))
    {
      if (DatingUtil.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) {
        return localMsgSummary;
      }
      boolean bool;
      if ((!AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin))) {
        bool = false;
      } else {
        bool = true;
      }
      if (paramMessage.isSend())
      {
        MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, null, bool, false);
        return localMsgSummary;
      }
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, paramString, bool, false);
    }
    return localMsgSummary;
  }
  
  private String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getMessageFacade();
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.DATE_UIN.equals(this.mUser.uin)))
      {
        str = paramString;
        if (!AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin)) {}
      }
      else
      {
        if (AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin)) {
          return ContactUtils.a(paramQQAppInterface, paramString, true);
        }
        if (UinTypeUtil.c(paramString))
        {
          str = paramString;
          if (localObject != null)
          {
            localObject = ((QQMessageFacade)localObject).getLastMessage(paramString, paramInt);
            str = paramString;
            if (localObject != null)
            {
              paramString = ContactUtils.g(paramQQAppInterface, ((Message)localObject).senderuin);
              str = paramString;
              if (TextUtils.isEmpty(paramString)) {
                return ContactUtils.a(paramQQAppInterface, ((Message)localObject).senderuin, false);
              }
            }
          }
        }
        else
        {
          str = ContactUtils.g(paramQQAppInterface, paramString);
          if (TextUtils.isEmpty(str)) {
            return ContactUtils.a(paramQQAppInterface, paramString, false);
          }
          return str;
        }
      }
    }
    else {
      str = null;
    }
    return str;
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    try
    {
      MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = new MessageForNearbyRecommenderTips();
      localMessageForNearbyRecommenderTips.msgData = paramMessage.msgData;
      localMessageForNearbyRecommenderTips.parse();
      paramMsgSummary.strContent = paramContext.getResources().getString(2131694410);
      paramMessage = localMessageForNearbyRecommenderTips.strBrief;
      if ((paramMessage != null) && (!"".equals(localMessageForNearbyRecommenderTips.strBrief))) {
        paramMsgSummary.strContent = localMessageForNearbyRecommenderTips.strBrief;
      }
      if (!localMessageForNearbyRecommenderTips.readFlag)
      {
        this.mMsgExtroInfo = paramContext.getResources().getString(2131694411);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
        return;
      }
      this.mMsgExtroInfo = "";
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, ConversationFacade paramConversationFacade, Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    if (paramQQMessageFacade != null)
    {
      this.mUnreadFlag = 1;
      this.mUnreadNum = paramConversationFacade.a(this.mUser.uin, this.mUser.getType());
      if (this.mUnreadNum <= 0)
      {
        this.mUnreadNum = paramConversationFacade.a(AppConstants.DATE_SAY_HELLO_LIST_UIN, this.mUser.getType());
        this.mUnreadFlag = 3;
      }
    }
    if ((paramMessage.msg != null) && (-999 != paramMessage.msgtype))
    {
      paramQQMessageFacade = paramString;
      if (paramMessage.msgtype == -1024)
      {
        paramQQMessageFacade = paramString;
        if (paramString != null)
        {
          paramQQMessageFacade = paramString;
          if (paramString.length() > 12)
          {
            paramQQMessageFacade = new StringBuilder();
            paramQQMessageFacade.append(paramString.substring(0, 11));
            paramQQMessageFacade.append("...");
            paramQQMessageFacade = paramQQMessageFacade.toString();
          }
        }
        if (paramMessage.isSendFromLocal()) {
          paramMsgSummary.strContent = paramContext.getString(2131698743, new Object[] { paramQQMessageFacade });
        } else {
          paramMsgSummary.strContent = paramContext.getString(2131698742, new Object[] { paramQQMessageFacade });
        }
      }
    }
    else
    {
      paramMsgSummary.strContent = paramContext.getString(2131698744);
      paramQQMessageFacade = paramString;
    }
    DatingUtil.a("data_recent_msg", new Object[] { paramQQMessageFacade, paramMsgSummary.strContent });
  }
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (paramQQMessageFacade != null) {
      this.mUnreadNum = paramQQMessageFacade.d();
    }
    if ((-999 == paramMessage.msgtype) || (paramMessage.msg == null)) {
      paramMsgSummary.strContent = paramContext.getString(2131718363);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForNearbyLiveTip)paramQQAppInterface.getMessageFacade().a(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.item_data", 2, "msg.msgtype == MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP, tip = null");
      }
      return;
    }
    paramQQAppInterface.parse();
    paramMsgSummary.strPrefix = null;
    this.mUnreadFlag = 1;
    paramContext = paramContext.getResources().getString(2131699037);
    if (!TextUtils.isEmpty(paramQQAppInterface.c2cMsgWording))
    {
      paramMsgSummary.strContent = paramQQAppInterface.c2cMsgWording;
      this.mLastMsg = paramQQAppInterface.c2cMsgWording;
      return;
    }
    if (paramQQAppInterface.isLiving)
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramContext);
      paramMessage.append(paramQQAppInterface.nickName);
      paramMessage.append(paramQQAppInterface.getSummaryMsg());
      paramMsgSummary.strContent = paramMessage.toString();
      paramMessage = new StringBuilder();
      paramMessage.append(paramContext);
      paramMessage.append(paramQQAppInterface.nickName);
      paramMessage.append(paramQQAppInterface.getSummaryMsg());
      this.mLastMsg = paramMessage.toString();
      return;
    }
    if (MessageForNearbyLiveTip.isHuayangTip(paramQQAppInterface.jumpingUrl))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(paramContext);
      paramMessage.append(paramQQAppInterface.nickName);
      paramMessage.append(paramQQAppInterface.liveEndWording);
      paramMsgSummary.strContent = paramMessage.toString();
      paramMessage = new StringBuilder();
      paramMessage.append(paramContext);
      paramMessage.append(paramQQAppInterface.nickName);
      paramMessage.append(paramQQAppInterface.liveEndWording);
      this.mLastMsg = paramMessage.toString();
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append(paramContext);
    paramMessage.append(paramQQAppInterface.nickName);
    paramMessage.append(HardCodeUtil.a(2131713110));
    paramMessage.append(paramQQAppInterface.getSummaryMsg());
    paramMsgSummary.strContent = paramMessage.toString();
    paramMessage = new StringBuilder();
    paramMessage.append(paramContext);
    paramMessage.append(paramQQAppInterface.nickName);
    paramMessage.append(HardCodeUtil.a(2131713092));
    paramMessage.append(paramQQAppInterface.getSummaryMsg());
    this.mLastMsg = paramMessage.toString();
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, ConversationFacade paramConversationFacade, Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    this.mMsgExtroInfo = "";
    StringBuilder localStringBuilder;
    if (DatingUtil.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131693169);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      paramMsgSummary.strContent = paramConversationFacade.a(this.mUser.uin, 1001, paramContext.getResources().getString(2131693168), 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("recent item update:[uin:");
        localStringBuilder.append(this.mUser.uin);
        localStringBuilder.append(",type:");
        localStringBuilder.append(this.mUser.getType());
        localStringBuilder.append(",hasUnreadRedPacketMsg]");
        QLog.d("Q.msg_box", 2, localStringBuilder.toString());
      }
    }
    else if (DatingUtil.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131694301);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
    }
    else if (DatingUtil.a(paramQQAppInterface, paramMessage))
    {
      this.mMsgExtroInfo = paramContext.getString(2131699016);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167170);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("recent item update:[uin:");
        localStringBuilder.append(this.mUser.uin);
        localStringBuilder.append(",type:");
        localStringBuilder.append(this.mUser.getType());
        localStringBuilder.append(",hasHelloMsg]");
        QLog.d("Q.msg_box", 2, localStringBuilder.toString());
      }
    }
    if (paramMessage.msgtype == -4011)
    {
      a(paramContext, paramMessage, paramMsgSummary);
      return;
    }
    if (paramMessage.msgtype == -2053)
    {
      a(paramQQAppInterface, paramContext, paramMessage, paramMsgSummary);
      return;
    }
    if (paramMessage.msgtype == -2055)
    {
      a(paramQQAppInterface, paramConversationFacade, paramMessage, paramMsgSummary);
      return;
    }
    if (paramMessage.msgtype == -2068)
    {
      paramMsgSummary.strPrefix = null;
      if (paramConversationFacade != null)
      {
        this.mUnreadNum = paramConversationFacade.a(this.mUser.uin, this.mUser.getType());
        this.mUnreadFlag = 1;
      }
    }
    else if (paramMessage.msgtype == -2070)
    {
      paramQQAppInterface = (MessageForYanZhi)paramQQAppInterface.getMessageFacade().b(paramMessage.senderuin, paramMessage.istroop);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg_box.item_data", 2, "msgForYanZhi == null");
        }
        return;
      }
      paramQQAppInterface.parse();
      paramMsgSummary.strPrefix = null;
      paramQQMessageFacade = new StringBuilder();
      paramQQMessageFacade.append(paramContext.getString(2131694302));
      paramQQMessageFacade.append(": ");
      paramQQMessageFacade.append(paramQQAppInterface.msg);
      paramMsgSummary.strContent = paramQQMessageFacade.toString();
      if (paramConversationFacade != null)
      {
        this.mUnreadNum = paramConversationFacade.a(this.mUser.uin, this.mUser.getType());
        this.mUnreadFlag = 1;
      }
    }
    else
    {
      if (paramQQMessageFacade != null)
      {
        this.mUnreadFlag = 1;
        this.mUnreadNum = paramConversationFacade.a(this.mUser.uin, this.mUser.getType());
        if (this.mUnreadNum <= 0)
        {
          this.mUnreadNum = paramConversationFacade.b();
          this.mUnreadFlag = 3;
        }
      }
      if ((TextUtils.isEmpty(paramString)) && (!DatingUtil.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) && (DatingUtil.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
        paramMsgSummary.strContent = paramContext.getString(2131693134);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ConversationFacade paramConversationFacade, Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForInteractAndFollow)paramQQAppInterface.getMessageFacade().a(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.item_data", 2, "interactAndFollow == null");
      }
      return;
    }
    paramQQAppInterface.parse();
    paramMsgSummary.strPrefix = null;
    paramMsgSummary.strContent = paramQQAppInterface.context;
    this.mLastMsg = paramQQAppInterface.context;
    this.mUnreadNum = paramConversationFacade.a(this.mUser.uin, this.mUser.getType());
    if (this.mUnreadNum <= 0)
    {
      this.mUnreadNum = paramConversationFacade.b();
      this.mUnreadFlag = 3;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      Object localObject1 = null;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null) {
        localObject1 = localQQMessageFacade.getLastMessage(this.mUser.uin, this.mUser.getType());
      }
      ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
      if ((localConversationFacade != null) && (localObject1 != null)) {
        this.mUnreadNum = localConversationFacade.a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      } else {
        this.mUnreadNum = 0;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new Message();
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("msg is null: ");
          ((StringBuilder)localObject2).append(this.mUser.uin);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(this.mUser.getType());
          QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
      }
      String str = a(paramQQAppInterface, ((Message)localObject2).senderuin, ((Message)localObject2).istroop);
      localObject1 = a(paramQQAppInterface, paramContext, (Message)localObject2, str);
      if ((((Message)localObject2).getMessageText() == null) && (((Message)localObject2).msgData == null)) {
        this.mDisplayTime = 0L;
      } else {
        this.mDisplayTime = ((Message)localObject2).time;
      }
      if ((!AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin)))
      {
        if (AppConstants.DATE_UIN.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131698741);
          a(paramContext, localQQMessageFacade, localConversationFacade, (Message)localObject2, (MsgSummary)localObject1, str);
        }
        else if (AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131718365);
          a(paramContext, localQQMessageFacade, (Message)localObject2, (MsgSummary)localObject1);
        }
        else
        {
          this.mTitleName = ContactUtils.a(paramQQAppInterface, this.mUser.uin, true);
        }
      }
      else
      {
        this.mTitleName = paramContext.getString(2131693136);
        a(paramQQAppInterface, paramContext, localQQMessageFacade, localConversationFacade, (Message)localObject2, (MsgSummary)localObject1, str);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recent item update:[uin:");
        ((StringBuilder)localObject2).append(this.mUser.uin);
        ((StringBuilder)localObject2).append(",type:");
        ((StringBuilder)localObject2).append(this.mUser.getType());
        ((StringBuilder)localObject2).append(",unreadNum:");
        ((StringBuilder)localObject2).append(this.mUnreadNum);
        ((StringBuilder)localObject2).append("]");
        QLog.d("Q.msg_box", 2, ((StringBuilder)localObject2).toString());
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject1);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject1);
      if (AppSetting.d)
      {
        paramContext = ((MsgSummary)localObject1).strContent;
        paramQQAppInterface = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          paramQQAppInterface = this.mMsgExtroInfo;
        }
        localObject1 = "";
        paramContext = paramQQAppInterface;
        if (paramQQAppInterface == null) {
          paramContext = "";
        }
        if (this.mUnreadNum > 0)
        {
          if (this.mTitleName != null) {
            paramQQAppInterface = this.mTitleName;
          } else {
            paramQQAppInterface = "";
          }
          if (this.mShowTime != null) {
            localObject1 = this.mShowTime;
          }
          this.mContentDesc = String.format("%s,%s,%d条未读,%s", new Object[] { paramQQAppInterface, localObject1, Integer.valueOf(this.mUnreadNum), paramContext });
        }
        else
        {
          if (this.mTitleName != null) {
            paramQQAppInterface = this.mTitleName;
          } else {
            paramQQAppInterface = "";
          }
          if (this.mShowTime != null) {
            localObject1 = this.mShowTime;
          }
          this.mContentDesc = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, localObject1, paramContext });
        }
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox
 * JD-Core Version:    0.7.0.1
 */