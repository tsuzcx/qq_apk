import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bewy
{
  protected long a;
  aark a;
  protected bevk a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  private bewy(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Aark = new bewz(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static bewy a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bevx.a("TroopFilePreviewWorker", bevx.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bevx.a("TroopFilePreviewWorker", bevx.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bevx.a("TroopFilePreviewWorker", bevx.a, "getWoker. item.id=null");
      return null;
    }
    return new bewy(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopFilePreviewWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    bevx.c("TroopFilePreviewWorker", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Bevk = aaqt.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Aark);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewy
 * JD-Core Version:    0.7.0.1
 */