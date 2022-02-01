package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.InetAddress;

final class TypeAdapters$23
  extends TypeAdapter<InetAddress>
{
  public InetAddress read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return InetAddress.getByName(paramJsonReader.nextString());
  }
  
  public void write(JsonWriter paramJsonWriter, InetAddress paramInetAddress)
  {
    if (paramInetAddress == null) {
      paramInetAddress = null;
    } else {
      paramInetAddress = paramInetAddress.getHostAddress();
    }
    paramJsonWriter.value(paramInetAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.23
 * JD-Core Version:    0.7.0.1
 */