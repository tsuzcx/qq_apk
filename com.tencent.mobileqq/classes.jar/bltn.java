import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVipInfoManager.3;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

public class bltn
{
  private static bltn jdField_a_of_type_Bltn;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int = -1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private String b;
  
  private bltn()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("QZONE_VIP_INFO", i);
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(new blto(this));
      }
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    return a(paramInt, 0, 1);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3 - paramInt2 + 1)
    {
    default: 
      paramInt3 = 0;
    }
    while (paramInt3 == 0)
    {
      return 0;
      paramInt3 = 1;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
      continue;
      paramInt3 = 15;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1 << paramInt4 + 1 & paramInt1 | paramInt2 << paramInt3 | (1 << paramInt3) - 1 & paramInt1;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 6, 6);
    }
  }
  
  public static bltn a()
  {
    if (jdField_a_of_type_Bltn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bltn == null) {
        jdField_a_of_type_Bltn = new bltn();
      }
      return jdField_a_of_type_Bltn;
    }
  }
  
  private String a(String paramString)
  {
    return "key_vip_info_bitmap_pre" + paramString;
  }
  
  private void a()
  {
    a(false);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, "cm", 2, 1);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Intent localIntent = new Intent();
    String str = paramActivity.getResources().getString(2131716822);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString2);
    localIntent.putExtra("source", paramString3);
    localIntent.putExtra("viptype", paramInt1);
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("month", paramInt2);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1, null, false, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnSubThread(new QZoneVipInfoManager.3(paramQQAppInterface));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int >= 0) && (!paramBoolean)) {}
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentSharedPreferences == null);
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(a(localAppRuntime.getAccount()), 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(b(localAppRuntime.getAccount()), null);
    this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(c(localAppRuntime.getAccount()), null);
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, 6, 6) != 0;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, String paramString)
  {
    int i = 1;
    QLog.d("QZoneVipInfoManager", 1, new Object[] { "onPetBrandClick petId = ", Integer.valueOf(paramInt) });
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str3;
    String str1;
    label69:
    String str2;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      str3 = "0";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateHostUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aiozhu");
      i = 0;
      if (TextUtils.isEmpty(str1)) {
        break label242;
      }
      str2 = str1;
      if (str1.contains("{pet_id}")) {
        str2 = str1.replace("{pet_id}", String.valueOf(paramInt));
      }
      if (!str2.contains("{uin}")) {
        break label244;
      }
    }
    label242:
    label244:
    for (paramString = str2.replace("{uin}", paramString);; paramString = str2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVipInfoManager", 2, "onPetBrandClick petId = " + paramInt + " from = " + i + " reserve = " + str3 + " jumpUrl = " + paramString);
      }
      bcst.b(null, "dc00898", "", "", "", "", i, 0, str3, "", "", "");
      return a(paramActivity, paramString);
      str3 = "1";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPetNameplateGuestUrl", "https://cmshow.qq.com/apollo/html/pet/pet_hall.html?_wv=16777218&_cwv=9&_wwv=1&thunder_id=8&_bid=3094&pet={pet_id}&open=1&adtag=aioke");
      break label69;
      break;
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("QZoneVipInfoManager", 1, "jumpToH5 activity = null or url = null , url = " + paramString);
      return false;
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
    paramActivity.startActivity(localIntent);
    return true;
  }
  
  public static int b(int paramInt)
  {
    return a(paramInt, 2, 5);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 13, 13);
    }
  }
  
  private String b(String paramString)
  {
    return "key_vip_info_personalized_vip_pre" + paramString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      if (localEditor != null)
      {
        this.jdField_a_of_type_Boolean = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (localAppRuntime != null)
        {
          localEditor.putInt(a(localAppRuntime.getAccount()), this.jdField_a_of_type_Int);
          localEditor.putString(b(localAppRuntime.getAccount()), this.jdField_a_of_type_JavaLangString);
          localEditor.putString(c(localAppRuntime.getAccount()), this.b);
          localEditor.commit();
        }
      }
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    String str = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowPreviewPayUrl", "https://h5.qzone.qq.com/v2/vip/show/previewDialog?_wv=16781315&_wwv=13&actionId={actionId}&type={type}");
    if (URLUtil.isNetworkUrl(str)) {
      if (!str.contains("{actionId}")) {
        break label223;
      }
    }
    label223:
    for (paramString1 = str.replace("{actionId}", paramString1);; paramString1 = str)
    {
      str = paramString1;
      if (paramString1.contains("{type}")) {
        str = paramString1.replace("{type}", paramString2);
      }
      paramString1 = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
      paramString1.putExtra("url", str);
      paramString1.putExtra("hide_left_button", true);
      paramString1.putExtra("show_right_close_button", false);
      paramString1.putExtra("flag_show_loading_dialog", true);
      paramString1.putExtra("show_close_btn", false);
      paramString1.putExtra("finish_animation_none", true);
      paramString1.putExtra("fragmentStyle", 2);
      paramString1.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(paramString1);
      return;
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break;
      }
      paramActivity = bgng.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramActivity, str);
      if (paramActivity != null)
      {
        paramActivity.a();
        return;
      }
      QLog.e("QZoneVipInfoManager", 1, "aio jumpToH5PreviewAction error jumpAction = null , url = " + str);
      return;
    }
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt, 13, 13) != 0;
  }
  
  public static boolean b(Activity paramActivity, String paramString)
  {
    QLog.d("QZoneVipInfoManager", 1, "onSuperYellowBrandClick");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = a().a() + 1;
    String str2;
    String str1;
    if (paramString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))
    {
      str2 = "0";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateHostUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      label62:
      if (TextUtils.isEmpty(str1)) {
        break label196;
      }
      if (!str1.contains("{uin}")) {
        break label198;
      }
    }
    label196:
    label198:
    for (paramString = str1.replace("{uin}", paramString);; paramString = str1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVipInfoManager", 2, "onSuperYellowBrandClick from = " + i + " reserve = " + str2 + " jumpUrl = " + paramString);
      }
      bcst.b(null, "dc00898", "", "", "", "", i, 0, str2, "", "", "");
      return a(paramActivity, paramString);
      str2 = "1";
      str1 = QzoneConfig.getInstance().getConfig("H5Url", "aioCMShowQZSVIPNameplateGuestUrl", "https://h5.qzone.qq.com/limishow/mall?_wv=131072&_fv=0&_wwv=128&_wvx=10&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMjEifQ%3D%3D");
      break label62;
      break;
    }
  }
  
  public static int c(int paramInt)
  {
    return a(paramInt, 7, 8);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 21, 21);
    }
  }
  
  private String c(String paramString)
  {
    return "key_vip_info_custom_diamond_url_pre" + paramString;
  }
  
  public static boolean c(int paramInt)
  {
    return a(paramInt, 21, 21) != 0;
  }
  
  public static int d(int paramInt)
  {
    return a(paramInt, 9, 12);
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int d(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 22, 22);
    }
  }
  
  public static boolean d(int paramInt)
  {
    return a(paramInt, 22, 22) != 0;
  }
  
  public static int e(int paramInt)
  {
    return a(paramInt, 14, 16);
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = a(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int e(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 23, 23);
    }
  }
  
  public static boolean e(int paramInt)
  {
    return a(paramInt, 23, 23) != 0;
  }
  
  public static int f(int paramInt)
  {
    return a(paramInt, 17, 20);
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public static int f(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 24, 24);
    }
  }
  
  public static boolean f(int paramInt)
  {
    return a(paramInt, 24, 24) != 0;
  }
  
  public static int g(int paramInt)
  {
    return a(paramInt, 26, 29);
  }
  
  public static int g(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 26, 29);
      }
    }
    return i;
  }
  
  public static int g(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 25, 25);
    }
  }
  
  public static boolean g(int paramInt)
  {
    return a(paramInt, 25, 25) != 0;
  }
  
  public int a()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
  
  public String a()
  {
    a();
    return this.b;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      a();
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int, paramInt);
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info)
  {
    boolean bool2 = true;
    a(true);
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int, paramInt1);
    this.jdField_a_of_type_Int = b(this.jdField_a_of_type_Int, paramInt2);
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt3 != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Int = a(paramInt1, bool1);
      if (paramstar_info != null)
      {
        this.jdField_a_of_type_Int = c(this.jdField_a_of_type_Int, paramstar_info.iStarStatus);
        this.jdField_a_of_type_Int = d(this.jdField_a_of_type_Int, paramstar_info.iStarLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isAnnualVip == 0) {
          break label317;
        }
        bool1 = true;
        label107:
        this.jdField_a_of_type_Int = b(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isHighStarVip == 0) {
          break label323;
        }
        bool1 = true;
        label133:
        this.jdField_a_of_type_Int = e(paramInt1, bool1);
      }
      if (paramcombine_diamond_info != null)
      {
        this.jdField_a_of_type_Int = e(this.jdField_a_of_type_Int, paramcombine_diamond_info.iShowType);
        this.jdField_a_of_type_Int = f(this.jdField_a_of_type_Int, paramcombine_diamond_info.iVipLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVip == 0) {
          break label329;
        }
        bool1 = true;
        label196:
        this.jdField_a_of_type_Int = c(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVipEver == 0) {
          break label335;
        }
      }
    }
    label317:
    label323:
    label329:
    label335:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Int = d(paramInt1, bool1);
      paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
      paramcombine_diamond_info = new Bundle();
      paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.jdField_a_of_type_Int);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.jdField_a_of_type_JavaLangString);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoCustomDiamondUrl", this.b);
      paramstar_info.putExtras(paramcombine_diamond_info);
      BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
      b();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label107;
      bool1 = false;
      break label133;
      bool1 = false;
      break label196;
    }
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public int b()
  {
    a();
    return b(this.jdField_a_of_type_Int);
  }
  
  public boolean b()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltn
 * JD-Core Version:    0.7.0.1
 */