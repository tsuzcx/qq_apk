package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RequiresApi(28)
public class AppComponentFactory
  extends android.app.AppComponentFactory
{
  @NonNull
  public final Activity instantiateActivity(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (Activity)CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Activity instantiateActivityCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    try
    {
      paramClassLoader = (Activity)Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new RuntimeException("Couldn't call constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label27:
      break label27;
    }
  }
  
  @NonNull
  public final Application instantiateApplication(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return (Application)CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(paramClassLoader, paramString));
  }
  
  @NonNull
  public Application instantiateApplicationCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = (Application)Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new RuntimeException("Couldn't call constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label27:
      break label27;
    }
  }
  
  @NonNull
  public final ContentProvider instantiateProvider(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return (ContentProvider)CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(paramClassLoader, paramString));
  }
  
  @NonNull
  public ContentProvider instantiateProviderCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = (ContentProvider)Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new RuntimeException("Couldn't call constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label27:
      break label27;
    }
  }
  
  @NonNull
  public final BroadcastReceiver instantiateReceiver(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public BroadcastReceiver instantiateReceiverCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    try
    {
      paramClassLoader = (BroadcastReceiver)Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new RuntimeException("Couldn't call constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label27:
      break label27;
    }
  }
  
  @NonNull
  public final Service instantiateService(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    return (Service)CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(paramClassLoader, paramString, paramIntent));
  }
  
  @NonNull
  public Service instantiateServiceCompat(@NonNull ClassLoader paramClassLoader, @NonNull String paramString, @Nullable Intent paramIntent)
  {
    try
    {
      paramClassLoader = (Service)Class.forName(paramString, false, paramClassLoader).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      throw new RuntimeException("Couldn't call constructor", paramClassLoader);
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label27:
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.AppComponentFactory
 * JD-Core Version:    0.7.0.1
 */