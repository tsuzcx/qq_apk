import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import mqq.app.AppRuntime;

public class asir
  extends asiu
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return mzh.a(paramString1) + paramString1;
    }
    return mzh.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    asiv localasiv = new asiv();
    int i;
    if ("MiniAppLauncher".equals(paramString2))
    {
      i = 1;
      localasiv.jdField_a_of_type_Int = i;
      localasiv.jdField_a_of_type_Boolean = paramBoolean;
      localasiv.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (localasiv.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), a(paramString3, "") };; localasiv.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) })
    {
      if (localasiv.jdField_a_of_type_Int != 1) {
        break label135;
      }
      stb.a().dispatch("MiniAppManager", localasiv);
      return;
      i = 5;
      break;
    }
    label135:
    stb.a().dispatch(localasiv);
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
    mzb.b(str, localAppRuntime, new asis(this, str, paramString1, paramString2, paramObject, System.currentTimeMillis()), true, 0, true);
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
    } while ((!mzb.c(str)) || (!nap.a(paramBundle, str)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     asir
 * JD-Core Version:    0.7.0.1
 */