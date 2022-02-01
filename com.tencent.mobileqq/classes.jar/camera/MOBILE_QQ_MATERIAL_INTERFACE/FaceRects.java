package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceRects
  extends JceStruct
{
  public double H;
  public double W;
  public double X;
  public double Y;
  
  public FaceRects() {}
  
  public FaceRects(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.X = paramDouble1;
    this.Y = paramDouble2;
    this.W = paramDouble3;
    this.H = paramDouble4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.X = paramJceInputStream.read(this.X, 0, false);
    this.Y = paramJceInputStream.read(this.Y, 1, false);
    this.W = paramJceInputStream.read(this.W, 2, false);
    this.H = paramJceInputStream.read(this.H, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.X, 0);
    paramJceOutputStream.write(this.Y, 1);
    paramJceOutputStream.write(this.W, 2);
    paramJceOutputStream.write(this.H, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.FaceRects
 * JD-Core Version:    0.7.0.1
 */