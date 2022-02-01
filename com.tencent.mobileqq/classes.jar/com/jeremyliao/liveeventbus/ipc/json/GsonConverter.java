package com.jeremyliao.liveeventbus.ipc.json;

import com.google.gson.Gson;

public class GsonConverter
  implements JsonConverter
{
  private Gson gson = new Gson();
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    return this.gson.fromJson(paramString, paramClass);
  }
  
  public String toJson(Object paramObject)
  {
    return this.gson.toJson(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.ipc.json.GsonConverter
 * JD-Core Version:    0.7.0.1
 */