package com.tencent.luggage.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.SparseArray;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.a;
import org.joor.Reflect;

@Keep
public class LuggageActivityHelper
{
  protected static final String KEY_INSTANCE_ID = "Luggage.LuggageActivityHelperinstance_id";
  protected static final String KEY_PROC_NAME = "Luggage.LuggageActivityHelperproc_name";
  protected static final String KEY_REQ_CODE = "Luggage.LuggageActivityHelperreq_code";
  private static final String TAG = "Luggage.LuggageActivityHelper";
  protected static final Map<LuggageActivityHelper.ActivityHelperKey, LuggageActivityHelper> sHelpers = new HashMap();
  @Nullable
  protected Activity mActivity;
  private LuggageActivityHelper.ActivityFinishInterceptCallback mActivityFinishInterceptCallback;
  protected final SparseArray<LuggageActivityHelper.ActivityResultCallback> mActivityResultCallbacks = new SparseArray();
  private final Set<LuggageActivityHelper.ActivityResultInterceptCallback> mInterceptResultCallbacks = Collections.newSetFromMap(new ConcurrentHashMap());
  private final SparseArray<LuggageActivityHelper.PermissionResultCallback> mPermissionResultCallbacks = new SparseArray();
  private Random mRand;
  
  protected LuggageActivityHelper(@Nullable Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mRand = new Random();
  }
  
  public static LuggageActivityHelper FOR(Context paramContext)
  {
    return FOR(paramContext, LuggageActivityHelper.class);
  }
  
  public static <T extends LuggageActivityHelper> T FOR(Context paramContext, Class<T> paramClass)
  {
    a.b("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if (((paramContext.isFinishing()) || (paramContext.isDestroyed())) && (paramClass == LuggageActivityHelper.class))
      {
        o.b("Luggage.LuggageActivityHelper", "FOR(%s, %s) instance destroyed, return DUMMY", new Object[] { paramContext, paramClass.getCanonicalName() });
        return (LuggageActivityHelper)getDummy(LuggageActivityHelper.class, paramContext);
      }
      LuggageActivityHelper.ActivityHelperKey localActivityHelperKey = genActivityHelperKey(paramClass, paramContext);
      if (sHelpers.get(localActivityHelperKey) == null)
      {
        paramClass = (LuggageActivityHelper)Reflect.on(paramClass).create(new Object[] { paramContext }).get();
        sHelpers.put(localActivityHelperKey, paramClass);
        LuggageActivityHelper.ActivityAutoRelease.register(paramContext, paramClass);
      }
      return (LuggageActivityHelper)sHelpers.get(localActivityHelperKey);
    }
    a.b(false);
    return (LuggageActivityHelper)getDummy(paramClass, null);
  }
  
  public static void REMOVE(Context paramContext)
  {
    remove(paramContext);
  }
  
  private boolean checkActivityFinish()
  {
    LuggageActivityHelper.ActivityFinishInterceptCallback localActivityFinishInterceptCallback = this.mActivityFinishInterceptCallback;
    if (localActivityFinishInterceptCallback != null) {
      return localActivityFinishInterceptCallback.interceptFinishResult();
    }
    return true;
  }
  
  protected static LuggageActivityHelper.ActivityHelperKey genActivityHelperKey(Class<? extends LuggageActivityHelper> paramClass, Activity paramActivity)
  {
    return new LuggageActivityHelper.ActivityHelperKey(paramClass, paramActivity);
  }
  
  private static <T extends LuggageActivityHelper> Object getDummy(Class<T> paramClass, Activity paramActivity)
  {
    return (LuggageActivityHelper)Reflect.on(paramClass).create(new Object[] { paramActivity }).get();
  }
  
  private int rand()
  {
    return this.mRand.nextInt(2147483646) + 1 & 0xFFFF;
  }
  
