import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;

class bdpf
  implements RequestProxy.RequestListener
{
  bdpf(bdpe parambdpe, long paramLong1, long paramLong2) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    bdrb.a().i("APIProxyImpl", "httpRequest minigame onFailure [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    bdpe.a(this.jdField_a_of_type_Bdpe).getNativeHttp().httpCallBack(this.b, -1, null);
    bdpe.a(this.jdField_a_of_type_Bdpe, System.currentTimeMillis() - this.jdField_a_of_type_Long, -1);
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    bdrb.a().i("APIProxyImpl", "httpRequest minigame [timecost = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms]");
    bdpe.a(this.jdField_a_of_type_Bdpe).getNativeHttp().httpCallBack(this.b, paramInt, paramArrayOfByte);
    bdpe.a(this.jdField_a_of_type_Bdpe, System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpf
 * JD-Core Version:    0.7.0.1
 */