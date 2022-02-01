import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bfws
{
  protected long a;
  aavn a;
  protected bfve a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  private bfws(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Aavn = new bfwt(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static bfws a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bfvr.a("TroopFilePreviewWorker", bfvr.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfvr.a("TroopFilePreviewWorker", bfvr.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bfvr.a("TroopFilePreviewWorker", bfvr.a, "getWoker. item.id=null");
      return null;
    }
    return new bfws(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface == null)
    {
      bfvr.a("TroopFilePreviewWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    bfvr.c("TroopFilePreviewWorker", bfvr.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Bfve = aauw.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Aavn);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfws
 * JD-Core Version:    0.7.0.1
 */