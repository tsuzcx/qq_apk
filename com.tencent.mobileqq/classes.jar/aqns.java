import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class aqns
{
  aqnm jdField_a_of_type_Aqnm;
  aqnv jdField_a_of_type_Aqnv = null;
  private aqoz jdField_a_of_type_Aqoz;
  private aqpr jdField_a_of_type_Aqpr;
  private aqpv jdField_a_of_type_Aqpv;
  private aqrw jdField_a_of_type_Aqrw;
  private aqrz jdField_a_of_type_Aqrz;
  private aqtx jdField_a_of_type_Aqtx;
  aqvu jdField_a_of_type_Aqvu;
  private aqvx jdField_a_of_type_Aqvx;
  aqwl jdField_a_of_type_Aqwl;
  public QQAppInterface a;
  
  public aqns(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_Aqwl == null) {
      a();
    }
    arni.a();
    if (this.jdField_a_of_type_Aqnv == null) {
      this.jdField_a_of_type_Aqnv = new aqnv(this, null);
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
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_Aqnv, paramQQAppInterface);
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
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    return;
    if (localFileManagerEntity.peerUin.equals(aljq.A)) {}
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
    arni.b(paramFileManagerEntity.nSessionId);
    if (!bdee.d(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    bkev.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  /* Error */
  public aqnm a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 313	aqns:jdField_a_of_type_Aqnm	Laqnm;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 315	aqnm
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aqns:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 317	aqnm:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 313	aqns:jdField_a_of_type_Aqnm	Laqnm;
    //   26: aload_0
    //   27: getfield 313	aqns:jdField_a_of_type_Aqnm	Laqnm;
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
    //   0	47	0	this	aqns
    //   30	6	1	localaqnm	aqnm
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
  public aqoz a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 320	aqns:jdField_a_of_type_Aqoz	Laqoz;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 322	aqoz
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aqns:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 323	aqoz:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 320	aqns:jdField_a_of_type_Aqoz	Laqoz;
    //   26: aload_0
    //   27: getfield 320	aqns:jdField_a_of_type_Aqoz	Laqoz;
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
    //   0	47	0	this	aqns
    //   30	6	1	localaqoz	aqoz
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
  public aqpr a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 326	aqns:jdField_a_of_type_Aqpr	Laqpr;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 328	aqpr
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aqns:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 329	aqpr:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 326	aqns:jdField_a_of_type_Aqpr	Laqpr;
    //   26: aload_0
    //   27: getfield 326	aqns:jdField_a_of_type_Aqpr	Laqpr;
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
    //   0	47	0	this	aqns
    //   30	6	1	localaqpr	aqpr
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
  public aqpv a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 332	aqns:jdField_a_of_type_Aqpv	Laqpv;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 334	aqpv
    //   15: dup
    //   16: aload_0
    //   17: getfield 26	aqns:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 335	aqpv:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 332	aqns:jdField_a_of_type_Aqpv	Laqpv;
    //   26: aload_0
    //   27: getfield 332	aqns:jdField_a_of_type_Aqpv	Laqpv;
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
    //   0	47	0	this	aqns
    //   30	6	1	localaqpv	aqpv
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
  
  public aqvu a()
  {
    try
    {
      if (this.jdField_a_of_type_Aqvu == null) {
        this.jdField_a_of_type_Aqvu = new aqvu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aqvu localaqvu = this.jdField_a_of_type_Aqvu;
      return localaqvu;
    }
    finally {}
  }
  
  public aqvx a()
  {
    if (this.jdField_a_of_type_Aqvx == null) {}
    try
    {
      if (this.jdField_a_of_type_Aqvx == null)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
        this.jdField_a_of_type_Aqvx = new aqvx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aqvx;
    }
    finally {}
  }
  
  public aqwl a()
  {
    try
    {
      if (this.jdField_a_of_type_Aqwl == null) {
        this.jdField_a_of_type_Aqwl = new aqwl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aqwl localaqwl = this.jdField_a_of_type_Aqwl;
      return localaqwl;
    }
    finally {}
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = arni.a().longValue();
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
      arni.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = arni.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = arni.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = ayvw.a(-1000).uniseq;
    localFileManagerEntity.nOpType = 26;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1)) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      localFileManagerEntity.srvTime = (ayvc.a() * 1000L);
      localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = arni.a();
      localFileManagerEntity.msgUid = arni.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + arni.a(localFileManagerEntity));
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
      arni.a();
      return null;
    }
    String str = bauj.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = arni.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = arni.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = ayvw.a(-1000).uniseq;
    aeyf.a().a(l, paramLong, paramInt2);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (ayvc.a() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = arni.a();
    localFileManagerEntity.msgUid = arni.b();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + arni.a(localFileManagerEntity));
    }
    arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, ayvc.a());
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
    String str2 = bauj.a(paramString1, 0L, 0, true);
    String str1 = arni.a(paramString1);
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
        l = ayvw.a(-1000).uniseq;
        aeyf.a().a(l, paramLong, paramInt2);
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt1);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = arni.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt1);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (ayvc.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = arni.a(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = arni.a();
      localFileManagerEntity.msgUid = arni.b();
      localFileManagerEntity.strThumbPath = arni.a(paramString1, 150, 150);
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
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
      if (arna.a(localFileManagerEntity.getFilePath(), new aqnt(this, localFileManagerEntity, paramString2))) {
        break;
      }
      arnu.a().execute(paramString2);
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
    arnu.a().execute(paramString2);
    return localFileManagerEntity;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Aqtx == null) {}
    try
    {
      if (this.jdField_a_of_type_Aqtx == null) {
        this.jdField_a_of_type_Aqtx = new aqtx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aqtx.a(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_Aqrw == null) {}
    try
    {
      if (this.jdField_a_of_type_Aqrw == null) {
        this.jdField_a_of_type_Aqrw = new aqrw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aqrw.a(paramFileManagerEntity, paramInt);
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
    while (i < aqxj.c().size())
    {
      localObject = (OfflineFileInfo)aqxj.c().get(i);
      localArrayList.add(a(arni.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).a)));
      i += 1;
    }
    i = 0;
    while (i < aqxj.b().size())
    {
      localObject = (FileManagerEntity)aqxj.b().get(i);
      if (((FileManagerEntity)localObject).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else
      {
        arna.a((FileManagerEntity)localObject);
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
          if (!bdcs.b(((FileManagerEntity)localObject).getFilePath())) {
            break;
          }
          localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          continue;
          localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
        }
      }
    }
    Object localObject = aqxj.a().iterator();
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
          aroj localaroj = arni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localFileManagerEntity.strTroopFileUuid = localaroj.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId, paramLong2, paramInt2);
          localFileManagerEntity.mContext = localaroj;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (bdee.d(BaseApplication.getContext())) {
          break label520;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131694829);
        localFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof aroj)) {
          ((aroj)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong1, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, arni.a());
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
    int k = aqxj.d().size();
    int j = aqxj.c().size();
    Iterator localIterator = aqxj.b().iterator();
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
      int m = aqxj.b().size() - i;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= v> Download All Select File Start!, weiyun[" + k + "],offline[" + j + "],recent[" + m + "]");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + aqxj.d().size() + "], offline[" + aqxj.c().size() + "], recent[" + (aqxj.b().size() - i) + "], localfile[" + aqxj.a().size() + "]");
      }
      if ((i > 0) && (m == 0) && (k == 0) && (j == 0))
      {
        bdcd.a(paramContext, 230).setMessage(paramContext.getString(2131692758)).setNegativeButton(2131720083, new aqnu(this)).show();
        return;
      }
      i = 0;
      while (i < k)
      {
        paramContext = arni.a((WeiYunFileInfo)aqxj.d().get(i));
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
        paramContext = arni.a((OfflineFileInfo)aqxj.c().get(i), 0);
        paramContext.status = 2;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
        i += 1;
      }
      i = 0;
      label460:
      if (i < aqxj.b().size())
      {
        paramContext = (FileManagerEntity)aqxj.b().get(i);
        arna.a(paramContext);
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
            QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + arni.a(paramContext));
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
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, aqxi paramaqxi)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, paramaqxi);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, paramaqxi);
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
    arni.b(paramFileManagerEntity.nSessionId);
    if (!bdee.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131692745);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opType[" + paramFileManagerEntity.nOpType + "]");
    Object localObject = (atvt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
    if ((localObject != null) && (((atvt)localObject).a(paramFileManagerEntity.peerUin)))
    {
      arni.a(alpo.a(2131704936));
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
    arni.b(paramFileManagerEntity.nSessionId);
    if ((paramInt1 != 27) && (!bdee.d(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
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
        throw new NullPointerException(alpo.a(2131704934));
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
          localObject = arni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramFileManagerEntity.strTroopFileUuid = ((aroj)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId, paramLong, paramInt2);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        paramInt2 = paramFileManagerEntity.busId;
        i = paramInt2;
        if (!bdee.d(BaseApplication.getContext()))
        {
          i = paramInt2;
          if ((paramFileManagerEntity.mContext instanceof aroj))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131694829);
            ((aroj)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + arni.a(paramFileManagerEntity));
    }
    if (paramInt1 == 20) {
      bkev.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
    arni.b(paramFileManagerEntity.nSessionId);
    arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt1, false);
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
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + arni.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    Object localObject = aqxj.a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((FileInfo)((Iterator)localObject).next()).c();
      try
      {
        new VFSFile(str).delete();
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
      if (i >= aqxj.d().size()) {
        break;
      }
      a((WeiYunFileInfo)aqxj.d().get(i));
      i += 1;
    }
    while (j < aqxj.b().size())
    {
      localObject = (FileManagerEntity)aqxj.b().get(j);
      arna.a((FileManagerEntity)localObject);
      b(((FileManagerEntity)localObject).nSessionId);
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int i = aqxj.d().size();
    int j = aqxj.c().size();
    int k = aqxj.b().size();
    int m = aqxj.a().size();
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^> Send All Select File Start!, weiyun[" + i + "],offline[" + j + "],recent[" + k + "],local[" + m + "] sendUin[" + arni.e(paramString1) + "] recvUin[" + arni.e(paramString2) + "] peerType[" + paramInt + "]");
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("last_select_send", true);
        ((SharedPreferences.Editor)localObject1).commit();
        if ((aqxj.d().size() == 0) && (aqxj.c().size() == 0))
        {
          localObject1 = aqxj.a();
          Object localObject2 = aqxj.b();
          i = 0;
          Object localObject3 = ((Set)localObject1).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!arof.b(((FileInfo)((Iterator)localObject3).next()).c())) {
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
              armz.a(2131692939);
              return;
              if (i >= aqxj.d().size()) {
                continue;
              }
              localObject1 = (WeiYunFileInfo)aqxj.d().get(i);
              arng.a("0X8005415");
              b(arni.a((WeiYunFileInfo)localObject1), paramString1, paramString2, paramInt);
              i += 1;
              continue;
              if (i >= aqxj.c().size()) {
                break label1093;
              }
              localObject1 = (OfflineFileInfo)aqxj.c().get(i);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(arni.a((OfflineFileInfo)localObject1, paramInt), paramString1, paramString2, paramInt, true);
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
              if (i < aqxj.b().size())
              {
                localObject1 = (FileManagerEntity)aqxj.b().get(i);
                if (((FileManagerEntity)localObject1).sendCloudUnsuccessful())
                {
                  QLog.w("FileManagerEngine<FileAssistant>", 1, "Id[" + ((FileManagerEntity)localObject1).nSessionId + "] unSend success!");
                  break label1099;
                }
                if ((((FileManagerEntity)localObject1).fileSize <= 20971520L) && (paramBoolean) && (aqxj.b((FileManagerEntity)localObject1)))
                {
                  new bado(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((FileManagerEntity)localObject1, paramString1, paramString2, paramInt);
                  break label1099;
                }
                arna.a((FileManagerEntity)localObject1);
                arng.a("0X8005413");
                a(((FileManagerEntity)localObject1).nSessionId, paramString1, paramString2, paramInt, true);
                break label1099;
              }
              localObject1 = aqxj.a().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (FileInfo)((Iterator)localObject1).next();
                localObject3 = ((FileInfo)localObject2).c();
                if ((paramBoolean) && (((FileInfo)localObject2).a() <= 20971520L) && (aqxj.b((FileInfo)localObject2)))
                {
                  new bado(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject3, paramString1, paramString2, paramInt);
                  continue;
                }
                arng.a("0X8005414");
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
                if (aqxj.d().size() > 0) {
                  i = 1;
                }
                j = i;
                if (aqxj.a().size() > 0) {
                  j = i + 10;
                }
                if (aqxj.b().size() > 0)
                {
                  i = j + 100;
                  azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
                }
              }
              else
              {
                i = arni.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                if ((paramInt != 0) || (i >= 3) || (!arni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2))) {
                  continue;
                }
                arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, false);
                paramString1 = BaseApplicationImpl.getContext().getString(2131698659);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, -3009, paramString1);
                arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i + 1);
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
      localObject = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((aroj)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    while (!bdee.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131694829);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof aroj)) {
        ((aroj)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return false;
      if (paramFileManagerEntity.mContext == null) {
        paramFileManagerEntity.mContext = arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
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
    arnh localarnh;
    if (1 == localFileManagerEntity.nOpType)
    {
      localarnh = new arnh();
      localarnh.b = "recv_file_cancel";
      arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localarnh);
    }
    while (paramLong > 0L)
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localarnh = new arnh();
        localarnh.b = "send_file_cancel";
        arng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localarnh);
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
    bbpe localbbpe1 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, localFileManagerEntity.Uuid, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if ((localbbpe1 == null) || (localbbpe1.e == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      int j = Math.abs(new Random().nextInt());
      bbpe localbbpe2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(localbbpe1.e, paramLong2, localbbpe1.g, localbbpe1.jdField_a_of_type_JavaLangString, localbbpe1.c, localbbpe1.h, j, paramLong1);
      if (localbbpe2 == null)
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
        return false;
      }
      paramInt1 = arni.a(localbbpe1.g);
      if (paramInt1 == 0) {
        if (arof.a(localbbpe1.jdField_a_of_type_JavaLangString))
        {
          paramString = new BitmapFactory.Options();
          paramString.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(localbbpe1.jdField_a_of_type_JavaLangString, paramString);
          paramLong2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbbpe2.g, localbbpe2.c, localbbpe2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localbbpe1.b), paramLong1, paramString.outWidth, paramString.outHeight, paramLong4, paramInt3);
        }
      }
      for (;;)
      {
        localFileManagerEntity.structMsgSeq = paramLong2;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
        }
        return true;
        paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(localbbpe1.b), 1, localbbpe1.e);
        if (paramString != null)
        {
          paramLong2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbbpe2.g, localbbpe2.c, localbbpe2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localbbpe1.b), paramLong1, paramString.width, paramString.height, paramLong4, paramInt3);
        }
        else
        {
          paramLong2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbbpe2.g, localbbpe2.c, localbbpe2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localbbpe1.b), paramLong1, paramLong4, paramInt3);
          continue;
          if (paramInt1 == 2)
          {
            paramInt1 = 0;
            paramInt2 = 0;
            int i = 0;
            if (arof.a(localbbpe1.jdField_a_of_type_JavaLangString))
            {
              paramString = ShortVideoUtils.a(paramString);
              paramInt1 = paramString[0];
              paramInt2 = paramString[1];
              i = paramString[3];
            }
            for (;;)
            {
              paramLong2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbbpe2.g, localbbpe2.c, localbbpe2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localbbpe1.b), paramLong1, paramInt1, paramInt2, i, paramLong4, paramInt3);
              break;
              paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(localbbpe1.b), 1, localbbpe1.e);
              if (paramString != null)
              {
                paramInt1 = paramString.width;
                paramInt2 = paramString.height;
                i = paramString.duration;
              }
            }
          }
          paramLong2 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbbpe2.g, localbbpe2.c, localbbpe2.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(localbbpe1.b), paramLong1, paramLong4, paramInt3);
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
      paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, false, 0L, arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), paramLong4, paramInt3);
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
          paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0), paramLong4, paramInt3);
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
            paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, 7, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1), paramLong4, paramInt3);
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
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + arni.a(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      arni.c(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      arni.b(localFileManagerEntity.nSessionId);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramInt1);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt1);
      continue;
      if (aqxh.a(localFileManagerEntity.Uuid))
      {
        badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, paramString2, paramInt1);
      }
      else if ((localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + arni.e(paramString1) + "], recvUin[" + arni.e(paramString2) + "], peerType[" + paramInt1 + "], toOffline[" + paramBoolean + "]");
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
        arni.b(((FileManagerEntity)localObject).nSessionId);
        arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
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
    VFSFile localVFSFile;
    if (localObject != null)
    {
      i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      localVFSFile = new VFSFile(paramString1);
      if (arni.a(paramString1) != 0) {
        break label138;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      aroa.a(paramString1, localOptions);
      bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bbpe)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight, paramLong, paramInt);
    }
    for (;;)
    {
      return true;
      label138:
      if (arni.a(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.a(paramString1);
        bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bbpe)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramString1[0], paramString1[1], paramString1[2], paramLong, paramInt);
      }
      else
      {
        bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bbpe)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramLong, paramInt);
      }
    }
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Aqrz == null) {}
    try
    {
      if (this.jdField_a_of_type_Aqrz == null) {
        this.jdField_a_of_type_Aqrz = new aqrz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Aqrz.a(paramFileManagerEntity, 7);
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
    b(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to Troop ");
      a().a(paramFileManagerEntity, paramString2, paramInt2);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to offline ");
      a(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
  }
  
  public void b(String paramString)
  {
    a().a(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aqwl.a(paramString1, paramString2);
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
      if (!arni.b(localFileManagerEntity.getFilePath())) {
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
    String str = arni.d(paramFileManagerEntity);
    if (arof.b(str)) {
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
    BaseApplicationImpl.sApplication.unregisterReceiver(this.jdField_a_of_type_Aqnv);
    this.jdField_a_of_type_Aqnv = null;
    armo.a().b();
    ardf.a().c();
    aqsz.a();
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
 * Qualified Name:     aqns
 * JD-Core Version:    0.7.0.1
 */