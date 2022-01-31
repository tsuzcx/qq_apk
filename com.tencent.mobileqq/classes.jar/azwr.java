import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class azwr
  implements CompoundButton.OnCheckedChangeListener
{
  azwr(azwq paramazwq, azwu paramazwu) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Azwu.a).troopuin.equals(azwq.a(this.jdField_a_of_type_Azwq)))) {
      this.jdField_a_of_type_Azwu.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwr
 * JD-Core Version:    0.7.0.1
 */