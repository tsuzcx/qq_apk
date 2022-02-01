package com.tencent.luggage.wxa.fy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class r
  implements i
{
  private Map<Class<? extends j>, j> a = new ConcurrentHashMap();
  
  @Nullable
  public <AddOn extends j> AddOn a(@NonNull Class<AddOn> paramClass)
  {
    j localj = (j)this.a.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj))) {
      return localj;
    }
    return null;
  }
  
  @NonNull
  public String a()
  {
    return "VideoPlayer#Stub";
  }
  
  public <AddOn extends j> void a(@NonNull Class<AddOn> paramClass, @Nullable AddOn paramAddOn)
  {
    if (paramAddOn == null)
    {
      this.a.remove(paramClass);
      return;
    }
    this.a.put(paramClass, paramAddOn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.r
 * JD-Core Version:    0.7.0.1
 */