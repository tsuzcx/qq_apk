package com.tencent.ilivesdk.giftservice;

import android.graphics.Point;
import com.tencent.falco.base.libapi.channel.PushCallback;
import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice.util.InBuffer;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.ReceiveGiftMessageListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage.TransparentMsg;
import com.tencent.protobuf.payGiftSvr.nano.BroadcastPersonGift;
import com.tencent.protobuf.payGiftSvr.nano.ILiveGiftSite;
import com.tencent.protobuf.payGiftSvr.nano.TransparentMsg;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class GiftService$1
  implements PushCallback
{
  GiftService$1(GiftService paramGiftService) {}
  
  private boolean isSelfMsg(GiftMessage paramGiftMessage)
  {
    return paramGiftMessage.mConsumerId == this.this$0.getServiceAdapter().getAccountUin();
  }
  
  public void onRecv(int paramInt, byte[] paramArrayOfByte, MsgExtInfo paramMsgExtInfo)
  {
    paramArrayOfByte = new InBuffer(paramArrayOfByte);
    try
    {
      paramInt = (int)paramArrayOfByte.readInt();
      if ((paramInt != 1011) && (paramInt != 3011)) {
        return;
      }
      paramArrayOfByte.readInt();
      Object localObject1 = new byte[paramArrayOfByte.readShort()];
      paramArrayOfByte.readBuffer((byte[])localObject1);
      paramArrayOfByte = new InBuffer((byte[])localObject1);
      if (paramArrayOfByte.readByte() != 4) {
        return;
      }
      localObject1 = new byte[paramArrayOfByte.readShort()];
      paramArrayOfByte.readBuffer((byte[])localObject1);
      localObject1 = BroadcastPersonGift.parseFrom((byte[])localObject1);
      paramArrayOfByte = new GiftMessage();
      paramArrayOfByte.mMessageType = 4;
      paramArrayOfByte.mGiftType = ((BroadcastPersonGift)localObject1).giftType;
      paramArrayOfByte.mConsumerId = ((BroadcastPersonGift)localObject1).dwUserUin;
      paramArrayOfByte.mConsumerHeadKey = ((BroadcastPersonGift)localObject1).headKey;
      paramArrayOfByte.mConsumerLogoUrl = new String(((BroadcastPersonGift)localObject1).logoFullUrl, StandardCharsets.UTF_8);
      paramArrayOfByte.mHeadTimestamp = ((BroadcastPersonGift)localObject1).logoTimestamp;
      paramArrayOfByte.mConsumerNickName = new String(((BroadcastPersonGift)localObject1).userQtName, StandardCharsets.UTF_8);
      paramArrayOfByte.mAnchorId = ((BroadcastPersonGift)localObject1).dwAnchorUin;
      paramArrayOfByte.mAnchorNickName = new String(((BroadcastPersonGift)localObject1).anchorQtName, StandardCharsets.UTF_8);
      paramArrayOfByte.mPlayUid = ((BroadcastPersonGift)localObject1).playUid;
      paramArrayOfByte.mPlayNickname = new String(((BroadcastPersonGift)localObject1).playNickname, StandardCharsets.UTF_8);
      if (paramArrayOfByte.mPlayUid <= 0L)
      {
        paramArrayOfByte.mPlayUid = paramArrayOfByte.mAnchorId;
        paramArrayOfByte.mPlayNickname = paramArrayOfByte.mAnchorNickName;
      }
      paramArrayOfByte.mRoomId = ((BroadcastPersonGift)localObject1).roomId;
      paramArrayOfByte.mSubRoomId = ((BroadcastPersonGift)localObject1).subRoomId;
      paramArrayOfByte.mGiftNum = ((BroadcastPersonGift)localObject1).giftNum;
      paramArrayOfByte.mGiftId = ((BroadcastPersonGift)localObject1).giftId;
      paramArrayOfByte.mRecvTime = System.currentTimeMillis();
      paramArrayOfByte.mSubGiftType = ((BroadcastPersonGift)localObject1).fromType;
      paramArrayOfByte.mBusinessUid = new String(((BroadcastPersonGift)localObject1).userBusinessUid, StandardCharsets.UTF_8);
      paramArrayOfByte.mUserClientType = ((BroadcastPersonGift)localObject1).clientType;
      int i;
      if (((BroadcastPersonGift)localObject1).iLiveGiftSites.length > 0)
      {
        localObject2 = new ArrayList(((BroadcastPersonGift)localObject1).iLiveGiftSites.length);
        localObject3 = ((BroadcastPersonGift)localObject1).iLiveGiftSites;
        i = localObject3.length;
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject4 = localObject3[paramInt];
          Point localPoint = new Point();
          localPoint.set(localObject4.x, localObject4.y);
          ((List)localObject2).add(localPoint);
          paramInt += 1;
        }
        paramArrayOfByte.mCustomizedPoints = ((List)localObject2);
      }
      paramArrayOfByte.mComboSeq = ((BroadcastPersonGift)localObject1).comboSeq;
      paramArrayOfByte.mComboCount = ((BroadcastPersonGift)localObject1).comboCount;
      Object localObject2 = this.this$0.getServiceAdapter().getLogger();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("giftMessage.mComboSeq = ");
      ((StringBuilder)localObject3).append(paramArrayOfByte.mComboSeq);
      ((StringBuilder)localObject3).append(" giftMessage.mComboCount = ");
      ((StringBuilder)localObject3).append(paramArrayOfByte.mComboCount);
      ((LogInterface)localObject2).i("GiftService", ((StringBuilder)localObject3).toString(), new Object[0]);
      if (((BroadcastPersonGift)localObject1).msgComTrans.length > 0)
      {
        localObject1 = ((BroadcastPersonGift)localObject1).msgComTrans;
        i = localObject1.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = localObject1[paramInt];
          paramArrayOfByte.getClass();
          localObject3 = new GiftMessage.TransparentMsg(paramArrayOfByte);
          ((GiftMessage.TransparentMsg)localObject3).msgType = ((TransparentMsg)localObject2).msgType;
          ((GiftMessage.TransparentMsg)localObject3).msgData = ((TransparentMsg)localObject2).msgData;
          paramArrayOfByte.mMsgComTrans.add(localObject3);
          paramInt += 1;
        }
      }
      paramArrayOfByte.mMsgExtInfo = paramMsgExtInfo;
      paramMsgExtInfo = this.this$0.getServiceAdapter().getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onbroacastgift ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.dump());
      paramMsgExtInfo.i("GiftService", ((StringBuilder)localObject1).toString(), new Object[0]);
      paramMsgExtInfo = this.this$0.getServiceAdapter().getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("giftMessage.mComboCount ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.mComboCount);
      paramMsgExtInfo.d("GiftService", ((StringBuilder)localObject1).toString(), new Object[0]);
      if (isSelfMsg(paramArrayOfByte)) {
        return;
      }
      paramMsgExtInfo = GiftService.access$000(this.this$0).iterator();
      while (paramMsgExtInfo.hasNext()) {
        ((GiftServiceInterface.ReceiveGiftMessageListener)paramMsgExtInfo.next()).onGiftMessageReceive(paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.1
 * JD-Core Version:    0.7.0.1
 */