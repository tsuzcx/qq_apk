package com.jeremyliao.liveeventbus.ipc.json;

public abstract interface JsonConverter
{
  public abstract <T> T fromJson(String paramString, Class<T> paramClass);
  
  public abstract String toJson(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.ipc.json.JsonConverter
 * JD-Core Version:    0.7.0.1
 */