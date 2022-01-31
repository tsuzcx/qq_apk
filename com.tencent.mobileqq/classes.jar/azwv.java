import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class azwv
  implements CompoundButton.OnCheckedChangeListener
{
  azwv(azwu paramazwu, azwy paramazwy) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Azwy.a).troopuin.equals(azwu.a(this.jdField_a_of_type_Azwu)))) {
      this.jdField_a_of_type_Azwy.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwv
 * JD-Core Version:    0.7.0.1
 */