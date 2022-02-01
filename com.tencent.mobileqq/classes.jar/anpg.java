import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;

class anpg
  implements DialogInterface.OnClickListener
{
  anpg(anpe paramanpe, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131690099), 0).b(0);
    if (anpe.a(this.jdField_a_of_type_Anpe))
    {
      anpe.a(this.jdField_a_of_type_Anpe, 1);
      anpe.b(this.jdField_a_of_type_Anpe);
      this.jdField_a_of_type_Anpe.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpg
 * JD-Core Version:    0.7.0.1
 */