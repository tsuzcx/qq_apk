package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.JpegRegionDecoder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class RegionBitmap
{
  private static final int MSG_RECYCLE_REGION_BITMAP = 2;
  private static final int MSG_UPDATE_DECODE_REGION = 1;
  private static final String TAG = "RegionBitmap";
  private static HandlerThread mWorkThread = new HandlerThread("URLDrawable-Region-Update-Task");
  private WeakReference<OnUpdateCallback> mCallback;
  private LinkedList<DrawData> mDataList = new LinkedList();
  private Object mDataLock = new Object();
  private Rect mDecodeRect = new Rect();
  private RegionBitmapBlockHelper mHelper;
  private String mImagePath;
  private JpegRegionDecoder mRegionDecoder;
  private int mSample;
  private Rect mTmp = new Rect();
  private WorkHandler mWorkHandler;
  
  static
  {
    mWorkThread.start();
  }
  
  public RegionBitmap(String paramString)
  {
    if (this.mWorkHandler == null) {
      this.mWorkHandler = new WorkHandler(mWorkThread.getLooper());
    }
    this.mImagePath = paramString;
  }
  
  private Rect decodeToRegion(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {
      return null;
    }
    return new Rect(paramRect.left * paramInt2 / paramInt1, paramRect.top * paramInt2 / paramInt1, paramRect.right * paramInt2 / paramInt1, paramRect.bottom * paramInt2 / paramInt1);
  }
  
  private Rect regionToDecode(int paramInt1, int paramInt2, Rect paramRect)
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
          DrawData localDrawData = (DrawData)localIterator.next();
          if (localDrawData.mBitmap != null) {
            paramCanvas.drawBitmap(localDrawData.mBitmap, null, localDrawData.mDrawRect, paramPaint);
          }
        }
      }
    }
  }
  
  public void recycle()
  {
    if (!this.mWorkHandler.hasMessages(2)) {
      this.mWorkHandler.sendEmptyMessage(2);
    }
  }
  
  public void setOnUpdateCallback(OnUpdateCallback paramOnUpdateCallback)
  {
    this.mCallback = new WeakReference(paramOnUpdateCallback);
  }
  
  public void updateRegionBitmap(RegionDrawableData paramRegionDrawableData)
  {
    if (this.mWorkHandler.hasMessages(1)) {
      this.mWorkHandler.removeMessages(1);
    }
    this.mWorkHandler.sendMessage(this.mWorkHandler.obtainMessage(1, paramRegionDrawableData));
  }
  
  public class DrawData
  {
    Bitmap mBitmap;
    Rect mDrawRect;
    
    public DrawData() {}
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      return ((DrawData)paramObject).mDrawRect.equals(this.mDrawRect);
    }
  }
  
  public static abstract interface OnUpdateCallback
  {
    public abstract void regionRefreshed();
  }
  
  final class WorkHandler
    extends Handler
  {
    public WorkHandler() {}
    
    public WorkHandler(Looper paramLooper)
    {
      super();
    }
    
    private void decode(RegionDrawableData paramRegionDrawableData, RegionBitmap.DrawData paramDrawData, int paramInt)
    {
      long l1 = SystemClock.uptimeMillis();
      RegionBitmap.this.mTmp.set(RegionBitmap.this.regionToDecode(paramRegionDrawableData.mSourceDensity, paramRegionDrawableData.mTargetDensity, paramDrawData.mDrawRect));
      paramRegionDrawableData = new JpegOptions();
      paramRegionDrawableData.inSampleSize = paramInt;
      try
      {
        paramDrawData.mBitmap = RegionBitmap.this.mRegionDecoder.decodeRegion(RegionBitmap.this.mTmp, paramRegionDrawableData);
        paramRegionDrawableData = paramDrawData.mBitmap;
        if ((paramRegionDrawableData != null) && (!paramRegionDrawableData.isRecycled()))
        {
          paramDrawData = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
          if (paramDrawData != null) {
            paramDrawData.regionRefreshed();
          }
        }
        if (!QLog.isColorLevel()) {
          break label127;
        }
        if (paramRegionDrawableData != null) {
          break label1195;
        }
      }
      catch (IllegalArgumentException paramRegionDrawableData)
      {
        for (;;)
        {
          paramDrawData.mBitmap = null;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(RegionBitmap.this.mRegionDecoder.getWidth() + "x" + RegionBitmap.this.mRegionDecoder.getHeight() + "\n");
          if (QLog.isColorLevel()) {
            QLog.w("RegionDrawable", 1, localStringBuilder.toString(), paramRegionDrawableData);
          }
          paramRegionDrawableData = paramDrawData.mBitmap;
          if ((paramRegionDrawableData != null) && (!paramRegionDrawableData.isRecycled()))
          {
            paramDrawData = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
            if (paramDrawData != null) {
              paramDrawData.regionRefreshed();
            }
          }
          if (QLog.isColorLevel()) {
            if (paramRegionDrawableData != null) {
              break;
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RegionDrawable", 2, "decodeRegion OOM");
          }
          paramRegionDrawableData.inSampleSize <<= 1;
          paramDrawData.mBitmap = RegionBitmap.this.mRegionDecoder.decodeRegion(RegionBitmap.this.mTmp, paramRegionDrawableData);
          paramRegionDrawableData = paramDrawData.mBitmap;
          if ((paramRegionDrawableData != null) && (!paramRegionDrawableData.isRecycled()))
          {
            paramDrawData = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
            if (paramDrawData != null) {
              paramDrawData.regionRefreshed();
            }
          }
          if (QLog.isColorLevel()) {
            if (paramRegionDrawableData != null) {
              break;
            }
          }
        }
      }
      catch (RuntimeException paramRegionDrawableData)
      {
        for (;;)
        {
          paramDrawData.mBitmap = null;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(RegionBitmap.this.mRegionDecoder.getWidth() + "x" + RegionBitmap.this.mRegionDecoder.getHeight() + "\n");
          if (QLog.isColorLevel()) {
            QLog.w("RegionDrawable", 1, ((StringBuilder)localObject).toString(), paramRegionDrawableData);
          }
          paramRegionDrawableData = paramDrawData.mBitmap;
          if ((paramRegionDrawableData != null) && (!paramRegionDrawableData.isRecycled()))
          {
            paramDrawData = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
            if (paramDrawData != null) {
              paramDrawData.regionRefreshed();
            }
          }
          if (QLog.isColorLevel()) {
            if (paramRegionDrawableData != null) {
              break;
            }
          }
        }
      }
      finally
      {
        paramDrawData = paramDrawData.mBitmap;
        if ((paramDrawData == null) || (paramDrawData.isRecycled())) {
          break label549;
        }
        localObject = (RegionBitmap.OnUpdateCallback)RegionBitmap.this.mCallback.get();
        if (localObject == null) {
          break label549;
        }
        ((RegionBitmap.OnUpdateCallback)localObject).regionRefreshed();
        if (!QLog.isColorLevel()) {
          break label567;
        }
        if (paramDrawData != null) {
          break label569;
        }
        QLog.i("RegionDrawable", 2, "Decode region failure...");
      }
      QLog.i("RegionDrawable", 2, "Decode region failure...");
      label127:
      return;
      for (;;)
      {
        StringBuilder localStringBuilder;
        Object localObject;
        label549:
        label567:
        label569:
        l2 = SystemClock.uptimeMillis();
        paramDrawData = new StringBuilder();
        paramDrawData.append("cost " + (l2 - l1) + ", sample " + paramInt + "\n");
        paramDrawData.append("decode rect " + RegionBitmap.this.mTmp + "\n");
        paramDrawData.append("decode size " + RegionBitmap.this.mTmp.width() + " * " + RegionBitmap.this.mTmp.height() + "\n");
        QLog.i("RegionDrawable", 2, paramDrawData.toString());
      }
      long l2 = SystemClock.uptimeMillis();
      paramRegionDrawableData = new StringBuilder();
      paramRegionDrawableData.append("cost " + (l2 - l1) + ", sample " + paramInt + "\n");
      paramRegionDrawableData.append("decode rect " + RegionBitmap.this.mTmp + "\n");
      paramRegionDrawableData.append("decode size " + RegionBitmap.this.mTmp.width() + " * " + RegionBitmap.this.mTmp.height() + "\n");
      paramRegionDrawableData = paramRegionDrawableData.toString();
      for (;;)
      {
        QLog.i("RegionDrawable", 2, paramRegionDrawableData);
        return;
        l2 = SystemClock.uptimeMillis();
        paramRegionDrawableData = new StringBuilder();
        paramRegionDrawableData.append("cost " + (l2 - l1) + ", sample " + paramInt + "\n");
        paramRegionDrawableData.append("decode rect " + RegionBitmap.this.mTmp + "\n");
        paramRegionDrawableData.append("decode size " + RegionBitmap.this.mTmp.width() + " * " + RegionBitmap.this.mTmp.height() + "\n");
        paramRegionDrawableData = paramRegionDrawableData.toString();
        continue;
        l2 = SystemClock.uptimeMillis();
        paramRegionDrawableData = new StringBuilder();
        paramRegionDrawableData.append("cost " + (l2 - l1) + ", sample " + paramInt + "\n");
        paramRegionDrawableData.append("decode rect " + RegionBitmap.this.mTmp + "\n");
        paramRegionDrawableData.append("decode size " + RegionBitmap.this.mTmp.width() + " * " + RegionBitmap.this.mTmp.height() + "\n");
        paramRegionDrawableData = paramRegionDrawableData.toString();
        continue;
        label1195:
        l2 = SystemClock.uptimeMillis();
        paramRegionDrawableData = new StringBuilder();
        paramRegionDrawableData.append("cost " + (l2 - l1) + ", sample " + paramInt + "\n");
        paramRegionDrawableData.append("decode rect " + RegionBitmap.this.mTmp + "\n");
        paramRegionDrawableData.append("decode size " + RegionBitmap.this.mTmp.width() + " * " + RegionBitmap.this.mTmp.height() + "\n");
        paramRegionDrawableData = paramRegionDrawableData.toString();
      }
    }
    
    private void initRegionDecoder()
    {
      if ((RegionBitmap.this.mRegionDecoder == null) || (RegionBitmap.this.mRegionDecoder.isRecycled())) {
        if (TextUtils.isEmpty(RegionBitmap.this.mImagePath)) {
          throw new RuntimeException("Image path is null");
        }
      }
      try
      {
        RegionBitmap.access$002(RegionBitmap.this, JpegRegionDecoder.newInstance(RegionBitmap.this.mImagePath));
        if ((QLog.isColorLevel()) && (RegionBitmap.this.mRegionDecoder != null)) {
          QLog.i("RegionDrawable", 2, "origin size " + RegionBitmap.this.mRegionDecoder.getWidth() + "x" + RegionBitmap.this.mRegionDecoder.getHeight());
        }
        if ((RegionBitmap.this.mRegionDecoder == null) && (QLog.isColorLevel())) {
          QLog.e("RegionBitmap", 2, "BitmapRegionDecoder object is null");
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException);
          }
          RegionBitmap.access$002(RegionBitmap.this, null);
        }
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        long l1;
        int m;
        int i;
        int j;
        int k;
        long l2;
        long l3;
        do
        {
          RegionDrawableData localRegionDrawableData;
          int i2;
          do
          {
            do
            {
              return;
              initRegionDecoder();
            } while ((RegionBitmap.this.mRegionDecoder == null) || (!RegionDrawableData.class.isInstance(paramMessage.obj)));
            localRegionDrawableData = (RegionDrawableData)paramMessage.obj;
            i2 = localRegionDrawableData.calcSample();
          } while (i2 == 0);
          if (RegionBitmap.this.mHelper == null) {
            RegionBitmap.access$502(RegionBitmap.this, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmap.this.mRegionDecoder.getWidth(), RegionBitmap.this.mRegionDecoder.getHeight())));
          }
          l1 = SystemClock.uptimeMillis();
          m = 0;
          int n = 0;
          int i1 = 0;
          Rect localRect = RegionBitmap.this.regionToDecode(localRegionDrawableData.mSourceDensity, localRegionDrawableData.mTargetDensity, localRegionDrawableData.mShowArea);
          paramMessage = RegionBitmap.this.mHelper.getBlocks(localRect);
          ??? = RegionBitmap.this.mHelper.getBlocks(RegionBitmap.this.mDecodeRect);
          Object localObject3;
          if (??? == null)
          {
            ??? = new LinkedList();
            localObject2 = paramMessage.iterator();
            for (;;)
            {
              i = m;
              j = n;
              paramMessage = (Message)???;
              k = i1;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              paramMessage = (Rect)((Iterator)localObject2).next();
              paramMessage.set(RegionBitmap.this.decodeToRegion(localRegionDrawableData.mSourceDensity, localRegionDrawableData.mTargetDensity, paramMessage));
              localObject3 = new RegionBitmap.DrawData(RegionBitmap.this);
              ((RegionBitmap.DrawData)localObject3).mDrawRect = paramMessage;
              ((LinkedList)???).add(localObject3);
            }
          }
          paramMessage = RegionBitmap.this.mHelper.getBlocksExceptRegion(RegionBitmap.this.mDecodeRect, paramMessage);
          Object localObject2 = RegionBitmap.this.mHelper.getBlocksExceptRegion(localRect, (LinkedList)???);
          n = ((LinkedList)localObject2).size();
          i1 = paramMessage.size();
          if ((i2 == RegionBitmap.this.mSample) && (paramMessage.isEmpty()) && (((LinkedList)localObject2).isEmpty()))
          {
            RegionBitmap.this.mDecodeRect.set(localRect);
            return;
          }
          ??? = new LinkedList(RegionBitmap.this.mDataList);
          i = 0;
          localObject2 = ((LinkedList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Rect)((Iterator)localObject2).next();
            Iterator localIterator = ((LinkedList)???).iterator();
            j = i;
            for (;;)
            {
              i = j;
              if (!localIterator.hasNext()) {
                break;
              }
              RegionBitmap.DrawData localDrawData = (RegionBitmap.DrawData)localIterator.next();
              RegionBitmap.this.mTmp.set(RegionBitmap.this.regionToDecode(localRegionDrawableData.mSourceDensity, localRegionDrawableData.mTargetDensity, localDrawData.mDrawRect));
              if (RegionBitmap.this.mTmp.equals(localObject3))
              {
                localIterator.remove();
                j += 1;
              }
            }
          }
          m = i;
          localObject2 = paramMessage.iterator();
          for (;;)
          {
            i = n;
            j = m;
            paramMessage = (Message)???;
            k = i1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramMessage = (Rect)((Iterator)localObject2).next();
            paramMessage.set(RegionBitmap.this.decodeToRegion(localRegionDrawableData.mSourceDensity, localRegionDrawableData.mTargetDensity, paramMessage));
            localObject3 = new RegionBitmap.DrawData(RegionBitmap.this);
            ((RegionBitmap.DrawData)localObject3).mDrawRect = paramMessage;
            ((LinkedList)???).add(localObject3);
          }
          l2 = SystemClock.uptimeMillis();
          synchronized (RegionBitmap.this.mDataLock)
          {
            RegionBitmap.access$902(RegionBitmap.this, paramMessage);
            l3 = SystemClock.uptimeMillis();
            m = 0;
            paramMessage = RegionBitmap.this.mDataList.iterator();
            while (paramMessage.hasNext())
            {
              ??? = (RegionBitmap.DrawData)paramMessage.next();
              if ((i2 != RegionBitmap.this.mSample) || (((RegionBitmap.DrawData)???).mBitmap == null) || (((RegionBitmap.DrawData)???).mDrawRect == null) || (((RegionBitmap.DrawData)???).mDrawRect.isEmpty()))
              {
                decode(localRegionDrawableData, (RegionBitmap.DrawData)???, i2);
                m += 1;
              }
            }
          }
          RegionBitmap.access$802(RegionBitmap.this, i2);
          RegionBitmap.this.mDecodeRect.set(localRect);
        } while (!QLog.isColorLevel());
        QLog.i("RegionDrawable", 2, "选取有效块:cost " + (l2 - l1));
        QLog.i("RegionDrawable", 2, "解析有效块:cost " + (SystemClock.uptimeMillis() - l3));
        QLog.i("RegionDrawable", 2, "分块：" + RegionBitmap.this.mDataList.size());
        QLog.i("RegionDrawable", 2, "invalide has " + i + ", remove " + j);
        QLog.i("RegionDrawable", 2, "refresh has " + k + ", decode " + m);
        QLog.i("RegionDrawable", 2, "刷新面积/解析面积：" + RegionBitmap.this.mDecodeRect.width() * RegionBitmap.this.mDecodeRect.height() / (RegionBitmap.this.mDataList.size() * 160000));
        return;
      } while ((RegionBitmap.this.mRegionDecoder == null) || (RegionBitmap.this.mRegionDecoder.isRecycled()));
      RegionBitmap.this.mRegionDecoder.recycle();
      RegionBitmap.access$002(RegionBitmap.this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmap
 * JD-Core Version:    0.7.0.1
 */