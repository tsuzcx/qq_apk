import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aqcz
{
  private static volatile aqcz jdField_a_of_type_Aqcz;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  apxc jdField_a_of_type_Apxc = new aqda(this);
  private aqdi jdField_a_of_type_Aqdi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private aqcz(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apxc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apxc);
    }
  }
  
  public static aqcz a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Aqcz == null) {}
    try
    {
      if (jdField_a_of_type_Aqcz == null) {
        jdField_a_of_type_Aqcz = new aqcz(paramQQAppInterface);
      }
      return jdField_a_of_type_Aqcz;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (apwx)paramQQAppInterface.getManager(264);
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
    bdcd.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699348)).setPositiveButton(paramBaseActivity.getString(2131699347), new aqdb()).show();
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
    bdcd.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699346)).setNegativeButton(paramBaseActivity.getString(2131699344), new aqdd()).setPositiveButton(paramBaseActivity.getString(2131699345), new aqdc(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, apyc paramapyc)
  {
    athk.b(paramQQAppInterface, paramapyc.jdField_b_of_type_JavaLangString);
    athk.a(paramQQAppInterface, paramapyc, paramapyc.jdField_a_of_type_Long, 2, paramInt);
    String str1 = paramapyc.jdField_b_of_type_JavaLangString;
    paramInt = paramapyc.jdField_b_of_type_Int;
    String str2 = paramapyc.f;
    if (!TextUtils.isEmpty(paramapyc.c)) {}
    for (boolean bool = true;; bool = false)
    {
      athk.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramapyc.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (amfi)paramQQAppInterface.getManager(285);
        paramQQAppInterface.b(paramapyc.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((apwx)paramQQAppInterface.getManager(264)).a(paramString1, paramString2, paramInt);
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null))
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "isNeedShowSchoolVerifyDialogByMathChat-> null == mActivity || null == mActivity.app then return true");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogByMathChat->");
    }
    if ((b(paramBaseActivity.app)) && (!c(paramBaseActivity.app)))
    {
      b(paramBaseActivity);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogByMathChat-> is not student ");
    }
    return false;
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
  
  public static void b(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusWriteDialog() activity is null just return");
      return;
    }
    bdcd.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699305)).setNegativeButton(paramBaseActivity.getString(2131699344), new aqdh()).setPositiveButton(paramBaseActivity.getString(2131699304), new aqdg(paramBaseActivity)).show();
  }
  
  public static boolean b(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    awnc localawnc = ((apwx)paramBaseActivity.app.getManager(264)).a();
    boolean bool = c(paramBaseActivity.app);
    bdcd.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699305)).setNegativeButton(paramBaseActivity.getString(2131699344), new aqdf()).setPositiveButton(paramBaseActivity.getString(2131699345), new aqde(paramBaseActivity, bool, localawnc)).show();
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (apwx)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> return " + paramQQAppInterface.b());
    }
    return paramQQAppInterface.b();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (apwx)paramQQAppInterface.getManager(264);
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
    paramQQAppInterface = (apwx)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (paramQQAppInterface.c() == 2)
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
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apxc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Aqdi = null;
    jdField_a_of_type_Aqcz = null;
    this.jdField_a_of_type_Apxc = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, aqdi paramaqdi)
  {
    String str1;
    if (paramAllInOne != null)
    {
      str1 = paramAllInOne.jdField_a_of_type_JavaLangString;
      String str2 = paramAllInOne.h;
      paramAllInOne = paramAllInOne.c;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", new Object[] { str1, str2, paramAllInOne }));
      }
      a(paramQQAppInterface, str1, str2, paramAllInOne, paramaqdi);
      i = aqcx.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label116;
        }
      }
    }
    label116:
    for (int i = 2;; i = 4)
    {
      aqcx.a().a(i, str1, "", aqcx.a(), aqcx.b(), aqcx.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, aqdi paramaqdi)
  {
    if ((paramQQAppInterface == null) || (paramaqdi == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramaqdi);
      }
    }
    do
    {
      return;
      if (a(paramQQAppInterface)) {
        break label125;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Aqdi = paramaqdi;
    ((apwv)paramQQAppInterface.a(127)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    return;
    label125:
    paramString1 = ((apwx)paramQQAppInterface.getManager(264)).a();
    paramaqdi.a(c(paramQQAppInterface), paramString1.jdField_a_of_type_Int, paramString1.jdField_b_of_type_JavaLangString, paramString1.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcz
 * JD-Core Version:    0.7.0.1
 */