  private static void remove(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      Object localObject1 = sHelpers.entrySet().iterator();
      Object localObject2 = new ArrayList();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (LuggageActivityHelper.ActivityHelperKey.a((LuggageActivityHelper.ActivityHelperKey)((Map.Entry)localObject3).getKey()) == paramContext) {
          ((List)localObject2).add(((Map.Entry)localObject3).getKey());
        }
      }
      paramContext = ((List)localObject2).iterator();
      while (paramContext.hasNext())
      {
        localObject1 = (LuggageActivityHelper.ActivityHelperKey)paramContext.next();
        localObject2 = (LuggageActivityHelper)sHelpers.remove(localObject1);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("FOR: put");
        ((StringBuilder)localObject3).append(LuggageActivityHelper.ActivityHelperKey.b((LuggageActivityHelper.ActivityHelperKey)localObject1).getCanonicalName());
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(LuggageActivityHelper.ActivityHelperKey.a((LuggageActivityHelper.ActivityHelperKey)localObject1).getClass().getCanonicalName());
        o.d("Luggage.LuggageActivityHelper", ((StringBuilder)localObject3).toString());
        if (localObject2 != null)
        {
          ((LuggageActivityHelper)localObject2).mActivityResultCallbacks.clear();
          ((LuggageActivityHelper)localObject2).mInterceptResultCallbacks.clear();
          ((LuggageActivityHelper)localObject2).mPermissionResultCallbacks.clear();
        }
      }
    }
  }
  
  public boolean checkRequestPermission(String paramString, LuggageActivityHelper.PermissionResultCallback paramPermissionResultCallback)
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {
      return true;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {
      return false;
    }
    try
    {
      int i = ContextCompat.checkSelfPermission(localActivity, paramString);
      if (i == 0) {
        return true;
      }
      requestPermissions(new String[] { paramString }, paramPermissionResultCallback);
      return false;
    }
    catch (Exception paramString)
    {
      o.b("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", new Object[] { paramString });
    }
    return true;
  }
  
  protected void cleanUp()
  {
    remove(this.mActivity);
  }
  
  public void finish()
  {
    Activity localActivity = this.mActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()) && (!this.mActivity.isDestroyed()) && (checkActivityFinish())) {
      this.mActivity.finish();
    }
  }
  
  protected int genRandomCodeFor(SparseArray paramSparseArray)
  {
    int i;
    do
    {
      i = rand();
    } while (paramSparseArray.get(i) != null);
    return i;
  }
  
  public void interceptActivityFinish(LuggageActivityHelper.ActivityFinishInterceptCallback paramActivityFinishInterceptCallback)
  {
    this.mActivityFinishInterceptCallback = paramActivityFinishInterceptCallback;
  }
  
  public void interceptActivityResult(LuggageActivityHelper.ActivityResultInterceptCallback paramActivityResultInterceptCallback)
  {
    if (paramActivityResultInterceptCallback == null) {
      return;
    }
    this.mInterceptResultCallbacks.add(paramActivityResultInterceptCallback);
  }
  
  public void interceptActivityResultOnce(LuggageActivityHelper.ActivityResultInterceptCallback paramActivityResultInterceptCallback)
  {
    if (paramActivityResultInterceptCallback == null) {
      return;
    }
    interceptActivityResult(new LuggageActivityHelper.1(this, paramActivityResultInterceptCallback));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.mInterceptResultCallbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((LuggageActivityHelper.ActivityResultInterceptCallback)((Iterator)localObject).next()).onResult(paramInt1, paramInt2, paramIntent)) {
        return;
      }
    }
    localObject = (LuggageActivityHelper.Callback)this.mActivityResultCallbacks.get(paramInt1);
    this.mActivityResultCallbacks.delete(paramInt1);
    if (localObject != null) {
      ((LuggageActivityHelper.ActivityResultCallback)localObject).onResult(paramInt2, paramIntent);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LuggageActivityHelper.Callback localCallback = (LuggageActivityHelper.Callback)this.mPermissionResultCallbacks.get(paramInt);
    this.mPermissionResultCallbacks.delete(paramInt);
    if (localCallback != null) {
      ((LuggageActivityHelper.PermissionResultCallback)localCallback).onResult(paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void removeInterceptActivityResultCallback(LuggageActivityHelper.ActivityResultInterceptCallback paramActivityResultInterceptCallback)
  {
    if (paramActivityResultInterceptCallback == null) {
      return;
    }
    this.mInterceptResultCallbacks.remove(paramActivityResultInterceptCallback);
  }
  
  @TargetApi(23)
  public void requestPermissions(String[] paramArrayOfString, LuggageActivityHelper.PermissionResultCallback paramPermissionResultCallback)
  {
    if (this.mActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      int[] arrayOfInt = new int[paramArrayOfString.length];
      Arrays.fill(arrayOfInt, 0);
      paramPermissionResultCallback.onResult(paramArrayOfString, arrayOfInt);
      return;
    }
    int i = genRandomCodeFor(this.mPermissionResultCallbacks);
    this.mPermissionResultCallbacks.put(i, paramPermissionResultCallback);
    this.mActivity.requestPermissions(paramArrayOfString, i);
  }
  
  public void startActivityForResult(Intent paramIntent, LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    if (this.mActivity == null) {
      return;
    }
    int i = genRandomCodeFor(this.mActivityResultCallbacks);
    this.mActivityResultCallbacks.put(i, paramActivityResultCallback);
    this.mActivity.startActivityForResult(paramIntent, i);
  }
  
  public void startActivityForResultThrows(Intent paramIntent, LuggageActivityHelper.ActivityResultCallback paramActivityResultCallback)
  {
    startActivityForResult(paramIntent, paramActivityResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper
 * JD-Core Version:    0.7.0.1
 */