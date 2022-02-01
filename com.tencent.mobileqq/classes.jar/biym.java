import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class biym
  implements View.OnClickListener
{
  biym(biyl parambiyl, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Biyl.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biym
 * JD-Core Version:    0.7.0.1
 */