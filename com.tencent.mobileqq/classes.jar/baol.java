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

public class baol
  extends QIPCModule
{
  private static baol jdField_a_of_type_Baol;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private baol(String paramString)
  {
    super(paramString);
  }
  
  public static baol a()
  {
    try
    {
      if (jdField_a_of_type_Baol == null) {
        jdField_a_of_type_Baol = new baol("ThemeIPCModule");
      }
      baol localbaol = jdField_a_of_type_Baol;
      return localbaol;
    }
    finally {}
  }
  
  public static void a(String paramString, aufy<baoo> paramaufy)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramaufy.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramaufy.postQuery(new baoo().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new baon(paramString, paramaufy));
  }
  
  public static void a(String paramString, banv parambanv)
  {
    Bundle localBundle = new Bundle();
    if (parambanv != null) {
      localBundle.putParcelable("binder", new BinderWarpper(parambanv.asBinder()));
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
      for (paramString = new baom(this, banw.asInterface(paramBundle));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baol
 * JD-Core Version:    0.7.0.1
 */