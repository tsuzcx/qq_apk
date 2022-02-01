package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle
{
  private static final Class[] ACCEPTABLE_CLASSES;
  private static final String KEYS = "keys";
  private static final String VALUES = "values";
  private final Map<String, SavedStateHandle.SavingStateLiveData<?>> mLiveDatas = new HashMap();
  final Map<String, Object> mRegular;
  private final SavedStateRegistry.SavedStateProvider mSavedStateProvider = new SavedStateHandle.1(this);
  final Map<String, SavedStateRegistry.SavedStateProvider> mSavedStateProviders = new HashMap();
  
  static
  {
    Class localClass1 = Boolean.TYPE;
    Class localClass2 = Double.TYPE;
    Class localClass3 = Integer.TYPE;
    Class localClass4 = Long.TYPE;
    Class localClass5 = Byte.TYPE;
    Class localClass6 = Character.TYPE;
    Class localClass7 = Float.TYPE;
    Class localClass8 = Short.TYPE;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject1 = Size.class;
    } else {
      localObject1 = Integer.TYPE;
    }
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject2 = SizeF.class;
    } else {
      localObject2 = Integer.TYPE;
    }
    ACCEPTABLE_CLASSES = new Class[] { localClass1, [Z.class, localClass2, [D.class, localClass3, [I.class, localClass4, [J.class, String.class, [Ljava.lang.String.class, Binder.class, Bundle.class, localClass5, [B.class, localClass6, [C.class, CharSequence.class, [Ljava.lang.CharSequence.class, ArrayList.class, localClass7, [F.class, Parcelable.class, [Landroid.os.Parcelable.class, Serializable.class, localClass8, [S.class, SparseArray.class, localObject1, localObject2 };
  }
  
  public SavedStateHandle()
  {
    this.mRegular = new HashMap();
  }
  
  public SavedStateHandle(@NonNull Map<String, Object> paramMap)
  {
    this.mRegular = new HashMap(paramMap);
  }
  
  static SavedStateHandle createHandle(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return new SavedStateHandle();
    }
    HashMap localHashMap = new HashMap();
    if (paramBundle2 != null)
    {
      Iterator localIterator = paramBundle2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle2.get(str));
      }
    }
    if (paramBundle1 == null) {
      return new SavedStateHandle(localHashMap);
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    if ((paramBundle2 != null) && (paramBundle1 != null) && (paramBundle2.size() == paramBundle1.size()))
    {
      int i = 0;
      while (i < paramBundle2.size())
      {
        localHashMap.put((String)paramBundle2.get(i), paramBundle1.get(i));
        i += 1;
      }
      return new SavedStateHandle(localHashMap);
    }
    paramBundle1 = new IllegalStateException("Invalid bundle passed as restored state");
    for (;;)
    {
      throw paramBundle1;
    }
  }
  
  @NonNull
  private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String paramString, boolean paramBoolean, @Nullable T paramT)
  {
    MutableLiveData localMutableLiveData = (MutableLiveData)this.mLiveDatas.get(paramString);
    if (localMutableLiveData != null) {
      return localMutableLiveData;
    }
    if (this.mRegular.containsKey(paramString)) {
      paramT = new SavedStateHandle.SavingStateLiveData(this, paramString, this.mRegular.get(paramString));
    } else if (paramBoolean) {
      paramT = new SavedStateHandle.SavingStateLiveData(this, paramString, paramT);
    } else {
      paramT = new SavedStateHandle.SavingStateLiveData(this, paramString);
    }
    this.mLiveDatas.put(paramString, paramT);
    return paramT;
  }
  
  private static void validateValue(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = ACCEPTABLE_CLASSES;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].isInstance(paramObject)) {
        return;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't put value with type ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    ((StringBuilder)localObject).append(" into saved state");
    paramObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  @MainThread
  public void clearSavedStateProvider(@NonNull String paramString)
  {
    this.mSavedStateProviders.remove(paramString);
  }
  
  @MainThread
  public boolean contains(@NonNull String paramString)
  {
    return this.mRegular.containsKey(paramString);
  }
  
  @MainThread
  @Nullable
  public <T> T get(@NonNull String paramString)
  {
    return this.mRegular.get(paramString);
  }
  
  @MainThread
  @NonNull
  public <T> MutableLiveData<T> getLiveData(@NonNull String paramString)
  {
    return getLiveDataInternal(paramString, false, null);
  }
  
  @MainThread
  @NonNull
  public <T> MutableLiveData<T> getLiveData(@NonNull String paramString, @SuppressLint({"UnknownNullness"}) T paramT)
  {
    return getLiveDataInternal(paramString, true, paramT);
  }
  
  @MainThread
  @NonNull
  public Set<String> keys()
  {
    return Collections.unmodifiableSet(this.mRegular.keySet());
  }
  
  @MainThread
  @Nullable
  public <T> T remove(@NonNull String paramString)
  {
    Object localObject = this.mRegular.remove(paramString);
    paramString = (SavedStateHandle.SavingStateLiveData)this.mLiveDatas.remove(paramString);
    if (paramString != null) {
      paramString.detach();
    }
    return localObject;
  }
  
  @NonNull
  SavedStateRegistry.SavedStateProvider savedStateProvider()
  {
    return this.mSavedStateProvider;
  }
  
  @MainThread
  public <T> void set(@NonNull String paramString, @Nullable T paramT)
  {
    validateValue(paramT);
    MutableLiveData localMutableLiveData = (MutableLiveData)this.mLiveDatas.get(paramString);
    if (localMutableLiveData != null)
    {
      localMutableLiveData.setValue(paramT);
      return;
    }
    this.mRegular.put(paramString, paramT);
  }
  
  @MainThread
  public void setSavedStateProvider(@NonNull String paramString, @NonNull SavedStateRegistry.SavedStateProvider paramSavedStateProvider)
  {
    this.mSavedStateProviders.put(paramString, paramSavedStateProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandle
 * JD-Core Version:    0.7.0.1
 */