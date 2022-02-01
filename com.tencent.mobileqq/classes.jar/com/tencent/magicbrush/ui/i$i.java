package com.tencent.magicbrush.ui;

import android.graphics.Bitmap;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 13})
final class i$i
  extends Lambda
  implements Function0<Bitmap>
{
  i$i(Bitmap paramBitmap, i.b paramb)
  {
    super(0);
  }
  
  public final Bitmap a()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      return ((TextureView)this.b).getBitmap(localBitmap);
    }
    return ((TextureView)this.b).getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.i
 * JD-Core Version:    0.7.0.1
 */