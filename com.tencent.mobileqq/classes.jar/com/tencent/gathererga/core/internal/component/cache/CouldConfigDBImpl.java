package com.tencent.gathererga.core.internal.component.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gathererga.core.internal.component.GathererCompContext;
import com.tencent.gathererga.core.internal.component.db.AbsSecureStorage;

public class CouldConfigDBImpl
  extends AbsSecureStorage
  implements CloudConfigDB
{
  private SharedPreferences a;
  
  protected SharedPreferences a()
  {
    return this.a;
  }
  
  protected String a()
  {
    return GathererCompContext.a.a();
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("gatherer_cloud_conf", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.cache.CouldConfigDBImpl
 * JD-Core Version:    0.7.0.1
 */