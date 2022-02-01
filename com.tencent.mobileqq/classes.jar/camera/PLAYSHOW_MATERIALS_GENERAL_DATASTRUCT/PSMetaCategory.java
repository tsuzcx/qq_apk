package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class PSMetaCategory
  extends JceStruct
{
  static Map<String, String> cache_additionalFields;
  static ArrayList<PSMetaMaterial> cache_materials;
  static ArrayList<PSMetaCategory> cache_subCategories = new ArrayList();
  public Map<String, String> additionalFields = null;
  public boolean defaultFlag = true;
  public String id = "";
  public ArrayList<PSMetaMaterial> materials = null;
  public String name = "";
  public boolean onlyFlag = true;
  public ArrayList<PSMetaCategory> subCategories = null;
  
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
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.subCategories;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.materials;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.defaultFlag, 4);
    paramJceOutputStream.write(this.onlyFlag, 5);
    localObject = this.additionalFields;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory
 * JD-Core Version:    0.7.0.1
 */