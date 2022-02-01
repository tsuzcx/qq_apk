import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class amjt
  extends Handler
{
  public amjt(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      QQToast.a(BaseApplication.getContext(), 1, 2131693965, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bjbs == null) {
        this.a.jdField_a_of_type_Bjbs = new bjbs(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bjbs.c(2131698420);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bjbs.isShowing()));
    this.a.jdField_a_of_type_Bjbs.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjt
 * JD-Core Version:    0.7.0.1
 */