import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class atck
{
  private static volatile atck jdField_a_of_type_Atck;
  private long jdField_a_of_type_Long;
  asvt jdField_a_of_type_Asvt = new atcl(this);
  private atcr jdField_a_of_type_Atcr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private atck(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    }
  }
  
  public static atck a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Atck == null) {}
    try
    {
      if (jdField_a_of_type_Atck == null) {
        jdField_a_of_type_Atck = new atck(paramQQAppInterface);
      }
      return jdField_a_of_type_Atck;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> mExtendFriendManager is null then return 0");
      }
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      if (paramQQAppInterface.a() == null) {
        break;
      }
      str = paramQQAppInterface.g();
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> schoolName = " + str);
    return str;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> has not school schoolName ");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "enterAio() context is null just return");
      return;
    }
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtras(new Bundle());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showMatchCountDialog() activity is null just return");
      return;
    }
    bhlq.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698076)).setPositiveButton(paramBaseActivity.getString(2131698075), new atcm()).show();
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showToast() activity is null just return");
      return;
    }
    QQToast.a(paramBaseActivity, paramString, 0).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialog() activity is null just return");
      return;
    }
    bhlq.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698074)).setNegativeButton(paramBaseActivity.getString(2131698072), new atco()).setPositiveButton(paramBaseActivity.getString(2131698073), new atcn(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, aswv paramaswv)
  {
    awlm.b(paramQQAppInterface, paramaswv.jdField_b_of_type_JavaLangString);
    awlm.a(paramQQAppInterface, paramaswv, paramaswv.jdField_a_of_type_Long, 2, paramInt);
    String str1 = paramaswv.jdField_b_of_type_JavaLangString;
    paramInt = paramaswv.jdField_b_of_type_Int;
    String str2 = paramaswv.f;
    if (!TextUtils.isEmpty(paramaswv.c)) {}
    for (boolean bool = true;; bool = false)
    {
      awlm.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramaswv.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (bbcd)paramQQAppInterface.getManager(285);
        paramQQAppInterface.b(paramaswv.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((asvi)paramQQAppInterface.getManager(264)).a(paramString1, paramString2, paramInt);
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    azyi localazyi = ((asvi)paramBaseActivity.app.getManager(264)).a();
    boolean bool = c(paramBaseActivity.app);
    bhlq.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698036)).setNegativeButton(paramBaseActivity.getString(2131698072), new atcq()).setPositiveButton(paramBaseActivity.getString(2131698073), new atcp(paramBaseActivity, bool, localazyi)).show();
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> currentUin = " + paramQQAppInterface.getCurrentAccountUin());
    }
    if ((b(paramQQAppInterface)) && (!d(paramQQAppInterface))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> false ");
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> return " + paramQQAppInterface.c());
    }
    return paramQQAppInterface.c();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramQQAppInterface.g()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return false");
    }
    return false;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (paramQQAppInterface.e() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return false");
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Atcr = null;
    jdField_a_of_type_Atck = null;
    this.jdField_a_of_type_Asvt = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, atcr paramatcr)
  {
    String str1;
    if (paramAllInOne != null)
    {
      str1 = paramAllInOne.jdField_a_of_type_JavaLangString;
      String str2 = paramAllInOne.h;
      byte[] arrayOfByte = paramAllInOne.c;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", new Object[] { str1, str2, arrayOfByte }));
      }
      a(paramQQAppInterface, str1, str2, arrayOfByte, ExtendFriendUserInfo.subIDToFromType(paramAllInOne.l), paramatcr);
      i = atci.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label126;
        }
      }
    }
    label126:
    for (int i = 2;; i = 4)
    {
      atci.a().a(i, str1, "", atci.a(), atci.b(), atci.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, atcr paramatcr)
  {
    if ((paramQQAppInterface == null) || (paramatcr == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramatcr);
      }
    }
    do
    {
      return;
      if (a(paramQQAppInterface)) {
        break label143;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Atcr = paramatcr;
    ((asvg)paramQQAppInterface.a(127)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.2(this, paramInt, paramString1));
    return;
    label143:
    paramString1 = (asvi)paramQQAppInterface.getManager(264);
    paramString2 = paramString1.a();
    if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)))
    {
      paramatcr.a(false, -1, paramString1.f(), "");
      return;
    }
    paramatcr.a(c(paramQQAppInterface), paramString2.jdField_a_of_type_Int, paramString2.jdField_b_of_type_JavaLangString, paramString2.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atck
 * JD-Core Version:    0.7.0.1
 */