package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class YoutuResultItem
  extends JceStruct
{
  public double Confidence = 0.0D;
  public String Label = "";
  
  public YoutuResultItem() {}
  
  public YoutuResultItem(String paramString, double paramDouble)
  {
    this.Label = paramString;
    this.Confidence = paramDouble;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Label = paramJceInputStream.readString(0, false);
    this.Confidence = paramJceInputStream.read(this.Confidence, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.Label;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.Confidence, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem
 * JD-Core Version:    0.7.0.1
 */