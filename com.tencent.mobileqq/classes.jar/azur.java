import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class azur
{
  public TroopFileTransferManager.Item a;
  public String a;
  xay jdField_a_of_type_Xay = new azut(this);
  xbe jdField_a_of_type_Xbe = new azus(this);
  public long d;
  
  protected azur(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.d = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static azur a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      azsr.a("TroopFileUploadFeedsSender", azsr.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azsr.a("TroopFileUploadFeedsSender", azsr.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      azsr.a("TroopFileUploadFeedsSender", azsr.a, "getSender. item.id=null");
    }
    return new azur(paramLong, paramItem);
  }
  
  public long a()
  {
    return this.d;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void j()
  {
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopFileUploadFeedsSender", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    azsr.c("TroopFileUploadFeedsSender", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    xap.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Xbe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azur
 * JD-Core Version:    0.7.0.1
 */