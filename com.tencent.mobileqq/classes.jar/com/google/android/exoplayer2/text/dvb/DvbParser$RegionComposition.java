package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;

final class DvbParser$RegionComposition
{
  public final int clutId;
  public final int depth;
  public final boolean fillFlag;
  public final int height;
  public final int id;
  public final int levelOfCompatibility;
  public final int pixelCode2Bit;
  public final int pixelCode4Bit;
  public final int pixelCode8Bit;
  public final SparseArray<DvbParser.RegionObject> regionObjects;
  public final int width;
  
  public DvbParser$RegionComposition(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<DvbParser.RegionObject> paramSparseArray)
  {
    this.id = paramInt1;
    this.fillFlag = paramBoolean;
    this.width = paramInt2;
    this.height = paramInt3;
    this.levelOfCompatibility = paramInt4;
    this.depth = paramInt5;
    this.clutId = paramInt6;
    this.pixelCode8Bit = paramInt7;
    this.pixelCode4Bit = paramInt8;
    this.pixelCode2Bit = paramInt9;
    this.regionObjects = paramSparseArray;
  }
  
  public void mergeFrom(RegionComposition paramRegionComposition)
  {
    if (paramRegionComposition == null) {}
    for (;;)
    {
      return;
      paramRegionComposition = paramRegionComposition.regionObjects;
      int i = 0;
      while (i < paramRegionComposition.size())
      {
        this.regionObjects.put(paramRegionComposition.keyAt(i), paramRegionComposition.valueAt(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition
 * JD-Core Version:    0.7.0.1
 */