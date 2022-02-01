import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import mqq.app.AppRuntime;

public class awxo
  extends awxr
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return nvf.a(paramString1) + paramString1;
    }
    return nvf.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    awxs localawxs = new awxs();
    int i;
    if ("MiniAppLauncher".equals(paramString2))
    {
      i = 1;
      localawxs.jdField_a_of_type_Int = i;
      localawxs.jdField_a_of_type_Boolean = paramBoolean;
      localawxs.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (localawxs.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), a(paramString3, "") };; localawxs.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) })
    {
      if (localawxs.jdField_a_of_type_Int != 1) {
        break label135;
      }
      wad.a().dispatch("MiniAppManager", localawxs);
      return;
      i = 5;
      break;
    }
    label135:
    wad.a().dispatch(localawxs);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    String str = paramString1.substring("ak:".length());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      b(false, paramString1, paramString2, -1, str, paramObject);
      return;
    }
    nuz.b(str, localAppRuntime, new awxp(this, str, paramString1, paramString2, paramObject, System.currentTimeMillis()), true, 0, true);
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return false;
      str = paramBundle.getString("bid");
      paramBundle = paramBundle.getString("path");
    } while ((!nuz.c(str)) || (!nwj.a(paramBundle, str)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxo
 * JD-Core Version:    0.7.0.1
 */