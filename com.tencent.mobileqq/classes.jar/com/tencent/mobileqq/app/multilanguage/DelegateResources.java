package com.tencent.mobileqq.app.multilanguage;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.qphone.base.util.QLog;

public class DelegateResources
  extends Resources
{
  private QQResourcesImpl a;
  
  public DelegateResources(QQResourcesImpl paramQQResourcesImpl)
  {
    super(paramQQResourcesImpl.b().getAssets(), paramQQResourcesImpl.b().getDisplayMetrics(), paramQQResourcesImpl.b().getConfiguration());
    this.a = paramQQResourcesImpl;
  }
  
  public CharSequence getText(int paramInt)
  {
    int i = this.a.a(paramInt);
    if (i > 0) {}
    label130:
    try
    {
      CharSequence localCharSequence = this.a.a().getText(i);
      break label40;
      localCharSequence = this.a.b().getText(paramInt);
      label40:
      localObject = localCharSequence;
      if (!QLog.isDevelopLevel()) {
        break label130;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ,content:");
      ((StringBuilder)localObject).append(localCharSequence);
      QLog.d("MultiLanguageEngine", 4, new Object[] { "getText delegate:", Integer.valueOf(paramInt), " ,langId:", Integer.valueOf(i), ((StringBuilder)localObject).toString() });
      return localCharSequence;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject;
      label117:
      break label117;
    }
    localObject = this.a.b().getText(paramInt);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.multilanguage.DelegateResources
 * JD-Core Version:    0.7.0.1
 */