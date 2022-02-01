import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

public class amcm
  extends Handler
{
  public amcm(SpecailCareListActivity paramSpecailCareListActivity) {}
  
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
      QQToast.a(BaseApplication.getContext(), 1, 2131694255, 0).b(this.a.getTitleBarHeight());
      return;
      if (this.a.jdField_a_of_type_Bisl == null) {
        this.a.jdField_a_of_type_Bisl = new bisl(this.a, this.a.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_Bisl.c(2131698886);
    } while ((this.a.isFinishing()) || (this.a.jdField_a_of_type_Bisl.isShowing()));
    this.a.jdField_a_of_type_Bisl.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcm
 * JD-Core Version:    0.7.0.1
 */