import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class asrv
  implements asrm
{
  private becp jdField_a_of_type_Becp;
  protected QQAppInterface a;
  private UUID jdField_a_of_type_JavaUtilUUID;
  
  public asrv(QQAppInterface paramQQAppInterface, becp parambecp)
  {
    this.jdField_a_of_type_Becp = parambecp;
    this.jdField_a_of_type_JavaUtilUUID = this.jdField_a_of_type_Becp.jdField_a_of_type_JavaUtilUUID;
    if (this.jdField_a_of_type_JavaUtilUUID == null) {
      throw new NullPointerException("TroopFileStatusInfo Id null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Becp.c;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Becp.e;
  }
  
  public void a(long paramLong)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null) {
      QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
    }
    TroopFileTransferManager.Item localItem;
    do
    {
      return;
      localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_a_of_type_JavaUtilUUID);
    } while (localItem == null);
    localItem.ProgressValue = paramLong;
    localTroopFileTransferManager.a(localItem, 8);
  }
  
  public void a(ashw paramashw)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
      return;
    }
    localTroopFileTransferManager.a(this.jdField_a_of_type_Becp.e, this.jdField_a_of_type_Becp.g, this.jdField_a_of_type_Becp.c, this.jdField_a_of_type_Becp.h, new asrw(this, paramashw));
  }
  
  public void a(String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_a_of_type_JavaUtilUUID);
    if (localItem != null)
    {
      boolean bool = bebd.b(localItem.Status);
      if (QLog.isColorLevel()) {
        QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + localItem.Status + "]");
      }
      if ((!bool) && (this.jdField_a_of_type_Becp.jdField_b_of_type_Int != 7)) {
        break label126;
      }
      localItem.LocalFile = paramString;
      localTroopFileTransferManager.a(localItem, 11);
    }
    for (;;)
    {
      ashu.a(this);
      return;
      label126:
      localTroopFileTransferManager.a(localItem, 6);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_b_of_type_Long);
    if (localTroopFileTransferManager == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = localTroopFileTransferManager.a(this.jdField_a_of_type_Becp.jdField_a_of_type_JavaUtilUUID);
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
      if ((!bebd.b(localItem.Status)) && (this.jdField_a_of_type_Becp.jdField_b_of_type_Int != 7)) {
        break label134;
      }
      localTroopFileTransferManager.a(localItem, 10);
    }
    for (;;)
    {
      ashu.a(this);
      return;
      label134:
      localTroopFileTransferManager.a(localItem, 3);
    }
  }
  
  public String b()
  {
    return asyy.a().c() + bjkz.a(this.jdField_a_of_type_Becp.e);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_Becp.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrv
 * JD-Core Version:    0.7.0.1
 */