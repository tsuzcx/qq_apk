import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class bbzn
  implements CompoundButton.OnCheckedChangeListener
{
  bbzn(bbzm parambbzm, bbzq parambbzq) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Bbzq.a).troopuin.equals(bbzm.a(this.jdField_a_of_type_Bbzm)))) {
      this.jdField_a_of_type_Bbzq.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzn
 * JD-Core Version:    0.7.0.1
 */