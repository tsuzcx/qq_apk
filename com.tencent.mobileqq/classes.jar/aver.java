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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aver
  implements AdapterView.OnItemClickListener
{
  public aver(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    axvd localaxvd = (axvd)this.a.jdField_a_of_type_Axva.a(paramInt);
    Object localObject;
    if (localaxvd.jdField_a_of_type_Int == 1)
    {
      this.a.a(this.a.jdField_a_of_type_Axva.a());
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    }
    switch (localaxvd.jdField_a_of_type_Int)
    {
    default: 
      label100:
      axxb.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "click_op_button", localaxvd.jdField_a_of_type_Int);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "onItemClick:" + localaxvd.jdField_c_of_type_JavaLangString + ", " + localaxvd.jdField_a_of_type_JavaLangString);
      }
      if ((localaxvd.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(localaxvd.e)) && (this.a.getActivity() != null) && (bhny.a(this.a.getActivity(), localaxvd.e)) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
        if (TextUtils.isEmpty(localaxvd.d)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(localaxvd.d));
        ((Intent)localObject).setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
        if (bool) {
          break;
        }
        this.a.a(localaxvd);
      }
      catch (Exception localException)
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "jump to app with scheme Excepyion e = " + localException.getMessage());
        bool = false;
        continue;
      }
      bool = bhny.a(this.a.getActivity(), localaxvd.e, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      continue;
      localException.a(39);
      break label100;
      localException.a(25);
      break label100;
      localException.a(23);
      localException.a(26);
      break label100;
      localException.a(40);
      break label100;
      if (this.a.jdField_a_of_type_Axva == null) {
        break label100;
      }
      this.a.jdField_a_of_type_Axva.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      break label100;
      localException.a(41);
      break label100;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aver
 * JD-Core Version:    0.7.0.1
 */