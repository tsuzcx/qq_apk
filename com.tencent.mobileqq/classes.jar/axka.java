import android.util.Log;
import com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO;
import com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender;
import com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.SSOException;
import java.net.URL;
import java.util.concurrent.Callable;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class axka
  implements Callable<byte[]>
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  final byte[] jdField_a_of_type_ArrayOfByte;
  
  public axka(WebServiceSSO.WebServiceSSOSender paramWebServiceSSOSender, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  private byte[] a(URL paramURL, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    paramArrayOfByte = RequestBody.create(null, paramArrayOfByte);
    paramURL = new Request.Builder().url(paramURL).post(paramArrayOfByte).build();
    paramArrayOfByte = WebServiceSSO.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.a).newCall(paramURL).execute();
    paramURL = localObject;
    if (paramArrayOfByte.isSuccessful())
    {
      paramArrayOfByte.body().contentLength();
      paramURL = paramArrayOfByte.body().bytes();
      paramArrayOfByte.body().close();
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramURL));
        try
        {
          int i = paramArrayOfByte.getInt("ErrorCode");
          paramArrayOfByte = paramArrayOfByte.getString("ErrorInfo");
          throw new WebServiceSSO.WebServiceSSOSender.SSOException(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender, i, paramArrayOfByte);
        }
        catch (JSONException paramArrayOfByte)
        {
          throw new WebServiceSSO.WebServiceSSOSender.SSOException(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender, -3, "SSO通信异常，异常信息解析错误。原始内容：" + new String(paramURL));
        }
        return paramURL;
      }
      catch (Exception paramArrayOfByte) {}
    }
  }
  
  public byte[] a()
  {
    if (WebServiceSSO.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.a)) {}
    for (Object localObject = "https://test.tim.qq.com/v4/";; localObject = "https://open.tim.qq.com/v4/")
    {
      localObject = new URL((String)localObject + "NowSSOSvcProxy" + "/" + this.jdField_a_of_type_JavaLangString + WebServiceSSO.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.a));
      Log.d("RequestCallable", "WebServiceSSO--send url=" + ((URL)localObject).toString());
      return a((URL)localObject, this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axka
 * JD-Core Version:    0.7.0.1
 */