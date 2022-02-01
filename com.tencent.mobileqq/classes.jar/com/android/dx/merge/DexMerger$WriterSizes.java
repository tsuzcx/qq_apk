package com.android.dx.merge;

import com.android.dex.Dex;
import com.android.dex.Dex.Section;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;

class DexMerger$WriterSizes
{
  private int annotation;
  private int annotationsDirectory;
  private int annotationsSet;
  private int annotationsSetRefList;
  private int classData;
  private int code;
  private int debugInfo;
  private int encodedArray;
  private int header = 112;
  private int idsDefs;
  private int mapList;
  private int stringData;
  private int typeList;
  
  public DexMerger$WriterSizes(DexMerger paramDexMerger)
  {
    this.header = DexMerger.access$2000(paramDexMerger).used();
    this.idsDefs = DexMerger.access$1700(paramDexMerger).used();
    this.mapList = DexMerger.access$2100(paramDexMerger).used();
    this.typeList = DexMerger.access$1800(paramDexMerger).used();
    this.classData = DexMerger.access$2200(paramDexMerger).used();
    this.code = DexMerger.access$2300(paramDexMerger).used();
    this.stringData = DexMerger.access$1600(paramDexMerger).used();
    this.debugInfo = DexMerger.access$2400(paramDexMerger).used();
    this.encodedArray = DexMerger.access$2500(paramDexMerger).used();
    this.annotationsDirectory = DexMerger.access$2600(paramDexMerger).used();
    this.annotationsSet = DexMerger.access$2700(paramDexMerger).used();
    this.annotationsSetRefList = DexMerger.access$2800(paramDexMerger).used();
    this.annotation = DexMerger.access$1900(paramDexMerger).used();
    fourByteAlign();
  }
  
  public DexMerger$WriterSizes(Dex[] paramArrayOfDex)
  {
    int i = 0;
    while (i < paramArrayOfDex.length)
    {
      plus(paramArrayOfDex[i].getTableOfContents(), false);
      i += 1;
    }
    fourByteAlign();
  }
  
  private static int fourByteAlign(int paramInt)
  {
    return paramInt + 3 & 0xFFFFFFFC;
  }
  
  private void fourByteAlign()
  {
    this.header = fourByteAlign(this.header);
    this.idsDefs = fourByteAlign(this.idsDefs);
    this.mapList = fourByteAlign(this.mapList);
    this.typeList = fourByteAlign(this.typeList);
    this.classData = fourByteAlign(this.classData);
    this.code = fourByteAlign(this.code);
    this.stringData = fourByteAlign(this.stringData);
    this.debugInfo = fourByteAlign(this.debugInfo);
    this.encodedArray = fourByteAlign(this.encodedArray);
    this.annotationsDirectory = fourByteAlign(this.annotationsDirectory);
    this.annotationsSet = fourByteAlign(this.annotationsSet);
    this.annotationsSetRefList = fourByteAlign(this.annotationsSetRefList);
    this.annotation = fourByteAlign(this.annotation);
  }
  
  private void plus(TableOfContents paramTableOfContents, boolean paramBoolean)
  {
    this.idsDefs += paramTableOfContents.stringIds.size * 4 + paramTableOfContents.typeIds.size * 4 + paramTableOfContents.protoIds.size * 12 + paramTableOfContents.fieldIds.size * 8 + paramTableOfContents.methodIds.size * 8 + paramTableOfContents.classDefs.size * 32;
    this.mapList = (paramTableOfContents.sections.length * 12 + 4);
    this.typeList += fourByteAlign(paramTableOfContents.typeLists.byteCount);
    this.stringData += paramTableOfContents.stringDatas.byteCount;
    this.annotationsDirectory += paramTableOfContents.annotationsDirectories.byteCount;
    this.annotationsSet += paramTableOfContents.annotationSets.byteCount;
    this.annotationsSetRefList += paramTableOfContents.annotationSetRefLists.byteCount;
    if (paramBoolean)
    {
      this.code += paramTableOfContents.codes.byteCount;
      this.classData += paramTableOfContents.classDatas.byteCount;
      this.encodedArray += paramTableOfContents.encodedArrays.byteCount;
      this.annotation += paramTableOfContents.annotations.byteCount;
      this.debugInfo += paramTableOfContents.debugInfos.byteCount;
      return;
    }
    this.code += (int)Math.ceil(paramTableOfContents.codes.byteCount * 1.25D);
    this.classData += (int)Math.ceil(paramTableOfContents.classDatas.byteCount * 1.67D);
    this.encodedArray += paramTableOfContents.encodedArrays.byteCount * 2;
    this.annotation += (int)Math.ceil(paramTableOfContents.annotations.byteCount * 2);
    this.debugInfo += paramTableOfContents.debugInfos.byteCount * 2;
  }
  
  public int size()
  {
    return this.header + this.idsDefs + this.mapList + this.typeList + this.classData + this.code + this.stringData + this.debugInfo + this.encodedArray + this.annotationsDirectory + this.annotationsSet + this.annotationsSetRefList + this.annotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger.WriterSizes
 * JD-Core Version:    0.7.0.1
 */