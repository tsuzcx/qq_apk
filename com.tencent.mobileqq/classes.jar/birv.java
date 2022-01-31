import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class birv
  implements DialogInterface.OnShowListener
{
  birv(birt parambirt, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (birt.a(this.jdField_a_of_type_Birt) != null) {
      birt.a(this.jdField_a_of_type_Birt).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      birt.a(this.jdField_a_of_type_Birt).b();
      return;
    }
    birt.a(this.jdField_a_of_type_Birt).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birv
 * JD-Core Version:    0.7.0.1
 */