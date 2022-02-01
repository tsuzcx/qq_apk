import android.content.Context;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;
import mqq.manager.Manager;

public class bkpn
  implements Manager
{
  public Context a;
  private bkpm jdField_a_of_type_Bkpm;
  private bkpp jdField_a_of_type_Bkpp = new bkpp(new bkpo(this, Looper.getMainLooper()));
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  
  public bkpn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bkpp);
    this.jdField_a_of_type_Bkpm = ((bkpm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(176));
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QfavFileForwardManager", 2, "insertWeiYun2OfflineEntity : entity is null, peerUin[" + aszt.e(paramString2) + "], peerType[" + paramInt1 + "]");
      }
      paramFileManagerEntity = null;
      return paramFileManagerEntity;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = aszt.a().longValue();
    String str2 = TransfileUtile.makeTransFileProtocolData(localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, 0, true);
    long l = bbli.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.nOpType = 37;
    localFileManagerEntity.peerNick = aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.srvTime = (bbko.a() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = aszt.a();
    localFileManagerEntity.msgUid = aszt.b();
    if (paramInt2 != 0) {
      afoa.a().a(l, 0L, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
      str1 = paramString1;
    }
    for (;;)
    {
      localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
      localFileManagerEntity.strMiddleThumPath = paramFileManagerEntity.strMiddleThumPath;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString2, str1, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str2, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 1, l, localFileManagerEntity.msgUid, -1L, bbko.a());
      paramFileManagerEntity = localFileManagerEntity;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QfavFileForwardManager", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt1 + "],FileManagerEntity:" + aszt.a(localFileManagerEntity));
      return localFileManagerEntity;
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        str1 = paramString1;
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(paramLong1).longValue());
    if (localTroopFileTransferManager == null) {}
    do
    {
      int i;
      becp localbecp;
      do
      {
        return;
        i = Math.abs(new Random().nextInt());
        localbecp = localTroopFileTransferManager.a(paramFileManagerEntity, 102, i, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      } while (localbecp == null);
      bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "" + paramLong1, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localbecp.a.toString(), i, null, paramFileManagerEntity.nSessionId, paramLong2, paramInt);
      paramFileManagerEntity.strTroopFileUuid = localbecp.a.toString();
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        break;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localbecp.a, -1, null, amtj.a(2131715935));
    } while (!QLog.isColorLevel());
    QLog.i("QfavFileForwardManager", 2, "forwardToTroop : network error");
    return;
    this.jdField_a_of_type_Bkpm.a(1, paramFileManagerEntity, paramLong1);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    paramFileManagerEntity = a(paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLong1 + "", paramFileManagerEntity.peerType, paramInt);
    aszt.b(paramFileManagerEntity.nSessionId);
    aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLong1 + "", paramFileManagerEntity);
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.fProgress = 0.0F;
    this.jdField_a_of_type_Bkpm.a(2, paramFileManagerEntity, paramLong1);
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("QfavFileForwardManager", 1, "insertFav2OfflineEntity mApp=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 236;
    localDataLineMsgRecord.fileFrom = 6;
    localDataLineMsgRecord.nOpType = 38;
    localDataLineMsgRecord.istroop = 0;
    amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8);
    localDataLineMsgRecord.sessionid = localamqd.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = bbko.a();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = amqd.a(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.entityID = paramFileManagerEntity.nSessionId;
    localDataLineMsgRecord.thumbPath = paramFileManagerEntity.strThumbPath;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getDatalineMessageManager(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localamqd.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)amqd.b(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    this.jdField_a_of_type_Bkpm.a(3, paramFileManagerEntity, paramLong1, localDataLineMsgRecord.sessionid);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bkpp.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bkpp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpn
 * JD-Core Version:    0.7.0.1
 */