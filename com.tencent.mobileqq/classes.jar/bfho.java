import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class bfho
  implements bljo
{
  public bfho(TroopAvatarWallPreviewActivity.2.1 param1) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (TroopAvatarWallPreviewActivity.a(this.a.a.this$0).isReport)
    {
      TroopAvatarWallPreviewActivity.a(this.a.a.this$0).addPicIndex(paramInt);
      paramAdapterView = TroopAvatarWallPreviewActivity.a(this.a.a.this$0);
      paramAdapterView.slide_number += 1;
    }
    this.a.a.this$0.jdField_a_of_type_Int = paramInt;
    paramAdapterView = this.a.a.this$0.jdField_a_of_type_Int + 1 + "/" + this.a.a.this$0.jdField_b_of_type_Int;
    this.a.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView);
    boolean bool1;
    if (this.a.a.this$0.c)
    {
      bdll.b(this.a.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.this$0.jdField_a_of_type_JavaLangString, "0", "", "");
      if (this.a.a.this$0.jdField_b_of_type_Boolean) {
        TroopAvatarWallPreviewActivity.a(this.a.a.this$0, this.a.a.this$0.jdField_a_of_type_Int);
      }
      boolean bool2 = this.a.a.this$0.f;
      if ((TroopAvatarWallPreviewActivity.a(this.a.a.this$0) != null) && (TroopAvatarWallPreviewActivity.a(this.a.a.this$0).getBoolean("from_personality_label", false)))
      {
        paramAdapterView = this.a.a.this$0;
        if (Long.valueOf((String)this.a.a.this$0.jdField_b_of_type_JavaUtilArrayList.get(this.a.a.this$0.jdField_a_of_type_Int)).longValue() == -1L) {
          break label530;
        }
        bool1 = true;
        label363:
        paramAdapterView.f = bool1;
      }
      if (bool2 != this.a.a.this$0.f)
      {
        paramAdapterView = this.a.a.this$0.jdField_a_of_type_AndroidWidgetImageView;
        if (!this.a.a.this$0.f) {
          break label536;
        }
      }
    }
    label530:
    label536:
    for (paramInt = 0;; paramInt = 8)
    {
      paramAdapterView.setVisibility(paramInt);
      if (this.a.a.this$0.j) {
        TroopAvatarWallPreviewActivity.b(this.a.a.this$0);
      }
      TroopAvatarWallPreviewActivity.b(this.a.a.this$0, this.a.a.this$0.jdField_a_of_type_Int);
      return;
      bdll.b(this.a.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.this$0.jdField_a_of_type_JavaLangString, "1", "", "");
      break;
      bool1 = false;
      break label363;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfho
 * JD-Core Version:    0.7.0.1
 */