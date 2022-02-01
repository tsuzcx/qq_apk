package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MetaAuthInfo
  extends JceStruct
{
  public String appid = "";
  public String encyptedStr = "";
  
  public MetaAuthInfo() {}
  
  public MetaAuthInfo(String paramString1, String paramString2)
  {
    this.appid = paramString1;
    this.encyptedStr = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, false);
    this.encyptedStr = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.appid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.encyptedStr;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAuthInfo
 * JD-Core Version:    0.7.0.1
 */