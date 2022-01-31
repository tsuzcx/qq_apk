import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class bbse
{
  protected long a;
  protected bbqq a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  ypt a;
  
  private bbse(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Ypt = new bbsf(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static bbse a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      bbrc.a("TroopFilePreviewWorker", bbrc.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbrc.a("TroopFilePreviewWorker", bbrc.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopFilePreviewWorker", bbrc.a, "getWoker. item.id=null");
      return null;
    }
    return new bbse(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFilePreviewWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    bbrc.c("TroopFilePreviewWorker", bbrc.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_Bbqq = ypf.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_Ypt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbse
 * JD-Core Version:    0.7.0.1
 */