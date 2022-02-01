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
    int i = 0;
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
      switch (paramArrayOfByte.readByte())
      {
      case 4: 
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
        ArrayList localArrayList;
        Object localObject2;
        int j;
        if (((BroadcastPersonGift)localObject1).iLiveGiftSites.length > 0)
        {
          localArrayList = new ArrayList(((BroadcastPersonGift)localObject1).iLiveGiftSites.length);
          localObject2 = ((BroadcastPersonGift)localObject1).iLiveGiftSites;
          j = localObject2.length;
          paramInt = 0;
          while (paramInt < j)
          {
            Object localObject3 = localObject2[paramInt];
            Point localPoint = new Point();
            localPoint.set(localObject3.x, localObject3.y);
            localArrayList.add(localPoint);
            paramInt += 1;
          }
          paramArrayOfByte.mCustomizedPoints = localArrayList;
        }
        paramArrayOfByte.mComboSeq = ((BroadcastPersonGift)localObject1).comboSeq;
        paramArrayOfByte.mComboCount = ((BroadcastPersonGift)localObject1).comboCount;
        this.this$0.getServiceAdapter().getLogger().i("GiftService", "giftMessage.mComboSeq = " + paramArrayOfByte.mComboSeq + " giftMessage.mComboCount = " + paramArrayOfByte.mComboCount, new Object[0]);
        if (((BroadcastPersonGift)localObject1).msgComTrans.length > 0)
        {
          localObject1 = ((BroadcastPersonGift)localObject1).msgComTrans;
          j = localObject1.length;
          paramInt = i;
          while (paramInt < j)
          {
            localArrayList = localObject1[paramInt];
            paramArrayOfByte.getClass();
            localObject2 = new GiftMessage.TransparentMsg(paramArrayOfByte);
            ((GiftMessage.TransparentMsg)localObject2).msgType = localArrayList.msgType;
            ((GiftMessage.TransparentMsg)localObject2).msgData = localArrayList.msgData;
            paramArrayOfByte.mMsgComTrans.add(localObject2);
            paramInt += 1;
          }
        }
        paramArrayOfByte.mMsgExtInfo = paramMsgExtInfo;
        this.this$0.getServiceAdapter().getLogger().i("GiftService", "onbroacastgift " + paramArrayOfByte.dump(), new Object[0]);
        this.this$0.getServiceAdapter().getLogger().d("GiftService", "giftMessage.mComboCount " + paramArrayOfByte.mComboCount, new Object[0]);
        if (!isSelfMsg(paramArrayOfByte))
        {
          paramMsgExtInfo = GiftService.access$000(this.this$0).iterator();
          while (paramMsgExtInfo.hasNext()) {
            ((GiftServiceInterface.ReceiveGiftMessageListener)paramMsgExtInfo.next()).onGiftMessageReceive(paramArrayOfByte);
          }
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.1
 * JD-Core Version:    0.7.0.1
 */