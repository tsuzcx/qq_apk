package com.tencent.mobileqq.activity.recent.data;

import acvy;
import acwh;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anhk;
import anni;
import arkw;
import bglf;
import bgnr;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.RecentUser;
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
    if ((paramMessage.msgtype == -1024) || (paramMessage.msgtype == -4011) || (arkw.a(paramQQAppInterface, paramMessage)) || (arkw.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) || (arkw.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
      return localMsgSummary;
    }
    if ((anhk.H.equals(this.mUser.uin)) || (anhk.I.equals(this.mUser.uin))) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramMessage.isSend())
      {
        bgnr.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, null, bool, false);
        return localMsgSummary;
      }
      bgnr.a(paramContext, paramQQAppInterface, paramMessage, this.mUser.getType(), localMsgSummary, paramString, bool, false);
      return localMsgSummary;
    }
  }
  
  private String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.a();
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!anhk.H.equals(this.mUser.uin)) && (!anhk.I.equals(this.mUser.uin)) && (!anhk.ab.equals(this.mUser.uin)))
      {
        str = paramString;
        if (!anhk.w.equals(this.mUser.uin)) {}
      }
      else
      {
        if (!anhk.w.equals(this.mUser.uin)) {
          break label107;
        }
        str = bglf.b(paramQQAppInterface, paramString, true);
      }
      label107:
      do
      {
        do
        {
          do
          {
            return str;
            if (!acwh.b(paramString)) {
              break;
            }
            str = paramString;
          } while (localObject == null);
          localObject = ((QQMessageFacade)localObject).a(paramString, paramInt);
          str = paramString;
        } while (localObject == null);
        paramString = bglf.q(paramQQAppInterface, ((QQMessageFacade.Message)localObject).senderuin);
        str = paramString;
      } while (!TextUtils.isEmpty(paramString));
      return bglf.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject).senderuin, false);
      String str = bglf.q(paramQQAppInterface, paramString);
      if (TextUtils.isEmpty(str)) {
        return bglf.b(paramQQAppInterface, paramString, false);
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
      paramMsgSummary.strContent = paramContext.getResources().getString(2131693934);
      if ((localMessageForNearbyRecommenderTips.strBrief != null) && (!"".equals(localMessageForNearbyRecommenderTips.strBrief))) {
        paramMsgSummary.strContent = localMessageForNearbyRecommenderTips.strBrief;
      }
      if (!localMessageForNearbyRecommenderTips.readFlag)
      {
        this.mMsgExtroInfo = paramContext.getResources().getString(2131693935);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
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
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, acvy paramacvy, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    if (paramQQMessageFacade != null)
    {
      this.mUnreadFlag = 1;
      this.mUnreadNum = paramacvy.a(this.mUser.uin, this.mUser.getType());
      if (this.mUnreadNum <= 0)
      {
        this.mUnreadNum = paramacvy.a(anhk.ak, this.mUser.getType());
        this.mUnreadFlag = 3;
      }
    }
    if ((paramMessage.msg == null) || (-999 == paramMessage.msgtype))
    {
      paramMsgSummary.strContent = paramContext.getString(2131697868);
      paramQQMessageFacade = paramString;
    }
    for (;;)
    {
      arkw.a("data_recent_msg", new Object[] { paramQQMessageFacade, paramMsgSummary.strContent });
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
          paramMsgSummary.strContent = paramContext.getString(2131697867, new Object[] { paramQQMessageFacade });
        } else {
          paramMsgSummary.strContent = paramContext.getString(2131697866, new Object[] { paramQQMessageFacade });
        }
      }
    }
  }
  
  private void a(Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (paramQQMessageFacade != null) {
      this.mUnreadNum = paramQQMessageFacade.d();
    }
    if ((-999 == paramMessage.msgtype) || (paramMessage.msg == null)) {
      paramMsgSummary.strContent = paramContext.getString(2131717392);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, acvy paramacvy, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForInteractAndFollow)paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
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
      this.mUnreadNum = paramacvy.a(this.mUser.uin, this.mUser.getType());
    } while ((this.mUnreadNum > 0) || (paramacvy == null));
    this.mUnreadNum = paramacvy.b();
    this.mUnreadFlag = 3;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    paramQQAppInterface = (MessageForNearbyLiveTip)paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop, paramMessage.uniseq);
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
    paramContext = paramContext.getResources().getString(2131698093);
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
    paramMsgSummary.strContent = (paramContext + paramQQAppInterface.nickName + anni.a(2131711951) + paramQQAppInterface.getSummaryMsg());
    this.mLastMsg = (paramContext + paramQQAppInterface.nickName + anni.a(2131711933) + paramQQAppInterface.getSummaryMsg());
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, acvy paramacvy, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, String paramString)
  {
    this.mMsgExtroInfo = "";
    if (arkw.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131692875);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
      paramMsgSummary.strContent = paramacvy.a(this.mUser.uin, 1001, paramContext.getResources().getString(2131692874), 0);
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
            if (arkw.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
            {
              this.mMsgExtroInfo = paramContext.getResources().getString(2131693827);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
              break;
            }
            if (!arkw.a(paramQQAppInterface, paramMessage)) {
              break;
            }
            this.mMsgExtroInfo = paramContext.getString(2131698073);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
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
              a(paramQQAppInterface, paramacvy, paramMessage, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype != -2068) {
              break label411;
            }
            paramMsgSummary.strPrefix = null;
          } while (paramacvy == null);
          this.mUnreadNum = paramacvy.a(this.mUser.uin, this.mUser.getType());
          this.mUnreadFlag = 1;
          return;
          if (paramMessage.msgtype != -2070) {
            break label545;
          }
          paramQQAppInterface = (MessageForYanZhi)paramQQAppInterface.a().b(paramMessage.senderuin, paramMessage.istroop);
          if (paramQQAppInterface != null) {
            break label463;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.msg_box.item_data", 2, "msgForYanZhi == null");
        return;
        paramQQAppInterface.parse();
        paramMsgSummary.strPrefix = null;
        paramMsgSummary.strContent = (paramContext.getString(2131693828) + ": " + paramQQAppInterface.msg);
      } while (paramacvy == null);
      this.mUnreadNum = paramacvy.a(this.mUser.uin, this.mUser.getType());
      this.mUnreadFlag = 1;
      return;
      if (paramQQMessageFacade != null)
      {
        this.mUnreadFlag = 1;
        this.mUnreadNum = paramacvy.a(this.mUser.uin, this.mUser.getType());
        if (this.mUnreadNum <= 0)
        {
          this.mUnreadNum = paramacvy.b();
          this.mUnreadFlag = 3;
        }
      }
    } while ((!TextUtils.isEmpty(paramString)) || (arkw.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) || (!arkw.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())));
    label411:
    label545:
    paramMsgSummary.strContent = paramContext.getString(2131692863);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null) {
      localObject1 = localQQMessageFacade.a(this.mUser.uin, this.mUser.getType());
    }
    acvy localacvy = paramQQAppInterface.a();
    Object localObject2;
    if ((localacvy != null) && (localObject1 != null))
    {
      this.mUnreadNum = localacvy.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
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
        if ((!anhk.H.equals(this.mUser.uin)) && (!anhk.I.equals(this.mUser.uin))) {
          break label477;
        }
        this.mTitleName = paramContext.getString(2131692865);
        a(paramQQAppInterface, paramContext, localQQMessageFacade, localacvy, (QQMessageFacade.Message)localObject1, localMsgSummary, (String)localObject2);
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
        if (anhk.ab.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131697865);
          a(paramContext, localQQMessageFacade, localacvy, (QQMessageFacade.Message)localObject1, localMsgSummary, (String)localObject2);
          break label260;
        }
        if (anhk.w.equals(this.mUser.uin))
        {
          this.mTitleName = paramContext.getString(2131717394);
          a(paramContext, localQQMessageFacade, (QQMessageFacade.Message)localObject1, localMsgSummary);
          break label260;
        }
        this.mTitleName = bglf.b(paramQQAppInterface, this.mUser.uin, true);
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