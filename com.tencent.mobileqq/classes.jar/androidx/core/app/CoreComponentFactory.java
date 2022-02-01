package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(api=28)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CoreComponentFactory
  extends AppComponentFactory
{
  static <T> T checkCompatWrapper(T paramT)
  {
    if ((paramT instanceof CoreComponentFactory.CompatWrapped))
    {
      Object localObject = ((CoreComponentFactory.CompatWrapped)paramT).getWrapper();
      if (localObject != null) {
        return localObject;
      }
    }
    return paramT;
  }
  
  @NonNull
  public Activity instantiateActivity(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (Activity)checkCompatWrapper(super.instantiateActivity(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Application instantiateApplication(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return (Application)checkCompatWrapper(super.instantiateApplication(paramClassLoader, paramString));
  }
  
  @NonNull
  public ContentProvider instantiateProvider(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return (ContentProvider)checkCompatWrapper(super.instantiateProvider(paramClassLoader, paramString));
  }
  
  @NonNull
  public BroadcastReceiver instantiateReceiver(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (BroadcastReceiver)checkCompatWrapper(super.instantiateReceiver(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Service instantiateService(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (Service)checkCompatWrapper(super.instantiateService(paramClassLoader, paramString, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.CoreComponentFactory
 * JD-Core Version:    0.7.0.1
 */