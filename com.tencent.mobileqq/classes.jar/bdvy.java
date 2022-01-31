import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import mqq.app.AppRuntime;

public class bdvy
  extends bdvv
{
  static azmj jdField_a_of_type_Azmj = new bdvz();
  private static bdvy jdField_a_of_type_Bdvy;
  private static bdwa jdField_a_of_type_Bdwa = new bdwa();
  private static int b;
  
  public bdvy(bdvb parambdvb, AppRuntime paramAppRuntime, int paramInt)
  {
    super(parambdvb, paramAppRuntime, paramInt);
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("theme", 4).getString("theme_font_root_pre", null);
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().remove("theme_font_root_pre").commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().putString("theme_font_root_pre", paramString).commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    if (!TextHook.getInstance().isDefault())
    {
      QLog.d("ThemeFontAdapter", 1, "resetDefaultFont");
      TextHook.getInstance().switchDefault();
      TextHook.getInstance().update(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    b = 0;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label22;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label22:
      String str = paramString2 + "." + Process.myPid() + ".tmp";
      try
      {
        ETEngine.getInstanceForSpace();
        bool1 = ETEngine.native_ftf2ttf(paramString1, str);
        if (bool1)
        {
          paramString1 = new File(str);
          paramString2 = new File(paramString2);
          if (!paramString2.exists()) {
            bool1 = paramString1.renameTo(paramString2);
          }
          bool2 = bool1;
          if (bool1) {
            continue;
          }
          QLog.e("ThemeFontAdapter", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
          return bool1;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error, errMsg = " + paramString1.toString());
        return false;
      }
    }
    QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error");
    return bool1;
  }
  
  public static void b(int paramInt)
  {
    b((int)fx.a(paramInt), fx.b(paramInt));
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    QLog.d("ThemeFontAdapter", 1, "switchFont  fontId:" + paramInt1 + " fontType:" + paramInt2);
    if (b == paramInt1)
    {
      QLog.d("ThemeFontAdapter", 1, "switchFont already set fontId:" + paramInt1 + " fontType:" + paramInt2);
      return;
    }
    if (paramInt1 == 0)
    {
      a(true);
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ThemeFontAdapter.2(paramInt1, paramInt2));
  }
  
  public static void b(Context paramContext)
  {
    TextHook.setSupportProcess(true);
    paramContext.registerReceiver(jdField_a_of_type_Bdwa, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static void c(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_Bdwa);
  }
  
  public static void d()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Azmj);
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Bdvy != null) {
      jdField_a_of_type_Bdvy.c();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    bdvb localbdvb = new bdvb(localAppRuntime, paramInt1);
    jdField_a_of_type_Bdvy = new bdvy(localbdvb, localAppRuntime, paramInt2);
    localbdvb.a(jdField_a_of_type_Bdvy);
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (fw localfw = a(this.jdField_a_of_type_Bdvd.a(), this.jdField_a_of_type_Int);; localfw = gb.a().a(this.jdField_a_of_type_Bdvd.a(), this.jdField_a_of_type_Int))
    {
      QLog.e("ThemeFontAdapter", 2, "load   fontInfo:" + localfw);
      if (localfw != null) {
        b(localfw.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvy
 * JD-Core Version:    0.7.0.1
 */