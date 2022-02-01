package android.arch.lifecycle;

import android.support.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExternalLiveData<T>
  extends MutableLiveData<T>
{
  public static final int START_VERSION = -1;
  
  private Object callMethodPutIfAbsent(Object paramObject1, Object paramObject2)
  {
    Object localObject = getFieldObservers();
    Method localMethod = localObject.getClass().getDeclaredMethod("putIfAbsent", new Class[] { Object.class, Object.class });
    localMethod.setAccessible(true);
    return localMethod.invoke(localObject, new Object[] { paramObject1, paramObject2 });
  }
  
  private Object getFieldObservers()
  {
    Field localField = LiveData.class.getDeclaredField("mObservers");
    localField.setAccessible(true);
    return localField.get(this);
  }
  
  public int getVersion()
  {
    return super.getVersion();
  }
  
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    ExternalLiveData.ExternalLifecycleBoundObserver localExternalLifecycleBoundObserver;
    do
    {
      return;
      try
      {
        localExternalLifecycleBoundObserver = new ExternalLiveData.ExternalLifecycleBoundObserver(this, paramLifecycleOwner, paramObserver);
        paramObserver = (LiveData.LifecycleBoundObserver)callMethodPutIfAbsent(paramObserver, localExternalLifecycleBoundObserver);
        if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
          throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
      }
      catch (Exception paramLifecycleOwner)
      {
        paramLifecycleOwner.printStackTrace();
        return;
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localExternalLifecycleBoundObserver);
  }
  
  protected Lifecycle.State observerActiveLevel()
  {
    return Lifecycle.State.CREATED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.ExternalLiveData
 * JD-Core Version:    0.7.0.1
 */