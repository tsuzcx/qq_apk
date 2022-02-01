package com.tencent.biz.richframework.network.servlet;

import android.content.Intent;
import android.support.annotation.CallSuper;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class VSBaseServlet
  extends MSFServlet
{
  public static final String KEY_NETWORK_TIME_COST = "key_network_time_cost";
  public static final String KEY_REQUEST = "key_request";
  public static final String KEY_REQUEST_DATA = "key_request_data";
  public static final String KEY_RESPONSE_MSG = "key_response_msg";
  public static final String KEY_SEND_TIMESTAMP = "key_send_timestamp";
  public static final String SECONDARY_VS_TIME_OUT_TIME = "secondary_vs_time_out_time";
  private static final long TIMEOUT_TIME = QCircleConfig.getInstance().getConfigValue("qqcircle", "secondary_vs_time_out_time", Integer.valueOf(20000)).intValue();
  public static final int VS_TIME_OUT_TIME_DEFAULT_VALUE = 20000;
  
  @CallSuper
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = (BaseRequest)paramIntent.getSerializableExtra("key_request");
    if (paramIntent == null)
    {
      QLog.e("VSNetworkHelper", 1, "onReceive. KEY_REQUEST_DATA is Null.");
      return;
    }
    if ((paramIntent instanceof VSBaseRequest))
    {
      VSBaseRequest localVSBaseRequest = (VSBaseRequest)paramIntent;
      localVSBaseRequest.setSsoResultCode(paramFromServiceMsg.getResultCode());
      localVSBaseRequest.setSsoFailMsg(paramFromServiceMsg.getBusinessFailMsg());
      localVSBaseRequest.setNetworkTimeCost(System.currentTimeMillis() - paramIntent.getSendTimeStamp());
      localVSBaseRequest.setSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
    }
    VSNetworkHelper.getDispatchObserver().onReceive(paramIntent.getContextHashCode(), paramFromServiceMsg.isSuccess(), paramIntent, paramFromServiceMsg.getWupBuffer());
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    BaseRequest localBaseRequest = (BaseRequest)paramIntent.getSerializableExtra("key_request");
    byte[] arrayOfByte2 = (byte[])paramIntent.getSerializableExtra("key_request_data");
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramIntent.putExtra("key_send_timestamp", System.currentTimeMillis());
    paramPacket.setSSOCommand(localBaseRequest.getCmdName());
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(TIMEOUT_TIME);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.VSBaseServlet
 * JD-Core Version:    0.7.0.1
 */