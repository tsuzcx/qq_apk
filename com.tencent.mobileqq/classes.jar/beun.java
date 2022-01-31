import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;

class beun
  implements RequestProxy.RequestListener
{
  beun(beum parambeum, long paramLong1, long paramLong2, String paramString) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    bewt.a().i("APIProxyImpl", "httpRequest minigame onFailure [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    if (beum.a(this.jdField_a_of_type_Beum) != null) {
      beum.a(this.jdField_a_of_type_Beum).getNativeHttp().httpCallBack(this.b, -1, null);
    }
    for (;;)
    {
      beum.a(this.jdField_a_of_type_Beum, System.currentTimeMillis() - this.jdField_a_of_type_Long, -1);
      return;
      bewt.a().e("APIProxyImpl", "httpRequest onFailure but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    bewt.a().i("APIProxyImpl", "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    if (beum.a(this.jdField_a_of_type_Beum) != null) {
      beum.a(this.jdField_a_of_type_Beum).getNativeHttp().httpCallBack(this.b, paramInt, paramArrayOfByte);
    }
    for (;;)
    {
      beum.a(this.jdField_a_of_type_Beum, System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt);
      return;
      bewt.a().e("APIProxyImpl", "httpRequest onResponse but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beun
 * JD-Core Version:    0.7.0.1
 */