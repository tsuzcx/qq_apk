import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class aoke
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  private aodp jdField_a_of_type_Aodp = new aokg(this);
  private aokj jdField_a_of_type_Aokj;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LinkedHashMap<Long, aokk> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private LinkedHashMap<String, LinkedHashMap<Long, aoki>> b = new LinkedHashMap();
  
  public aoke(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
    try
    {
      ThreadManager.executeOnSubThread(new OnlineFileSessionCenter.1(this, paramQQAppInterface));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 2, paramQQAppInterface.toString());
    }
  }
  
  aokk a(long paramLong)
  {
    aokk localaokk3 = (aokk)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
    aokk localaokk1 = localaokk3;
    if (localaokk3 == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      localaokk1 = localaokk3;
      if (localFileManagerEntity != null)
      {
        localaokk1 = new aokk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
        localaokk1.a(localFileManagerEntity);
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), localaokk1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
        if (localaokk1 != null)
        {
          localaokk1.n();
          c(paramLong);
        }
        return null;
      }
    }
    finally {}
    if (localaokk2 != null) {
      localaokk2.k();
    }
    b();
    return localaokk2;
  }
  
  aokk a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    aokk localaokk;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localaokk = (aokk)((Iterator)localObject).next();
    } while ((localaokk == null) || (localaokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (!paramString.equalsIgnoreCase(localaokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) || (paramLong != localaokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId));
    for (;;)
    {
      if (localaokk == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
        if (localObject == null) {
          break label261;
        }
        paramLong = ((FileManagerEntity)localObject).nSessionId;
        paramString = new aokk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).nSessionId);
        paramString.a((FileManagerEntity)localObject);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), paramString);
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) {
            break label247;
          }
          QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
          if (paramString != null)
          {
            paramString.n();
            c(paramLong);
          }
          return null;
        }
        finally {}
        if (localaokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          paramLong = localaokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          paramString = localaokk;
          continue;
          label247:
          if (paramString != null) {
            paramString.k();
          }
          b();
          return paramString;
        }
        else
        {
          label261:
          paramString = localaokk;
          paramLong = 0L;
        }
      }
      localaokk = null;
    }
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((aokk)localEntry.getValue()).n();
      long l = ((Long)localEntry.getKey()).longValue();
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      localIterator.remove();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. stop. and remove the worker..[" + i + " - " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      aokk localaokk = (aokk)localEntry.getValue();
      localaokk.b(paramInt);
      if (localaokk.c())
      {
        long l = ((Long)localEntry.getKey()).longValue();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. remove the worker....");
      }
    }
    a();
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] PauseTrans sessionid error.return");
    }
    aokk localaokk;
    do
    {
      return;
      localaokk = a(paramLong);
      if (localaokk == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.PauseTrans");
        return;
      }
      localaokk.f();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] had be deleted by user. stop it");
        localaokk.n();
      }
    } while (!localaokk.c());
    c(paramLong);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderCancelUpload sessionid error.return");
    }
    aokk localaokk;
    do
    {
      do
      {
        return;
        localaokk = a(paramString, paramLong);
        if (localaokk != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderCancelUpload");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new aoki(this, 10));
      return;
      localaokk.e();
    } while (!localaokk.c());
    c(localaokk.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onFileRequestBeHandledByPC sessionid error.return");
    }
    aokk localaokk;
    do
    {
      do
      {
        return;
        localaokk = a(paramString, paramLong);
        if (localaokk != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onFileRequestBeHandledByPC");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new aoki(this, paramInt));
      return;
      localaokk.a(paramInt);
    } while (!localaokk.c());
    c(localaokk.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadProgressNotify sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadProgressNotify");
        return;
      }
      paramString.a(paramInt1, paramInt2);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadException sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadException");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong));
      localObject = new aoki(this, 12);
      ((aoki)localObject).jdField_b_of_type_Int = paramInt;
      ((aoki)localObject).jdField_a_of_type_JavaLangString = paramString2;
      a(paramString1, paramLong, (aoki)localObject);
      return;
      ((aokk)localObject).a(paramInt, paramString2);
    } while (!((aokk)localObject).c());
    c(((aokk)localObject).jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    if ((paramString1 == null) || (paramLong1 <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]onSenderUploadCompleted  sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong1);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]. not find worker.onSenderUploadCompleted");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong1));
      localObject = new aoki(this, 11);
      ((aoki)localObject).jdField_b_of_type_Int = paramInt;
      ((aoki)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((aoki)localObject).jdField_b_of_type_Long = paramLong2;
      a(paramString1, paramLong1, (aoki)localObject);
      return;
      if (!((aokk)localObject).a(paramInt, paramString2, paramLong2)) {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed. but onlineworker handle failed!!!!");
      }
    } while (!((aokk)localObject).c());
    c(((aokk)localObject).jdField_a_of_type_Long);
  }
  
  void a(String paramString, long paramLong, aoki paramaoki)
  {
    if ((paramString == null) || (paramLong <= 0L) || (paramaoki == null)) {
      return;
    }
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  cacheHandleBeforeRequest handleType:" + paramaoki.jdField_a_of_type_Int + " info_1:" + paramaoki.jdField_b_of_type_Int + " info_2:" + paramaoki.jdField_a_of_type_JavaLangString + " info_3:" + paramaoki.jdField_b_of_type_Long);
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.b.get(paramString);
    if (localLinkedHashMap == null)
    {
      localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put(Long.valueOf(paramLong), paramaoki);
      this.b.put(paramString, localLinkedHashMap);
      return;
    }
    localLinkedHashMap.put(Long.valueOf(paramLong), paramaoki);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onRecvOnLineFileResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onRecvOnLineFileResult");
        return;
      }
      paramString.a(paramBoolean);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt1, String paramString3, aonz paramaonz, long paramLong2, int paramInt2)
  {
    if (paramaonz == null)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
      return;
    }
    if (0L == paramaonz.jdField_b_of_type_Long)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramaonz.jdField_b_of_type_Long + "]  onFileRequestCome sessionid error.return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramaonz.jdField_b_of_type_Long) != null)
    {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramaonz.jdField_b_of_type_Long + "] request come filename:" + paramaonz.jdField_a_of_type_JavaLangString + ", but is repeat session and return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramaonz.jdField_b_of_type_Long))
    {
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramaonz.jdField_b_of_type_Long + "] request come filename:" + paramaonz.jdField_a_of_type_JavaLangString + "but it had be deleted by user");
      return;
    }
    String str = axwb.a(axoy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramaonz.jdField_a_of_type_JavaLangString, 0, null), paramaonz.jdField_a_of_type_Long, 0, false, null);
    long l = awbi.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString1, 0);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.setCloudType(0);
    localFileManagerEntity.fileName = paramaonz.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramaonz.jdField_a_of_type_Long;
    localFileManagerEntity.nOpType = -1;
    localFileManagerEntity.peerNick = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.srvTime = (1000L * paramLong1);
    localFileManagerEntity.status = 4;
    localFileManagerEntity.Uuid = null;
    localFileManagerEntity.isReaded = paramBoolean;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.nFileType = -1;
    localFileManagerEntity.nOLfileSessionId = paramaonz.jdField_b_of_type_Long;
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramaonz.jdField_b_of_type_Long + "] - nSessionId[" + localFileManagerEntity.nSessionId + "] request come filename:" + paramaonz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, false, paramaonz.jdField_a_of_type_JavaLangString, paramaonz.jdField_a_of_type_Long, false, 0, str, paramShort, paramShort, paramString3, paramInt1, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "File Coming:" + apck.a(localFileManagerEntity));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    }
    paramString2 = new aokk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
    paramString2.a(localFileManagerEntity);
    do
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(localFileManagerEntity.nSessionId), paramString2);
        paramString2.k();
        if (paramString2.c())
        {
          c(localFileManagerEntity.nSessionId);
          b();
          return;
        }
      }
      finally {}
    } while (!a(paramString1, paramaonz.jdField_b_of_type_Long));
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramaonz.jdField_b_of_type_Long + "] had be handled before request come");
  }
  
  public boolean a(long paramLong)
  {
    boolean bool1 = false;
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] recvOnLineFile sessionid error.return");
    }
    aokk localaokk;
    boolean bool2;
    do
    {
      return bool1;
      localaokk = a(paramLong);
      if (localaokk == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.recvOnLineFile");
        return false;
      }
      apcj localapcj = new apcj();
      localapcj.b = "recv_file_online";
      apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapcj);
      bool2 = localaokk.d();
      bool1 = bool2;
    } while (!localaokk.c());
    c(paramLong);
    return bool2;
  }
  
  boolean a(String paramString, long paramLong)
  {
    boolean bool2;
    if ((paramString == null) || (paramLong <= 0L))
    {
      bool2 = false;
      return bool2;
    }
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.b.get(paramString);
    Object localObject;
    boolean bool1;
    if (localLinkedHashMap != null)
    {
      localObject = (aoki)localLinkedHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  isBeHandledBeforeRequest handleType:" + ((aoki)localObject).jdField_a_of_type_Int + " info_1:" + ((aoki)localObject).jdField_b_of_type_Int + " info_2:" + ((aoki)localObject).jdField_a_of_type_JavaLangString + " info_3:" + ((aoki)localObject).jdField_b_of_type_Long);
        switch (((aoki)localObject).jdField_a_of_type_Int)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          bool1 = false;
          localLinkedHashMap.remove(Long.valueOf(paramLong));
          if (localLinkedHashMap.size() == 0) {
            this.b.remove(paramString);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramLong = awao.a();
      bool2 = bool1;
      if (paramLong - this.jdField_a_of_type_Long < 3600L) {
        break;
      }
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
      this.jdField_a_of_type_Long = paramLong;
      bool2 = bool1;
      if (this.b.size() <= 0) {
        break;
      }
      paramString = this.b.entrySet().iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramString.hasNext()) {
          break;
        }
        localLinkedHashMap = (LinkedHashMap)((Map.Entry)paramString.next()).getValue();
        if ((localLinkedHashMap != null) && (localLinkedHashMap.size() > 0))
        {
          localObject = localLinkedHashMap.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label597;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            aoki localaoki = (aoki)localEntry.getValue();
            long l = ((Long)localEntry.getKey()).longValue();
            if (localaoki != null)
            {
              if (paramLong - localaoki.jdField_a_of_type_Long < 7200L) {
                continue;
              }
              QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]  isBeHandledBeforeRequest and clear it.handleType:" + localaoki.jdField_a_of_type_Int + " info_1:" + localaoki.jdField_b_of_type_Int + " info_2:" + localaoki.jdField_a_of_type_JavaLangString + " info_3:" + localaoki.jdField_b_of_type_Long);
              ((Iterator)localObject).remove();
              continue;
              a(paramString, paramLong, ((aoki)localObject).jdField_a_of_type_Int);
              bool1 = true;
              break;
              a(paramString, paramLong);
              bool1 = true;
              break;
              a(paramString, paramLong, ((aoki)localObject).jdField_b_of_type_Int, ((aoki)localObject).jdField_a_of_type_JavaLangString, ((aoki)localObject).jdField_b_of_type_Long);
              bool1 = true;
              break;
              a(paramString, paramLong, ((aoki)localObject).jdField_b_of_type_Int, ((aoki)localObject).jdField_a_of_type_JavaLangString);
              bool1 = true;
              break;
            }
            ((Iterator)localObject).remove();
          }
          label597:
          if (localLinkedHashMap.size() == 0) {
            paramString.remove();
          }
        }
        else
        {
          paramString.remove();
        }
      }
      bool1 = false;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new aokh(this, Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_Aokj == null)
    {
      this.jdField_a_of_type_Aokj = new aokj(this, null);
      this.jdField_a_of_type_Aokj.a();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] start progress make pump thread!!!");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession onNeworkChanged set failed");
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new OnlineFileSessionCenter.3(this, paramInt));
      return;
    }
    a(paramInt);
  }
  
  public void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] ResumeTrans sessionid error.return");
    }
    aokk localaokk;
    do
    {
      return;
      localaokk = a(paramLong);
      if (localaokk == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.ResumeTrans");
        return;
      }
      localaokk.g();
    } while (!localaokk.c());
    c(paramLong);
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderReplayComeOnRecv sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderReplayComeOnRecv");
        return;
      }
      paramString.i();
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskSenderUpProgressResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskSenderUpProgressResult");
        return;
      }
      paramString.b(paramBoolean);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Aokj != null)
    {
      this.jdField_a_of_type_Aokj.b();
      this.jdField_a_of_type_Aokj = null;
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
    }
  }
  
  void c(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. remove the worker");
      return;
    }
    finally {}
  }
  
  public void c(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskUpProgressAndSessionInvaid sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskUpProgressAndSessionInvaid");
        return;
      }
      paramString.m();
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      aokk localaokk = (aokk)localEntry.getValue();
      localaokk.b(l1);
      if (localaokk.c())
      {
        long l2 = ((Long)localEntry.getKey()).longValue();
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l2 + "]. remove the worker..[" + i + " - " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0) {
      c();
    }
  }
  
  public void d(long paramLong)
  {
    try
    {
      aokk localaokk = (aokk)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localaokk != null) {
        localaokk.n();
      }
      c(paramLong);
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  clearHistory. session center stop. . .");
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_Aodp != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoke
 * JD-Core Version:    0.7.0.1
 */