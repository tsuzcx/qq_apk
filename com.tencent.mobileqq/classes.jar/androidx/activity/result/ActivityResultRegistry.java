package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry
{
  private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
  private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
  private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
  private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
  private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
  private static final String LOG_TAG = "ActivityResultRegistry";
  private final transient Map<String, ActivityResultRegistry.CallbackAndContract<?>> mKeyToCallback = new HashMap();
  private final Map<String, ActivityResultRegistry.LifecycleContainer> mKeyToLifecycleContainers = new HashMap();
  private final Map<String, Integer> mKeyToRc = new HashMap();
  private final Bundle mPendingResults = new Bundle();
  private Random mRandom = new Random();
  private final Map<Integer, String> mRcToKey = new HashMap();
  
  private void bindRcKey(int paramInt, String paramString)
  {
    this.mRcToKey.put(Integer.valueOf(paramInt), paramString);
    this.mKeyToRc.put(paramString, Integer.valueOf(paramInt));
  }
  
  private <O> void doDispatch(String paramString, int paramInt, @Nullable Intent paramIntent, @Nullable ActivityResultRegistry.CallbackAndContract<O> paramCallbackAndContract)
  {
    if ((paramCallbackAndContract != null) && (paramCallbackAndContract.mCallback != null))
    {
      paramCallbackAndContract.mCallback.onActivityResult(paramCallbackAndContract.mContract.parseResult(paramInt, paramIntent));
      return;
    }
    this.mPendingResults.putParcelable(paramString, new ActivityResult(paramInt, paramIntent));
  }
  
  private int generateRandomNumber()
  {
    for (int i = this.mRandom.nextInt(2147418112);; i = this.mRandom.nextInt(2147418112))
    {
      i += 65536;
      if (!this.mRcToKey.containsKey(Integer.valueOf(i))) {
        break;
      }
    }
    return i;
  }
  
  private int registerKey(String paramString)
  {
    Integer localInteger = (Integer)this.mKeyToRc.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = generateRandomNumber();
    bindRcKey(i, paramString);
    return i;
  }
  
  @MainThread
  public final boolean dispatchResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    String str = (String)this.mRcToKey.get(Integer.valueOf(paramInt1));
    if (str == null) {
      return false;
    }
    doDispatch(str, paramInt2, paramIntent, (ActivityResultRegistry.CallbackAndContract)this.mKeyToCallback.get(str));
    return true;
  }
  
  @MainThread
  public final <O> boolean dispatchResult(int paramInt, @SuppressLint({"UnknownNullness"}) O paramO)
  {
    Object localObject = (String)this.mRcToKey.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return false;
    }
    localObject = (ActivityResultRegistry.CallbackAndContract)this.mKeyToCallback.get(localObject);
    if (localObject != null)
    {
      if (((ActivityResultRegistry.CallbackAndContract)localObject).mCallback == null) {
        return false;
      }
      ((ActivityResultRegistry.CallbackAndContract)localObject).mCallback.onActivityResult(paramO);
      return true;
    }
    return false;
  }
  
  @MainThread
  public abstract <I, O> void onLaunch(int paramInt, @NonNull ActivityResultContract<I, O> paramActivityResultContract, @SuppressLint({"UnknownNullness"}) I paramI, @Nullable ActivityOptionsCompat paramActivityOptionsCompat);
  
  public final void onRestoreInstanceState(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ArrayList localArrayList1 = paramBundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
    if (localArrayList2 != null)
    {
      if (localArrayList1 == null) {
        return;
      }
      int j = localArrayList2.size();
      int i = 0;
      while (i < j)
      {
        bindRcKey(((Integer)localArrayList1.get(i)).intValue(), (String)localArrayList2.get(i));
        i += 1;
      }
      this.mRandom = ((Random)paramBundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT"));
      this.mPendingResults.putAll(paramBundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
    }
  }
  
  public final void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    paramBundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.mRcToKey.keySet()));
    paramBundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.mRcToKey.values()));
    paramBundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", this.mPendingResults);
    paramBundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.mRandom);
  }
  
  @NonNull
  public final <I, O> ActivityResultLauncher<I> register(@NonNull String paramString, @NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultCallback<O> paramActivityResultCallback)
  {
    int i = registerKey(paramString);
    this.mKeyToCallback.put(paramString, new ActivityResultRegistry.CallbackAndContract(paramActivityResultCallback, paramActivityResultContract));
    ActivityResult localActivityResult = (ActivityResult)this.mPendingResults.getParcelable(paramString);
    if (localActivityResult != null)
    {
      this.mPendingResults.remove(paramString);
      paramActivityResultCallback.onActivityResult(paramActivityResultContract.parseResult(localActivityResult.getResultCode(), localActivityResult.getData()));
    }
    return new ActivityResultRegistry.4(this, i, paramActivityResultContract, paramString);
  }
  
  @NonNull
  public final <I, O> ActivityResultLauncher<I> register(@NonNull String paramString, @NonNull LifecycleOwner paramLifecycleOwner, @NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultCallback<O> paramActivityResultCallback)
  {
    Lifecycle localLifecycle = paramLifecycleOwner.getLifecycle();
    if (!localLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED))
    {
      int i = registerKey(paramString);
      this.mKeyToCallback.put(paramString, new ActivityResultRegistry.CallbackAndContract(paramActivityResultCallback, paramActivityResultContract));
      ActivityResult localActivityResult = (ActivityResult)this.mPendingResults.getParcelable(paramString);
      ActivityResultRegistry.LifecycleContainer localLifecycleContainer = (ActivityResultRegistry.LifecycleContainer)this.mKeyToLifecycleContainers.get(paramString);
      paramLifecycleOwner = localLifecycleContainer;
      if (localLifecycleContainer == null) {
        paramLifecycleOwner = new ActivityResultRegistry.LifecycleContainer(localLifecycle);
      }
      if (localActivityResult != null)
      {
        this.mPendingResults.remove(paramString);
        paramLifecycleOwner.addObserver(new ActivityResultRegistry.1(this, paramActivityResultCallback, paramActivityResultContract, localActivityResult));
        this.mKeyToLifecycleContainers.put(paramString, paramLifecycleOwner);
      }
      paramLifecycleOwner.addObserver(new ActivityResultRegistry.2(this, paramString));
      return new ActivityResultRegistry.3(this, i, paramActivityResultContract, paramString);
    }
    paramString = new StringBuilder();
    paramString.append("LifecycleOwner ");
    paramString.append(paramLifecycleOwner);
    paramString.append(" is attempting to register while current state is ");
    paramString.append(localLifecycle.getCurrentState());
    paramString.append(". LifecycleOwners must call register before they are STARTED.");
    throw new IllegalStateException(paramString.toString());
  }
  
  @MainThread
  final void unregister(@NonNull String paramString)
  {
    Object localObject = (Integer)this.mKeyToRc.remove(paramString);
    if (localObject != null) {
      this.mRcToKey.remove(localObject);
    }
    this.mKeyToCallback.remove(paramString);
    if (this.mPendingResults.containsKey(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Dropping pending result for request ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(this.mPendingResults.getParcelable(paramString));
      Log.w("ActivityResultRegistry", ((StringBuilder)localObject).toString());
      this.mPendingResults.remove(paramString);
    }
    localObject = (ActivityResultRegistry.LifecycleContainer)this.mKeyToLifecycleContainers.get(paramString);
    if (localObject != null)
    {
      ((ActivityResultRegistry.LifecycleContainer)localObject).clearObservers();
      this.mKeyToLifecycleContainers.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry
 * JD-Core Version:    0.7.0.1
 */