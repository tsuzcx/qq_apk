import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqig
  implements AdapterView.OnItemClickListener
{
  public aqig(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    paramAdapterView = (aszt)this.a.jdField_a_of_type_Aszq.a(paramInt);
    if (paramAdapterView.jdField_a_of_type_Int == 1)
    {
      this.a.a(this.a.jdField_a_of_type_Aszq.a());
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    }
    switch (paramAdapterView.jdField_a_of_type_Int)
    {
    default: 
      label96:
      atbr.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "click_op_button", paramAdapterView.jdField_a_of_type_Int);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "onItemClick:" + paramAdapterView.jdField_c_of_type_JavaLangString + ", " + paramAdapterView.jdField_a_of_type_JavaLangString);
      }
      if ((paramAdapterView.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(paramAdapterView.e)) && (this.a.getActivity() != null) && (bbfr.a(this.a.getActivity(), paramAdapterView.e)) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
        if (TextUtils.isEmpty(paramAdapterView.d)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView.d));
        paramView.setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity(paramView);
        if (bool) {
          break;
        }
        this.a.a(paramAdapterView);
      }
      catch (Exception paramView)
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "jump to app with scheme Excepyion e = " + paramView.getMessage());
        bool = false;
        continue;
      }
      bool = bbfr.a(this.a.getActivity(), paramAdapterView.e, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      continue;
      paramView.a(39);
      break label96;
      paramView.a(25);
      break label96;
      paramView.a(23);
      paramView.a(26);
      break label96;
      paramView.a(40);
      break label96;
      if (this.a.jdField_a_of_type_Aszq == null) {
        break label96;
      }
      this.a.jdField_a_of_type_Aszq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      break label96;
      paramView.a(41);
      break label96;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqig
 * JD-Core Version:    0.7.0.1
 */