import QC.GetConciseThemeReq;
import QC.GetConciseThemeRsp;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.AppInterface;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class bbyp
{
  public static int a;
  public static String a;
  public static List<String> a;
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
  private static int f;
  
  static
  {
    jdField_a_of_type_Int = -2368549;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaLangString = "2921";
    jdField_b_of_type_Int = -1;
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_JavaUtilList.size())
      {
        if (TextUtils.equals("2920", a(i))) {
          jdField_c_of_type_Int = i;
        }
      }
      else
      {
        f = 0;
        return;
      }
      i += 1;
    }
  }
  
  public static int a()
  {
    if (d != 0) {
      return d;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label63;
      }
      d = -1;
    }
    for (;;)
    {
      return d;
      label63:
      if ("2921".equals(localObject)) {
        d = -657670;
      } else if ("3064".equals(localObject)) {
        d = -7084;
      } else if ("3063".equals(localObject)) {
        d = -15542596;
      } else if ("3066".equals(localObject)) {
        d = -34918;
      } else if ("3065".equals(localObject)) {
        d = -10145065;
      } else if ("3067".equals(localObject)) {
        d = -39054;
      } else if ("3491".equals(localObject)) {
        d = -15120003;
      }
    }
  }
  
  public static int a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilList.size() == 0) {
      return -1;
    }
    if (jdField_a_of_type_JavaUtilList.contains(paramString)) {
      return jdField_a_of_type_JavaUtilList.indexOf(paramString);
    }
    jdField_a_of_type_JavaLangString = paramString;
    jdField_b_of_type_Int = jdField_a_of_type_JavaUtilList.size();
    return jdField_b_of_type_Int;
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
  
  public static String a(int paramInt)
  {
    if ((jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (String)jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (jdField_b_of_type_Int == paramInt) {
      return jdField_a_of_type_JavaLangString;
    }
    return "2921";
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-2147483648);
  }
  
  public static void a(int paramInt)
  {
    f = paramInt;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("simple_ui_mode_switch", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    new bgol("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetConciseThemeReq", "stReq", "stRsp").a("GetConciseTheme", new GetConciseThemeReq(bgol.a()), new GetConciseThemeRsp(), new bbyq(paramString, paramAppInterface, paramBoolean), false);
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
            paramImmersiveTitleBar2.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167070));
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
            paramSystemBarCompact.setStatusBarColor(2131167070);
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
      localObject = (bbyj)((QQAppInterface)localObject).getBusinessHandler(154);
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      int i = jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      ((bbyj)localObject).a(bool, i);
      ((bbyj)localObject).notifyUI(4, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramString });
      if (QLog.isColorLevel()) {
        QLog.i("SimpleUILogSimpleUIUtil", 1, String.format(Locale.getDefault(), "onGetSimpleUISwitchOnLogin [%b,%b]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static final void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("SimpleUILogSimpleUIUtil", 1, String.format("onGetSimpleUIPref type=%d bPref=%d uin=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (paramString.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
    {
      int i = paramInt1;
      if (!a(paramInt1)) {
        i = 0;
      }
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      ((SharedPreferences)localObject).edit().putInt("key_simple_ui_pref_828", i).apply();
      if (i != jdField_c_of_type_Int)
      {
        jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
        ((SharedPreferences)localObject).edit().putInt("key_simple_no_night_ui_828", i).apply();
      }
      if (paramInt2 == 1) {
        a(paramString);
      }
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
    if (((paramInt < 0) || (paramInt >= jdField_a_of_type_JavaUtilList.size())) && (paramInt != jdField_b_of_type_Int))
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
    if (e != 0) {
      return e;
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("QzoneIPCModule", "action_qzone_get_themeid", null);
    if ((localObject != null) && (((EIPCResult)localObject).data != null))
    {
      localObject = ((EIPCResult)localObject).data.getString("themeId");
      if (!"2971".equals(localObject)) {
        break label68;
      }
      e = Color.parseColor("#03081A");
    }
    for (;;)
    {
      return e;
      label68:
      if ("2921".equals(localObject)) {
        e = Color.parseColor("#03081A");
      } else if ("3064".equals(localObject)) {
        e = Color.parseColor("#03081A");
      } else if ("3063".equals(localObject)) {
        e = -1;
      } else if ("3066".equals(localObject)) {
        e = -1;
      } else if ("3065".equals(localObject)) {
        e = -1;
      } else if ("3067".equals(localObject)) {
        e = -1;
      } else if ("3491".equals(localObject)) {
        e = -1;
      }
    }
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilList.size())
    {
      if (TextUtils.equals(paramString, a(i))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      f = BaseApplicationImpl.getApplication().getSharedPreferences("key_simple_status_sp_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0).getInt("simple_ui_mode_switch", 0);
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
    if ("2920".equals(paramString)) {}
    while ((!"2971".equals(paramString)) && (!"2921".equals(paramString)) && (!"3064".equals(paramString)) && (!"3063".equals(paramString)) && (!"3066".equals(paramString)) && (!"3065".equals(paramString)) && (!"3067".equals(paramString)) && (!"3491".equals(paramString)) && (!jdField_a_of_type_JavaUtilList.contains(paramString))) {
      return false;
    }
    return true;
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
    k = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_828", -1);
    i = k;
    if (!a(k))
    {
      k = ((SharedPreferences)localObject).getInt("key_simple_ui_pref_new", 0);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_simple_ui_pref_new");
      ((SharedPreferences.Editor)localObject).commit();
      i = k;
      if (!a(k)) {
        i = j;
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
    }
  }
  
  private static void c()
  {
    if (f == 1) {}
  }
  
  public static final boolean c()
  {
    return (b()) && (!ThemeUtil.isNowThemeIsNightForQzone()) && (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzonesimpleui", true));
  }
  
  public static int d()
  {
    int i = 1;
    if (BaseApplicationImpl.sProcessId == 1) {}
    while ((i != 0) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -2147483648) && (a(jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())))
    {
      return jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      i = 0;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ThemeUtil.getUinThemePreferences((AppRuntime)localObject);
      int j = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_828", -1);
      i = j;
      if (!a(j))
      {
        j = ((SharedPreferences)localObject).getInt("key_simple_no_night_ui_new", 0);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("key_simple_no_night_ui_new");
        ((SharedPreferences.Editor)localObject).commit();
        if (a(j))
        {
          i = j;
          if (j != jdField_c_of_type_Int) {}
        }
        else
        {
          i = 0;
        }
      }
      jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(-2147483648, i);
      return i;
    }
    return 0;
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
      return f;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyp
 * JD-Core Version:    0.7.0.1
 */