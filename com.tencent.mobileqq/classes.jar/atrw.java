import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class atrw
  implements bjoe
{
  public atrw(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Bjnw != null) {
        this.a.jdField_a_of_type_Bjnw.dismiss();
      }
      this.a.o();
      return;
      this.a.p();
      continue;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b();
      }
      if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
      {
        atrh.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131694062), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */