import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class asca
  implements bhqd
{
  public asca(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Bhpy != null) {
        this.a.jdField_a_of_type_Bhpy.dismiss();
      }
      this.a.o();
      return;
      this.a.p();
      continue;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
      }
      if ((bdee.d(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        asbl.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131694764), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asca
 * JD-Core Version:    0.7.0.1
 */