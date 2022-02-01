package com.tencent.ilivesdk.giftservice_interface.model;

import android.graphics.Point;
import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import java.util.ArrayList;
import java.util.List;

public class GiftMessage
{
  public static final int CONSUME_LIMIT = 22;
  public static final int GIFT_TYPE_COMBO = 101;
  public static final int LUXURY_GIFT_TYPE = 104;
  public static final int SEND_GIFT_OVER_TYPE = 5;
  public static final int SEND_GIFT_TYPE = 4;
  public long mAnchorId;
  public String mAnchorNickName;
  public int mBalance;
  public String mBusinessUid;
  public boolean mCanShowLuxuryAnimation;
  public int mComboCount;
  public long mComboSeq;
  public byte[] mConsumerHeadKey;
  public long mConsumerId;
  public String mConsumerLogoUrl;
  public String mConsumerNickName;
  public List<Point> mCustomizedPoints;
  public int mFromType;
  public String mGiftIconUrl = "";
  public int mGiftId;
  public String mGiftName;
  public int mGiftNum;
  public int mGiftType;
  public long mHeadTimestamp;
  public long mLogoTimestamp;
  public int mMessageType;
  public ArrayList<GiftMessage.TransparentMsg> mMsgComTrans = new ArrayList();
  public MsgExtInfo mMsgExtInfo;
  public String mPlayNickname;
  public long mPlayUid;
  public long mRecvTime;
  public long mRoomId;
  public int mSubGiftType;
  public long mSubRoomId;
  public int mUserClientType;
  public int sendGiftErrorCode;
  public String sendGiftErrorMsg;
  
  public String dump()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playuin:");
    localStringBuilder.append(this.mPlayUid);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(this.mConsumerId);
    localStringBuilder.append(" gifttype");
    localStringBuilder.append(this.mGiftType);
    localStringBuilder.append(" roomid:");
    localStringBuilder.append(this.mRoomId);
    localStringBuilder.append(" subroomid:");
    localStringBuilder.append(this.mSubRoomId);
    localStringBuilder.append(" giftid:");
    localStringBuilder.append(this.mGiftId);
    localStringBuilder.append(" giftnum:");
    localStringBuilder.append(this.mGiftNum);
    localStringBuilder.append(" combseq:");
    localStringBuilder.append(this.mComboSeq);
    localStringBuilder.append(" combcount:");
    localStringBuilder.append(this.mComboCount);
    localStringBuilder.append(" points:");
    List localList = this.mCustomizedPoints;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.model.GiftMessage
 * JD-Core Version:    0.7.0.1
 */