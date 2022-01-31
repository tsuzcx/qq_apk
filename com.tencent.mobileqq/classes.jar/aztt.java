import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class aztt
{
  protected long a;
  protected azsf a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  xbd a;
  
  private aztt(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Xbd = new aztu(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static aztt a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      azsr.a("TroopFilePreviewWorker", azsr.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azsr.a("TroopFilePreviewWorker", azsr.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azsr.a("TroopFilePreviewWorker", azsr.a, "getWoker. item.id=null");
      return null;
    }
    return new aztt(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopFilePreviewWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    azsr.c("TroopFilePreviewWorker", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Azsf = xap.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Xbd);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztt
 * JD-Core Version:    0.7.0.1
 */