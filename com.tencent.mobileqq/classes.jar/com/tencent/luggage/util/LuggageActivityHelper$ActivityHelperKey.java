package com.tencent.luggage.util;

import android.app.Activity;

public class LuggageActivityHelper$ActivityHelperKey
{
  private Class<? extends LuggageActivityHelper> a;
  private Activity b;
  
  public LuggageActivityHelper$ActivityHelperKey(Class<? extends LuggageActivityHelper> paramClass, Activity paramActivity)
  {
    this.a = paramClass;
    this.b = paramActivity;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityHelperKey)paramObject;
      if (!this.a.getCanonicalName().equals(paramObject.a.getCanonicalName())) {
        return false;
      }
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public Activity getActivity()
  {
    return this.b;
  }
  
  public Class<? extends LuggageActivityHelper> getHelper()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return this.a.getCanonicalName().hashCode() * 31 + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityHelperKey
 * JD-Core Version:    0.7.0.1
 */