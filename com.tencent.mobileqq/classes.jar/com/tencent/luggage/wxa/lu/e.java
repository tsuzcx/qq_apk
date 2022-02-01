package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.pd.t;
import com.tencent.luggage.wxa.pd.t.b;
import org.json.JSONObject;

public class e
  extends u
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  protected t a;
  private boolean b = false;
  private t.b c = new e.1(this);
  
  private void a(c paramc)
  {
    if (!this.b)
    {
      this.a = new t(paramc.getContext(), this.c);
      this.a.enable();
      this.b = true;
    }
  }
  
  private void b()
  {
    if (this.b)
    {
      this.a.disable();
      this.a = null;
      this.b = false;
    }
  }
  
  public String a(c paramc, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.a(paramc);
      a(paramc);
    }
    else
    {
      h.b(paramc);
      b();
    }
    return b("ok");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.e
 * JD-Core Version:    0.7.0.1
 */