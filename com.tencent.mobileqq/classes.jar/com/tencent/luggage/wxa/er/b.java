package com.tencent.luggage.wxa.er;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.ui.PhoneNumberVerifyCodeUI;
import com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.a;
import com.tencent.luggage.wxa.bb.a.c;
import com.tencent.luggage.wxa.dc.s;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.du.b.b;
import com.tencent.luggage.wxa.nf.h;
import org.joor.Reflect;
import org.joor.ReflectException;

public class b
  extends com.tencent.luggage.wxa.dm.b
{
  private Context b;
  @Nullable
  private com.tencent.luggage.wxa.em.e c;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    try
    {
      this.c = ((com.tencent.luggage.wxa.em.e)Reflect.on("com.tencent.luggage.standalone_ext.game.impl.StandaloneGameGlobalSetupDelegateIMPL").create().get());
      return;
    }
    catch (ReflectException paramContext)
    {
      label28:
      break label28;
    }
    throw new RuntimeException("Check your proguard config pls, you should keep 'com.tencent.luggage.standalone_ext.game.impl.StandaloneGameGlobalSetupDelegateIMPL' for mini-game support.");
  }
  
  protected void a()
  {
    super.a();
    com.tencent.luggage.wxa.du.d.a().a(new b.b(), com.tencent.luggage.standalone_ext.service.d.class);
    com.tencent.luggage.wxa.em.e locale = this.c;
    if (locale != null) {
      locale.a();
    }
  }
  
  public void a(@NonNull a.c paramc)
  {
    super.a(paramc);
    paramc.a(com.tencent.luggage.wxa.pg.a.class, new com.tencent.luggage.wxa.ex.a());
    paramc.a(com.tencent.luggage.wxa.dp.a.class, new a());
    paramc.a(com.tencent.luggage.wxa.ob.b.class, s.a);
    paramc.a(com.tencent.luggage.wxa.cj.d.class, com.tencent.luggage.wxa.cj.b.a);
    paramc.a(com.tencent.luggage.wxa.mp.e.class, new com.tencent.luggage.wxa.co.a());
    paramc.a(com.tencent.luggage.wxa.ot.c.class, com.tencent.luggage.wxa.ot.b.a);
    paramc.a(com.tencent.luggage.wxa.ot.d.class, com.tencent.luggage.wxa.ot.g.a);
    com.tencent.luggage.wxa.em.e locale = this.c;
    if (locale != null) {
      locale.a(paramc);
    }
    com.tencent.luggage.wxa.do.b.a();
    i.a.a(true);
    PhoneNumberVerifyCodeUI.a.a();
    paramc.a(com.tencent.luggage.wxa.ja.e.class, new com.tencent.luggage.wxa.no.c());
    paramc.a(com.tencent.luggage.wxa.kp.d.class, new com.tencent.luggage.wxa.mv.b());
    paramc.a(com.tencent.luggage.wxa.ma.g.class, com.tencent.luggage.wxa.ma.c.a());
    paramc.a(h.class, com.tencent.luggage.wxa.fa.a.a());
    com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.iv.d.class, new b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.er.b
 * JD-Core Version:    0.7.0.1
 */