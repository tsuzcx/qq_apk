import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class assy
{
  private static volatile assy jdField_a_of_type_Assy;
  private long jdField_a_of_type_Long;
  aslz jdField_a_of_type_Aslz = new assz(this);
  private astf jdField_a_of_type_Astf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private assy(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
    }
  }
  
  public static assy a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Assy == null) {}
    try
    {
      if (jdField_a_of_type_Assy == null) {
        jdField_a_of_type_Assy = new assy(paramQQAppInterface);
      }
      return jdField_a_of_type_Assy;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
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
    localIntent.putExtra("key_limitchat_enter_type", aici.c);
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
    bhdj.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698526)).setPositiveButton(paramBaseActivity.getString(2131698525), new asta()).show();
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
    bhdj.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698524)).setNegativeButton(paramBaseActivity.getString(2131698522), new astc()).setPositiveButton(paramBaseActivity.getString(2131698523), new astb(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, asne paramasne)
  {
    aweo.b(paramQQAppInterface, paramasne.jdField_b_of_type_JavaLangString);
    aweo.a(paramQQAppInterface, paramasne, paramasne.jdField_a_of_type_Long, 2, paramInt);
    String str1 = paramasne.jdField_b_of_type_JavaLangString;
    paramInt = paramasne.jdField_b_of_type_Int;
    String str2 = paramasne.f;
    if (!TextUtils.isEmpty(paramasne.c)) {}
    for (boolean bool = true;; bool = false)
    {
      aweo.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramasne.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (bbdh)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        paramQQAppInterface.b(paramasne.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, paramString2, paramInt);
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    azrs localazrs = ((aslo)paramBaseActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    boolean bool = c(paramBaseActivity.app);
    bhdj.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698486)).setNegativeButton(paramBaseActivity.getString(2131698522), new aste()).setPositiveButton(paramBaseActivity.getString(2131698523), new astd(paramBaseActivity, bool, localazrs)).show();
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
    paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
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
    paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
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
    paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_Astf = null;
    jdField_a_of_type_Assy = null;
    this.jdField_a_of_type_Aslz = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, astf paramastf)
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
      a(paramQQAppInterface, str1, str2, arrayOfByte, ExtendFriendUserInfo.subIDToFromType(paramAllInOne.l), paramastf);
      i = assw.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label126;
        }
      }
    }
    label126:
    for (int i = 2;; i = 4)
    {
      assw.a().a(i, str1, "", assw.a(), assw.b(), assw.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, astf paramastf)
  {
    if ((paramQQAppInterface == null) || (paramastf == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramastf);
      }
    }
    do
    {
      return;
      if (a(paramQQAppInterface)) {
        break label144;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Astf = paramastf;
    ((aslm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.2(this, paramInt, paramString1));
    return;
    label144:
    paramString1 = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    paramString2 = paramString1.a();
    if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)))
    {
      paramastf.showCampusVerifyDialog(false, -1, paramString1.f(), "");
      return;
    }
    paramastf.showCampusVerifyDialog(c(paramQQAppInterface), paramString2.jdField_a_of_type_Int, paramString2.jdField_b_of_type_JavaLangString, paramString2.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assy
 * JD-Core Version:    0.7.0.1
 */