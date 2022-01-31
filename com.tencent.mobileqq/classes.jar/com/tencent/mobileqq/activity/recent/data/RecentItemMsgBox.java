package com.tencent.mobileqq.activity.recent.data;

import abta;
import abti;
import alof;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import apib;
import bdgc;
import bdil;
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
  extends RecentUserBaseData
{
  public static final String TAG = "Q.msg_box.item_data";
  
  public RecentItemMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
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
    abta localabta = paramQQAppInterface.a();
    if ((localabta != null) && (localObject1 != null))
    {
      this.mUnreadNum = localabta.a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      label85:
      if (localObject1 != null) {
        break label2624;
      }
      localObject1 = new QQMessageFacade.Message();
      localObject4 = localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "msg is null: " + this.mUser.uin + "," + this.mUser.getType());
      }
    }
    label279:
    label304:
    label377:
    Object localObject2;
    label564:
    label821:
    label2615:
    label2624:
    for (Object localObject4 = localObject1;; localObject4 = localObject2)
    {
      MsgSummary localMsgSummary = a();
      Object localObject3;
      if (!TextUtils.isEmpty(localObject4.senderuin))
      {
        localObject3 = localObject4.senderuin;
        if ((!alof.H.equals(this.mUser.uin)) && (!alof.I.equals(this.mUser.uin)) && (!alof.ab.equals(this.mUser.uin)))
        {
          localObject1 = localObject3;
          if (!alof.w.equals(this.mUser.uin)) {}
        }
        else if (alof.w.equals(this.mUser.uin))
        {
          localObject1 = bdgc.b(paramQQAppInterface, localObject4.senderuin, true);
        }
      }
      for (;;)
      {
        if ((localObject4.getMessageText() != null) || (localObject4.msgData != null))
        {
          this.mDisplayTime = localObject4.time;
          if ((localObject4.msgtype != -1024) && (localObject4.msgtype != -4011) && (!apib.a(paramQQAppInterface, localObject4)) && (!apib.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) && (!apib.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
            break label1015;
          }
          if ((!alof.H.equals(this.mUser.uin)) && (!alof.I.equals(this.mUser.uin))) {
            break label2163;
          }
          this.mTitleName = paramContext.getString(2131693375);
          this.mMsgExtroInfo = "";
          if (!apib.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) {
            break label1104;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131693391);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
          if (localabta != null) {
            localMsgSummary.strContent = localabta.a(this.mUser.uin, 1001, paramContext.getResources().getString(2131693390), 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",hasUnreadRedPacketMsg]");
          }
          if (localObject4.msgtype != -4011) {
            break label1326;
          }
        }
        try
        {
          localObject1 = new MessageForNearbyRecommenderTips();
          ((MessageForNearbyRecommenderTips)localObject1).msgData = localObject4.msgData;
          ((MessageForNearbyRecommenderTips)localObject1).parse();
          localMsgSummary.strContent = paramContext.getResources().getString(2131694727);
          if ((((MessageForNearbyRecommenderTips)localObject1).strBrief != null) && (!"".equals(((MessageForNearbyRecommenderTips)localObject1).strBrief))) {
            localMsgSummary.strContent = ((MessageForNearbyRecommenderTips)localObject1).strBrief;
          }
          if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
            break label1307;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694728);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
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
            break label2550;
          }
          if (this.mTitleName == null) {
            break label2537;
          }
          paramQQAppInterface = this.mTitleName;
          if (this.mShowTime == null) {
            break label2543;
          }
        }
        label1104:
        label2537:
        label2543:
        for (localObject1 = this.mShowTime;; localObject2 = "")
        {
          paramQQAppInterface = String.format("%s,%s,%d条未读,%s", new Object[] { paramQQAppInterface, localObject1, Integer.valueOf(this.mUnreadNum), paramContext });
          this.mContentDesc = paramQQAppInterface;
          e();
          return;
          this.mUnreadNum = 0;
          break label85;
          if (abti.c(localObject4.senderuin))
          {
            localObject1 = localObject3;
            if (localQQMessageFacade == null) {
              break label2615;
            }
            QQMessageFacade.Message localMessage = localQQMessageFacade.a(localObject4.senderuin, localObject4.istroop);
            localObject1 = localObject3;
            if (localMessage != null)
            {
              localObject3 = bdgc.q(paramQQAppInterface, localMessage.senderuin);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = bdgc.b(paramQQAppInterface, localMessage.senderuin, false);
              }
            }
            break label279;
          }
          localObject3 = bdgc.q(paramQQAppInterface, localObject4.senderuin);
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            break label2615;
          }
          localObject1 = bdgc.b(paramQQAppInterface, localObject4.senderuin, false);
          break label279;
          this.mDisplayTime = 0L;
          break label304;
          label1015:
          boolean bool = false;
          if ((alof.H.equals(this.mUser.uin)) || (alof.I.equals(this.mUser.uin))) {
            bool = true;
          }
          if (localObject4.isSend())
          {
            bdil.a(paramContext, paramQQAppInterface, localObject4, this.mUser.getType(), localMsgSummary, null, bool, false);
            break label377;
          }
          bdil.a(paramContext, paramQQAppInterface, localObject4, this.mUser.getType(), localMsgSummary, (String)localObject1, bool, false);
          break label377;
          if (apib.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))
          {
            this.mMsgExtroInfo = paramContext.getResources().getString(2131694561);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
            if (!QLog.isColorLevel()) {
              break label564;
            }
            QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",hasUnreadGiftMsg]");
            break label564;
          }
          if (!apib.a(paramQQAppInterface, localObject4)) {
            break label564;
          }
          this.mMsgExtroInfo = paramContext.getString(2131699491);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
          if (!QLog.isColorLevel()) {
            break label564;
          }
          QLog.d("Q.msg_box", 2, "recent item update:[uin:" + this.mUser.uin + ",type:" + this.mUser.getType() + ",hasHelloMsg]");
          break label564;
          this.mMsgExtroInfo = "";
          break label678;
          if (localObject4.msgtype == -2053)
          {
            localObject2 = (MessageForNearbyLiveTip)paramQQAppInterface.a().a(localObject4.senderuin, localObject4.istroop, localObject4.uniseq);
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg_box.item_data", 2, "msg.msgtype == MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP, tip = null");
              return;
            }
            ((MessageForNearbyLiveTip)localObject2).parse();
            localMsgSummary.strPrefix = null;
            this.mUnreadFlag = 1;
            localObject3 = paramContext.getResources().getString(2131699550);
            if (!TextUtils.isEmpty(((MessageForNearbyLiveTip)localObject2).c2cMsgWording))
            {
              localMsgSummary.strContent = ((MessageForNearbyLiveTip)localObject2).c2cMsgWording;
              this.mLastMsg = ((MessageForNearbyLiveTip)localObject2).c2cMsgWording;
              break label678;
            }
            if (((MessageForNearbyLiveTip)localObject2).isLiving)
            {
              localMsgSummary.strContent = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
              this.mLastMsg = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
              break label678;
            }
            if (MessageForNearbyLiveTip.isHuayangTip(((MessageForNearbyLiveTip)localObject2).jumpingUrl))
            {
              localMsgSummary.strContent = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).liveEndWording);
              this.mLastMsg = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + ((MessageForNearbyLiveTip)localObject2).liveEndWording);
              break label678;
            }
            localMsgSummary.strContent = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + alud.a(2131713572) + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
            this.mLastMsg = ((String)localObject3 + ((MessageForNearbyLiveTip)localObject2).nickName + alud.a(2131713554) + ((MessageForNearbyLiveTip)localObject2).getSummaryMsg());
            break label678;
          }
          if (localObject4.msgtype == -2055)
          {
            localObject2 = (MessageForInteractAndFollow)paramQQAppInterface.a().a(localObject4.senderuin, localObject4.istroop, localObject4.uniseq);
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg_box.item_data", 2, "interactAndFollow == null");
              return;
            }
            ((MessageForInteractAndFollow)localObject2).parse();
            localMsgSummary.strPrefix = null;
            localMsgSummary.strContent = ((MessageForInteractAndFollow)localObject2).context;
            this.mLastMsg = ((MessageForInteractAndFollow)localObject2).context;
            this.mUnreadNum = localabta.a(this.mUser.uin, this.mUser.getType());
            if ((this.mUnreadNum > 0) || (localabta == null)) {
              break label678;
            }
            this.mUnreadNum = localabta.b();
            this.mUnreadFlag = 3;
            break label678;
          }
          if (localObject4.msgtype == -2068)
          {
            localMsgSummary.strPrefix = null;
            if (localabta == null) {
              break label678;
            }
            this.mUnreadNum = localabta.a(this.mUser.uin, this.mUser.getType());
            this.mUnreadFlag = 1;
            break label678;
          }
          if (localObject4.msgtype == -2070)
          {
            localObject2 = (MessageForYanZhi)paramQQAppInterface.a().b(localObject4.senderuin, localObject4.istroop);
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.msg_box.item_data", 2, "msgForYanZhi == null");
              return;
            }
            ((MessageForYanZhi)localObject2).parse();
            localMsgSummary.strPrefix = null;
            localMsgSummary.strContent = (paramContext.getString(2131694562) + ": " + ((MessageForYanZhi)localObject2).msg);
            if (localabta == null) {
              break label678;
            }
            this.mUnreadNum = localabta.a(this.mUser.uin, this.mUser.getType());
            this.mUnreadFlag = 1;
            break label678;
          }
          if (localQQMessageFacade != null)
          {
            this.mUnreadFlag = 1;
            this.mUnreadNum = localabta.a(this.mUser.uin, this.mUser.getType());
            if ((this.mUnreadNum <= 0) && (localabta != null))
            {
              this.mUnreadNum = localabta.b();
              this.mUnreadFlag = 3;
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (apib.a(paramQQAppInterface, this.mUser.uin, this.mUser.getType())) || (!apib.b(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
            break label678;
          }
          localMsgSummary.strContent = paramContext.getString(2131693373);
          break label678;
          label2163:
          if (alof.ab.equals(this.mUser.uin))
          {
            this.mTitleName = paramContext.getString(2131699157);
            if (localQQMessageFacade != null)
            {
              this.mUnreadFlag = 1;
              this.mUnreadNum = localabta.a(this.mUser.uin, this.mUser.getType());
              if ((this.mUnreadNum <= 0) && (localabta != null))
              {
                this.mUnreadNum = localabta.a(alof.ak, this.mUser.getType());
                this.mUnreadFlag = 3;
              }
            }
            if ((localObject4.msg == null) || (-999 == localObject4.msgtype))
            {
              localMsgSummary.strContent = paramContext.getString(2131699161);
              localObject3 = localObject2;
            }
            for (;;)
            {
              apib.a("data_recent_msg", new Object[] { localObject3, localMsgSummary.strContent });
              break;
              localObject3 = localObject2;
              if (localObject4.msgtype == -1024)
              {
                localObject3 = localObject2;
                if (localObject2 != null)
                {
                  localObject3 = localObject2;
                  if (((String)localObject2).length() > 12) {
                    localObject3 = ((String)localObject2).substring(0, 11) + "...";
                  }
                }
                if (localObject4.isSendFromLocal()) {
                  localMsgSummary.strContent = paramContext.getString(2131699160, new Object[] { localObject3 });
                } else {
                  localMsgSummary.strContent = paramContext.getString(2131699159, new Object[] { localObject3 });
                }
              }
            }
          }
          if (alof.w.equals(this.mUser.uin))
          {
            this.mTitleName = paramContext.getString(2131719307);
            if (localQQMessageFacade != null) {
              this.mUnreadNum = localQQMessageFacade.d();
            }
            if ((-999 != localObject4.msgtype) && (localObject4.msg != null)) {
              break label678;
            }
            localMsgSummary.strContent = paramContext.getString(2131719305);
            break label678;
          }
          this.mTitleName = bdgc.b(paramQQAppInterface, this.mUser.uin, true);
          break label678;
          paramQQAppInterface = "";
          break label821;
        }
        label2550:
        if (this.mTitleName != null)
        {
          paramQQAppInterface = this.mTitleName;
          if (this.mShowTime == null) {
            break label2608;
          }
        }
        for (localObject2 = this.mShowTime;; localObject2 = "")
        {
          paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, localObject2, paramContext });
          break;
          paramQQAppInterface = "";
          break label2562;
        }
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox
 * JD-Core Version:    0.7.0.1
 */