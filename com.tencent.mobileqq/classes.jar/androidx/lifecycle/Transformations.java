package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

public class Transformations
{
  @MainThread
  @NonNull
  public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> paramLiveData)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Transformations.3(localMediatorLiveData));
    return localMediatorLiveData;
  }
  
  @MainThread
  @NonNull
  public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> paramLiveData, @NonNull Function<X, Y> paramFunction)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Transformations.1(localMediatorLiveData, paramFunction));
    return localMediatorLiveData;
  }
  
  @MainThread
  @NonNull
  public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> paramLiveData, @NonNull Function<X, LiveData<Y>> paramFunction)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Transformations.2(paramFunction, localMediatorLiveData));
    return localMediatorLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.Transformations
 * JD-Core Version:    0.7.0.1
 */