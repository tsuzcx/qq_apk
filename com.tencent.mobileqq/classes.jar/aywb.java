import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class aywb
  implements CompoundButton.OnCheckedChangeListener
{
  aywb(aywa paramaywa, aywe paramaywe) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Aywe.a).troopuin.equals(aywa.a(this.jdField_a_of_type_Aywa)))) {
      this.jdField_a_of_type_Aywe.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aywb
 * JD-Core Version:    0.7.0.1
 */