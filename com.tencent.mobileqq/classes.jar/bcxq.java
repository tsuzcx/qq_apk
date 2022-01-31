import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bcxq
  extends ameq
{
  bcxq(bcxl parambcxl) {}
  
  public void a(boolean paramBoolean, bcxk parambcxk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (parambcxk == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(parambcxk.jdField_a_of_type_JavaLangString))) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    label423:
    label604:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Bety != null) && (this.a.jdField_a_of_type_Bety.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.jdField_b_of_type_Int != -1))
      {
        if ((!paramBoolean) || (parambcxk.jdField_a_of_type_Int != 0)) {
          break label423;
        }
        if (parambcxk.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_JavaLangString = parambcxk.jdField_b_of_type_JavaLangString;
          if (this.a.jdField_b_of_type_Int != 0)
          {
            if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        else
        {
          this.a.jdField_b_of_type_JavaLangString = parambcxk.jdField_b_of_type_JavaLangString;
          if (this.a.jdField_b_of_type_Int != 1)
          {
            if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
            return;
          }
        }
        switch (this.a.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break label604;
        }
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
        this.a.b();
        bcxl.b(this.a);
        continue;
        this.a.b();
        bcxl.c(this.a);
        continue;
        this.a.c = bckq.a("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        bcxl.d(this.a);
        continue;
        this.a.b();
        bcxl.e(this.a);
        continue;
        this.a.b();
        bcxl.f(this.a);
        continue;
        if ((parambcxk.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 0))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if ((!parambcxk.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 1))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if (this.a.jdField_a_of_type_Bcxu != null) {
          this.a.jdField_a_of_type_Bcxu.a(this.a.jdField_a_of_type_Int, false);
        }
        this.a.b();
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693136), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.jdField_b_of_type_Int = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxq
 * JD-Core Version:    0.7.0.1
 */