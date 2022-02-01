package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PSMetaCategory
  extends JceStruct
{
  static Map<String, String> cache_additionalFields;
  static ArrayList<PSMetaMaterial> cache_materials;
  static ArrayList<PSMetaCategory> cache_subCategories = new ArrayList();
  public Map<String, String> additionalFields;
  public boolean defaultFlag = true;
  public String id = "";
  public ArrayList<PSMetaMaterial> materials;
  public String name = "";
  public boolean onlyFlag = true;
  public ArrayList<PSMetaCategory> subCategories;
  
  static
  {
    Object localObject = new PSMetaCategory();
    cache_subCategories.add(localObject);
    cache_materials = new ArrayList();
    localObject = new PSMetaMaterial();
    cache_materials.add(localObject);
    cache_additionalFields = new HashMap();
    cache_additionalFields.put("", "");
  }
  
  public PSMetaCategory() {}
  
  public PSMetaCategory(String paramString1, String paramString2, ArrayList<PSMetaCategory> paramArrayList, ArrayList<PSMetaMaterial> paramArrayList1, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.subCategories = paramArrayList;
    this.materials = paramArrayList1;
    this.defaultFlag = paramBoolean1;
    this.onlyFlag = paramBoolean2;
    this.additionalFields = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.subCategories = ((ArrayList)paramJceInputStream.read(cache_subCategories, 2, false));
    this.materials = ((ArrayList)paramJceInputStream.read(cache_materials, 3, false));
    this.defaultFlag = paramJceInputStream.read(this.defaultFlag, 4, false);
    this.onlyFlag = paramJceInputStream.read(this.onlyFlag, 5, false);
    this.additionalFields = ((Map)paramJceInputStream.read(cache_additionalFields, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    if (this.subCategories != null) {
      paramJceOutputStream.write(this.subCategories, 2);
    }
    if (this.materials != null) {
      paramJceOutputStream.write(this.materials, 3);
    }
    paramJceOutputStream.write(this.defaultFlag, 4);
    paramJceOutputStream.write(this.onlyFlag, 5);
    if (this.additionalFields != null) {
      paramJceOutputStream.write(this.additionalFields, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory
 * JD-Core Version:    0.7.0.1
 */