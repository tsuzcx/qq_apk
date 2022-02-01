package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

public final class StdAttributeList
  extends FixedSizeList
  implements AttributeList
{
  public StdAttributeList(int paramInt)
  {
    super(paramInt);
  }
  
  public int byteLength()
  {
    int k = size();
    int j = 2;
    int i = 0;
    while (i < k)
    {
      j += get(i).byteLength();
      i += 1;
    }
    return j;
  }
  
  public Attribute findFirst(String paramString)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Attribute localAttribute = get(i);
      if (localAttribute.getName().equals(paramString)) {
        return localAttribute;
      }
      i += 1;
    }
    return null;
  }
  
  public Attribute findNext(Attribute paramAttribute)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (get(i) == paramAttribute)
      {
        paramAttribute = paramAttribute.getName();
        i += 1;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label77;
      }
      Attribute localAttribute = get(i);
      if (localAttribute.getName().equals(paramAttribute))
      {
        return localAttribute;
        i += 1;
        break;
        return null;
      }
      i += 1;
    }
    label77:
    return null;
  }
  
  public Attribute get(int paramInt)
  {
    return (Attribute)get0(paramInt);
  }
  
  public void set(int paramInt, Attribute paramAttribute)
  {
    set0(paramInt, paramAttribute);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdAttributeList
 * JD-Core Version:    0.7.0.1
 */