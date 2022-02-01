package com.tencent.luggage.wxa.ok;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int c = 0;
  
  protected a(@NonNull u paramu)
  {
    super(paramu);
  }
  
  private void a(boolean paramBoolean)
  {
    this.b.set(c.b.a);
    if ((this.a.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.a.getContext()).getWindow();
      if (localWindow == null) {
        return;
      }
      View localView = localWindow.getDecorView();
      localWindow.clearFlags(1024);
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramInt != this.c) {
      i = 1;
    } else {
      i = 0;
    }
    this.c = paramInt;
    if (2 == paramInt)
    {
      Activity localActivity = this.a.Y();
      if ((localActivity != null) && (Build.VERSION.SDK_INT >= 24) && (localActivity.isInMultiWindowMode()) && (localActivity.getRequestedOrientation() == 1)) {
        return;
      }
      if (!paramBoolean) {
        b();
      }
    }
    else if (((i != 0) || (this.b.get() == c.b.a)) && (!paramBoolean))
    {
      a();
    }
  }
  
  public void b()
  {
    this.b.set(c.b.b);
    Object localObject = com.tencent.luggage.wxa.rc.a.a(this.a.getContext());
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed()))
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject == null) {
        return;
      }
      ((Window)localObject).addFlags(1024);
      localObject = ((Window)localObject).getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
    }
  }
  
  public void c()
  {
    super.c();
    int i = a.1.a[((c.b)this.b.get()).ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      b();
      return;
    }
    a(true);
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ok.a
 * JD-Core Version:    0.7.0.1
 */