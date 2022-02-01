package com.tencent.luggage.wxa.ch;

import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.am;
import java.util.Map;

public class a
  extends am
{
  protected Map<String, Object> a(b paramb)
  {
    paramb = super.a(paramb);
    paramb.put("x5Version", Integer.valueOf(0));
    Integer localInteger = Integer.valueOf(654316592);
    paramb.put("clientVersion", localInteger);
    paramb.put("wmpfVersion", localInteger);
    paramb.put("wmpfRuntimeAppId", i.a.f().e());
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ch.a
 * JD-Core Version:    0.7.0.1
 */