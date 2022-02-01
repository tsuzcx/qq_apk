package com.tencent.biz.qqcircle.extendpb;

import android.text.TextUtils;
import java.util.HashMap;

public class BaseBlockData<T>
{
  protected HashMap<String, Object> a;
  protected T b;
  
  public BaseBlockData(T paramT)
  {
    this.b = paramT;
    this.a = new HashMap();
  }
  
  public T a()
  {
    return this.b;
  }
  
  public Object a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return this.a.get(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.a.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.extendpb.BaseBlockData
 * JD-Core Version:    0.7.0.1
 */