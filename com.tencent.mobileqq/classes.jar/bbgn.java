import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;

public class bbgn
  implements DialogInterface.OnClickListener
{
  public bbgn(QLifeCommentActivity paramQLifeCommentActivity, bdjz parambdjz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.cancel();
    }
    QLifeCommentActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity);
    azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgn
 * JD-Core Version:    0.7.0.1
 */