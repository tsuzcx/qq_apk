package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;

final class u$a
  extends RelativeLayout
  implements bi
{
  public u$a(u paramu, @NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    if (!u.a(this.a)) {
      this.a.b_.draw(paramCanvas);
    }
    Bitmap localBitmap = this.a.aJ();
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, u.b(this.a).getTop(), null);
    }
    return true;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (this.a.a(this, paramRunnable)) {
      return true;
    }
    return super.post(paramRunnable);
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (this.a.a(this, paramRunnable, paramLong)) {
      return true;
    }
    return super.postDelayed(paramRunnable, paramLong);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.a
 * JD-Core Version:    0.7.0.1
 */