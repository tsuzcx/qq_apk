package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MetaCategory
  extends JceStruct
{
  static Map<String, String> cache_dynamicFields;
  static ArrayList<MetaMaterial> cache_materials;
  static ArrayList<MetaCategory> cache_subCategories = new ArrayList();
  public Map<String, String> dynamicFields = null;
  public String id = "";
  public ArrayList<MetaMaterial> materials = null;
  public String name = "";
  public ArrayList<MetaCategory> subCategories = null;
  public String thumbUrl = "";
  
  static
  {
    Object localObject = new MetaCategory();
    cache_subCategories.add(localObject);
    cache_materials = new ArrayList();
    localObject = new MetaMaterial();
    cache_materials.add(localObject);
    cache_dynamicFields = new HashMap();
    cache_dynamicFields.put("", "");
  }
  
  public MetaCategory() {}
  
  public MetaCategory(String paramString1, String paramString2, String paramString3, ArrayList<MetaCategory> paramArrayList, ArrayList<MetaMaterial> paramArrayList1, Map<String, String> paramMap)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.thumbUrl = paramString3;
    this.subCategories = paramArrayList;
    this.materials = paramArrayList1;
    this.dynamicFields = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.thumbUrl = paramJceInputStream.readString(2, false);
    this.subCategories = ((ArrayList)paramJceInputStream.read(cache_subCategories, 3, false));
    this.materials = ((ArrayList)paramJceInputStream.read(cache_materials, 4, false));
    this.dynamicFields = ((Map)paramJceInputStream.read(cache_dynamicFields, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.thumbUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.subCategories;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.materials;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.dynamicFields;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory
 * JD-Core Version:    0.7.0.1
 */