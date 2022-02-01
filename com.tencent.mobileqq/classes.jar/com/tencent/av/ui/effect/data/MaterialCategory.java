package com.tencent.av.ui.effect.data;

import com.tencent.av.ui.QavListItemBase.ItemInfo;
import java.util.ArrayList;
import java.util.List;

public class MaterialCategory
{
  public String a;
  public String b;
  public boolean c = true;
  public List<QavListItemBase.ItemInfo> d = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MaterialCategory{categoryId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("categoryName = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("materialList size = ");
    Object localObject = this.d;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(((List)localObject).size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.data.MaterialCategory
 * JD-Core Version:    0.7.0.1
 */