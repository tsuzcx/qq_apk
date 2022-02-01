import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

public class atws
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  private atpa jdField_a_of_type_Atpa = new atwu(this);
  private atwx jdField_a_of_type_Atwx;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LinkedHashMap<Long, atwy> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private LinkedHashMap<String, LinkedHashMap<Long, atww>> b = new LinkedHashMap();
  
  public atws(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
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
  
  atwy a(long paramLong)
  {
    atwy localatwy3 = (atwy)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
    atwy localatwy1 = localatwy3;
    if (localatwy3 == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      localatwy1 = localatwy3;
      if (localFileManagerEntity != null)
      {
        localatwy1 = new atwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
        localatwy1.a(localFileManagerEntity);
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), localatwy1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
        if (localatwy1 != null)
        {
          localatwy1.n();
          c(paramLong);
        }
        return null;
      }
    }
    finally {}
    if (localatwy2 != null) {
      localatwy2.k();
    }
    b();
    return localatwy2;
  }
  
  atwy a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    atwy localatwy;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localatwy = (atwy)((Iterator)localObject).next();
    } while ((localatwy == null) || (localatwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (!paramString.equalsIgnoreCase(localatwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) || (paramLong != localatwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId));
    for (;;)
    {
      if (localatwy == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
        if (localObject == null) {
          break label261;
        }
        paramLong = ((FileManagerEntity)localObject).nSessionId;
        paramString = new atwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).nSessionId);
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
        if (localatwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          paramLong = localatwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          paramString = localatwy;
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
          paramString = localatwy;
          paramLong = 0L;
        }
      }
      localatwy = null;
    }
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((atwy)localEntry.getValue()).n();
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
      atwy localatwy = (atwy)localEntry.getValue();
      localatwy.b(paramInt);
      if (localatwy.c())
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
    atwy localatwy;
    do
    {
      return;
      localatwy = a(paramLong);
      if (localatwy == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.PauseTrans");
        return;
      }
      localatwy.f();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] had be deleted by user. stop it");
        localatwy.n();
      }
    } while (!localatwy.c());
    c(paramLong);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderCancelUpload sessionid error.return");
    }
    atwy localatwy;
    do
    {
      do
      {
        return;
        localatwy = a(paramString, paramLong);
        if (localatwy != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderCancelUpload");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new atww(this, 10));
      return;
      localatwy.e();
    } while (!localatwy.c());
    c(localatwy.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onFileRequestBeHandledByPC sessionid error.return");
    }
    atwy localatwy;
    do
    {
      do
      {
        return;
        localatwy = a(paramString, paramLong);
        if (localatwy != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onFileRequestBeHandledByPC");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new atww(this, paramInt));
      return;
      localatwy.a(paramInt);
    } while (!localatwy.c());
    c(localatwy.jdField_a_of_type_Long);
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
      localObject = new atww(this, 12);
      ((atww)localObject).jdField_b_of_type_Int = paramInt;
      ((atww)localObject).jdField_a_of_type_JavaLangString = paramString2;
      a(paramString1, paramLong, (atww)localObject);
      return;
      ((atwy)localObject).a(paramInt, paramString2);
    } while (!((atwy)localObject).c());
    c(((atwy)localObject).jdField_a_of_type_Long);
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
      localObject = new atww(this, 11);
      ((atww)localObject).jdField_b_of_type_Int = paramInt;
      ((atww)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((atww)localObject).jdField_b_of_type_Long = paramLong2;
      a(paramString1, paramLong1, (atww)localObject);
      return;
      if (!((atwy)localObject).a(paramInt, paramString2, paramLong2)) {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed. but onlineworker handle failed!!!!");
      }
    } while (!((atwy)localObject).c());
    c(((atwy)localObject).jdField_a_of_type_Long);
  }
  
  void a(String paramString, long paramLong, atww paramatww)
  {
    if ((paramString == null) || (paramLong <= 0L) || (paramatww == null)) {
      return;
    }
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  cacheHandleBeforeRequest handleType:" + paramatww.jdField_a_of_type_Int + " info_1:" + paramatww.jdField_b_of_type_Int + " info_2:" + paramatww.jdField_a_of_type_JavaLangString + " info_3:" + paramatww.jdField_b_of_type_Long);
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.b.get(paramString);
    if (localLinkedHashMap == null)
    {
      localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put(Long.valueOf(paramLong), paramatww);
      this.b.put(paramString, localLinkedHashMap);
      return;
    }
    localLinkedHashMap.put(Long.valueOf(paramLong), paramatww);
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
  
  public void a(String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt1, String paramString3, atzk paramatzk, long paramLong2, int paramInt2)
  {
    if (paramatzk == null)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
      return;
    }
    if (0L == paramatzk.jdField_b_of_type_Long)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatzk.jdField_b_of_type_Long + "]  onFileRequestCome sessionid error.return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramatzk.jdField_b_of_type_Long) != null)
    {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatzk.jdField_b_of_type_Long + "] request come filename:" + paramatzk.jdField_a_of_type_JavaLangString + ", but is repeat session and return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramatzk.jdField_b_of_type_Long))
    {
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatzk.jdField_b_of_type_Long + "] request come filename:" + paramatzk.jdField_a_of_type_JavaLangString + "but it had be deleted by user");
      return;
    }
    String str = beyo.a(berv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramatzk.jdField_a_of_type_JavaLangString, 0, null), paramatzk.jdField_a_of_type_Long, 0, false, null);
    long l = bcry.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString1, 0);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.setCloudType(0);
    localFileManagerEntity.fileName = paramatzk.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramatzk.jdField_a_of_type_Long;
    localFileManagerEntity.nOpType = -1;
    localFileManagerEntity.peerNick = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.srvTime = (1000L * paramLong1);
    localFileManagerEntity.status = 4;
    localFileManagerEntity.Uuid = null;
    localFileManagerEntity.isReaded = paramBoolean;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.nFileType = -1;
    localFileManagerEntity.nOLfileSessionId = paramatzk.jdField_b_of_type_Long;
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatzk.jdField_b_of_type_Long + "] - nSessionId[" + localFileManagerEntity.nSessionId + "] request come filename:" + paramatzk.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, false, paramatzk.jdField_a_of_type_JavaLangString, paramatzk.jdField_a_of_type_Long, false, 0, str, paramShort, paramShort, paramString3, paramInt1, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "File Coming:" + aunj.a(localFileManagerEntity));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    }
    paramString2 = new atwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
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
    } while (!a(paramString1, paramatzk.jdField_b_of_type_Long));
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatzk.jdField_b_of_type_Long + "] had be handled before request come");
  }
  
  public boolean a(long paramLong)
  {
    boolean bool1 = false;
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] recvOnLineFile sessionid error.return");
    }
    atwy localatwy;
    boolean bool2;
    do
    {
      return bool1;
      localatwy = a(paramLong);
      if (localatwy == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.recvOnLineFile");
        return false;
      }
      auni localauni = new auni();
      localauni.b = "recv_file_online";
      aunh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localauni);
      bool2 = localatwy.d();
      bool1 = bool2;
    } while (!localatwy.c());
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
      localObject = (atww)localLinkedHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  isBeHandledBeforeRequest handleType:" + ((atww)localObject).jdField_a_of_type_Int + " info_1:" + ((atww)localObject).jdField_b_of_type_Int + " info_2:" + ((atww)localObject).jdField_a_of_type_JavaLangString + " info_3:" + ((atww)localObject).jdField_b_of_type_Long);
        switch (((atww)localObject).jdField_a_of_type_Int)
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
      paramLong = bcrg.a();
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
            atww localatww = (atww)localEntry.getValue();
            long l = ((Long)localEntry.getKey()).longValue();
            if (localatww != null)
            {
              if (paramLong - localatww.jdField_a_of_type_Long < 7200L) {
                continue;
              }
              QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]  isBeHandledBeforeRequest and clear it.handleType:" + localatww.jdField_a_of_type_Int + " info_1:" + localatww.jdField_b_of_type_Int + " info_2:" + localatww.jdField_a_of_type_JavaLangString + " info_3:" + localatww.jdField_b_of_type_Long);
              ((Iterator)localObject).remove();
              continue;
              a(paramString, paramLong, ((atww)localObject).jdField_a_of_type_Int);
              bool1 = true;
              break;
              a(paramString, paramLong);
              bool1 = true;
              break;
              a(paramString, paramLong, ((atww)localObject).jdField_b_of_type_Int, ((atww)localObject).jdField_a_of_type_JavaLangString, ((atww)localObject).jdField_b_of_type_Long);
              bool1 = true;
              break;
              a(paramString, paramLong, ((atww)localObject).jdField_b_of_type_Int, ((atww)localObject).jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_AndroidOsHandler = new atwv(this, Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_Atwx == null)
    {
      this.jdField_a_of_type_Atwx = new atwx(this, null);
      this.jdField_a_of_type_Atwx.a();
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
    atwy localatwy;
    do
    {
      return;
      localatwy = a(paramLong);
      if (localatwy == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.ResumeTrans");
        return;
      }
      localatwy.g();
    } while (!localatwy.c());
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
    if (this.jdField_a_of_type_Atwx != null)
    {
      this.jdField_a_of_type_Atwx.b();
      this.jdField_a_of_type_Atwx = null;
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
      atwy localatwy = (atwy)localEntry.getValue();
      localatwy.b(l1);
      if (localatwy.c())
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
      atwy localatwy = (atwy)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localatwy != null) {
        localatwy.n();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_Atpa != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atws
 * JD-Core Version:    0.7.0.1
 */