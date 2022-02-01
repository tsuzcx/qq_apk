package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleData
  extends JceStruct
{
  public String DisplayText = "";
  public String Id = "";
  
  public BubbleData() {}
  
  public BubbleData(String paramString1, String paramString2)
  {
    this.Id = paramString1;
    this.DisplayText = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Id = paramJceInputStream.readString(0, false);
    this.DisplayText = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.Id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.DisplayText;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.BubbleData
 * JD-Core Version:    0.7.0.1
 */