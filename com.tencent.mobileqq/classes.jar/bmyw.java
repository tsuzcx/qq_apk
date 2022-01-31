import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class bmyw
  implements DialogInterface.OnShowListener
{
  bmyw(bmyu parambmyu, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (bmyu.a(this.jdField_a_of_type_Bmyu) != null) {
      bmyu.a(this.jdField_a_of_type_Bmyu).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bmyu.a(this.jdField_a_of_type_Bmyu).b();
      return;
    }
    bmyu.a(this.jdField_a_of_type_Bmyu).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyw
 * JD-Core Version:    0.7.0.1
 */