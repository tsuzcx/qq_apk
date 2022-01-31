import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;

class bbta
  implements DialogInterface.OnClickListener
{
  bbta(bbsn parambbsn, bbsa parambbsa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    TroopFileTransferManager.a(this.jdField_a_of_type_Bbsn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbsn.jdField_a_of_type_Long).a(this.jdField_a_of_type_Bbsa.jdField_a_of_type_JavaUtilUUID);
    paramDialogInterface = (bbsa)bcmu.a(this.jdField_a_of_type_Bbsn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbsn.jdField_a_of_type_Long).c.get(this.jdField_a_of_type_Bbsa.f);
    if (paramDialogInterface != null) {
      paramDialogInterface.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bbsa.b);
    }
    azqs.b(this.jdField_a_of_type_Bbsn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", this.jdField_a_of_type_Bbsn.jdField_a_of_type_Long + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbta
 * JD-Core Version:    0.7.0.1
 */