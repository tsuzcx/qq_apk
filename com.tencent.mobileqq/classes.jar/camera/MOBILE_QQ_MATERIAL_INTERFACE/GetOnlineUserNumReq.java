package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineUserNumReq
  extends JceStruct
{
  public String Nothing = "";
  
  public GetOnlineUserNumReq() {}
  
  public GetOnlineUserNumReq(String paramString)
  {
    this.Nothing = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Nothing = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.Nothing;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumReq
 * JD-Core Version:    0.7.0.1
 */