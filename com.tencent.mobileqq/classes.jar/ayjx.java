import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class ayjx
  implements DialogInterface.OnClickListener
{
  ayjx(ayjt paramayjt, aylx paramaylx, ayka paramayka) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Ayjt.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_Ayjt.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131700527), 0).a();
      return;
    }
    ((ayks)this.jdField_a_of_type_Ayjt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.jdField_a_of_type_Aylx.c, this.jdField_a_of_type_Aylx.a, this.jdField_a_of_type_Aylx.d, new ayjy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjx
 * JD-Core Version:    0.7.0.1
 */