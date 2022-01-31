import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;

public class azeg
  implements DialogInterface.OnClickListener
{
  public azeg(QLifeCommentActivity paramQLifeCommentActivity, bbgu parambbgu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing())) {
      this.jdField_a_of_type_Bbgu.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azeg
 * JD-Core Version:    0.7.0.1
 */