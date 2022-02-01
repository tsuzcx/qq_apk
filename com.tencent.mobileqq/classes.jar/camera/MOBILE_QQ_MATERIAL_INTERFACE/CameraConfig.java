package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CameraConfig
  extends JceStruct
{
  public String ConfigContent = "";
  public String ExpId = "";
  
  public CameraConfig() {}
  
  public CameraConfig(String paramString1, String paramString2)
  {
    this.ExpId = paramString1;
    this.ConfigContent = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ExpId = paramJceInputStream.readString(0, false);
    this.ConfigContent = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ExpId != null) {
      paramJceOutputStream.write(this.ExpId, 0);
    }
    if (this.ConfigContent != null) {
      paramJceOutputStream.write(this.ConfigContent, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig
 * JD-Core Version:    0.7.0.1
 */