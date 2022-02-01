import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class bpqc
  implements DialogInterface.OnShowListener
{
  bpqc(bpqa parambpqa, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (bpqa.a(this.jdField_a_of_type_Bpqa) != null) {
      bpqa.a(this.jdField_a_of_type_Bpqa).onShow(paramDialogInterface);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bpqa.a(this.jdField_a_of_type_Bpqa).b();
      return;
    }
    bpqa.a(this.jdField_a_of_type_Bpqa).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqc
 * JD-Core Version:    0.7.0.1
 */