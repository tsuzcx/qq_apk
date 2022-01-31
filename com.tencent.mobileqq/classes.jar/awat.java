import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class awat
  implements awbb
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  akat jdField_a_of_type_Akat = new awav(this);
  private awan jdField_a_of_type_Awan;
  private awaw jdField_a_of_type_Awaw;
  private awax jdField_a_of_type_Awax;
  protected awaz a;
  private awba jdField_a_of_type_Awba;
  private Iterator<awao> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<awao> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public awat(String paramString, awan paramawan)
  {
    this.jdField_a_of_type_Awaz = new awau(this);
    this.b = paramString;
    this.jdField_a_of_type_Awan = paramawan;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Awax = new awax(this.b);
    this.jdField_a_of_type_Awax.a(this.jdField_a_of_type_Awaz);
    this.jdField_a_of_type_Awba = new awba(this);
  }
  
  private MessageRecord a(long paramLong)
  {
    Object localObject = null;
    MessageRecord localMessageRecord = null;
    if (paramLong != 0L)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      localObject = localMessageRecord;
      if (localIterator.hasNext())
      {
        localObject = (awao)localIterator.next();
        if (paramLong != ((awao)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((awao)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(awao paramawao)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramawao.jdField_a_of_type_Int).append(", uniseq:").append(paramawao.jdField_a_of_type_Long).append(", addStatus:").append(paramawao.jdField_b_of_type_Int).append(", sendStatus:").append(paramawao.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Awax.b(paramawao.jdField_a_of_type_Long);
    if (paramawao.a()) {
      this.jdField_a_of_type_Awan.a(paramawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramawao.c()) {
      this.jdField_a_of_type_Awan.a(paramawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramawao.jdField_a_of_type_Akat, paramawao.jdField_a_of_type_Awar);
    }
    b();
    c();
  }
  
  private void b()
  {
    Object localObject2;
    try
    {
      localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label325;
          }
          awao localawao = (awao)((Iterator)localObject2).next();
          if (!localawao.a()) {
            break;
          }
          localawao.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Awax.a(localawao.jdField_a_of_type_Long);
          this.jdField_a_of_type_Awan.a(localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localawao.jdField_a_of_type_Int).append(", uniseq:").append(localawao.jdField_a_of_type_Long).append(", path:").append(localawao.jdField_a_of_type_JavaLangString).append(", status:").append(localawao.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localawao.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Awba.a(localawao.jdField_a_of_type_JavaLangRunnable);
            localawao.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localawao.jdField_a_of_type_Long);
            }
          }
          if (localawao.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localawao.jdField_a_of_type_Long);
            }
            a(localawao.jdField_a_of_type_Long);
          }
        }
      } while (localObject1.b());
    }
    finally {}
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not ready to add ").append(localObject1.jdField_a_of_type_Int).append(", path:").append(localObject1.jdField_a_of_type_JavaLangString).append(", mStatus:").append(localObject1.jdField_b_of_type_Int);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject2).toString());
    }
    label325:
  }
  
  private void c()
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
        {
          awas.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Awaw != null) {
            this.jdField_a_of_type_Awaw.a(this.b);
          }
          this.jdField_a_of_type_Awba.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        awao localawao = (awao)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localawao == null) {
          continue;
        }
        if (localawao.c())
        {
          localawao.c = 4;
          this.jdField_a_of_type_Awba.a();
          this.jdField_a_of_type_Awan.a(localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Akat, localawao.jdField_a_of_type_Awar);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localawao.jdField_a_of_type_Int).append(", uniseq:").append(localawao.jdField_a_of_type_Long).append(", dest:").append(localawao.jdField_a_of_type_JavaLangString).append(", status:").append(localawao.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Awan.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Awba.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public awao a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      awao localawao = (awao)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localawao.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localawao.jdField_a_of_type_Int).append(", uniseq:").append(localawao.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localawao);
        return localawao;
      }
    }
    return null;
  }
  
  public awao a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      awao localawao = (awao)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localawao.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localawao.jdField_a_of_type_Int).append(", uniseq:").append(localawao.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localawao);
        return localawao;
      }
    }
    return null;
  }
  
  public awax a()
  {
    return this.jdField_a_of_type_Awax;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awax != null)
    {
      this.jdField_a_of_type_Awax.a();
      this.jdField_a_of_type_Awax = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Awba != null)
    {
      this.jdField_a_of_type_Awba.b();
      this.jdField_a_of_type_Awba = null;
    }
    this.jdField_a_of_type_Awaw = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Awba.a();
    awao localawao = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Awan.a(a(paramLong))) {
        localawao = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localawao != null) {
        if (localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          awas.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Awan.b(a(paramLong));
            this.jdField_a_of_type_Awba.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localawao = (awao)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localawao == null) || (!this.jdField_a_of_type_Awan.a(localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localawao = a(localawao.jdField_a_of_type_Long);; localawao = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awba.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Awan.b(a(paramLong));
      this.jdField_a_of_type_Awba.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Awan.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Awba.a(paramLong, i, paramInt2);
      return;
    }
    a(paramLong);
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! progress stuck ", Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "oldSeq and newSeq should not be zero");
      }
    }
    for (;;)
    {
      return;
      int i;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            awao localawao = (awao)localIterator.next();
            if (paramLong1 == localawao.jdField_a_of_type_Long)
            {
              localawao.jdField_a_of_type_Long = paramLong2;
              if (localawao.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Awba.a(localawao.jdField_a_of_type_JavaLangRunnable);
                localawao.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Awba.a(paramLong2);
              }
              if (QLog.isColorLevel())
              {
                QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "updateMediaMsgByUniseq old:", Long.valueOf(paramLong1), ", new:", Long.valueOf(paramLong2) });
                i = 1;
              }
            }
          }
        }
      }
      while (i == 0)
      {
        a(paramLong2, "");
        return;
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, false);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject = new awao();
    ((awao)localObject).jdField_a_of_type_Long = paramLong;
    ((awao)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((awao)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((awao)localObject).jdField_a_of_type_Int = i;
    ((awao)localObject).jdField_b_of_type_Int = 0;
    ((awao)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((awao)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Awba.a(paramLong);; ((awao)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Awba.a(paramString))
    {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enqueueMediaMsg msgSize:").append(this.jdField_a_of_type_Int).append(", uniseq:").append(paramLong).append(", path:").append(paramString).append(", queue:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public void a(awaw paramawaw)
  {
    this.jdField_a_of_type_Awaw = paramawaw;
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsgRecord").append(" uniseq:").append(paramLong).append(", path:").append(paramString).append(", realadd:").append(paramBoolean);
      QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    awao localawao;
    if (((Iterator)localObject).hasNext())
    {
      localawao = (awao)((Iterator)localObject).next();
      if ((localawao.jdField_a_of_type_Long == 0L) || (paramLong != localawao.jdField_a_of_type_Long)) {
        break label217;
      }
      localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localawao.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localawao.jdField_b_of_type_Int = 2;
      if (localawao.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Awba.a(localawao.jdField_a_of_type_JavaLangRunnable);
        localawao.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localawao.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localawao.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localawao.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localawao.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localawao.jdField_b_of_type_Int = 1;
          }
          else
          {
            localawao.jdField_b_of_type_Int = 2;
            if (localawao.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Awba.a(localawao.jdField_a_of_type_JavaLangRunnable);
              localawao.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localawao.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, akat paramakat, awar paramawar)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      awao localawao = (awao)localIterator.next();
      if (paramMessageRecord.uniseq == localawao.jdField_a_of_type_Long)
      {
        localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localawao.jdField_a_of_type_Akat = paramakat;
        localawao.jdField_a_of_type_Awar = paramawar;
        localawao.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localawao.jdField_a_of_type_Int).append(", uniseq:").append(localawao.jdField_a_of_type_Long).append(", addStatus:").append(localawao.jdField_b_of_type_Int).append(", sendStatus:").append(localawao.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    awao localawao = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localawao = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localawao != null) && (localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        awas.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localawao = a((String)paramObject);
        i = 2;
        break;
      }
      label114:
      i = 0;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty();
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      awao localawao = (awao)localIterator.next();
      if ((localawao.jdField_a_of_type_Long != 0L) && (paramLong == localawao.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localawao.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localawao.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awat
 * JD-Core Version:    0.7.0.1
 */