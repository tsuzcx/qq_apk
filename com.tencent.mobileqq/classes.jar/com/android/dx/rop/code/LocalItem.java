package com.android.dx.rop.code;

import com.android.dx.rop.cst.CstString;

public class LocalItem
  implements Comparable<LocalItem>
{
  private final CstString name;
  private final CstString signature;
  
  private LocalItem(CstString paramCstString1, CstString paramCstString2)
  {
    this.name = paramCstString1;
    this.signature = paramCstString2;
  }
  
  private static int compareHandlesNulls(CstString paramCstString1, CstString paramCstString2)
  {
    if (paramCstString1 == paramCstString2) {
      return 0;
    }
    if (paramCstString1 == null) {
      return -1;
    }
    if (paramCstString2 == null) {
      return 1;
    }
    return paramCstString1.compareTo(paramCstString2);
  }
  
  public static LocalItem make(CstString paramCstString1, CstString paramCstString2)
  {
    if ((paramCstString1 == null) && (paramCstString2 == null)) {
      return null;
    }
    return new LocalItem(paramCstString1, paramCstString2);
  }
  
  public int compareTo(LocalItem paramLocalItem)
  {
    int i = compareHandlesNulls(this.name, paramLocalItem.name);
    if (i != 0) {
      return i;
    }
    return compareHandlesNulls(this.signature, paramLocalItem.signature);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocalItem)) {}
    while (compareTo((LocalItem)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public CstString getName()
  {
    return this.name;
  }
  
  public CstString getSignature()
  {
    return this.signature;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.name == null)
    {
      i = 0;
      if (this.signature != null) {
        break label36;
      }
    }
    for (;;)
    {
      return i * 31 + j;
      i = this.name.hashCode();
      break;
      label36:
      j = this.signature.hashCode();
    }
  }
  
  public String toString()
  {
    if ((this.name != null) && (this.signature == null)) {
      return this.name.toQuoted();
    }
    if ((this.name == null) && (this.signature == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[");
    if (this.name == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("|");
      if (this.signature != null) {
        break label103;
      }
    }
    label103:
    for (String str = "";; str = this.signature.toQuoted())
    {
      return str;
      str = this.name.toQuoted();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.LocalItem
 * JD-Core Version:    0.7.0.1
 */