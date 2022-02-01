package com.tencent.mobileqq.app.message.hookparcel;

import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.lang.reflect.Type;

public class PBJsonAdapter
  implements JsonDeserializer<MessageMicro>, JsonSerializer<MessageMicro>
{
  private Class<? extends MessageMicro<?>> a;
  
  public PBJsonAdapter(Class<? extends MessageMicro<?>> paramClass)
  {
    this.a = paramClass;
  }
  
  public JsonElement a(MessageMicro paramMessageMicro, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    return new JsonPrimitive(Base64.encodeToString(paramMessageMicro.toByteArray(), 3));
  }
  
  public MessageMicro a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
  {
    try
    {
      paramType = (MessageMicro)this.a.newInstance();
      paramType.mergeFrom(Base64.decode(paramJsonElement.getAsString(), 3));
      return paramType;
    }
    catch (IllegalAccessException paramJsonElement)
    {
      paramJsonElement.printStackTrace();
      return null;
    }
    catch (InstantiationException paramJsonElement)
    {
      for (;;)
      {
        paramJsonElement.printStackTrace();
      }
    }
    catch (InvalidProtocolBufferMicroException paramJsonElement)
    {
      for (;;)
      {
        paramJsonElement.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.PBJsonAdapter
 * JD-Core Version:    0.7.0.1
 */