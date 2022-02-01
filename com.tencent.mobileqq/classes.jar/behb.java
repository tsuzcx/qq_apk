import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class behb
{
  public TroopFileTransferManager.Item a;
  public String a;
  zrw jdField_a_of_type_Zrw = new behd(this);
  zsb jdField_a_of_type_Zsb = new behc(this);
  public long d;
  
  protected behb(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static behb a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      befc.a("TroopFileUploadFeedsSender", befc.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      befc.a("TroopFileUploadFeedsSender", befc.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      befc.a("TroopFileUploadFeedsSender", befc.a, "getSender. item.id=null");
    }
    return new behb(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileUploadFeedsSender", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    befc.c("TroopFileUploadFeedsSender", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    zrj.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Zsb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behb
 * JD-Core Version:    0.7.0.1
 */