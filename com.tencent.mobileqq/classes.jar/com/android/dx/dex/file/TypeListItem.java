package com.android.dx.dex.file;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class TypeListItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int ELEMENT_SIZE = 2;
  private static final int HEADER_SIZE = 4;
  private final TypeList list;
  
  public TypeListItem(TypeList paramTypeList)
  {
    super(4, paramTypeList.size() * 2 + 4);
    this.list = paramTypeList;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    paramDexFile = paramDexFile.getTypeIds();
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      paramDexFile.intern(this.list.getType(i));
      i += 1;
    }
  }
  
  protected int compareTo0(OffsettedItem paramOffsettedItem)
  {
    return StdTypeList.compareContents(this.list, ((TypeListItem)paramOffsettedItem).list);
  }
  
  public TypeList getList()
  {
    return this.list;
  }
  
  public int hashCode()
  {
    return StdTypeList.hashContents(this.list);
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_TYPE_LIST;
  }
  
  public String toHuman()
  {
    throw new RuntimeException("unsupported");
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int j = 0;
    paramDexFile = paramDexFile.getTypeIds();
    int k = this.list.size();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, offsetString() + " type_list");
      paramAnnotatedOutput.annotate(4, "  size: " + Hex.u4(k));
      i = 0;
      while (i < k)
      {
        Type localType = this.list.getType(i);
        int m = paramDexFile.indexOf(localType);
        paramAnnotatedOutput.annotate(2, "  " + Hex.u2(m) + " // " + localType.toHuman());
        i += 1;
      }
    }
    paramAnnotatedOutput.writeInt(k);
    int i = j;
    while (i < k)
    {
      paramAnnotatedOutput.writeShort(paramDexFile.indexOf(this.list.getType(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.TypeListItem
 * JD-Core Version:    0.7.0.1
 */