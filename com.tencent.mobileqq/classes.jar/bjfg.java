import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjfg
  implements CompoundButton.OnCheckedChangeListener
{
  bjfg(bjff parambjff, bjcg parambjcg) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bjcg.b = paramBoolean;
    this.jdField_a_of_type_Bjff.notifyDataSetChanged();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfg
 * JD-Core Version:    0.7.0.1
 */