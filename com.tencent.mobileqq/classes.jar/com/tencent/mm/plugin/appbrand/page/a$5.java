package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.oi.f.a;
import com.tencent.luggage.wxa.pc.g;

class a$5
  extends aw
{
  a$5(a parama, u paramu, y paramy)
  {
    super(paramu, paramy);
  }
  
  public void a(@NonNull f.a parama, int paramInt)
  {
    super.a(parama, paramInt);
    if (this.a.y() == null) {
      return;
    }
    ((c)this.a.y()).a(new a.5.1(this, paramInt));
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    boolean bool = this.a.n().aj().a();
    Resources localResources = this.a.n().ag().getResources();
    if (bool) {
      i = 2131165190;
    } else {
      i = 2131165364;
    }
    int i = g.a(paramString2, localResources.getColor(i));
    a(f.a.a(paramString1, bool), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.5
 * JD-Core Version:    0.7.0.1
 */