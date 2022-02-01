package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IPUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0xed4Params;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.SecurityInfo;

public class RIJCoinInfoModule
  extends ReadInJoyEngineModule
{
  private HashMap<Integer, RIJCoinInfoModule.RequestHandler> a;
  
  public RIJCoinInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    b();
  }
  
  private RIJCoinInfoModule.RequestHandler a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      return (RIJCoinInfoModule.RequestHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  private void a(RIJCoinInfoModule.RequestHandler paramRequestHandler)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (paramRequestHandler == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramRequestHandler.a()), paramRequestHandler);
  }
  
  private void a(oidb_cmd0xed4.ReqBody paramReqBody)
  {
    Object localObject = new oidb_cmd0xed4.MetaData();
    ((oidb_cmd0xed4.MetaData)localObject).timestamp.set(NetConnInfoCenter.getServerTimeMillis() / 1000L);
    paramReqBody.meta.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xed4.SecurityInfo();
    ((oidb_cmd0xed4.SecurityInfo)localObject).nickname.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname());
    if (!TextUtils.isEmpty(DeviceInfoUtil.b())) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).device_id.set(DeviceInfoUtil.b());
    }
    String str = IPUtils.a(BaseApplicationImpl.getContext());
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).ip.set(str);
    }
    str = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty(str)) {
      ((oidb_cmd0xed4.SecurityInfo)localObject).terminal_id.set(str);
    }
    ((oidb_cmd0xed4.SecurityInfo)localObject).os_type.set(2);
    ((oidb_cmd0xed4.SecurityInfo)localObject).app_version.set("8.5.5");
    paramReqBody.security_info.set((MessageMicro)localObject);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    a(new RIJCoinInfoModule.CoinQueryRequestHandler());
    a(new RIJCoinInfoModule.CoinPresentRequestHandler());
    a(new RIJCoinInfoModule.CoinRewardRequestHandler());
    a(new RIJCoinInfoModule.ContentCoinCheckRequestHandler());
    a(new RIJCoinInfoModule.ContentCoinNumQueryRequestHandler());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xed4.RspBody localRspBody = new oidb_cmd0xed4.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("RequestType");
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.e("RIJCoinInfoModule", 2, "handle0xed4CoinInfoResp error, result:" + i);
    }
    int j = localRspBody.retcode.get();
    paramObject = localRspBody.retmsg.get();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, new Object[] { "handle0xed4CoinInfoResp result = ", i + ", requestType=" + paramFromServiceMsg + ", retCode=" + j + ", retMsg=" + paramObject });
    }
    RIJCoinInfoModule.RequestHandler localRequestHandler = a(paramFromServiceMsg.intValue());
    if (localRequestHandler == null)
    {
      QLog.e("RIJCoinInfoModule", 1, "dispatch0xed4Resp() cant find requestHandler, requestType=" + paramFromServiceMsg);
      return;
    }
    localRequestHandler.a(paramToServiceMsg, localRspBody, i, j, paramObject);
  }
  
  public void a() {}
  
  public void a(ReadInJoyRequestParams.Request0xed4Params paramRequest0xed4Params)
  {
    if (paramRequest0xed4Params == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo params == null");
      }
    }
    RIJCoinInfoModule.RequestHandler localRequestHandler;
    do
    {
      return;
      try
      {
        oidb_cmd0xed4.ReqBody localReqBody = new oidb_cmd0xed4.ReqBody();
        localRequestHandler = a(paramRequest0xed4Params.jdField_a_of_type_Int);
        if (localRequestHandler != null) {
          break;
        }
        QLog.e("RIJCoinInfoModule", 1, "request0xed4CoinInfo cant find requestHandler, requestType=" + paramRequest0xed4Params.jdField_a_of_type_Int);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("RIJCoinInfoModule", 2, "request0xed4CoinInfo failed. type=" + paramRequest0xed4Params.jdField_a_of_type_Int + ", rowkey=" + paramRequest0xed4Params.jdField_a_of_type_JavaLangString, localThrowable);
    return;
    a(localThrowable);
    localRequestHandler.a(paramRequest0xed4Params, localThrowable);
    Object localObject = localThrowable.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCoinInfoModule", 2, "request0xed4CoinInfo requestType:" + paramRequest0xed4Params.jdField_a_of_type_Int + ", toByteArray size=" + localObject.length);
    }
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xed4", 3796, 1, (byte[])localObject);
    ((ToServiceMsg)localObject).getAttributes().put("RequestType", Integer.valueOf(paramRequest0xed4Params.jdField_a_of_type_Int));
    if (!TextUtils.isEmpty(paramRequest0xed4Params.jdField_a_of_type_JavaLangString)) {
      ((ToServiceMsg)localObject).getAttributes().put("RequestRowkey", paramRequest0xed4Params.jdField_a_of_type_JavaLangString);
    }
    a((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xed4")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule
 * JD-Core Version:    0.7.0.1
 */