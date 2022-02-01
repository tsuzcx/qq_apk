import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class blla
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
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      bmbx.d("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
      return PhotoCommonBaseData.getInstance();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blla
 * JD-Core Version:    0.7.0.1
 */