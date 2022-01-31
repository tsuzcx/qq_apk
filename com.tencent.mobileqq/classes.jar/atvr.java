import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.PushNotificationManager.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class atvr
  implements Manager
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  private long jdField_a_of_type_Long;
  private aols jdField_a_of_type_Aols;
  private awbw jdField_a_of_type_Awbw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int d = -1;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public atvr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.executeOnSubThread(new PushNotificationManager.1(this, paramQQAppInterface));
  }
  
  private int a()
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    if ((this.d >= 0) && (localLong.longValue() - this.jdField_a_of_type_Long < 86400000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "mTodayHadShowCount=" + this.d + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return this.d;
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = bdiv.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      if (localLong.longValue() - this.jdField_a_of_type_Long > 86400000L)
      {
        this.jdField_a_of_type_Long = bdjj.a(localLong.longValue());
        bdiv.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_Long);
        bdiv.ai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        this.d = 0;
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Today First Query, mTodayHadShowCount=" + this.d + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
        }
      }
      else
      {
        this.d = bdiv.aW(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Query, mTodayHadShowCount=" + this.d + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
        }
      }
    }
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {}
    for (String str = paramSessionInfo.jdField_a_of_type_JavaLangString;; str = "") {
      for (;;)
      {
        if ((QLog.isColorLevel()) && (TextUtils.isEmpty(str))) {
          QLog.d("PushNotificationManager", 2, "sessionInfo.curType=" + paramSessionInfo.jdField_a_of_type_Int + " uin==null sessionInfo.realTroopUin=" + paramSessionInfo.c);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "uin=" + str + "mApp.getAccount()=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
        try
        {
          List localList = this.jdField_a_of_type_Awbw.a(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str }, null, null, null, null);
          if ((localList == null) || (localList.size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
            }
            paramSessionInfo = new PushSwitchGrayTipsInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), str, paramSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 1);
            this.jdField_a_of_type_Awbw.b(paramSessionInfo);
            return true;
            if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
              str = paramSessionInfo.jdField_a_of_type_JavaLangString;
            }
          }
          else
          {
            paramSessionInfo = (PushSwitchGrayTipsInfo)localList.get(0);
            if (QLog.isColorLevel()) {
              QLog.d("PushNotificationManager", 2, "pushSwitchGrayTipsInfo.lastShowTime=" + paramSessionInfo.lastShowTime + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
            }
            if (paramSessionInfo.lastShowTime >= this.jdField_a_of_type_Long) {
              return false;
            }
            paramSessionInfo.lastShowTime = this.jdField_a_of_type_Long;
            paramSessionInfo.showCount += 1;
            this.jdField_a_of_type_Awbw.a(paramSessionInfo);
            return true;
          }
        }
        finally {}
      }
    }
  }
  
  private void b(SessionInfo paramSessionInfo, int paramInt)
  {
    String str2 = "";
    String str1 = "";
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      str2 = a().a();
    }
    for (str1 = a().b();; str1 = a().d())
    {
      do
      {
        aslp localaslp = new aslp(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str2, paramSessionInfo.jdField_a_of_type_Int, -5023, 655383, 0L);
        if (paramSessionInfo.jdField_a_of_type_Int == 0) {
          localaslp.jdField_a_of_type_Long = (ayvc.a() + 1L);
        }
        int i = str2.indexOf(str1);
        if (i >= 0)
        {
          paramSessionInfo = new Bundle();
          paramSessionInfo.putInt("key_action", 40);
          paramSessionInfo.putString("textColor", "");
          paramSessionInfo.putString("image_resource", null);
          paramSessionInfo.putString("key_action_DATA", paramInt + "");
          localaslp.a(i, str1.length() + i, paramSessionInfo);
        }
        paramSessionInfo = new MessageForUniteGrayTip();
        paramSessionInfo.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaslp);
        aslq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
        azmj.b(null, "dc00898", "", "", "0X8009ACE", "0X8009ACE", paramInt, paramInt, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "add gray tip =" + str2 + " fromType=" + paramInt);
        }
        return;
      } while ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000));
      str2 = a().c();
    }
  }
  
  public aols a()
  {
    if (this.jdField_a_of_type_Aols == null)
    {
      this.jdField_a_of_type_Aols = new aols();
      this.jdField_a_of_type_Aols.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
      }
    }
    return this.jdField_a_of_type_Aols;
  }
  
  public void a(aols paramaols)
  {
    this.jdField_a_of_type_Aols = paramaols;
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt)
  {
    if (QQToast.a() == 0) {
      if (a().a())
      {
        if (a() < a().a()) {
          break label46;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "getmTodayHadShowCount > showCount");
        }
      }
    }
    label46:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!a(paramSessionInfo));
      this.d += 1;
      bdiv.ai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.d);
      b(paramSessionInfo, paramInt);
      return;
    }
    QLog.d("PushNotificationManager", 2, "isNotificationEnabled=" + QQToast.a());
  }
  
  public void onDestroy()
  {
    this.d = -1;
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvr
 * JD-Core Version:    0.7.0.1
 */