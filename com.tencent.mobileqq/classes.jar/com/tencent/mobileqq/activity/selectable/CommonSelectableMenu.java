package com.tencent.mobileqq.activity.selectable;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import java.lang.ref.WeakReference;

public class CommonSelectableMenu<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int l = -1;
  protected CommonMenuWrapper a;
  protected TextSelectableHelper b;
  protected WeakReference<QQAppInterface> c;
  protected WeakReference<T> d;
  public String e;
  private Point f = new Point();
  private AIOSelectableDelegateProxy g;
  private boolean h;
  private boolean i;
  private long j = -1L;
  private int k;
  private int m = -1;
  private int n = -1;
  
  protected String a()
  {
    if (AIOSelectableDelegateImpl.a().l()) {
      return AIOSelectableDelegateImpl.a().d();
    }
    return this.e;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.l())
    {
      if (!this.h) {
        return;
      }
      int i1 = paramMotionEvent.getAction();
      int i2 = (int)paramMotionEvent.getRawX();
      int i3 = (int)paramMotionEvent.getRawY();
      if (i1 == 0)
      {
        this.i = (localAIOSelectableDelegateImpl.d(i2, i3) ^ true);
        this.j = localAIOSelectableDelegateImpl.b;
        if (this.i)
        {
          this.m = i2;
          this.n = i3;
        }
        else
        {
          this.m = -1;
          this.n = -1;
        }
        this.k = 0;
        return;
      }
      if (i1 == 2)
      {
        if ((this.i) && (Math.pow(this.m - i2, 2.0D) + Math.pow(this.n - i3, 2.0D) > l))
        {
          this.k = 2;
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect scrolling.");
          }
        }
      }
      else if (((i1 == 1) || (i1 == 3)) && (this.i))
      {
        if (this.k == 0)
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.b;
          long l2 = this.j;
          if ((l2 != -1L) && (l1 != -1L))
          {
            if (l2 == l1) {
              localAIOSelectableDelegateImpl.n();
            }
          }
          else {
            localAIOSelectableDelegateImpl.n();
          }
        }
        this.k = 1;
        this.i = false;
        this.j = -1L;
      }
    }
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.e = paramContainerView.getText();
    this.b = new TextSelectableHelper();
    this.c = new WeakReference(paramT.app);
    this.d = new WeakReference(paramT);
    a(paramContainerView);
    if (l == -1)
    {
      int i1 = ViewConfiguration.get(paramT).getScaledTouchSlop();
      l = i1 * i1;
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131431492, HardCodeUtil.a(2131900435), 2130839057);
    paramQQCustomMenu.a(2131433636, HardCodeUtil.a(2131900433), 2130839066);
    paramQQCustomMenu.a(2131432813, HardCodeUtil.a(2131900434), 2130839065);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void a(ContainerView paramContainerView)
  {
    paramContainerView.c.setOnTouchListener(new CommonSelectableMenu.1(this));
    paramContainerView.c.setOnLongClickListener(new CommonSelectableMenu.2(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof SelectableComponent))
    {
      SelectableComponent localSelectableComponent = (SelectableComponent)paramView;
      if (paramView.getContext() != null)
      {
        Object localObject = new QQCustomMenu();
        a((QQCustomMenu)localObject);
        if (this.a == null)
        {
          this.a = new TextPreviewMenuWrapper();
          this.a.a(this);
        }
        int i1 = this.f.y - AIOUtils.b(10.0F, paramView.getResources());
        int i2 = this.f.x - ViewUtils.dpToPx(14.0F);
        this.a.a((QQCustomMenu)localObject, false);
        this.a.a(i2);
        this.a.b(i1);
        localObject = this.a;
        ((CommonMenuWrapper)localObject).c = i1;
        ((CommonMenuWrapper)localObject).d = i2;
        if (com.tencent.qphone.base.util.QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showMenuView: pointY -> ");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(", lastShowX -> ");
          ((StringBuilder)localObject).append(this.f.x);
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, ((StringBuilder)localObject).toString());
        }
        if (this.g == null) {
          this.g = new AIOSelectableDelegateProxy();
        }
        this.g.a(localSelectableComponent);
        this.g.a(paramContainerView, paramContainerView);
        this.g.a(this.a);
        this.b.a(paramView, this.a);
      }
    }
  }
  
  public void b()
  {
    this.h = true;
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.c != null))
    {
      paramContainerView.c.setOnLongClickListener(null);
      paramContainerView.c.setOnClickListener(null);
    }
    paramContainerView = this.g;
    if (paramContainerView != null)
    {
      paramContainerView.n();
      this.g = null;
    }
    paramContainerView = this.a;
    if (paramContainerView != null)
    {
      paramContainerView.a(null);
      this.a = null;
    }
    this.b = null;
  }
  
  public void c()
  {
    this.h = false;
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.l()) && (localAIOSelectableDelegateImpl.i())) {
      localAIOSelectableDelegateImpl.n();
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableMenu
 * JD-Core Version:    0.7.0.1
 */