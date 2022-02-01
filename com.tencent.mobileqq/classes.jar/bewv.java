import android.view.View;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class bewv
  implements AdapterView.OnItemSelectedListener
{
  public bewv(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Int = paramInt;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onItemSelect(paramInt);
      }
      if (!this.a.c) {
        bdla.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.jdField_a_of_type_JavaLangString, "0", "", "");
      }
      while (TroopAvatarWallEditActivity.a(this.a) != null)
      {
        TroopAvatarWallEditActivity.a(this.a).a(paramInt);
        return;
        bdla.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.jdField_a_of_type_JavaLangString, "1", "", "");
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewv
 * JD-Core Version:    0.7.0.1
 */