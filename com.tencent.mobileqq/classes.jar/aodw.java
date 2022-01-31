import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine.1;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class aodw
{
  aodq jdField_a_of_type_Aodq;
  aodz jdField_a_of_type_Aodz = null;
  private aofd jdField_a_of_type_Aofd;
  private aofv jdField_a_of_type_Aofv;
  private aofz jdField_a_of_type_Aofz;
  private aoia jdField_a_of_type_Aoia;
  private aoid jdField_a_of_type_Aoid;
  private aokb jdField_a_of_type_Aokb;
  aoly jdField_a_of_type_Aoly;
  private aomb jdField_a_of_type_Aomb;
  aomp jdField_a_of_type_Aomp;
  public QQAppInterface a;
  
  public aodw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_Aomp == null) {
      a();
    }
    apck.a();
    if (this.jdField_a_of_type_Aodz == null) {
      this.jdField_a_of_type_Aodz = new aodz(this, null);
    }
    try
    {
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.intent.action.MEDIA_MOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_EJECT");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_REMOVED");
      paramQQAppInterface.addDataScheme("file");
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_Aodz, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      }
    }
    do
    {
      do
      {
        return;
        switch (localFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow operation type!");
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.setCloudType(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
      a(localFileManagerEntity);
      return;
      c(localFileManagerEntity);
      return;
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        if (localFileManagerEntity.bDelInFM == true)
        {
          localFileManagerEntity.bDelInFM = false;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "err cloud type.when reTry :" + localFileManagerEntity.getCloudType());
    return;
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    return;
    if (localFileManagerEntity.peerUin.equals(ajed.A)) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, localFileManagerEntity, i);
      return;
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    apck.b(paramFileManagerEntity.nSessionId);
    if (!badq.d(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    bgtg.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  /* Error */
  public aodq a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 313	aodw:jdField_a_of_type_Aodq	Laodq;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 315	aodq
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aodw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 317	aodq:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 313	aodw:jdField_a_of_type_Aodq	Laodq;
    //   26: aload_0
    //   27: getfield 313	aodw:jdField_a_of_type_Aodq	Laodq;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aodw
    //   30	6	1	localaodq	aodq
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public aofd a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 320	aodw:jdField_a_of_type_Aofd	Laofd;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 322	aofd
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aodw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 323	aofd:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 320	aodw:jdField_a_of_type_Aofd	Laofd;
    //   26: aload_0
    //   27: getfield 320	aodw:jdField_a_of_type_Aofd	Laofd;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aodw
    //   30	6	1	localaofd	aofd
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public aofv a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 326	aodw:jdField_a_of_type_Aofv	Laofv;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 328	aofv
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aodw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 329	aofv:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 326	aodw:jdField_a_of_type_Aofv	Laofv;
    //   26: aload_0
    //   27: getfield 326	aodw:jdField_a_of_type_Aofv	Laofv;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aodw
    //   30	6	1	localaofv	aofv
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public aofz a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 332	aodw:jdField_a_of_type_Aofz	Laofz;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 334	aofz
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aodw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 335	aofz:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 332	aodw:jdField_a_of_type_Aofz	Laofz;
    //   26: aload_0
    //   27: getfield 332	aodw:jdField_a_of_type_Aofz	Laofz;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aodw
    //   30	6	1	localaofz	aofz
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  public aoly a()
  {
    try
    {
      if (this.jdField_a_of_type_Aoly == null) {
        this.jdField_a_of_type_Aoly = new aoly(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aoly localaoly = this.jdField_a_of_type_Aoly;
      return localaoly;
    }
    finally {}
  }
  
  public aomb a()
  {
    if (this.jdField_a_of_type_Aomb == null) {}
    try
    {
      if (this.jdField_a_of_type_Aomb == null)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
        this.jdField_a_of_type_Aomb = new aomb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aomb;
    }
    finally {}
  }
  
  public aomp a()
  {
    try
    {
      if (this.jdField_a_of_type_Aomp == null) {
        this.jdField_a_of_type_Aomp = new aomp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aomp localaomp = this.jdField_a_of_type_Aomp;
      return localaomp;
    }
    finally {}
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = apck.a().longValue();
    localFileManagerEntity.Uuid = paramFileManagerEntity.Uuid;
    localFileManagerEntity.selfUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.fileName = paramFileManagerEntity.fileName;
    localFileManagerEntity.fileSize = paramFileManagerEntity.fileSize;
    localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 29;
    localFileManagerEntity.busId = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().a(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramString.nSessionId + "] SendDisc2Weiyun[" + paramString.fileName + "]");
      return paramString;
    }
    c(paramString);
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramString.nSessionId + "] SendOffline2Weiyun[" + paramString.fileName + "]");
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      apck.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = apck.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = apck.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = awbi.a(-1000).uniseq;
    localFileManagerEntity.nOpType = 26;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1)) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      localFileManagerEntity.srvTime = (awao.a() * 1000L);
      localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = apck.a();
      localFileManagerEntity.msgUid = apck.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + apck.a(localFileManagerEntity));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramFileManagerEntity, paramString1, paramString2, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      apck.a();
      return null;
    }
    String str = axwb.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = apck.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = apck.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = awbi.a(-1000).uniseq;
    acvh.a().a(l, paramLong, paramInt2);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (awao.a() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = apck.a();
    localFileManagerEntity.msgUid = apck.b();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + apck.a(localFileManagerEntity));
    }
    apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, awao.a());
      return localFileManagerEntity;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      paramString1 = null;
      return paramString1;
    }
    String str2 = axwb.a(paramString1, 0L, 0, true);
    String str1 = apck.a(paramString1);
    long l = -1L;
    int i;
    label57:
    int j;
    label65:
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label435;
      }
      j = 3;
      if (paramBoolean)
      {
        l = awbi.a(-1000).uniseq;
        acvh.a().a(l, paramLong, paramInt2);
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt1);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = apck.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt1);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (awao.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = apck.a(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = apck.a();
      localFileManagerEntity.msgUid = apck.b();
      localFileManagerEntity.strThumbPath = apck.a(paramString1, 150, 150);
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
        break label441;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      paramString2 = new FileManagerEngine.1(this, localFileManagerEntity, paramBoolean, paramString3, str1, paramString1, paramInt1, str2, j, l);
      if (localFileManagerEntity.nFileType != 5) {
        break label467;
      }
      paramString1 = localFileManagerEntity;
      if (apcc.a(localFileManagerEntity.getFilePath(), new aodx(this, localFileManagerEntity, paramString2))) {
        break;
      }
      apcw.a().execute(paramString2);
      return localFileManagerEntity;
      i = 6;
      break label57;
      label435:
      j = 2;
      break label65;
      label441:
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
    label467:
    apcw.a().execute(paramString2);
    return localFileManagerEntity;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Aokb == null) {}
    try
    {
      if (this.jdField_a_of_type_Aokb == null) {
        this.jdField_a_of_type_Aokb = new aokb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aokb.a(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_Aoia == null) {}
    try
    {
      if (this.jdField_a_of_type_Aoia == null) {
        this.jdField_a_of_type_Aoia = new aoia(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aoia.a(paramFileManagerEntity, paramInt);
    }
    finally {}
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().b(paramString1, paramString2, paramInt, paramObject);
  }
  
  public ArrayList<FileManagerEntity> a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < aonm.c().size())
    {
      localObject = (OfflineFileInfo)aonm.c().get(i);
      localArrayList.add(a(apck.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).a)));
      i += 1;
    }
    i = 0;
    while (i < aonm.b().size())
    {
      localObject = (FileManagerEntity)aonm.b().get(i);
      if (((FileManagerEntity)localObject).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else
      {
        apcc.a((FileManagerEntity)localObject);
        switch (((FileManagerEntity)localObject).getCloudType())
        {
        case 2: 
        case 4: 
        default: 
          localObject = null;
        }
        while (localObject != null)
        {
          localArrayList.add(localObject);
          break;
          if (!bace.b(((FileManagerEntity)localObject).getFilePath())) {
            break;
          }
          localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          continue;
          localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
        }
      }
    }
    Object localObject = aonm.a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
      FileManagerEntity localFileManagerEntity = a(localFileInfo.c(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      localFileManagerEntity.strApkPackageName = localFileInfo.b();
      localArrayList.add(localFileManagerEntity);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a().a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity != null) {
      a(paramInt1, a(localFileManagerEntity), paramInt2);
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    a(paramInt, paramLong, paramString, 0L, 0);
  }
  
  public void a(int paramInt1, long paramLong1, String paramString, long paramLong2, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, paramString, 1);
    localFileManagerEntity.fProgress = 0.0F;
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
      localFileManagerEntity.status = 2;
      if (((FileManagerEntity)localObject).peerType == 0)
      {
        localFileManagerEntity.nOpType = 26;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendOffline2Troop[" + localFileManagerEntity.fileName + "]");
        if ((TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) || (localFileManagerEntity.mContext == null))
        {
          apdl localapdl = apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localFileManagerEntity.strTroopFileUuid = localapdl.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId, paramLong2, paramInt2);
          localFileManagerEntity.mContext = localapdl;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (badq.d(BaseApplication.getContext())) {
          break label520;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131629008);
        localFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof apdl)) {
          ((apdl)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong1, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, apck.a());
          continue;
          if (((FileManagerEntity)localObject).peerType == 3000)
          {
            localFileManagerEntity.nOpType = 27;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendDisce2Troop[" + localFileManagerEntity.fileName + "]");
          }
          else if (((FileManagerEntity)localObject).peerType == 6000)
          {
            localFileManagerEntity.nOpType = 32;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendDataline2Troop[" + localFileManagerEntity.fileName + "]");
          }
        }
      }
      label520:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(102, paramInt1, localFileManagerEntity);
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    a().a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(38, paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    a(3, paramLong, paramString, 0L, paramInt);
  }
  
  public void a(Context paramContext)
  {
    int k = aonm.d().size();
    int j = aonm.c().size();
    Iterator localIterator = aonm.b().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((FileManagerEntity)localIterator.next()).nFileType != 13) {
        break label806;
      }
      i += 1;
    }
    label806:
    for (;;)
    {
      break;
      int m = aonm.b().size() - i;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= v> Download All Select File Start!, weiyun[" + k + "],offline[" + j + "],recent[" + m + "]");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + aonm.d().size() + "], offline[" + aonm.c().size() + "], recent[" + (aonm.b().size() - i) + "], localfile[" + aonm.a().size() + "]");
      }
      if ((i > 0) && (m == 0) && (k == 0) && (j == 0))
      {
        babr.a(paramContext, 230).setMessage(paramContext.getString(2131627041)).setNegativeButton(2131653656, new aody(this)).show();
        return;
      }
      i = 0;
      while (i < k)
      {
        paramContext = apck.a((WeiYunFileInfo)aonm.d().get(i));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downWeiYunFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 5);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramContext = apck.a((OfflineFileInfo)aonm.c().get(i), 0);
        paramContext.status = 2;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
        i += 1;
      }
      i = 0;
      label460:
      if (i < aonm.b().size())
      {
        paramContext = (FileManagerEntity)aonm.b().get(i);
        apcc.a(paramContext);
        if (paramContext.status != 16) {
          break label501;
        }
      }
      for (;;)
      {
        i += 1;
        break label460;
        break;
        label501:
        if (paramContext.nFileType != 13) {
          switch (paramContext.getCloudType())
          {
          default: 
            QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + apck.a(paramContext));
            break;
          case 3: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "=_= v> downRecentFiles,local[" + i + "] break");
            }
            break;
          case 1: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,offline[" + i + "]");
            }
            if ((paramContext.bSend == true) && (paramContext.status != 1) && (paramContext.status != -1) && (paramContext.status != 3)) {
              QLog.w("FileManagerEngine<FileAssistant>", 2, "=_= v> downRecentFiles,but Id[" + paramContext.nSessionId + "] is sendStatus but no Success! continiu");
            } else {
              a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
            }
            break;
          case 2: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,weiyun[" + i + "]");
            }
            a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 5);
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, aonl paramaonl)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, paramaonl);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, paramaonl);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    apck.b(paramFileManagerEntity.nSessionId);
    if (!badq.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131627028);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opType[" + paramFileManagerEntity.nOpType + "]");
    Object localObject = (arip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
    if ((localObject != null) && (((arip)localObject).a(paramFileManagerEntity.peerUin)))
    {
      apck.a(ajjy.a(2131638768));
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] SendOf2Disc[" + paramFileManagerEntity.fileName + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(106, paramFileManagerEntity);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] SendOf2Of[" + paramFileManagerEntity.fileName + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    a(paramFileManagerEntity, paramInt, 0L, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt1;
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt1 + "]");
    apck.b(paramFileManagerEntity.nSessionId);
    if ((paramInt1 != 27) && (!badq.d(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt1 + "]");
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt1;
    int j = 0;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt1 + "] error");
      if (QLog.isDevelopLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "多人聊天转发，selfUin不能为自己！！！");
        throw new NullPointerException(ajjy.a(2131638766));
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Disc[" + paramFileManagerEntity.fileName + "]");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Offline[" + paramFileManagerEntity.fileName + "]");
        i = 3;
        continue;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Weiyun[" + paramFileManagerEntity.fileName + "]");
        i = 25;
        continue;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Troop[" + paramFileManagerEntity.fileName + "]");
        Object localObject;
        if ((TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) || (paramFileManagerEntity.mContext == null))
        {
          localObject = apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramFileManagerEntity.strTroopFileUuid = ((apdl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId, paramLong, paramInt2);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        paramInt2 = paramFileManagerEntity.busId;
        i = paramInt2;
        if (!badq.d(BaseApplication.getContext()))
        {
          i = paramInt2;
          if ((paramFileManagerEntity.mContext instanceof apdl))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131629008);
            ((apdl)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + apck.a(paramFileManagerEntity));
    }
    if (paramInt1 == 20) {
      bgtg.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt);
    apck.b(paramFileManagerEntity.nSessionId);
    apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt, false);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().a(paramWeiYunFileInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + apck.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    Object localObject = aonm.a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((FileInfo)((Iterator)localObject).next()).c();
      try
      {
        apdh.a(new File(str));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException.toString());
      }
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= aonm.d().size()) {
        break;
      }
      a((WeiYunFileInfo)aonm.d().get(i));
      i += 1;
    }
    while (j < aonm.b().size())
    {
      localObject = (FileManagerEntity)aonm.b().get(j);
      apcc.a((FileManagerEntity)localObject);
      b(((FileManagerEntity)localObject).nSessionId);
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int i = aonm.d().size();
    int j = aonm.c().size();
    int k = aonm.b().size();
    int m = aonm.a().size();
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^> Send All Select File Start!, weiyun[" + i + "],offline[" + j + "],recent[" + k + "],local[" + m + "] sendUin[" + apck.e(paramString1) + "] recvUin[" + apck.e(paramString2) + "] peerType[" + paramInt + "]");
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("last_select_send", true);
        ((SharedPreferences.Editor)localObject1).commit();
        if ((aonm.d().size() == 0) && (aonm.c().size() == 0))
        {
          localObject1 = aonm.a();
          Object localObject2 = aonm.b();
          i = 0;
          Object localObject3 = ((Set)localObject1).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!apdh.b(((FileInfo)((Iterator)localObject3).next()).c())) {
              i += 1;
            }
          }
          else
          {
            localObject3 = ((ArrayList)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              if (((FileManagerEntity)((Iterator)localObject3).next()).status == 16)
              {
                i += 1;
                continue;
              }
            }
            else
            {
              if (i != ((Set)localObject1).size() + ((ArrayList)localObject2).size()) {
                continue;
              }
              QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^! Send All Select File is INVALID ");
              apcb.a(2131627218);
              return;
              if (i >= aonm.d().size()) {
                continue;
              }
              localObject1 = (WeiYunFileInfo)aonm.d().get(i);
              apci.a("0X8005415");
              b(apck.a((WeiYunFileInfo)localObject1), paramString1, paramString2, paramInt);
              i += 1;
              continue;
              if (i >= aonm.c().size()) {
                break label1093;
              }
              localObject1 = (OfflineFileInfo)aonm.c().get(i);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(apck.a((OfflineFileInfo)localObject1, paramInt), paramString1, paramString2, paramInt, true);
              ((FileManagerEntity)localObject1).peerType = paramInt;
              ((FileManagerEntity)localObject1).status = 2;
              if (paramInt == 3000)
              {
                ((FileManagerEntity)localObject1).nOpType = 28;
                QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject1).nSessionId + "] sendOffline2Disc[" + ((FileManagerEntity)localObject1).fileName + "]");
                a((FileManagerEntity)localObject1);
                i += 1;
                continue;
              }
              QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject1).nSessionId + "] sendOffline2Offline[" + ((FileManagerEntity)localObject1).fileName + "]");
              continue;
              if (i < aonm.b().size())
              {
                localObject1 = (FileManagerEntity)aonm.b().get(i);
                if (((FileManagerEntity)localObject1).sendCloudUnsuccessful())
                {
                  QLog.w("FileManagerEngine<FileAssistant>", 1, "Id[" + ((FileManagerEntity)localObject1).nSessionId + "] unSend success!");
                  break label1099;
                }
                if ((((FileManagerEntity)localObject1).fileSize <= 20971520L) && (paramBoolean) && (aonm.b((FileManagerEntity)localObject1)))
                {
                  new axfm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((FileManagerEntity)localObject1, paramString1, paramString2, paramInt);
                  break label1099;
                }
                apcc.a((FileManagerEntity)localObject1);
                apci.a("0X8005413");
                a(((FileManagerEntity)localObject1).nSessionId, paramString1, paramString2, paramInt, true);
                break label1099;
              }
              localObject1 = aonm.a().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (FileInfo)((Iterator)localObject1).next();
                localObject3 = ((FileInfo)localObject2).c();
                if ((paramBoolean) && (((FileInfo)localObject2).a() <= 20971520L) && (aonm.b((FileInfo)localObject2)))
                {
                  new axfm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject3, paramString1, paramString2, paramInt);
                  continue;
                }
                apci.a("0X8005414");
                if (paramInt == 1)
                {
                  a((String)localObject3, paramString2);
                  continue;
                }
                a((String)localObject3, paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)localObject2).b();
                continue;
              }
              if (paramInt == 1)
              {
                i = 0;
                if (aonm.d().size() > 0) {
                  i = 1;
                }
                j = i;
                if (aonm.a().size() > 0) {
                  j = i + 10;
                }
                if (aonm.b().size() > 0)
                {
                  i = j + 100;
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
                }
              }
              else
              {
                i = apck.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                if ((paramInt != 0) || (i >= 3) || (!apck.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2))) {
                  continue;
                }
                apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, false);
                paramString1 = BaseApplicationImpl.getContext().getString(2131632623);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, -3009, paramString1);
                apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i + 1);
                return;
              }
              i = j;
              continue;
            }
            continue;
          }
          continue;
          continue;
          return;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label1093:
      continue;
      label1099:
      i += 1;
    }
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public boolean a(int paramInt1, FileManagerEntity paramFileManagerEntity, int paramInt2)
  {
    Object localObject;
    if (0L == paramFileManagerEntity.datalineEntitySessionId)
    {
      localObject = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((apdl)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    while (!badq.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131629008);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof apdl)) {
        ((apdl)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return false;
      if (paramFileManagerEntity.mContext == null) {
        paramFileManagerEntity.mContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(38, paramInt1, paramFileManagerEntity);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(paramLong) + "] call Pause");
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(paramLong) + "] item is not exist");
      }
      return false;
    }
    if ((localFileManagerEntity.getCloudType() == 0) && (1 != localFileManagerEntity.nOpType))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      return true;
    }
    apcj localapcj;
    if (1 == localFileManagerEntity.nOpType)
    {
      localapcj = new apcj();
      localapcj.b = "recv_file_cancel";
      apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapcj);
    }
    while (paramLong > 0L)
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localapcj = new apcj();
        localapcj.b = "send_file_cancel";
        apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapcj);
      }
    }
    if ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
    }
    QLog.e("FileManagerEngine<FileAssistant>", 2, "Pause: can not find file entity info.");
    return false;
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    return a(paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramInt2, 0L, 0);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, int paramInt3)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    if (localFileManagerEntity == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", new Object[] { localFileManagerEntity.fileName, paramLong1 + "", localFileManagerEntity.strTroopFilePath }));
    }
    ayqd localayqd1 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, localFileManagerEntity.Uuid, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if ((localayqd1 == null) || (localayqd1.e == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      int j = Math.abs(new Random().nextInt());
      ayqd localayqd2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(localayqd1.e, paramLong2, localayqd1.g, localayqd1.jdField_a_of_type_JavaLangString, localayqd1.c, localayqd1.h, j, paramLong1);
      if (localayqd2 == null)
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
        return false;
      }
      paramInt1 = apck.a(localayqd1.g);
      if (paramInt1 == 0) {
        if (apdh.a(localayqd1.jdField_a_of_type_JavaLangString))
        {
          paramString = new BitmapFactory.Options();
          paramString.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(localayqd1.jdField_a_of_type_JavaLangString, paramString);
          paramLong2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localayqd2.g, localayqd2.c, localayqd2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localayqd1.b), paramLong1, paramString.outWidth, paramString.outHeight, paramLong4, paramInt3);
        }
      }
      for (;;)
      {
        localFileManagerEntity.structMsgSeq = paramLong2;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
        }
        return true;
        paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(localayqd1.b), 1, localayqd1.e);
        if (paramString != null)
        {
          paramLong2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localayqd2.g, localayqd2.c, localayqd2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localayqd1.b), paramLong1, paramString.width, paramString.height, paramLong4, paramInt3);
        }
        else
        {
          paramLong2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localayqd2.g, localayqd2.c, localayqd2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localayqd1.b), paramLong1, paramLong4, paramInt3);
          continue;
          if (paramInt1 == 2)
          {
            paramInt1 = 0;
            paramInt2 = 0;
            int i = 0;
            if (apdh.a(localayqd1.jdField_a_of_type_JavaLangString))
            {
              paramString = ShortVideoUtils.a(paramString);
              paramInt1 = paramString[0];
              paramInt2 = paramString[1];
              i = paramString[3];
            }
            for (;;)
            {
              paramLong2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localayqd2.g, localayqd2.c, localayqd2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localayqd1.b), paramLong1, paramInt1, paramInt2, i, paramLong4, paramInt3);
              break;
              paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(localayqd1.b), 1, localayqd1.e);
              if (paramString != null)
              {
                paramInt1 = paramString.width;
                paramInt2 = paramString.height;
                i = paramString.duration;
              }
            }
          }
          paramLong2 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localayqd2.g, localayqd2.c, localayqd2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localayqd1.b), paramLong1, paramLong4, paramInt3);
        }
      }
    }
    if ((paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
      if (paramLong2 != 0L) {
        break label1028;
      }
    }
    label1028:
    for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
    {
      paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, false, 0L, apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), paramLong4, paramInt3);
      return true;
      if (paramInt1 == 7)
      {
        paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
        if (paramLong2 != 0L) {
          break label1022;
        }
      }
      label1022:
      for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
      {
        if (localFileManagerEntity.datalineEntitySessionId != 0L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0), paramLong4, paramInt3);
          break;
        }
        if (paramInt1 != 6003) {
          break;
        }
        paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
        if (paramLong2 == 0L) {}
        for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
        {
          if (localFileManagerEntity.datalineEntitySessionId != 0L) {}
          for (bool = true;; bool = false)
          {
            paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, 7, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1), paramLong4, paramInt3);
            break;
          }
        }
      }
    }
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramLong, paramString1, paramString2, paramInt, paramBoolean, 0);
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + apck.a(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      apck.c(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      apck.b(localFileManagerEntity.nSessionId);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramInt1);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt1);
      continue;
      if (aonk.a(localFileManagerEntity.Uuid))
      {
        axfs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, paramString2, paramInt1);
      }
      else if ((localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + apck.e(paramString1) + "], recvUin[" + apck.e(paramString2) + "], peerType[" + paramInt1 + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
          localObject = paramString1;
        }
        while (paramInt1 == 1)
        {
          d(paramLong, paramString2);
          return false;
          if (paramInt1 == 1006) {
            localObject = paramString1;
          }
        }
        localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt1, true, 0L, paramInt2);
        apck.b(((FileManagerEntity)localObject).nSessionId);
        apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
        ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
        if (localFileManagerEntity.peerType == 3000)
        {
          ((FileManagerEntity)localObject).selfUin = localFileManagerEntity.peerUin;
          if (paramInt1 == 3000)
          {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendDisc2Disc[" + ((FileManagerEntity)localObject).fileName + "]");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 22);
          }
          else
          {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendDisc2Offline[" + ((FileManagerEntity)localObject).fileName + "]");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject, 21);
          }
        }
        else
        {
          if (paramInt1 == 3000)
          {
            ((FileManagerEntity)localObject).nOpType = 28;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendOfline2Disc[" + ((FileManagerEntity)localObject).fileName + "]");
          }
          for (;;)
          {
            a((FileManagerEntity)localObject);
            break;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendOfline2Offline[" + ((FileManagerEntity)localObject).fileName + "]");
          }
        }
      }
      else if (localFileManagerEntity.getFilePath() != null)
      {
        if (paramInt1 == 1) {
          a(localFileManagerEntity.getFilePath(), paramString2);
        } else {
          return a(localFileManagerEntity.getFilePath(), paramString1, paramString2, paramInt1, paramBoolean) != null;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, 0);
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramString2));
    int i;
    File localFile;
    if (localObject != null)
    {
      i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      localFile = new File(paramString1);
      if (apck.a(paramString1) != 0) {
        break label138;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      apdc.a(paramString1, localOptions);
      azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localFile.getName(), localFile.length(), ((ayqd)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight, paramLong, paramInt);
    }
    for (;;)
    {
      return true;
      label138:
      if (apck.a(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.a(paramString1);
        azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localFile.getName(), localFile.length(), ((ayqd)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramString1[0], paramString1[1], paramString1[2], paramLong, paramInt);
      }
      else
      {
        azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localFile.getName(), localFile.length(), ((ayqd)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramLong, paramInt);
      }
    }
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Aoid == null) {}
    try
    {
      if (this.jdField_a_of_type_Aoid == null) {
        this.jdField_a_of_type_Aoid = new aoid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aoid.a(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String b(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
  }
  
  public void b(long paramLong, String paramString) {}
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
      }
      return;
    }
    switch (paramFileManagerEntity.getCloudType())
    {
    }
    for (;;)
    {
      f();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
      return;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 1);
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
      if (paramFileManagerEntity.nOpType == 50) {
        a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 50);
      } else {
        a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 5);
      }
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.nFileType == 0)
    {
      a(paramFileManagerEntity, paramInt);
      return;
    }
    if (paramFileManagerEntity.peerType == 3000)
    {
      b(paramFileManagerEntity);
      return;
    }
    a(paramFileManagerEntity);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to Troop ");
      a().a(paramFileManagerEntity, paramString2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to offline ");
    a(paramFileManagerEntity, str, paramString2, paramInt);
  }
  
  public void b(String paramString)
  {
    a().a(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aomp.a(paramString1, paramString2);
  }
  
  public boolean b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + paramLong);
      }
      return false;
    }
    boolean bool;
    if (localFileManagerEntity.getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.getCloudType() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity.nSessionId);
      }
      if (!apck.b(localFileManagerEntity.getFilePath())) {
        break label237;
      }
      localFileManagerEntity.cloudType = 3;
    }
    for (;;)
    {
      if ((!localFileManagerEntity.bDelInAio) || (!localFileManagerEntity.bDelInFM)) {
        break label247;
      }
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      break;
      label237:
      localFileManagerEntity.status = 16;
    }
    label247:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    return bool;
  }
  
  public String c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    String str = apck.d(paramFileManagerEntity);
    if (apdh.b(str)) {
      return str;
    }
    a().a(paramFileManagerEntity.nSessionId, str, paramFileManagerEntity.strServerPath);
    return null;
  }
  
  public void c()
  {
    a().a();
  }
  
  public void c(long paramLong, String paramString) {}
  
  public void d()
  {
    BaseApplicationImpl.sApplication.unregisterReceiver(this.jdField_a_of_type_Aodz);
    this.jdField_a_of_type_Aodz = null;
    apbo.a().b();
    aosu.a().c();
    aojd.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
  }
  
  public void d(long paramLong, String paramString)
  {
    a(3, paramLong, paramString);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aodw
 * JD-Core Version:    0.7.0.1
 */