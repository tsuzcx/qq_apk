import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqha
  implements View.OnClickListener
{
  aqha(aqgz paramaqgz, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (aqgz.a(this.jdField_a_of_type_Aqgz) != this.jdField_a_of_type_Int)
    {
      aqgz.a(this.jdField_a_of_type_Aqgz, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aqgz.notifyDataSetChanged();
    }
    azcl.a("0X800ADEB");
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { "[action] bindItemClickListener: invoked. ", " position: ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqha
 * JD-Core Version:    0.7.0.1
 */