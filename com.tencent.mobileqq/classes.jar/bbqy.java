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

public class bbqy
  extends alpa
{
  bbqy(bbqu parambbqu) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Alpa);
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      if (this.a.jdField_a_of_type_Bbrd != null) {
        break;
      }
      bbqu.a(this.a);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate data null");
      bbqu.a(this.a);
      this.a.jdField_a_of_type_Bbrd.a(-1, "");
      this.a.jdField_a_of_type_Bbrd = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((bbrf)paramObject).jdField_a_of_type_Int;
      i = j;
    }
    catch (Exception paramObject)
    {
      label135:
      String str;
      break label135;
    }
    QLog.i("TroopCreateLogic", 1, "onGetTroopCreate retCode:" + i + "  currentUin:" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    bbqu.a(this.a);
    this.a.jdField_a_of_type_Bbrd.a(i, "");
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate troopUin:" + str);
      bbqu.a(this.a);
      this.a.jdField_a_of_type_Bbrd.a(-1, "");
      this.a.jdField_a_of_type_Bbrd = null;
      return;
    }
    this.a.jdField_a_of_type_Bbre.f = str;
    azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_Bbre.jdField_a_of_type_Int), "", "");
    if (this.a.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList == null)
    {
      i = 1;
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.a.jdField_a_of_type_Bbre.d, "" + i, "");
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate success troopUin:" + str + " number:" + i + "  createFrom:" + this.a.jdField_a_of_type_Bbre.d);
      ThreadManager.post(new TroopCreateLogic.4.1(this, str, paramObject, i), 8, null, true);
      if (this.a.jdField_a_of_type_Bbre.b)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.a.a(paramObject, str);
      }
      this.a.jdField_a_of_type_Bbrd.a(0, str);
      if (this.a.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label630;
      }
      ((amdu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(str, this.a.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList, "");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
    }
    for (;;)
    {
      bbqu.a(this.a);
      return;
      i = this.a.jdField_a_of_type_Bbre.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label630:
      this.a.jdField_a_of_type_Bbrd = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqy
 * JD-Core Version:    0.7.0.1
 */