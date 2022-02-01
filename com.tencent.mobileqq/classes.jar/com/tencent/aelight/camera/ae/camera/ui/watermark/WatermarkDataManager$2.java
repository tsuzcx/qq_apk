package com.tencent.aelight.camera.ae.camera.ui.watermark;

import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StWatermarkDict;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class WatermarkDataManager$2
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StGetWatermarkDictRsp>
{
  WatermarkDataManager$2(WatermarkDataManager paramWatermarkDataManager, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String arg5, CLIENT.StGetWatermarkDictRsp paramStGetWatermarkDictRsp)
  {
    if (paramBoolean)
    {
      ??? = paramStGetWatermarkDictRsp.vecWatermarkDict.get();
      paramBaseRequest = new HashMap();
      ??? = ???.iterator();
      while (???.hasNext())
      {
        paramStGetWatermarkDictRsp = (CLIENT.StWatermarkDict)???.next();
        paramBaseRequest.put(paramStGetWatermarkDictRsp.key.get(), paramStGetWatermarkDictRsp.value.get());
      }
      ??? = new StringBuilder();
      ???.append("GetWatermarkDictRequest [onReceive] watermarkDict.size:");
      ???.append(paramBaseRequest.size());
      AEQLog.b("WaterMarkManager", ???.toString());
      synchronized (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager)
      {
        WatermarkDataManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager).clear();
        WatermarkDataManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager).putAll(paramBaseRequest);
        WatermarkDataManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager$IWatermarkDictCallback.onGetWatermarkDict(paramBaseRequest);
        return;
      }
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("GetWatermarkDictRequest retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errMSg:");
    paramBaseRequest.append(???);
    AEQLog.d("WaterMarkManager", paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager.2
 * JD-Core Version:    0.7.0.1
 */