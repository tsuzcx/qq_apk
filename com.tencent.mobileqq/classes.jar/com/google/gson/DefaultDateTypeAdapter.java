package com.google.gson;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class DefaultDateTypeAdapter
  extends TypeAdapter<java.util.Date>
{
  private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
  private final Class<? extends java.util.Date> dateType;
  private final DateFormat enUsFormat;
  private final DateFormat localFormat;
  
  public DefaultDateTypeAdapter(int paramInt1, int paramInt2)
  {
    this(java.util.Date.class, DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }
  
  DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass)
  {
    this(paramClass, DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }
  
  DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, int paramInt)
  {
    this(paramClass, DateFormat.getDateInstance(paramInt, Locale.US), DateFormat.getDateInstance(paramInt));
  }
  
  public DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, int paramInt1, int paramInt2)
  {
    this(paramClass, DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }
  
  DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, String paramString)
  {
    this(paramClass, new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }
  
  DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class) && (paramClass != Timestamp.class))
    {
      paramDateFormat1 = new StringBuilder();
      paramDateFormat1.append("Date type must be one of ");
      paramDateFormat1.append(java.util.Date.class);
      paramDateFormat1.append(", ");
      paramDateFormat1.append(Timestamp.class);
      paramDateFormat1.append(", or ");
      paramDateFormat1.append(java.sql.Date.class);
      paramDateFormat1.append(" but was ");
      paramDateFormat1.append(paramClass);
      throw new IllegalArgumentException(paramDateFormat1.toString());
    }
    this.dateType = paramClass;
    this.enUsFormat = paramDateFormat1;
    this.localFormat = paramDateFormat2;
  }
  
  private java.util.Date deserializeToDate(String paramString)
  {
    for (;;)
    {
      try
      {
        synchronized (this.localFormat)
        {
          localDate = this.localFormat.parse(paramString);
          return localDate;
        }
      }
      catch (ParseException localParseException2)
      {
        java.util.Date localDate;
        continue;
      }
      try
      {
        localDate = this.enUsFormat.parse(paramString);
        return localDate;
      }
      catch (ParseException localParseException3)
      {
        continue;
      }
      try
      {
        localDate = ISO8601Utils.parse(paramString, new ParsePosition(0));
        return localDate;
      }
      catch (ParseException localParseException1)
      {
        throw new JsonSyntaxException(paramString, localParseException1);
      }
    }
    throw paramString;
  }
  
  public java.util.Date read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    paramJsonReader = deserializeToDate(paramJsonReader.nextString());
    Class localClass = this.dateType;
    if (localClass == java.util.Date.class) {
      return paramJsonReader;
    }
    if (localClass == Timestamp.class) {
      return new Timestamp(paramJsonReader.getTime());
    }
    if (localClass == java.sql.Date.class) {
      return new java.sql.Date(paramJsonReader.getTime());
    }
    throw new AssertionError();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultDateTypeAdapter");
    localStringBuilder.append('(');
    localStringBuilder.append(this.localFormat.getClass().getSimpleName());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(JsonWriter paramJsonWriter, java.util.Date paramDate)
  {
    if (paramDate == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    synchronized (this.localFormat)
    {
      paramJsonWriter.value(this.enUsFormat.format(paramDate));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.DefaultDateTypeAdapter
 * JD-Core Version:    0.7.0.1
 */