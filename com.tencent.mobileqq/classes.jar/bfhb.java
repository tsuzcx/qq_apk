import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.widget.AdapterView;

public class bfhb
  implements bljo
{
  public bfhb(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Int = paramInt;
      if (this.a.jdField_a_of_type_Aksb != null) {
        this.a.jdField_a_of_type_Aksb.b(paramInt);
      }
      if (!this.a.c) {
        bdll.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.jdField_a_of_type_JavaLangString, "0", "", "");
      }
      while (TroopAvatarWallEditActivity.a(this.a) != null)
      {
        TroopAvatarWallEditActivity.a(this.a).a(paramInt);
        return;
        bdll.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.jdField_a_of_type_JavaLangString, "1", "", "");
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhb
 * JD-Core Version:    0.7.0.1
 */