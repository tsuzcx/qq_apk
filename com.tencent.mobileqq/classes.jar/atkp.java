import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class atkp
  implements DialogInterface.OnClickListener
{
  atkp(atko paramatko, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(this.jdField_a_of_type_Atko.a, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    new bfis(this.jdField_a_of_type_Long, this.jdField_a_of_type_Atko.a, this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkp
 * JD-Core Version:    0.7.0.1
 */