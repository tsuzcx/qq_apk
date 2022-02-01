package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;

class OnLinePushMessageProcessor$HandleShMsgType0x08
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public OnLinePushMessageProcessor$HandleShMsgType0x08(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, String paramString)
  {
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public HandleShMsgType0x08 a()
  {
    byte[] arrayOfByte = new byte[4];
    if (this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length > 4) {
      PkgTools.copyData(arrayOfByte, 0, this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg, 0, 4);
    }
    this.jdField_a_of_type_Long = PkgTools.getLongData(arrayOfByte, 0);
    if (this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length >= 9)
    {
      arrayOfByte = new byte[this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length - 9];
      PkgTools.copyData(arrayOfByte, 0, this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg, 8, arrayOfByte.length);
      this.jdField_a_of_type_JavaLangString = new String(EmotionCodecUtils.a(arrayOfByte), "utf-8");
    }
    this.jdField_a_of_type_Int = 1000;
    this.b = -1000;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgType0x08
 * JD-Core Version:    0.7.0.1
 */