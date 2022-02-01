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
    //   23: goto +97 -> 120
    //   26: astore_3
    //   27: new 31	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: aload 4
    //   38: ldc 34
    //   40: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_1
    //   47: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: ldc 43
    //   55: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 45	com/google/gson/JsonParseException
    //   62: dup
    //   63: aload 4
    //   65: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aload_3
    //   69: invokespecial 52	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_3
    //   74: new 31	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: ldc 34
    //   87: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 4
    //   93: aload_1
    //   94: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 4
    //   100: ldc 43
    //   102: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: new 45	com/google/gson/JsonParseException
    //   109: dup
    //   110: aload 4
    //   112: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aload_3
    //   116: invokespecial 52	com/google/gson/JsonParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: athrow
    //   120: aload_1
    //   121: iload_2
    //   122: invokevirtual 25	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   125: aload_3
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	JsonParser
    //   0	127	1	paramJsonReader	JsonReader
    //   4	118	2	bool	boolean
    //   14	7	3	localJsonElement	JsonElement
    //   22	1	3	localObject	Object
    //   26	43	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   73	53	3	localStackOverflowError	java.lang.StackOverflowError
    //   34	77	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	15	22	finally
    //   27	73	22	finally
    //   74	120	22	finally
    //   10	15	26	java/lang/OutOfMemoryError
    //   10	15	73	java/lang/StackOverflowError
  }
  
  public JsonElement parse(Reader paramReader)
  {
    try
    {
      paramReader = new JsonReader(paramReader);
      JsonElement localJsonElement = parse(paramReader);
      if (!localJsonElement.isJsonNull())
      {
        if (paramReader.peek() == JsonToken.END_DOCUMENT) {
          return localJsonElement;
        }
        throw new JsonSyntaxException("Did not consume the entire document.");
      }
      return localJsonElement;
    }
    catch (NumberFormatException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new JsonIOException(paramReader);
    }
    catch (MalformedJsonException paramReader)
    {
      throw new JsonSyntaxException(paramReader);
    }
  }
  
  public JsonElement parse(String paramString)
  {
    return parse(new StringReader(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.JsonParser
 * JD-Core Version:    0.7.0.1
 */