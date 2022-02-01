package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTextValidStatusReq
  extends JceStruct
{
  public String EmoText = "";
  
  public GetTextValidStatusReq() {}
  
  public GetTextValidStatusReq(String paramString)
  {
    this.EmoText = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.EmoText = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.EmoText;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusReq
 * JD-Core Version:    0.7.0.1
 */