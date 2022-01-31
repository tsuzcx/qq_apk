import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneExternalRequest;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class bchi
  extends QzoneExternalRequest
{
  private JceStruct jdField_a_of_type_ComQqTafJceJceStruct;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bchi() {}
  
  public bchi(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2)
  {
    super.setRefer(paramString2);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.jdField_a_of_type_ComQqTafJceJceStruct = paramHttpReq;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.needCompress = false;
    this.b = a(paramString1);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.w("WebSoRequest", 1, "cmd is EMPTY OR NULL !!!");
    }
    do
    {
      return null;
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[(paramString.length - 1)];
  }
  
  public static HttpRsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (HttpRsp)decode(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("WebSoRequest", 1, "onResponse error:", paramArrayOfByte);
    }
    return null;
  }
  
  public String getCmdString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bchi
 * JD-Core Version:    0.7.0.1
 */