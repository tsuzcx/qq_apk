package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetImageClassifyRsp
  extends JceStruct
{
  static SmartFilterRspItem cache_SingleRet = new SmartFilterRspItem();
  public SmartFilterRspItem SingleRet = null;
  
  public GetImageClassifyRsp() {}
  
  public GetImageClassifyRsp(SmartFilterRspItem paramSmartFilterRspItem)
  {
    this.SingleRet = paramSmartFilterRspItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.SingleRet = ((SmartFilterRspItem)paramJceInputStream.read(cache_SingleRet, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    SmartFilterRspItem localSmartFilterRspItem = this.SingleRet;
    if (localSmartFilterRspItem != null) {
      paramJceOutputStream.write(localSmartFilterRspItem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImageClassifyRsp
 * JD-Core Version:    0.7.0.1
 */