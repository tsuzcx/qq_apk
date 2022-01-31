import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

class aojo
  implements DialogInterface.OnClickListener
{
  aojo(aojj paramaojj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_Aotv != null) {
      this.a.jdField_a_of_type_Aotv.a(false);
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramDialogInterface = (aojh)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDialogInterface != null) {
        paramDialogInterface.aF_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aojo
 * JD-Core Version:    0.7.0.1
 */