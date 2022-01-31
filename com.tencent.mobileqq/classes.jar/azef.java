import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;

public class azef
  implements DialogInterface.OnClickListener
{
  public azef(QLifeCommentActivity paramQLifeCommentActivity, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.cancel();
    }
    QLifeCommentActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity);
    axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azef
 * JD-Core Version:    0.7.0.1
 */