package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameCache;
import com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.AnimationItem;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.AnimationItem.ItemAnimationCallback;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Acceleration;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Velocity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;

public class StickerBubbleAnimationView
  extends View
  implements View.OnAttachStateChangeListener, AnimationItem.ItemAnimationCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback;
  private FrameManager jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameFrameManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList(70);
  private Map<String, List<AnimationItem>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Map<String, List<AnimationItem>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private Map<String, BitmapDrawable[]> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private Map<String, Integer> d = new HashMap();
  private Map<String, List<AddItemRequest>> e = new HashMap();
  
  public StickerBubbleAnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  private float a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - l) % 400L;
    Double.isNaN(d1);
    d1 = d1 / 400.0D * 20.0D;
    if (d1 < 10.0D) {
      d1 -= 5.0D;
    } else {
      d1 = 10.0D - (d1 - 10.0D) - 5.0D;
    }
    return (float)d1;
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
  
  private AnimationItem a(AddItemRequest paramAddItemRequest, long paramLong)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    Object localObject = ((BitmapDrawable[])this.jdField_c_of_type_JavaUtilMap.get(paramAddItemRequest.jdField_a_of_type_JavaLangString))[0];
    float f2 = paramAddItemRequest.jdField_b_of_type_Int / ((Drawable)localObject).getIntrinsicWidth() / 3.0F * f1;
    f1 = f2;
    if (paramAddItemRequest.jdField_a_of_type_Boolean) {
      f1 = f2 * 1.7F;
    }
    localObject = new ItemStatus.Velocity(paramAddItemRequest.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity);
    ItemStatus.Acceleration localAcceleration = new ItemStatus.Acceleration(paramAddItemRequest.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration);
    paramAddItemRequest = new AnimationItem(((BitmapDrawable[])this.jdField_c_of_type_JavaUtilMap.get(paramAddItemRequest.jdField_a_of_type_JavaLangString))[0], paramAddItemRequest.jdField_a_of_type_AndroidGraphicsPoint, (ItemStatus.Velocity)localObject, localAcceleration, paramLong, f1, paramAddItemRequest.jdField_a_of_type_Boolean, paramAddItemRequest.jdField_a_of_type_JavaLangString, paramAddItemRequest.jdField_a_of_type_Int);
    paramAddItemRequest.a(this);
    return paramAddItemRequest;
  }
  
  private void a(Canvas paramCanvas, long paramLong)
  {
    int j = this.jdField_a_of_type_Int;
    if (j <= 1) {
      return;
    }
    if (j < 10) {
      i = Utils.a(j * 2.5F + 50.0F, getResources());
    }
    for (;;)
    {
      f1 = i;
      break;
      if (j < 100) {
        i = Utils.a((j - 10) * 0.2777778F + 75.0F, getResources());
      } else {
        i = Utils.a(100.0F, getResources());
      }
    }
    String str = Integer.toString(j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f1);
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
    int i = (int)((paramCanvas.getWidth() - f1) / 2.0F);
    j = (int)(paramCanvas.getHeight() / 8 - this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent);
    int k = paramCanvas.save();
    if (!this.jdField_c_of_type_Boolean) {
      paramCanvas.rotate(a(paramLong), i + f1 / 2.0F, j + this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent / 2.0F);
    }
    f1 = i;
    float f2 = j;
    paramCanvas.drawText(str, f1, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(str, f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(k);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  private void a(AddItemRequest paramAddItemRequest, long paramLong)
  {
    Map localMap;
    if (paramAddItemRequest.jdField_a_of_type_Boolean) {
      localMap = this.jdField_b_of_type_JavaUtilMap;
    } else {
      localMap = this.jdField_a_of_type_JavaUtilMap;
    }
    List localList = (List)localMap.get(paramAddItemRequest.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      localMap.put(paramAddItemRequest.jdField_a_of_type_JavaLangString, localObject);
    }
    ((List)localObject).add(a(paramAddItemRequest, paramLong));
  }
  
  private void a(Set<String> paramSet, long paramLong, Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        long l = SystemClock.uptimeMillis();
        paramSet = paramSet.iterator();
        i = 0;
        if (paramSet.hasNext())
        {
          localObject1 = (String)paramSet.next();
          if (!this.jdField_c_of_type_JavaUtilMap.containsKey(localObject1)) {
            break label384;
          }
          BitmapDrawable[] arrayOfBitmapDrawable = (BitmapDrawable[])this.jdField_c_of_type_JavaUtilMap.get(localObject1);
          int k = ((Integer)this.d.get(localObject1)).intValue();
          List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
          if (localList == null) {
            break label381;
          }
          Object localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            AnimationItem localAnimationItem = (AnimationItem)((Iterator)localObject2).next();
            localAnimationItem.a(paramCanvas, paramLong, a(paramLong, localAnimationItem.a(), arrayOfBitmapDrawable, k));
            continue;
          }
          i += localList.size();
          localList = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject1);
          j = i;
          localObject1 = paramSet;
          if (localList == null) {
            break label391;
          }
          localObject1 = localList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AnimationItem)((Iterator)localObject1).next();
            ((AnimationItem)localObject2).a(paramCanvas, paramLong, a(paramLong, ((AnimationItem)localObject2).a(), arrayOfBitmapDrawable, k));
            continue;
          }
          j = i + localList.size();
          localObject1 = paramSet;
          break label391;
        }
        if (this.jdField_a_of_type_Boolean) {
          a(paramCanvas, paramLong);
        }
        if (QLog.isColorLevel())
        {
          if (this.jdField_b_of_type_Long % 60L != 0L) {
            return;
          }
          paramLong = SystemClock.uptimeMillis();
          paramSet = new StringBuilder();
          paramSet.append("draw ");
          paramSet.append(i);
          paramSet.append(" items, take time ");
          paramSet.append(paramLong - l);
          QLog.d("StickerBubble_AnimationView_Cost", 2, paramSet.toString());
          return;
        }
      }
      catch (Exception paramSet)
      {
        QLog.e("StickerBubble_AnimationView", 1, "throw exception in doDraw: ", paramSet);
      }
      return;
      label381:
      continue;
      label384:
      Object localObject1 = paramSet;
      int j = i;
      label391:
      paramSet = (Set<String>)localObject1;
      int i = j;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilMap.isEmpty()) && (this.jdField_b_of_type_JavaUtilMap.isEmpty())) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!((List)this.jdField_a_of_type_JavaUtilMap.get(str)).isEmpty())
      {
        i = 0;
        break label89;
      }
    }
    int i = 1;
    label89:
    localObject = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    do
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
    } while (((List)this.jdField_b_of_type_JavaUtilMap.get(str)).isEmpty());
    int j = 0;
    if ((j != 0) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback;
      if (localObject != null) {
        ((StickerBubbleAnimationView.StickerBubbleAnimationCallback)localObject).a(this.jdField_a_of_type_JavaUtilSet.size());
      }
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameFrameManager = new FrameManager(getContext(), this.jdField_c_of_type_JavaUtilMap, this.d);
    this.jdField_b_of_type_Int = getContext().getResources().getDisplayMetrics().widthPixels;
    setBackgroundColor(0);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#418DFF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(30.0F);
    Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    if (localTypeface != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(localTypeface);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    setFocusable(false);
    setClickable(false);
    addOnAttachStateChangeListener(this);
  }
  
  public void a(AddItemRequest paramAddItemRequest)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramAddItemRequest.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = paramAddItemRequest.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int += 1;
    List localList = (List)this.e.get(paramAddItemRequest.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.e.put(paramAddItemRequest.jdField_a_of_type_JavaLangString, localObject);
    }
    ((List)localObject).add(paramAddItemRequest);
  }
  
  public void a(AnimationItem paramAnimationItem)
  {
    post(new StickerBubbleAnimationView.1(this, paramAnimationItem));
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "pauseAnim");
    }
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "resumeAnim");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas.getWidth() < this.jdField_b_of_type_Int / 2) {
      return;
    }
    SystemClock.uptimeMillis();
    this.jdField_b_of_type_Long += 1L;
    Set localSet = this.e.keySet();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameFrameManager.a(localSet);
    long l = SystemClock.uptimeMillis();
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      if (this.jdField_c_of_type_JavaUtilMap.containsKey(localObject))
      {
        localObject = (List)this.e.get(localObject);
        if (localObject == null) {
          return;
        }
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext()) {
          a((AddItemRequest)localIterator2.next(), l);
        }
        ((List)localObject).clear();
      }
    }
    a(localSet, l, paramCanvas);
    e();
    invalidate();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "onViewAttachedToWindow");
    }
    FrameCache.a();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "onViewDetachedFromWindow");
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.e.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleFrameFrameManager.a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback;
    if (paramView != null) {
      paramView.a();
    }
  }
  
  public void setAnimationCallback(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleAnimationView$StickerBubbleAnimationCallback = paramStickerBubbleAnimationCallback;
  }
  
  public void setShowText(boolean paramBoolean, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView
 * JD-Core Version:    0.7.0.1
 */