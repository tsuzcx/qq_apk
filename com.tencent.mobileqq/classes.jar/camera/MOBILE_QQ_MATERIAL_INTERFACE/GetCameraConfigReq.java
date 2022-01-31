package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCameraConfigReq
  extends JceStruct
{
  public String Uin = "";
  
  public GetCameraConfigReq() {}
  
  public GetCameraConfigReq(String paramString)
  {
    this.Uin = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Uin = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Uin != null) {
      paramJceOutputStream.write(this.Uin, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq
 * JD-Core Version:    0.7.0.1
 */