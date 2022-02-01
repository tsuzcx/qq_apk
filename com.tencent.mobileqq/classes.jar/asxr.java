import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class asxr
  implements DialogInterface.OnClickListener
{
  asxr(asxp paramasxp, List paramList, asxo paramasxo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      asxp.a(this.jdField_a_of_type_Asxp, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Asxo != null) {
        this.jdField_a_of_type_Asxo.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_Asxo == null) {
      return;
    }
    this.jdField_a_of_type_Asxo.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxr
 * JD-Core Version:    0.7.0.1
 */