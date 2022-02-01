package com.tencent.mobileqq.app.multilanguage;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;

public class QQResourcesImpl
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private String jdField_a_of_type_JavaLangString;
  private Resources b;
  
  public QQResourcesImpl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentResResources;
    if (localObject != null)
    {
      if (this.b == null) {
        return paramInt;
      }
      localObject = ((Resources)localObject).getResourceEntryName(paramInt);
      String str = this.jdField_a_of_type_AndroidContentResResources.getResourceTypeName(paramInt);
      int i = this.b.getIdentifier((String)localObject, str, this.jdField_a_of_type_JavaLangString);
      if (i > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiLanguageEngine", 2, new Object[] { "resourceName:", localObject, " ,lanResID:", Integer.valueOf(i), " ,oldId:", Integer.valueOf(paramInt) });
        }
        return i;
      }
    }
    return paramInt;
  }
  
  public Resources a()
  {
    Resources localResources2 = this.b;
    Resources localResources1 = localResources2;
    if (localResources2 == null) {
      localResources1 = this.jdField_a_of_type_AndroidContentResResources;
    }
    return localResources1;
  }
  
  public void a(Resources paramResources, String paramString)
  {
    this.b = paramResources;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Resources b()
  {
    return this.jdField_a_of_type_AndroidContentResResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.multilanguage.QQResourcesImpl
 * JD-Core Version:    0.7.0.1
 */