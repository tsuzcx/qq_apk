package com.android.dx.merge;

import com.android.dex.Dex.Section;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;

class DexMerger$1
  extends DexMerger.IdMerger<String>
{
  DexMerger$1(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    super(paramDexMerger, paramSection);
  }
  
  TableOfContents.Section getSection(TableOfContents paramTableOfContents)
  {
    return paramTableOfContents.stringIds;
  }
  
  String read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt)
  {
    return paramSection.readString();
  }
  
  void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3)
  {
    paramIndexMap.stringIds[paramInt2] = paramInt3;
  }
  
  void write(String paramString)
  {
    TableOfContents.Section localSection = DexMerger.access$1500(this.this$0).stringDatas;
    localSection.size += 1;
    DexMerger.access$1700(this.this$0).writeInt(DexMerger.access$1600(this.this$0).getPosition());
    DexMerger.access$1600(this.this$0).writeStringData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.1
 * JD-Core Version:    0.7.0.1
 */