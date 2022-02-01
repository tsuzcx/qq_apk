package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;

class RIJLimitFriendHandler$1
  implements Runnable
{
  RIJLimitFriendHandler$1(RIJLimitFriendHandler paramRIJLimitFriendHandler, String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_TencentImOidbCmd0xbd6Oidb_cmd0xbd6$RspBody, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJLimitFriendHandler.1
 * JD-Core Version:    0.7.0.1
 */