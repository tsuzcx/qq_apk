package com.tencent.av.business.manager;

import com.tencent.av.business.manager.pendant.ItemBase;
import java.util.ArrayList;

class Checker$ItemRecord
{
  final ItemBase a;
  final ArrayList<String> b = new ArrayList(0);
  String c;
  String d;
  int e = 0;
  boolean f = false;
  boolean g = false;
  
  Checker$ItemRecord(ItemBase paramItemBase, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.a = paramItemBase;
    this.e = 0;
    if (paramArrayList != null) {
      this.b.addAll(paramArrayList);
    }
    this.f = paramBoolean;
  }
  
  boolean a()
  {
    return this.e >= 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ItemRecord{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker.ItemRecord
 * JD-Core Version:    0.7.0.1
 */