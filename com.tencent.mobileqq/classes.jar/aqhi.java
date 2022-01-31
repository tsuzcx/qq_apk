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

public class aqhi
{
  private static volatile aqhi jdField_a_of_type_Aqhi;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  aqbl jdField_a_of_type_Aqbl = new aqhj(this);
  private aqhr jdField_a_of_type_Aqhr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private aqhi(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
    }
  }
  
  public static aqhi a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Aqhi == null) {}
    try
    {
      if (jdField_a_of_type_Aqhi == null) {
        jdField_a_of_type_Aqhi = new aqhi(paramQQAppInterface);
      }
      return jdField_a_of_type_Aqhi;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
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
    bdgm.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699360)).setPositiveButton(paramBaseActivity.getString(2131699359), new aqhk()).show();
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
    bdgm.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699358)).setNegativeButton(paramBaseActivity.getString(2131699356), new aqhm()).setPositiveButton(paramBaseActivity.getString(2131699357), new aqhl(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, aqcl paramaqcl)
  {
    atlt.b(paramQQAppInterface, paramaqcl.jdField_b_of_type_JavaLangString);
    atlt.a(paramQQAppInterface, paramaqcl, paramaqcl.jdField_a_of_type_Long, 2, paramInt);
    String str1 = paramaqcl.jdField_b_of_type_JavaLangString;
    paramInt = paramaqcl.jdField_b_of_type_Int;
    String str2 = paramaqcl.f;
    if (!TextUtils.isEmpty(paramaqcl.c)) {}
    for (boolean bool = true;; bool = false)
    {
      atlt.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramaqcl.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (amjx)paramQQAppInterface.getManager(285);
        paramQQAppInterface.b(paramaqcl.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((aqbg)paramQQAppInterface.getManager(264)).a(paramString1, paramString2, paramInt);
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
    bdgm.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699317)).setNegativeButton(paramBaseActivity.getString(2131699356), new aqhq()).setPositiveButton(paramBaseActivity.getString(2131699316), new aqhp(paramBaseActivity)).show();
  }
  
  public static boolean b(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    awrl localawrl = ((aqbg)paramBaseActivity.app.getManager(264)).a();
    boolean bool = c(paramBaseActivity.app);
    bdgm.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131699317)).setNegativeButton(paramBaseActivity.getString(2131699356), new aqho()).setPositiveButton(paramBaseActivity.getString(2131699357), new aqhn(paramBaseActivity, bool, localawrl)).show();
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
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
    paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
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
    paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Aqhr = null;
    jdField_a_of_type_Aqhi = null;
    this.jdField_a_of_type_Aqbl = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, aqhr paramaqhr)
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
      a(paramQQAppInterface, str1, str2, paramAllInOne, paramaqhr);
      i = aqhg.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label116;
        }
      }
    }
    label116:
    for (int i = 2;; i = 4)
    {
      aqhg.a().a(i, str1, "", aqhg.a(), aqhg.b(), aqhg.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, aqhr paramaqhr)
  {
    if ((paramQQAppInterface == null) || (paramaqhr == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramaqhr);
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
    this.jdField_a_of_type_Aqhr = paramaqhr;
    ((aqbe)paramQQAppInterface.a(127)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    return;
    label125:
    paramString1 = (aqbg)paramQQAppInterface.getManager(264);
    paramString2 = paramString1.a();
    if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)))
    {
      paramaqhr.a(false, -1, paramString1.f(), "");
      return;
    }
    paramaqhr.a(c(paramQQAppInterface), paramString2.jdField_a_of_type_Int, paramString2.jdField_b_of_type_JavaLangString, paramString2.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhi
 * JD-Core Version:    0.7.0.1
 */