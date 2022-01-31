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

public class bakc
  extends QIPCModule
{
  private static bakc jdField_a_of_type_Bakc;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private bakc(String paramString)
  {
    super(paramString);
  }
  
  public static bakc a()
  {
    try
    {
      if (jdField_a_of_type_Bakc == null) {
        jdField_a_of_type_Bakc = new bakc("ThemeIPCModule");
      }
      bakc localbakc = jdField_a_of_type_Bakc;
      return localbakc;
    }
    finally {}
  }
  
  public static void a(String paramString, aubp<bakf> paramaubp)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramaubp.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramaubp.postQuery(new bakf().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new bake(paramString, paramaubp));
  }
  
  public static void a(String paramString, bajm parambajm)
  {
    Bundle localBundle = new Bundle();
    if (parambajm != null) {
      localBundle.putParcelable("binder", new BinderWarpper(parambajm.asBinder()));
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
      for (paramString = new bakd(this, bajn.asInterface(paramBundle));; paramString = null)
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
 * Qualified Name:     bakc
 * JD-Core Version:    0.7.0.1
 */