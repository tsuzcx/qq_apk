package com.tencent.luggage.wxa.qa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.sj.g;
import com.tencent.mm.plugin.appbrand.appstorage.o;

class j$1
  implements g
{
  j$1(j paramj) {}
  
  public String a()
  {
    return "TempFileIconLoader";
  }
  
  public void run()
  {
    Object localObject = this.a.b.getFileSystem().g(this.a.a);
    if (localObject == null)
    {
      this.a.c.a("Failed to load icon via temp file", this.a);
      return;
    }
    localObject = BitmapFactory.decodeFile(((i)localObject).b());
    if (localObject != null)
    {
      this.a.a((Bitmap)localObject);
      return;
    }
    this.a.c.a("Failed to load icon via temp file", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.j.1
 * JD-Core Version:    0.7.0.1
 */