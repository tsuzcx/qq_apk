import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;

class baty
  implements bfoq
{
  baty(batu parambatu) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + paramInt);
    }
    this.a.jdField_b_of_type_Boolean = true;
    switch (paramInt)
    {
    default: 
      this.a.b(false);
      this.a.jdField_a_of_type_Int = -1;
      this.a.jdField_b_of_type_Int = -1;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Bfol.dismiss();
      return;
      this.a.b(true);
      this.a.jdField_b_of_type_Int = 1;
      batu.a(this.a);
      continue;
      this.a.b(true);
      this.a.jdField_b_of_type_Int = 0;
      batu.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baty
 * JD-Core Version:    0.7.0.1
 */