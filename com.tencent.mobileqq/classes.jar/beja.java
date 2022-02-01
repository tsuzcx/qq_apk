import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beja
  implements CompoundButton.OnCheckedChangeListener
{
  beja(beiz parambeiz, bejd parambejd) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Bejd.a).troopuin.equals(beiz.a(this.jdField_a_of_type_Beiz)))) {
      this.jdField_a_of_type_Bejd.b = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beja
 * JD-Core Version:    0.7.0.1
 */