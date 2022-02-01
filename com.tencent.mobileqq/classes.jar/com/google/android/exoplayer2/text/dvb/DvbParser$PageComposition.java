package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;

final class DvbParser$PageComposition
{
  public final SparseArray<DvbParser.PageRegion> regions;
  public final int state;
  public final int timeOutSecs;
  public final int version;
  
  public DvbParser$PageComposition(int paramInt1, int paramInt2, int paramInt3, SparseArray<DvbParser.PageRegion> paramSparseArray)
  {
    this.timeOutSecs = paramInt1;
    this.version = paramInt2;
    this.state = paramInt3;
    this.regions = paramSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition
 * JD-Core Version:    0.7.0.1
 */