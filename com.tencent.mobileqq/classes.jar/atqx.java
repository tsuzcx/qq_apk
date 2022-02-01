import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.os.Bundle;
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
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class atqx
{
  private atlm jdField_a_of_type_Atlm;
  atqr jdField_a_of_type_Atqr;
  atrb jdField_a_of_type_Atrb = null;
  private atrc jdField_a_of_type_Atrc;
  private atrw jdField_a_of_type_Atrw;
  private atrz jdField_a_of_type_Atrz;
  private atsi jdField_a_of_type_Atsi;
  private atto jdField_a_of_type_Atto;
  private atud jdField_a_of_type_Atud;
  private atug jdField_a_of_type_Atug;
  private atvy jdField_a_of_type_Atvy;
  private atwp jdField_a_of_type_Atwp;
  atym jdField_a_of_type_Atym;
  private atyp jdField_a_of_type_Atyp;
  aurp jdField_a_of_type_Aurp;
  public QQAppInterface a;
  
  public atqx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_Aurp == null) {
      a();
    }
    aunj.a();
    if (this.jdField_a_of_type_Atrb == null) {
      this.jdField_a_of_type_Atrb = new atrb(this, null);
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
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_Atrb, paramQQAppInterface);
      label116:
      g();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      break label116;
    }
  }
  
  private void b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      return;
    }
    switch (localFileManagerEntity.nOpType)
    {
    default: 
      QLog.e("FileManagerEngine<FileAssistant>", 1, "unknow operation type!");
      return;
    case 0: 
    case 1: 
    case 5: 
    case 6: 
    case 8: 
    case 50: 
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.setCloudType(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
    case 3: 
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
    case 7: 
    case 28: 
      a(localFileManagerEntity);
      return;
    case 4: 
      c(localFileManagerEntity);
      return;
    case 20: 
    case 21: 
    case 22: 
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
    case 9: 
    case 10: 
    case 13: 
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.bDelInFM = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
        return;
      }
      QLog.e("FileManagerEngine<FileAssistant>", 1, "err cloud type.when reTry :" + localFileManagerEntity.getCloudType());
      return;
    case 24: 
    case 25: 
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return;
    }
    if (localFileManagerEntity.peerUin.equals(antf.A)) {}
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
    aunj.b(paramFileManagerEntity.nSessionId);
    if (!bhnv.d(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    bnyz.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(25, paramFileManagerEntity);
  }
  
  private void g()
  {
    audj.a().a(false);
  }
  
  /* Error */
  public atlm a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 328	atqx:jdField_a_of_type_Atlm	Latlm;
    //   8: ifnonnull +25 -> 33
    //   11: aload_0
    //   12: new 330	atlm
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 332	atlm:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 328	atqx:jdField_a_of_type_Atlm	Latlm;
    //   26: aload_0
    //   27: getfield 328	atqx:jdField_a_of_type_Atlm	Latlm;
    //   30: invokevirtual 334	atlm:b	()V
    //   33: aload_0
    //   34: getfield 328	atqx:jdField_a_of_type_Atlm	Latlm;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: areturn
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	atqx
    //   37	6	1	localatlm	atlm
    //   44	4	1	localObject1	Object
    //   49	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	33	44	finally
    //   33	40	44	finally
    //   45	47	44	finally
    //   2	4	49	finally
    //   47	49	49	finally
  }
  
  /* Error */
  public atqr a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 337	atqx:jdField_a_of_type_Atqr	Latqr;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 339	atqr
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 340	atqr:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 337	atqx:jdField_a_of_type_Atqr	Latqr;
    //   26: aload_0
    //   27: getfield 337	atqx:jdField_a_of_type_Atqr	Latqr;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatqr	atqr
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
  public atrc a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 343	atqx:jdField_a_of_type_Atrc	Latrc;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 345	atrc
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 346	atrc:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 343	atqx:jdField_a_of_type_Atrc	Latrc;
    //   26: aload_0
    //   27: getfield 343	atqx:jdField_a_of_type_Atrc	Latrc;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatrc	atrc
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
  public atrw a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 349	atqx:jdField_a_of_type_Atrw	Latrw;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 351	atrw
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 352	atrw:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 349	atqx:jdField_a_of_type_Atrw	Latrw;
    //   26: aload_0
    //   27: getfield 349	atqx:jdField_a_of_type_Atrw	Latrw;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatrw	atrw
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
  public atrz a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 355	atqx:jdField_a_of_type_Atrz	Latrz;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 357	atrz
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 358	atrz:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 355	atqx:jdField_a_of_type_Atrz	Latrz;
    //   26: aload_0
    //   27: getfield 355	atqx:jdField_a_of_type_Atrz	Latrz;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatrz	atrz
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
  public atsi a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 361	atqx:jdField_a_of_type_Atsi	Latsi;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 363	atsi
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 364	atsi:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 361	atqx:jdField_a_of_type_Atsi	Latsi;
    //   26: aload_0
    //   27: getfield 361	atqx:jdField_a_of_type_Atsi	Latsi;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatsi	atsi
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
  public atto a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 367	atqx:jdField_a_of_type_Atto	Latto;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 369	atto
    //   15: dup
    //   16: aload_0
    //   17: getfield 30	atqx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 370	atto:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 367	atqx:jdField_a_of_type_Atto	Latto;
    //   26: aload_0
    //   27: getfield 367	atqx:jdField_a_of_type_Atto	Latto;
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
    //   0	47	0	this	atqx
    //   30	6	1	localatto	atto
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
  
  public atvy a()
  {
    try
    {
      if (this.jdField_a_of_type_Atvy == null)
      {
        this.jdField_a_of_type_Atvy = new atvy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Atvy.a();
      }
      atvy localatvy = this.jdField_a_of_type_Atvy;
      return localatvy;
    }
    finally {}
  }
  
  public atym a()
  {
    try
    {
      if (this.jdField_a_of_type_Atym == null) {
        this.jdField_a_of_type_Atym = new atym(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      atym localatym = this.jdField_a_of_type_Atym;
      return localatym;
    }
    finally {}
  }
  
  public atyp a()
  {
    if (this.jdField_a_of_type_Atyp == null) {}
    try
    {
      if (this.jdField_a_of_type_Atyp == null)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
        this.jdField_a_of_type_Atyp = new atyp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Atyp;
    }
    finally {}
  }
  
  public aurp a()
  {
    try
    {
      if (this.jdField_a_of_type_Aurp == null) {
        this.jdField_a_of_type_Aurp = new aurp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aurp localaurp = this.jdField_a_of_type_Aurp;
      return localaurp;
    }
    finally {}
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = aunj.a().longValue();
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
      aunj.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = aunj.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = aunj.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = bcry.a(-1000).uniseq;
    localFileManagerEntity.nOpType = 26;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1)) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
    {
      localFileManagerEntity.srvTime = (bcrg.a() * 1000L);
      localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = aunj.a();
      localFileManagerEntity.msgUid = aunj.b();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + aunj.a(localFileManagerEntity));
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
      aunj.a();
      return null;
    }
    String str = beyo.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = aunj.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = aunj.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = bcry.a(-1000).uniseq;
    agsg.a().a(l, paramLong, paramInt2);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (bcrg.a() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = aunj.a();
    localFileManagerEntity.msgUid = aunj.b();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + aunj.a(localFileManagerEntity));
    }
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, bcrg.a());
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
    String str2 = beyo.a(paramString1, 0L, 0, true);
    String str1 = aunj.a(paramString1);
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
        l = bcry.a(-1000).uniseq;
        agsg.a().a(l, paramLong, paramInt2);
      }
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString3, paramInt1);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = aunj.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt1);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (bcrg.a() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = aunj.a(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = aunj.a();
      localFileManagerEntity.msgUid = aunj.b();
      localFileManagerEntity.strThumbPath = aunj.a(paramString1, 150, 150);
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
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
      if (aunb.a(localFileManagerEntity.getFilePath(), new atqy(this, localFileManagerEntity, paramString2))) {
        break;
      }
      aunu.a().execute(paramString2);
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
    aunu.a().execute(paramString2);
    return localFileManagerEntity;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Atwp == null) {}
    try
    {
      if (this.jdField_a_of_type_Atwp == null) {
        this.jdField_a_of_type_Atwp = new atwp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Atwp.a(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_Atud == null) {}
    try
    {
      if (this.jdField_a_of_type_Atud == null) {
        this.jdField_a_of_type_Atud = new atud(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Atud.a(paramFileManagerEntity, paramInt);
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
    while (i < atyw.c().size())
    {
      localObject = (OfflineFileInfo)atyw.c().get(i);
      localArrayList.add(a(aunj.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).a)));
      i += 1;
    }
    i = 0;
    while (i < atyw.b().size())
    {
      localObject = (FileManagerEntity)atyw.b().get(i);
      if (((FileManagerEntity)localObject).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else
      {
        aunb.a((FileManagerEntity)localObject);
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
          if (!bhmi.b(((FileManagerEntity)localObject).getFilePath())) {
            break;
          }
          localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          continue;
          localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
        }
      }
    }
    Object localObject = atyw.a().iterator();
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
          auok localauok = aunj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localFileManagerEntity.strTroopFileUuid = localauok.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId, paramLong2, paramInt2);
          localFileManagerEntity.mContext = localauok;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (bhnv.d(BaseApplication.getContext())) {
          break label520;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131694008);
        localFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof auok)) {
          ((auok)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong1, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, aunj.a());
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
    int k = atyw.d().size();
    int j = atyw.c().size();
    Iterator localIterator = atyw.b().iterator();
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
      int m = atyw.b().size() - i;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= v> Download All Select File Start!, weiyun[" + k + "],offline[" + j + "],recent[" + m + "]");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + atyw.d().size() + "], offline[" + atyw.c().size() + "], recent[" + (atyw.b().size() - i) + "], localfile[" + atyw.a().size() + "]");
      }
      if ((i > 0) && (m == 0) && (k == 0) && (j == 0))
      {
        bhlq.a(paramContext, 230).setMessage(paramContext.getString(2131692332)).setNegativeButton(2131718195, new atra(this)).show();
        return;
      }
      i = 0;
      while (i < k)
      {
        paramContext = aunj.a((WeiYunFileInfo)atyw.d().get(i));
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
        paramContext = aunj.a((OfflineFileInfo)atyw.c().get(i), 0);
        paramContext.status = 2;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
        i += 1;
      }
      i = 0;
      label460:
      if (i < atyw.b().size())
      {
        paramContext = (FileManagerEntity)atyw.b().get(i);
        aunb.a(paramContext);
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
            QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + aunj.a(paramContext));
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
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, atyv paramatyv)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, paramatyv);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, paramatyv);
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
    aunj.b(paramFileManagerEntity.nSessionId);
    if (!bhnv.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131692319);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(0), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opType[" + paramFileManagerEntity.nOpType + "]");
    Object localObject = (axad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
    if ((localObject != null) && (((axad)localObject).a(paramFileManagerEntity.peerUin)))
    {
      aunj.a(anzj.a(2131703452));
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
    aunj.b(paramFileManagerEntity.nSessionId);
    if ((paramInt1 != 27) && (!bhnv.d(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
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
        throw new NullPointerException(anzj.a(2131703450));
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
          localObject = aunj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramFileManagerEntity.strTroopFileUuid = ((auok)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId, paramLong, paramInt2);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        paramInt2 = paramFileManagerEntity.busId;
        i = paramInt2;
        if (!bhnv.d(BaseApplication.getContext()))
        {
          i = paramInt2;
          if ((paramFileManagerEntity.mContext instanceof auok))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131694008);
            ((auok)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + aunj.a(paramFileManagerEntity));
    }
    if (paramInt1 == 20) {
      bnyz.a();
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
    aunj.b(paramFileManagerEntity.nSessionId);
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt1, false);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().a(paramWeiYunFileInfo);
  }
  
  public void a(String paramString)
  {
    a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    while (i < atyw.d().size())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)atyw.d().get(i);
      aunh.a("0X8005415");
      b(aunj.a(localWeiYunFileInfo), paramString1, paramString2, paramInt);
      i += 1;
    }
    if (atyw.d().size() > 0) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB7", "0X800AFB7", 0, atyw.d().size(), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + aunj.e(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString3, paramString4, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    Object localObject = new ArrayList();
    Iterator localIterator = atyw.a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((FileInfo)localIterator.next()).c();
      try
      {
        VFSFile localVFSFile = new VFSFile(str);
        ((List)localObject).add(str);
        localVFSFile.delete();
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException.toString());
      }
    }
    if (((List)localObject).size() > 0) {
      MediaScannerConnection.scanFile(BaseApplication.getContext(), (String[])((List)localObject).toArray(new String[0]), null, null);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= atyw.d().size()) {
        break;
      }
      a((WeiYunFileInfo)atyw.d().get(i));
      i += 1;
    }
    while (j < atyw.b().size())
    {
      localObject = (FileManagerEntity)atyw.b().get(j);
      aunb.a((FileManagerEntity)localObject);
      b(((FileManagerEntity)localObject).nSessionId);
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int i = atyw.d().size();
    int j = atyw.c().size();
    int k = atyw.b().size();
    int m = atyw.a().size();
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^> Send All Select File Start!, weiyun[" + i + "],offline[" + j + "],recent[" + k + "],local[" + m + "] sendUin[" + aunj.e(paramString1) + "] recvUin[" + aunj.e(paramString2) + "] peerType[" + paramInt + "]");
    label610:
    label613:
    label616:
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("last_select_send", true);
        ((SharedPreferences.Editor)localObject).commit();
        if ((atyw.d().size() == 0) && (atyw.c().size() == 0) && (atyw.e().size() == 0))
        {
          localObject = atyw.a();
          ArrayList localArrayList = atyw.b();
          i = 0;
          Iterator localIterator = ((Set)localObject).iterator();
          if (localIterator.hasNext())
          {
            if (auog.b(((FileInfo)localIterator.next()).c())) {
              break label613;
            }
            i += 1;
            break label613;
          }
          localIterator = localArrayList.iterator();
          if (localIterator.hasNext())
          {
            if (((FileManagerEntity)localIterator.next()).status != 16) {
              break label610;
            }
            i += 1;
            break label616;
          }
          if (i == ((Set)localObject).size() + localArrayList.size())
          {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^! Send All Select File is INVALID ");
            auna.a(2131692472);
            return;
          }
        }
        a(paramString1, paramString2, paramInt);
        b(paramString1, paramString2, paramInt);
        b(paramBoolean, paramString1, paramString2, paramInt);
        c(paramBoolean, paramString1, paramString2, paramInt);
        c(paramString1, paramString2, paramInt);
        if (paramInt == 1)
        {
          i = 0;
          if (atyw.d().size() > 0) {
            i = 1;
          }
          j = i;
          if (atyw.a().size() > 0) {
            j = i + 10;
          }
          if (atyw.b().size() > 0)
          {
            i = j + 100;
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
          }
        }
        else
        {
          i = aunj.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((paramInt != 0) || (i >= 3) || (!aunj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2))) {
            break;
          }
          aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, false);
          paramString1 = BaseApplicationImpl.getContext().getString(2131697612);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, -3009, paramString1);
          aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i + 1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.getMessage());
        return;
      }
      i = j;
      continue;
      break label616;
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
      localObject = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((auok)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    while (!bhnv.d(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131694008);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof auok)) {
        ((auok)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return false;
      if (paramFileManagerEntity.mContext == null) {
        paramFileManagerEntity.mContext = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
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
    auni localauni;
    if (1 == localFileManagerEntity.nOpType)
    {
      localauni = new auni();
      localauni.b = "recv_file_cancel";
      aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
    }
    while (paramLong > 0L)
    {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localauni = new auni();
        localauni.b = "send_file_cancel";
        aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
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
    Object localObject = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, localFileManagerEntity.Uuid, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if ((localObject == null) || (((bftf)localObject).e == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      int j = Math.abs(new Random().nextInt());
      bftf localbftf = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(((bftf)localObject).e, paramLong2, ((bftf)localObject).g, ((bftf)localObject).jdField_a_of_type_JavaLangString, ((bftf)localObject).c, ((bftf)localObject).h, j, paramLong1);
      if (localbftf == null)
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
        return false;
      }
      paramInt1 = aunj.a(((bftf)localObject).g);
      if (paramInt1 == 0) {
        if (auog.a(((bftf)localObject).jdField_a_of_type_JavaLangString))
        {
          paramString = new BitmapFactory.Options();
          paramString.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(((bftf)localObject).jdField_a_of_type_JavaLangString, paramString);
          paramLong2 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbftf.g, localbftf.c, localbftf.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(((bftf)localObject).b), paramLong1, paramString.outWidth, paramString.outHeight, paramLong4, paramInt3);
        }
      }
      for (;;)
      {
        localFileManagerEntity.structMsgSeq = paramLong2;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
        }
        return true;
        paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((bftf)localObject).b), 1, ((bftf)localObject).e);
        if (paramString != null)
        {
          paramLong2 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbftf.g, localbftf.c, localbftf.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(((bftf)localObject).b), paramLong1, paramString.width, paramString.height, paramLong4, paramInt3);
        }
        else
        {
          paramLong2 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbftf.g, localbftf.c, localbftf.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(((bftf)localObject).b), paramLong1, paramLong4, paramInt3);
          continue;
          if (paramInt1 == 2)
          {
            paramInt1 = 0;
            paramInt2 = 0;
            int i = 0;
            if (auog.a(((bftf)localObject).jdField_a_of_type_JavaLangString))
            {
              paramString = ShortVideoUtils.a(paramString);
              paramInt1 = paramString[0];
              paramInt2 = paramString[1];
              i = paramString[3];
            }
            for (;;)
            {
              paramLong2 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbftf.g, localbftf.c, localbftf.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(((bftf)localObject).b), paramLong1, paramInt1, paramInt2, i, paramLong4, paramInt3);
              break;
              paramString = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(((bftf)localObject).b), 1, ((bftf)localObject).e);
              if (paramString != null)
              {
                paramInt1 = paramString.width;
                paramInt2 = paramString.height;
                i = paramString.duration;
              }
            }
          }
          paramLong2 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), localbftf.g, localbftf.c, localbftf.jdField_a_of_type_JavaUtilUUID.toString(), j, String.valueOf(((bftf)localObject).b), paramLong1, paramLong4, paramInt3);
        }
      }
    }
    if ((paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
      if (paramLong2 != 0L) {
        break label1113;
      }
    }
    label1107:
    label1113:
    for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
    {
      localObject = new Bundle();
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkPackageName)) {
        ((Bundle)localObject).putString("yyb_apk_package_name_key", localFileManagerEntity.yybApkPackageName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkName)) {
        ((Bundle)localObject).putString("yyb_apk_name_key", localFileManagerEntity.yybApkName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkIconUrl)) {
        ((Bundle)localObject).putString("yyb_apk_icon_url_key", localFileManagerEntity.yybApkIconUrl);
      }
      paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, false, 0L, aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), paramLong4, paramInt3, (Bundle)localObject);
      return true;
      if (paramInt1 == 7)
      {
        paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
        if (paramLong2 != 0L) {
          break label1107;
        }
      }
      for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
      {
        if (localFileManagerEntity.datalineEntitySessionId != 0L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0), paramLong4, paramInt3, null);
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
            paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, 7, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1), paramLong4, paramInt3, null);
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
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + aunj.a(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      aunj.b(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      aunj.b(localFileManagerEntity.nSessionId);
      if (TextUtils.isEmpty(paramString1)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramInt1);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt1);
      continue;
      if (atyu.a(localFileManagerEntity.Uuid))
      {
        becb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, paramString2, paramInt1);
      }
      else if ((localFileManagerEntity.getCloudType() == 1) && (!TextUtils.isEmpty(localFileManagerEntity.Uuid)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + aunj.e(paramString1) + "], recvUin[" + aunj.e(paramString2) + "], peerType[" + paramInt1 + "], toOffline[" + paramBoolean + "]");
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
        aunj.b(((FileManagerEntity)localObject).nSessionId);
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
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
      else
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt1, int paramInt2)
  {
    bmlg localbmlg;
    if (paramInt1 == 1)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send FavFile to Troop ");
      if (auog.b(paramFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.getFilePath(), paramString, 0L, paramInt2);
        return true;
      }
      localbmlg = new bmlg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbmlg != null) {
        localbmlg.a(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
      }
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 6000)
      {
        localbmlg = new bmlg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localbmlg != null) {
          localbmlg.c(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
        }
      }
      else if (paramInt1 == 0)
      {
        localbmlg = new bmlg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localbmlg != null) {
          localbmlg.b(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send QfavFile to offline ");
      }
      else
      {
        if (paramInt1 != 3000) {
          break label274;
        }
        if (!auog.b(paramFileManagerEntity.getFilePath())) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString, paramInt1, true, 0L, paramInt2);
      }
    }
    auna.a(2131692484);
    return false;
    label274:
    QLog.e("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send QfavFile to peerType:" + paramInt1);
    auna.a(2131692484);
    return false;
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
      if (aunj.a(paramString1) != 0) {
        break label138;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      auob.a(paramString1, localOptions);
      bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bftf)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight, paramLong, paramInt);
    }
    for (;;)
    {
      return true;
      label138:
      if (aunj.a(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.a(paramString1);
        bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bftf)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramString1[0], paramString1[1], paramString1[2], paramLong, paramInt);
      }
      else
      {
        bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((bftf)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramLong, paramInt);
      }
    }
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Atug == null) {}
    try
    {
      if (this.jdField_a_of_type_Atug == null) {
        this.jdField_a_of_type_Atug = new atug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Atug.a(paramFileManagerEntity, 7);
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
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    if (i < atyw.c().size())
    {
      Object localObject = (OfflineFileInfo)atyw.c().get(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aunj.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt, true);
      ((FileManagerEntity)localObject).peerType = paramInt;
      ((FileManagerEntity)localObject).status = 2;
      if (paramInt == 3000)
      {
        ((FileManagerEntity)localObject).nOpType = 28;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] sendOffline2Disc[" + ((FileManagerEntity)localObject).fileName + "]");
      }
      for (;;)
      {
        a((FileManagerEntity)localObject);
        i += 1;
        break;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] sendOffline2Offline[" + ((FileManagerEntity)localObject).fileName + "]");
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    if (i < atyw.b().size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)atyw.b().get(i);
      if (localFileManagerEntity.sendCloudUnsuccessful()) {
        QLog.w("FileManagerEngine<FileAssistant>", 1, "Id[" + localFileManagerEntity.nSessionId + "] unSend success!");
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localFileManagerEntity.fileSize <= 20971520L) && (paramBoolean) && (atyw.b(localFileManagerEntity)))
        {
          new bebw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localFileManagerEntity, paramString1, paramString2, paramInt);
        }
        else
        {
          aunb.a(localFileManagerEntity);
          aunh.a("0X8005413");
          a(localFileManagerEntity.nSessionId, paramString1, paramString2, paramInt, true);
        }
      }
    }
    if (atyw.b().size() > 0) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB4", "0X800AFB4", 0, atyw.b().size(), 0, "", "", "", "");
    }
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
      if (!aunj.b(localFileManagerEntity.getFilePath())) {
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
    String str = aunj.d(paramFileManagerEntity);
    if (auog.b(str)) {
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
  
  public void c(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aurp.a(paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    if (atyw.e().size() > 0) {
      a().a(atyw.e(), paramString2, paramInt, null);
    }
    if (atyw.e().size() > 0) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB6", "0X800AFB6", 0, atyw.e().size(), 0, "", "", "", "");
    }
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    Iterator localIterator = atyw.a().iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      String str = localFileInfo.c();
      if ((paramBoolean) && (localFileInfo.a() <= 20971520L) && (atyw.b(localFileInfo)))
      {
        new bebw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str, paramString1, paramString2, paramInt);
      }
      else
      {
        aunh.a("0X8005414");
        if (paramInt == 1) {
          a(str, paramString2);
        } else {
          a(str, paramString1, paramString2, paramInt, true).strApkPackageName = localFileInfo.b();
        }
      }
    }
    if (atyw.a().size() > 0) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB5", "0X800AFB5", 0, atyw.a().size(), 0, "", "", "", "");
    }
  }
  
  public void d()
  {
    BaseApplicationImpl.sApplication.unregisterReceiver(this.jdField_a_of_type_Atrb);
    this.jdField_a_of_type_Atrb = null;
    aumo.a().b();
    audx.a().c();
    atvk.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObservers();
      QLog.i("FileManagerEngine<FileAssistant><QFile>", 1, "free: remove all file observers.");
      label61:
      if (this.jdField_a_of_type_Atlm != null) {
        this.jdField_a_of_type_Atlm.c();
      }
      if (this.jdField_a_of_type_Atvy != null) {
        this.jdField_a_of_type_Atvy.b();
      }
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
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
 * Qualified Name:     atqx
 * JD-Core Version:    0.7.0.1
 */