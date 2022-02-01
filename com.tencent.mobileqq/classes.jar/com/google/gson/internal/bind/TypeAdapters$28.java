package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Locale;
import java.util.StringTokenizer;

final class TypeAdapters$28
  extends TypeAdapter<Locale>
{
  public Locale read(JsonReader paramJsonReader)
  {
    Object localObject1 = paramJsonReader.peek();
    Object localObject2 = JsonToken.NULL;
    String str = null;
    if (localObject1 == localObject2)
    {
      paramJsonReader.nextNull();
      return null;
    }
    localObject2 = new StringTokenizer(paramJsonReader.nextString(), "_");
    if (((StringTokenizer)localObject2).hasMoreElements()) {
      paramJsonReader = ((StringTokenizer)localObject2).nextToken();
    } else {
      paramJsonReader = null;
    }
    if (((StringTokenizer)localObject2).hasMoreElements()) {
      localObject1 = ((StringTokenizer)localObject2).nextToken();
    } else {
      localObject1 = null;
    }
    if (((StringTokenizer)localObject2).hasMoreElements()) {
      str = ((StringTokenizer)localObject2).nextToken();
    }
    if ((localObject1 == null) && (str == null)) {
      return new Locale(paramJsonReader);
    }
    if (str == null) {
      return new Locale(paramJsonReader, (String)localObject1);
    }
    return new Locale(paramJsonReader, (String)localObject1, str);
  }
  
  public void write(JsonWriter paramJsonWriter, Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = null;
    } else {
      paramLocale = paramLocale.toString();
    }
    paramJsonWriter.value(paramLocale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.28
 * JD-Core Version:    0.7.0.1
 */