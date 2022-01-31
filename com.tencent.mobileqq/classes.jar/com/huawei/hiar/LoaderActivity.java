package com.huawei.hiar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.huawei.remoteLoader.client.ARDynamiteClient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class LoaderActivity
  extends Activity
{
  private static final String TAG = LoaderActivity.class.getSimpleName();
  private Object instance;
  Class<?> localClass;
  
  public void LoadAPK(Bundle paramBundle, String paramString)
  {
    try
    {
      this.localClass = ARDynamiteClient.getLoadClass(paramString);
      if (this.localClass == null)
      {
        Log.e(TAG, "Load class failed! name =" + paramString);
        return;
      }
      this.instance = this.localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      Log.d(TAG, "instance = " + this.instance);
      paramString = this.localClass.getDeclaredMethod("setActivity", new Class[] { Activity.class });
      paramString.setAccessible(true);
      paramString.invoke(this.instance, new Object[] { this });
      paramString = this.localClass.getDeclaredMethod("onCreate", new Class[] { Bundle.class });
      paramString.setAccessible(true);
      paramString.invoke(this.instance, new Object[] { paramBundle });
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.__arengine_education);
    paramBundle = new Bundle();
    paramBundle.putBoolean("KEY_START_FROM_OTHER_ACTIVITY", true);
    paramBundle.putString("str", "LoaderActivity");
    Object localObject = getIntent();
    if (localObject == null)
    {
      Log.e(TAG, "intent is null");
      return;
    }
    localObject = (String)((Intent)localObject).getSerializableExtra("implActivityName");
    if (localObject == null)
    {
      Log.e(TAG, "implActivityName is null");
      return;
    }
    Log.d(TAG, "implActivityName is :" + (String)localObject);
    LoadAPK(paramBundle, (String)localObject);
  }
  
  protected void onDestroy()
  {
    Log.d(TAG, "onDestroy in LoaderActivity");
    super.onDestroy();
    try
    {
      Method localMethod = this.localClass.getDeclaredMethod("onDestroy", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.instance, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onPause()
  {
    Log.d(TAG, "onPause in LoaderActivity");
    super.onPause();
    try
    {
      Method localMethod = this.localClass.getDeclaredMethod("onPause", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.instance, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onResume()
  {
    Log.d(TAG, "onResume in LoaderActivity");
    super.onResume();
    try
    {
      Method localMethod = this.localClass.getDeclaredMethod("onResume", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.instance, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onStart()
  {
    Log.d(TAG, "onStart in LoaderActivity");
    super.onStart();
    try
    {
      Method localMethod = this.localClass.getDeclaredMethod("onStart", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.instance, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onStop()
  {
    Log.d(TAG, "onStop in LoaderActivity");
    super.onStop();
    try
    {
      Method localMethod = this.localClass.getDeclaredMethod("onStop", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this.instance, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.LoaderActivity
 * JD-Core Version:    0.7.0.1
 */