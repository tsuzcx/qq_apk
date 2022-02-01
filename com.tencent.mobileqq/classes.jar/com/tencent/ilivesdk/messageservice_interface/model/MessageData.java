package com.tencent.ilivesdk.messageservice_interface.model;

import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;

public class MessageData
{
  public static final int ENTER_ROOM_MSG_TYPE = 3;
  public static final int E_BUY_MESSAGE = 6;
  public static final int FOLLOW_ANCHOR_MESSAGE = 5;
  public static final int GIFT_MSG_TYPE = 2;
  public static final int MSG_ELEMENT_IMAGE_TYPE = 2;
  public static final int MSG_ELEMENT_TEXT_TYPE = 1;
  public static final int NORMAL_CHAT_MESSAGE = 33;
  public static final int NORMAL_CHAT_TEXT_MSG_TYPE = 1;
  public static final int SYSTEM_NOTICE_MESSAGE = 4;
  public String mEBuyProgramId;
  public String mEBuyScreenMsg;
  public int mEBuyType;
  public MessageData.GiftInfo mGiftInfo = new MessageData.GiftInfo(this);
  public int mMainRoomId;
  public String mMessageId;
  public int mMessageType;
  public MsgExtInfo mMsgExtInfo;
  public String mRawTipStr;
  public MessageData.SpeakerInfo mSpeakerInfo = new MessageData.SpeakerInfo(this);
  public int mSubRoomId;
  public MessageData.MsgContent msgContent = new MessageData.MsgContent(this);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.messageservice_interface.model.MessageData
 * JD-Core Version:    0.7.0.1
 */