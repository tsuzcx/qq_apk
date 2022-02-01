import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjoq
  implements CompoundButton.OnCheckedChangeListener
{
  bjoq(bjop parambjop, bjlv parambjlv) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bjlv.b = paramBoolean;
    this.jdField_a_of_type_Bjop.notifyDataSetChanged();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoq
 * JD-Core Version:    0.7.0.1
 */