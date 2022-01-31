import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class batz
  extends akim
{
  batz(batu parambatu) {}
  
  public void a(boolean paramBoolean, batt parambatt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (parambatt == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(parambatt.jdField_a_of_type_JavaLangString))) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    label423:
    label604:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Bcpq != null) && (this.a.jdField_a_of_type_Bcpq.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.jdField_b_of_type_Int != -1))
      {
        if ((!paramBoolean) || (parambatt.jdField_a_of_type_Int != 0)) {
          break label423;
        }
        if (parambatt.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_JavaLangString = parambatt.jdField_b_of_type_JavaLangString;
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
          this.a.jdField_b_of_type_JavaLangString = parambatt.jdField_b_of_type_JavaLangString;
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
        batu.b(this.a);
        continue;
        this.a.b();
        batu.c(this.a);
        continue;
        this.a.c = bahh.a("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        batu.d(this.a);
        continue;
        this.a.b();
        batu.e(this.a);
        continue;
        this.a.b();
        batu.f(this.a);
        continue;
        if ((parambatt.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 0))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if ((!parambatt.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 1))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if (this.a.jdField_a_of_type_Baud != null) {
          this.a.jdField_a_of_type_Baud.a(this.a.jdField_a_of_type_Int, false);
        }
        this.a.b();
        bcpw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693032), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.jdField_b_of_type_Int = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batz
 * JD-Core Version:    0.7.0.1
 */