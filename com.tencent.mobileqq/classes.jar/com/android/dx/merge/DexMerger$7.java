package com.android.dx.merge;

import com.android.dex.Annotation;
import com.android.dex.Dex.Section;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;

class DexMerger$7
  extends DexMerger.IdMerger<Annotation>
{
  DexMerger$7(DexMerger paramDexMerger, Dex.Section paramSection)
  {
    super(paramDexMerger, paramSection);
  }
  
  TableOfContents.Section getSection(TableOfContents paramTableOfContents)
  {
    return paramTableOfContents.annotations;
  }
  
  Annotation read(Dex.Section paramSection, IndexMap paramIndexMap, int paramInt)
  {
    return paramIndexMap.adjust(paramSection.readAnnotation());
  }
  
  void updateIndex(int paramInt1, IndexMap paramIndexMap, int paramInt2, int paramInt3)
  {
    paramIndexMap.putAnnotationOffset(paramInt1, DexMerger.access$1900(this.this$0).getPosition());
  }
  
  void write(Annotation paramAnnotation)
  {
    paramAnnotation.writeTo(DexMerger.access$1900(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.7
 * JD-Core Version:    0.7.0.1
 */