import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class aufl
  implements aufc
{
  private bftf jdField_a_of_type_Bftf;
  protected QQAppInterface a;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public aufl(QQAppInterface paramQQAppInterface, bftf parambftf)
  {
    this.jdField_a_of_type_Bftf = parambftf;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Bftf.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bftf.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bftf.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.a(localItem, 8);
  }
  
  public void a(atvm paramatvm)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_Bftf.e, this.jdField_a_of_type_Bftf.g, this.jdField_a_of_type_Bftf.c, this.jdField_a_of_type_Bftf.h, new aufm(this, paramatvm));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      boolean bool = bfrt.b(localItem.Status);
      if (QLog.isColorLevel()) {
        QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
      }
      if ((!bool) && (this.jdField_a_of_type_Bftf.jdField_b_of_type_Int != 7)) {
        break label126;
      }
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.a(localItem, 11);
    }
    for (;;)
    {
      atvk.a(this);
      return;
      label126:
      localTroopFileTransferManager.a(localItem, 6);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Bftf.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      if (paramBoolean)
      {
        localTroopFileTransferManager.a(localItem, 12);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + paramBoolean + "], itemStatus[" + localItem.Status + "]");
      }
      if ((!bfrt.b(localItem.Status)) && (this.jdField_a_of_type_Bftf.jdField_b_of_type_Int != 7)) {
        break label134;
      }
      localTroopFileTransferManager.a(localItem, 10);
    }
    for (;;)
    {
      atvk.a(this);
      return;
      label134:
      localTroopFileTransferManager.a(localItem, 3);
    }
  }
  
  public String b()
  {
    return aumo.a().c() + blev.a(this.jdField_a_of_type_Bftf.e);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Bftf.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufl
 * JD-Core Version:    0.7.0.1
 */