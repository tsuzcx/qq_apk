import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class bhau
  implements Handler.Callback
{
  public static int a;
  public static boolean c;
  bjng jdField_a_of_type_Bjng;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  int b;
  public volatile boolean b;
  
  static
  {
    jdField_a_of_type_Int = 42080;
  }
  
  public bhau(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_Bjng = new bjng(ThreadManager.getSubThreadLooper(), this);
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getPreferences().getBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", false);
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleLebaEntryChecker", 2, "WholePeopleLebaEntryChecker init switch:" + this.jdField_a_of_type_Boolean);
      }
    } while (!c);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    Object localObject = paramQQAppInterface.getLebaResourceInfoList();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, list is null, return false");
      }
      return false;
    }
    int i = 0;
    if (i < ((List)localObject).size())
    {
      LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((List)localObject).get(i);
      if ((localLebaPluginInfo == null) || (localLebaPluginInfo.uiResId != 770L)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, is=770, find=" + bool1);
      }
      if (!bool1) {
        break;
      }
      localObject = paramQQAppInterface.getLebaHelper().a;
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, campusLebaEntryChecker is null");
        }
      }
      while (((bhau)localObject).jdField_b_of_type_Boolean)
      {
        paramQQAppInterface = ((azvi)paramQQAppInterface.getManager(36)).a().iterator();
        do
        {
          bool1 = bool2;
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
          localObject = (BusinessInfoCheckUpdate.AppSetting)paramQQAppInterface.next();
        } while (((BusinessInfoCheckUpdate.AppSetting)localObject).appid.get() != 770);
        bool2 = ((BusinessInfoCheckUpdate.AppSetting)localObject).setting.get();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow find appid 770");
          bool1 = bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow return " + bool1);
        }
        return bool1;
        i += 1;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WholePeopleLebaEntryChecker", 2, "checkPluginShow, switch is off, return false");
      return false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjng.hasMessages(0)) {
      this.jdField_a_of_type_Bjng.removeMessages(0);
    }
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_Bjng.sendEmptyMessageDelayed(0, 2000L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (c) {
        this.jdField_a_of_type_Boolean = true;
      }
      paramQQAppInterface.getPreferences().edit().putBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", paramBoolean).apply();
    } while (!QLog.isColorLevel());
    QLog.i("WholePeopleLebaEntryChecker", 2, String.format(Locale.getDefault(), "update show: %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleLebaEntryChecker", 2, "setEntryIsOn " + paramBoolean);
    }
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      amzu.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008824", "0X8008824", 0, this.jdField_b_of_type_Int, 0, "", "", "", "");
    this.jdField_b_of_type_Int = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhau
 * JD-Core Version:    0.7.0.1
 */