import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class bdpp
  extends QIPCModule
{
  private static bdpp jdField_a_of_type_Bdpp;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private bdpp(String paramString)
  {
    super(paramString);
  }
  
  public static bdpp a()
  {
    try
    {
      if (jdField_a_of_type_Bdpp == null) {
        jdField_a_of_type_Bdpp = new bdpp("ThemeIPCModule");
      }
      bdpp localbdpp = jdField_a_of_type_Bdpp;
      return localbdpp;
    }
    finally {}
  }
  
  public static void a(String paramString, awnc<bdps> paramawnc)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramawnc.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramawnc.postQuery(new bdps().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new bdpr(paramString, paramawnc));
  }
  
  public static void a(String paramString, bdoz parambdoz)
  {
    Bundle localBundle = new Bundle();
    if (parambdoz != null) {
      localBundle.putParcelable("binder", new BinderWarpper(parambdoz.asBinder()));
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
    for (IBinder localIBinder = ((BinderWarpper)paramBundle.getParcelable("binder")).a;; localIBinder = null)
    {
      if (jdField_a_of_type_JavaLangString.equals(paramString)) {
        if (localIBinder == null) {
          break label144;
        }
      }
      label144:
      for (paramString = new bdpq(this, bdpa.asInterface(localIBinder));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return bhcy.a(this, paramString, paramBundle, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpp
 * JD-Core Version:    0.7.0.1
 */