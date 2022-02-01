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

public class aumr
  implements AdapterView.OnItemClickListener
{
  public aumr(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    axcm localaxcm = (axcm)this.a.jdField_a_of_type_Axcj.a(paramInt);
    Object localObject;
    if (localaxcm.jdField_a_of_type_Int == 1)
    {
      this.a.a(this.a.jdField_a_of_type_Axcj.a());
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    }
    switch (localaxcm.jdField_a_of_type_Int)
    {
    default: 
      label100:
      axei.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "click_op_button", localaxcm.jdField_a_of_type_Int);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "onItemClick:" + localaxcm.jdField_c_of_type_JavaLangString + ", " + localaxcm.jdField_a_of_type_JavaLangString);
      }
      if ((localaxcm.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(localaxcm.e)) && (this.a.getActivity() != null) && (bgnw.a(this.a.getActivity(), localaxcm.e)) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
        if (TextUtils.isEmpty(localaxcm.d)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(localaxcm.d));
        ((Intent)localObject).setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
        if (bool) {
          break;
        }
        this.a.a(localaxcm);
      }
      catch (Exception localException)
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "jump to app with scheme Excepyion e = " + localException.getMessage());
        bool = false;
        continue;
      }
      bool = bgnw.a(this.a.getActivity(), localaxcm.e, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
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
      if (this.a.jdField_a_of_type_Axcj == null) {
        break label100;
      }
      this.a.jdField_a_of_type_Axcj.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      break label100;
      localException.a(41);
      break label100;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumr
 * JD-Core Version:    0.7.0.1
 */