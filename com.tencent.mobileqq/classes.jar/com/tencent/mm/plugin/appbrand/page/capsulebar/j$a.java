package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.LinkedList;

public final class j$a
  implements i.a
{
  @Nullable
  private Drawable b = null;
  @Nullable
  private CharSequence c = null;
  private int d = -2147483648;
  
  protected j$a(j paramj) {}
  
  @UiThread
  private boolean b()
  {
    return j.b(this.a).peekFirst() == this;
  }
  
  public void a()
  {
    this.a.a(new j.a.6(this));
  }
  
  public void b(int paramInt)
  {
    this.a.a(new j.a.5(this, paramInt));
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    this.a.a(new j.a.1(this, paramDrawable));
  }
  
  public void b(@Nullable CharSequence paramCharSequence)
  {
    this.a.a(new j.a.3(this, paramCharSequence));
  }
  
  public void c(int paramInt)
  {
    this.a.a(new j.a.2(this, paramInt));
  }
  
  public void d(int paramInt)
  {
    this.a.a(new j.a.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j.a
 * JD-Core Version:    0.7.0.1
 */