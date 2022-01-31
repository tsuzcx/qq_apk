import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class aret
  implements arek
{
  private bbpe jdField_a_of_type_Bbpe;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public aret(bbpe parambbpe)
  {
    this.jdField_a_of_type_Bbpe = parambbpe;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Bbpe.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bbpe.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bbpe.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.a(localItem, 8);
  }
  
  public void a(aqtd paramaqtd)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.e, this.jdField_a_of_type_Bbpe.g, this.jdField_a_of_type_Bbpe.c, this.jdField_a_of_type_Bbpe.h, new areu(this, paramaqtd));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    boolean bool = bbns.b(localItem.Status);
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
    }
    if ((bool) || (this.jdField_a_of_type_Bbpe.jdField_b_of_type_Int == 7))
    {
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.a(localItem, 11);
      return;
    }
    localTroopFileTransferManager.a(localItem, 6);
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bbpe.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    if (paramBoolean)
    {
      localTroopFileTransferManager.a(localItem, 12);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + paramBoolean + "], itemStatus[" + localItem.Status + "]");
    }
    if ((bbns.b(localItem.Status)) || (this.jdField_a_of_type_Bbpe.jdField_b_of_type_Int == 7))
    {
      localTroopFileTransferManager.a(localItem, 10);
      return;
    }
    localTroopFileTransferManager.a(localItem, 3);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbpe.jdField_b_of_type_Int == 12;
  }
  
  public String b()
  {
    return armo.a().c() + bhma.a(this.jdField_a_of_type_Bbpe.e);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Bbpe.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aret
 * JD-Core Version:    0.7.0.1
 */