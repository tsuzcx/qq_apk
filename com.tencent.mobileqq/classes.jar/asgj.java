import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class asgj
  implements bhuk
{
  public asgj(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Bhuf != null) {
        this.a.jdField_a_of_type_Bhuf.dismiss();
      }
      this.a.o();
      return;
      this.a.p();
      continue;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
      }
      if ((bdin.d(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        asfu.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131694766), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgj
 * JD-Core Version:    0.7.0.1
 */