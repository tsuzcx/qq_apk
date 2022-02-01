import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;

public class boqg
{
  private static MutableLiveData<Boolean> a = new MutableLiveData();
  private static MutableLiveData<Boolean> b = new MutableLiveData();
  private static MutableLiveData<Boolean> c = new MutableLiveData();
  
  public static MutableLiveData<Boolean> a()
  {
    return a;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = bozz.a().a("CameraModuleSvc.GetCameraConfig", "", 4);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    return "";
  }
  
  public static MutableLiveData<Boolean> b()
  {
    return b;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open("camera_story_default_template.json");
        localObject1 = paramContext;
        localObject2 = paramContext;
        String str2 = noe.a(paramContext);
        localObject1 = str2;
        localObject2 = localObject1;
      }
      catch (Throwable paramContext)
      {
        localObject2 = localObject1;
        paramContext.printStackTrace();
        localObject2 = str1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          return "";
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label88;
        }
      }
      try
      {
        paramContext.close();
        localObject2 = localObject1;
        return localObject2;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return localObject1;
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      label88:
      throw paramContext;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public static MutableLiveData<Boolean> c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqg
 * JD-Core Version:    0.7.0.1
 */