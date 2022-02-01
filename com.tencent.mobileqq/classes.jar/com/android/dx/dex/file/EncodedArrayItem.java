package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstArray;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;

public final class EncodedArrayItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 1;
  private final CstArray array;
  private byte[] encodedForm;
  
  public EncodedArrayItem(CstArray paramCstArray)
  {
    super(1, -1);
    if (paramCstArray == null) {
      throw new NullPointerException("array == null");
    }
    this.array = paramCstArray;
    this.encodedForm = null;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    ValueEncoder.addContents(paramDexFile, this.array);
  }
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    paramOffsettedItem = (EncodedArrayItem)paramOffsettedItem;
    return this.array.compareTo(paramOffsettedItem.array);
  }
  
  public int hashCode()
  {
    return this.array.hashCode();
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_ENCODED_ARRAY_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
    new ValueEncoder(paramSection.getFile(), localByteArrayAnnotatedOutput).writeArray(this.array, false);
    this.encodedForm = localByteArrayAnnotatedOutput.toByteArray();
    setWriteSize(this.encodedForm.length);
  }
  
  public String toHuman()
  {
    return this.array.toHuman();
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " encoded array");
      new ValueEncoder(paramDexFile, paramAnnotatedOutput).writeArray(this.array, true);
      return;
    }
    paramAnnotatedOutput.write(this.encodedForm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.EncodedArrayItem
 * JD-Core Version:    0.7.0.1
 */