import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterRequest;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;

class atiq
  implements VSDispatchObserver.onVSRspCallBack
{
  atiq(atip paramatip, MethodChannel.Result paramResult) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    paramObject = paramVSBaseRequest.getCmdName();
    QLog.i("flutter.QQCircleChannelHandler", 1, "[sendSsoRequest][onReceive] cmd=" + paramObject + ", success=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (!(paramVSBaseRequest instanceof QCircleFlutterRequest))
    {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[onReceive] invalid request, request=" + paramVSBaseRequest);
      return;
    }
    byte[] arrayOfByte = ((QCircleFlutterRequest)paramVSBaseRequest).getResponseByteData();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cmd", paramObject);
    localHashMap.put("isSuc", Boolean.valueOf(paramBoolean));
    localHashMap.put("errCode", Long.valueOf(paramLong));
    localHashMap.put("errDesc", paramString);
    localHashMap.put("body", arrayOfByte);
    localHashMap.put("ssoSeq", Integer.valueOf(paramVSBaseRequest.getCurrentSeq()));
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.success(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atiq
 * JD-Core Version:    0.7.0.1
 */