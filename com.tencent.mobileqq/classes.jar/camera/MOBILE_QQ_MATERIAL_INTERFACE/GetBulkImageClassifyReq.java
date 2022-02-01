package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBulkImageClassifyReq
  extends JceStruct
{
  static ArrayList<SmartFilterReqItem> cache_MultiPics = new ArrayList();
  public ArrayList<SmartFilterReqItem> MultiPics;
  
  static
  {
    SmartFilterReqItem localSmartFilterReqItem = new SmartFilterReqItem();
    cache_MultiPics.add(localSmartFilterReqItem);
  }
  
  public GetBulkImageClassifyReq() {}
  
  public GetBulkImageClassifyReq(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    this.MultiPics = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MultiPics = ((ArrayList)paramJceInputStream.read(cache_MultiPics, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MultiPics != null) {
      paramJceOutputStream.write(this.MultiPics, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyReq
 * JD-Core Version:    0.7.0.1
 */