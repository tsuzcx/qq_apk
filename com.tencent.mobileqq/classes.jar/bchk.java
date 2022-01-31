import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class bchk
  implements DialogInterface.OnClickListener
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bchk(bchb parambchb, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = bcfb.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(paramDialogInterface, paramInt);
    }
    this.jdField_a_of_type_Bchb.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_Bchb.jdField_a_of_type_Bchm = null;
    bcfb.a("710", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchk
 * JD-Core Version:    0.7.0.1
 */