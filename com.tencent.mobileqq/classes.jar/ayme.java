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

public class ayme
  extends QIPCModule
{
  private static ayme jdField_a_of_type_Ayme;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private ayme(String paramString)
  {
    super(paramString);
  }
  
  public static ayme a()
  {
    try
    {
      if (jdField_a_of_type_Ayme == null) {
        jdField_a_of_type_Ayme = new ayme("ThemeIPCModule");
      }
      ayme localayme = jdField_a_of_type_Ayme;
      return localayme;
    }
    finally {}
  }
  
  public static void a(String paramString, asko<aymh> paramasko)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramasko.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramasko.postQuery(new aymh().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new aymg(paramString, paramasko));
  }
  
  public static void a(String paramString, aylo paramaylo)
  {
    Bundle localBundle = new Bundle();
    if (paramaylo != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramaylo.asBinder()));
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
      for (paramString = new aymf(this, aylp.asInterface(paramBundle));; paramString = null)
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
 * Qualified Name:     ayme
 * JD-Core Version:    0.7.0.1
 */