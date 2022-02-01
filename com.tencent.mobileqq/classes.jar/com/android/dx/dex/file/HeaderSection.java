package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class HeaderSection
  extends UniformItemSection
{
  private final List<HeaderItem> list;
  
  public HeaderSection(DexFile paramDexFile)
  {
    super(null, paramDexFile, 4);
    paramDexFile = new HeaderItem();
    paramDexFile.setIndex(0);
    this.list = Collections.singletonList(paramDexFile);
  }
  
  public IndexedItem get(Constant paramConstant)
  {
    return null;
  }
  
  public Collection<? extends Item> items()
  {
    return this.list;
  }
  
  protected void orderItems() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.HeaderSection
 * JD-Core Version:    0.7.0.1
 */