package com.tencent.luggage.wxa.bl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.luggage.wxa.bm.e.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.magicbrush.MBRuntime;
import java.lang.ref.WeakReference;

public class b
  implements IImageDecodeService.b
{
  public static final b a = new b();
  private final int b = 2048;
  private final int c = 2048;
  private boolean d;
  private WeakReference<com.tencent.luggage.wxa.bp.b> e = null;
  
  private void a(int paramInt)
  {
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(807L, paramInt, 1L, false);
  }
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    if (this.e.get() != null)
    {
      com.tencent.luggage.wxa.bm.e locale = ((com.tencent.luggage.wxa.bp.b)this.e.get()).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      locale.a(parama, localStringBuilder.toString());
    }
  }
  
  public void a(MBRuntime paramMBRuntime, d paramd, boolean paramBoolean)
  {
    this.d = paramBoolean;
    o.d("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    com.tencent.luggage.wxa.bp.b localb;
    if ((paramBoolean) && (paramd != null) && ((paramd.ae() instanceof com.tencent.luggage.wxa.du.c))) {
      localb = (com.tencent.luggage.wxa.bp.b)((com.tencent.luggage.wxa.du.c)paramd.ae()).d(com.tencent.luggage.wxa.bp.b.class);
    } else {
      localb = null;
    }
    this.e = new WeakReference(localb);
    paramMBRuntime = paramMBRuntime.h();
    paramMBRuntime.addImageStreamFetcher(new b.a(paramd, null), true);
    paramMBRuntime.addImageStreamFetcher(new b.b(paramd), false);
    paramMBRuntime.setKvReportDelegate(new b.c(14883));
    paramd = new com.tencent.luggage.wxa.gj.a();
    paramd.a(2048, 2048);
    paramMBRuntime.setBitmapDecodeSlave(paramd);
    paramMBRuntime.addDecodeEventListener(this);
  }
  
  public void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
  {
    switch (b.1.a[parama.ordinal()])
    {
    default: 
      return;
    case 9: 
      o.d("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
      a(8);
      return;
    case 8: 
      o.b("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
      a(paramString, e.a.d, r.a().getString(2131886928));
      a(5);
      return;
    case 7: 
      o.b("MicroMsg.MBImageHandlerRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
      a(paramString, e.a.d, r.a().getString(2131886933));
      a(1);
      return;
    case 6: 
      o.b("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
      a(paramString, e.a.d, r.a().getString(2131886932));
      a(4);
      return;
    case 5: 
      a(paramString, e.a.d, String.format(r.a().getString(2131886937), new Object[] { Integer.valueOf(parama1.d()), Integer.valueOf(parama1.e()), Long.valueOf(parama1.g()), Long.valueOf(parama1.f()) }));
      a(3);
      return;
    case 4: 
      a(paramString, e.a.d, r.a().getString(2131886931));
      a(0);
      return;
    case 3: 
      a(paramString, e.a.d, r.a().getString(2131886936));
      a(5);
      return;
    case 2: 
      if (TextUtils.isEmpty(parama1.h())) {
        a(paramString, e.a.d, r.a().getString(2131886935));
      } else {
        a(paramString, e.a.d, String.format("%s: %s", new Object[] { r.a().getString(2131886935), parama1.h() }));
      }
      a(7);
      return;
    }
    com.tencent.luggage.wxa.bu.a.a().a(parama1.b(), parama1.c(), paramString, parama1);
    if (parama1.c() >= 1000L) {
      a(11);
    }
  }
  
  public void a(@NonNull String paramString, @Nullable Object paramObject, @Nullable IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.b
 * JD-Core Version:    0.7.0.1
 */