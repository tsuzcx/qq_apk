import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class bmuk
  implements DialogInterface.OnShowListener
{
  bmuk(bmui parambmui, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (bmui.a(this.jdField_a_of_type_Bmui) != null) {
      bmui.a(this.jdField_a_of_type_Bmui).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bmui.a(this.jdField_a_of_type_Bmui).b();
      return;
    }
    bmui.a(this.jdField_a_of_type_Bmui).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuk
 * JD-Core Version:    0.7.0.1
 */