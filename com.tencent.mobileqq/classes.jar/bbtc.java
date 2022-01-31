import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bbtc
{
  public TroopFileTransferManager.Item a;
  public String a;
  ypo jdField_a_of_type_Ypo = new bbte(this);
  ypu jdField_a_of_type_Ypu = new bbtd(this);
  public long d;
  
  protected bbtc(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static bbtc a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "getSender. item.id=null");
    }
    return new bbtc(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    bbrc.c("TroopFileUploadFeedsSender", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    ypf.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Ypu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtc
 * JD-Core Version:    0.7.0.1
 */