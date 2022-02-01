package com.tencent.aelight.camera.ae.album.data;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AEPhotoCommonDataCreator
{
  public static PhotoCommonBaseData a()
  {
    try
    {
      Object localObject = PhotoCommonBaseData.class.getDeclaredConstructor(null);
      ((Constructor)localObject).setAccessible(true);
      localObject = (PhotoCommonBaseData)((Constructor)localObject).newInstance(null);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    AEQLog.d("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
    return PhotoCommonBaseData.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.data.AEPhotoCommonDataCreator
 * JD-Core Version:    0.7.0.1
 */