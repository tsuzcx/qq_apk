package com.tencent.mobileqq.app.message.hookparcel;

import com.google.gson.GsonBuilder;
import java.lang.reflect.Field;

public abstract interface ParcelHooker$Callback
{
  public abstract void a(GsonBuilder paramGsonBuilder, Field[] paramArrayOfField);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.hookparcel.ParcelHooker.Callback
 * JD-Core Version:    0.7.0.1
 */