import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class biqd
{
  private static bjoa<Boolean> a = new bjoa();
  private static bjoa<Boolean> b = new bjoa();
  private static bjoa<Boolean> c = new bjoa();
  
  public static bjoa<Boolean> a()
  {
    return a;
  }
  
  public static GetCategoryMaterialRsp a()
  {
    Object localObject = bbdj.a(new File(biif.a));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = (GetCategoryMaterialRsp)new Gson().fromJson((String)localObject, GetCategoryMaterialRsp.class);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new GetCategoryMaterialRsp();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = bizj.a().a("CameraModuleSvc.GetCameraConfig", "", 4);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext;
    }
    return "";
  }
  
  public static bjoa<Boolean> b()
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
        String str2 = nax.a(paramContext);
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
  
  public static bjoa<Boolean> c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqd
 * JD-Core Version:    0.7.0.1
 */