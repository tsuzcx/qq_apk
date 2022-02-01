package com.tencent.luggage.wxa.ly;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class d
  extends a<c>
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "showVirtualBottomNavigationBar";
  
  private void a(c paramc)
  {
    paramc = com.tencent.luggage.wxa.rh.d.a(paramc.getContext());
    if (paramc == null)
    {
      o.d("JsApiShowVirtualBottomNavigationBar", "null == activity");
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      o.d("JsApiShowVirtualBottomNavigationBar", "null == window");
      return;
    }
    int j = paramc.getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j & 0xFFFFFDFF & 0xFFFFFFFD;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i & 0xFFFFEFFF;
    }
    paramc.getDecorView().setSystemUiVisibility(j & 0xFFFFFEFF);
    paramc.getDecorView().setOnSystemUiVisibilityChangeListener(null);
  }
  
  private void a(@NonNull c paramc, int paramInt)
  {
    if (!t.a())
    {
      t.a(new d.1(this, paramc, paramInt));
      return;
    }
    o.d("JsApiShowVirtualBottomNavigationBar", "show");
    a(paramc);
    paramc.a(paramInt, b("ok"));
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ly.d
 * JD-Core Version:    0.7.0.1
 */