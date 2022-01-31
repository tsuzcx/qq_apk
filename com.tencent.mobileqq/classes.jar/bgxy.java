import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;
import java.util.List;
import java.util.Map;

class bgxy
  implements RequestProxy.RequestListener
{
  bgxy(bgxx parambgxx, long paramLong1, long paramLong2, String paramString) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    bhaj.a().i("APIProxyImpl", "httpRequest minigame onFailure [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    paramString = bgxx.a(this.jdField_a_of_type_Bgxx).getGameEngine().getNativeHttp();
    if (paramString != null) {
      paramString.httpCallBack(this.b, -1, null);
    }
    for (;;)
    {
      bgxx.a(this.jdField_a_of_type_Bgxx, System.currentTimeMillis() - this.jdField_a_of_type_Long, -1);
      return;
      bhaj.a().e("APIProxyImpl", "httpRequest onFailure but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    bhaj.a().i("APIProxyImpl", "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    paramMap = bgxx.a(this.jdField_a_of_type_Bgxx).getGameEngine().getNativeHttp();
    if (paramMap != null) {
      paramMap.httpCallBack(this.b, paramInt, paramArrayOfByte);
    }
    for (;;)
    {
      bgxx.a(this.jdField_a_of_type_Bgxx, System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt);
      return;
      bhaj.a().e("APIProxyImpl", "httpRequest onResponse but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxy
 * JD-Core Version:    0.7.0.1
 */