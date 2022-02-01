package com.tencent.mobileqq.apollo.touch;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public class CMActionTouchManager
  implements ICMTouchManager
{
  private static final Pattern a = Pattern.compile("\\d+#?_pet");
  private String b;
  private boolean c;
  private boolean d;
  private float e;
  private float f;
  private CMActionTouchManager.CheckForLongPress g = new CMActionTouchManager.CheckForLongPress(this);
  private int h = -1;
  private float i;
  private float j;
  private View k;
  private Context l;
  private long m = 350L;
  private OnApolloViewListener n;
  private boolean o = false;
  private boolean p;
  private RectF q;
  private List<ApolloSkeletonBounding> r = new CopyOnWriteArrayList();
  
  public CMActionTouchManager(View paramView, OnApolloViewListener paramOnApolloViewListener)
  {
    this.k = paramView;
    this.l = this.k.getContext();
    this.m = ViewConfiguration.getLongPressTimeout();
    this.n = paramOnApolloViewListener;
  }
  
  public static ClickInfo a(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList)
  {
    ClickInfo localClickInfo1 = new ClickInfo();
    localClickInfo1.a = -1;
    localClickInfo1.b = "";
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, new Object[] { "all bounding:", paramList });
    }
    ClickInfo localClickInfo2 = d(paramFloat1, paramFloat2, paramList, localClickInfo1);
    if (localClickInfo2 != null) {
      return localClickInfo2;
    }
    localClickInfo2 = c(paramFloat1, paramFloat2, paramList, localClickInfo1);
    if (localClickInfo2 != null) {
      return localClickInfo2;
    }
    localClickInfo2 = b(paramFloat1, paramFloat2, paramList, localClickInfo1);
    if (localClickInfo2 != null) {
      return localClickInfo2;
    }
    paramList = a(paramFloat1, paramFloat2, paramList, localClickInfo1);
    if (paramList != null) {
      return paramList;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("not cmshow area, mNode:");
      paramList.append(localClickInfo1.a);
      paramList.append(",mApolloId=");
      paramList.append(localClickInfo1.b);
      QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
    }
    return localClickInfo1;
  }
  
  @Nullable
  private static ClickInfo a(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList, ClickInfo paramClickInfo)
  {
    int i1 = paramList.size() - 1;
    while (i1 >= 0)
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)paramList.get(i1);
      if ((paramFloat1 >= localApolloSkeletonBounding.x) && (paramFloat1 <= localApolloSkeletonBounding.x + localApolloSkeletonBounding.width) && (paramFloat2 >= localApolloSkeletonBounding.y) && (paramFloat2 <= localApolloSkeletonBounding.y + localApolloSkeletonBounding.height))
      {
        paramClickInfo.a = 1;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        paramClickInfo.b = paramList;
        if (!TextUtils.isEmpty(paramClickInfo.b))
        {
          paramList = a.matcher(paramClickInfo.b);
          if ((paramList != null) && (paramList.matches())) {
            paramClickInfo.a = 5;
          }
        }
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("other cmshow area, mNode:");
          paramList.append(paramClickInfo.a);
          paramList.append(",mApolloId=");
          paramList.append(paramClickInfo.b);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return paramClickInfo;
      }
      i1 -= 1;
    }
    return null;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.o)
    {
      float f1 = this.k.getWidth();
      float f2 = this.k.getHeight();
      if ((f1 > 0.0F) && (f2 > 0.0F))
      {
        if ((paramFloat1 < f1 / 2.0F) && (paramFloat2 < f2) && (this.h != 1000)) {
          return true;
        }
        if (paramFloat2 > f2) {
          return true;
        }
      }
    }
    return false;
  }
  
  @Nullable
  private static ClickInfo b(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList, ClickInfo paramClickInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)paramList.next();
      if ((localApolloSkeletonBounding.bubbleWidth > 0.0F) && (localApolloSkeletonBounding.bubbleHeight > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.bubbleX) && (paramFloat1 <= localApolloSkeletonBounding.bubbleX + localApolloSkeletonBounding.bubbleWidth) && (paramFloat2 >= localApolloSkeletonBounding.bubbleY) && (paramFloat2 <= localApolloSkeletonBounding.bubbleY + localApolloSkeletonBounding.bubbleHeight))
      {
        paramClickInfo.a = 1000;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        paramClickInfo.b = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("bubble, mNode:");
          paramList.append(paramClickInfo.a);
          paramList.append(",mApolloId=");
          paramList.append(paramClickInfo.b);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return paramClickInfo;
      }
    }
    return null;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.g;
    if (paramMotionEvent != null) {
      this.k.removeCallbacks(paramMotionEvent);
    }
    if (c())
    {
      int i1 = 8;
      int i2 = this.h;
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4)
          {
            if (i2 != 5)
            {
              if (i2 == 1000) {
                i1 = 7;
              }
            }
            else {
              i1 = 12;
            }
          }
          else {
            i1 = 11;
          }
        }
        else {
          i1 = 10;
        }
      }
      else {
        i1 = 9;
      }
      this.n.a(i1, this.b);
      this.b = null;
    }
  }
  
  @Nullable
  private static ClickInfo c(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList, ClickInfo paramClickInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)paramList.next();
      if ((localApolloSkeletonBounding.brand1Width > 0.0F) && (localApolloSkeletonBounding.brand1Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand1X) && (paramFloat1 <= localApolloSkeletonBounding.brand1X + localApolloSkeletonBounding.brand1Width) && (paramFloat2 >= localApolloSkeletonBounding.brand1Y) && (paramFloat2 <= localApolloSkeletonBounding.brand1Y + localApolloSkeletonBounding.brand1Height))
      {
        paramClickInfo.a = 3;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        paramClickInfo.b = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("sprite brand, mNode:");
          paramList.append(paramClickInfo.a);
          paramList.append(",mApolloId=");
          paramList.append(paramClickInfo.b);
          QLog.d("ApolloSkeletonBounding", 2, paramList.toString());
        }
        return paramClickInfo;
      }
      if ((localApolloSkeletonBounding.brand2Width > 0.0F) && (localApolloSkeletonBounding.brand2Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand2X) && (paramFloat1 <= localApolloSkeletonBounding.brand2X + localApolloSkeletonBounding.brand2Width) && (paramFloat2 >= localApolloSkeletonBounding.brand2Y) && (paramFloat2 <= localApolloSkeletonBounding.brand2Y + localApolloSkeletonBounding.brand2Height))
      {
        paramClickInfo.a = 4;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        paramClickInfo.b = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("pet brand, mNode:");
          paramList.append(paramClickInfo.a);
          paramList.append(",mApolloId=");
          paramList.append(paramClickInfo.b);
          QLog.d("ApolloSkeletonBounding", 2, paramList.toString());
        }
        return paramClickInfo;
      }
    }
    return null;
  }
  
  private boolean c()
  {
    return (this.n != null) && (!this.d) && (!this.c) && ((this.h >= 0) || (!TextUtils.isEmpty(this.b)));
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.c = false;
    this.d = false;
    if (this.g == null) {
      this.g = new CMActionTouchManager.CheckForLongPress(this);
    }
    this.g.a();
    this.k.postDelayed(this.g, this.m);
    this.i = paramMotionEvent.getY();
    this.j = paramMotionEvent.getX();
    float f1 = this.j;
    this.e = f1;
    float f2 = this.i;
    this.f = f2;
    f2 = this.k.getBottom() - this.k.getTop() - f2;
    this.h = -1;
    this.b = "";
    if (this.n == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("list length:");
      paramMotionEvent.append(this.r.size());
      paramMotionEvent.append("mPY = ");
      paramMotionEvent.append(this.i);
      paramMotionEvent.append(", pty = ");
      paramMotionEvent.append(f2);
      paramMotionEvent.append(",mPX = ");
      paramMotionEvent.append(this.j);
      paramMotionEvent.append(", xInView = ");
      paramMotionEvent.append(f1);
      paramMotionEvent.append("super.getBottom() = ");
      paramMotionEvent.append(this.k.getBottom());
      paramMotionEvent.append("super.getTop()");
      paramMotionEvent.append(this.k.getTop());
      QLog.d("[cmshow][CMActionTouchManager]", 2, paramMotionEvent.toString());
    }
    paramMotionEvent = a(f1, f2, this.r);
    this.h = paramMotionEvent.a;
    this.b = paramMotionEvent.b;
    if (a(f1, f2)) {
      return false;
    }
    if ((this.h >= 0) || (!TextUtils.isEmpty(this.b))) {
      bool = true;
    }
    return bool;
  }
  
  private int d()
  {
    View localView = this.k;
    if ((localView instanceof ApolloTextureView)) {
      return ((ApolloTextureView)localView).getWindowAttachCount();
    }
    if ((localView instanceof ApolloSurfaceView)) {
      return ((ApolloSurfaceView)localView).getWindowAttachCount();
    }
    return 0;
  }
  
  @Nullable
  private static ClickInfo d(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList, ClickInfo paramClickInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)paramList.next();
      if ((localApolloSkeletonBounding.giftHeight > 0.0F) && (localApolloSkeletonBounding.giftWidth > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.giftX) && (paramFloat1 <= localApolloSkeletonBounding.giftX + localApolloSkeletonBounding.giftWidth) && (paramFloat2 >= localApolloSkeletonBounding.giftY) && (paramFloat2 <= localApolloSkeletonBounding.giftY + localApolloSkeletonBounding.giftHeight))
      {
        paramClickInfo.a = 2;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        paramClickInfo.b = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("gift mNode:");
          paramList.append(paramClickInfo.a);
          paramList.append(",mApolloId=");
          paramList.append(paramClickInfo.b);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return paramClickInfo;
      }
    }
    return null;
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    this.j = paramMotionEvent.getX();
    this.i = paramMotionEvent.getY();
    if ((Math.abs(this.j - this.e) > ViewConfiguration.get(this.l).getScaledTouchSlop()) || (Math.abs(this.i - this.f) > ViewConfiguration.get(this.l).getScaledTouchSlop()))
    {
      this.k.removeCallbacks(this.g);
      this.d = false;
      this.c = true;
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.g;
    if (paramMotionEvent != null) {
      this.k.removeCallbacks(paramMotionEvent);
    }
  }
  
  public float a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, "[getManRectMaxHeight]");
    }
    float f1 = 0.0F;
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext()) {
      f1 = Math.max(f1, ((ApolloSkeletonBounding)localIterator.next()).height);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f1) });
    }
    return f1;
  }
  
  public void a(RectF paramRectF)
  {
    this.q = paramRectF;
  }
  
  public void a(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt)
  {
    List localList = this.r;
    int i1 = localList.size();
    int i3 = 1;
    i1 -= 1;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 < 0) {
        break;
      }
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)localList.get(i1);
      if (localApolloSkeletonBounding.name.equals(paramApolloSkeletonBounding.name))
      {
        if (paramInt == 0) {
          localApolloSkeletonBounding.updateData(paramApolloSkeletonBounding);
        } else {
          localList.remove(localApolloSkeletonBounding);
        }
        i2 = 0;
        break;
      }
      i1 -= 1;
    }
    if (i2 != 0) {
      localList.add(paramApolloSkeletonBounding);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.p) {
      return false;
    }
    if (this.n == null) {
      return false;
    }
    RectF localRectF = this.q;
    if (localRectF != null)
    {
      if (!localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        QLog.d("[cmshow][CMActionTouchManager]", 2, "touch not in mTouchableRect!");
        return false;
      }
      QLog.d("[cmshow][CMActionTouchManager]", 2, "touch in mTouchableRect!");
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          e(paramMotionEvent);
          return false;
        }
        d(paramMotionEvent);
        return true;
      }
      b(paramMotionEvent);
      return false;
    }
    return c(paramMotionEvent);
  }
  
  public List<ApolloSkeletonBounding> b()
  {
    return this.r;
  }
  
  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.CMActionTouchManager
 * JD-Core Version:    0.7.0.1
 */