import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager.1;
import com.tencent.mobileqq.app.message.DatalineMessageManager.2;
import com.tencent.mobileqq.app.message.DatalineMessageManager.3;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aosf
  implements aosp
{
  public int a;
  public QQMessageFacade a;
  public QQAppInterface a;
  public String a;
  
  public aosf(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_JavaLangString = antf.z;
    this.jdField_a_of_type_Int = 6000;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().b(paramDataLineMsgRecord);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    localMessage.selfuin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.senderuin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.msgtype = paramDataLineMsgRecord.msgtype;
    if (localMessage.msgtype == -2009) {
      localMessage.msgtype = -2005;
    }
    localMessage.msg = paramDataLineMsgRecord.msg;
    localMessage.emoRecentMsg = null;
    if (paramDataLineMsgRecord.time > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg mr msg time[" + localMessage.time + "] to time[" + paramDataLineMsgRecord.time + "]");
      localMessage.time = paramDataLineMsgRecord.time;
    }
    localMessage.msgseq = paramDataLineMsgRecord.msgseq;
    localMessage.isread = paramDataLineMsgRecord.isread;
    localMessage.issend = paramDataLineMsgRecord.issend;
    localMessage.frienduin = String.valueOf(this.jdField_a_of_type_JavaLangString);
    localMessage.istroop = this.jdField_a_of_type_Int;
    localMessage.fileType = -1;
    localMessage.msgId = paramDataLineMsgRecord.msgId;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessage);
    if (!paramDataLineMsgRecord.isSend()) {
      localMessage.hasReply = true;
    }
    if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
    {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(localMessage);
      if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
        break label290;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessage.frienduin, localMessage.istroop, 1);
    }
    label290:
    while ((paramEntityManager != null) && (paramEntityManager.getComeCount() != 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessage.frienduin, localMessage.istroop, 1);
  }
  
  public int a()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      throw new RuntimeException("clearHistory in no-main thread");
    }
    localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase() == null) {
      return 0;
    }
    int i = a().a();
    if (i > 0)
    {
      ((QQMessageFacade.Message)localObject).msg = null;
      ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
      ((QQMessageFacade.Message)localObject).fileType = -1;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject);
    return i;
  }
  
  public int a(long paramLong)
  {
    DataLineMsgSet localDataLineMsgSet = a().a(paramLong);
    if (localDataLineMsgSet == null) {
      return -1;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return a(localDataLineMsgSet);
    }
    new Handler(localLooper).post(new DatalineMessageManager.2(this, localDataLineMsgSet));
    return 0;
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = false;
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      int i = a().a(paramDataLineMsgSet);
      if (i > 0)
      {
        paramDataLineMsgSet = adak.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.containsKey(paramDataLineMsgSet))
        {
          bool = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.get(paramDataLineMsgSet)).hasReply;
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.remove(paramDataLineMsgSet);
        }
        long l = a().a().size();
        if (l > 0L)
        {
          localObject = a().a();
          paramDataLineMsgSet = (DataLineMsgSet)localObject;
          if (localObject != null) {
            if ((((DataLineMsgRecord)localObject).msgtype != -5000) && (((DataLineMsgRecord)localObject).msgtype != -5041))
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (((DataLineMsgRecord)localObject).msgtype != -2073) {}
            }
            else
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (l > 1L) {
                paramDataLineMsgSet = a().a().get((int)(l - 2L)).getLastItem();
              }
            }
          }
          localObject = new QQMessageFacade.Message();
          if (paramDataLineMsgSet != null)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramDataLineMsgSet);
            ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
            ((QQMessageFacade.Message)localObject).hasReply = bool;
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((QQMessageFacade.Message)localObject);
            this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a.put(adak.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int), localObject);
          }
        }
        paramDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().findRecentUserByUin(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
        paramDataLineMsgSet.close();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject);
        }
      }
      return i;
    }
    new Handler((Looper)localObject).post(new DatalineMessageManager.3(this, paramDataLineMsgSet));
    return 0;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    long l2 = -1L;
    long l1;
    if (paramDataLineMsgRecord == null)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
        l1 = l2;
      }
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return l1;
      a();
      localObject1 = new fb(false, false);
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        try
        {
          if (paramDataLineMsgRecord.time == 0L) {
            paramDataLineMsgRecord.time = bcrg.a();
          }
          if (paramDataLineMsgRecord.msgseq == 0L) {
            paramDataLineMsgRecord.msgseq = ((int)paramDataLineMsgRecord.time);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = (RecentUser)((apaw)localObject2).findRecentUserByUin(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
          localRecentUser.setType(this.jdField_a_of_type_Int);
          localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
          ((apaw)localObject2).saveRecentUser(localRecentUser);
          a(paramDataLineMsgRecord, (EntityManager)localObject1);
          l2 = paramDataLineMsgRecord.msgId;
          if (paramBoolean) {
            paramDataLineMsgRecord.issuc = true;
          }
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramDataLineMsgRecord);
          ((EntityManager)localObject1).close();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l2);
            return l2;
          }
        }
        finally
        {
          ((EntityManager)localObject1).close();
        }
      }
    }
    new Handler((Looper)localObject2).post(new DatalineMessageManager.1(this, paramDataLineMsgRecord, (fb)localObject1));
    ((fb)localObject1).a(-1L);
    return 0L;
  }
  
  public apas a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    return a().b(paramLong);
  }
  
  protected void a()
  {
    ((anvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(false);
  }
  
  public void a(int paramInt, apat paramapat)
  {
    a().a(paramInt, paramapat);
  }
  
  public void a(long paramLong)
  {
    a().b(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    a().b(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().a(paramLong, paramString, paramArrayOfByte);
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    try
    {
      apaw localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = (RecentUser)localapaw.findRecentUserByUin(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
      localRecentUser.setType(this.jdField_a_of_type_Int);
      localRecentUser.lastmsgtime = bcrg.a();
      localapaw.saveRecentUser(localRecentUser);
      ((EntityManager)localObject1).close();
      localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localObject1);
      return;
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
  }
  
  public void b(long paramLong)
  {
    a().c(paramLong);
  }
  
  public void b(long paramLong, String paramString)
  {
    a().a(paramLong, paramString);
  }
  
  public void c()
  {
    a().d();
  }
  
  public void c(long paramLong)
  {
    a().a(paramLong);
  }
  
  public void d()
  {
    a().c();
  }
  
  public void d(long paramLong)
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int);
    if (paramLong > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg msg time[" + localMessage.time + "] to time[" + paramLong + "]");
      localMessage.time = paramLong;
    }
  }
  
  public void e()
  {
    if (!LiteActivity.class.getName().equals(anvl.a(BaseApplication.getContext()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "setDataLineMsgReaded,unread=" + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
      }
    } while (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int) <= 0);
    a().e();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */