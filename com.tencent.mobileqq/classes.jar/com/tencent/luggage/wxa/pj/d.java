package com.tencent.luggage.wxa.pj;

import com.tencent.luggage.wxa.pm.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class d
  extends c
{
  private String d()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  public com.tencent.luggage.wxa.pm.c a(com.tencent.luggage.wxa.pm.a parama, i parami)
  {
    super.a(parama, parami);
    parami.a("WebSocket Protocol Handshake");
    parami.a("Server", "Java-WebSocket");
    parami.a("Date", d());
    return parami;
  }
  
  public a c()
  {
    return new d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pj.d
 * JD-Core Version:    0.7.0.1
 */