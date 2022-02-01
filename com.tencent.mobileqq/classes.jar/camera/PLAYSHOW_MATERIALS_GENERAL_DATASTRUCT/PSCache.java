package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PSCache
  extends JceStruct
{
  static ArrayList<PSMetaCategory> cache_categories = new ArrayList();
  public ArrayList<PSMetaCategory> categories = null;
  public int createTime = 0;
  
  static
  {
    PSMetaCategory localPSMetaCategory = new PSMetaCategory();
    cache_categories.add(localPSMetaCategory);
  }
  
  public PSCache() {}
  
  public PSCache(int paramInt, ArrayList<PSMetaCategory> paramArrayList)
  {
    this.createTime = paramInt;
    this.categories = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.createTime = paramJceInputStream.read(this.createTime, 0, false);
    this.categories = ((ArrayList)paramJceInputStream.read(cache_categories, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.createTime, 0);
    if (this.categories != null) {
      paramJceOutputStream.write(this.categories, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSCache
 * JD-Core Version:    0.7.0.1
 */