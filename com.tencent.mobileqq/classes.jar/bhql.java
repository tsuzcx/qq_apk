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

public class bhql
  extends bhqi
{
  static bdfj jdField_a_of_type_Bdfj = new bhqm();
  private static bhqn jdField_a_of_type_Bhqn = new bhqn();
  private static int b;
  private static int c = 10;
  private static int d;
  
  public bhql(bhpm parambhpm, AppRuntime paramAppRuntime, int paramInt)
  {
    super(parambhpm, paramAppRuntime, paramInt);
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
    d = 0;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label22;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label22:
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        return true;
      }
      paramString2 = paramString2 + "." + Process.myPid() + ".tmp";
      try
      {
        ETEngine.getInstanceForSpace();
        bool1 = ETEngine.native_ftf2ttf(paramString1, paramString2);
        if (bool1)
        {
          paramString1 = new File(paramString2);
          bool2 = paramString1.renameTo(localFile);
          bool1 = bool2;
          if (bool2) {
            continue;
          }
          QLog.e("ThemeFontAdapter", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
          return bool2;
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
    b((int)gb.a(paramInt), gb.b(paramInt));
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
    paramContext.registerReceiver(jdField_a_of_type_Bhqn, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static void c(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_Bhqn);
  }
  
  public static void d()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Bdfj);
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    bhpm localbhpm = new bhpm(localAppRuntime, paramInt1);
    localbhpm.a(new bhql(localbhpm, localAppRuntime, paramInt2));
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (ga localga = a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int);; localga = gf.a().a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int))
    {
      QLog.e("ThemeFontAdapter", 2, "load   fontInfo:" + localga + " sCurrentTryNumber:" + d);
      if (localga != null)
      {
        int i = d;
        d = i + 1;
        if (i < c)
        {
          b(localga.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
          c();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhql
 * JD-Core Version:    0.7.0.1
 */