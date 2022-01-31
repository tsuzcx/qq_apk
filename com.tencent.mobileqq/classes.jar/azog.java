import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class azog
  extends ajsy
{
  azog(azoc paramazoc) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ajsy);
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      if (this.a.jdField_a_of_type_Azol != null) {
        break;
      }
      azoc.a(this.a);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate data null");
      azoc.a(this.a);
      this.a.jdField_a_of_type_Azol.a(-1, "");
      this.a.jdField_a_of_type_Azol = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((azon)paramObject).jdField_a_of_type_Int;
      i = j;
    }
    catch (Exception paramObject)
    {
      label135:
      String str;
      break label135;
    }
    QLog.i("TroopCreateLogic", 1, "onGetTroopCreate retCode:" + i + "  currentUin:" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    azoc.a(this.a);
    this.a.jdField_a_of_type_Azol.a(i, "");
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate troopUin:" + str);
      azoc.a(this.a);
      this.a.jdField_a_of_type_Azol.a(-1, "");
      this.a.jdField_a_of_type_Azol = null;
      return;
    }
    this.a.jdField_a_of_type_Azom.f = str;
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_Azom.jdField_a_of_type_Int), "", "");
    if (this.a.jdField_a_of_type_Azom.jdField_a_of_type_JavaUtilArrayList == null)
    {
      i = 1;
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.a.jdField_a_of_type_Azom.d, "" + i, "");
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate success troopUin:" + str + " number:" + i + "  createFrom:" + this.a.jdField_a_of_type_Azom.d);
      ThreadManager.post(new TroopCreateLogic.4.1(this, str, paramObject, i), 8, null, true);
      if (this.a.jdField_a_of_type_Azom.b)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.a.a(paramObject, str);
      }
      this.a.jdField_a_of_type_Azol.a(0, str);
      if (this.a.jdField_a_of_type_Azom.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label630;
      }
      ((akhp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(str, this.a.jdField_a_of_type_Azom.jdField_a_of_type_JavaUtilArrayList, "");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Akil);
    }
    for (;;)
    {
      azoc.a(this.a);
      return;
      i = this.a.jdField_a_of_type_Azom.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label630:
      this.a.jdField_a_of_type_Azol = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azog
 * JD-Core Version:    0.7.0.1
 */