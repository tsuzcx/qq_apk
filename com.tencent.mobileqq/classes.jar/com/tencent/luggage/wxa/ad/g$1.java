package com.tencent.luggage.wxa.ad;

import com.tencent.luggage.wxa.ae.c;
import com.tencent.luggage.wxa.ak.b;
import com.tencent.luggage.wxa.h.k;

final class g$1
  implements g
{
  public boolean a(k paramk)
  {
    paramk = paramk.f;
    return ("text/vtt".equals(paramk)) || ("text/x-ssa".equals(paramk)) || ("application/ttml+xml".equals(paramk)) || ("application/x-mp4-vtt".equals(paramk)) || ("application/x-subrip".equals(paramk)) || ("application/x-quicktime-tx3g".equals(paramk)) || ("application/cea-608".equals(paramk)) || ("application/x-mp4-cea-608".equals(paramk)) || ("application/cea-708".equals(paramk)) || ("application/dvbsubs".equals(paramk));
  }
  
  public e b(k paramk)
  {
    String str = paramk.f;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1693976202: 
      if (str.equals("application/ttml+xml")) {
        i = 3;
      }
      break;
    case 1668750253: 
      if (str.equals("application/x-subrip")) {
        i = 4;
      }
      break;
    case 1566016562: 
      if (str.equals("application/cea-708")) {
        i = 8;
      }
      break;
    case 1566015601: 
      if (str.equals("application/cea-608")) {
        i = 6;
      }
      break;
    case 930165504: 
      if (str.equals("application/x-mp4-cea-608")) {
        i = 7;
      }
      break;
    case 822864842: 
      if (str.equals("text/x-ssa")) {
        i = 1;
      }
      break;
    case 691401887: 
      if (str.equals("application/x-quicktime-tx3g")) {
        i = 5;
      }
      break;
    case -1004728940: 
      if (str.equals("text/vtt")) {
        i = 0;
      }
      break;
    case -1026075066: 
      if (str.equals("application/x-mp4-vtt")) {
        i = 2;
      }
      break;
    case -1351681404: 
      if (str.equals("application/dvbsubs")) {
        i = 9;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
    case 9: 
      return new com.tencent.luggage.wxa.af.a(paramk.h);
    case 8: 
      return new c(paramk.z);
    case 6: 
    case 7: 
      return new com.tencent.luggage.wxa.ae.a(paramk.f, paramk.z);
    case 5: 
      return new com.tencent.luggage.wxa.aj.a(paramk.h);
    case 4: 
      return new com.tencent.luggage.wxa.ah.a();
    case 3: 
      return new com.tencent.luggage.wxa.ai.a();
    case 2: 
      return new b();
    case 1: 
      return new com.tencent.luggage.wxa.ag.a(paramk.h);
    }
    return new com.tencent.luggage.wxa.ak.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ad.g.1
 * JD-Core Version:    0.7.0.1
 */