import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class bdbh
  extends QIPCModule
{
  private static bdbh jdField_a_of_type_Bdbh;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private bdbh(String paramString)
  {
    super(paramString);
  }
  
  public static bdbh a()
  {
    try
    {
      if (jdField_a_of_type_Bdbh == null) {
        jdField_a_of_type_Bdbh = new bdbh("ThemeIPCModule");
      }
      bdbh localbdbh = jdField_a_of_type_Bdbh;
      return localbdbh;
    }
    finally {}
  }
  
  public static void a(String paramString, avtb<bdbk> paramavtb)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramavtb.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramavtb.postQuery(new bdbk().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new bdbj(paramString, paramavtb));
  }
  
  public static void a(String paramString, bdar parambdar)
  {
    Bundle localBundle = new Bundle();
    if (parambdar != null) {
      localBundle.putParcelable("binder", new BinderWarpper(parambdar.asBinder()));
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
      for (paramString = new bdbi(this, bdas.asInterface(localIBinder));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return RemoteProxy.onCall(this, paramString, paramBundle, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbh
 * JD-Core Version:    0.7.0.1
 */