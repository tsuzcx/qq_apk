package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetPlayShowCatMatTreeReq
  extends JceStruct
{
  public String ETag = "";
  public String MqVersion = "";
  
  public GetPlayShowCatMatTreeReq() {}
  
  public GetPlayShowCatMatTreeReq(String paramString1, String paramString2)
  {
    this.ETag = paramString1;
    this.MqVersion = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ETag = paramJceInputStream.readString(0, false);
    this.MqVersion = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ETag != null) {
      paramJceOutputStream.write(this.ETag, 0);
    }
    if (this.MqVersion != null) {
      paramJceOutputStream.write(this.MqVersion, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq
 * JD-Core Version:    0.7.0.1
 */