import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;

public class atcb
{
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.c() + "extend_friend_campus_file", 0);
  }
  
  public static EditExtendFriendInfo.SchoolInfo a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    EditExtendFriendInfo.SchoolInfo localSchoolInfo = new EditExtendFriendInfo.SchoolInfo();
    if (paramSchoolInfo != null)
    {
      if (paramSchoolInfo.uint32_idx.has()) {
        localSchoolInfo.uint32_idx.set(paramSchoolInfo.uint32_idx.get());
      }
      if (paramSchoolInfo.uint32_category.has()) {
        localSchoolInfo.uint32_category.set(paramSchoolInfo.uint32_category.get());
      }
      if (paramSchoolInfo.str_school_id.has()) {
        localSchoolInfo.str_school_id.set(paramSchoolInfo.str_school_id.get());
      }
      if (paramSchoolInfo.str_school_name.has()) {
        localSchoolInfo.str_school_name.set(paramSchoolInfo.str_school_name.get());
      }
      if (paramSchoolInfo.str_department_id.has()) {
        localSchoolInfo.str_department_id.set(paramSchoolInfo.str_department_id.get());
      }
      if (paramSchoolInfo.str_department_name.has()) {
        localSchoolInfo.str_department_name.set(paramSchoolInfo.str_department_name.get());
      }
      if (paramSchoolInfo.uint32_degree.has()) {
        localSchoolInfo.uint32_degree.set(paramSchoolInfo.uint32_degree.get());
      }
      if (paramSchoolInfo.uint32_enrollment_year.has()) {
        localSchoolInfo.uint32_enrollment_year.set(paramSchoolInfo.uint32_enrollment_year.get());
      }
      if (paramSchoolInfo.uint32_graduation_year.has()) {
        localSchoolInfo.uint32_graduation_year.set(paramSchoolInfo.uint32_graduation_year.get());
      }
      if (paramSchoolInfo.uint32_allow_recommend.has()) {
        localSchoolInfo.uint32_allow_recommend.set(paramSchoolInfo.uint32_allow_recommend.get());
      }
      if (paramSchoolInfo.uint32_create_source.has()) {
        localSchoolInfo.uint32_create_source.set(paramSchoolInfo.uint32_create_source.get());
      }
      if (paramSchoolInfo.uint32_create_time.has()) {
        localSchoolInfo.uint32_create_time.set(paramSchoolInfo.uint32_create_time.get());
      }
      if (paramSchoolInfo.uint32_update_source.has()) {
        localSchoolInfo.uint32_update_source.set(paramSchoolInfo.uint32_update_source.get());
      }
      if (paramSchoolInfo.uint32_update_time.has()) {
        localSchoolInfo.uint32_update_time.set(paramSchoolInfo.uint32_update_time.get());
      }
      if (paramSchoolInfo.uint32_hidden_flag.has()) {
        localSchoolInfo.uint32_hidden_flag.set(paramSchoolInfo.uint32_hidden_flag.get());
      }
      if (paramSchoolInfo.uint32_verify_status.has()) {
        localSchoolInfo.uint32_verified.set(paramSchoolInfo.uint32_verify_status.get());
      }
    }
    return localSchoolInfo;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    String str = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128";
    if (!TextUtils.isEmpty(paramString1)) {
      str = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128&category=" + paramInt2 + "&schoolname=" + paramString1 + "&schoolid=" + paramString2 + "&idx=" + paramInt1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToEditSchoolInfoWebPage url=%s", new Object[] { str }));
    }
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", str);
    paramActivity.startActivity(paramString1);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "https://h5.qzone.qq.com/v2/wezone/schoolauth?busitype=2&_wv=3&_proxy=1&idx=" + paramInt + "&schoolname=" + paramString1 + "&schoolid=" + paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolCertificateWebPage url=%s", new Object[] { paramString1 }));
    }
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramActivity.startActivity(paramString2);
  }
  
  public static void a(Activity paramActivity, asvg paramasvg, String paramString, EditExtendFriendInfo.SchoolInfo paramSchoolInfo)
  {
    if (paramActivity.isFinishing())
    {
      QLog.d("CampusHelper", 1, "showProfileEduBackgroundUpdateDialog return ");
      return;
    }
    paramString = String.format(paramActivity.getString(2131697975), new Object[] { paramString });
    bhlq.a(paramActivity, 230).setMessage(paramString).setPositiveButton(paramActivity.getString(2131697976), new atcd(paramasvg, paramSchoolInfo)).setNegativeButton(paramActivity.getString(2131690584), new atcc()).show();
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    String str = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128";
    if (!TextUtils.isEmpty(paramString)) {
      str = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128&schoolname=" + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, String.format("jumpToSchoolFillInWebPage url=%s", new Object[] { str }));
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", str);
    paramActivity.startActivity(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface).edit().putBoolean("has_shown_fill_birthday_dialog_before", true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "markHasShownFillBirthdayDialog ");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(paramQQAppInterface);
    int j = localSharedPreferences.getInt("campus_certi_status", -1);
    int i;
    if (paramInt1 != j)
    {
      i = 1;
      if (i != 0)
      {
        localSharedPreferences.edit().putInt("campus_certi_status", paramInt1).commit();
        if (paramInt1 != 0) {
          break label121;
        }
        a(paramQQAppInterface, true);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusHelper", 2, "updateCertificateBannerShowFlag  oldStatus = " + j + ",newStatus = " + paramInt1 + ",certificateType = " + paramInt2);
      }
      return;
      i = 0;
      break;
      label121:
      if (paramInt2 == 2) {
        a(paramQQAppInterface, true);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    a(paramQQAppInterface).edit().putBoolean("need_show_campus_certi_banner", paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "updateCampusCertificateBannerShowFlag result = " + paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = a(paramQQAppInterface).getBoolean("has_shown_fill_birthday_dialog_before", false);
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "hasShownFillBirthdayDialogBefore result = " + bool);
    }
    return bool;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "updateShowSchoolBeginnerTip " + paramBoolean);
    }
    a(paramQQAppInterface).edit().putBoolean("extend_friend_school_beginner_guide", paramBoolean).commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = a(paramQQAppInterface).getBoolean("need_show_campus_certi_banner", false);
    if (QLog.isColorLevel()) {
      QLog.d("CampusHelper", 2, "getCampusCertificateBannerShowFlag result = " + bool);
    }
    return bool;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return a(paramQQAppInterface).getBoolean("extend_friend_school_beginner_guide", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcb
 * JD-Core Version:    0.7.0.1
 */