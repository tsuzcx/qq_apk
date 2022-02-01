package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetCategoryMaterialRsp
  extends JceStruct
{
  static BubbleData cache_BubbleData = new BubbleData();
  static ArrayList<MetaCategory> cache_Categories = new ArrayList();
  public BubbleData BubbleData;
  public ArrayList<MetaCategory> Categories;
  public int Code;
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
    if (this.ETag != null) {
      paramJceOutputStream.write(this.ETag, 1);
    }
    if (this.Categories != null) {
      paramJceOutputStream.write(this.Categories, 2);
    }
    if (this.BubbleData != null) {
      paramJceOutputStream.write(this.BubbleData, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp
 * JD-Core Version:    0.7.0.1
 */