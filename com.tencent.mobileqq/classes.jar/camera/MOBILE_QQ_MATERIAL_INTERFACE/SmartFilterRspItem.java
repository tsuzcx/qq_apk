package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class SmartFilterRspItem
  extends JceStruct
{
  static ArrayList<YoutuResultItem> cache_DisplayLabels = new ArrayList();
  public ArrayList<YoutuResultItem> DisplayLabels = null;
  public String PituLabel = "";
  
  static
  {
    YoutuResultItem localYoutuResultItem = new YoutuResultItem();
    cache_DisplayLabels.add(localYoutuResultItem);
  }
  
  public SmartFilterRspItem() {}
  
  public SmartFilterRspItem(String paramString, ArrayList<YoutuResultItem> paramArrayList)
  {
    this.PituLabel = paramString;
    this.DisplayLabels = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.PituLabel = paramJceInputStream.readString(0, false);
    this.DisplayLabels = ((ArrayList)paramJceInputStream.read(cache_DisplayLabels, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.PituLabel;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.DisplayLabels;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterRspItem
 * JD-Core Version:    0.7.0.1
 */