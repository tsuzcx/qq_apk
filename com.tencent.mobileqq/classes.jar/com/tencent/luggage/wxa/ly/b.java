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
import com.tencent.luggage.wxa.rh.d;
import org.json.JSONObject;

public class b
  extends a
{
  private static final int CTRL_INDEX = 580;
  private static final String NAME = "hideVirtualBottomNavigationBar";
  
  private void a(c paramc)
  {
    paramc = d.a(paramc.getContext());
    if (paramc == null)
    {
      o.d("JsApiHideVirtualBottomNavigationBar", "null == activity");
      return;
    }
    paramc = paramc.getWindow();
    if (paramc == null)
    {
      o.d("JsApiHideVirtualBottomNavigationBar", "null == window");
      return;
    }
    int j = paramc.getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 20) {
      i = j | 0x200 | 0x2;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1000;
    }
    i = j | 0x100;
    paramc.getDecorView().setSystemUiVisibility(i);
    paramc.getDecorView().setOnSystemUiVisibilityChangeListener(new b.2(this, paramc, i));
  }
  
  private void a(@NonNull c paramc, int paramInt)
  {
    if (!t.a())
    {
      t.a(new b.1(this, paramc, paramInt));
      return;
    }
    o.d("JsApiHideVirtualBottomNavigationBar", "hide");
    a(paramc);
    paramc.a(paramInt, b("ok"));
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ly.b
 * JD-Core Version:    0.7.0.1
 */