package com.tencent.luggage.wxa.kw;

import android.os.Looper;
import android.view.View;
import com.tencent.luggage.wxa.pp.h;
import com.tencent.luggage.wxa.pp.x;
import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.mm.plugin.appbrand.page.am;
import org.json.JSONObject;

public class f
  extends com.tencent.luggage.wxa.jx.u<com.tencent.mm.plugin.appbrand.page.u>
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "restoreWebviewFocus";
  
  private void a(com.tencent.mm.plugin.appbrand.page.u paramu, boolean paramBoolean)
  {
    h.a().c(paramu.aj());
    View localView = paramu.aj().getContentView();
    if (paramBoolean)
    {
      paramu = x.a(localView, paramu.aq());
      if (paramu != null) {
        paramu.setShowDoneButton(false);
      }
      localView.requestFocus();
    }
  }
  
  public String a(com.tencent.mm.plugin.appbrand.page.u paramu, JSONObject paramJSONObject)
  {
    new f.1(this, paramu, paramJSONObject.optBoolean("focus", false)).a(new s(Looper.getMainLooper()));
    return b("ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.f
 * JD-Core Version:    0.7.0.1
 */