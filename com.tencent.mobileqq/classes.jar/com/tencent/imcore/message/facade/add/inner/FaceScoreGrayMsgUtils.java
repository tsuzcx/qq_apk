package com.tencent.imcore.message.facade.add.inner;

import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FaceScoreGrayMsgUtils
{
  public static void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (MessageRecord)localIterator.next();
      if ((localObject1 instanceof MessageForStructing))
      {
        paramList = (MessageForStructing)localObject1;
        if ((paramList.structingMsg != null) && (paramList.structingMsg.mMsgServiceID == 98))
        {
          MsgProxyUtils.a(paramList, false);
          Object localObject2 = (NearbyGrayTipsManager)paramQQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = ");
            ((StringBuilder)localObject3).append(paramList);
            QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
          IFaceScoreUtils localIFaceScoreUtils = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
          boolean bool2 = ((IFaceScoreUtils)localObject3).getFaceScoreFlag(paramList, "isFaceScoreSecondMember");
          localObject2 = ((NearbyGrayTipsManager)localObject2).b(1, 2, ((MessageRecord)localObject1).time);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = ");
            ((StringBuilder)localObject3).append(bool2);
            ((StringBuilder)localObject3).append(", configForFaceScore = ");
            ((StringBuilder)localObject3).append(localObject2);
            QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject3).toString());
          }
          if (localObject2 != null)
          {
            int i = StructMsgItemLayout26.d(paramList.structingMsg.mExtraData);
            paramList = new Random();
            paramList.setSeed(((MessageRecord)localObject1).time);
            boolean bool1;
            if ((i & 0x4) != 0) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1)
            {
              if (bool2) {
                paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).getFavoriteGrayTipWording1(paramList);
              } else {
                paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).getFavoriteGrayTipWording2(paramList);
              }
            }
            else {
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).getGrayTipWording(paramList);
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("QQMessageFacade.addMultiMessagesInner  getGrayTipWording, wording = ");
              ((StringBuilder)localObject3).append(paramList);
              QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject3).toString());
            }
            if ((paramList != null) && (!TextUtils.isEmpty(paramList.text)))
            {
              localObject2 = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, paramList.text, paramList.highlightText, 16, ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).url, 1);
              paramList = MessageRecordFactory.a(-2027);
              paramList.init(((MessageRecord)localObject1).selfuin, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).selfuin, (String)localObject2, ((MessageRecord)localObject1).time - 1L, -2027, 1001, ((MessageRecord)localObject1).time - 1L);
              paramList.isread = true;
              localObject2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              localObject3 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              ((IFaceScoreUtils)localObject2).setFaceScoreFlag(paramList, "isFaceScoreGrayTips", true);
              localObject2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              localObject3 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              ((IFaceScoreUtils)localObject2).setFaceScoreFlag(paramList, "isFaceScoreSecondMember", bool2);
              localObject2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              localObject3 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              ((IFaceScoreUtils)localObject2).setFaceScoreFlag(paramList, "isFaceScoreSpecialLike", bool1);
              MsgProxyUtils.a(paramList, false);
              paramQQMessageFacade.a(paramList, ((MessageRecord)localObject1).selfuin);
              if (!QLog.isColorLevel()) {
                continue;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("QQMessageFacade.addMultiMessagesInner insert faceScore gray tips., msg = ");
              ((StringBuilder)localObject1).append(paramList);
              QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject1).toString());
              continue;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.FaceScoreGrayMsgUtils
 * JD-Core Version:    0.7.0.1
 */