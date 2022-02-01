package com.android.dex;

import java.util.Arrays;

public final class TableOfContents
{
  public final TableOfContents.Section annotationSetRefLists = new TableOfContents.Section(4098);
  public final TableOfContents.Section annotationSets = new TableOfContents.Section(4099);
  public final TableOfContents.Section annotations = new TableOfContents.Section(8196);
  public final TableOfContents.Section annotationsDirectories = new TableOfContents.Section(8198);
  public int apiLevel;
  public int checksum;
  public final TableOfContents.Section classDatas = new TableOfContents.Section(8192);
  public final TableOfContents.Section classDefs = new TableOfContents.Section(6);
  public final TableOfContents.Section codes = new TableOfContents.Section(8193);
  public int dataOff;
  public int dataSize;
  public final TableOfContents.Section debugInfos = new TableOfContents.Section(8195);
  public final TableOfContents.Section encodedArrays = new TableOfContents.Section(8197);
  public final TableOfContents.Section fieldIds = new TableOfContents.Section(4);
  public int fileSize;
  public final TableOfContents.Section header = new TableOfContents.Section(0);
  public int linkOff;
  public int linkSize;
  public final TableOfContents.Section mapList = new TableOfContents.Section(4096);
  public final TableOfContents.Section methodIds = new TableOfContents.Section(5);
  public final TableOfContents.Section protoIds = new TableOfContents.Section(3);
  public final TableOfContents.Section[] sections = { this.header, this.stringIds, this.typeIds, this.protoIds, this.fieldIds, this.methodIds, this.classDefs, this.mapList, this.typeLists, this.annotationSetRefLists, this.annotationSets, this.classDatas, this.codes, this.stringDatas, this.debugInfos, this.annotations, this.encodedArrays, this.annotationsDirectories };
  public byte[] signature = new byte[20];
  public final TableOfContents.Section stringDatas = new TableOfContents.Section(8194);
  public final TableOfContents.Section stringIds = new TableOfContents.Section(1);
  public final TableOfContents.Section typeIds = new TableOfContents.Section(2);
  public final TableOfContents.Section typeLists = new TableOfContents.Section(4097);
  
  private TableOfContents.Section getSection(short paramShort)
  {
    TableOfContents.Section[] arrayOfSection = this.sections;
    int j = arrayOfSection.length;
    int i = 0;
    while (i < j)
    {
      TableOfContents.Section localSection = arrayOfSection[i];
      if (localSection.type == paramShort) {
        return localSection;
      }
      i += 1;
    }
    throw new IllegalArgumentException("No such map item: " + paramShort);
  }
  
