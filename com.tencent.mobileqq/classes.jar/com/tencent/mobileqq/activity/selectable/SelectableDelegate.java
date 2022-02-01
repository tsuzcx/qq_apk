package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface SelectableDelegate
{
  public abstract int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(@NonNull SelectablePopupMenu paramSelectablePopupMenu);
  
  public abstract void a(ChatMessage paramChatMessage);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract int b(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract String b();
  
  public abstract void b(@ColorInt int paramInt);
  
  public abstract int c();
  
  public abstract void c(@ColorInt int paramInt);
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public abstract int e();
  
  public abstract int f();
  
  public abstract int g();
  
  public abstract void h();
  
  public abstract boolean i();
  
  public abstract void j();
  
  public abstract boolean k();
  
  public abstract boolean l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract boolean q();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableDelegate
 * JD-Core Version:    0.7.0.1
 */