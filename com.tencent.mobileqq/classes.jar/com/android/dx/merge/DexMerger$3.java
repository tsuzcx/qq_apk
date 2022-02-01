package com.android.dx.merge;

import com.android.dex.Dex.Section;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;
import com.android.dex.TypeList;

class DexMerger$3
  extends DexMerger.IdMerger<TypeList>
{
  DexMerger$3(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    super(paramDexMerger, paramSection);
  }
  
  TableOfContents.Section getSection(TableOfContents paramTableOfContents)
  {
    return paramTableOfContents.typeLists;
  }
  
  TypeList read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt)
  {
    return paramIndexMap.adjustTypeList(paramSection.readTypeList());
  }
  
  void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3)
  {
    paramIndexMap.putTypeListOffset(paramInt1, DexMerger.access$1800(this.this$0).getPosition());
  }
  
  void write(TypeList paramTypeList)
  {
    DexMerger.access$1800(this.this$0).writeTypeList(paramTypeList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.3
 * JD-Core Version:    0.7.0.1
 */