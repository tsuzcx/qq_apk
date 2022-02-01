import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class azzr
  implements birt, Manager
{
  private bafn jdField_a_of_type_Bafn = new azzs(this);
  private birs jdField_a_of_type_Birs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public azzr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Birs = new birs(paramQQAppInterface, this);
    a(this.jdField_a_of_type_Birs.a(13));
    a(paramQQAppInterface);
  }
  
  private void a()
  {
    if ((this.b) && (this.c)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        b();
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      bafl localbafl = (bafl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
      if (localbafl != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(42425));
        localbafl.a(localArrayList);
        paramQQAppInterface.addObserver(this.jdField_a_of_type_Bafn);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("notifySettingMeRedPointChanged mSettingMeRedPointEnable=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      anri localanri = (anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localanri != null) {
        localanri.notifyUI(115, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((TextUtils.equals(paramString, "profile_switch_config")) && (this.jdField_a_of_type_Birs != null)) {
      a(this.jdField_a_of_type_Birs.a(13));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("updateConfigSwitch newConfigSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean != this.b)
    {
      this.b = paramBoolean;
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("updateBusinessSwitch newBusinessSwitch=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean != this.c)
    {
      this.c = paramBoolean;
      a();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Birs != null)
    {
      this.jdField_a_of_type_Birs.a();
      this.jdField_a_of_type_Birs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzr
 * JD-Core Version:    0.7.0.1
 */