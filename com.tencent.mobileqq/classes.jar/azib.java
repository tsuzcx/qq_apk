import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class azib
{
  public static int a;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private static boolean jdField_b_of_type_Boolean;
  public static int c;
  private static AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-2147483648);
  private static boolean jdField_c_of_type_Boolean;
  public static int d;
  public static int e;
  public static final int f;
  private static int g;
  
  static
  {
    jdField_a_of_type_Int = -2368549;
    int i = 0;
    for (;;)
    {
      if (i < azhw.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        if (TextUtils.equals("2920", azhw.jdField_b_of_type_ArrayOfJavaLangString[i])) {
          jdField_b_of_type_Int = i;
        }
      }
      else
      {
        g = 0;
        e = aekt.a(22.0F, BaseApplicationImpl.getApplication().getApplicationContext().getResources());
        f = aekt.a(40.0F, BaseApplicationImpl.getApplication().getApplicationContext().getResources());
        return;
      }
      i += 1;
    }
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int != 0) {
      return jdField_c_of_type_Int;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label63;
      }
      jdField_c_of_type_Int = -1;
    }
    for (;;)
    {
      return jdField_c_of_type_Int;
      label63:
      if ("2921".equals(localObject)) {
        jdField_c_of_type_Int = -657670;
      } else if ("3064".equals(localObject)) {
        jdField_c_of_type_Int = -7084;
      } else if ("3063".equals(localObject)) {
        jdField_c_of_type_Int = -15542596;
      } else if ("3066".equals(localObject)) {
        jdField_c_of_type_Int = -34918;
      } else if ("3065".equals(localObject)) {
        jdField_c_of_type_Int = -10145065;
      } else if ("3067".equals(localObject)) {
        jdField_c_of_type_Int = -39054;
      } else if ("3491".equals(localObject)) {
        jdField_c_of_type_Int = -15120003;
      }
    }
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    while (i < azhw.jdField_b_of_type_ArrayOfJavaLangString.length)
    {
      if (TextUtils.equals(paramString, azhw.jdField_b_of_type_ArrayOfJavaLangString[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static SystemBarCompact a(SystemBarCompact paramSystemBarCompact, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    boolean bool = true;
    if (paramActivity == null) {
      return null;
    }
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return null;
    }
    if (!c()) {
      return null;
    }
    int k = a();
    if (ImmersiveUtils.c())
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.jdField_b_of_type_Int);
      ImmersiveUtils.a(paramActivity.getWindow(), true);
      if (paramSystemBarCompact == null) {
        if (!paramBoolean1)
        {
          paramBoolean1 = bool;
          paramSystemBarCompact = new SystemBarCompact(paramActivity, paramBoolean1, k);
          paramSystemBarCompact.init();
        }
      }
      for (;;)
      {
        ImmersiveUtils.a(paramBoolean2, paramActivity.getWindow());
        return paramSystemBarCompact;
        paramBoolean1 = false;
        break;
        paramSystemBarCompact.setStatusBarColor(k);
      }
    }
    if (paramSystemBarCompact == null)
    {
      paramActivity.getWindow().addFlags(ImmersiveUtils.jdField_b_of_type_Int);
      ImmersiveUtils.a(paramActivity.getWindow(), true);
      if (paramBoolean2) {
        i = jdField_a_of_type_Int;
      }
      paramSystemBarCompact = new SystemBarCompact(paramActivity, true, i);
      paramSystemBarCompact.init();
      return paramSystemBarCompact;
    }
    i = j;
    if (paramBoolean2) {
      i = jdField_a_of_type_Int;
    }
    paramSystemBarCompact.setStatusBarColor(i);
    return paramSystemBarCompact;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
  }
  
  public static void a(int paramInt)
  {
    g = paramInt;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("simple_ui_mode_switch", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static void a(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow)
  {
    boolean bool1 = false;
    boolean bool2;
    if (b())
    {
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!jdField_b_of_type_Boolean)) {
        if (b(ThemeUtil.getCurrentThemeId())) {
          if (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(ThemeUtil.getCurrentThemeId()))
          {
            ImmersiveUtils.a(false, paramWindow);
            jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
    do
    {
      return;
      ImmersiveUtils.a(true, paramWindow);
      break;
      if (!bool2) {
        bool1 = true;
      }
      ImmersiveUtils.a(bool1, paramWindow);
      break;
      if ((ImmersiveUtils.isSupporImmersive() == 0) || (paramImmersiveTitleBar2 == null) || (bool2)) {
        break;
      }
      paramImmersiveTitleBar2.setBackgroundColor(jdField_a_of_type_Int);
      break;
      if (true == jdField_a_of_type_Boolean)
      {
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!jdField_b_of_type_Boolean)) {
          ImmersiveUtils.a(false, paramWindow);
        }
        for (;;)
        {
          jdField_a_of_type_Boolean = false;
          return;
          if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramImmersiveTitleBar2 != null)) {
            paramImmersiveTitleBar2.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131166957));
          }
        }
      }
    } while (paramImmersiveTitleBar2 == null);
    ThemeUtil.adjustThemeStatusBar(paramWindow);
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow)
  {
    a(paramSystemBarCompact, paramWindow, null);
  }
  
  public static void a(SystemBarCompact paramSystemBarCompact, Window paramWindow, Boolean paramBoolean)
  {
    boolean bool;
    if (b())
    {
      bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!jdField_b_of_type_Boolean)) {
        if (paramBoolean == null) {
          if (!bool)
          {
            bool = true;
            if (!b(ThemeUtil.getCurrentThemeId())) {
              break label97;
            }
            if (ThemeUtil.isSimpleColrThemeStateBarUseWhite(ThemeUtil.getCurrentThemeId())) {
              break label88;
            }
            ImmersiveUtils.a(false, paramWindow);
            label70:
            jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
    label88:
    label97:
    do
    {
      return;
      bool = false;
      break;
      bool = paramBoolean.booleanValue();
      break;
      ImmersiveUtils.a(true, paramWindow);
      break label70;
      ImmersiveUtils.a(bool, paramWindow);
      break label70;
      if ((ImmersiveUtils.isSupporImmersive() == 0) || (paramSystemBarCompact == null) || (bool)) {
        break label70;
      }
      paramSystemBarCompact.setStatusBarColor(jdField_a_of_type_Int);
      break label70;
      if (true == jdField_a_of_type_Boolean)
      {
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!jdField_b_of_type_Boolean)) {
          if (paramBoolean == null)
          {
            bool = false;
            ImmersiveUtils.a(bool, paramWindow);
          }
        }
        for (;;)
        {
          jdField_a_of_type_Boolean = false;
          return;
          bool = paramBoolean.booleanValue();
          break;
          if ((ImmersiveUtils.isSupporImmersive() != 0) && (paramSystemBarCompact != null)) {
            paramSystemBarCompact.setStatusBarColor(2131166957);
          }
        }
      }
    } while (paramSystemBarCompact == null);
    ThemeUtil.adjustThemeStatusBar(paramWindow);
  }
  
  private static final void a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (a(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())))
    {
      localObject = (azhx)((QQAppInterface)localObject).a(154);
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      int i = jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      ((azhx)localObject).a(bool, i);
      ((azhx)localObject).notifyUI(4, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUILogSimpleUIUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt1 = azhw.a[paramInt1];
    QLog.d("SimpleUILogSimpleUIUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (paramString.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      if (a(paramInt1)) {
        break label160;
      }
      paramInt1 = i;
    }
    label160:
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      ((SharedPreferences)localObject).edit().putInt("key_simple_ui_pref_828", paramInt1).apply();
      if (paramInt1 != jdField_b_of_type_Int)
      {
        jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
        ((SharedPreferences)localObject).edit().putInt("key_simple_no_night_ui_828", paramInt1).apply();
      }
      if (paramInt2 == 1) {
        a(paramString);
      }
      return;
    }
  }
  
  public static final void a(String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    QLog.d("SimpleUILogSimpleUIUtil", 1, String.format("onGetSimpleUISwitch type=%d bSwitch=%b uin=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramString }));
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (paramString.equals(localQQAppInterface.getCurrentAccountUin())))
    {
      AtomicInteger localAtomicInteger = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (paramBoolean) {
        i = 1;
      }
      localAtomicInteger.set(i);
      ThemeUtil.getUinThemePreferences(localQQAppInterface).edit().putBoolean("key_simple_ui_switch", paramBoolean).commit();
      if (paramInt == 1) {
        a(paramString);
      }
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, Window paramWindow)
  {
    if (b())
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!bool))
      {
        if (!paramBoolean) {
          break label45;
        }
        ImmersiveUtils.a(false, paramWindow);
      }
    }
    return;
    label45:
    ImmersiveUtils.a(true, paramWindow);
  }
  
  public static final boolean a()
  {
    return a(ThemeUtil.getCurrentThemeId());
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= azhw.jdField_b_of_type_ArrayOfJavaLangString.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUILogSimpleUIUtil", 2, "isValidSimplePref error bPref=" + paramInt);
      }
      return false;
    }
    return true;
  }
  
  public static final boolean a(String paramString)
  {
    return ("2920".equals(paramString)) || (b(paramString));
  }
  
  public static int b()
  {
    if (d != 0) {
      return d;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label68;
      }
      d = Color.parseColor("#03081A");
    }
    for (;;)
    {
      return d;
      label68:
      if ("2921".equals(localObject)) {
        d = Color.parseColor("#03081A");
      } else if ("3064".equals(localObject)) {
        d = Color.parseColor("#03081A");
      } else if ("3063".equals(localObject)) {
        d = -1;
      } else if ("3066".equals(localObject)) {
        d = -1;
      } else if ("3065".equals(localObject)) {
        d = -1;
      } else if ("3067".equals(localObject)) {
        d = -1;
      } else if ("3491".equals(localObject)) {
        d = -1;
      }
    }
  }
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      g = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("simple_ui_mode_switch", 0);
    }
  }
  
  public static final boolean b()
  {
    int j = 1;
    boolean bool = false;
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 1;
    }
    while ((i != 0) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648)) {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      bool = ThemeUtil.getUinThemePreferences((AppRuntime)localObject).getBoolean("key_simple_ui_switch", false);
      localObject = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
      if (!bool) {
        break label92;
      }
    }
    label92:
    for (int i = j;; i = 0)
    {
      ((AtomicInteger)localObject).compareAndSet(-2147483648, i);
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    return ("2971".equals(paramString)) || ("2921".equals(paramString)) || ("3064".equals(paramString)) || ("3063".equals(paramString)) || ("3066".equals(paramString)) || ("3065".equals(paramString)) || ("3067".equals(paramString)) || ("3491".equals(paramString));
  }
  
  public static final int c()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if ((i == 0) || (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -2147483648) || (!a(jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) {
        break label54;
      }
      i = jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    label54:
    do
    {
      return i;
      i = 0;
      break;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      i = k;
    } while (localObject == null);
    Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
    i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
    if (!a(i))
    {
      i = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
      ((SharedPreferences.Editor)localObject).commit();
      if (!a(i)) {
        i = j;
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
      i = azhw.jdField_b_of_type_ArrayOfInt[i];
    }
  }
  
  private static void c()
  {
    if (g == 1) {}
  }
  
  public static final boolean c()
  {
    return (b()) && (!ThemeUtil.isNowThemeIsNightForQzone()) && (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonesimpleui", true));
  }
  
  public static int d()
  {
    int i = 1;
    int j = 0;
    int k = 0;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if ((i == 0) || (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -2147483648) || (!a(jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))) {
        break label54;
      }
      i = jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    label54:
    do
    {
      return i;
      i = 0;
      break;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      i = k;
    } while (localObject == null);
    Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
    i = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
    if (!a(i))
    {
      k = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
      ((SharedPreferences.Editor)localObject).commit();
      i = j;
      if (a(k))
      {
        if (k != jdField_b_of_type_Int) {
          break label155;
        }
        i = j;
      }
    }
    for (;;)
    {
      jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
      label155:
      i = azhw.jdField_b_of_type_ArrayOfInt[k];
    }
  }
  
  public static boolean d()
  {
    return Color.parseColor("#03081A") == b();
  }
  
  public static int e()
  {
    if (!jdField_c_of_type_Boolean)
    {
      b();
      c();
      jdField_c_of_type_Boolean = true;
    }
    if (b()) {
      return g;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azib
 * JD-Core Version:    0.7.0.1
 */