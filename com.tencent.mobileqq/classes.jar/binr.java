import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class binr
  implements CompoundButton.OnCheckedChangeListener
{
  binr(binq parambinq, bikw parambikw) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bikw.b = paramBoolean;
    this.jdField_a_of_type_Binq.notifyDataSetChanged();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binr
 * JD-Core Version:    0.7.0.1
 */