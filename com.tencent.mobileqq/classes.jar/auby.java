import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class auby
  implements DialogInterface.OnClickListener
{
  auby(aubw paramaubw, List paramList, aubv paramaubv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      aubw.a(this.jdField_a_of_type_Aubw, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Aubv != null) {
        this.jdField_a_of_type_Aubv.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_Aubv == null) {
      return;
    }
    this.jdField_a_of_type_Aubv.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auby
 * JD-Core Version:    0.7.0.1
 */