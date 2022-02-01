package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;

class b$6
  implements Runnable
{
  b$6(b paramb, Bitmap paramBitmap, View.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    if (this.c.getParent() == null) {
      return;
    }
    if (b.c(this.c) == null)
    {
      Object localObject = (ViewStub)this.c.findViewById(2131431549);
      if (localObject == null) {
        return;
      }
      ((ViewStub)localObject).inflate();
      localObject = this.c;
      b.a((b)localObject, (AppBrandActionBarCustomImageView)((b)localObject).findViewById(2131431548));
    }
    b.c(this.c).setVisibility(0);
    b.c(this.c).setImageBitmap(this.a);
    b.c(this.c).setClickable(true);
    b.c(this.c).setOnClickListener(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.6
 * JD-Core Version:    0.7.0.1
 */