package com.tencent.mobileqq.app.proxy.fts;

import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.data.FTSMessageSync;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.persistence.fts.FTSQueryArgs;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FTSMsgOperator
  extends FTSIndexOperator
{
  private MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public FTSMsgOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramQQAppInterface, paramFTSSyncHandler);
  }
  
  private MessageRecordEntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  }
  
  public ArrayList a(long paramLong, Pair paramPair)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      Object localObject = FTSArgsFactory.a(FTSMessage.class, String.valueOf(paramLong));
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a((FTSQueryArgs)localObject);
      if ((paramPair != null) && (localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
          if ((localFTSEntity instanceof FTSMessage))
          {
            ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
            ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
          }
        }
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a())) {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {}
    }
    while (!QLog.isColorLevel())
    {
      long l1;
      do
      {
        return null;
        l1 = System.nanoTime();
        localObject = paramString.trim().toLowerCase();
        paramString = SQLiteFTSUtils.a((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
        }
      } while ((paramString == null) || (paramString.length == 0));
      long l2 = System.nanoTime();
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
      }
      Object localObject = SQLiteFTSUtils.a((String)localObject);
      paramString = FTSArgsFactory.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
    }
    QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        return null;
      }
      long l1 = System.nanoTime();
      Object localObject = paramString.trim().toLowerCase();
      paramString = SQLiteFTSUtils.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
      }
      if ((paramString == null) || (paramString.length == 0)) {
        return null;
      }
      long l2 = System.nanoTime();
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
      }
      localObject = SQLiteFTSUtils.a((String)localObject);
      paramString = FTSArgsFactory.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList a(String paramString1, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
        return null;
      }
      Object localObject = paramString1.trim().toLowerCase();
      paramString1 = SQLiteFTSUtils.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString1));
      }
      if ((paramString1 == null) || (paramString1.length == 0)) {
        return null;
      }
      localObject = SQLiteFTSUtils.a((String)localObject);
      paramString1 = FTSArgsFactory.a(paramString1, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt, paramString2);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt)
  {
    return a(paramString, paramClass, paramBoolean1, paramBoolean2, 1, FTSMessage.getExt1(paramLong, paramInt));
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, Pair paramPair)
  {
    paramString = a(paramString, paramClass, paramBoolean1, paramBoolean2, 2, String.valueOf(paramLong));
    if ((paramPair != null) && (paramString != null) && (!paramString.isEmpty()))
    {
      paramClass = paramString.iterator();
      while (paramClass.hasNext())
      {
        FTSEntity localFTSEntity = (FTSEntity)paramClass.next();
        if ((localFTSEntity instanceof FTSMessage))
        {
          ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
          ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.a();
    }
  }
  
  public void a(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMsgQueueItem.c != null) && (!TextUtils.isEmpty(paramMsgQueueItem.c)))
    {
      if (paramMsgQueueItem.jdField_a_of_type_AndroidContentContentValues == null) {
        return;
      }
      localObject1 = "SELECT * FROM " + paramMsgQueueItem.b + " WHERE " + paramMsgQueueItem.c + ";";
      localObject2 = new String[paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localObject2[i] = paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      localObject1 = a().a((String)localObject1, paramMsgQueueItem.b, paramMsgQueueItem.c, (String[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject1 != null) && (SQLiteFTSUtils.a(paramMsgQueueItem.jdField_a_of_type_AndroidContentContentValues))) {
        paramMsgQueueItem = ((List)localObject1).iterator();
      }
    }
    while (paramMsgQueueItem.hasNext())
    {
      localObject1 = (MessageRecord)paramMsgQueueItem.next();
      if ((((MessageRecord)localObject1).isSupportFTS()) && (((MessageRecord)localObject1).isValid) && (((MessageRecord)localObject1).msgtype != -2006))
      {
        localObject1 = FTSMessageCodec.a((MessageRecord)localObject1);
        ((FTSMessage)localObject1).deleteOpt();
        paramEntityManager.b(FTSMessageCodec.a((FTSMessage)localObject1));
        continue;
        if ((localObject1 != null) && (SQLiteFTSUtils.b(paramMsgQueueItem.jdField_a_of_type_AndroidContentContentValues)))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((((MessageRecord)localObject2).isSupportFTS()) && (((MessageRecord)localObject2).isValid) && (((MessageRecord)localObject2).msgtype != -2006))
            {
              if ((localObject2 instanceof MessageForStructing)) {
                ((MessageForStructing)localObject2).parse();
              }
              FTSMessage localFTSMessage = FTSMessageCodec.a((MessageRecord)localObject2);
              localFTSMessage.deleteOpt();
              paramEntityManager.b(FTSMessageCodec.a(localFTSMessage));
              localObject2 = SQLiteFTSUtils.a(paramMsgQueueItem.jdField_a_of_type_AndroidContentContentValues, (MessageRecord)localObject2);
              ((FTSMessage)localObject2).insertOpt();
              paramEntityManager.b(FTSMessageCodec.a((FTSMessage)localObject2));
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("Q.fts.FTSMsgOperator", 2, "UPDATE MESSAGE, whereClause null");
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Entity paramEntity, EntityManager paramEntityManager)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).isSupportFTS()) && (((MessageRecord)paramEntity).isValid) && (((MessageRecord)paramEntity).msgtype != -2006))
    {
      paramEntity = FTSMessageCodec.a((MessageRecord)paramEntity);
      paramEntity.insertOpt();
      paramEntityManager.b(FTSMessageCodec.a(paramEntity));
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader = new FTSMsgUpgrader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("IndexContent", true);
  }
  
  public void b()
  {
    if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      if (!a()) {
        break label30;
      }
      if (b()) {
        c();
      }
    }
    return;
    label30:
    c();
  }
  
  public void b(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager)
  {
    Object localObject;
    if ((paramMsgQueueItem.c != null) && (!TextUtils.isEmpty(paramMsgQueueItem.c)))
    {
      localObject = "SELECT * FROM " + paramMsgQueueItem.b + " WHERE " + paramMsgQueueItem.c + ";";
      String[] arrayOfString = new String[paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        arrayOfString[i] = paramMsgQueueItem.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      try
      {
        paramMsgQueueItem = a().a((String)localObject, paramMsgQueueItem.b, paramMsgQueueItem.c, arrayOfString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramMsgQueueItem == null) {
          break label285;
        }
        paramMsgQueueItem = paramMsgQueueItem.iterator();
        while (paramMsgQueueItem.hasNext())
        {
          localObject = (MessageRecord)paramMsgQueueItem.next();
          if ((((MessageRecord)localObject).isSupportFTS()) && (((MessageRecord)localObject).isValid) && (((MessageRecord)localObject).msgtype != -2006))
          {
            localObject = FTSMessageCodec.a((MessageRecord)localObject);
            ((FTSMessage)localObject).deleteOpt();
            paramEntityManager.b(FTSMessageCodec.a((FTSMessage)localObject));
          }
        }
      }
      catch (OutOfMemoryError paramMsgQueueItem)
      {
        for (;;)
        {
          QLog.e("Q.fts.FTSMsgOperator", 2, paramMsgQueueItem, new Object[0]);
          paramMsgQueueItem = null;
        }
      }
    }
    else
    {
      localObject = new FTSMessage();
      ((FTSMessage)localObject).mType = 1;
      ((FTSMessage)localObject).mContent = "DELETE TABLE";
      ((FTSMessage)localObject).mOId = -9223372036854775808L;
    }
    try
    {
      ((FTSMessage)localObject).uin = CharacterUtil.a(paramMsgQueueItem.jdField_a_of_type_JavaLangString);
      ((FTSMessage)localObject).istroop = paramMsgQueueItem.jdField_a_of_type_Int;
      ((FTSMessage)localObject).deleteOpt();
      paramEntityManager.b(FTSMessageCodec.a((FTSMessage)localObject));
      label285:
      return;
    }
    catch (NumberFormatException paramMsgQueueItem) {}
  }
  
  public void c()
  {
    super.c();
    if (1 == SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.obtainMessage(1, this).sendToTarget();
    }
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("SyncCursor");
        if (!bool) {
          if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("SyncCursor")) {
            return false;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "mWokerThread: failure ", localThrowable);
        }
        FTSDBManager.jdField_a_of_type_Boolean = false;
        return false;
      }
    }
    for (int i = 0;; i = -1)
    {
      int j = i;
      if (i != 1) {
        j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("SyncCursor");
      }
      this.jdField_a_of_type_Int = j;
      if (j == -1) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgOperator", 2, "startSyncStep: syncCursor = " + j);
      }
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
  }
  
  public void e()
  {
    int j = 0;
    if ((!FTSDBManager.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase ENABLE = " + FTSDBManager.jdField_a_of_type_Boolean + ", FTSUpgradeFlag = " + SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
    }
    label217:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
            List localList = ((EntityManager)localObject).a(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, "_id", "800");
            ((EntityManager)localObject).a();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("transToDatabase size: ");
              if (localList != null)
              {
                i = localList.size();
                QLog.i("Q.fts.FTSMsgOperator", 2, i);
              }
            }
            else
            {
              if ((localList == null) || (localList.isEmpty())) {
                break;
              }
              i = j;
              if (i >= localList.size()) {
                break;
              }
              localObject = FTSMessageCodec.a((FTSMessageSync)localList.get(i));
              if ((((FTSMessage)localObject).mType != -1) && ((((FTSMessage)localObject).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessage)localObject).mContent))) && (((FTSMessage)localObject).mOId != -1L)) {
                break label296;
              }
            }
            for (;;)
            {
              i += 1;
              break label217;
              i = 0;
              break;
              try
              {
                this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
              }
              catch (Throwable localThrowable1) {}
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase failure: ", localThrowable1);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a())) {
            break;
          }
          Object localObject = new ArrayList(256);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
              break label456;
            }
            Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
                localFTSEntity.preWrite();
                try
                {
                  ((ArrayList)localObject).add(localFTSEntity);
                }
                catch (Throwable localThrowable2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase failure: ", localThrowable2);
                  }
                  return;
                }
              }
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        } while (localArrayList.isEmpty());
        i = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(localArrayList);
      } while (i == -1);
      this.jdField_a_of_type_Int = i;
      return;
    } while (!QLog.isColorLevel());
    label296:
    label456:
    QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator
 * JD-Core Version:    0.7.0.1
 */