import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bbwn
{
  protected long a;
  protected bbuz a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  yui a;
  
  private bbwn(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Yui = new bbwo(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static bbwn a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bbvl.a("TroopFilePreviewWorker", bbvl.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbvl.a("TroopFilePreviewWorker", bbvl.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("TroopFilePreviewWorker", bbvl.a, "getWoker. item.id=null");
      return null;
    }
    return new bbwn(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFilePreviewWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    bbvl.c("TroopFilePreviewWorker", bbvl.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Bbuz = ytu.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Yui);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwn
 * JD-Core Version:    0.7.0.1
 */