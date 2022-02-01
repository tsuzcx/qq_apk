import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bfxq
{
  aavj jdField_a_of_type_Aavj = new bfxs(this);
  aavo jdField_a_of_type_Aavo = new bfxr(this);
  public TroopFileTransferManager.Item a;
  public String a;
  public long d;
  
  protected bfxq(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static bfxq a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "getSender. item.id=null");
    }
    return new bfxq(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    bfvr.c("TroopFileUploadFeedsSender", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    aauw.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Aavo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxq
 * JD-Core Version:    0.7.0.1
 */