  private void readHeader(Dex.Section paramSection)
  {
    byte[] arrayOfByte = paramSection.readByteArray(8);
    if (!DexFormat.isSupportedDexMagic(arrayOfByte)) {
      throw new DexException("Unexpected magic: " + Arrays.toString(arrayOfByte));
    }
    this.apiLevel = DexFormat.magicToApi(arrayOfByte);
    this.checksum = paramSection.readInt();
    this.signature = paramSection.readByteArray(20);
    this.fileSize = paramSection.readInt();
    int i = paramSection.readInt();
    if (i != 112) {
      throw new DexException("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = paramSection.readInt();
    if (i != 305419896) {
      throw new DexException("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    this.linkSize = paramSection.readInt();
    this.linkOff = paramSection.readInt();
    this.mapList.off = paramSection.readInt();
    if (this.mapList.off == 0) {
      throw new DexException("Cannot merge dex files that do not contain a map");
    }
    this.stringIds.size = paramSection.readInt();
    this.stringIds.off = paramSection.readInt();
    this.typeIds.size = paramSection.readInt();
    this.typeIds.off = paramSection.readInt();
    this.protoIds.size = paramSection.readInt();
    this.protoIds.off = paramSection.readInt();
    this.fieldIds.size = paramSection.readInt();
    this.fieldIds.off = paramSection.readInt();
    this.methodIds.size = paramSection.readInt();
    this.methodIds.off = paramSection.readInt();
    this.classDefs.size = paramSection.readInt();
    this.classDefs.off = paramSection.readInt();
    this.dataSize = paramSection.readInt();
    this.dataOff = paramSection.readInt();
  }
  
  private void readMap(Dex.Section paramSection)
  {
    int j = paramSection.readInt();
    Object localObject = null;
    int i = 0;
    while (i < j)
    {
      short s = paramSection.readShort();
      paramSection.readShort();
      TableOfContents.Section localSection = getSection(s);
      int k = paramSection.readInt();
      int m = paramSection.readInt();
      if (((localSection.size != 0) && (localSection.size != k)) || ((localSection.off != -1) && (localSection.off != m))) {
        throw new DexException("Unexpected map value for 0x" + Integer.toHexString(s));
      }
      localSection.size = k;
      localSection.off = m;
      if ((localObject != null) && (localObject.off > localSection.off)) {
        throw new DexException("Map is unsorted at " + localObject + ", " + localSection);
      }
      i += 1;
      localObject = localSection;
    }
    Arrays.sort(this.sections);
  }
  
  public void computeSizesFromOffsets()
  {
    int j = this.dataOff;
    int k = this.dataSize;
    int i = this.sections.length;
    j = k + j;
    i -= 1;
    if (i >= 0)
    {
      TableOfContents.Section localSection = this.sections[i];
      if (localSection.off == -1) {}
      for (;;)
      {
        i -= 1;
        break;
        if (localSection.off > j) {
          throw new DexException("Map is unsorted at " + localSection);
        }
        localSection.byteCount = (j - localSection.off);
        j = localSection.off;
      }
    }
  }
  
  public void readFrom(Dex paramDex)
  {
    readHeader(paramDex.open(0));
    readMap(paramDex.open(this.mapList.off));
    computeSizesFromOffsets();
  }
  
  public void writeHeader(Dex.Section paramSection, int paramInt)
  {
    paramSection.write(DexFormat.apiToMagic(paramInt).getBytes("UTF-8"));
    paramSection.writeInt(this.checksum);
    paramSection.write(this.signature);
    paramSection.writeInt(this.fileSize);
    paramSection.writeInt(112);
    paramSection.writeInt(305419896);
    paramSection.writeInt(this.linkSize);
    paramSection.writeInt(this.linkOff);
    paramSection.writeInt(this.mapList.off);
    paramSection.writeInt(this.stringIds.size);
    paramSection.writeInt(this.stringIds.off);
    paramSection.writeInt(this.typeIds.size);
    paramSection.writeInt(this.typeIds.off);
    paramSection.writeInt(this.protoIds.size);
    paramSection.writeInt(this.protoIds.off);
    paramSection.writeInt(this.fieldIds.size);
    paramSection.writeInt(this.fieldIds.off);
    paramSection.writeInt(this.methodIds.size);
    paramSection.writeInt(this.methodIds.off);
    paramSection.writeInt(this.classDefs.size);
    paramSection.writeInt(this.classDefs.off);
    paramSection.writeInt(this.dataSize);
    paramSection.writeInt(this.dataOff);
  }
  
  public void writeMap(Dex.Section paramSection)
  {
    TableOfContents.Section[] arrayOfSection = this.sections;
    int m = arrayOfSection.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfSection[i].exists()) {
        k = j + 1;
      }
      i += 1;
    }
    paramSection.writeInt(j);
    arrayOfSection = this.sections;
    j = arrayOfSection.length;
    i = 0;
    while (i < j)
    {
      TableOfContents.Section localSection = arrayOfSection[i];
      if (localSection.exists())
      {
        paramSection.writeShort(localSection.type);
        paramSection.writeShort((short)0);
        paramSection.writeInt(localSection.size);
        paramSection.writeInt(localSection.off);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.TableOfContents
 * JD-Core Version:    0.7.0.1
 */