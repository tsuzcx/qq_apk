package com.android.dx.merge;

import com.android.dex.Dex.Section;
import com.android.dex.DexIndexOverflowException;
import com.android.dex.MethodId;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;

class DexMerger$6
  extends DexMerger.IdMerger<MethodId>
{
  DexMerger$6(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    super(paramDexMerger, paramSection);
  }
  
  TableOfContents.Section getSection(TableOfContents paramTableOfContents)
  {
    return paramTableOfContents.methodIds;
  }
  
  MethodId read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt)
  {
    return paramIndexMap.adjust(paramSection.readMethodId());
  }
  
  void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < 0) || (paramInt3 > 65535)) {
      throw new DexIndexOverflowException("method ID not in [0, 0xffff]: " + paramInt3);
    }
    paramIndexMap.methodIds[paramInt2] = ((short)paramInt3);
  }
  
  void write(MethodId paramMethodId)
  {
    paramMethodId.writeTo(DexMerger.access$1700(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.6
 * JD-Core Version:    0.7.0.1
 */