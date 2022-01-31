import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import mqq.app.AppRuntime;

public class atzr
  extends atzu
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return ncb.a(paramString1) + paramString1;
    }
    return ncb.a(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    atzv localatzv = new atzv();
    int i;
    if ("MiniAppLauncher".equals(paramString2))
    {
      i = 1;
      localatzv.jdField_a_of_type_Int = i;
      localatzv.jdField_a_of_type_Boolean = paramBoolean;
      localatzv.jdField_a_of_type_JavaLangString = paramString2;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (localatzv.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), a(paramString3, "") };; localatzv.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) })
    {
      if (localatzv.jdField_a_of_type_Int != 1) {
        break label135;
      }
      uht.a().dispatch("MiniAppManager", localatzv);
      return;
      i = 5;
      break;
    }
    label135:
    uht.a().dispatch(localatzv);
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
    nbv.b(str, localAppRuntime, new atzs(this, str, paramString1, paramString2, paramObject, System.currentTimeMillis()), true, 0, true);
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
    } while ((!nbv.c(str)) || (!ndl.a(paramBundle, str)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atzr
 * JD-Core Version:    0.7.0.1
 */