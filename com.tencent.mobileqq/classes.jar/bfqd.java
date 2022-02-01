import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfqd
  implements CompoundButton.OnCheckedChangeListener
{
  bfqd(bfqc parambfqc, bfqg parambfqg) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Bfqg.a).troopuin.equals(bfqc.a(this.jdField_a_of_type_Bfqc)))) {
      this.jdField_a_of_type_Bfqg.b = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqd
 * JD-Core Version:    0.7.0.1
 */