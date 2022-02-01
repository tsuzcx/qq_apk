import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class bqrx
  implements DialogInterface.OnShowListener
{
  bqrx(bqrv parambqrv, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (bqrv.a(this.jdField_a_of_type_Bqrv) != null) {
      bqrv.a(this.jdField_a_of_type_Bqrv).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bqrv.a(this.jdField_a_of_type_Bqrv).b();
      return;
    }
    bqrv.a(this.jdField_a_of_type_Bqrv).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqrx
 * JD-Core Version:    0.7.0.1
 */