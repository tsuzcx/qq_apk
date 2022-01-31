import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

class apam
  implements DialogInterface.OnClickListener
{
  apam(apah paramapah) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Apll != null) {
      this.a.jdField_a_of_type_Apll.a(false);
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramDialogInterface = (apaf)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDialogInterface != null) {
        paramDialogInterface.aC_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apam
 * JD-Core Version:    0.7.0.1
 */