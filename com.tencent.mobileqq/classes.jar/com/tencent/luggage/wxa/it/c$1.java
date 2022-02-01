package com.tencent.luggage.wxa.it;

import com.tencent.mm.ui.f;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

class c$1
  implements com.tencent.luggage.wxa.ir.a
{
  c$1(c paramc) {}
  
  public void a()
  {
    try
    {
      Date localDate = e.a.parse(c.a(this.a).b());
      this.a.b.c.onTimeSelectChanged(localDate);
      return;
    }
    catch (ParseException localParseException)
    {
      f.a(c.b(this.a), localParseException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.c.1
 * JD-Core Version:    0.7.0.1
 */