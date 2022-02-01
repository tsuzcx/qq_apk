package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

public final class StringDataItem
  extends OffsettedItem
{
  private final CstString value;
  
  public StringDataItem(CstString paramCstString)
  {
    super(1, writeSize(paramCstString));
    this.value = paramCstString;
  }
  
  private static int writeSize(CstString paramCstString)
  {
    return Leb128.unsignedLeb128Size(paramCstString.getUtf16Size()) + paramCstString.getUtf8Size() + 1;
  }
  
  public void addContents(DexFile paramDexFile) {}
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    paramOffsettedItem = (StringDataItem)paramOffsettedItem;
    return this.value.compareTo(paramOffsettedItem.value);
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_STRING_DATA_ITEM;
  }
  
  public String toHuman()
  {
    return this.value.toQuoted();
  }
  
  public void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    paramDexFile = this.value.getBytes();
    int i = this.value.getUtf16Size();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(i), "utf16_size: " + Hex.u4(i));
      paramAnnotatedOutput.annotate(paramDexFile.size() + 1, this.value.toQuoted());
    }
    paramAnnotatedOutput.writeUleb128(i);
    paramAnnotatedOutput.write(paramDexFile);
    paramAnnotatedOutput.writeByte(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.StringDataItem
 * JD-Core Version:    0.7.0.1
 */