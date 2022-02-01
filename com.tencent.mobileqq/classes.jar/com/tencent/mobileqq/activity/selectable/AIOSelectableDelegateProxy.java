package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class AIOSelectableDelegateProxy
  implements SelectableDelegate
{
  private SelectableComponent jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent;
  private SelectableCursor jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
  private SelectablePopupMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu;
  private boolean jdField_a_of_type_Boolean = true;
  private SelectableCursor b;
  
  private AIOSelectableDelegateImpl a()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.a()) {
      return localAIOSelectableDelegateImpl;
    }
    throw new IllegalStateException("The proxy has been not attached.");
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.a()) {
      return localAIOSelectableDelegateImpl.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return a().a(paramInt1, paramInt2);
  }
  
  @Nullable
  public String a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a().a(paramInt, paramBoolean);
  }
  
  public void a(@NonNull SelectableComponent paramSelectableComponent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent = paramSelectableComponent;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent.bind(this);
  }
  
  public void a(@NonNull SelectableCursor paramSelectableCursor1, @NonNull SelectableCursor paramSelectableCursor2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor = paramSelectableCursor1;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor.a(this);
    this.b = paramSelectableCursor2;
    this.b.a(this);
  }
  
  public void a(@NonNull SelectablePopupMenu paramSelectablePopupMenu)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu = paramSelectablePopupMenu;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.a() != null) {
      localAIOSelectableDelegateImpl.d();
    }
    localAIOSelectableDelegateImpl.a(this);
    localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent);
    localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor, this.b);
    localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu);
    localAIOSelectableDelegateImpl.a(paramChatMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public int b()
  {
    return a().b();
  }
  
  public void b()
  {
    a().b();
  }
  
  public void b(int paramInt)
  {
    AIOSelectableDelegateImpl.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c())
    {
      if (localAIOSelectableDelegateImpl.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
        return;
      }
      if (paramChatMessage.uniseq != localAIOSelectableDelegateImpl.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)
      {
        if (this == localAIOSelectableDelegateImpl.a()) {
          localAIOSelectableDelegateImpl.f();
        }
      }
      else if (this != localAIOSelectableDelegateImpl.a())
      {
        localAIOSelectableDelegateImpl.a(this);
        localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableComponent);
        localAIOSelectableDelegateImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor, this.b);
        if (localAIOSelectableDelegateImpl.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu != null) {
          a(localAIOSelectableDelegateImpl.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectablePopupMenu);
        }
        localAIOSelectableDelegateImpl.e();
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return a().c();
  }
  
  public void c()
  {
    AIOSelectableDelegateImpl.a().c();
  }
  
  public void c(int paramInt)
  {
    AIOSelectableDelegateImpl.a().c(paramInt);
  }
  
  public boolean c()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    return (this == localAIOSelectableDelegateImpl.a()) && (localAIOSelectableDelegateImpl.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (this == localAIOSelectableDelegateImpl.a()) {
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public boolean d()
  {
    SelectableCursor localSelectableCursor = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableCursor;
    return (localSelectableCursor != null) && (localSelectableCursor.a(1));
  }
  
  public boolean e()
  {
    SelectableCursor localSelectableCursor = this.b;
    return (localSelectableCursor != null) && (localSelectableCursor.a(2));
  }
  
  public boolean f()
  {
    return (d()) && (e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy
 * JD-Core Version:    0.7.0.1
 */