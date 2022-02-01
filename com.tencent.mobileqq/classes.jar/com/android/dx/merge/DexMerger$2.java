package com.android.dx.merge;

import com.android.dex.Dex.Section;
import com.android.dex.DexIndexOverflowException;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;

class DexMerger$2
  extends DexMerger.IdMerger<Integer>
{
  DexMerger$2(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    super(paramDexMerger, paramSection);
  }
  
  TableOfContents.Section getSection(TableOfContents paramTableOfContents)
  {
    return paramTableOfContents.typeIds;
  }
  
  Integer read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt)
  {
    return Integer.valueOf(paramIndexMap.adjustString(paramSection.readInt()));
  }
  
  void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < 0) || (paramInt3 > 65535)) {
      throw new DexIndexOverflowException("type ID not in [0, 0xffff]: " + paramInt3);
    }
    paramIndexMap.typeIds[paramInt2] = ((short)paramInt3);
  }
  
  void write(Integer paramInteger)
  {
    DexMerger.access$1700(this.this$0).writeInt(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.2
 * JD-Core Version:    0.7.0.1
 */