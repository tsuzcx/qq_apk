import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class azfh
  implements DialogInterface.OnClickListener
{
  public azfh(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b.get(this.jdField_a_of_type_Int);
    long l = Long.parseLong((String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c.get(this.jdField_a_of_type_Int));
    ajti localajti = (ajti)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.a(2);
    if (localajti != null) {
      localajti.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.app.getCurrentAccountUin(), paramDialogInterface, l);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfh
 * JD-Core Version:    0.7.0.1
 */