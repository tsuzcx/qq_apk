import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.widget.QQToast;

class angm
  implements DialogInterface.OnClickListener
{
  angm(angk paramangk, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131690038), 0).b(0);
    if (angk.a(this.jdField_a_of_type_Angk))
    {
      angk.a(this.jdField_a_of_type_Angk, 1);
      angk.b(this.jdField_a_of_type_Angk);
      this.jdField_a_of_type_Angk.a.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angm
 * JD-Core Version:    0.7.0.1
 */