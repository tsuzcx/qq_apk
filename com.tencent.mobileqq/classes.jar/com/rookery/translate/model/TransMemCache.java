package com.rookery.translate.model;

import android.support.v4.util.LruCache;

public class TransMemCache
  implements ICache<String>
{
  private int jdField_a_of_type_Int;
  LruCache<String, String> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  
  public TransMemCache(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new TransMemCache.1(this, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1) == null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramString2);
      }
      else
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString1);
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("tween");
    a(localStringBuilder.toString(), paramBoolean.toString());
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("tween");
    paramString1 = a(localStringBuilder.toString());
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
  
  public void b(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("HasChangeToOriginalText");
    a(localStringBuilder.toString(), paramBoolean.toString());
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(paramString1, paramString2, paramLong));
    localStringBuilder.append("HasChangeToOriginalText");
    paramString1 = a(localStringBuilder.toString());
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TransMemCache
 * JD-Core Version:    0.7.0.1
 */