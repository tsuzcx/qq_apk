import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class bbve
  implements CompoundButton.OnCheckedChangeListener
{
  bbve(bbvd parambbvd, bbvh parambbvh) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Bbvh.a).troopuin.equals(bbvd.a(this.jdField_a_of_type_Bbvd)))) {
      this.jdField_a_of_type_Bbvh.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbve
 * JD-Core Version:    0.7.0.1
 */