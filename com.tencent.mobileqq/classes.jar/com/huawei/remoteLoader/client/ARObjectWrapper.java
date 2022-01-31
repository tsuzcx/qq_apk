package com.huawei.remoteLoader.client;

import android.os.IBinder;
import com.huawei.arengine.remoteLoader.IObjectWrapper;
import com.huawei.arengine.remoteLoader.IObjectWrapper.Stub;
import com.huawei.hiar.annotations.UsedByReflection;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

@UsedByReflection("ARObjectWrapper.java")
public final class ARObjectWrapper<T>
  extends IObjectWrapper.Stub
{
  @UsedByReflection("ARObjectWrapper.java")
  private final T wrappedObject;
  
  private ARObjectWrapper(T paramT)
  {
    this.wrappedObject = paramT;
  }
  
  @UsedByReflection("ARObjectWrapper.java")
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper, Class<T> paramClass)
  {
    if (paramIObjectWrapper == null) {
      return null;
    }
    if ((paramIObjectWrapper instanceof ARObjectWrapper)) {
      return ((ARObjectWrapper)paramIObjectWrapper).wrappedObject;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    paramIObjectWrapper = null;
    Object localObject = paramIObjectWrapper;
    if (i < j)
    {
      localObject = arrayOfField[i];
      if (!((Field)localObject).isSynthetic()) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (paramIObjectWrapper != null)
      {
        localObject = null;
        if (localObject != null)
        {
          if (!((AccessibleObject)localObject).isAccessible())
          {
            ((AccessibleObject)localObject).setAccessible(true);
            try
            {
              paramIObjectWrapper = ((Field)localObject).get(localIBinder);
              if (paramIObjectWrapper == null) {
                return null;
              }
              if (!paramClass.isInstance(paramIObjectWrapper)) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.");
              }
            }
            catch (NullPointerException paramIObjectWrapper)
            {
              throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
              paramIObjectWrapper = paramClass.cast(paramIObjectWrapper);
              return paramIObjectWrapper;
            }
            catch (IllegalArgumentException paramIObjectWrapper)
            {
              throw new IllegalArgumentException("remoteBinder is the wrong class.", paramIObjectWrapper);
            }
            catch (IllegalAccessException paramIObjectWrapper)
            {
              throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
            }
          }
          throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
      }
      paramIObjectWrapper = (IObjectWrapper)localObject;
    }
  }
  
  public static <T> IObjectWrapper wrap(T paramT)
  {
    return new ARObjectWrapper(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.remoteLoader.client.ARObjectWrapper
 * JD-Core Version:    0.7.0.1
 */