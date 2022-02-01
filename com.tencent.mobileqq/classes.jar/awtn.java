import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.PushNotificationManager.1;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class awtn
  implements Manager
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  private long jdField_a_of_type_Long;
  private ardv jdField_a_of_type_Ardv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private int d = -1;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public awtn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
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
        this.jdField_a_of_type_Long = bhhr.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      if (localLong.longValue() - this.jdField_a_of_type_Long > 86400000L)
      {
        this.jdField_a_of_type_Long = bhid.a(localLong.longValue());
        bhhr.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_Long);
        bhhr.ai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        this.d = 0;
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Today First Query, mTodayHadShowCount=" + this.d + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
        }
      }
      else
      {
        this.d = bhhr.aW(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "Query, mTodayHadShowCount=" + this.d + " mTodayZeroTimeMillis=" + this.jdField_a_of_type_Long);
        }
      }
    }
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.curType == 0) {}
    for (String str = paramSessionInfo.curFriendUin;; str = "") {
      for (;;)
      {
        if ((QLog.isColorLevel()) && (TextUtils.isEmpty(str))) {
          QLog.d("PushNotificationManager", 2, "sessionInfo.curType=" + paramSessionInfo.curType + " uin==null sessionInfo.realTroopUin=" + paramSessionInfo.realTroopUin);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "uin=" + str + "mApp.getAccount()=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
        try
        {
          List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str }, null, null, null, null);
          if ((localList == null) || (localList.size() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
            }
            paramSessionInfo = new PushSwitchGrayTipsInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), str, paramSessionInfo.curType, this.jdField_a_of_type_Long, 1);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramSessionInfo);
            return true;
            if ((paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000)) {
              str = paramSessionInfo.curFriendUin;
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
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramSessionInfo);
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
    if (paramSessionInfo.curType == 0) {
      str2 = a().a();
    }
    for (str1 = a().b();; str1 = a().d())
    {
      do
      {
        avhz localavhz = new avhz(paramSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str2, paramSessionInfo.curType, -5023, 655383, 0L);
        if (paramSessionInfo.curType == 0) {
          localavhz.jdField_a_of_type_Long = (bcrg.a() + 1L);
        }
        int i = str2.indexOf(str1);
        if (i >= 0)
        {
          paramSessionInfo = new Bundle();
          paramSessionInfo.putInt("key_action", 40);
          paramSessionInfo.putString("textColor", "");
          paramSessionInfo.putString("image_resource", null);
          paramSessionInfo.putString("key_action_DATA", paramInt + "");
          localavhz.a(i, str1.length() + i, paramSessionInfo);
        }
        paramSessionInfo = new MessageForUniteGrayTip();
        paramSessionInfo.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localavhz);
        avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
        bdla.b(null, "dc00898", "", "", "0X8009ACE", "0X8009ACE", paramInt, paramInt, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("PushNotificationManager", 2, "add gray tip =" + str2 + " fromType=" + paramInt);
        }
        return;
      } while ((paramSessionInfo.curType != 1) && (paramSessionInfo.curType != 3000));
      str2 = a().c();
    }
  }
  
  public ardv a()
  {
    if (this.jdField_a_of_type_Ardv == null)
    {
      this.jdField_a_of_type_Ardv = new ardv();
      this.jdField_a_of_type_Ardv.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
      }
    }
    return this.jdField_a_of_type_Ardv;
  }
  
  public void a(ardv paramardv)
  {
    this.jdField_a_of_type_Ardv = paramardv;
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
      bhhr.ai(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtn
 * JD-Core Version:    0.7.0.1
 */