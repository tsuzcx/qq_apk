import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bfng
{
  protected long a;
  aahm a;
  protected bfls a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  private bfng(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Aahm = new bfnh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static bfng a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bfmf.a("TroopFilePreviewWorker", bfmf.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bfmf.a("TroopFilePreviewWorker", bfmf.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bfmf.a("TroopFilePreviewWorker", bfmf.a, "getWoker. item.id=null");
      return null;
    }
    return new bfng(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopFilePreviewWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    bfmf.c("TroopFilePreviewWorker", bfmf.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Bfls = aagu.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Aahm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfng
 * JD-Core Version:    0.7.0.1
 */