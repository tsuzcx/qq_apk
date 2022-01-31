import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;

class beve
  implements RequestProxy.RequestListener
{
  beve(bevd parambevd, long paramLong1, long paramLong2, String paramString) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    bexk.a().i("APIProxyImpl", "httpRequest minigame onFailure [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    if (bevd.a(this.jdField_a_of_type_Bevd) != null) {
      bevd.a(this.jdField_a_of_type_Bevd).getNativeHttp().httpCallBack(this.b, -1, null);
    }
    for (;;)
    {
      bevd.a(this.jdField_a_of_type_Bevd, System.currentTimeMillis() - this.jdField_a_of_type_Long, -1);
      return;
      bexk.a().e("APIProxyImpl", "httpRequest onFailure but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    bexk.a().i("APIProxyImpl", "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    if (bevd.a(this.jdField_a_of_type_Bevd) != null) {
      bevd.a(this.jdField_a_of_type_Bevd).getNativeHttp().httpCallBack(this.b, paramInt, paramArrayOfByte);
    }
    for (;;)
    {
      bevd.a(this.jdField_a_of_type_Bevd, System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt);
      return;
      bexk.a().e("APIProxyImpl", "httpRequest onResponse but mTTEngine is null, url:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beve
 * JD-Core Version:    0.7.0.1
 */