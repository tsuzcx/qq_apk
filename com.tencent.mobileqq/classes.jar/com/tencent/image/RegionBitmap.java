package com.tencent.image;

import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.URLDrawableDepWrap;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public final class RegionBitmap
{
  private static final int MSG_RECYCLE_REGION_BITMAP = 2;
  private static final int MSG_UPDATE_DECODE_REGION = 1;
  private static final String TAG = "RegionBitmap";
  private WeakReference<RegionBitmap.OnUpdateCallback> mCallback;
  private long mCurrentTaskTime;
  private RegionDrawDataList mDataList = new RegionDrawDataList();
  private Object mDataLock = new Object();
  private Rect mDecodeRect = new Rect();
  private RegionBitmapBlockHelper mHelper;
  private String mImagePath;
  private BitmapRegionDecoder mRegionDecoder;
  private int mSample;
  private Rect mTmp = new Rect();
  private RegionBitmap.WorkHandler mWorkHandler;
  
  public RegionBitmap(String paramString)
  {
    if (this.mWorkHandler == null) {
      this.mWorkHandler = new RegionBitmap.WorkHandler(this, URLDrawable.depImp.mThreadManager.getFileThread().getLooper());
    }
    this.mImagePath = paramString;
  }
  
  public static Rect decodeToRegion(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {
      return null;
    }
    return new Rect(paramRect.left * paramInt2 / paramInt1, paramRect.top * paramInt2 / paramInt1, paramRect.right * paramInt2 / paramInt1, paramRect.bottom * paramInt2 / paramInt1);
  }
  
  public static Rect regionToDecode(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {
      return null;
    }
    return new Rect(paramRect.left * paramInt1 / paramInt2, paramRect.top * paramInt1 / paramInt2, paramRect.right * paramInt1 / paramInt2, paramRect.bottom * paramInt1 / paramInt2);
  }
  
  void draw(Canvas paramCanvas, Paint paramPaint)
  {
    synchronized (this.mDataLock)
    {
      if ((this.mDataList != null) && (!this.mDataList.isEmpty()))
      {
        Iterator localIterator = this.mDataList.iterator();
        while (localIterator.hasNext())
        {
          RegionBitmap.DrawData localDrawData = (RegionBitmap.DrawData)localIterator.next();
          if (localDrawData.mBitmap != null) {
            paramCanvas.drawBitmap(localDrawData.mBitmap, null, localDrawData.mDrawRect, paramPaint);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramCanvas;
    }
  }
  
  public void recycle()
  {
    if (!this.mWorkHandler.hasMessages(2)) {
      this.mWorkHandler.sendEmptyMessage(2);
    }
  }
  
  public void setOnUpdateCallback(RegionBitmap.OnUpdateCallback paramOnUpdateCallback)
  {
    this.mCallback = new WeakReference(paramOnUpdateCallback);
  }
  
  public void updateRegionBitmap(RegionDrawableData paramRegionDrawableData)
  {
    if (this.mWorkHandler.hasMessages(1)) {
      this.mWorkHandler.removeMessages(1);
    }
    this.mCurrentTaskTime = SystemClock.uptimeMillis();
    paramRegionDrawableData.mTaskTime = this.mCurrentTaskTime;
    RegionBitmap.WorkHandler localWorkHandler = this.mWorkHandler;
    localWorkHandler.sendMessage(localWorkHandler.obtainMessage(1, paramRegionDrawableData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.RegionBitmap
 * JD-Core Version:    0.7.0.1
 */