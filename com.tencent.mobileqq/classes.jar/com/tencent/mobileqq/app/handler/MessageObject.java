package com.tencent.mobileqq.app.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MessageObject
{
  public int a;
  public FromServiceMsg a;
  public ToServiceMsg a;
  public Object a;
  public boolean a;
  
  public MessageObject(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this(paramInt, paramToServiceMsg, paramFromServiceMsg, paramObject, false);
  }
  
  public MessageObject(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.MessageObject
 * JD-Core Version:    0.7.0.1
 */