package com.tencent.mobileqq.app.multilanguage;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;

public class QQResourcesImpl
{
  private Resources a;
  private Resources b;
  private String c;
  
  public QQResourcesImpl(Context paramContext)
  {
    this.a = paramContext.getResources();
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (this.b == null) {
        return 0;
      }
      localObject = ((Resources)localObject).getResourceEntryName(paramInt);
      String str = this.a.getResourceTypeName(paramInt);
      int i = this.b.getIdentifier((String)localObject, str, this.c);
      if (i > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiLanguageEngine", 2, new Object[] { "resourceName:", localObject, " ,lanResID:", Integer.valueOf(i), " ,oldId:", Integer.valueOf(paramInt) });
        }
        return i;
      }
    }
    return 0;
  }
  
  public Resources a()
  {
    Resources localResources2 = this.b;
    Resources localResources1 = localResources2;
    if (localResources2 == null) {
      localResources1 = this.a;
    }
    return localResources1;
  }
  
  public void a(Resources paramResources, String paramString)
  {
    this.b = paramResources;
    this.c = paramString;
  }
  
  public Resources b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.multilanguage.QQResourcesImpl
 * JD-Core Version:    0.7.0.1
 */