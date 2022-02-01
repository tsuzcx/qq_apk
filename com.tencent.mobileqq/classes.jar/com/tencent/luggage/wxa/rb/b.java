package com.tencent.luggage.wxa.rb;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface b
{
  public abstract int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString);
  
  public abstract int a(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract long a(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract long b(String paramString1, String paramString2, ContentValues paramContentValues);
  
  public abstract Cursor b(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor b(String paramString, String[] paramArrayOfString, int paramInt);
  
  public abstract Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);
  
  public abstract Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.b
 * JD-Core Version:    0.7.0.1
 */