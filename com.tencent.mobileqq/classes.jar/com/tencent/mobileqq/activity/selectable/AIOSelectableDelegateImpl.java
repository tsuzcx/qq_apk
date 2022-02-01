package com.tencent.mobileqq.activity.selectable;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AIOSelectableDelegateImpl
  implements Handler.Callback, SelectableDelegate
{
  private static final int d = ViewUtils.dpToPx(30.0F);
  private static final int e = ViewUtils.dpToPx(28.0F);
  private static final int f = ViewUtils.dpToPx(72.0F);
  private static final int g = ViewUtils.dpToPx(63.0F);
  protected SelectablePopupMenu a;
  protected long b = -1L;
  ChatMessage c;
  private WeakReference<AIOSelectableDelegateProxy> h;
  private SelectableComponent i;
  private SelectableCursor j;
  private SelectableCursor k;
  private SelectableMagnifier l;
  private List<WeakReference<OnSelectListener>> m = new ArrayList();
  private int n = -1;
  private int o = -1;
  private boolean p = false;
  private final int[] q = new int[2];
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v;
  private int w;
  private final Handler x = new Handler(Looper.getMainLooper(), this);
  private boolean y = true;
  
  private void A()
  {
    if (this.l != null) {
      return;
    }
    throw new IllegalStateException("Has no magnifier.");
  }
  
  private void B()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      OnSelectListener localOnSelectListener = (OnSelectListener)((WeakReference)localIterator.next()).get();
      if (localOnSelectListener != null) {
        localOnSelectListener.a(this);
      }
    }
  }
  
  public static AIOSelectableDelegateImpl a()
  {
    return AIOSelectableDelegateImpl.Holder.a;
  }
  
  private void w()
  {
    this.i.highlightBackgroundColor(this.v);
    this.i.selectContent(this.n, this.o);
    this.i.highlightContent();
    this.j.f(this.w);
    this.k.f(this.w);
    this.i.locationByIndex(this.n, this.q, true);
    SelectableCursor localSelectableCursor = this.j;
    int[] arrayOfInt = this.q;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.i.locationByIndex(this.o, this.q, false);
    localSelectableCursor = this.k;
    arrayOfInt = this.q;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 2);
  }
  
  private boolean x()
  {
    return this.i != null;
  }
  
  private void y()
  {
    if ((this.j != null) && (this.k != null)) {
      return;
    }
    throw new IllegalStateException("Has not bound cursors.");
  }
  
  private boolean z()
  {
    return this.a != null;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.j != null) && (o())) {
      return this.j.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (this.k != null) && (p())) {
      return this.k.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.n = paramInt2;
        this.o = paramInt1;
      }
      else
      {
        this.n = paramInt1;
        this.o = paramInt2;
      }
      if (this.o - this.n > 0) {
        this.p = true;
      }
    }
    else
    {
      this.n = -1;
      this.o = -1;
      this.p = false;
    }
    x();
    this.i.selectContent(this.n, this.o);
    this.i.highlightContent();
    y();
    this.i.locationByIndex(this.n, this.q, true);
    SelectableCursor localSelectableCursor = this.j;
    int[] arrayOfInt = this.q;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.i.locationByIndex(this.o, this.q, false);
    localSelectableCursor = this.k;
    arrayOfInt = this.q;
    localSelectableCursor.b(arrayOfInt[0], arrayOfInt[1], 2);
    B();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    x();
    z();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(paramInt3);
    this.x.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    x();
    A();
    if (this.r == -1) {
      return;
    }
    if (!this.y) {
      return;
    }
    Message localMessage = Message.obtain();
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    localMessage.what = i1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(this.r);
    this.x.sendMessageDelayed(localMessage, 10L);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.r = paramInt;
    if (!paramBoolean) {
      this.s = paramInt;
    }
  }
  
  void a(View paramView)
  {
    int i1;
    if (paramView != null)
    {
      paramView.getLocationInWindow(this.q);
      i1 = this.q[1];
    }
    else
    {
      i1 = ViewUtils.getScreenHeight();
    }
    d(i1);
  }
  
  void a(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      SelectablePopupMenu localSelectablePopupMenu = this.a;
      localBaseChatPie = paramBaseChatPie;
      if ((localSelectablePopupMenu instanceof AIOMenuWrapper)) {
        localBaseChatPie = ((AIOMenuWrapper)localSelectablePopupMenu).a;
      }
    }
    int i1;
    if ((localBaseChatPie != null) && (localBaseChatPie.X != null) && (localBaseChatPie.X.getVisibility() == 0))
    {
      localBaseChatPie.X.getLocationInWindow(this.q);
      i1 = this.q[1];
    }
    else
    {
      i1 = ViewUtils.getScreenHeight();
    }
    d(i1);
  }
  
  void a(@Nullable AIOSelectableDelegateProxy paramAIOSelectableDelegateProxy)
  {
    WeakReference localWeakReference = this.h;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.h = new WeakReference(paramAIOSelectableDelegateProxy);
  }
  
  public void a(@NonNull OnSelectListener paramOnSelectListener)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      if (paramOnSelectListener == (OnSelectListener)((WeakReference)localIterator.next()).get())
      {
        i1 = 1;
        break label45;
      }
    }
    int i1 = 0;
    label45:
    if (i1 == 0) {
      this.m.add(new WeakReference(paramOnSelectListener));
    }
  }
  
  public void a(@NonNull SelectableComponent paramSelectableComponent)
  {
    this.i = paramSelectableComponent;
  }
  
  public void a(@NonNull SelectableCursor paramSelectableCursor1, @NonNull SelectableCursor paramSelectableCursor2)
  {
    this.j = paramSelectableCursor1;
    this.k = paramSelectableCursor2;
  }
  
  public void a(@NonNull SelectablePopupMenu paramSelectablePopupMenu)
  {
    this.a = paramSelectablePopupMenu;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    x();
    this.n = 0;
    this.o = this.i.contentLength();
    if (this.n >= this.o)
    {
      this.p = false;
      return;
    }
    this.b = System.currentTimeMillis();
    this.c = paramChatMessage;
    this.p = true;
    this.i.highlightBackgroundColor(this.v);
    this.i.selectContent(this.n, this.o);
    this.i.highlightContent();
    y();
    this.r = -1;
    this.s = -1;
    this.t = -1;
    this.u = -1;
    this.j.f(this.w);
    this.k.f(this.w);
    this.i.locationByIndex(this.n, this.q, true);
    paramChatMessage = this.j;
    int[] arrayOfInt = this.q;
    paramChatMessage.b(arrayOfInt[0], arrayOfInt[1], 1);
    this.i.locationByIndex(this.o, this.q, false);
    paramChatMessage = this.k;
    arrayOfInt = this.q;
    paramChatMessage.b(arrayOfInt[0], arrayOfInt[1], 2);
    h();
    paramChatMessage = this.l;
    if (paramChatMessage == null) {
      this.l = new QMagnifier();
    } else if (paramChatMessage.a()) {
      this.l.b();
    }
    B();
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    x();
    return this.i.touchIndex(paramInt1, paramInt2);
  }
  
  @Nullable
  public String b()
  {
    x();
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((SelectableComponent)localObject).content();
      if (localObject != null) {
        return ((CharSequence)localObject).toString();
      }
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(@NonNull OnSelectListener paramOnSelectListener)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (paramOnSelectListener == (OnSelectListener)localWeakReference.get())
      {
        paramOnSelectListener = localWeakReference;
        break label47;
      }
    }
    paramOnSelectListener = null;
    label47:
    if (paramOnSelectListener != null) {
      this.m.remove(paramOnSelectListener);
    }
  }
  
  public int c()
  {
    x();
    SelectableComponent localSelectableComponent = this.i;
    if (localSelectableComponent != null) {
      return localSelectableComponent.contentLength();
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
  }
  
  @Nullable
  public String d()
  {
    x();
    CharSequence localCharSequence = this.i.selectContent();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  void d(int paramInt)
  {
    if (!x()) {
      return;
    }
    if (!z()) {
      return;
    }
    Object localObject1 = this.a;
    if ((localObject1 instanceof CommonMenuWrapper)) {
      i2 = ((CommonMenuWrapper)localObject1).d;
    } else {
      i2 = ((SelectablePopupMenu)localObject1).c();
    }
    localObject1 = this.a;
    int i3;
    if ((localObject1 instanceof CommonMenuWrapper)) {
      i3 = ((CommonMenuWrapper)localObject1).c;
    } else {
      i3 = ((SelectablePopupMenu)localObject1).d();
    }
    Object localObject2 = this.i.view();
    localObject1 = localObject2;
    if (((View)localObject2).getId() != 2131430578)
    {
      View localView = ((View)localObject2).findViewById(2131430578);
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView;
      }
    }
    ((View)localObject1).getLocationInWindow(this.q);
    localObject2 = this.q;
    int i5 = 1;
    int i6 = localObject2[1];
    int i7 = localObject2[1];
    int i8 = ((View)localObject1).getHeight();
    localObject1 = this.q;
    int i4 = 0;
    int i9 = localObject1[0];
    int i10 = this.i.view().getPaddingLeft();
    this.i.locationByIndex(this.n, this.q, true);
    localObject1 = this.q;
    int i11 = localObject1[0];
    this.i.locationByIndex(this.o, (int[])localObject1, false);
    int i1 = this.q[0];
    if (this.s == 2)
    {
      i11 = i1 - i2;
      if ((i11 > d) || (i11 < 0))
      {
        i11 = d;
        if (i1 - i11 < i9 + i10) {
          break label339;
        }
        i1 -= i11;
        break label339;
      }
    }
    else
    {
      i1 = i2 - i11;
      if ((i1 > d) || (i1 < 0)) {
        break label332;
      }
    }
    i1 = i2;
    break label339;
    label332:
    i1 = d + i11;
    label339:
    if (i6 - e < f + ImmersiveUtils.statusHeight)
    {
      i6 = i7 + i8 + 0;
      if (i6 < f + ImmersiveUtils.statusHeight)
      {
        if ((i3 != 0) && (i3 - e > f + ImmersiveUtils.statusHeight))
        {
          paramInt = i3 - e;
          i1 = i4;
          break label591;
        }
        if (i3 != 0)
        {
          i5 = g;
          i6 = e;
          if (i5 + i3 - i6 < paramInt)
          {
            paramInt = i3 - i6;
            i1 = 1;
            break label591;
          }
        }
        paramInt = f + ImmersiveUtils.statusHeight;
      }
      else
      {
        if (g + i6 > paramInt)
        {
          if ((i3 != 0) && (i3 - e > f + ImmersiveUtils.statusHeight))
          {
            paramInt = i3 - e;
          }
          else
          {
            if (i3 != 0)
            {
              i4 = g;
              i6 = e;
              if (i4 + i3 - i6 < paramInt)
              {
                paramInt = i3 - i6;
                break label564;
              }
            }
            paramInt = f + ImmersiveUtils.statusHeight + g + e;
            i2 = i1;
          }
          i1 = 0;
          break label567;
        }
        else
        {
          paramInt = i6;
          i2 = i1;
        }
        i1 = i5;
        break label591;
      }
    }
    else if (i6 <= paramInt)
    {
      paramInt = i6 - e;
    }
    label564:
    label567:
    int i2 = i1;
    i1 = i4;
    label591:
    a(i2, paramInt, i1);
  }
  
  public boolean d(int paramInt1, int paramInt2)
  {
    if (!l()) {
      return false;
    }
    Object localObject = this.i;
    if (localObject == null) {
      return false;
    }
    localObject = ((SelectableComponent)localObject).view();
    ((View)localObject).getLocationInWindow(this.q);
    int[] arrayOfInt = this.q;
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int i3 = ((View)localObject).getMeasuredWidth();
    int i4 = ((View)localObject).getMeasuredHeight();
    return (paramInt1 >= i1) && (paramInt1 <= i3 + i1) && (paramInt2 >= i2) && (paramInt2 <= i4 + i2);
  }
  
  public int e()
  {
    x();
    return this.n;
  }
  
  public int f()
  {
    x();
    return this.o;
  }
  
  public int g()
  {
    return this.r;
  }
  
  public void h()
  {
    a((View)null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (paramMessage.what == 1)
    {
      this.x.removeMessages(1);
      localObject = this.i;
      if (localObject != null)
      {
        SelectablePopupMenu localSelectablePopupMenu = this.a;
        if (localSelectablePopupMenu != null)
        {
          localSelectablePopupMenu.a(((SelectableComponent)localObject).view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
          paramMessage = this.l;
          if ((paramMessage != null) && (paramMessage.a())) {
            this.l.b();
          }
        }
      }
      return true;
    }
    if (paramMessage.what == 2)
    {
      this.x.removeMessages(2);
      this.x.removeMessages(3);
      if (this.l != null)
      {
        if (((Integer)paramMessage.obj).intValue() == 1) {
          localObject = this.j;
        } else {
          localObject = this.k;
        }
        if ((localObject != null) && (this.i != null)) {
          this.l.a(((SelectableCursor)localObject).e(), paramMessage.arg1, paramMessage.arg2, this.i.view(), true);
        }
      }
    }
    else if (paramMessage.what == 3)
    {
      this.x.removeMessages(2);
      this.x.removeMessages(3);
      if (this.l != null)
      {
        if (((Integer)paramMessage.obj).intValue() == 1) {
          localObject = this.j;
        } else {
          localObject = this.k;
        }
        if ((localObject != null) && (this.i != null)) {
          this.l.a(((SelectableCursor)localObject).e(), paramMessage.arg1, paramMessage.arg2, this.i.view(), false);
        }
      }
    }
    else if (paramMessage.what == 4)
    {
      this.x.removeMessages(4);
      if ((this.i != null) && (this.j != null) && (this.k != null))
      {
        w();
        h();
      }
    }
    return false;
  }
  
  public boolean i()
  {
    SelectablePopupMenu localSelectablePopupMenu = this.a;
    if (localSelectablePopupMenu != null) {
      return localSelectablePopupMenu.e();
    }
    return false;
  }
  
  public void j()
  {
    z();
    this.a.f();
  }
  
  public boolean k()
  {
    return true;
  }
  
  public boolean l()
  {
    return this.p;
  }
  
  public void m()
  {
    B();
  }
  
  public void n()
  {
    this.c = null;
    SelectableMagnifier localSelectableMagnifier = this.l;
    if (localSelectableMagnifier != null)
    {
      if (localSelectableMagnifier.a()) {
        this.l.b();
      }
      this.l = null;
    }
    v();
    this.a = null;
    this.p = false;
    this.n = -1;
    this.o = -1;
    this.r = -1;
    this.s = -1;
    this.t = -1;
    this.u = -1;
    this.b = -1L;
    B();
  }
  
  public boolean o()
  {
    SelectableCursor localSelectableCursor = this.j;
    return (localSelectableCursor != null) && (localSelectableCursor.d(1));
  }
  
  public boolean p()
  {
    SelectableCursor localSelectableCursor = this.k;
    return (localSelectableCursor != null) && (localSelectableCursor.d(2));
  }
  
  public boolean q()
  {
    return (o()) && (p());
  }
  
  public String r()
  {
    if ((this.i instanceof MixedMsgLinearLayout))
    {
      x();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.i).a();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return null;
    }
    return d();
  }
  
  @Nullable
  AIOSelectableDelegateProxy s()
  {
    WeakReference localWeakReference = this.h;
    if (localWeakReference != null) {
      return (AIOSelectableDelegateProxy)localWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  public View t()
  {
    SelectableComponent localSelectableComponent = this.i;
    if (localSelectableComponent != null) {
      return localSelectableComponent.view();
    }
    return null;
  }
  
  void u()
  {
    x();
    y();
    this.x.sendEmptyMessage(4);
  }
  
  void v()
  {
    if (this.a != null)
    {
      this.x.removeMessages(1);
      if (this.a.e()) {
        this.a.f();
      }
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      ((SelectableComponent)localObject).selectContent(-1, -1);
      this.i.clearHighlightContent();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (((SelectableCursor)localObject).d(1)) {
        this.j.e(1);
      }
      this.j = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (((SelectableCursor)localObject).d(2)) {
        this.k.e(2);
      }
      this.k = null;
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl
 * JD-Core Version:    0.7.0.1
 */