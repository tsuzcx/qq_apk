import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class bjxl
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bjxl(bjxd parambjxd, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = bjvg.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bjxd.a(this.b);
    bjvg.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxl
 * JD-Core Version:    0.7.0.1
 */