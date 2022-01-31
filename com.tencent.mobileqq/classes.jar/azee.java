import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;

public class azee
  implements DialogInterface.OnClickListener
{
  public azee(QLifeCommentActivity paramQLifeCommentActivity, bbgg parambbgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azee
 * JD-Core Version:    0.7.0.1
 */