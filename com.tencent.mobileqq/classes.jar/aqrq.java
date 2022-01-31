import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class aqrq
  implements DialogInterface.OnClickListener
{
  aqrq(aqrp paramaqrp, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(this.jdField_a_of_type_Aqrp.a, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    new bboe(this.jdField_a_of_type_Long, this.jdField_a_of_type_Aqrp.a, this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrq
 * JD-Core Version:    0.7.0.1
 */