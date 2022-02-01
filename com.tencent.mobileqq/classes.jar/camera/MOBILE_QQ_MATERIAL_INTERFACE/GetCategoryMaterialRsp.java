package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetCategoryMaterialRsp
  extends JceStruct
{
  static BubbleData cache_BubbleData = new BubbleData();
  static ArrayList<MetaCategory> cache_Categories = new ArrayList();
  public BubbleData BubbleData = null;
  public ArrayList<MetaCategory> Categories = null;
  public int Code = 0;
  public String ETag = "";
  
  static
  {
    MetaCategory localMetaCategory = new MetaCategory();
    cache_Categories.add(localMetaCategory);
  }
  
  public GetCategoryMaterialRsp() {}
  
  public GetCategoryMaterialRsp(int paramInt, String paramString, ArrayList<MetaCategory> paramArrayList, BubbleData paramBubbleData)
  {
    this.Code = paramInt;
    this.ETag = paramString;
    this.Categories = paramArrayList;
    this.BubbleData = paramBubbleData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Code = paramJceInputStream.read(this.Code, 0, false);
    this.ETag = paramJceInputStream.readString(1, false);
    this.Categories = ((ArrayList)paramJceInputStream.read(cache_Categories, 2, false));
    this.BubbleData = ((BubbleData)paramJceInputStream.read(cache_BubbleData, 3, false));
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
    localObject = this.BubbleData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp
 * JD-Core Version:    0.7.0.1
 */