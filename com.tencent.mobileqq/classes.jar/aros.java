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
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aros
{
  private static volatile aros jdField_a_of_type_Aros;
  private long jdField_a_of_type_Long;
  arht jdField_a_of_type_Arht = new arot(this);
  private aroz jdField_a_of_type_Aroz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private aros(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Arht);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Arht);
    }
  }
  
  public static aros a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Aros == null) {}
    try
    {
      if (jdField_a_of_type_Aros == null) {
        jdField_a_of_type_Aros = new aros(paramQQAppInterface);
      }
      return jdField_a_of_type_Aros;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (arhi)paramQQAppInterface.getManager(264);
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
    bfur.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698240)).setPositiveButton(paramBaseActivity.getString(2131698239), new arou()).show();
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
    bfur.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698238)).setNegativeButton(paramBaseActivity.getString(2131698236), new arow()).setPositiveButton(paramBaseActivity.getString(2131698237), new arov(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ariy paramariy)
  {
    auyo.b(paramQQAppInterface, paramariy.jdField_b_of_type_JavaLangString);
    auyo.a(paramQQAppInterface, paramariy, paramariy.jdField_a_of_type_Long, 2, paramInt);
    String str1 = paramariy.jdField_b_of_type_JavaLangString;
    paramInt = paramariy.jdField_b_of_type_Int;
    String str2 = paramariy.f;
    if (!TextUtils.isEmpty(paramariy.c)) {}
    for (boolean bool = true;; bool = false)
    {
      auyo.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramariy.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (azwy)paramQQAppInterface.getManager(285);
        paramQQAppInterface.b(paramariy.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((arhi)paramQQAppInterface.getManager(264)).a(paramString1, paramString2, paramInt);
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    aymx localaymx = ((arhi)paramBaseActivity.app.getManager(264)).a();
    boolean bool = c(paramBaseActivity.app);
    bfur.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698200)).setNegativeButton(paramBaseActivity.getString(2131698236), new aroy()).setPositiveButton(paramBaseActivity.getString(2131698237), new arox(paramBaseActivity, bool, localaymx)).show();
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
    paramQQAppInterface = (arhi)paramQQAppInterface.getManager(264);
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
    paramQQAppInterface = (arhi)paramQQAppInterface.getManager(264);
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
    paramQQAppInterface = (arhi)paramQQAppInterface.getManager(264);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Arht);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Aroz = null;
    jdField_a_of_type_Aros = null;
    this.jdField_a_of_type_Arht = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, aroz paramaroz)
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
      a(paramQQAppInterface, str1, str2, arrayOfByte, ExtendFriendUserInfo.subIDToFromType(paramAllInOne.l), paramaroz);
      i = aroq.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label126;
        }
      }
    }
    label126:
    for (int i = 2;; i = 4)
    {
      aroq.a().a(i, str1, "", aroq.a(), aroq.b(), aroq.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, aroz paramaroz)
  {
    if ((paramQQAppInterface == null) || (paramaroz == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramaroz);
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
    this.jdField_a_of_type_Aroz = paramaroz;
    ((arhg)paramQQAppInterface.getBusinessHandler(127)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.2(this, paramInt, paramString1));
    return;
    label143:
    paramString1 = (arhi)paramQQAppInterface.getManager(264);
    paramString2 = paramString1.a();
    if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)))
    {
      paramaroz.showCampusVerifyDialog(false, -1, paramString1.f(), "");
      return;
    }
    paramaroz.showCampusVerifyDialog(c(paramQQAppInterface), paramString2.jdField_a_of_type_Int, paramString2.jdField_b_of_type_JavaLangString, paramString2.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */