package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class) && (paramClass != Timestamp.class)) {
      throw new IllegalArgumentException("Date type must be one of " + java.util.Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + paramClass);
    }
    this.dateType = paramClass;
    this.enUsFormat = paramDateFormat1;
    this.localFormat = paramDateFormat2;
  }
  
  private java.util.Date deserializeToDate(String paramString)
  {
    java.util.Date localDate2;
    synchronized (this.localFormat)
    {
      try
      {
        java.util.Date localDate1 = this.localFormat.parse(paramString);
        return localDate1;
      }
      catch (ParseException localParseException1) {}
    }
  }
  
  public java.util.Date read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      paramJsonReader = null;
    }
    java.util.Date localDate;
    do
    {
      return paramJsonReader;
      localDate = deserializeToDate(paramJsonReader.nextString());
      paramJsonReader = localDate;
    } while (this.dateType == java.util.Date.class);
    if (this.dateType == Timestamp.class) {
      return new Timestamp(localDate.getTime());
    }
    if (this.dateType == java.sql.Date.class) {
      return new java.sql.Date(localDate.getTime());
    }
    throw new AssertionError();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultDateTypeAdapter");
    localStringBuilder.append('(').append(this.localFormat.getClass().getSimpleName()).append(')');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.DefaultDateTypeAdapter
 * JD-Core Version:    0.7.0.1
 */