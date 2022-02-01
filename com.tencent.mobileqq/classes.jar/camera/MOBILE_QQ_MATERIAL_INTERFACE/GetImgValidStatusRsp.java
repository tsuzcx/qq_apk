package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetImgValidStatusRsp
  extends JceStruct
{
  public int Code;
  public int ValidStatus;
  
  public GetImgValidStatusRsp() {}
  
  public GetImgValidStatusRsp(int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp
 * JD-Core Version:    0.7.0.1
 */