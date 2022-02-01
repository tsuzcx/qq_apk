package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser
{
  /* Error */
  public JsonElement parse(JsonReader paramJsonReader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 21	com/google/gson/stream/JsonReader:isLenient	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 25	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   10: aload_1
    //   11: invokestatic 29	com/google/gson/internal/Streams:parse	(Lcom/google/gson/stream/JsonReader;)Lcom/google/gson/JsonElement;
    //   14: astore_3
    //   15: aload_1
    //   16: iload_2
    //   17: invokevirtual 25	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   20: aload_3
    //   21: areturn
    //   22: astore_3
    //   23: new 31	com/google/gson/JsonParseException
    //   26: dup
    //   27: new 33	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   34: ldc 36
    //   36: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 45
    //   45: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aload_3
    //   52: invokespecial 52	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_3
    //   57: aload_1
    //   58: iload_2
    //   59: invokevirtual 25	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   62: aload_3
    //   63: athrow
    //   64: astore_3
    //   65: new 31	com/google/gson/JsonParseException
    //   68: dup
    //   69: new 33	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   76: ldc 36
    //   78: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 45
    //   87: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: aload_3
    //   94: invokespecial 52	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	JsonParser
    //   0	98	1	paramJsonReader	JsonReader
    //   4	55	2	bool	boolean
    //   14	7	3	localJsonElement	JsonElement
    //   22	30	3	localStackOverflowError	java.lang.StackOverflowError
    //   56	7	3	localObject	Object
    //   64	30	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   10	15	22	java/lang/StackOverflowError
    //   10	15	56	finally
    //   23	56	56	finally
    //   65	98	56	finally
    //   10	15	64	java/lang/OutOfMemoryError
  }
  
  public JsonElement parse(Reader paramReader)
  {
    JsonElement localJsonElement;
    try
    {
      paramReader = new JsonReader(paramReader);
      localJsonElement = parse(paramReader);
      if ((!localJsonElement.isJsonNull()) && (paramReader.peek() != JsonToken.END_DOCUMENT)) {
        throw new JsonSyntaxException("Did not consume the entire document.");
      }
    }
    catch (MalformedJsonException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new JsonIOException(paramReader);
    }
    catch (NumberFormatException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    return localJsonElement;
  }
  
  public JsonElement parse(String paramString)
  {
    return parse(new StringReader(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.gson.JsonParser
 * JD-Core Version:    0.7.0.1
 */