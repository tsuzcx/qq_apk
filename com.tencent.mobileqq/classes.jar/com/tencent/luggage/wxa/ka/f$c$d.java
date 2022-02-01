package com.tencent.luggage.wxa.ka;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.oo.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.n.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class f$c$d
  implements Runnable
{
  f$c$d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, c paramc) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new n.a(this.a, this.b.getResources().getString(2131886923), this.c, this.d, false, null, 0, 112, null));
    this.e.a((List)localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.f.c.d
 * JD-Core Version:    0.7.0.1
 */