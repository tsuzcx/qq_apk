package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;

final class TreeTypeAdapter$GsonContextImpl
  implements JsonDeserializationContext, JsonSerializationContext
{
  private TreeTypeAdapter$GsonContextImpl(TreeTypeAdapter paramTreeTypeAdapter) {}
  
  public <R> R deserialize(JsonElement paramJsonElement, Type paramType)
  {
    return this.this$0.gson.fromJson(paramJsonElement, paramType);
  }
  
  public JsonElement serialize(Object paramObject)
  {
    return this.this$0.gson.toJsonTree(paramObject);
  }
  
  public JsonElement serialize(Object paramObject, Type paramType)
  {
    return this.this$0.gson.toJsonTree(paramObject, paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter.GsonContextImpl
 * JD-Core Version:    0.7.0.1
 */