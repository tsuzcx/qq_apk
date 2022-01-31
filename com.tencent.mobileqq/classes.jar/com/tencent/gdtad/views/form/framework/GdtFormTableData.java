package com.tencent.gdtad.views.form.framework;

import com.tencent.gdtad.views.xijing.GdtTextData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yxp;
import zaf;

public class GdtFormTableData
  implements Serializable
{
  public int borderColor = 0;
  public int borderColorError = 0;
  public int borderCornerRadius;
  public int borderWidth;
  private List<GdtFormItemData> items = new ArrayList();
  
  public boolean addItem(GdtFormItemData paramGdtFormItemData)
  {
    if ((paramGdtFormItemData == null) || (!paramGdtFormItemData.isValid()) || (this.items == null)) {
      return false;
    }
    return this.items.add(paramGdtFormItemData);
  }
  
  public GdtFormItemData getItem(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= getSize())) {
      return null;
    }
    return (GdtFormItemData)this.items.get(paramInt);
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.items.size();
    }
    return 0;
  }
  
  public boolean isValid()
  {
    if ((this.items != null) && (!this.items.isEmpty()) && (this.borderCornerRadius >= 0) && (this.borderWidth >= 0)) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext())
    {
      GdtFormItemData localGdtFormItemData = (GdtFormItemData)localIterator.next();
      if ((localGdtFormItemData == null) || (!localGdtFormItemData.isValid())) {
        return false;
      }
    }
    return true;
  }
  
  public zaf validate()
  {
    if (!isValid())
    {
      yxp.d("GdtFormTableData", "validate error");
      return new zaf(3, -1, null);
    }
    int i = 0;
    while (i < getSize())
    {
      GdtFormItemData localGdtFormItemData = getItem(i);
      if (localGdtFormItemData == null)
      {
        yxp.d("GdtFormTableData", "validate error " + i);
        return new zaf(3, i, null);
      }
      zaf localzaf = localGdtFormItemData.validate();
      if (localzaf == null)
      {
        yxp.d("GdtFormTableData", "validate error " + i);
        return new zaf(3, i, localGdtFormItemData.title.text);
      }
      localzaf.b = i;
      if (localzaf.a == 2) {
        i += 1;
      } else {
        return localzaf;
      }
    }
    return new zaf(2, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormTableData
 * JD-Core Version:    0.7.0.1
 */