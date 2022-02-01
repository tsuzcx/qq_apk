package com.tencent.luggage.scanner.scanner.ui;

import android.graphics.Point;
import android.view.TextureView;
import com.tencent.luggage.scanner.camera.b.d.a;
import com.tencent.luggage.scanner.camera.g;

class b$1
  implements b.d.a
{
  b$1(b paramb, b.d.a parama) {}
  
  public void a()
  {
    if ((this.b.b.c()) && (this.b.b.a()) && (this.b.c != null))
    {
      Object localObject = this.b.a;
      b localb = this.b;
      ((TextureView)localObject).setTransform(b.a(localb, localb.b.g(), new Point(this.b.a.getWidth(), this.b.a.getHeight())));
      localObject = this.a;
      if (localObject != null) {
        ((b.d.a)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.b.1
 * JD-Core Version:    0.7.0.1
 */