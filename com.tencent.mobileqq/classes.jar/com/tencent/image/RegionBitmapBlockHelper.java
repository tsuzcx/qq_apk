package com.tencent.image;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.LinkedList;

public class RegionBitmapBlockHelper
{
  static final int REGION_BLOCK_SIZE = 1000;
  private Rect mImageRect;
  private Rect mRegionRect;
  
  public RegionBitmapBlockHelper(Rect paramRect, int paramInt1, int paramInt2)
  {
    this.mImageRect = paramRect;
    this.mRegionRect = RegionBitmap.decodeToRegion(paramInt1, paramInt2, this.mImageRect);
  }
  
  public LinkedList<Rect> getBlocks(Rect paramRect, int paramInt)
  {
    if ((paramRect == null) || (paramRect.isEmpty()))
    {
      paramRect = null;
      return paramRect;
    }
    int j = paramRect.left / 1000;
    int k = paramRect.right / 1000 + 1;
    paramInt = paramRect.top / 1000;
    int m = paramRect.bottom / 1000 + 1;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      paramRect = localLinkedList;
      if (paramInt >= m) {
        break;
      }
      int i = j;
      while (i < k)
      {
        paramRect = new Rect();
        paramRect.left = (i * 1000);
        paramRect.right = (paramRect.left + 1000);
        paramRect.top = (paramInt * 1000);
        paramRect.bottom = (paramRect.top + 1000);
        if ((i + 1 == k) || (paramInt + 1 == m)) {
          paramRect.intersect(this.mImageRect);
        }
        localLinkedList.add(paramRect);
        i += 1;
      }
      paramInt += 1;
    }
  }
  
  public LinkedList<Rect> getBlocksExceptRegion(Rect paramRect, LinkedList<Rect> paramLinkedList)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Rect localRect = (Rect)paramLinkedList.next();
      if (!Rect.intersects(paramRect, localRect)) {
        localLinkedList.add(localRect);
      }
    }
    return localLinkedList;
  }
  
  public LinkedList<RegionBitmap.DrawData> getDrawDatas(RegionDrawableData paramRegionDrawableData, int paramInt)
  {
    Rect localRect = paramRegionDrawableData.mShowArea;
    if ((localRect == null) || (localRect.isEmpty())) {
      return null;
    }
    int i1 = paramInt * 1000 * paramRegionDrawableData.mTargetDensity / paramRegionDrawableData.mSourceDensity;
    int n = localRect.left / i1;
    int j = localRect.right / i1;
    int i = j;
    if (localRect.right % i1 != 0) {
      i = j + 1;
    }
    int k = localRect.top / i1;
    int m = localRect.bottom / i1;
    j = m;
    if (localRect.bottom % i1 != 0) {
      j = m + 1;
    }
    paramRegionDrawableData = new LinkedList();
    while (k < j)
    {
      m = n;
      while (m < i)
      {
        localRect = new Rect();
        localRect.left = (m * i1);
        localRect.right = (localRect.left + i1);
        localRect.top = (k * i1);
        localRect.bottom = (localRect.top + i1);
        if ((m + 1 == i) || (k + 1 == j)) {
          localRect.intersect(this.mRegionRect);
        }
        RegionBitmap.DrawData localDrawData = new RegionBitmap.DrawData();
        localDrawData.mDrawRect = localRect;
        localDrawData.mDecodeSample = paramInt;
        paramRegionDrawableData.add(localDrawData);
        m += 1;
      }
      k += 1;
    }
    return paramRegionDrawableData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmapBlockHelper
 * JD-Core Version:    0.7.0.1
 */