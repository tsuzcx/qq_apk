import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bmhm
  implements DialogInterface.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  private bmhm(bmhk parambmhk, String paramString)
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
    this.jdField_a_of_type_Bmhk.cancelInstall(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhm
 * JD-Core Version:    0.7.0.1
 */