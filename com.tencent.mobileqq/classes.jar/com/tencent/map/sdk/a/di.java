package com.tencent.map.sdk.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class di
  implements ds<Date>, ea<Date>
{
  private final DateFormat a;
  private final DateFormat b;
  private final DateFormat c;
  
  di()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }
  
  public di(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }
  
  public di(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }
  
  private di(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    this.a = paramDateFormat1;
    this.b = paramDateFormat2;
    this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  private dt a(Date paramDate)
  {
    synchronized (this.b)
    {
      paramDate = new dy(this.a.format(paramDate));
      return paramDate;
    }
  }
  
  private Date a(dt paramdt)
  {
    for (;;)
    {
      try
      {
        synchronized (this.b)
        {
          localDate = this.b.parse(paramdt.c());
          return localDate;
        }
      }
      catch (ParseException localParseException2)
      {
        Date localDate;
        continue;
      }
      try
      {
        localDate = this.a.parse(paramdt.c());
        return localDate;
      }
      catch (ParseException localParseException3)
      {
        continue;
      }
      try
      {
        localDate = this.c.parse(paramdt.c());
        return localDate;
      }
      catch (ParseException localParseException1)
      {
        throw new eb(paramdt.c(), localParseException1);
      }
    }
    throw paramdt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(di.class.getSimpleName());
    localStringBuilder.append('(');
    localStringBuilder.append(this.b.getClass().getSimpleName());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.di
 * JD-Core Version:    0.7.0.1
 */