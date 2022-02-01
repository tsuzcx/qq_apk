package com.android.dx.dex.file;

import com.android.dx.dex.DexOptions;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class HeaderItem
  extends IndexedItem
{
  public void addContents(DexFile paramDexFile) {}
  
  public ItemType itemType()
  {
    return ItemType.TYPE_HEADER_ITEM;
  }
  
  public int writeSize()
  {
    return 112;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    int j = paramDexFile.getMap().getFileOffset();
    Object localObject = paramDexFile.getFirstDataSection();
    Section localSection = paramDexFile.getLastDataSection();
    int k = ((Section)localObject).getFileOffset();
    int m = localSection.getFileOffset() + localSection.writeSize() - k;
    localObject = paramDexFile.getDexOptions().getMagic();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(8, "magic: " + new CstString((String)localObject).toQuoted());
      paramAnnotatedOutput.annotate(4, "checksum");
      paramAnnotatedOutput.annotate(20, "signature");
      paramAnnotatedOutput.annotate(4, "file_size:       " + Hex.u4(paramDexFile.getFileSize()));
      paramAnnotatedOutput.annotate(4, "header_size:     " + Hex.u4(112));
      paramAnnotatedOutput.annotate(4, "endian_tag:      " + Hex.u4(305419896));
      paramAnnotatedOutput.annotate(4, "link_size:       0");
      paramAnnotatedOutput.annotate(4, "link_off:        0");
      paramAnnotatedOutput.annotate(4, "map_off:         " + Hex.u4(j));
    }
    int i = 0;
    while (i < 8)
    {
      paramAnnotatedOutput.writeByte(((String)localObject).charAt(i));
      i += 1;
    }
    paramAnnotatedOutput.writeZeroes(24);
    paramAnnotatedOutput.writeInt(paramDexFile.getFileSize());
    paramAnnotatedOutput.writeInt(112);
    paramAnnotatedOutput.writeInt(305419896);
    paramAnnotatedOutput.writeZeroes(8);
    paramAnnotatedOutput.writeInt(j);
    paramDexFile.getStringIds().writeHeaderPart(paramAnnotatedOutput);
    paramDexFile.getTypeIds().writeHeaderPart(paramAnnotatedOutput);
    paramDexFile.getProtoIds().writeHeaderPart(paramAnnotatedOutput);
    paramDexFile.getFieldIds().writeHeaderPart(paramAnnotatedOutput);
    paramDexFile.getMethodIds().writeHeaderPart(paramAnnotatedOutput);
    paramDexFile.getClassDefs().writeHeaderPart(paramAnnotatedOutput);
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(4, "data_size:       " + Hex.u4(m));
      paramAnnotatedOutput.annotate(4, "data_off:        " + Hex.u4(k));
    }
    paramAnnotatedOutput.writeInt(m);
    paramAnnotatedOutput.writeInt(k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.HeaderItem
 * JD-Core Version:    0.7.0.1
 */