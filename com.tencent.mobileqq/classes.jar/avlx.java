import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class avlx
  implements DialogInterface.OnClickListener
{
  avlx(avlt paramavlt, avnx paramavnx, avma paramavma) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdee.g(this.jdField_a_of_type_Avlt.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_Avlt.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131701398), 0).a();
      return;
    }
    ((avms)this.jdField_a_of_type_Avlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Avnx.c, this.jdField_a_of_type_Avnx.a, this.jdField_a_of_type_Avnx.d, new avly(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlx
 * JD-Core Version:    0.7.0.1
 */