import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bbxl
{
  public TroopFileTransferManager.Item a;
  public String a;
  yud jdField_a_of_type_Yud = new bbxn(this);
  yuj jdField_a_of_type_Yuj = new bbxm(this);
  public long d;
  
  protected bbxl(long paramLong, TroopFileTransferManager.Item paramItem)
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
  
  public static bbxl a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "getSender. item.id=null");
    }
    return new bbxl(paramLong, paramItem);
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
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileUploadFeedsSender", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    bbvl.c("TroopFileUploadFeedsSender", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    ytu.a(localQQAppInterface, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Yuj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxl
 * JD-Core Version:    0.7.0.1
 */