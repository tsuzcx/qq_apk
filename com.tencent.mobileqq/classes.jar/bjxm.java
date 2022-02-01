import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class bjxm
  implements DialogInterface.OnClickListener
{
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public bjxm(bjxd parambjxd, DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = bjvg.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(paramDialogInterface, paramInt);
    }
    this.jdField_a_of_type_Bjxd.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo = null;
    bjvg.a("710", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxm
 * JD-Core Version:    0.7.0.1
 */