import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class arjc
  implements arit
{
  private bbtn jdField_a_of_type_Bbtn;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public arjc(bbtn parambbtn)
  {
    this.jdField_a_of_type_Bbtn = parambbtn;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Bbtn.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bbtn.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bbtn.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.a(localItem, 8);
  }
  
  public void a(aqxm paramaqxm)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.e, this.jdField_a_of_type_Bbtn.g, this.jdField_a_of_type_Bbtn.c, this.jdField_a_of_type_Bbtn.h, new arjd(this, paramaqxm));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    boolean bool = bbsb.b(localItem.Status);
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
    }
    if ((bool) || (this.jdField_a_of_type_Bbtn.jdField_b_of_type_Int == 7))
    {
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.a(localItem, 11);
      return;
    }
    localTroopFileTransferManager.a(localItem, 6);
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbtn.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    if (paramBoolean)
    {
      localTroopFileTransferManager.a(localItem, 12);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + paramBoolean + "], itemStatus[" + localItem.Status + "]");
    }
    if ((bbsb.b(localItem.Status)) || (this.jdField_a_of_type_Bbtn.jdField_b_of_type_Int == 7))
    {
      localTroopFileTransferManager.a(localItem, 10);
      return;
    }
    localTroopFileTransferManager.a(localItem, 3);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbtn.jdField_b_of_type_Int == 12;
  }
  
  public String b()
  {
    return arqx.a().c() + bhqh.a(this.jdField_a_of_type_Bbtn.e);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Bbtn.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjc
 * JD-Core Version:    0.7.0.1
 */