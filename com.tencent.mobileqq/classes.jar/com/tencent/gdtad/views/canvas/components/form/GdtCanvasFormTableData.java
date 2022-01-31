package com.tencent.gdtad.views.canvas.components.form;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GdtCanvasFormTableData
  implements Serializable
{
  public int borderColor = 0;
  public int borderColorError = 0;
  public int borderCornerRadius;
  public int borderWidth;
  private List items = new ArrayList();
  
  public boolean addItem(GdtCanvasFormItemData paramGdtCanvasFormItemData)
  {
    if ((paramGdtCanvasFormItemData == null) || (!paramGdtCanvasFormItemData.isValid()) || (this.items == null)) {
      return false;
    }
    return this.items.add(paramGdtCanvasFormItemData);
  }
  
  public GdtCanvasFormItemData getItem(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= getSize())) {
      return null;
    }
    return (GdtCanvasFormItemData)this.items.get(paramInt);
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
      GdtCanvasFormItemData localGdtCanvasFormItemData = (GdtCanvasFormItemData)localIterator.next();
      if ((localGdtCanvasFormItemData == null) || (!localGdtCanvasFormItemData.isValid())) {
        return false;
      }
    }
    return true;
  }
  
  public GdtCanvasFormError validate()
  {
    if (!isValid())
    {
      GdtLog.d("GdtCanvasFormTableData", "validate error");
      return new GdtCanvasFormError(3, -1, null);
    }
    int i = 0;
    while (i < getSize())
    {
      GdtCanvasFormItemData localGdtCanvasFormItemData = getItem(i);
      if (localGdtCanvasFormItemData == null)
      {
        GdtLog.d("GdtCanvasFormTableData", "validate error " + i);
        return new GdtCanvasFormError(3, i, null);
      }
      GdtCanvasFormError localGdtCanvasFormError = localGdtCanvasFormItemData.validate();
      if (localGdtCanvasFormError == null)
      {
        GdtLog.d("GdtCanvasFormTableData", "validate error " + i);
        return new GdtCanvasFormError(3, i, localGdtCanvasFormItemData.title.text);
      }
      localGdtCanvasFormError.b = i;
      if (localGdtCanvasFormError.a == 2) {
        i += 1;
      } else {
        return localGdtCanvasFormError;
      }
    }
    return new GdtCanvasFormError(2, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormTableData
 * JD-Core Version:    0.7.0.1
 */