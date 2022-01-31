import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class bgxm
  extends QzoneExternalRequest
{
  ClientOnlineNotfiyReq a;
  
  public bgxm(long paramLong, byte[] paramArrayOfByte)
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
    return bggm.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgxm
 * JD-Core Version:    0.7.0.1
 */