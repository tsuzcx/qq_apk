package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SigTlpAnimation
  extends XBubbleAnimation
{
  protected static Rect k = new Rect();
  public String d;
  public String[] e;
  protected boolean f = false;
  protected String g;
  protected View h;
  protected SignatureTemplateInfo.DynamicItem i;
  protected Rect j = new Rect();
  private int u;
  private RichStatItemBuilder.Holder v;
  private SigTlpAnimation.ItemViewHolder w;
  
  public SigTlpAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.p = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.q = null;
    this.r = new Handler();
  }
  
  public int a(View paramView, boolean paramBoolean)
  {
    View localView = (View)paramView.getParent();
    int m = paramView.getTop();
    if (localView == null) {
      return m;
    }
    if (paramBoolean)
    {
      n = m;
      do
      {
        m = n;
        if ((localView instanceof ChatXListView)) {
          break;
        }
        m = n + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        n = m;
      } while (paramView != null);
      return m;
    }
    paramView = localView;
    int n = m;
    if (this.h == null)
    {
      n = m;
      do
      {
        m = n;
        if ((localView instanceof MutilayoutSlideDetectListView)) {
          break;
        }
        m = n + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        n = m;
      } while (paramView != null);
      return m;
    }
    do
    {
      m = n;
      if ((paramView instanceof MaxHeightRelativelayout)) {
        break;
      }
      m = n + paramView.getTop();
      localView = (View)paramView.getParent();
      paramView = localView;
      n = m;
    } while (localView != null);
    return m;
  }
  
  public void a()
  {
    this.p.a(true);
  }
  
  protected void a(int paramInt)
  {
    QQViewCompatUtil.a(this.a, paramInt);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        return false;
      }
      if (this.e != null) {
        return true;
      }
      localObject = FileUtils.getChildFiles(paramString);
      if (((ArrayList)localObject).size() <= 0) {
        return false;
      }
      this.e = new String[((ArrayList)localObject).size()];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("%d.png");
      paramString = ((StringBuilder)localObject).toString();
      int i1 = this.e.length;
      int n;
      for (int m = 0; m < i1; m = n)
      {
        localObject = this.e;
        n = m + 1;
        localObject[m] = String.format(paramString, new Object[] { Integer.valueOf(n) });
      }
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.o == null) {
      return false;
    }
    if (f())
    {
      if (paramBoolean) {
        this.o.setBackgroundDrawable(this.p);
      }
      ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
      localLayoutParams1.height = (this.j.bottom - this.j.top);
      localLayoutParams1.width = (this.j.right - this.j.left);
      this.a.addViewInLayout(this.o, -1, localLayoutParams1, false);
      if ((this.f) && (this.h != null))
      {
        ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        localLayoutParams2.height = (this.h.getBottom() - this.h.getTop());
        localLayoutParams2.width = (this.h.getRight() - this.h.getLeft());
        Object localObject = (View)this.h.getParent();
        View localView = this.h;
        if (((localView instanceof TextView)) && (localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)localView.getParent();
          k.left = (this.h.getLeft() + ((RelativeLayout)localObject).getLeft() + ((View)((RelativeLayout)localObject).getParent()).getLeft());
          ((RelativeLayout)localObject).removeView(this.h);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("paramButton.width=");
          ((StringBuilder)localObject).append(localLayoutParams2.width);
          ((StringBuilder)localObject).append(",paramButton.height=");
          ((StringBuilder)localObject).append(localLayoutParams2.height);
          QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
        }
        this.a.addViewInLayout(this.h, 1, localLayoutParams2, false);
        this.h.layout(0, 0, localLayoutParams2.width, localLayoutParams2.height);
      }
      this.o.layout(0, 0, localLayoutParams1.width, localLayoutParams1.height);
      return e();
    }
    return false;
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
      QLog.d("SigTlpAnimation", 2, localStringBuilder.toString());
    }
    if ((this.f) && (this.o != null))
    {
      this.a.removeAllViews();
      a(false);
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      return false;
    }
    this.h = null;
    String str1 = String.valueOf(paramVarArgs[1]);
    this.g = String.valueOf(paramVarArgs[2]);
    String str2 = (String)paramVarArgs[3];
    this.f = ((Boolean)paramVarArgs[4]).booleanValue();
    if (paramVarArgs[5] != null) {
      this.h = ((View)paramVarArgs[5]);
    }
    this.i = ((SignatureTemplateInfo.DynamicItem)paramVarArgs[6]);
    ThreadManager.getFileThreadHandler().post(new SigTlpAnimation.2(this, str1, str2));
    return true;
  }
  
  protected void b()
  {
    this.p.a(false);
  }
  
  public void b(boolean paramBoolean)
  {
    c();
    if (this.o != null)
    {
      this.a.removeViewInLayout(this.o);
      this.o = null;
    }
    if ((paramBoolean) && ((this.h == null) || (this.f)))
    {
      this.a.removeAllViews();
      this.h = null;
    }
    this.a.invalidate();
  }
  
  protected void c()
  {
    if (this.p != null) {
      this.p.c();
    }
  }
  
  public void d()
  {
    b(false);
  }
  
  protected boolean e()
  {
    if (this.o != null)
    {
      this.o.offsetLeftAndRight(this.j.left);
      this.o.offsetTopAndBottom(this.j.top);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rect.left=");
        ((StringBuilder)localObject).append(this.j.left);
        ((StringBuilder)localObject).append(",rect.top=");
        ((StringBuilder)localObject).append(this.j.top);
        QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
      }
      if (this.f)
      {
        localObject = this.h;
        if (localObject != null)
        {
          ((View)localObject).offsetLeftAndRight(k.left);
          this.h.offsetTopAndBottom(k.top);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("rectAio.left=");
            ((StringBuilder)localObject).append(k.left);
            ((StringBuilder)localObject).append(",rectAio.top=");
            ((StringBuilder)localObject).append(k.top);
            QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    else if (this.f)
    {
      this.r.post(new SigTlpAnimation.1(this));
    }
    return true;
  }
  
  public boolean f()
  {
    boolean bool = this.f;
    Object localObject1 = null;
    int i1 = 0;
    int i2 = 0;
    Object localObject2;
    int n;
    if (bool)
    {
      this.v = null;
      this.u = AIOUtils.a(Long.valueOf(this.d).longValue(), this.b.getAdapter());
      localObject2 = AIOUtils.b(AIOUtils.a(this.b, this.u));
      if ((localObject2 != null) && ((localObject2 instanceof RichStatItemBuilder.Holder)))
      {
        this.v = ((RichStatItemBuilder.Holder)localObject2);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("list view item's tag can not cast to Holder, object:");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(",mPosition:");
        localStringBuilder.append(this.u);
        QLog.e("SigTlpAnimation", 2, localStringBuilder.toString());
      }
      localObject2 = this.v;
      if (localObject2 == null)
      {
        b(true);
        return false;
      }
      if (((RichStatItemBuilder.Holder)localObject2).d != null) {
        localObject1 = this.v.d.h();
      }
      if ((this.o != null) && (localObject1 != null))
      {
        i1 = ((View)localObject1).getLeft();
        n = a((View)localObject1, true) - this.b.getScrollY();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getParentTop(mHolder.sigView, true):");
          ((StringBuilder)localObject2).append(a((View)localObject1, true));
          ((StringBuilder)localObject2).append(",istview.getScrollY():");
          ((StringBuilder)localObject2).append(this.b.getScrollY());
          QLog.e("SigTlpAnimation", 2, ((StringBuilder)localObject2).toString());
        }
        m = ((View)localObject1).getWidth();
        i2 = ((View)localObject1).getHeight();
        if (this.h != null) {
          k.top = 0;
        }
      }
      else
      {
        int i3 = 0;
        n = 0;
        m = 0;
        i1 = i2;
        i2 = i3;
      }
    }
    else
    {
      localObject1 = this.h;
      if (localObject1 == null)
      {
        this.w = null;
        this.u = SignatureManager.a(this.d, this.b.getAdapter());
        localObject1 = AIOUtils.b(AIOUtils.a(this.b, this.u));
        if ((localObject1 != null) && ((localObject1 instanceof SigTlpAnimation.ItemViewHolder)))
        {
          this.w = ((SigTlpAnimation.ItemViewHolder)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("list view item's tag can not cast to ItemViewHolder, object:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.e("SigTlpAnimation", 2, ((StringBuilder)localObject2).toString());
        }
        if (this.w == null) {
          return false;
        }
        if (this.o != null)
        {
          m = this.w.a.getRight();
          n = this.w.a.getLeft();
          i2 = this.w.a.getBottom() - this.w.a.getTop();
          m -= n;
        }
        else
        {
          i2 = 0;
          m = 0;
        }
        n = 0;
      }
      else
      {
        i1 = ((View)localObject1).getLeft();
        n = this.h.getTop();
        m = this.h.getRight() - this.h.getLeft();
        i2 = this.h.getBottom() - this.h.getTop();
      }
    }
    float f2 = this.i.c;
    float f1 = m;
    int m = i1 + (int)(f2 * f1);
    f2 = this.i.d;
    float f3 = i2;
    n += (int)(f2 * f3);
    this.j.set(m, n, (int)(this.i.e * f1) + m, (int)(this.i.f * f3) + n);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindView top=");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append(",left=");
      ((StringBuilder)localObject1).append(m);
      QLog.d("SigTlpAnimation", 2, ((StringBuilder)localObject1).toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation
 * JD-Core Version:    0.7.0.1
 */