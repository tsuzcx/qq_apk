import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class baun
  extends akil
{
  baun(baui parambaui) {}
  
  public void a(boolean paramBoolean, bauh parambauh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (parambauh == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(parambauh.jdField_a_of_type_JavaLangString))) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    label423:
    label604:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.jdField_b_of_type_Int != -1))
      {
        if ((!paramBoolean) || (parambauh.jdField_a_of_type_Int != 0)) {
          break label423;
        }
        if (parambauh.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_JavaLangString = parambauh.jdField_b_of_type_JavaLangString;
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
          this.a.jdField_b_of_type_JavaLangString = parambauh.jdField_b_of_type_JavaLangString;
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
        baui.b(this.a);
        continue;
        this.a.b();
        baui.c(this.a);
        continue;
        this.a.c = bahv.a("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        baui.d(this.a);
        continue;
        this.a.b();
        baui.e(this.a);
        continue;
        this.a.b();
        baui.f(this.a);
        continue;
        if ((parambauh.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 0))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if ((!parambauh.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 1))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if (this.a.jdField_a_of_type_Baur != null) {
          this.a.jdField_a_of_type_Baur.a(this.a.jdField_a_of_type_Int, false);
        }
        this.a.b();
        bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693033), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.jdField_b_of_type_Int = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baun
 * JD-Core Version:    0.7.0.1
 */