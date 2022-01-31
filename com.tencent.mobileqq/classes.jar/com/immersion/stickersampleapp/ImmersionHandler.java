package com.immersion.stickersampleapp;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRReq;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.ReqBody;

public class ImmersionHandler
  extends BusinessHandler
{
  private ImmerIConnectionProxy jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ImmersionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(ImmerIConnectionProxy paramImmerIConnectionProxy)
  {
    this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy = paramImmerIConnectionProxy;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImmersionHandler", 2, "HapticMediaPlayer start request");
    }
    oidb_0xa4d.IMMRReq localIMMRReq = new oidb_0xa4d.IMMRReq();
    localIMMRReq.str_url.set(paramString);
    paramString = new oidb_0xa4d.ReqBody();
    paramString.msg_immr_req.set(localIMMRReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ImmersionHandler.ImmersionObserver(false, this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy), paramString.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.ImmersionHandler
 * JD-Core Version:    0.7.0.1
 */