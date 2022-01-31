import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class bfkw
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bfkw(bfko parambfko, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bfip.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bfko.a(this.b);
    bfip.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkw
 * JD-Core Version:    0.7.0.1
 */