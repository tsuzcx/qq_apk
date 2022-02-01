package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

final class TypeAdapters$10
  extends TypeAdapter<AtomicIntegerArray>
{
  public AtomicIntegerArray read(JsonReader paramJsonReader)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      try
      {
        localArrayList.add(Integer.valueOf(paramJsonReader.nextInt()));
      }
      catch (NumberFormatException paramJsonReader)
      {
        throw new JsonSyntaxException(paramJsonReader);
      }
    }
    paramJsonReader.endArray();
    int j = localArrayList.size();
    paramJsonReader = new AtomicIntegerArray(j);
    int i = 0;
    while (i < j)
    {
      paramJsonReader.set(i, ((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicIntegerArray paramAtomicIntegerArray)
  {
    paramJsonWriter.beginArray();
    int j = paramAtomicIntegerArray.length();
    int i = 0;
    while (i < j)
    {
      paramJsonWriter.value(paramAtomicIntegerArray.get(i));
      i += 1;
    }
    paramJsonWriter.endArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.10
 * JD-Core Version:    0.7.0.1
 */