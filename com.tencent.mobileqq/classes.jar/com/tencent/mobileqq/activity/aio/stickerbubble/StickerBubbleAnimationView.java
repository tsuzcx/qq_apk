package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import vyp;
import vyq;
import vyr;

public class StickerBubbleAnimationView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback, StickerBubbleAnimationItem.ItemAnimationCallback, Runnable
{
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback;
  private volatile String jdField_a_of_type_JavaLangString = "";
  private ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private boolean jdField_b_of_type_Boolean = true;
  private HashMap c;
  private HashMap d;
  
  public StickerBubbleAnimationView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private float a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - this.jdField_a_of_type_Long) % 400L / 400.0D * 20.0D;
    if (d1 < 10.0D) {}
    for (d1 -= 5.0D;; d1 = 10.0D - (d1 - 10.0D) - 5.0D) {
      return (float)d1;
    }
  }
  
  @Nullable
  private Bitmap a(@NonNull Bitmap paramBitmap, double paramDouble)
  {
    paramDouble = getResources().getDisplayMetrics().density * paramDouble / 2.75D;
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramDouble), (int)(paramDouble * paramBitmap.getHeight()), true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("StickerAnimationView", 1, "oom when scale bitmap");
    }
    return null;
  }
  
  private BitmapDrawable a(long paramLong1, long paramLong2, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    paramInt = (int)((paramLong1 - paramLong2) / paramInt % paramArrayOfBitmapDrawable.length);
    while (paramInt >= 0)
    {
      if (paramArrayOfBitmapDrawable[paramInt] != null) {
        return paramArrayOfBitmapDrawable[paramInt];
      }
      paramInt -= 1;
    }
    return paramArrayOfBitmapDrawable[0];
  }
  
  private StickerBubbleAnimationItem a(StickerBubbleAnimationView.AddItemRequest paramAddItemRequest, long paramLong)
  {
    ItemStatus.Velocity localVelocity = new ItemStatus.Velocity(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    ItemStatus.Acceleration localAcceleration = new ItemStatus.Acceleration(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    paramAddItemRequest = new StickerBubbleAnimationItem(((BitmapDrawable[])this.c.get(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest)))[0], StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), localVelocity, localAcceleration, 1.0D, paramLong, StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    paramAddItemRequest.a(this);
    return paramAddItemRequest;
  }
  
  private void a(Canvas paramCanvas, long paramLong)
  {
    int i = this.jdField_a_of_type_Int;
    String str;
    float f1;
    if (i > 1)
    {
      str = Integer.toString(i);
      if (i >= 10) {
        break label244;
      }
      f1 = AIOUtils.a(i * 2.5F + 50.0F, getResources());
      if (f1 >= 0.0F) {
        break label386;
      }
      Float localFloat = (Float)jdField_a_of_type_AndroidUtilSparseArray.get(str.length());
      if (localFloat == null) {
        break label291;
      }
      f1 = localFloat.floatValue();
    }
    label386:
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f1);
      f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
      i = (int)((paramCanvas.getWidth() - f1) / 2.0F);
      int j = paramCanvas.save();
      int k = (int)(paramCanvas.getHeight() / 8 - this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent);
      float f2 = a(paramLong);
      float f3 = i;
      paramCanvas.rotate(f2, f1 / 2.0F + f3, k + this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent / 2.0F);
      paramCanvas.drawText(str, i, k, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawText(str, i, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(j);
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = paramLong;
      }
      return;
      label244:
      if (i < 100)
      {
        f1 = AIOUtils.a((i - 10) * 0.2777778F + 75.0F, getResources());
        break;
      }
      f1 = AIOUtils.a(100.0F, getResources());
      break;
      label291:
      i = 200;
      for (;;)
      {
        if (i > 0)
        {
          f1 = AIOUtils.a(i, getResources());
          this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
          if (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str) >= getResources().getDisplayMetrics().widthPixels - AIOUtils.a(48.0F, getResources())) {}
        }
        else
        {
          jdField_a_of_type_AndroidUtilSparseArray.put(str.length(), Float.valueOf(f1));
          break;
        }
        i -= 10;
      }
    }
  }
  
  private void a(ManualDecodeGifImage paramManualDecodeGifImage, BitmapDrawable[] paramArrayOfBitmapDrawable, String paramString, int paramInt)
  {
    ThreadManager.post(new vyr(this, paramArrayOfBitmapDrawable, paramManualDecodeGifImage, paramString, paramInt), 8, null, true);
  }
  
  private void a(StickerBubbleAnimationView.AddItemRequest paramAddItemRequest, long paramLong)
  {
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest))
    {
      localLinkedList1 = (LinkedList)this.jdField_b_of_type_JavaUtilHashMap.get(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
      localLinkedList2 = localLinkedList1;
      if (localLinkedList1 == null)
      {
        localLinkedList2 = new LinkedList();
        if (!StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest)) {
          break label103;
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), localLinkedList2);
      }
      label62:
      if (!StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest)) {
        break label120;
      }
    }
    label103:
    label120:
    for (paramAddItemRequest = b(paramAddItemRequest, paramLong);; paramAddItemRequest = a(paramAddItemRequest, paramLong))
    {
      localLinkedList2.add(paramAddItemRequest);
      return;
      localLinkedList1 = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
      break;
      this.jdField_a_of_type_JavaUtilHashMap.put(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), localLinkedList2);
      break label62;
    }
  }
  
  private void a(Set paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramSet = new File(str);
      if ((!this.c.containsKey(str)) && (paramSet.exists()))
      {
        Object localObject = StickerBubbleAnimationHelper.a(str);
        if (localObject != null)
        {
          this.c.put(str, ((StickerBubbleAnimationHelper.CacheItem)localObject).a());
          this.d.put(str, Integer.valueOf(((StickerBubbleAnimationHelper.CacheItem)localObject).a()));
          if (QLog.isColorLevel()) {
            QLog.d("StickerAnimationView", 2, "get frames from cache");
          }
        }
        else
        {
          try
          {
            localObject = new ManualDecodeGifImage(paramSet, false);
            this.d.put(str, Integer.valueOf(((ManualDecodeGifImage)localObject).a()));
            BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[((ManualDecodeGifImage)localObject).b()];
            paramSet = a(((ManualDecodeGifImage)localObject).a(), 0.7D);
            Resources localResources = getResources();
            if (paramSet != null)
            {
              arrayOfBitmapDrawable[0] = new BitmapDrawable(localResources, paramSet);
              a((ManualDecodeGifImage)localObject, arrayOfBitmapDrawable, str, ((ManualDecodeGifImage)localObject).a());
              this.c.put(str, arrayOfBitmapDrawable);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("StickerAnimationView", 2, "decoded first frame of gif: " + str);
            }
          }
          catch (IOException paramSet)
          {
            for (;;)
            {
              QLog.e("StickerAnimationView", 1, "decode gif fail: " + paramSet);
              break;
              paramSet = ((ManualDecodeGifImage)localObject).a();
            }
          }
          catch (OutOfMemoryError paramSet)
          {
            QLog.e("StickerAnimationView", 1, "oom when decode gif or scale first frame, " + paramSet);
          }
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(Set paramSet, long paramLong)
  {
    LinkedList localLinkedList = null;
    BitmapDrawable[] arrayOfBitmapDrawable = null;
    Object localObject5 = null;
    Object localObject1 = localObject5;
    Object localObject4 = localLinkedList;
    Object localObject3 = arrayOfBitmapDrawable;
    long l;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 22)
        {
          localObject4 = localLinkedList;
          localObject3 = arrayOfBitmapDrawable;
          boolean bool = this.jdField_b_of_type_Boolean;
          localObject1 = localObject5;
          if (bool)
          {
            localObject4 = localLinkedList;
            localObject3 = arrayOfBitmapDrawable;
          }
        }
      }
      catch (Exception paramSet)
      {
        localObject3 = localObject4;
        QLog.e("StickerAnimationView", 1, "throw exception in doDraw: " + paramSet);
        return;
        localObject4 = localObject5;
        localObject3 = localObject5;
        ((Canvas)localObject5).drawColor(0, PorterDuff.Mode.CLEAR);
        i = 0;
        localObject4 = localObject5;
        localObject3 = localObject5;
        Object localObject2 = paramSet.iterator();
        localObject4 = localObject5;
        localObject3 = localObject5;
        if (!((Iterator)localObject2).hasNext()) {
          break label731;
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        localObject7 = (String)((Iterator)localObject2).next();
        localObject4 = localObject5;
        localObject3 = localObject5;
        if (!this.c.containsKey(localObject7)) {
          break label841;
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        localObject6 = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject7);
        localObject4 = localObject5;
        localObject3 = localObject5;
        localLinkedList = (LinkedList)this.jdField_b_of_type_JavaUtilHashMap.get(localObject7);
        localObject4 = localObject5;
        localObject3 = localObject5;
        arrayOfBitmapDrawable = (BitmapDrawable[])this.c.get(localObject7);
        localObject4 = localObject5;
        localObject3 = localObject5;
        k = ((Integer)this.d.get(localObject7)).intValue();
        if (localObject6 == null) {
          break label834;
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        localObject7 = ((LinkedList)localObject6).iterator();
        localObject4 = localObject5;
        localObject3 = localObject5;
        if (!((Iterator)localObject7).hasNext()) {
          break label581;
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        localObject8 = (StickerBubbleAnimationItem)((Iterator)localObject7).next();
        localObject4 = localObject5;
        localObject3 = localObject5;
        localBitmapDrawable = a(paramLong, ((StickerBubbleAnimationItem)localObject8).a(), arrayOfBitmapDrawable, k);
        localObject4 = localObject5;
        localObject3 = localObject5;
        ((StickerBubbleAnimationItem)localObject8).a((Canvas)localObject5, this.jdField_a_of_type_AndroidGraphicsPaint, paramLong, localBitmapDrawable);
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject3);
      }
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockHardwareCanvas();
        localObject5 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          localObject3 = localObject1;
          localObject5 = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        l = SystemClock.uptimeMillis();
        if (localObject5 == null)
        {
          localObject4 = localObject5;
          localObject3 = localObject5;
          QLog.e("StickerAnimationView", 1, "lockCanvas but return null");
          if (localObject5 != null) {
            this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject5);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject4 = localLinkedList;
        localObject3 = arrayOfBitmapDrawable;
        if (QLog.isColorLevel())
        {
          localObject4 = localLinkedList;
          localObject3 = arrayOfBitmapDrawable;
          QLog.d("StickerAnimationView", 2, "invoke lockHardwareCanvas but exception thrown: " + localThrowable);
        }
        localObject4 = localLinkedList;
        localObject3 = arrayOfBitmapDrawable;
        this.jdField_b_of_type_Boolean = false;
        localObject2 = localObject5;
      }
    }
    label581:
    label841:
    for (;;)
    {
      int i;
      Object localObject7;
      Object localObject6;
      int k;
      Object localObject8;
      BitmapDrawable localBitmapDrawable;
      localObject4 = localObject5;
      localObject3 = localObject5;
      for (int j = ((LinkedList)localObject6).size() + i;; j = i)
      {
        i = j;
        if (localLinkedList == null) {
          break label841;
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        localObject6 = localLinkedList.iterator();
        for (;;)
        {
          localObject4 = localObject5;
          localObject3 = localObject5;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject4 = localObject5;
          localObject3 = localObject5;
          localObject7 = (StickerBubbleAnimationItem)((Iterator)localObject6).next();
          localObject4 = localObject5;
          localObject3 = localObject5;
          localObject8 = a(paramLong, ((StickerBubbleAnimationItem)localObject7).a(), arrayOfBitmapDrawable, k);
          localObject4 = localObject5;
          localObject3 = localObject5;
          ((StickerBubbleAnimationItem)localObject7).a((Canvas)localObject5, this.jdField_a_of_type_AndroidGraphicsPaint, paramLong, (Drawable)localObject8);
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        i = j + localLinkedList.size();
        break label841;
        label731:
        localObject4 = localObject5;
        localObject3 = localObject5;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject4 = localObject5;
          localObject3 = localObject5;
          a((Canvas)localObject5, paramLong);
        }
        localObject4 = localObject5;
        localObject3 = localObject5;
        if (SystemClock.uptimeMillis() - l > 50L)
        {
          localObject4 = localObject5;
          localObject3 = localObject5;
          if (paramLong - this.jdField_b_of_type_Long > 1000L)
          {
            localObject4 = localObject5;
            localObject3 = localObject5;
            b(paramSet, paramLong);
          }
        }
        if (localObject5 == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject5);
        return;
      }
    }
  }
  
  private StickerBubbleAnimationItem b(StickerBubbleAnimationView.AddItemRequest paramAddItemRequest, long paramLong)
  {
    ItemStatus.Velocity localVelocity = new ItemStatus.Velocity(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    ItemStatus.Acceleration localAcceleration = new ItemStatus.Acceleration(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    paramAddItemRequest = new StickerBubbleAnimationItem(((BitmapDrawable[])this.c.get(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest)))[0], StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), localVelocity, localAcceleration, paramLong, 1.7D, true, StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    paramAddItemRequest.a(this);
    return paramAddItemRequest;
  }
  
  private void b()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    Typeface localTypeface = PEPanelHelper.a;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(localTypeface);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#418DFF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(30.0F);
    setFocusable(false);
    setClickable(false);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(70);
  }
  
  private void b(Set paramSet, long paramLong)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      Object localObject = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localObject != null)
      {
        int j = ((LinkedList)localObject).size();
        int i = 0;
        localObject = ((LinkedList)localObject).iterator();
        label63:
        StickerBubbleAnimationItem localStickerBubbleAnimationItem;
        if (((Iterator)localObject).hasNext())
        {
          localStickerBubbleAnimationItem = (StickerBubbleAnimationItem)((Iterator)localObject).next();
          if ((str.equals(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
            break label125;
          }
          localStickerBubbleAnimationItem.a(paramLong - 2000L);
          this.jdField_b_of_type_Long = paramLong;
        }
        for (;;)
        {
          break label63;
          break;
          label125:
          if ((j > 20) && (i < j / 2))
          {
            localStickerBubbleAnimationItem.a(paramLong - 2000L);
            this.jdField_b_of_type_Long = paramLong;
          }
          i += 1;
        }
      }
    }
  }
  
  private void c()
  {
    int j = 0;
    if ((this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (this.jdField_b_of_type_JavaUtilHashMap.isEmpty())) {}
    label167:
    for (;;)
    {
      return;
      int k = 1;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        i = k;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(str)).isEmpty());
      int i = 0;
      localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((LinkedList)this.jdField_b_of_type_JavaUtilHashMap.get(str)).isEmpty()) {
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label167;
        }
        this.jdField_a_of_type_JavaLangString = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback.a();
        return;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(StickerBubbleAnimationItem paramStickerBubbleAnimationItem)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new vyq(this, paramStickerBubbleAnimationItem));
  }
  
  public void a(StickerBubbleAnimationView.AddItemRequest paramAddItemRequest)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest)))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest);
    }
    this.jdField_a_of_type_Int += 1;
    ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest));
    ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
    if (localConcurrentLinkedQueue2 == null)
    {
      localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(StickerBubbleAnimationView.AddItemRequest.a(paramAddItemRequest), localConcurrentLinkedQueue1);
    }
    localConcurrentLinkedQueue1.add(paramAddItemRequest);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_JavaLangThreadLocal.get() == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      this.c = new HashMap();
      this.d = new HashMap();
      this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    }
    Set localSet = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    a(localSet);
    long l2 = SystemClock.uptimeMillis();
    Iterator localIterator = localSet.iterator();
    String str;
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (this.c.containsKey(str))
        {
          localObject = (Queue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (localObject != null) {
            break;
          }
        }
      }
    }
    do
    {
      return;
      localObject = new ArrayList((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StickerBubbleAnimationView.AddItemRequest localAddItemRequest = (StickerBubbleAnimationView.AddItemRequest)((Iterator)localObject).next();
        a(localAddItemRequest, l2);
        ((ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).remove(localAddItemRequest);
      }
      break;
      a(localSet, l2);
      c();
      l2 = SystemClock.uptimeMillis();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 16L - (l2 - l1));
  }
  
  public void setAnimationCallback(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback = paramStickerBubbleAnimationCallback;
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerAnimationView", 2, "surfaceCreated");
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("StickerBubbleAnimationRenderThread", -4);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.post(this);
    StickerBubbleAnimationHelper.a();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerAnimationView", 2, "surfaceDestroyed");
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new vyp(this));
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback.b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView
 * JD-Core Version:    0.7.0.1
 */