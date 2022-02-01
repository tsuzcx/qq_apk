import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.4.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class bfqq
  extends anua
{
  bfqq(bfqm parambfqm) {}
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Anua);
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      if (this.a.jdField_a_of_type_Bfqv != null) {
        break;
      }
      bfqm.a(this.a);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate data null");
      bfqm.a(this.a);
      this.a.jdField_a_of_type_Bfqv.a(-1, "");
      this.a.jdField_a_of_type_Bfqv = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((bfqx)paramObject).jdField_a_of_type_Int;
      i = j;
    }
    catch (Exception paramObject)
    {
      label135:
      String str;
      break label135;
    }
    QLog.i("TroopCreateLogic", 1, "onGetTroopCreate retCode:" + i + "  currentUin:" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    bfqm.a(this.a);
    this.a.jdField_a_of_type_Bfqv.a(i, "");
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate troopUin:" + str);
      bfqm.a(this.a);
      this.a.jdField_a_of_type_Bfqv.a(-1, "");
      this.a.jdField_a_of_type_Bfqv = null;
      return;
    }
    this.a.jdField_a_of_type_Bfqw.f = str;
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_Bfqw.jdField_a_of_type_Int), "", "");
    if (this.a.jdField_a_of_type_Bfqw.jdField_a_of_type_JavaUtilList == null)
    {
      i = 1;
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.a.jdField_a_of_type_Bfqw.d, "" + i, "");
      QLog.i("TroopCreateLogic", 1, "onGetTroopCreate success troopUin:" + str + " number:" + i + "  createFrom:" + this.a.jdField_a_of_type_Bfqw.d);
      ThreadManager.post(new TroopCreateLogic.4.1(this, str, paramObject, i), 8, null, true);
      if (this.a.jdField_a_of_type_Bfqw.b)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.a.a(paramObject, str);
      }
      this.a.jdField_a_of_type_Bfqv.a(0, str);
      if (this.a.jdField_a_of_type_Bfqw.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label634;
      }
      ((aoip)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(str, this.a.jdField_a_of_type_Bfqw.jdField_a_of_type_JavaUtilList, "");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Aojs);
    }
    for (;;)
    {
      bfqm.a(this.a);
      return;
      i = this.a.jdField_a_of_type_Bfqw.jdField_a_of_type_JavaUtilList.size();
      break;
      label634:
      this.a.jdField_a_of_type_Bfqv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqq
 * JD-Core Version:    0.7.0.1
 */