import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class bchj
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bchj(bchb parambchb, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bcfb.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    bchb.a(this.b);
    bcfb.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchj
 * JD-Core Version:    0.7.0.1
 */