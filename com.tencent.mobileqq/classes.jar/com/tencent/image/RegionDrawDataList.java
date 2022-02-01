package com.tencent.image;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.LinkedList;

public class RegionDrawDataList
  extends LinkedList<RegionBitmap.DrawData>
{
  HashMap<Rect, RegionBitmap.DrawData> mRegionDatas = new HashMap();
  
  public boolean add(RegionBitmap.DrawData paramDrawData)
  {
    this.mRegionDatas.put(paramDrawData.mDrawRect, paramDrawData);
    return super.add(paramDrawData);
  }
  
  public RegionBitmap.DrawData getRegionData(RegionBitmap.DrawData paramDrawData)
  {
    if (paramDrawData.mDrawRect != null) {
      return (RegionBitmap.DrawData)this.mRegionDatas.get(paramDrawData.mDrawRect);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.RegionDrawDataList
 * JD-Core Version:    0.7.0.1
 */