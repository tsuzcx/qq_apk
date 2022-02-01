package com.tencent.ad.tangram.canvas.views.form.framework;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Keep
public class AdFormTableData
  implements Serializable
{
  private static final String TAG = "AdFormTableData";
  public int borderColor = 0;
  public int borderColorError = 0;
  public int borderCornerRadius = 0;
  public int borderWidth;
  private List<AdFormItemData> items = new ArrayList();
  
  public boolean addItem(AdFormItemData paramAdFormItemData)
  {
    if ((paramAdFormItemData == null) || (!paramAdFormItemData.isValid()) || (this.items == null)) {
      return false;
    }
    return this.items.add(paramAdFormItemData);
  }
  
  public AdFormItemData getItem(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt >= getSize())) {
      return null;
    }
    return (AdFormItemData)this.items.get(paramInt);
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
      AdFormItemData localAdFormItemData = (AdFormItemData)localIterator.next();
      if ((localAdFormItemData == null) || (!localAdFormItemData.isValid())) {
        return false;
      }
    }
    return true;
  }
  
  public AdFormError validate()
  {
    if (!isValid())
    {
      AdLog.e("AdFormTableData", "validate error");
      return new AdFormError(3, -1, null);
    }
    int i = 0;
    while (i < getSize())
    {
      AdFormItemData localAdFormItemData = getItem(i);
      if (localAdFormItemData == null)
      {
        AdLog.e("AdFormTableData", "validate error " + i);
        return new AdFormError(3, i, null);
      }
      AdFormError localAdFormError = localAdFormItemData.validate();
      if (localAdFormError == null)
      {
        AdLog.e("AdFormTableData", "validate error " + i);
        return new AdFormError(3, i, localAdFormItemData.title.text);
      }
      localAdFormError.index = i;
      if (localAdFormError.type == 2) {
        i += 1;
      } else {
        return localAdFormError;
      }
    }
    return new AdFormError(2, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData
 * JD-Core Version:    0.7.0.1
 */