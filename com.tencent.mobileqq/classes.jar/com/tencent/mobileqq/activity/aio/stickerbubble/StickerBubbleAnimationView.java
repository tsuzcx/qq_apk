package com.tencent.mobileqq.activity.aio.stickerbubble;

import actn;
import aevh;
import aevi;
import aevj;
import aevl;
import aevm;
import aevo;
import aevp;
import aevq;
import aevr;
import aevs;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StickerBubbleAnimationView
  extends View
  implements aevq, View.OnAttachStateChangeListener
{
  private static SparseArray<Float> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aevs jdField_a_of_type_Aevs;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Long> jdField_a_of_type_JavaUtilList;
  private Map<String, List<aevp>> jdField_a_of_type_JavaUtilMap;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Map<String, List<aevp>> jdField_b_of_type_JavaUtilMap;
  private Map<String, BitmapDrawable[]> c;
  private Map<String, Integer> d;
  private Map<String, List<aevr>> e;
  
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
  
  private aevp a(aevr paramaevr, long paramLong)
  {
    aevi localaevi = new aevi(aevr.a(paramaevr));
    aevh localaevh = new aevh(aevr.a(paramaevr));
    paramaevr = new aevp(((BitmapDrawable[])this.c.get(aevr.a(paramaevr)))[0], aevr.a(paramaevr), localaevi, localaevh, 1.0D, paramLong, aevr.a(paramaevr), aevr.a(paramaevr));
    paramaevr.a(this);
    return paramaevr;
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
      QLog.e("StickerBubbleAnimationView", 1, "oom when scale bitmap");
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
  
  private void a(aevj paramaevj, BitmapDrawable[] paramArrayOfBitmapDrawable, String paramString, int paramInt)
  {
    ThreadManager.post(new StickerBubbleAnimationView.2(this, paramArrayOfBitmapDrawable, paramaevj, paramString, paramInt), 8, null, true);
  }
  
  private void a(aevr paramaevr, long paramLong)
  {
    List localList;
    Object localObject;
    if (aevr.a(paramaevr))
    {
      localList = (List)this.jdField_b_of_type_JavaUtilMap.get(aevr.a(paramaevr));
      localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        if (!aevr.a(paramaevr)) {
          break label111;
        }
        this.jdField_b_of_type_JavaUtilMap.put(aevr.a(paramaevr), localObject);
      }
      label66:
      if (!aevr.a(paramaevr)) {
        break label130;
      }
    }
    label130:
    for (paramaevr = b(paramaevr, paramLong);; paramaevr = a(paramaevr, paramLong))
    {
      ((List)localObject).add(paramaevr);
      return;
      localList = (List)this.jdField_a_of_type_JavaUtilMap.get(aevr.a(paramaevr));
      break;
      label111:
      this.jdField_a_of_type_JavaUtilMap.put(aevr.a(paramaevr), localObject);
      break label66;
    }
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
      f1 = actn.a(i * 2.5F + 50.0F, getResources());
      if (f1 >= 0.0F) {
        break label390;
      }
      Float localFloat = (Float)jdField_a_of_type_AndroidUtilSparseArray.get(str.length());
      if (localFloat == null) {
        break label294;
      }
      f1 = localFloat.floatValue();
    }
    label390:
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
        f1 = actn.a((i - 10) * 0.2777778F + 75.0F, getResources());
        break;
      }
      f1 = actn.a(100.0F, getResources());
      break;
      label294:
      i = 200;
      for (;;)
      {
        if (i > 0)
        {
          f1 = actn.a(i, getResources());
          this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
          if (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str) >= getResources().getDisplayMetrics().widthPixels - actn.a(48.0F, getResources())) {}
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
  
  private void a(String paramString)
  {
    ThreadManager.postImmediately(new StickerBubbleAnimationView.3(this, paramString), null, true);
  }
  
  private void a(Set<String> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!this.c.containsKey(str))
      {
        aevo localaevo = aevm.a(str);
        if (localaevo != null)
        {
          this.c.put(str, localaevo.a());
          this.d.put(str, Integer.valueOf(localaevo.a()));
          if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleAnimationView", 2, "get frames from cache");
          }
        }
        else if (!this.jdField_a_of_type_JavaUtilSet.contains(str))
        {
          this.jdField_a_of_type_JavaUtilSet.add(str);
          a(str);
        }
      }
    }
  }
  
  private void a(Set<String> paramSet, long paramLong, Canvas paramCanvas)
  {
    label392:
    label399:
    for (;;)
    {
      long l;
      int i;
      Object localObject2;
      Object localObject1;
      List localList;
      BitmapDrawable[] arrayOfBitmapDrawable;
      int k;
      Object localObject3;
      try
      {
        l = SystemClock.uptimeMillis();
        i = 0;
        paramSet = paramSet.iterator();
        if (paramSet.hasNext())
        {
          localObject2 = (String)paramSet.next();
          if (!this.c.containsKey(localObject2)) {
            break label399;
          }
          localObject1 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          localList = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject2);
          arrayOfBitmapDrawable = (BitmapDrawable[])this.c.get(localObject2);
          k = ((Integer)this.d.get(localObject2)).intValue();
          if (localObject1 == null) {
            break label392;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (aevp)((Iterator)localObject2).next();
            BitmapDrawable localBitmapDrawable = a(paramLong, ((aevp)localObject3).a(), arrayOfBitmapDrawable, k);
            ((aevp)localObject3).a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, paramLong, localBitmapDrawable);
            continue;
          }
          j = ((List)localObject1).size() + i;
        }
      }
      catch (Exception paramSet)
      {
        QLog.e("StickerBubbleAnimationView", 1, "throw exception in doDraw: " + paramSet);
        return;
      }
      for (;;)
      {
        i = j;
        if (localList == null) {
          break label399;
        }
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (aevp)((Iterator)localObject1).next();
          localObject3 = a(paramLong, ((aevp)localObject2).a(), arrayOfBitmapDrawable, k);
          ((aevp)localObject2).a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, paramLong, (Drawable)localObject3);
        }
        i = j + localList.size();
        break label399;
        if (this.jdField_a_of_type_Boolean) {
          a(paramCanvas, paramLong);
        }
        paramLong = SystemClock.uptimeMillis();
        if ((!QLog.isColorLevel()) || (this.jdField_b_of_type_Long % 60L != 0L)) {
          break;
        }
        QLog.d("StickerBubbleAnimationViewCost", 2, "draw " + i + " items, take time " + (paramLong - l));
        return;
        int j = i;
      }
    }
  }
  
  private aevp b(aevr paramaevr, long paramLong)
  {
    aevi localaevi = new aevi(aevr.a(paramaevr));
    aevh localaevh = new aevh(aevr.a(paramaevr));
    paramaevr = new aevp(((BitmapDrawable[])this.c.get(aevr.a(paramaevr)))[0], aevr.a(paramaevr), localaevi, localaevh, paramLong, 1.7D, true, aevr.a(paramaevr), aevr.a(paramaevr));
    paramaevr.a(this);
    return paramaevr;
  }
  
  private void b()
  {
    setBackgroundColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    if (aevl.a == null) {
      aevl.b();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(aevl.a);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(aevl.a);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#418DFF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(30.0F);
    setFocusable(false);
    setClickable(false);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(70);
    addOnAttachStateChangeListener(this);
  }
  
  private void c()
  {
    int j = 0;
    if ((this.jdField_a_of_type_JavaUtilMap.isEmpty()) && (this.jdField_b_of_type_JavaUtilMap.isEmpty())) {}
    label183:
    for (;;)
    {
      return;
      int k = 1;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      String str;
      do
      {
        i = k;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((List)this.jdField_a_of_type_JavaUtilMap.get(str)).isEmpty());
      int i = 0;
      localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((List)this.jdField_b_of_type_JavaUtilMap.get(str)).isEmpty()) {
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label183;
        }
        this.jdField_a_of_type_JavaLangString = "";
        if (this.jdField_a_of_type_Aevs == null) {
          break;
        }
        this.jdField_a_of_type_Aevs.a();
        return;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(aevp paramaevp)
  {
    post(new StickerBubbleAnimationView.1(this, paramaevp));
  }
  
  public void a(aevr paramaevr)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(aevr.a(paramaevr)))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = aevr.a(paramaevr);
    }
    this.jdField_a_of_type_Int += 1;
    List localList = (List)this.e.get(aevr.a(paramaevr));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.e.put(aevr.a(paramaevr), localObject);
    }
    ((List)localObject).add(paramaevr);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_b_of_type_Long += 1L;
    SystemClock.uptimeMillis();
    Set localSet = this.e.keySet();
    a(localSet);
    long l = SystemClock.uptimeMillis();
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      if (this.c.containsKey(localObject))
      {
        localObject = (List)this.e.get(localObject);
        if (localObject == null) {
          return;
        }
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext()) {
          a((aevr)localIterator2.next(), l);
        }
        ((List)localObject).clear();
      }
    }
    a(localSet, l, paramCanvas);
    c();
    SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationView", 2, "onViewAttachedToWindow");
    }
    aevm.a();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationView", 2, "onViewDetachedFromWindow");
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (this.jdField_a_of_type_Aevs != null) {
      this.jdField_a_of_type_Aevs.b();
    }
  }
  
  public void setAnimationCallback(aevs paramaevs)
  {
    this.jdField_a_of_type_Aevs = paramaevs;
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView
 * JD-Core Version:    0.7.0.1
 */