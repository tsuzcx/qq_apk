import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bcxr
  extends bfzo
{
  bcxr(bcxl parambcxl) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    while ((this.a.jdField_a_of_type_Bety == null) || (!this.a.jdField_a_of_type_Bety.isShowing()) || (this.a.jdField_a_of_type_Int == -1) || (this.a.b == -1)) {
      return;
    }
    if ((paramBoolean) && (paramHashMap != null))
    {
      String str = (String)paramHashMap.get("uin");
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(str))
      {
        this.a.b();
        return;
      }
      paramHashMap = (String)paramHashMap.get("url");
      this.a.jdField_a_of_type_JavaLangString = paramHashMap;
      switch (this.a.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
        this.a.c = bckq.a("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        bcxl.d(this.a);
        return;
      case 3: 
        this.a.b();
        bcxl.b(this.a);
        return;
      case 2: 
        this.a.b();
        bcxl.c(this.a);
        return;
      case 1: 
        this.a.b();
        bcxl.e(this.a);
        return;
      }
      this.a.b();
      bcxl.f(this.a);
      return;
    }
    if (this.a.jdField_a_of_type_Bcxu != null) {
      this.a.jdField_a_of_type_Bcxu.a(this.a.jdField_a_of_type_Int, false);
    }
    this.a.b();
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693136), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxr
 * JD-Core Version:    0.7.0.1
 */