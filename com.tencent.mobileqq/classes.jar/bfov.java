import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_req;
import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.Map;

public class bfov
  extends QzoneExternalRequest
{
  mobile_get_qzone_public_msg_req a;
  
  public bfov(long paramLong, Map<String, String> paramMap)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.a = new mobile_get_qzone_public_msg_req(paramLong, paramMap);
  }
  
  public static mobile_get_qzone_public_msg_rsp a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramArrayOfInt = (mobile_get_qzone_public_msg_rsp)decode(paramArrayOfByte, "getQzonePublicMsg", paramArrayOfInt);
      paramArrayOfByte = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService." + uniKey();
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getQzonePublicMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfov
 * JD-Core Version:    0.7.0.1
 */