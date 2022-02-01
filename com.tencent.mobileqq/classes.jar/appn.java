import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.ARScanEntryView.27;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class appn
  implements View.OnClickListener
{
  public appn(ARScanEntryView.27 param27) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Apef != null) {
      this.a.jdField_a_of_type_Apef.a(this.a.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo);
    }
    ARScanEntryView.g(this.a.this$0);
    ARScanEntryView.d(this.a.this$0);
    this.a.this$0.a.setOnClickListener(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appn
 * JD-Core Version:    0.7.0.1
 */