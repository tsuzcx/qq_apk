import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class bkja
  implements DialogInterface.OnShowListener
{
  bkja(bkiy parambkiy, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (bkiy.a(this.jdField_a_of_type_Bkiy) != null) {
      bkiy.a(this.jdField_a_of_type_Bkiy).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bkiy.a(this.jdField_a_of_type_Bkiy).b();
      return;
    }
    bkiy.a(this.jdField_a_of_type_Bkiy).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkja
 * JD-Core Version:    0.7.0.1
 */