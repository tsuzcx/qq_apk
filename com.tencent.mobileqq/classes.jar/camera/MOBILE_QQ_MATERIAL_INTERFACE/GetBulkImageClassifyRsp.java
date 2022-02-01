package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetBulkImageClassifyRsp
  extends JceStruct
{
  static ArrayList<SmartFilterRspItem> cache_MiltiRsps = new ArrayList();
  public ArrayList<SmartFilterRspItem> MiltiRsps = null;
  
  static
  {
    SmartFilterRspItem localSmartFilterRspItem = new SmartFilterRspItem();
    cache_MiltiRsps.add(localSmartFilterRspItem);
  }
  
  public GetBulkImageClassifyRsp() {}
  
  public GetBulkImageClassifyRsp(ArrayList<SmartFilterRspItem> paramArrayList)
  {
    this.MiltiRsps = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MiltiRsps = ((ArrayList)paramJceInputStream.read(cache_MiltiRsps, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.MiltiRsps != null) {
      paramJceOutputStream.write(this.MiltiRsps, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp
 * JD-Core Version:    0.7.0.1
 */