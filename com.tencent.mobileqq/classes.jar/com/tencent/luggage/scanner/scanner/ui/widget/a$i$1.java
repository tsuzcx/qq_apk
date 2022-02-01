package com.tencent.luggage.scanner.scanner.ui.widget;

import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class a$i$1
  implements Runnable
{
  a$i$1(a.i parami) {}
  
  public final void run()
  {
    if ((!a.n(this.a.a)) && (a.m(this.a.a) != null))
    {
      Object localObject = a.m(this.a.a);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (!((Bitmap)localObject).isRecycled())
      {
        a.o(this.a.a).setImageBitmap(a.m(this.a.a));
        a.o(this.a.a).setVisibility(0);
        a.o(this.a.a).setAlpha(0.0F);
        localObject = a.o(this.a.a).animate();
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).cancel();
        }
        localObject = a.o(this.a.a).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.i.1
 * JD-Core Version:    0.7.0.1
 */