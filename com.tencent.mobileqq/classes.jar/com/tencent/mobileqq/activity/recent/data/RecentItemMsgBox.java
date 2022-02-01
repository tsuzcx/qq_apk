package com.tencent.mobileqq.activity.recent.data;

import acmw;
import acnh;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anvx;
import arxx;
import bhfj;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemMsgBox
  extends AbsRecentUserBusinessBaseData
{
  public static final String TAG = "Q.msg_box.item_data";
  
  public RecentItemMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private MsgSummary a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, String paramString)
  {
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    if ((paramMessage.msgtype == -1024) || (paramMessage.msgtype == -4011) || (arxx.a(paramQQAppInterface, paramMessage)) || (arxx.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) || (arxx.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
      return localMsgSummary;
    }
    if ((AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) || (AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin))) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramMessage.isSend())
      {
        bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, null, bool, false);
        return localMsgSummary;
      }
      bhfj.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, paramString, bool, false);
      return localMsgSummary;
    }
  }
  
  private String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.DATE_UIN.equals(this.mUser.uin)))
      {
        str = paramString;
        if (!AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin)) {}
      }
      else
      {
        if (!AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin)) {
          break label107;
        }
        str = ContactUtils.getBuddyName(paramQQAppInterface, paramString, true);
      }
      label107:
      do
      {
        do
        {
          do
          {
            return str;
            if (!acnh.b(paramString)) {
              break;
            }
            str = paramString;
          } while (localObject == null);
          localObject = ((QQMessageFacade)localObject).getLastMessage(paramString, paramInt);
          str = paramString;
        } while (localObject == null);
        paramString = ContactUtils.getDateNickName(paramQQAppInterface, ((QQMessageFacade.Message)localObject).senderuin);
        str = paramString;
      } while (!TextUtils.isEmpty(paramString));
      return ContactUtils.getBuddyName(paramQQAppInterface, ((QQMessageFacade.Message)localObject).senderuin, false);
      String str = ContactUtils.getDateNickName(paramQQAppInterface, paramString);
      if (TextUtils.isEmpty(str)) {
        return ContactUtils.getBuddyName(paramQQAppInterface, paramString, false);
      }
      return str;
    }
    return null;
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    try
    {
      MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = new MessageForNearbyRecommenderTips();
      localMessageForNearbyRecommenderTips.msgData = paramMessage.msgData;
      localMessageForNearbyRecommenderTips.parse();
      paramMsgSummary.strContent = paramContext.getResources().getString(2131694241);
      if ((localMessageForNearbyRecommenderTips.strBrief != null) && (!"".equals(localMessageForNearbyRecommenderTips.strBrief))) {
        paramMsgSummary.strContent = localMessageForNearbyRecommenderTips.strBrief;
      }
      if (!localMessageForNearbyRecommenderTips.readFlag)
      {
        this.mMsgExtroInfo = paramContext.getResources().getString(2131694242);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
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
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, acmw paramacmw, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    if (paramQQMessageFacade != null)
    {
      this.mUnreadFlag = 1;
      this.mUnreadNum = paramacmw.a(this.mUser.uin, this.mUser.getType());
      if (this.mUnreadNum <= 0)
      {
        this.mUnreadNum = paramacmw.a(AppConstants.DATE_SAY_HELLO_LIST_UIN, this.mUser.getType());
        this.mUnreadFlag = 3;
      }
    }
    if ((paramMessage.msg == null) || (-999 == paramMessage.msgtype))
    {
      paramMsgSummary.strContent = paramContext.getString(2131698395);
      paramQQMessageFacade = paramString;
    }
    for (;;)
    {
      arxx.a("data_recent_msg", new Object[] { paramQQMessageFacade, paramMsgSummary.strContent });
      return;
      paramQQMessageFacade = paramString;
      if (paramMessage.msgtype == -1024)
      {
        paramQQMessageFacade = paramString;
        if (paramString != null)
        {
          paramQQMessageFacade = paramString;
          if (paramString.length() > 12) {
            paramQQMessageFacade = paramString.substring(0, 11) + "...";
          }
        }
        if (paramMessage.isSendFromLocal()) {
          paramMsgSummary.strContent = paramContext.getString(2131698394, new Object[] { paramQQMessageFacade });
        } else {
          paramMsgSummary.strContent = paramContext.getString(2131698393, new Object[] { paramQQMessageFacade });
        }
      }
    }
  }
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (paramQQMessageFacade != null) {
      this.mUnreadNum = paramQQMessageFacade.getUnreadMsgsNumForSameState();
    }
    if ((-999 == paramMessage.msgtype) || (paramMessage.msg == null)) {
      paramMsgSummary.strContent = paramContext.getString(2131718141);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, acmw paramacmw, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForInteractAndFollow)paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.item_data", 2, "interactAndFollow == null");
      }
    }
    do
    {
      return;
      paramQQAppInterface.parse();
      paramMsgSummary.strPrefix = null;
      paramMsgSummary.strContent = paramQQAppInterface.context;
      this.mLastMsg = paramQQAppInterface.context;
      this.mUnreadNum = paramacmw.a(this.mUser.uin, this.mUser.getType());
    } while (this.mUnreadNum > 0);
    this.mUnreadNum = paramacmw.b();
    this.mUnreadFlag = 3;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForNearbyLiveTip)paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
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
    paramContext = paramContext.getResources().getString(2131698655);
    if (!TextUtils.isEmpty(paramQQAppInterface.c2cMsgWording))
    {
      paramMsgSummary.strContent = paramQQAppInterface.c2cMsgWording;
      this.mLastMsg = paramQQAppInterface.c2cMsgWording;
      return;
    }
    if (paramQQAppInterface.isLiving)
    {
      paramMsgSummary.strContent = (paramContext + paramQQAppInterface.nickName + paramQQAppInterface.getSummaryMsg());
      this.mLastMsg = (paramContext + paramQQAppInterface.nickName + paramQQAppInterface.getSummaryMsg());
      return;
    }
    if (MessageForNearbyLiveTip.isHuayangTip(paramQQAppInterface.jumpingUrl))
    {
      paramMsgSummary.strContent = (paramContext + paramQQAppInterface.nickName + paramQQAppInterface.liveEndWording);
      this.mLastMsg = (paramContext + paramQQAppInterface.nickName + paramQQAppInterface.liveEndWording);
      return;
    }
    paramMsgSummary.strContent = (paramContext + paramQQAppInterface.nickName + anvx.a(2131712639) + paramQQAppInterface.getSummaryMsg());
    this.mLastMsg = (paramContext + paramQQAppInterface.nickName + anvx.a(2131712621) + paramQQAppInterface.getSummaryMsg());
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, acmw paramacmw, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    this.mMsgExtroInfo = "";
    if (arxx.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131693069);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
      paramMsgSummary.strContent = paramacmw.a(this.mUser.uin, 1001, paramContext.getResources().getString(2131693068), 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",hasUnreadRedPacketMsg]");
      }
      if (paramMessage.msgtype != -4011) {
        break label315;
      }
      a(paramContext, paramMessage, paramMsgSummary);
    }
    label315:
    label463:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (arxx.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
            {
              this.mMsgExtroInfo = paramContext.getResources().getString(2131694134);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
              break;
            }
            if (!arxx.a(paramQQAppInterface, paramMessage)) {
              break;
            }
            this.mMsgExtroInfo = paramContext.getString(2131698635);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167138);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",hasHelloMsg]");
            break;
            if (paramMessage.msgtype == -2053)
            {
              a(paramQQAppInterface, paramContext, paramMessage, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2055)
            {
              a(paramQQAppInterface, paramacmw, paramMessage, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype != -2068) {
              break label411;
            }
            paramMsgSummary.strPrefix = null;
          } while (paramacmw == null);
          this.mUnreadNum = paramacmw.a(this.mUser.uin, this.mUser.getType());
          this.mUnreadFlag = 1;
          return;
          if (paramMessage.msgtype != -2070) {
            break label545;
          }
          paramQQAppInterface = (MessageForYanZhi)paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramMessage.senderuin, paramMessage.istroop);
          if (paramQQAppInterface != null) {
            break label463;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.msg_box.item_data", 2, "msgForYanZhi == null");
        return;
        paramQQAppInterface.parse();
        paramMsgSummary.strPrefix = null;
        paramMsgSummary.strContent = (paramContext.getString(2131694135) + ": " + paramQQAppInterface.msg);
      } while (paramacmw == null);
      this.mUnreadNum = paramacmw.a(this.mUser.uin, this.mUser.getType());
      this.mUnreadFlag = 1;
      return;
      if (paramQQMessageFacade != null)
      {
        this.mUnreadFlag = 1;
        this.mUnreadNum = paramacmw.a(this.mUser.uin, this.mUser.getType());
        if (this.mUnreadNum <= 0)
        {
          this.mUnreadNum = paramacmw.b();
          this.mUnreadFlag = 3;
        }
      }
    } while ((!TextUtils.isEmpty(paramString)) || (arxx.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) || (!arxx.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())));
    label411:
    label545:
    paramMsgSummary.strContent = paramContext.getString(2131693028);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localObject1 = localQQMessageFacade.getLastMessage(this.mUser.uin, this.mUser.getType());
    }
    acmw localacmw = paramQQAppInterface.getConversationFacade();
    Object localObject2;
    if ((localacmw != null) && (localObject1 != null))
    {
      this.mUnreadNum = localacmw.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if (localObject1 != null) {
        break label657;
      }
      localObject2 = new QQMessageFacade.Message();
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.recent", 2, "msg is null: " + this.mUser.uin + "," + this.mUser.getType());
        localObject1 = localObject2;
      }
    }
    label260:
    label651:
    label657:
    for (;;)
    {
      localObject2 = a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, ((QQMessageFacade.Message)localObject1).istroop);
      MsgSummary localMsgSummary = a(paramQQAppInterface, paramContext, (QQMessageFacade.Message)localObject1, (String)localObject2);
      if ((((QQMessageFacade.Message)localObject1).getMessageText() != null) || (((QQMessageFacade.Message)localObject1).msgData != null))
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
        label202:
        if ((!AppConstants.LBS_HELLO_UIN.equals(this.mUser.uin)) && (!AppConstants.NEARBY_LBS_HELLO_UIN.equals(this.mUser.uin))) {
          break label477;
        }
        this.mTitleName = paramContext.getString(2131693030);
        a(paramQQAppInterface, paramContext, localQQMessageFacade, localacmw, (QQMessageFacade.Message)localObject1, localMsgSummary, (String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",unreadNum:" + this.mUnreadNum + "]");
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.c)
        {
          paramContext = localMsgSummary.strContent;
          paramQQAppInterface = paramContext;
          if (TextUtils.isEmpty(paramContext)) {
            paramQQAppInterface = this.mMsgExtroInfo;
          }
          paramContext = paramQQAppInterface;
          if (paramQQAppInterface == null) {
            paramContext = "";
          }
          if (this.mUnreadNum <= 0) {
            break label592;
          }
          if (this.mTitleName == null) {
            break label580;
          }
          paramQQAppInterface = this.mTitleName;
          label408:
          if (this.mShowTime == null) {
            break label586;
          }
        }
      }
      label580:
      label586:
      for (localObject1 = this.mShowTime;; localObject1 = "")
      {
        this.mContentDesc = String.format("%s,%s,%d条未读,%s", new Object[] { paramQQAppInterface, localObject1, Integer.valueOf(this.mUnreadNum), paramContext });
        updateMsgUnreadStateMenu();
        return;
        this.mUnreadNum = 0;
        break;
        this.mDisplayTime = 0L;
        break label202;
        label477:
        if (AppConstants.DATE_UIN.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131698392);
          a(paramContext, localQQMessageFacade, localacmw, (QQMessageFacade.Message)localObject1, localMsgSummary, (String)localObject2);
          break label260;
        }
        if (AppConstants.SAME_STATE_BOX_UIN.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131718143);
          a(paramContext, localQQMessageFacade, (QQMessageFacade.Message)localObject1, localMsgSummary);
          break label260;
        }
        this.mTitleName = ContactUtils.getBuddyName(paramQQAppInterface, this.mUser.uin, true);
        break label260;
        paramQQAppInterface = "";
        break label408;
      }
      label592:
      if (this.mTitleName != null)
      {
        paramQQAppInterface = this.mTitleName;
        label604:
        if (this.mShowTime == null) {
          break label651;
        }
      }
      for (localObject1 = this.mShowTime;; localObject1 = "")
      {
        this.mContentDesc = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, localObject1, paramContext });
        break;
        paramQQAppInterface = "";
        break label604;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox
 * JD-Core Version:    0.7.0.1
 */