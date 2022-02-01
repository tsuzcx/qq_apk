import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class beaa
  extends amop
{
  beaa(bdzw parambdzw) {}
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Amop);
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      if (this.a.jdField_a_of_type_Beaf != null) {
        break;
      }
      bdzw.a(this.a);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate data null");
      bdzw.a(this.a);
      this.a.jdField_a_of_type_Beaf.onCreateTroopCompletely(-1, "");
      this.a.jdField_a_of_type_Beaf = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((beah)paramObject).jdField_a_of_type_Int;
      i = j;
    }
    catch (Exception paramObject)
    {
      label135:
      String str;
      break label135;
    }
    QLog.i("TroopCreateLogic", 1, "onGetTroopCreate retCode:" + i + "  currentUin:" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    bdzw.a(this.a);
    this.a.jdField_a_of_type_Beaf.onCreateTroopCompletely(i, "");
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate troopUin:" + str);
      bdzw.a(this.a);
      this.a.jdField_a_of_type_Beaf.onCreateTroopCompletely(-1, "");
      this.a.jdField_a_of_type_Beaf = null;
      return;
    }
    this.a.jdField_a_of_type_Beag.f = str;
    bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_Beag.jdField_a_of_type_Int), "", "");
    if (this.a.jdField_a_of_type_Beag.jdField_a_of_type_JavaUtilList == null)
    {
      i = 1;
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.a.jdField_a_of_type_Beag.d, "" + i, "");
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate success troopUin:" + str + " number:" + i + "  createFrom:" + this.a.jdField_a_of_type_Beag.d);
      ThreadManager.post(new TroopCreateLogic.4.1(this, str, paramObject, i), 8, null, true);
      if (this.a.jdField_a_of_type_Beag.b)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.a.a(paramObject, str);
      }
      this.a.jdField_a_of_type_Beaf.onCreateTroopCompletely(0, str);
      if (this.a.jdField_a_of_type_Beag.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label634;
      }
      ((anca)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(str, this.a.jdField_a_of_type_Beag.jdField_a_of_type_JavaUtilList, "");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Andd);
    }
    for (;;)
    {
      bdzw.a(this.a);
      return;
      i = this.a.jdField_a_of_type_Beag.jdField_a_of_type_JavaUtilList.size();
      break;
      label634:
      this.a.jdField_a_of_type_Beaf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaa
 * JD-Core Version:    0.7.0.1
 */