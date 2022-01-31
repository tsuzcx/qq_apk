import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class apse
  implements DialogInterface.OnClickListener
{
  apse(apsc paramapsc, List paramList, apsb paramapsb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      apsc.a(this.jdField_a_of_type_Apsc, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Apsb != null) {
        this.jdField_a_of_type_Apsb.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_Apsb == null) {
      return;
    }
    this.jdField_a_of_type_Apsb.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apse
 * JD-Core Version:    0.7.0.1
 */