package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetImageClassifyReq
  extends JceStruct
{
  static SmartFilterReqItem cache_SinglePic = new SmartFilterReqItem();
  public SmartFilterReqItem SinglePic = null;
  
  public GetImageClassifyReq() {}
  
  public GetImageClassifyReq(SmartFilterReqItem paramSmartFilterReqItem)
  {
    this.SinglePic = paramSmartFilterReqItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.SinglePic = ((SmartFilterReqItem)paramJceInputStream.read(cache_SinglePic, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    SmartFilterReqItem localSmartFilterReqItem = this.SinglePic;
    if (localSmartFilterReqItem != null) {
      paramJceOutputStream.write(localSmartFilterReqItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImageClassifyReq
 * JD-Core Version:    0.7.0.1
 */