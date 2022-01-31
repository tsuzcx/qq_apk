import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class azut
{
  public TroopFileTransferManager.Item a;
  public String a;
  xav jdField_a_of_type_Xav = new azuv(this);
  xbb jdField_a_of_type_Xbb = new azuu(this);
  public long d;
  
  protected azut(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static azut a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      azst.a("TroopFileUploadFeedsSender", azst.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azst.a("TroopFileUploadFeedsSender", azst.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      azst.a("TroopFileUploadFeedsSender", azst.a, "getSender. item.id=null");
    }
    return new azut(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileUploadFeedsSender", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    azst.c("TroopFileUploadFeedsSender", azst.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    xam.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Xbb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azut
 * JD-Core Version:    0.7.0.1
 */