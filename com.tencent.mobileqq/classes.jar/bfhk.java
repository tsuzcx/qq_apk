import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class bfhk
  implements DialogInterface.OnClickListener
{
  public bfhk(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b.get(this.jdField_a_of_type_Int);
    long l = Long.parseLong((String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c.get(this.jdField_a_of_type_Int));
    anum localanum = (anum)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.a(2);
    if (localanum != null) {
      localanum.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getCurrentAccountUin(), paramDialogInterface, l);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhk
 * JD-Core Version:    0.7.0.1
 */