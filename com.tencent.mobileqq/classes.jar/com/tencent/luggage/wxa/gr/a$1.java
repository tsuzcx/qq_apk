package com.tencent.luggage.wxa.gr;

import java.util.ArrayList;
import java.util.HashMap;

class a$1
  implements e
{
  a$1(a parama) {}
  
  public void a(com.tencent.luggage.wxa.if.b paramb)
  {
    Object localObject = a.a(this.a);
    if (paramb != null) {}
    try
    {
      a.b(this.a).remove(paramb.b);
      String str = paramb.b;
      a.c(this.a).add(paramb.b);
      break label55;
      str = "";
      label55:
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Audio.AudioDownloadMgr", "download finish, src:%s", new Object[] { str });
      if (a.d(this.a) != null) {
        a.d(this.a).a(paramb);
      }
      return;
    }
    finally {}
  }
  
  public void b(com.tencent.luggage.wxa.if.b paramb)
  {
    Object localObject = a.a(this.a);
    if (paramb != null) {}
    try
    {
      a.b(this.a).remove(paramb.b);
      paramb = paramb.b;
      break label40;
      paramb = "";
      label40:
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Audio.AudioDownloadMgr", "download fail, src:%s", new Object[] { paramb });
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gr.a.1
 * JD-Core Version:    0.7.0.1
 */