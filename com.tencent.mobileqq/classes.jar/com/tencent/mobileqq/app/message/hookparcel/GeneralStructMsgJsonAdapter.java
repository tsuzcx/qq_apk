package com.tencent.mobileqq.app.message.hookparcel;

import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import java.lang.reflect.Type;

public class GeneralStructMsgJsonAdapter<T extends AbsStructMsg>
  implements JsonDeserializer<T>, JsonSerializer<T>
{
  public JsonElement a(T paramT, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    return new JsonPrimitive(Base64.encodeToString(paramT.getBytes(), 3));
  }
  
  public T a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
  {
    return StructMsgFactory.a(Base64.decode(paramJsonElement.getAsString(), 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.GeneralStructMsgJsonAdapter
 * JD-Core Version:    0.7.0.1
 */