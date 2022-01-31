import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class aplu
  implements apll
{
  private azqv jdField_a_of_type_Azqv;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public aplu(azqv paramazqv)
  {
    this.jdField_a_of_type_Azqv = paramazqv;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Azqv.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Azqv.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Azqv.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.a(localItem, 8);
  }
  
  public void a(apaf paramapaf)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_Azqv.e, this.jdField_a_of_type_Azqv.g, this.jdField_a_of_type_Azqv.c, this.jdField_a_of_type_Azqv.h, new aplv(this, paramapaf));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    boolean bool = azpj.b(localItem.Status);
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
    }
    if ((bool) || (this.jdField_a_of_type_Azqv.jdField_b_of_type_Int == 7))
    {
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.a(localItem, 11);
      return;
    }
    localTroopFileTransferManager.a(localItem, 6);
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Azqv.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    if (paramBoolean)
    {
      localTroopFileTransferManager.a(localItem, 12);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + paramBoolean + "], itemStatus[" + localItem.Status + "]");
    }
    if ((azpj.b(localItem.Status)) || (this.jdField_a_of_type_Azqv.jdField_b_of_type_Int == 7))
    {
      localTroopFileTransferManager.a(localItem, 10);
      return;
    }
    localTroopFileTransferManager.a(localItem, 3);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Azqv.jdField_b_of_type_Int == 12;
  }
  
  public String b()
  {
    return aptm.a().c() + bflg.a(this.jdField_a_of_type_Azqv.e);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Azqv.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplu
 * JD-Core Version:    0.7.0.1
 */