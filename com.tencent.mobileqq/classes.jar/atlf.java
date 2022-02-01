import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class atlf
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private atlv jdField_a_of_type_Atlv;
  public QQAppInterface a;
  
  public atlf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private TransFileInfo a(MessageRecord paramMessageRecord)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if (localEntityManager != null) {
        localObject1 = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(paramMessageRecord.time), String.valueOf(paramMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin });
      }
    }
    if ((localObject1 == null) && (paramMessageRecord != null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, "get TransferInfo null, time[" + String.valueOf(paramMessageRecord.time) + "],msgseq[" + String.valueOf(paramMessageRecord.msgseq) + "],uin[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "], frienduin[" + paramMessageRecord.frienduin + "]");
    }
    return localObject1;
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.2(this, paramBundle));
  }
  
  public int a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, Bundle paramBundle)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. sourceId:" + paramInt2);
        }
        paramInt1 = -1;
        return paramInt1;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. filePath:" + paramString2 + " size:" + paramLong + " sourceId:" + paramInt2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but app = null");
        }
      }
      else
      {
        long l = bcsa.a(-1000).uniseq;
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, AppConstants.FM_EXTERNAL_SAVEFILE_UIN, 0);
        if (paramString1 == null)
        {
          if (!QLog.isColorLevel()) {
            break label443;
          }
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
          break label443;
        }
        paramString1.setCloudType(3);
        paramString1.fileName = auea.a(paramString2);
        if (0L == paramLong)
        {
          paramString1.fileSize = auea.a(paramString2);
          paramString1.setFilePath(paramString2);
          paramString1.nOpType = paramInt2;
          paramString1.peerNick = null;
          paramString1.peerType = 0;
          paramString1.peerUin = AppConstants.FM_EXTERNAL_SAVEFILE_UIN;
          paramString1.srvTime = (bcrg.a() * 1000L);
          paramString1.status = 1;
          paramString1.Uuid = null;
          paramString1.isReaded = true;
          paramString1.bSend = false;
          if (paramBundle != null)
          {
            if (paramBundle.getBoolean("FILE_TMP_IS_ZIPINNER_FILE"))
            {
              paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
              String str = paramBundle.getString("FILE_TMP_DIR_PATH");
              paramLong = paramBundle.getLong("FILE_TMP_RELATED_ID");
              paramBundle = paramBundle.getString("FILE_TMP_ZIP_FILEID");
              paramString1.isZipInnerFile = true;
              paramString1.nRelatedSessionId = paramLong;
              paramString1.zipInnerPath = str;
              paramString1.strServerPath = paramString3;
              paramString1.zipFileId = paramBundle;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().g(paramString1);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1);
            auea.c(paramString2);
            paramInt1 = 0;
          }
        }
        else
        {
          paramString1.fileSize = paramLong;
          continue;
        }
        paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1.status = 1;
          paramString1.strServerPath = paramString3;
          paramString1.bDelInAio = true;
        }
        paramInt1 = paramBundle.getInt("FILE_FROM", -1);
        if (paramInt1 == -1) {
          continue;
        }
        paramString1.nOpType = paramInt1;
        continue;
      }
      paramInt1 = -2;
      continue;
      label443:
      paramInt1 = -3;
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 <= 0L) {
      return 0L;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + auea.e(paramString) + "], peeryType[" + String.valueOf(paramInt) + "], uniseq[" + String.valueOf(paramLong2) + "]");
    }
    MessageRecord localMessageRecord = null;
    if (paramLong2 > 0L) {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString, paramInt, paramLong2);
    }
    if (localMessageRecord != null)
    {
      paramString = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
      if (paramString == null) {}
    }
    for (paramLong1 = paramString.transferedSize * 100L / paramLong1;; paramLong1 = 0L)
    {
      localEntityManager.close();
      return paramLong1;
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, null, paramString3, -1L, -1L, -1L);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = bcsa.a(paramInt2);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.msg = paramString3;
    localMessageRecord.msgtype = paramInt2;
    localMessageRecord.isread = true;
    long l;
    if (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      if (paramLong2 <= 0L) {
        break label214;
      }
      l = paramLong2;
      label92:
      localMessageRecord.msgseq = l;
      if (paramLong2 <= 0L) {
        break label231;
      }
      label106:
      localMessageRecord.shmsgseq = paramLong2;
      if (paramLong1 <= 0L) {
        break label250;
      }
      label120:
      localMessageRecord.msgUid = paramLong1;
      if (paramLong3 <= 0L) {
        break label258;
      }
    }
    for (;;)
    {
      localMessageRecord.time = paramLong3;
      if ((paramMap == null) || (paramMap.size() <= 0)) {
        break label266;
      }
      paramString1 = paramMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localMessageRecord.saveExtInfoToExtStr(paramString2, (String)paramMap.get(paramString2));
      }
      paramInt2 = 0;
      break;
      label214:
      paramInt1 = bcpt.a;
      bcpt.a = paramInt1 + 1;
      l = paramInt1;
      break label92;
      label231:
      paramLong2 = Math.abs(new Random().nextInt());
      break label106;
      label250:
      paramLong1 = auea.b();
      break label120;
      label258:
      paramLong3 = bcrg.a();
    }
    label266:
    localMessageRecord.extraflag |= 0xFFFF7FFF;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + auea.e(localMessageRecord.selfuin) + "], frienduin[" + auea.e(localMessageRecord.frienduin) + "], senderuin[" + auea.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], msgtype[" + String.valueOf(paramString3) + "]");
    return localMessageRecord.uniseq;
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return a(paramString1, paramString2, paramBoolean1, paramString3, paramLong1, paramBoolean2, paramInt1, paramString4, paramLong2, paramLong3, paramString5, paramInt2, paramLong4, paramLong5, paramLong6, paramLong7, -1);
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3)
  {
    MessageRecord localMessageRecord = bcsa.a(-2005);
    localMessageRecord.uniseq = paramLong4;
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    if (paramString4 != null)
    {
      paramString5 = paramString4;
      if (paramString4.length() >= 1) {}
    }
    else
    {
      paramString5 = TransfileUtile.makeTransFileProtocolData(paramString3, paramLong1, 0, paramBoolean2);
    }
    localMessageRecord.msg = paramString5;
    localMessageRecord.msgtype = -2005;
    localMessageRecord.isread = paramBoolean2;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.msgseq = paramLong2;
      localMessageRecord.shmsgseq = bcsc.a(paramLong2, paramInt1);
      paramLong1 = paramLong5;
      if (paramLong5 == 0L) {
        paramLong1 = bcsc.a(bcsc.a());
      }
      localMessageRecord.msgUid = paramLong1;
      localMessageRecord.time = paramLong7;
      if (paramInt1 == 3000) {
        localMessageRecord.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramString1, paramInt1).shmsgseq;
      }
      if (!localMessageRecord.isSend()) {
        break label496;
      }
      ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageRecord);
    }
    for (;;)
    {
      localMessageRecord.vipBubbleDiyTextId = paramInt3;
      if (TextUtils.isEmpty(((MessageForFile)localMessageRecord).fileName)) {
        ((MessageForFile)localMessageRecord).fileName = auea.a(paramString3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramInt1);
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + auea.e(localMessageRecord.selfuin) + "], frienduin[" + auea.e(localMessageRecord.frienduin) + "], senderuin[" + auea.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
      return localMessageRecord.uniseq;
      paramInt2 = 0;
      break;
      label496:
      if (paramLong6 != -1L) {
        localMessageRecord.vipBubbleID = paramLong6;
      } else {
        localMessageRecord.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastC2CBubleID(paramString1);
      }
    }
  }
  
  public atlv a()
  {
    if (this.jdField_a_of_type_Atlv == null) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getTmpController mTmpController is null");
    }
    for (;;)
    {
      atlv localatlv = this.jdField_a_of_type_Atlv;
      this.jdField_a_of_type_Atlv = null;
      return localatlv;
      QLog.d("FileManagerDataCenter<FileAssistant>", 1, "getTmpController " + this.jdField_a_of_type_Atlv.getClass().getName());
    }
  }
  
  public FileManagerEntity a(long paramLong)
  {
    if (paramLong == -1L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId nSessionId[" + paramLong + "] is error");
      return null;
    }
    atpt localatpt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localatpt == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localatpt.a(paramLong);
    if (localFileManagerEntity != null)
    {
      localatpt.a(localFileManagerEntity);
      auds.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramLong));
    if (localFileManagerEntity != null)
    {
      localatpt.a(localFileManagerEntity);
      auds.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get entry null! nSessionId[" + paramLong + "]");
    return null;
  }
  
  public FileManagerEntity a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1);
    if (localFileManagerEntity != null)
    {
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid for queryall, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + auea.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      return localFileManagerEntity;
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = paramLong1;
    localFileManagerEntity.uniseq = paramLong2;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid, new a FileManagerEntity, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(paramLong2) + "], strUin[" + auea.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(long paramLong, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong, paramString);
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq  strUin is null, uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    if (paramLong <= 0L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq uniseq[" + paramLong + "] is error, strUin[" + auea.e(paramString) + "], peerType[" + paramInt + "]");
      return null;
    }
    atpt localatpt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localatpt == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq get FileManagerProxy null! strUin[" + auea.e(paramString) + "], uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localatpt.a(paramLong, paramString, paramInt);
    if (localFileManagerEntity != null)
    {
      auds.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    return localatpt.b(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (-1L != paramLong2) {}
    for (FileManagerEntity localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);; localFileManagerEntity1 = null)
    {
      FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
      if (localFileManagerEntity1 == null)
      {
        localFileManagerEntity2 = localFileManagerEntity1;
        if (paramLong1 > 0L) {
          localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1, paramString, paramInt);
        }
      }
      if (localFileManagerEntity2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "why sessionId[" + String.valueOf(paramLong2) + "] and uniseq[" + String.valueOf(paramLong1) + "] is wrong");
        }
        return null;
      }
      return localFileManagerEntity2;
    }
  }
  
  public FileManagerEntity a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(paramString);
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localObject == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity1 = ((atpt)localObject).a(paramString, paramLong);
    if (localFileManagerEntity1 != null) {
      return localFileManagerEntity1;
    }
    localObject = "select * from " + FileManagerEntity.tableName() + " where (nOLfileSessionId = " + paramLong + " or (nSessionId = " + paramLong + " and nOLfileSessionId = 0)) order by srvTime desc";
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject, null);
    FileManagerEntity localFileManagerEntity2;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localFileManagerEntity2 = (FileManagerEntity)localIterator.next();
        } while (!paramString.equalsIgnoreCase(localFileManagerEntity2.peerUin));
        localObject = localFileManagerEntity2;
        if (paramLong == localFileManagerEntity2.nOLfileSessionId) {
          break;
        }
      } while ((paramLong != localFileManagerEntity2.nSessionId) || (0L != localFileManagerEntity2.nOLfileSessionId));
    }
    for (localObject = localFileManagerEntity2;; localObject = localFileManagerEntity1)
    {
      if ((localObject != null) && (0L == ((FileManagerEntity)localObject).nOLfileSessionId))
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "QueryOLfileSessionEntity find a old ver data. nOLfileSessionId[" + paramLong + "]");
        ((FileManagerEntity)localObject).nOLfileSessionId = paramLong;
        c((FileManagerEntity)localObject);
      }
      localEntityManager.close();
      return localObject;
    }
  }
  
  public List<FileManagerEntity> a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramLong);
  }
  
  public List<FileManagerEntity> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString1, paramString2, paramBoolean);
  }
  
  public List<FileManagerEntity> a(List<Integer> paramList, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramList, paramString);
  }
  
  public Map<String, List<FileManagerEntity>> a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 0, null);
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerDataCenter<FileAssistant>", 2, "sessionnid[" + String.valueOf(paramLong) + "] item is not exist!may be is deleted!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity, paramString);
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1, paramString, paramInt, -1L);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "updateFileManagerTime error, entity is null,uinseq[" + String.valueOf(paramLong1) + "], frienduin[" + String.valueOf(paramString) + "], istroop[" + String.valueOf(paramInt) + "], time[" + String.valueOf(paramLong2) + "]");
      }
      return;
    }
    localFileManagerEntity.srvTime = (1000L * paramLong2);
    c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(atlv paramatlv)
  {
    QLog.d("FileManagerDataCenter<FileAssistant>", 1, "regTmpController" + paramatlv.getClass().getName());
    this.jdField_a_of_type_Atlv = paramatlv;
  }
  
  /* Error */
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	atlf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:getFileManagerProxy	()Latpt;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +69 -> 80
    //   14: ldc 72
    //   16: iconst_1
    //   17: new 74	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 665
    //   27: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 546	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   34: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc_w 296
    //   40: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 547	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   47: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: ldc_w 667
    //   53: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   60: invokestatic 289	auea:e	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 89
    //   68: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +32 -> 115
    //   86: ldc 72
    //   88: iconst_2
    //   89: new 74	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 669
    //   99: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokestatic 672	auea:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)Ljava/lang/String;
    //   106: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 128	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 674	atpt:b	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   120: aload_0
    //   121: getfield 15	atlf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 636	com/tencent/mobileqq/app/QQAppInterface:getFileManagerNotifyCenter	()Latlh;
    //   127: iconst_1
    //   128: iconst_3
    //   129: aconst_null
    //   130: invokevirtual 641	atlh:a	(ZILjava/lang/Object;)V
    //   133: goto -56 -> 77
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	atlf
    //   0	141	1	paramFileManagerEntity	FileManagerEntity
    //   9	107	2	localatpt	atpt
    // Exception table:
    //   from	to	target	type
    //   2	10	136	finally
    //   14	77	136	finally
    //   80	115	136	finally
    //   115	133	136	finally
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "Save of2of [" + String.valueOf(paramBoolean1) + "],query FileManagerEntity renturn null, SessionId[" + String.valueOf(paramLong) + "], ");
      }
      return;
    }
    if (paramBoolean1)
    {
      localFileManagerEntity.lastTime = (bcrg.a() * 1000L + 604800000L);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.Uuid = paramString2;
      localFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      localFileManagerEntity.fileIdCrc = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      auea.b(localFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity, 6, "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, paramInt, paramString1);
    localFileManagerEntity.isReaded = false;
    localFileManagerEntity.status = 0;
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      localFileManagerEntity.status = 16;
      if ((localFileManagerEntity.mContext != null) && ((localFileManagerEntity.mContext instanceof FileManagerEntity)))
      {
        paramString2 = (FileManagerEntity)localFileManagerEntity.mContext;
        paramString2.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramString2);
        localFileManagerEntity.mContext = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
    auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", "", localFileManagerEntity.peerUin, localFileManagerEntity.Uuid, paramInt, paramString1, 0L, 0L, 0L, "", "", 0, paramString1, null);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject2 = a(paramLong);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + auea.e(((FileManagerEntity)localObject2).peerUin) + "], peeryType[" + String.valueOf(((FileManagerEntity)localObject2).peerType) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject2).uniseq) + "]");
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).status = paramInt;
      ((EntityManager)localObject2).update((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setFMDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInFM = true;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity, true);
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "SetRead: strUin[" + auea.e(paramString) + "], peeryType[" + paramInt + "], uniseq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString, paramInt, paramLong);
    if (paramString != null)
    {
      paramString.isread = true;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramLong);
  }
  
  public FileManagerEntity b(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localObject == null) {
      return null;
    }
    if (paramLong > 0L)
    {
      FileManagerEntity localFileManagerEntity = ((atpt)localObject).a(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq for memory, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + auea.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
        return localFileManagerEntity;
      }
      localObject = ((atpt)localObject).b(paramLong, paramString, paramInt);
      if (localObject != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq for db, FileManagerEntity exist, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject).uniseq) + "], strUin[" + auea.e(((FileManagerEntity)localObject).peerUin) + "], peerType[" + String.valueOf(((FileManagerEntity)localObject).peerType) + "]");
        return localObject;
      }
    }
    localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = auea.a().longValue();
    ((FileManagerEntity)localObject).uniseq = paramLong;
    ((FileManagerEntity)localObject).peerUin = paramString;
    ((FileManagerEntity)localObject).peerType = paramInt;
    ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((FileManagerEntity)localObject).isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a((FileManagerEntity)localObject);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq, new a FileManagerEntity, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(paramLong) + "], strUin[" + auea.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localObject;
  }
  
  public FileManagerEntity b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().c(paramString);
  }
  
  public List<FileManagerEntity> b(List<Integer> paramList, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(paramList, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d();
  }
  
  public void b(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong, paramString);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      atpt localatpt;
      try
      {
        localatpt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
        if (localatpt == null)
        {
          QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[" + paramFileManagerEntity.nSessionId + "], uniseq[" + paramFileManagerEntity.uniseq + "], peerUin[" + auea.e(paramFileManagerEntity.peerUin) + "]");
          return;
        }
        if ((FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramFileManagerEntity.nSessionId)) == null)
        {
          localatpt.b(paramFileManagerEntity);
          continue;
        }
        localatpt.c(paramFileManagerEntity);
      }
      finally {}
      localatpt.e(paramFileManagerEntity);
    }
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setAioDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInAio = true;
      paramFileManagerEntity.uniseq = -1L;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity, true);
    }
  }
  
  public FileManagerEntity c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().f(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().c();
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d(paramFileManagerEntity);
  }
  
  public FileManagerEntity d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d(paramString);
  }
  
  public void d()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.1(this));
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity);
  }
  
  public FileManagerEntity e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().g(paramString);
  }
  
  public void e()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.3(this));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atlf
 * JD-Core Version:    0.7.0.1
 */