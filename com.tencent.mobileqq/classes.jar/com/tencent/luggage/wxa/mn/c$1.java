package com.tencent.luggage.wxa.mn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.kz.b;
import com.tencent.luggage.wxa.po.a;
import com.tencent.luggage.wxa.qz.o;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.apache.commons.io.IOUtils;

final class c$1
  implements a.c
{
  c$1(String paramString, c.b paramb, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void a(@Nullable InputStream paramInputStream)
  {
    if (paramInputStream == null)
    {
      o.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute, openRead failed, url=%s", new Object[] { this.a });
      paramInputStream = this.b;
      if (paramInputStream != null) {
        paramInputStream.a(null);
      }
      return;
    }
    paramInputStream = c.a(paramInputStream);
    paramInputStream.mark(c.a());
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    c.b().a(paramInputStream, null, (BitmapFactory.Options)localObject1);
    Object localObject2 = ((BitmapFactory.Options)localObject1).outMimeType;
    c.b localb = this.b;
    if (localb != null) {
      localb.a((BitmapFactory.Options)localObject1);
    }
    int i = -1;
    int j = ((String)localObject2).hashCode();
    if (j != -879299344)
    {
      if ((j == -879267568) && (((String)localObject2).equals("image/gif"))) {
        i = 0;
      }
    }
    else if (((String)localObject2).equals("image/GIF")) {
      i = 1;
    }
    if ((i != 0) && (i != 1)) {}
    try
    {
      paramInputStream.reset();
      localObject1 = c.b().a(paramInputStream);
      IOUtils.closeQuietly(paramInputStream);
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        break label266;
      }
      paramInputStream = (com.tencent.luggage.wxa.jx.c)this.c.get();
      localObject2 = (a)this.d.get();
      if ((paramInputStream == null) || (localObject2 == null)) {
        break label266;
      }
      paramInputStream.a(new c.1.2(this, (a)localObject2, (Bitmap)localObject1));
      return;
    }
    catch (Throwable paramInputStream)
    {
      label248:
      break label248;
    }
    o.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute, setImageBitmap failed, url=%s", new Object[] { this.a });
    label266:
    return;
    try
    {
      paramInputStream.reset();
      localObject1 = IOUtils.toByteArray(paramInputStream);
      IOUtils.closeQuietly(paramInputStream);
      paramInputStream = (com.tencent.luggage.wxa.jx.c)this.c.get();
      localObject2 = (a)this.d.get();
      if ((paramInputStream == null) || (localObject2 == null)) {
        break label350;
      }
      paramInputStream.a(new c.1.1(this, (a)localObject2, (byte[])localObject1));
      return;
    }
    catch (Throwable paramInputStream)
    {
      label332:
      label350:
      break label332;
    }
    o.b("Luggage.ViewAttributeHelper", "attachImageViewAttribute, setImageByteArray failed, url=%s", new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.c.1
 * JD-Core Version:    0.7.0.1
 */