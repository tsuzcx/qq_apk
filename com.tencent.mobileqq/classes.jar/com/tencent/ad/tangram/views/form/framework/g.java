package com.tencent.ad.tangram.views.form.framework;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  implements Serializable
{
  private static final String TAG = "AdFormTableData";
  public int borderColor = 0;
  public int borderColorError = 0;
  public int borderCornerRadius = 0;
  public int borderWidth;
  private List<d> items = new ArrayList();
  
  public boolean addItem(d paramd)
  {
    if ((paramd != null) && (paramd.isValid()))
    {
      List localList = this.items;
      if (localList != null) {
        return localList.add(paramd);
      }
    }
    return false;
  }
  
  public d getItem(int paramInt)
  {
    if ((isValid()) && (paramInt >= 0) && (paramInt < getSize())) {
      return (d)this.items.get(paramInt);
    }
    return null;
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
    Object localObject = this.items;
    int i;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (this.borderCornerRadius >= 0) && (this.borderWidth >= 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    localObject = this.items.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((locald == null) || (!locald.isValid())) {
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
      Object localObject1 = getItem(i);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("validate error ");
        ((StringBuilder)localObject1).append(i);
        AdLog.e("AdFormTableData", ((StringBuilder)localObject1).toString());
        return new AdFormError(3, i, null);
      }
      Object localObject2 = ((d)localObject1).validate();
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("validate error ");
        ((StringBuilder)localObject2).append(i);
        AdLog.e("AdFormTableData", ((StringBuilder)localObject2).toString());
        return new AdFormError(3, i, ((d)localObject1).title.text);
      }
      ((AdFormError)localObject2).index = i;
      if (((AdFormError)localObject2).type == 2) {
        i += 1;
      } else {
        return localObject2;
      }
    }
    return new AdFormError(2, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.g
 * JD-Core Version:    0.7.0.1
 */