import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bgue
  extends bjyh
{
  bgue(bgua parambgua) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.a.jdField_a_of_type_Bjyh);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    while ((this.a.jdField_a_of_type_Bisl == null) || (!this.a.jdField_a_of_type_Bisl.isShowing()) || (this.a.jdField_a_of_type_Int == -1) || (this.a.b == -1)) {
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
        this.a.c = bghb.a("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        bgua.e(this.a);
        return;
      case 3: 
        this.a.b();
        bgua.c(this.a);
        return;
      case 2: 
        this.a.b();
        bgua.d(this.a);
        return;
      case 1: 
        this.a.b();
        bgua.f(this.a);
        return;
      }
      this.a.b();
      bgua.g(this.a);
      return;
    }
    if (this.a.jdField_a_of_type_Bguh != null) {
      this.a.jdField_a_of_type_Bguh.onShareResp(this.a.jdField_a_of_type_Int, false);
    }
    this.a.b();
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692824), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgue
 * JD-Core Version:    0.7.0.1
 */