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
  private Paint a;
  private Paint b;
  private Typeface c;
  private Map<String, List<AnimationItem>> d = new HashMap();
  private Map<String, List<AnimationItem>> e = new HashMap();
  private FrameManager f;
  private Map<String, BitmapDrawable[]> g = new HashMap();
  private Map<String, Integer> h = new HashMap();
  private Map<String, List<AddItemRequest>> i = new HashMap();
  private boolean j = true;
  private String k = "";
  private int l = 0;
  private long m;
  private boolean n;
  private Set<String> o = new HashSet();
  private boolean p;
  private long q;
  private List<Long> r = new ArrayList(70);
  private int s;
  private StickerBubbleAnimationView.StickerBubbleAnimationCallback t;
  
  public StickerBubbleAnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  private float a(long paramLong)
  {
    long l1 = this.m;
    if (l1 == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - l1) % 400L;
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
  
  private void a(Canvas paramCanvas, long paramLong)
  {
    int i2 = this.l;
    if (i2 <= 1) {
      return;
    }
    if (i2 < 10) {
      i1 = Utils.a(i2 * 2.5F + 50.0F, getResources());
    }
    for (;;)
    {
      f1 = i1;
      break;
      if (i2 < 100) {
        i1 = Utils.a((i2 - 10) * 0.2777778F + 75.0F, getResources());
      } else {
        i1 = Utils.a(100.0F, getResources());
      }
    }
    String str = Integer.toString(i2);
    this.a.setTextSize(f1);
    this.b.setTextSize(f1);
    float f1 = this.a.measureText(str);
    int i1 = (int)((paramCanvas.getWidth() - f1) / 2.0F);
    i2 = (int)(paramCanvas.getHeight() / 8 - this.a.getFontMetrics().ascent);
    int i3 = paramCanvas.save();
    if (!this.p) {
      paramCanvas.rotate(a(paramLong), i1 + f1 / 2.0F, i2 + this.a.getFontMetrics().ascent / 2.0F);
    }
    f1 = i1;
    float f2 = i2;
    paramCanvas.drawText(str, f1, f2, this.b);
    paramCanvas.drawText(str, f1, f2, this.a);
    paramCanvas.restoreToCount(i3);
    if (this.m == 0L) {
      this.m = paramLong;
    }
  }
  
  private void a(AddItemRequest paramAddItemRequest, long paramLong)
  {
    Map localMap;
    if (paramAddItemRequest.c) {
      localMap = this.e;
    } else {
      localMap = this.d;
    }
    List localList = (List)localMap.get(paramAddItemRequest.b);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      localMap.put(paramAddItemRequest.b, localObject);
    }
    ((List)localObject).add(b(paramAddItemRequest, paramLong));
  }
  
  private void a(Set<String> paramSet, long paramLong, Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        long l1 = SystemClock.uptimeMillis();
        paramSet = paramSet.iterator();
        i1 = 0;
        if (paramSet.hasNext())
        {
          localObject1 = (String)paramSet.next();
          if (!this.g.containsKey(localObject1)) {
            break label384;
          }
          BitmapDrawable[] arrayOfBitmapDrawable = (BitmapDrawable[])this.g.get(localObject1);
          int i3 = ((Integer)this.h.get(localObject1)).intValue();
          List localList = (List)this.d.get(localObject1);
          if (localList == null) {
            break label381;
          }
          Object localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            AnimationItem localAnimationItem = (AnimationItem)((Iterator)localObject2).next();
            localAnimationItem.a(paramCanvas, paramLong, a(paramLong, localAnimationItem.b(), arrayOfBitmapDrawable, i3));
            continue;
          }
          i1 += localList.size();
          localList = (List)this.e.get(localObject1);
          i2 = i1;
          localObject1 = paramSet;
          if (localList == null) {
            break label391;
          }
          localObject1 = localList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AnimationItem)((Iterator)localObject1).next();
            ((AnimationItem)localObject2).a(paramCanvas, paramLong, a(paramLong, ((AnimationItem)localObject2).b(), arrayOfBitmapDrawable, i3));
            continue;
          }
          i2 = i1 + localList.size();
          localObject1 = paramSet;
          break label391;
        }
        if (this.j) {
          a(paramCanvas, paramLong);
        }
        if (QLog.isColorLevel())
        {
          if (this.q % 60L != 0L) {
            return;
          }
          paramLong = SystemClock.uptimeMillis();
          paramSet = new StringBuilder();
          paramSet.append("draw ");
          paramSet.append(i1);
          paramSet.append(" items, take time ");
          paramSet.append(paramLong - l1);
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
      int i2 = i1;
      label391:
      paramSet = (Set<String>)localObject1;
      int i1 = i2;
    }
  }
  
  private AnimationItem b(AddItemRequest paramAddItemRequest, long paramLong)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    Object localObject = ((BitmapDrawable[])this.g.get(paramAddItemRequest.b))[0];
    float f2 = paramAddItemRequest.g / ((Drawable)localObject).getIntrinsicWidth() / 3.0F * f1;
    f1 = f2;
    if (paramAddItemRequest.c) {
      f1 = f2 * 1.7F;
    }
    localObject = new ItemStatus.Velocity(paramAddItemRequest.d);
    ItemStatus.Acceleration localAcceleration = new ItemStatus.Acceleration(paramAddItemRequest.e);
    paramAddItemRequest = new AnimationItem(((BitmapDrawable[])this.g.get(paramAddItemRequest.b))[0], paramAddItemRequest.a, (ItemStatus.Velocity)localObject, localAcceleration, paramLong, f1, paramAddItemRequest.c, paramAddItemRequest.b, paramAddItemRequest.f);
    paramAddItemRequest.a(this);
    return paramAddItemRequest;
  }
  
  private void e()
  {
    if ((this.d.isEmpty()) && (this.e.isEmpty())) {
      return;
    }
    Object localObject = this.d.keySet().iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if (!((List)this.d.get(str)).isEmpty())
      {
        i1 = 0;
        break label89;
      }
    }
    int i1 = 1;
    label89:
    localObject = this.e.keySet().iterator();
    do
    {
      i2 = i1;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
    } while (((List)this.e.get(str)).isEmpty());
    int i2 = 0;
    if ((i2 != 0) && (!this.n) && (!this.p))
    {
      this.n = true;
      localObject = this.t;
      if (localObject != null) {
        ((StickerBubbleAnimationView.StickerBubbleAnimationCallback)localObject).a(this.o.size());
      }
      this.k = "";
      this.o.clear();
    }
  }
  
  public void a()
  {
    this.f = new FrameManager(getContext(), this.g, this.h);
    this.s = getContext().getResources().getDisplayMetrics().widthPixels;
    setBackgroundColor(0);
    this.a = new Paint();
    this.a.setColor(Color.parseColor("#FFDC4F"));
    this.a.setAntiAlias(true);
    this.b = new Paint(this.a);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(Color.parseColor("#418DFF"));
    this.b.setStrokeWidth(30.0F);
    Typeface localTypeface = this.c;
    if (localTypeface != null)
    {
      this.a.setTypeface(localTypeface);
      this.b.setTypeface(this.c);
    }
    setFocusable(false);
    setClickable(false);
    addOnAttachStateChangeListener(this);
  }
  
  public void a(AddItemRequest paramAddItemRequest)
  {
    if (!this.k.equals(paramAddItemRequest.b))
    {
      this.l = 0;
      this.k = paramAddItemRequest.b;
      this.o.add(this.k);
    }
    this.n = false;
    this.l += 1;
    List localList = (List)this.i.get(paramAddItemRequest.b);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.i.put(paramAddItemRequest.b, localObject);
    }
    ((List)localObject).add(paramAddItemRequest);
  }
  
  public void a(AnimationItem paramAnimationItem)
  {
    post(new StickerBubbleAnimationView.1(this, paramAnimationItem));
  }
  
  public void b()
  {
    this.p = true;
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "pauseAnim");
    }
  }
  
  public void c()
  {
    this.p = false;
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubble_AnimationView", 2, "resumeAnim");
    }
  }
  
  public void d()
  {
    this.k = "";
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas.getWidth() < this.s / 2) {
      return;
    }
    SystemClock.uptimeMillis();
    this.q += 1L;
    Set localSet = this.i.keySet();
    this.f.a(localSet);
    long l1 = SystemClock.uptimeMillis();
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      if (this.g.containsKey(localObject))
      {
        localObject = (List)this.i.get(localObject);
        if (localObject == null) {
          return;
        }
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext()) {
          a((AddItemRequest)localIterator2.next(), l1);
        }
        ((List)localObject).clear();
      }
    }
    a(localSet, l1, paramCanvas);
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
    this.d.clear();
    this.e.clear();
    this.i.clear();
    this.f.a();
    paramView = this.t;
    if (paramView != null) {
      paramView.a();
    }
  }
  
  public void setAnimationCallback(StickerBubbleAnimationView.StickerBubbleAnimationCallback paramStickerBubbleAnimationCallback)
  {
    this.t = paramStickerBubbleAnimationCallback;
  }
  
  public void setShowText(boolean paramBoolean, Typeface paramTypeface)
  {
    this.j = paramBoolean;
    this.c = paramTypeface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView
 * JD-Core Version:    0.7.0.1
 */