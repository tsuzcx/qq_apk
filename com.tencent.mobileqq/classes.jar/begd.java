import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class begd
{
  protected long a;
  protected beep a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  zsa a;
  
  private begd(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Zsa = new bege(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static begd a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      befc.a("TroopFilePreviewWorker", befc.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      befc.a("TroopFilePreviewWorker", befc.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      befc.a("TroopFilePreviewWorker", befc.a, "getWoker. item.id=null");
      return null;
    }
    return new begd(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFilePreviewWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    befc.c("TroopFilePreviewWorker", befc.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Beep = zrj.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Zsa);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begd
 * JD-Core Version:    0.7.0.1
 */