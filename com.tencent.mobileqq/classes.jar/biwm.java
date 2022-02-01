import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class biwm
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public biwm(biwe parambiwe, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = biuh.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Biwe.a(this.b);
    biuh.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwm
 * JD-Core Version:    0.7.0.1
 */