package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter
  extends TypeAdapter<Time>
{
  public static final TypeAdapterFactory FACTORY = new TimeTypeAdapter.1();
  private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");
  
  /* Error */
  public Time read(com.google.gson.stream.JsonReader paramJsonReader)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 42	com/google/gson/stream/JsonReader:peek	()Lcom/google/gson/stream/JsonToken;
    //   6: getstatic 48	com/google/gson/stream/JsonToken:NULL	Lcom/google/gson/stream/JsonToken;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 51	com/google/gson/stream/JsonReader:nextNull	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 53	java/sql/Time
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/google/gson/internal/bind/TimeTypeAdapter:format	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 57	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
    //   32: invokevirtual 63	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 69	java/util/Date:getTime	()J
    //   38: invokespecial 72	java/sql/Time:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: new 74	com/google/gson/JsonSyntaxException
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 77	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	TimeTypeAdapter
    //   0	61	1	paramJsonReader	com.google.gson.stream.JsonReader
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	56	finally
    //   20	42	56	finally
    //   47	56	56	finally
  }
  
  public void write(JsonWriter paramJsonWriter, Time paramTime)
  {
    if (paramTime == null) {
      paramTime = null;
    }
    try
    {
      paramTime = this.format.format(paramTime);
      paramJsonWriter.value(paramTime);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TimeTypeAdapter
 * JD-Core Version:    0.7.0.1
 */