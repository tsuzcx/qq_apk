import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awll
  implements View.OnClickListener
{
  public awll(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awll
 * JD-Core Version:    0.7.0.1
 */