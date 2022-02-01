import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhuf
  implements CompoundButton.OnCheckedChangeListener
{
  bhuf(bhue parambhue, bhrj parambhrj) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhrj.b = paramBoolean;
    this.jdField_a_of_type_Bhue.notifyDataSetChanged();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuf
 * JD-Core Version:    0.7.0.1
 */