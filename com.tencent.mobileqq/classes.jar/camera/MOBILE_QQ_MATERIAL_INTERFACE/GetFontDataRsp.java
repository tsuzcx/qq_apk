package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFontDataRsp
  extends JceStruct
{
  static byte[] cache_FontData = (byte[])new byte[1];
  public int Code = 0;
  public byte[] FontData = null;
  
  static
  {
    ((byte[])cache_FontData)[0] = 0;
  }
  
  public GetFontDataRsp() {}
  
  public GetFontDataRsp(int paramInt, byte[] paramArrayOfByte)
  {
    this.Code = paramInt;
    this.FontData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.FontData = ((byte[])paramJceInputStream.read(cache_FontData, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    if (this.FontData != null) {
      paramJceOutputStream.write(this.FontData, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp
 * JD-Core Version:    0.7.0.1
 */