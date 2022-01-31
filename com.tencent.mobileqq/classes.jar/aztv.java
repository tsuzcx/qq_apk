import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class aztv
{
  protected long a;
  protected azsh a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  xba a;
  
  private aztv(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Xba = new aztw(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static aztv a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      azst.a("TroopFilePreviewWorker", azst.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azst.a("TroopFilePreviewWorker", azst.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopFilePreviewWorker", azst.a, "getWoker. item.id=null");
      return null;
    }
    return new aztv(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFilePreviewWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    azst.c("TroopFilePreviewWorker", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Azsh = xam.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Xba);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztv
 * JD-Core Version:    0.7.0.1
 */