package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.ArrayList;
import java.util.List;

public class AEMaterialCategory
  implements Cloneable
{
  public List<AEMaterialMetaData> a;
  public int b;
  public String c;
  public String d;
  public int e = 2;
  public boolean f = false;
  public boolean g = true;
  public ArrayList<MetaCategory> h;
  
  public AEMaterialCategory() {}
  
  public AEMaterialCategory(String paramString)
  {
    this.d = paramString;
  }
  
  public AEMaterialCategory a()
  {
    AEMaterialCategory localAEMaterialCategory = new AEMaterialCategory();
    localAEMaterialCategory.d = this.d;
    localAEMaterialCategory.b = this.b;
    localAEMaterialCategory.c = this.c;
    localAEMaterialCategory.e = this.e;
    localAEMaterialCategory.f = this.f;
    localAEMaterialCategory.a = new ArrayList();
    localAEMaterialCategory.a.addAll(this.a);
    return localAEMaterialCategory;
  }
  
  public int hashCode()
  {
    List localList = this.a;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.hashCode();
    }
    return 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialCategory
 * JD-Core Version:    0.7.0.1
 */