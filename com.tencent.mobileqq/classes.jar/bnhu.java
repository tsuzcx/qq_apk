import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StWatermarkDict;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class bnhu
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StGetWatermarkDictRsp>
{
  bnhu(bnhs parambnhs) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StGetWatermarkDictRsp paramStGetWatermarkDictRsp)
  {
    if (paramBoolean)
    {
      bnrh.b(bnhs.a(), "[onReceive]:");
      paramVSBaseRequest = paramStGetWatermarkDictRsp.extInfo;
      paramString = paramStGetWatermarkDictRsp.vecWatermarkDict.get();
      paramVSBaseRequest = new HashMap();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramStGetWatermarkDictRsp = (CLIENT.StWatermarkDict)paramString.next();
        paramVSBaseRequest.put(paramStGetWatermarkDictRsp.key.get(), paramStGetWatermarkDictRsp.value.get());
      }
      bnrh.b(bnhs.a(), "[onReceive] watermarkDict.size:" + paramVSBaseRequest.size());
      bnhs.a(this.a, paramVSBaseRequest);
      return;
    }
    bnrh.d(bnhs.a(), "retCode:" + paramLong + " errMSg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhu
 * JD-Core Version:    0.7.0.1
 */