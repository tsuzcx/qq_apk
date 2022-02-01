package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class AIOSelectableDelegateProxy
  implements SelectableDelegate
{
  private boolean a = true;
  private SelectableComponent b;
  private SelectableCursor c;
  private SelectableCursor d;
  private SelectablePopupMenu e;
  
  private AIOSelectableDelegateImpl o()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.s()) {
      return localAIOSelectableDelegateImpl;
    }
    throw new IllegalStateException("The proxy has been not attached.");
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.s()) {
      return localAIOSelectableDelegateImpl.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    o().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    o().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    o().a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    o().a(paramInt, paramBoolean);
  }
  
  public void a(@NonNull SelectableComponent paramSelectableComponent)
  {
    this.b = paramSelectableComponent;
    this.b.bind(this);
  }
  
  public void a(@NonNull SelectableCursor paramSelectableCursor1, @NonNull SelectableCursor paramSelectableCursor2)
  {
    this.c = paramSelectableCursor1;
    this.c.a(this);
    this.d = paramSelectableCursor2;
    this.d.a(this);
  }
  
  public void a(@NonNull SelectablePopupMenu paramSelectablePopupMenu)
  {
    this.e = paramSelectablePopupMenu;
    this.e.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.s() != null) {
      localAIOSelectableDelegateImpl.n();
    }
    localAIOSelectableDelegateImpl.a(this);
    localAIOSelectableDelegateImpl.a(this.b);
    localAIOSelectableDelegateImpl.a(this.c, this.d);
    localAIOSelectableDelegateImpl.a(this.e);
    localAIOSelectableDelegateImpl.a(paramChatMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    o().a(paramBoolean);
  }
  
  public boolean a()
  {
    SelectableCursor localSelectableCursor = this.c;
    return (localSelectableCursor != null) && (localSelectableCursor.d(1));
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return o().b(paramInt1, paramInt2);
  }
  
  @Nullable
  public String b()
  {
    return o().b();
  }
  
  public void b(int paramInt)
  {
    AIOSelectableDelegateImpl.a().b(paramInt);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.l())
    {
      if (localAIOSelectableDelegateImpl.c == null) {
        return;
      }
      if (paramChatMessage.uniseq != localAIOSelectableDelegateImpl.c.uniseq)
      {
        if (this == localAIOSelectableDelegateImpl.s()) {
          localAIOSelectableDelegateImpl.v();
        }
      }
      else if (this != localAIOSelectableDelegateImpl.s())
      {
        localAIOSelectableDelegateImpl.a(this);
        localAIOSelectableDelegateImpl.a(this.b);
        localAIOSelectableDelegateImpl.a(this.c, this.d);
        if (localAIOSelectableDelegateImpl.a != null) {
          a(localAIOSelectableDelegateImpl.a);
        }
        localAIOSelectableDelegateImpl.u();
      }
    }
  }
  
  public int c()
  {
    return o().c();
  }
  
  public void c(int paramInt)
  {
    AIOSelectableDelegateImpl.a().c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    o().c(paramInt1, paramInt2);
  }
  
  public boolean d()
  {
    SelectableCursor localSelectableCursor = this.d;
    return (localSelectableCursor != null) && (localSelectableCursor.d(2));
  }
  
  public int e()
  {
    return o().e();
  }
  
  public int f()
  {
    return o().f();
  }
  
  public int g()
  {
    return o().g();
  }
  
  public void h()
  {
    o().h();
  }
  
  public boolean i()
  {
    return o().i();
  }
  
  public void j()
  {
    o().j();
  }
  
  public boolean k()
  {
    return this.a;
  }
  
  public boolean l()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    return (this == localAIOSelectableDelegateImpl.s()) && (localAIOSelectableDelegateImpl.l());
  }
  
  public void m()
  {
    AIOSelectableDelegateImpl.a().m();
  }
  
  public void n()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.s()) {
      localAIOSelectableDelegateImpl.n();
    }
  }
  
  public boolean q()
  {
    return (a()) && (d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy
 * JD-Core Version:    0.7.0.1
 */