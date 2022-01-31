import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class aytd
{
  protected long a;
  protected ayrp a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  wma a;
  
  private aytd(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Wma = new ayte(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static aytd a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      aysb.a("TroopFilePreviewWorker", aysb.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      aysb.a("TroopFilePreviewWorker", aysb.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      aysb.a("TroopFilePreviewWorker", aysb.a, "getWoker. item.id=null");
      return null;
    }
    return new aytd(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFilePreviewWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    aysb.c("TroopFilePreviewWorker", aysb.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Ayrp = wln.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Wma);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytd
 * JD-Core Version:    0.7.0.1
 */