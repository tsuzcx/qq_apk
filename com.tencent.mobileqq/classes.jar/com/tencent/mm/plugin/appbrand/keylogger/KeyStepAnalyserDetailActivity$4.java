package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.nk.f;
import com.tencent.luggage.wxa.nk.j;
import com.tencent.luggage.wxa.nk.j.b;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.c;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.d;
import java.util.Map;

class KeyStepAnalyserDetailActivity$4
  implements j.b
{
  KeyStepAnalyserDetailActivity$4(KeyStepAnalyserDetailActivity paramKeyStepAnalyserDetailActivity, Map paramMap, com.tencent.mm.plugin.appbrand.keylogger.stepview.b paramb, Context paramContext) {}
  
  public void a(j paramj)
  {
    int i = paramj.a().f();
    int j = paramj.a().h();
    com.tencent.mm.plugin.appbrand.keylogger.stepview.b localb1;
    if (this.a.containsKey(Integer.valueOf(j))) {
      localb1 = (com.tencent.mm.plugin.appbrand.keylogger.stepview.b)this.a.get(Integer.valueOf(j));
    } else {
      localb1 = this.b;
    }
    Object localObject = paramj.b();
    if (i == 1)
    {
      localObject = new d(this.c);
      ((d)localObject).setStep((c)KeyStepAnalyserDetailActivity.i(this.d).get(paramj.b().b()));
      localb1.addView((View)localObject);
      return;
    }
    boolean bool;
    if (i == 3) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.mm.plugin.appbrand.keylogger.stepview.b localb2 = new com.tencent.mm.plugin.appbrand.keylogger.stepview.b(this.c, bool);
    if (this.a.size() > 0) {
      localb2.setHasBorder(true);
    }
    if (localObject != null) {
      localb2.setStep((c)KeyStepAnalyserDetailActivity.i(this.d).get(((com.tencent.luggage.wxa.nk.b)localObject).b()));
    }
    localb1.addView(localb2);
    this.a.put(Integer.valueOf(paramj.a().g()), localb2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */