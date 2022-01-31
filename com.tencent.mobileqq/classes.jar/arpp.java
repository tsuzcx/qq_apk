import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class arpp
  implements DialogInterface.OnClickListener
{
  arpp(arpn paramarpn, List paramList, arpm paramarpm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      arpn.a(this.jdField_a_of_type_Arpn, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Arpm != null) {
        this.jdField_a_of_type_Arpm.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_Arpm == null) {
      return;
    }
    this.jdField_a_of_type_Arpm.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpp
 * JD-Core Version:    0.7.0.1
 */