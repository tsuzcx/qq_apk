package com.google.android.exoplayer2.text.dvb;

import android.util.SparseArray;

final class DvbParser$SubtitleService
{
  public final SparseArray<DvbParser.ClutDefinition> ancillaryCluts = new SparseArray();
  public final SparseArray<DvbParser.ObjectData> ancillaryObjects = new SparseArray();
  public final int ancillaryPageId;
  public final SparseArray<DvbParser.ClutDefinition> cluts = new SparseArray();
  public DvbParser.DisplayDefinition displayDefinition;
  public final SparseArray<DvbParser.ObjectData> objects = new SparseArray();
  public DvbParser.PageComposition pageComposition;
  public final SparseArray<DvbParser.RegionComposition> regions = new SparseArray();
  public final int subtitlePageId;
  
  public DvbParser$SubtitleService(int paramInt1, int paramInt2)
  {
    this.subtitlePageId = paramInt1;
    this.ancillaryPageId = paramInt2;
  }
  
  public void reset()
  {
    this.regions.clear();
    this.cluts.clear();
    this.objects.clear();
    this.ancillaryCluts.clear();
    this.ancillaryObjects.clear();
    this.displayDefinition = null;
    this.pageComposition = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbParser.SubtitleService
 * JD-Core Version:    0.7.0.1
 */