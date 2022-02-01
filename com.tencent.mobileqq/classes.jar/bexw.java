import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bexw
{
  aarg jdField_a_of_type_Aarg = new bexy(this);
  aarl jdField_a_of_type_Aarl = new bexx(this);
  public TroopFileTransferManager.Item a;
  public String a;
  public long d;
  
  protected bexw(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static bexw a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bevx.a("TroopFileUploadFeedsSender", bevx.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bevx.a("TroopFileUploadFeedsSender", bevx.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bevx.a("TroopFileUploadFeedsSender", bevx.a, "getSender. item.id=null");
    }
    return new bexw(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = bevv.a();
    if (localQQAppInterface == null)
    {
      bevx.a("TroopFileUploadFeedsSender", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    bevx.c("TroopFileUploadFeedsSender", bevx.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    aaqt.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Aarl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexw
 * JD-Core Version:    0.7.0.1
 */