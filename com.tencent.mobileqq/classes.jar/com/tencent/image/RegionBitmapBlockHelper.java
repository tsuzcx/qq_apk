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
    if ((paramRect != null) && (!paramRect.isEmpty()))
    {
      int j = paramRect.left / 1000;
      int k = paramRect.right / 1000 + 1;
      paramInt = paramRect.top / 1000;
      int m = paramRect.bottom / 1000 + 1;
      paramRect = new LinkedList();
      while (paramInt < m)
      {
        int i = j;
        while (i < k)
        {
          Rect localRect = new Rect();
          localRect.left = (i * 1000);
          localRect.right = (localRect.left + 1000);
          localRect.top = (paramInt * 1000);
          localRect.bottom = (localRect.top + 1000);
          i += 1;
          if ((i == k) || (paramInt + 1 == m)) {
            localRect.intersect(this.mImageRect);
          }
          paramRect.add(localRect);
        }
        paramInt += 1;
      }
      return paramRect;
    }
    return null;
  }
  
  public LinkedList<Rect> getBlocksExceptRegion(Rect paramRect, LinkedList<Rect> paramLinkedList)
  {
    if ((paramRect != null) && (!paramRect.isEmpty()))
    {
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
    return null;
  }
  
  public LinkedList<RegionBitmap.DrawData> getDrawDatas(RegionDrawableData paramRegionDrawableData, int paramInt)
  {
    Rect localRect = paramRegionDrawableData.mShowArea;
    if ((localRect != null) && (!localRect.isEmpty()))
    {
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
          m += 1;
          if ((m == i) || (k + 1 == j)) {
            localRect.intersect(this.mRegionRect);
          }
          RegionBitmap.DrawData localDrawData = new RegionBitmap.DrawData();
          localDrawData.mDrawRect = localRect;
          localDrawData.mDecodeSample = paramInt;
          paramRegionDrawableData.add(localDrawData);
        }
        k += 1;
      }
      return paramRegionDrawableData;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.RegionBitmapBlockHelper
 * JD-Core Version:    0.7.0.1
 */