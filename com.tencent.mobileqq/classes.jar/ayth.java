import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class ayth
{
  protected int a;
  protected long a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  wlz a;
  
  protected ayth(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_Wlz = new ayti(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public static ayth a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
      return null;
    }
    if (paramItem.BusId != 25)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "get2WeiyunForwarder. ForwardPath=null");
      return null;
    }
    return new ayth(paramLong, paramItem, 1);
  }
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramInt2 = 601;
    if (!paramBoolean)
    {
      bgtg.a(-1);
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult isSuccess:false ");
      paramString1 = new azie(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 601);
      ayrl.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
      return;
    }
    aysb.c("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult retCode:" + paramInt1 + " sClientWording:" + paramString3);
    bgtg.a(paramInt1);
    if (paramInt1 != 0)
    {
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramString1 = new azie(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, paramInt1, paramString3);
        ayrl.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
        return;
        paramInt1 = 202;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 703;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 701;
        continue;
        paramInt1 = 705;
        continue;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(paramString3)) {
          paramInt1 = 704;
        }
      }
    }
    paramString1 = new azie(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 602);
    ayrl.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = ayrz.a();
    if (localQQAppInterface == null)
    {
      aysb.a("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] troop2weiyun app=null");
      return -1;
    }
    aysb.c("TroopFileFromTroopForwarder", aysb.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] troop2weiyun. BusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId + " ForwardBusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId + " ForwardPath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath);
    wln.a(localQQAppInterface, true, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, localQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_Wlz);
    return 0;
  }
  
  public int a()
  {
    if (1 == this.jdField_a_of_type_Int) {
      return b();
    }
    return -1;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayth
 * JD-Core Version:    0.7.0.1
 */