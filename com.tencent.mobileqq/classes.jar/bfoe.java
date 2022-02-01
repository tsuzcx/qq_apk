import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bfoe
{
  aahi jdField_a_of_type_Aahi = new bfog(this);
  aahn jdField_a_of_type_Aahn = new bfof(this);
  public TroopFileTransferManager.Item a;
  public String a;
  public long d;
  
  protected bfoe(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static bfoe a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "getSender. item.id=null");
    }
    return new bfoe(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    bfmf.c("TroopFileUploadFeedsSender", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    aagu.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Aahn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoe
 * JD-Core Version:    0.7.0.1
 */