import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class blxa
  implements DialogInterface.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  private blxa(blwy paramblwy, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Blwy.cancelInstall(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxa
 * JD-Core Version:    0.7.0.1
 */