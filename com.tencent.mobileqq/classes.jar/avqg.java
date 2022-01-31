import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class avqg
  implements DialogInterface.OnClickListener
{
  avqg(avqc paramavqc, avsg paramavsg, avqj paramavqj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdin.g(this.jdField_a_of_type_Avqc.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_Avqc.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131701410), 0).a();
      return;
    }
    ((avrb)this.jdField_a_of_type_Avqc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Avsg.c, this.jdField_a_of_type_Avsg.a, this.jdField_a_of_type_Avsg.d, new avqh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqg
 * JD-Core Version:    0.7.0.1
 */