import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class axds
  implements DialogInterface.OnClickListener
{
  axds(axdo paramaxdo, axfs paramaxfs, axdv paramaxdv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Axdo.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_Axdo.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131700176), 0).a();
      return;
    }
    ((axen)this.jdField_a_of_type_Axdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.jdField_a_of_type_Axfs.c, this.jdField_a_of_type_Axfs.a, this.jdField_a_of_type_Axfs.d, new axdt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axds
 * JD-Core Version:    0.7.0.1
 */