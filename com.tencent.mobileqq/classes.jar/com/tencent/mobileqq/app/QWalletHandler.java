package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqBody;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqInfo;
import tencent.im.oidb.cmd0x438.oidb_0x438.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QWalletHandler
  extends BusinessHandler
{
  protected QWalletHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QWalletHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, List<oidb_0x438.ReqInfo> paramList)
  {
    Object localObject = new oidb_0x438.ReqBody();
    ((oidb_0x438.ReqBody)localObject).stReqInfo.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1080);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(paramInt);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x438.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x438");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QWalletObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletHandler", 4, "onReceive");
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isDevelopLevel())
    {
      QLog.i("QWalletHandler", 4, "cmd=" + str);
      QLog.i("QWalletHandler", 4, "data length =" + ((byte[])paramObject).length);
    }
    if (TextUtils.isEmpty(str)) {}
    do
    {
      do
      {
        return;
      } while (str.compareTo("OidbSvc.0x438") != 0);
      paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramToServiceMsg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QWalletHandler", 2, "onReceive: ssoPkg parse failed");
    return;
    paramFromServiceMsg = new oidb_0x438.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramFromServiceMsg.PasswdRedBag.get();
      if (paramFromServiceMsg != null)
      {
        notifyUI(paramToServiceMsg.uint32_service_type.get(), true, paramFromServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      notifyUI(paramToServiceMsg.uint32_service_type.get(), false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletHandler
 * JD-Core Version:    0.7.0.1
 */