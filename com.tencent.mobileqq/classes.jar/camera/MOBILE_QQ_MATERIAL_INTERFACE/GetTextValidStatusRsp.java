package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTextValidStatusRsp
  extends JceStruct
{
  public int Code = 0;
  public int ValidStatus = 0;
  
  public GetTextValidStatusRsp() {}
  
  public GetTextValidStatusRsp(int paramInt1, int paramInt2)
  {
    this.Code = paramInt1;
    this.ValidStatus = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.ValidStatus = paramJceInputStream.read(this.ValidStatus, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    paramJceOutputStream.write(this.ValidStatus, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp
 * JD-Core Version:    0.7.0.1
 */