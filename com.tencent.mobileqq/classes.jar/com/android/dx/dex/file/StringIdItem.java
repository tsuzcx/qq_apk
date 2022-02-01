package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class StringIdItem
  extends IndexedItem
  implements Comparable
{
  private StringDataItem data;
  private final CstString value;
  
  public StringIdItem(CstString paramCstString)
  {
    if (paramCstString == null) {
      throw new NullPointerException("value == null");
    }
    this.value = paramCstString;
    this.data = null;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    if (this.data == null)
    {
      paramDexFile = paramDexFile.getStringData();
      this.data = new StringDataItem(this.value);
      paramDexFile.add(this.data);
    }
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (StringIdItem)paramObject;
    return this.value.compareTo(paramObject.value);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof StringIdItem)) {
      return false;
    }
    paramObject = (StringIdItem)paramObject;
    return this.value.equals(paramObject.value);
  }
  
  public StringDataItem getData()
  {
    return this.data;
  }
  
  public CstString getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_STRING_ID_ITEM;
  }
  
  public int writeSize()
  {
    return 4;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int i = this.data.getAbsoluteOffset();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, indexString() + ' ' + this.value.toQuoted(100));
      paramAnnotatedOutput.annotate(4, "  string_data_off: " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.StringIdItem
 * JD-Core Version:    0.7.0.1
 */