import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfzs
  implements CompoundButton.OnCheckedChangeListener
{
  bfzs(bfzr parambfzr, bfzv parambfzv) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Bfzv.a).troopuin.equals(bfzr.a(this.jdField_a_of_type_Bfzr)))) {
      this.jdField_a_of_type_Bfzv.b = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzs
 * JD-Core Version:    0.7.0.1
 */