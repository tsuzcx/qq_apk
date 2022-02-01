import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class ayqk
  implements DialogInterface.OnClickListener
{
  ayqk(ayqg paramayqg, aysk paramaysk, ayqn paramayqn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bhnv.g(this.jdField_a_of_type_Ayqg.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_Ayqg.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131699941), 0).a();
      return;
    }
    ((ayrf)this.jdField_a_of_type_Ayqg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Aysk.c, this.jdField_a_of_type_Aysk.a, this.jdField_a_of_type_Aysk.d, new ayql(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqk
 * JD-Core Version:    0.7.0.1
 */