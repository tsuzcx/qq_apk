package com.tencent.luggage.wxa.kt;

import android.graphics.BitmapFactory.Options;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.mn.c.b;

class c
  extends ah
  implements c.b
{
  private static final int CTRL_INDEX = 678;
  public static final String NAME = "onImageViewLoad";
  private final a.b a;
  private final e b;
  
  c(int paramInt, a.b paramb, e parame)
  {
    a("viewId", Integer.valueOf(paramInt));
    this.a = paramb;
    this.b = parame;
  }
  
  public void a(@Nullable BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null)
    {
      a("errMsg", "ok");
      a("size", new c.1(this, paramOptions));
    }
    else
    {
      a("errMsg", "fail");
    }
    paramOptions = this.a;
    if ((paramOptions != null) && ("webview".equals(paramOptions.b("sendTo", null))))
    {
      this.b.a(this);
      return;
    }
    this.b.a(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.c
 * JD-Core Version:    0.7.0.1
 */