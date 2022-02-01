package com.immersion.stickersampleapp;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
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
  private QQAppInterface a;
  private ImmerIConnectionProxy b;
  
  public ImmersionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a(ImmerIConnectionProxy paramImmerIConnectionProxy)
  {
    this.b = paramImmerIConnectionProxy;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImmersionHandler", 2, "HapticMediaPlayer start request");
    }
    oidb_0xa4d.IMMRReq localIMMRReq = new oidb_0xa4d.IMMRReq();
    localIMMRReq.str_url.set(paramString);
    paramString = new oidb_0xa4d.ReqBody();
    paramString.msg_immr_req.set(localIMMRReq);
    ProtoUtils.a(this.a, new ImmersionHandler.ImmersionObserver(false, this.b), paramString.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.ImmersionHandler
 * JD-Core Version:    0.7.0.1
 */