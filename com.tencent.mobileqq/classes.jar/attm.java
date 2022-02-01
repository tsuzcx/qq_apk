import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class attm
  implements DialogInterface.OnClickListener
{
  attm(attk paramattk, List paramList, attj paramattj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      attk.a(this.jdField_a_of_type_Attk, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Attj != null) {
        this.jdField_a_of_type_Attj.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_Attj == null) {
      return;
    }
    this.jdField_a_of_type_Attj.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attm
 * JD-Core Version:    0.7.0.1
 */