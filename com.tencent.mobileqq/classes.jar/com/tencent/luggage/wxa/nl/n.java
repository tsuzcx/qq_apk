package com.tencent.luggage.wxa.nl;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.rb.b;
import com.tencent.luggage.wxa.rb.d;

public class n
  extends d<m>
{
  public static final String[] a = { d.a(m.d, "LaunchWxaAppPBTable") };
  
  public n(b paramb)
  {
    super(paramb, m.d, "LaunchWxaAppPBTable", m.a);
  }
  
  public boolean a(String paramString, fb paramfb)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramfb != null))
    {
      m localm = new m();
      localm.b = paramString;
      localm.c = paramfb;
      return super.b(localm);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.n
 * JD-Core Version:    0.7.0.1
 */