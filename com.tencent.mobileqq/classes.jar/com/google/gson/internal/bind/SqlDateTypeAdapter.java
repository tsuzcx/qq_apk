package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter
  extends TypeAdapter<Date>
{
  public static final TypeAdapterFactory FACTORY = new SqlDateTypeAdapter.1();
  private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");
  
  /* Error */
  public Date read(com.google.gson.stream.JsonReader paramJsonReader)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 42	com/google/gson/stream/JsonReader:peek	()Lcom/google/gson/stream/JsonToken;
    //   6: getstatic 48	com/google/gson/stream/JsonToken:NULL	Lcom/google/gson/stream/JsonToken;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 51	com/google/gson/stream/JsonReader:nextNull	()V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 53	java/sql/Date
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/google/gson/internal/bind/SqlDateTypeAdapter:format	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 57	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
    //   34: invokevirtual 63	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 69	java/util/Date:getTime	()J
    //   40: invokespecial 72	java/sql/Date:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: new 74	com/google/gson/JsonSyntaxException
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 77	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	SqlDateTypeAdapter
    //   0	62	1	paramJsonReader	com.google.gson.stream.JsonReader
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	57	finally
    //   22	44	57	finally
    //   48	57	57	finally
  }
  
  public void write(JsonWriter paramJsonWriter, Date paramDate)
  {
    if (paramDate == null) {}
    for (paramDate = null;; paramDate = this.format.format(paramDate)) {
      try
      {
        paramJsonWriter.value(paramDate);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.internal.bind.SqlDateTypeAdapter
 * JD-Core Version:    0.7.0.1
 */