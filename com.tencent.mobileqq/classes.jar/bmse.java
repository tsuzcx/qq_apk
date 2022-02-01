import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class bmse
  extends QzoneExternalRequest
{
  ClientOnlineNotfiyReq a;
  
  public bmse(long paramLong, byte[] paramArrayOfByte)
  {
    this.needCompress = false;
    this.a = new ClientOnlineNotfiyReq(paramArrayOfByte, paramLong);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService." + uniKey();
  }
  
  public byte[] getEncodedUniParameter()
  {
    return bmah.a(this.a);
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "MqqOnlineNtf";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmse
 * JD-Core Version:    0.7.0.1
 */