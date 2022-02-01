package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetPlayShowCatMatTreeRsp
  extends JceStruct
{
  static ArrayList<PSMetaCategory> cache_Categories = new ArrayList();
  public ArrayList<PSMetaCategory> Categories = null;
  public int Code = 0;
  public String ETag = "";
  
  static
  {
    PSMetaCategory localPSMetaCategory = new PSMetaCategory();
    cache_Categories.add(localPSMetaCategory);
  }
  
  public GetPlayShowCatMatTreeRsp() {}
  
  public GetPlayShowCatMatTreeRsp(int paramInt, String paramString, ArrayList<PSMetaCategory> paramArrayList)
  {
    this.Code = paramInt;
    this.ETag = paramString;
    this.Categories = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.ETag = paramJceInputStream.readString(1, false);
    this.Categories = ((ArrayList)paramJceInputStream.read(cache_Categories, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Code, 0);
    Object localObject = this.ETag;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.Categories;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp
 * JD-Core Version:    0.7.0.1
 */