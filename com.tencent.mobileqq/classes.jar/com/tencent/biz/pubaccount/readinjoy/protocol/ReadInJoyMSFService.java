package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import lwj;
import lwk;
import mqq.app.AppRuntime;

public class ReadInJoyMSFService
{
  private static ReadInJoyMSFService jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService;
  private int jdField_a_of_type_Int;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static ReadInJoyMSFService a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = new ReadInJoyMSFService();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttributes().get("seq");
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      } while (localObject == null);
      localObject = (ReadInJoyEngineModule)((WeakReference)localObject).get();
    } while (localObject == null);
    ((ReadInJoyEngineModule)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new lwk(this, paramToServiceMsg);
    ReadInJoyUtils.a().post(paramToServiceMsg);
  }
  
  public final void a(ToServiceMsg paramToServiceMsg, ReadInJoyEngineModule paramReadInJoyEngineModule)
  {
    if ((paramToServiceMsg == null) || (paramReadInJoyEngineModule == null)) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramReadInJoyEngineModule = new WeakReference(paramReadInJoyEngineModule);
    ReadInJoyUtils.a().post(new lwj(this, paramToServiceMsg, paramReadInJoyEngineModule));
    a(paramToServiceMsg);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    Object localObject = null;
    if (paramToServiceMsg == null) {
      return;
    }
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("ReadInJoy", 4, "bPbResp:" + bool);
      }
      paramException = localObject;
      if (paramBoolean)
      {
        if (!bool) {
          break label474;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyMSFService", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localObject;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          PkgTools.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramException);
      return;
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = ReadInJoyUtils.a().getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if (paramException != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramException.printStackTrace(new PrintStream(localByteArrayOutputStream));
        paramException = new String(localByteArrayOutputStream.toByteArray());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyMSFService", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      break;
      label474:
      if (0 != 0) {}
      try
      {
        throw new NullPointerException();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramException = localObject;
      }
      paramException = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyMSFService", 2, "bpc null");
        paramException = localObject;
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyMSFService", 2, "", localException);
          paramException = localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService
 * JD-Core Version:    0.7.0.1
 */