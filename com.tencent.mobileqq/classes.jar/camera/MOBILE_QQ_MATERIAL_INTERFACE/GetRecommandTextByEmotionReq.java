package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetRecommandTextByEmotionReq
  extends JceStruct
{
  static byte[] cache_Rawdata = (byte[])new byte[1];
  public byte[] Rawdata;
  
  static
  {
    ((byte[])cache_Rawdata)[0] = 0;
  }
  
  public GetRecommandTextByEmotionReq() {}
  
  public GetRecommandTextByEmotionReq(byte[] paramArrayOfByte)
  {
    this.Rawdata = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Rawdata = ((byte[])paramJceInputStream.read(cache_Rawdata, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Rawdata != null) {
      paramJceOutputStream.write(this.Rawdata, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionReq
 * JD-Core Version:    0.7.0.1
 */