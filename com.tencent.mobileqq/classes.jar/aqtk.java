import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

class aqtk
  implements DialogInterface.OnClickListener
{
  aqtk(aqtf paramaqtf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Arek != null) {
      this.a.jdField_a_of_type_Arek.a(false);
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramDialogInterface = (aqtd)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDialogInterface != null) {
        paramDialogInterface.aJ_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtk
 * JD-Core Version:    0.7.0.1
 */