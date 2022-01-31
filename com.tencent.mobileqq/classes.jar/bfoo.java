import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class bfoo
  extends QzoneExternalRequest
{
  ClientOnlineNotfiyReq a;
  
  public bfoo(long paramLong, byte[] paramArrayOfByte)
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
    return beye.a(this.a);
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
 * Qualified Name:     bfoo
 * JD-Core Version:    0.7.0.1
 */