package com.tencent.imcore.message;

import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

class OnLinePushMessageProcessor$HandleShMsgType0xe6
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public OnLinePushMessageProcessor$HandleShMsgType0xe6(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public HandleShMsgType0xe6 a()
  {
    this.jdField_a_of_type_JavaLangString = new String(EmotionCodecUtils.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg), "utf-8");
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("");
    localObject = ((FriendsManager)localObject).e(localStringBuilder.toString());
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      this.jdField_a_of_type_Int = 0;
    }
    else
    {
      localObject = ((IPhoneContactService)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(String.valueOf(this.jdField_a_of_type_Long));
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        this.jdField_a_of_type_Int = 1006;
      } else {
        this.jdField_a_of_type_Int = 1000;
      }
    }
    localObject = new SafeMsg.SafeMoreInfo();
    ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(this.jdField_a_of_type_OnlinePushPackMsgInfo.strFromMobile);
    ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(this.jdField_a_of_type_OnlinePushPackMsgInfo.strFromName);
    ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ArrayOfByte = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
    this.jdField_b_of_type_Int = -1002;
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.HandleShMsgType0xe6
 * JD-Core Version:    0.7.0.1
 */