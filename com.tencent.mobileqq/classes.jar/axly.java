import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class axly
  extends QIPCModule
{
  private static axly jdField_a_of_type_Axly;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private axly(String paramString)
  {
    super(paramString);
  }
  
  public static axly a()
  {
    try
    {
      if (jdField_a_of_type_Axly == null) {
        jdField_a_of_type_Axly = new axly("ThemeIPCModule");
      }
      axly localaxly = jdField_a_of_type_Axly;
      return localaxly;
    }
    finally {}
  }
  
  public static void a(String paramString, arok<axmb> paramarok)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramarok.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramarok.postQuery(new axmb().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new axma(paramString, paramarok));
  }
  
  public static void a(String paramString, axli paramaxli)
  {
    Bundle localBundle = new Bundle();
    if (paramaxli != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramaxli.asBinder()));
    }
    localBundle.putString("themeId", paramString);
    QIPCClientHelper.getInstance().callServer("ThemeIPCModule", jdField_a_of_type_JavaLangString, localBundle, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeIPCModule", 2, "onCall action = " + paramString);
    }
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    String str = paramBundle.getString("themeId");
    if (paramBundle.containsKey("binder")) {}
    for (paramBundle = ((BinderWarpper)paramBundle.getParcelable("binder")).a;; paramBundle = null)
    {
      if (jdField_a_of_type_JavaLangString.equals(paramString)) {
        if (paramBundle == null) {
          break label135;
        }
      }
      label135:
      for (paramString = new axlz(this, axlj.asInterface(paramBundle));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axly
 * JD-Core Version:    0.7.0.1
 */