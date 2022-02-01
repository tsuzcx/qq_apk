package com.tencent.ilivesdk.giftservice_interface.model;

import android.graphics.Point;
import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import java.util.ArrayList;
import java.util.List;

public class GiftMessage
{
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
  
  public String dump()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("playuin:").append(this.mPlayUid).append(" uin:").append(this.mConsumerId).append(" gifttype").append(this.mGiftType).append(" roomid:").append(this.mRoomId).append(" subroomid:").append(this.mSubRoomId).append(" giftid:").append(this.mGiftId).append(" giftnum:").append(this.mGiftNum).append(" combseq:").append(this.mComboSeq).append(" combcount:").append(this.mComboCount).append(" points:");
    if (this.mCustomizedPoints != null) {}
    for (int i = this.mCustomizedPoints.size();; i = 0)
    {
      localStringBuilder2.append(i);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.model.GiftMessage
 * JD-Core Version:    0.7.0.1
 */