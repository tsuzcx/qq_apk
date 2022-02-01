package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class FloorJumper
  extends AIOAnimationConatiner.AIOAnimator
{
  static final float i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
  static final float[] j = { 0.0F, 3.82F, 7.28F, 10.38F, 13.12F, 15.499998F, 17.52F, 19.18F, 20.48F, 21.420002F, 21.999998F, 22.219999F, 22.08F, 21.580004F, 20.720001F, 19.500004F, 17.920002F, 15.98F, 13.680004F, 11.020004F, 8.0F, 4.620003F, 0.8799973F, 0.0F, 0.0F, 1.568F, 2.848F, 3.839999F, 4.543999F, 4.959999F, 5.087998F, 4.927998F, 4.479999F, 3.744F, 2.719999F, 1.407999F, 0.0F, 0.0F, 0.5824001F, 0.9344F, 1.056F, 0.9472004F, 0.6080008F, 0.0384007F, 0.0F };
  static final float[] k = { 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.042F, 1.024F, 1.006F, 0.988F, 0.97F, 0.952F, 0.966F, 0.984F, 1.002F, 1.02F, 1.038F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.0356F, 1.0212F, 1.0068F, 0.9924F, 0.978F, 0.9636F, 0.9508F, 0.9652F, 0.9796F, 0.994F, 1.0084F, 1.0228F, 1.0436F, 0.98488F, 0.97336F, 0.96184F, 0.95032F, 0.9612F, 0.97272F, 0.98424F, 1.02288F };
  static final int l = j.length * 10;
  static final float m;
  static final float n;
  static final float o;
  private View A;
  private long B = 0L;
  int d = 0;
  boolean e = true;
  long f = 0L;
  long g = 0L;
  int h = -1;
  long p = 0L;
  int q;
  int r;
  int s;
  int t;
  int u;
  int v;
  float w;
  float x;
  float y = i * 750.0F;
  private Drawable z;
  
  static
  {
    float f1 = i;
    m = 39.772724F * f1;
    n = 17.5F * f1;
    o = f1 * 3000.0F;
  }
  
  public FloorJumper(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private BaseChatItemLayout a(long paramLong)
  {
    int i1 = 0;
    Object localObject2;
    if (paramLong == 0L) {
      while (i1 < this.b.getChildCount())
      {
        localObject1 = this.b.getChildAt(i1);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject2 = (BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)localObject1);
          if ((((BaseBubbleBuilder.ViewHolder)localObject2).k != 0) && (((BaseBubbleBuilder.ViewHolder)localObject2).h.getTop() + ((View)localObject1).getTop() + BaseChatItemLayout.k > 0)) {
            return (BaseChatItemLayout)localObject1;
          }
        }
        i1 += 1;
      }
    }
    int i6 = this.b.getHeaderViewsCount();
    int i7 = this.b.getFooterViewsCount();
    i1 = this.b.getFirstVisiblePosition();
    int i8 = this.b.getLastVisiblePosition();
    int i2;
    if (i1 > 1)
    {
      i1 -= 1;
      i2 = 1;
    }
    else
    {
      i2 = 0;
    }
    Object localObject1 = this.b.getAdapter();
    if (localObject1 == null) {
      return null;
    }
    int i9 = ((ListAdapter)localObject1).getCount();
    int i3 = i1;
    int i5;
    for (int i4 = 0; i3 <= i8; i4 = i5)
    {
      if (i3 < i6)
      {
        i5 = i4;
      }
      else
      {
        if (i3 >= i9 - i7) {
          return null;
        }
        if (i4 == 0)
        {
          i5 = i4;
          if (paramLong == ((ListAdapter)localObject1).getItemId(i3)) {
            i5 = 1;
          }
        }
        else
        {
          localObject2 = this.b.getChildAt(i3 - i1 - i2);
          if (((localObject2 instanceof BaseChatItemLayout)) && (((BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)localObject2)).k != 0)) {
            return (BaseChatItemLayout)localObject2;
          }
          i5 = i4;
          if (localObject2 == null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("not found idx: ");
            ((StringBuilder)localObject2).append(i3);
            ((StringBuilder)localObject2).append(", first: ");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(", last: ");
            ((StringBuilder)localObject2).append(i8);
            QLog.i("floor_jumper", 2, ((StringBuilder)localObject2).toString());
            i5 = i4;
          }
        }
      }
      i3 += 1;
    }
    return null;
  }
  
  private void a(AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage)
  {
    EggsUtil.a(null, "0X800B072", paramChatMessage.frienduin, paramAioAnimationRule);
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https")));
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject.length >= 5) && ((paramArrayOfObject[3] instanceof AioAnimationRule)))
    {
      if (!(paramArrayOfObject[4] instanceof ChatMessage)) {
        return;
      }
      AioAnimationRule localAioAnimationRule = (AioAnimationRule)paramArrayOfObject[3];
      if (!a(localAioAnimationRule.l)) {
        return;
      }
      paramArrayOfObject = (ChatMessage)paramArrayOfObject[4];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set jump url, url = ");
        localStringBuilder.append(localAioAnimationRule.l);
        QLog.d("FloorJumper", 2, localStringBuilder.toString());
      }
      this.A.setOnClickListener(new FloorJumper.1(this, localAioAnimationRule, paramArrayOfObject));
    }
  }
  
  int a(int paramInt, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i1;
    int i3;
    if (paramViewHolder.q.isSend())
    {
      i1 = paramViewHolder.h.getLeft() + BaseChatItemLayout.getBubblePaddingAlignError() + BaseChatItemLayout.getTextPaddingAlignError();
      i3 = paramViewHolder.h.getRight() - BaseChatItemLayout.getBubblePaddingAlignHead();
      i2 = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    else
    {
      i1 = paramViewHolder.h.getLeft() + BaseChatItemLayout.getBubblePaddingAlignHead() + BaseChatItemLayout.getTextPaddingAlignHead();
      i3 = paramViewHolder.h.getRight() - BaseChatItemLayout.getBubblePaddingAlignError();
      i2 = BaseChatItemLayout.getBubblePaddingAlignError();
    }
    int i2 = i3 - i2;
    double d3;
    if (paramInt <= i1)
    {
      if (i2 - n < i1) {
        return i1;
      }
      d1 = Math.random();
      d2 = i2 - i1 - n;
      Double.isNaN(d2);
      d3 = i1;
      Double.isNaN(d3);
      return (int)(d1 * d2 + d3);
    }
    if (paramInt >= i2)
    {
      f1 = i1;
      f2 = n;
      if (f1 + f2 < i2) {
        return i2;
      }
      d1 = f1 + f2;
      d2 = Math.random();
      d3 = i2 - i1 - n;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (int)(d1 + d2 * d3);
    }
    float f1 = paramInt - i1;
    float f2 = n;
    if ((f1 <= f2) && (i2 - paramInt <= f2)) {
      return paramInt;
    }
    f2 = n;
    if ((f1 > f2) && (i2 - paramInt > f2))
    {
      d1 = Math.random();
      f2 = i2 - i1;
      f1 = n;
      d2 = f2 - f1 - f1;
      Double.isNaN(d2);
      f2 = (int)(d1 * d2);
      return (int)(i1 + f1 + f2);
    }
    if (f1 > n)
    {
      d1 = Math.random();
      d2 = f1 - n;
      Double.isNaN(d2);
      f1 = (int)(d1 * d2);
      return (int)(paramInt - f1);
    }
    double d1 = Math.random();
    double d2 = i2 - paramInt - n;
    Double.isNaN(d2);
    f1 = (int)(d1 * d2);
    return (int)(paramInt + f1);
  }
  
  @TargetApi(11)
  void a(int paramInt1, int paramInt2, float... paramVarArgs)
  {
    int i1 = this.A.getLeft();
    int i2 = this.A.getWidth() / 2;
    int i3 = this.A.getBottom();
    this.A.offsetTopAndBottom(paramInt2 - i3);
    this.A.offsetLeftAndRight(paramInt1 - (i1 + i2));
    if (VersionUtils.e())
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        this.A.setScaleY(paramVarArgs[0]);
        this.A.setScaleX(2.0F - paramVarArgs[0]);
        return;
      }
      this.A.setScaleY(1.0F);
      this.A.setScaleX(1.0F);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.e)
    {
      int i1;
      if (paramBoolean)
      {
        i1 = this.d;
        int i2;
        BaseBubbleBuilder.ViewHolder localViewHolder;
        int i3;
        int i4;
        int i5;
        if ((i1 != 1) && (i1 != 2) && (i1 != 3))
        {
          if (i1 == 4)
          {
            i1 = AIOUtils.a(this.g, this.b.getAdapter());
            i2 = AIOUtils.a(this.f, this.b.getAdapter());
            if ((i1 >= this.b.getFirstVisiblePosition()) && (i1 <= this.b.getLastVisiblePosition()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(AIOUtils.a(this.b, i1));
              if (localViewHolder != null)
              {
                i2 = localViewHolder.h.getTop();
                i3 = localViewHolder.j.getTop();
                i4 = BaseChatItemLayout.k;
                i5 = this.b.getScrollY();
                i1 = this.t;
                i2 = i2 + i3 + i4 - i5 - (this.r + i1);
                if (i2 != 0)
                {
                  this.t = (i1 + i2);
                  this.v += i2;
                  this.A.offsetTopAndBottom(i2);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if ((i2 >= this.b.getFirstVisiblePosition()) && (i2 <= this.b.getLastVisiblePosition()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(AIOUtils.a(this.b, i2));
              if (localViewHolder != null)
              {
                i2 = localViewHolder.h.getTop();
                i3 = localViewHolder.j.getTop();
                i4 = BaseChatItemLayout.k;
                i5 = this.b.getScrollY();
                i1 = this.t;
                i2 = i2 + i3 + i4 - i5 - (this.r + i1);
                if (i2 != 0)
                {
                  this.t = (i1 + i2);
                  this.v += i2;
                  this.A.offsetTopAndBottom(i2);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if (i1 < this.b.getFirstVisiblePosition())
            {
              this.v = -1;
            }
            else if (i2 > this.b.getLastVisiblePosition())
            {
              this.d = 5;
              this.f = 0L;
              this.g = 0L;
            }
            else
            {
              c();
              return false;
            }
          }
        }
        else
        {
          i1 = AIOUtils.a(this.g, this.b.getAdapter());
          if (i1 < this.b.getFirstVisiblePosition())
          {
            this.v = -1;
          }
          else if (i1 > this.b.getLastVisiblePosition())
          {
            if (this.B > 0L)
            {
              c();
              return false;
            }
            this.d = 5;
            this.f = 0L;
            this.g = 0L;
          }
          else
          {
            localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(AIOUtils.a(this.b, i1));
            if (localViewHolder != null)
            {
              i2 = localViewHolder.h.getTop();
              i3 = localViewHolder.j.getTop();
              i4 = BaseChatItemLayout.k;
              i5 = this.b.getScrollY();
              i1 = this.t;
              i2 = i2 + i3 + i4 - i5 - (this.r + i1);
              if (i2 != 0)
              {
                this.t = (i1 + i2);
                this.v += i2;
                this.A.offsetTopAndBottom(i2);
              }
            }
            else
            {
              c();
              return false;
            }
          }
        }
      }
      if ((this.a != null) && (this.A != null))
      {
        if ((this.v <= this.a.getHeight() + this.A.getHeight()) && (this.u >= -this.A.getWidth() / 2) && (this.u <= this.a.getWidth() + this.A.getWidth() / 2))
        {
          if (this.v <= 0)
          {
            i1 = this.d;
            if (i1 != 1)
            {
              if ((i1 != 2) && (i1 != 3) && (i1 != 4))
              {
                if (i1 != 5) {
                  return true;
                }
                a(new Object[0]);
                a(this.u, this.v, new float[0]);
                return true;
              }
              i1 = AIOUtils.a(this.g, this.b.getAdapter());
              if ((i1 < this.b.getFirstVisiblePosition()) || (i1 > this.b.getLastVisiblePosition()))
              {
                a(new Object[0]);
                a(this.u, this.v, new float[0]);
              }
            }
          }
          return true;
        }
        c();
        return false;
      }
      this.e = false;
      this.z = null;
      this.A = null;
      return false;
    }
    c();
    return false;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.e) {
      return a(true);
    }
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    Object localObject = this.A;
    if (localObject == null)
    {
      this.z = ((Drawable)paramVarArgs[0]);
      localObject = this.z;
      if (localObject == null) {
        return false;
      }
      localObject = ((Drawable)localObject).getBounds();
      this.A = new View(this.b.getContext());
      this.A.setBackgroundDrawable(this.z);
      this.a.addViewInLayout(this.A, -1, AIOAnimationConatiner.a, false);
      if (((Rect)localObject).isEmpty()) {
        this.A.layout(-this.z.getIntrinsicWidth(), -this.z.getIntrinsicHeight(), 0, 0);
      } else {
        this.A.layout(-((Rect)localObject).width(), -((Rect)localObject).height(), 0, 0);
      }
      if (VersionUtils.e())
      {
        localObject = this.A;
        ((View)localObject).setPivotX(((View)localObject).getWidth() / 2);
        localObject = this.A;
        ((View)localObject).setPivotY(((View)localObject).getHeight());
        this.A.setLayerType(2, null);
      }
    }
    else
    {
      ((View)localObject).offsetLeftAndRight(-((View)localObject).getRight());
      localObject = this.A;
      ((View)localObject).offsetTopAndBottom(-((View)localObject).getBottom());
    }
    this.d = 2;
    this.e = true;
    if (paramVarArgs.length > 1) {
      localObject = paramVarArgs[1];
    } else {
      localObject = Integer.valueOf(0);
    }
    int i1 = ((Integer)localObject).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start floor jumper. delay: ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("eggs", 2, ((StringBuilder)localObject).toString());
    }
    this.p = (AnimationUtils.currentAnimationTimeMillis() + i1);
    this.d = 1;
    b(paramVarArgs);
    return true;
  }
  
  protected void c()
  {
    this.e = false;
    this.a.removeViewInLayout(this.A);
    this.z = null;
    this.A = null;
  }
  
  long e()
  {
    if (!this.e) {
      return -1L;
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    int i1 = this.d;
    float f1;
    if (i1 != 1)
    {
      float f2;
      float f3;
      int i2;
      if (i1 != 2)
      {
        if (i1 == 3) {
          break label698;
        }
        if (i1 != 4)
        {
          if (i1 != 5) {
            return -1L;
          }
          f1 = (float)(l1 - this.p) / 1000.0F;
          f2 = this.x;
          f3 = o;
          i1 = (int)(f2 * f1 + f3 * f1 * f1 / 2.0F);
          i2 = (int)(this.w * f1);
          f1 = Math.min(this.y, Math.abs(f2 + f3 * f1)) / this.y;
          this.v = (this.t + i1);
          this.u = (this.s + i2);
          if ((this.v <= this.a.getHeight() + this.A.getHeight()) && (this.u >= -this.A.getWidth() / 2) && (this.u <= this.a.getWidth() + this.A.getWidth() / 2))
          {
            a(this.u, this.v, new float[] { f1 * 0.25F + 0.9F });
            return FloorJumperSet.d;
          }
          a(0, this.A.getWidth(), new float[0]);
          c();
          return -1L;
        }
      }
      l2 = this.B;
      if (l2 == 0L)
      {
        f1 = (float)(l1 - this.p) / 1000.0F;
        f2 = this.x;
        f3 = o;
        i1 = (int)(f2 * f1 + f3 * f1 * f1 / 2.0F);
        int i3 = (int)(this.w * f1);
        f1 = Math.min(this.y, Math.abs(f2 + f3 * f1)) / this.y * 0.25F + 0.9F;
        i2 = this.r;
        if (i1 > i2)
        {
          f1 = 1.0F;
          this.B = l1;
          i1 = i2;
        }
        this.v = (this.t + i1);
        this.u = (this.s + i3);
        a(this.u, this.v, new float[] { f1 });
        return FloorJumperSet.d;
      }
      if (l1 - l2 <= l)
      {
        f1 = (float)(l1 - l2) / 1000.0F;
        i2 = Math.round((float)(l1 - l2) / 10.0F);
        localObject = j;
        i1 = i2;
        if (i2 >= localObject.length) {
          i1 = localObject.length - 1;
        }
        f1 = (int)(Math.max(Math.min(this.w, m), -m) * f1);
        f2 = j[i1];
        f3 = i;
        float f4 = k[i1];
        this.u = ((int)(this.s + this.q + f1));
        this.v = ((int)(this.t + this.r - f2 * f3));
        a(this.u, this.v, new float[] { f4 });
        return FloorJumperSet.d;
      }
      this.v = (this.t + this.r);
      a(this.u, this.v, new float[0]);
      i1 = (int)(Math.random() * 800.0D + 500.0D - 400.0D);
      l1 = AnimationUtils.currentAnimationTimeMillis();
      l2 = i1;
      this.p = (l1 + l2);
      this.d = 3;
      return l2;
    }
    label698:
    long l2 = this.p;
    if (l1 < l2) {
      return l2 - l1;
    }
    BaseBubbleBuilder.ViewHolder localViewHolder;
    double d1;
    double d2;
    if (this.d == 1)
    {
      this.p = l1;
      localObject = a(0L);
      if (localObject != null)
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)localObject);
        if (localViewHolder != null)
        {
          this.d = 2;
          this.f = 0L;
          this.g = localViewHolder.q.uniseq;
          this.B = 0L;
          this.q = 0;
          this.r = (localViewHolder.h.getTop() + ((BaseChatItemLayout)localObject).getTop() + BaseChatItemLayout.k - this.b.getScrollY());
          this.s = a((localViewHolder.h.getLeft() + localViewHolder.h.getRight()) / 2, localViewHolder);
          this.t = 0;
          this.w = 0.0F;
          d1 = i * 500.0F;
          d2 = Math.random();
          Double.isNaN(d1);
          this.x = ((float)(d1 * d2));
          this.v = 0;
          this.u = 0;
          return 0L;
        }
      }
      else
      {
        this.d = 5;
        i1 = this.b.getWidth() / 2;
        d1 = Math.random();
        f1 = i;
        d2 = f1;
        Double.isNaN(d2);
        this.s = (i1 + (int)(d1 * 160.0D * d2 - 80.0D));
        this.t = this.v;
        this.B = 0L;
        this.f = 0L;
        this.g = 0L;
        this.q = 0;
        this.r = 0;
        this.w = 0.0F;
        d1 = f1 * 500.0F;
        d2 = Math.random();
        Double.isNaN(d1);
        this.x = ((float)(d1 * d2));
      }
      return 0L;
    }
    Object localObject = a(this.g);
    if (localObject != null)
    {
      localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)localObject);
      if (localViewHolder != null)
      {
        this.s = this.u;
        this.t = this.v;
        this.d = 4;
        this.p = l1;
        this.B = 0L;
        this.f = this.g;
        this.g = localViewHolder.q.uniseq;
        this.x = ((float)-((Math.random() - 1.0D) * 300.0D + 750.0D) * i);
        this.r = (localViewHolder.h.getTop() + ((BaseChatItemLayout)localObject).getTop() + BaseChatItemLayout.k - this.b.getScrollY() - this.t);
        f1 = this.x;
        d1 = Math.sqrt(f1 * f1 + o * 2.0F * this.r);
        d2 = this.x;
        Double.isNaN(d2);
        double d3 = o;
        Double.isNaN(d3);
        d1 = (d1 - d2) / d3;
        this.q = (a(this.u, localViewHolder) - this.u);
        d2 = this.q;
        Double.isNaN(d2);
        this.w = ((float)(d2 / d1));
        return 0L;
      }
    }
    this.s = this.u;
    this.t = this.v;
    this.d = 5;
    this.p = l1;
    this.B = 0L;
    this.f = this.g;
    this.g = 0L;
    this.q = 0;
    this.r = 0;
    this.w = ((float)(Math.random() * 400.0D - 100.0D));
    this.x = ((float)-((Math.random() - 1.0D) * 300.0D + 750.0D) * i);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumper
 * JD-Core Version:    0.7.0.1
 */