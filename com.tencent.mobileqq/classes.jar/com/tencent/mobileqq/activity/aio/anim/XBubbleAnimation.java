package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.io.IOException;

public class XBubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private long d;
  private View e;
  private BaseBubbleBuilder.ViewHolder f;
  private boolean g = true;
  private Rect h = new Rect();
  protected int l;
  public BubbleInfo.CommonAttrs m;
  public BubbleInfo.CommonAttrs n;
  protected View o;
  public VipPngPlayAnimationDrawable p;
  public VipPngPlayAnimationDrawable q;
  public Handler r;
  public boolean s = false;
  public boolean t = false;
  
  public XBubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.p = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.q = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.r = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    float f1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      break;
    case 7: 
      if (paramBoolean) {
        paramInt1 = this.h.left;
      } else {
        paramInt1 = this.h.right;
      }
      f1 = this.h.bottom;
      paramInt2 = this.h.height();
      break;
    case 6: 
      if (paramBoolean) {
        paramInt1 = this.h.left;
      } else {
        paramInt1 = this.h.right;
      }
      paramInt2 = this.h.bottom;
      break;
    case 5: 
      if (paramBoolean) {
        paramInt1 = this.h.left;
      } else {
        paramInt1 = this.h.right;
      }
      paramInt2 = this.h.top;
      break;
    case 4: 
      if (paramBoolean) {
        paramInt1 = this.h.right;
      } else {
        paramInt1 = this.h.left;
      }
      paramInt1 = (int)(paramInt1 + this.h.width() / 2 - paramInt2 / 2.0F);
      paramInt2 = this.h.bottom;
      break;
    case 3: 
      if (paramBoolean) {
        paramInt1 = this.h.right;
      } else {
        paramInt1 = this.h.left;
      }
      paramInt1 = (int)(paramInt1 + this.h.width() / 2 - paramInt2 / 2.0F);
      paramInt2 = this.h.top;
      break;
    case 2: 
      if (paramBoolean) {
        paramInt1 = this.h.right;
      } else {
        paramInt1 = this.h.left;
      }
      f1 = this.h.bottom;
      paramInt2 = this.h.height();
      paramInt2 = (int)(f1 - paramInt2 / 2.0F - paramInt3 / 2.0F);
      break;
    case 1: 
      if (paramBoolean) {
        paramInt1 = this.h.right;
      } else {
        paramInt1 = this.h.left;
      }
      paramInt2 = this.h.bottom;
      break;
    }
    if (paramBoolean) {
      paramInt1 = this.h.right;
    } else {
      paramInt1 = this.h.left;
    }
    paramInt2 = this.h.top;
    return new int[] { paramInt1, paramInt2 };
  }
  
  protected void a(int paramInt)
  {
    View localView = this.o;
    if (localView != null)
    {
      localView.offsetTopAndBottom(paramInt);
      if ((this.p.C) || (this.o.getBottom() <= 0))
      {
        i = 1;
        break label41;
      }
    }
    int i = 0;
    label41:
    localView = this.e;
    if (localView != null)
    {
      localView.offsetTopAndBottom(paramInt);
      if ((!this.q.C) && (this.e.getBottom() > 0)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((i != 0) && (this.l != 0)) {
      this.r.post(new XBubbleAnimation.2(this));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.g == paramBoolean1) {
      return;
    }
    this.g = paramBoolean1;
    Object localObject = this.f;
    if (localObject != null)
    {
      Drawable localDrawable = ((BaseBubbleBuilder.ViewHolder)localObject).h.getBackground();
      if ((localDrawable instanceof VipBubbleDrawable))
      {
        if (this.f.i != null) {
          localObject = this.f.i.j;
        } else {
          localObject = null;
        }
        if (localObject != null)
        {
          localObject = this.m;
          if ((localObject == null) || (!((BubbleInfo.CommonAttrs)localObject).l.s))
          {
            localObject = this.n;
            if ((localObject == null) || (!((BubbleInfo.CommonAttrs)localObject).l.s)) {}
          }
          else if (paramBoolean1)
          {
            ((VipBubbleDrawable)localDrawable).c(true);
          }
          else
          {
            ((VipBubbleDrawable)localDrawable).c(false);
          }
        }
        if (paramBoolean2) {
          ((VipBubbleDrawable)localDrawable).a(paramBoolean1);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("background alpha changed:");
          ((StringBuilder)localObject).append(String.valueOf(paramBoolean1));
          QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("layout changed=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",bottom=");
      localStringBuilder.append(paramInt4);
      QLog.d("XBubbleAnimation", 2, localStringBuilder.toString());
    }
    if (this.s)
    {
      e();
      return true;
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    ThreadManager.post(new XBubbleAnimation.3(this, paramVarArgs), 8, null, true);
    return true;
  }
  
  protected boolean b(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean b(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != 3) {
      return false;
    }
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    if ((((Long)paramArrayOfObject[1]).longValue() != this.d) || (this.l != i))
    {
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
      if ((paramArrayOfObject != null) && (paramArrayOfObject.first != null))
      {
        if (((BubbleInfo.CommonAttrs)paramArrayOfObject.first).k == null) {
          return false;
        }
        this.m = ((BubbleInfo.CommonAttrs)paramArrayOfObject.first);
        this.n = ((BubbleInfo.CommonAttrs)paramArrayOfObject.second);
        try
        {
          this.p.a(this.m.k);
          if ((this.n != null) && (this.n.k != null)) {
            this.q.a(this.n.k);
          }
          return true;
        }
        catch (IOException paramArrayOfObject)
        {
          QLog.e("XBubbleAnimation", 1, "VipPngPlayAnimationDrawable measure exception", paramArrayOfObject);
        }
      }
    }
    return false;
  }
  
  protected void c()
  {
    VipPngPlayAnimationDrawable localVipPngPlayAnimationDrawable = this.p;
    if (localVipPngPlayAnimationDrawable != null) {
      localVipPngPlayAnimationDrawable.c();
    }
    localVipPngPlayAnimationDrawable = this.q;
    if (localVipPngPlayAnimationDrawable != null) {
      localVipPngPlayAnimationDrawable.c();
    }
  }
  
  public boolean c(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    boolean bool2 = false;
    Object localObject;
    if ((i == 3) && (!this.t))
    {
      int j = ((Integer)paramArrayOfObject[0]).intValue();
      long l1 = ((Long)paramArrayOfObject[1]).longValue();
      i = AIOUtils.a(l1, this.b.getAdapter());
      localObject = AIOUtils.b(AIOUtils.a(this.b, i));
      if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
      {
        this.f = ((BaseBubbleBuilder.ViewHolder)localObject);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("list view item's tag can not cast to ViewHolder, object:");
        localStringBuilder.append(localObject);
        QLog.e("XBubbleAnimation", 1, localStringBuilder.toString());
      }
      boolean bool1;
      if (l1 == this.d)
      {
        bool1 = bool2;
        if (this.l == j) {}
      }
      else
      {
        paramArrayOfObject = (Pair)paramArrayOfObject[2];
        bool1 = bool2;
        if (paramArrayOfObject != null)
        {
          bool1 = bool2;
          if (paramArrayOfObject.first != null)
          {
            if (((BubbleInfo.CommonAttrs)paramArrayOfObject.first).k == null) {
              return false;
            }
            g();
            this.d = l1;
            this.l = j;
            this.m = ((BubbleInfo.CommonAttrs)paramArrayOfObject.first);
            this.n = ((BubbleInfo.CommonAttrs)paramArrayOfObject.second);
            this.p.a(this.m.k, this.m.d);
            if (j != 0)
            {
              paramArrayOfObject = this.p;
              if (this.m.c) {
                i = 1;
              } else {
                i = this.m.b;
              }
              paramArrayOfObject.A = i;
            }
            this.o = new XBubbleAnimation.4(this, this.b.getContext());
            this.o.setBackgroundDrawable(this.p);
            this.a.addViewInLayout(this.o, -1, AIOAnimationConatiner.a, false);
            this.o.layout(0, 0, this.p.D, this.p.E);
            paramArrayOfObject = this.n;
            if ((paramArrayOfObject != null) && (paramArrayOfObject.k != null))
            {
              this.q.a(this.n.k, this.n.d);
              if (j != 0)
              {
                paramArrayOfObject = this.q;
                if (this.n.c) {
                  i = 1;
                } else {
                  i = this.n.b;
                }
                paramArrayOfObject.A = i;
              }
              this.e = new XBubbleAnimation.5(this, this.b.getContext());
              this.e.setBackgroundDrawable(this.q);
              this.a.addViewInLayout(this.e, -1, AIOAnimationConatiner.a, false);
              this.e.layout(0, 0, this.p.D, this.p.E);
            }
            bool1 = e();
            this.s = true;
          }
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start XBubbleAnimation failed. args.length=");
      ((StringBuilder)localObject).append(paramArrayOfObject.length);
      ((StringBuilder)localObject).append(", mIsStop=");
      ((StringBuilder)localObject).append(this.t);
      QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void d()
  {
    g();
  }
  
  protected boolean e()
  {
    if ((this.o == null) && (this.e == null)) {
      return false;
    }
    this.f = null;
    int i = AIOUtils.a(this.d, this.b.getAdapter());
    Object localObject = AIOUtils.b(AIOUtils.a(this.b, i));
    if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.f = ((BaseBubbleBuilder.ViewHolder)localObject);
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("list view item's tag can not cast to ViewHolder, object:");
      localStringBuilder.append(localObject);
      QLog.e("XBubbleAnimation", 2, localStringBuilder.toString());
    }
    if (this.l != 0)
    {
      localObject = this.f;
      if ((localObject == null) || (((BaseBubbleBuilder.ViewHolder)localObject).h == null) || (this.f.j == null)) {
        g();
      }
    }
    localObject = this.f;
    if ((localObject != null) && (this.o != null) && (this.m != null))
    {
      this.h.top = (((BaseBubbleBuilder.ViewHolder)localObject).h.getTop() + this.f.j.getTop() - this.b.getScrollY());
      this.h.left = (this.f.h.getLeft() + this.f.j.getLeft());
      this.h.bottom = (this.f.h.getBottom() + this.f.j.getTop() - this.b.getScrollY());
      this.h.right = (this.f.h.getRight() + this.f.j.getLeft());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindView bubbleRect top=");
        ((StringBuilder)localObject).append(this.h.top);
        ((StringBuilder)localObject).append(",left=");
        ((StringBuilder)localObject).append(this.h.left);
        ((StringBuilder)localObject).append(",bottom=");
        ((StringBuilder)localObject).append(this.h.bottom);
        ((StringBuilder)localObject).append(",right=");
        ((StringBuilder)localObject).append(this.h.right);
        ((StringBuilder)localObject).append(",listView height=");
        ((StringBuilder)localObject).append(this.b.getHeight());
        QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool2 = this.f.q.isSend() ^ true;
      localObject = this.m;
      if ((localObject != null) && (((BubbleInfo.CommonAttrs)localObject).l != null) && (!this.m.l.t)) {
        this.p.B = false;
      } else {
        this.p.B = bool2;
      }
      boolean bool1;
      if (this.n != null) {
        if (this.m.j.equals(this.n.j))
        {
          localObject = this.q;
          if (!bool2) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((VipPngPlayAnimationDrawable)localObject).B = bool1;
        }
        else
        {
          this.q.B = bool2;
        }
      }
      if (this.l == 6)
      {
        this.o.layout(this.h.left, this.h.top, this.h.right, this.h.bottom);
        return true;
      }
      localObject = a(this.m.g, this.m.f.right, this.m.f.bottom, bool2);
      int i2 = localObject[1] + this.m.f.top;
      if (!bool2)
      {
        j = localObject[0] + this.m.f.left;
        localObject = this.n;
        i = j;
        if (localObject == null) {
          break label904;
        }
        localObject = a(((BubbleInfo.CommonAttrs)localObject).g, this.n.f.right, this.n.f.bottom, bool2);
        i = localObject[0] - this.n.f.left - this.n.f.right;
        k = localObject[1];
        i1 = this.n.f.top;
      }
      else
      {
        j = localObject[0] - this.m.f.left - this.m.f.right;
        localObject = this.n;
        i = j;
        if (localObject == null) {
          break label904;
        }
        localObject = a(((BubbleInfo.CommonAttrs)localObject).g, this.n.f.right, this.n.f.bottom, bool2);
        i = localObject[0] + this.n.f.left;
        k = localObject[1];
        i1 = this.n.f.top;
      }
      k += i1;
      int i1 = j;
      int j = i;
      break label911;
      label904:
      int k = 0;
      j = 0;
      i1 = i;
      label911:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindView mView master_x=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(",master_y=");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(",mAttrsFirst.mRect.right=");
        ((StringBuilder)localObject).append(this.m.f.right);
        ((StringBuilder)localObject).append(",mAttrsFirst.mRect.bottom=");
        ((StringBuilder)localObject).append(this.m.f.bottom);
        ((StringBuilder)localObject).append(",listview.Width=");
        ((StringBuilder)localObject).append(this.b.getWidth());
        ((StringBuilder)localObject).append(",listview.Height=");
        ((StringBuilder)localObject).append(this.b.getHeight());
        QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
      }
      if ((i1 >= -this.m.f.right) && (i1 <= this.b.getWidth()) && (i2 >= -this.m.f.bottom))
      {
        i = i1 - this.o.getLeft();
        i1 = i2 - this.o.getTop();
        if ((i == 0) && (i1 == 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindView mView dx=");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(",dy=");
            ((StringBuilder)localObject).append(i1);
            QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.o.offsetLeftAndRight(i);
          this.o.offsetTopAndBottom(i1);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("bindView mView.offsetLeftAndRight ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(",mView.offsetTopAndBottom ");
            ((StringBuilder)localObject).append(i1);
            QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if ((this.n != null) && (this.e != null) && (bool1))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindView mLinkView x=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",y=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",mRect.right=");
          ((StringBuilder)localObject).append(this.n.f.right);
          ((StringBuilder)localObject).append(",mRect.bottom=");
          ((StringBuilder)localObject).append(this.n.f.bottom);
          ((StringBuilder)localObject).append(",listview.Width=");
          ((StringBuilder)localObject).append(this.b.getWidth());
          ((StringBuilder)localObject).append(",listview.Height=");
          ((StringBuilder)localObject).append(this.b.getHeight());
          QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
        }
        if ((j >= -this.n.f.right) && (j <= this.b.getWidth()) && (k >= -this.n.f.bottom))
        {
          i = j - this.e.getLeft();
          j = k - this.e.getTop();
          if ((i == 0) && (j == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("bindView mLinkView dx=");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",dy=");
              ((StringBuilder)localObject).append(j);
              QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            this.e.offsetLeftAndRight(i);
            this.e.offsetTopAndBottom(j);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("bindView mLinkView.offsetLeftAndRight ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",mLinkView.offsetTopAndBottom ");
              ((StringBuilder)localObject).append(j);
              QLog.d("XBubbleAnimation", 2, ((StringBuilder)localObject).toString());
            }
          }
          return true;
        }
      }
      else
      {
        return bool1;
      }
    }
    else if (this.l != 0)
    {
      this.r.post(new XBubbleAnimation.1(this));
    }
    return false;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XBubbleAnimation", 2, "now stop current animation!");
    }
    this.s = false;
    this.t = true;
    c();
    if (this.o != null)
    {
      this.a.removeViewInLayout(this.o);
      this.o = null;
    }
    if (this.e != null)
    {
      this.a.removeViewInLayout(this.e);
      this.e = null;
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation
 * JD-Core Version:    0.7.0.1
 */