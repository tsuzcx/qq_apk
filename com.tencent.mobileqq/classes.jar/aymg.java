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

public class aymg
  extends QIPCModule
{
  private static aymg jdField_a_of_type_Aymg;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private aymg(String paramString)
  {
    super(paramString);
  }
  
  public static aymg a()
  {
    try
    {
      if (jdField_a_of_type_Aymg == null) {
        jdField_a_of_type_Aymg = new aymg("ThemeIPCModule");
      }
      aymg localaymg = jdField_a_of_type_Aymg;
      return localaymg;
    }
    finally {}
  }
  
  public static void a(String paramString, askq<aymj> paramaskq)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramaskq.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramaskq.postQuery(new aymj().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new aymi(paramString, paramaskq));
  }
  
  public static void a(String paramString, aylq paramaylq)
  {
    Bundle localBundle = new Bundle();
    if (paramaylq != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramaylq.asBinder()));
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
      for (paramString = new aymh(this, aylr.asInterface(paramBundle));; paramString = null)
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
 * Qualified Name:     aymg
 * JD-Core Version:    0.7.0.1
 */