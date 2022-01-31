import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class awar
  implements awaz
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  akav jdField_a_of_type_Akav = new awat(this);
  private awal jdField_a_of_type_Awal;
  private awau jdField_a_of_type_Awau;
  private awav jdField_a_of_type_Awav;
  protected awax a;
  private away jdField_a_of_type_Away;
  private Iterator<awam> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<awam> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public awar(String paramString, awal paramawal)
  {
    this.jdField_a_of_type_Awax = new awas(this);
    this.b = paramString;
    this.jdField_a_of_type_Awal = paramawal;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Awav = new awav(this.b);
    this.jdField_a_of_type_Awav.a(this.jdField_a_of_type_Awax);
    this.jdField_a_of_type_Away = new away(this);
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
        localObject = (awam)localIterator.next();
        if (paramLong != ((awam)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((awam)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(awam paramawam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramawam.jdField_a_of_type_Int).append(", uniseq:").append(paramawam.jdField_a_of_type_Long).append(", addStatus:").append(paramawam.jdField_b_of_type_Int).append(", sendStatus:").append(paramawam.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Awav.b(paramawam.jdField_a_of_type_Long);
    if (paramawam.a()) {
      this.jdField_a_of_type_Awal.a(paramawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramawam.c()) {
      this.jdField_a_of_type_Awal.a(paramawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramawam.jdField_a_of_type_Akav, paramawam.jdField_a_of_type_Awap);
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
          awam localawam = (awam)((Iterator)localObject2).next();
          if (!localawam.a()) {
            break;
          }
          localawam.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Awav.a(localawam.jdField_a_of_type_Long);
          this.jdField_a_of_type_Awal.a(localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localawam.jdField_a_of_type_Int).append(", uniseq:").append(localawam.jdField_a_of_type_Long).append(", path:").append(localawam.jdField_a_of_type_JavaLangString).append(", status:").append(localawam.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localawam.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Away.a(localawam.jdField_a_of_type_JavaLangRunnable);
            localawam.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localawam.jdField_a_of_type_Long);
            }
          }
          if (localawam.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localawam.jdField_a_of_type_Long);
            }
            a(localawam.jdField_a_of_type_Long);
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
          awaq.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Awau != null) {
            this.jdField_a_of_type_Awau.a(this.b);
          }
          this.jdField_a_of_type_Away.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        awam localawam = (awam)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localawam == null) {
          continue;
        }
        if (localawam.c())
        {
          localawam.c = 4;
          this.jdField_a_of_type_Away.a();
          this.jdField_a_of_type_Awal.a(localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Akav, localawam.jdField_a_of_type_Awap);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localawam.jdField_a_of_type_Int).append(", uniseq:").append(localawam.jdField_a_of_type_Long).append(", dest:").append(localawam.jdField_a_of_type_JavaLangString).append(", status:").append(localawam.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Awal.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Away.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public awam a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      awam localawam = (awam)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localawam.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localawam.jdField_a_of_type_Int).append(", uniseq:").append(localawam.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localawam);
        return localawam;
      }
    }
    return null;
  }
  
  public awam a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      awam localawam = (awam)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localawam.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localawam.jdField_a_of_type_Int).append(", uniseq:").append(localawam.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localawam);
        return localawam;
      }
    }
    return null;
  }
  
  public awav a()
  {
    return this.jdField_a_of_type_Awav;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awav != null)
    {
      this.jdField_a_of_type_Awav.a();
      this.jdField_a_of_type_Awav = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Away != null)
    {
      this.jdField_a_of_type_Away.b();
      this.jdField_a_of_type_Away = null;
    }
    this.jdField_a_of_type_Awau = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Away.a();
    awam localawam = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Awal.a(a(paramLong))) {
        localawam = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localawam != null) {
        if (localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          awaq.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Awal.b(a(paramLong));
            this.jdField_a_of_type_Away.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localawam = (awam)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localawam == null) || (!this.jdField_a_of_type_Awal.a(localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localawam = a(localawam.jdField_a_of_type_Long);; localawam = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Away.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Awal.b(a(paramLong));
      this.jdField_a_of_type_Away.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Awal.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Away.a(paramLong, i, paramInt2);
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
            awam localawam = (awam)localIterator.next();
            if (paramLong1 == localawam.jdField_a_of_type_Long)
            {
              localawam.jdField_a_of_type_Long = paramLong2;
              if (localawam.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Away.a(localawam.jdField_a_of_type_JavaLangRunnable);
                localawam.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Away.a(paramLong2);
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
    Object localObject = new awam();
    ((awam)localObject).jdField_a_of_type_Long = paramLong;
    ((awam)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((awam)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((awam)localObject).jdField_a_of_type_Int = i;
    ((awam)localObject).jdField_b_of_type_Int = 0;
    ((awam)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((awam)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Away.a(paramLong);; ((awam)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Away.a(paramString))
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
  
  public void a(awau paramawau)
  {
    this.jdField_a_of_type_Awau = paramawau;
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
    awam localawam;
    if (((Iterator)localObject).hasNext())
    {
      localawam = (awam)((Iterator)localObject).next();
      if ((localawam.jdField_a_of_type_Long == 0L) || (paramLong != localawam.jdField_a_of_type_Long)) {
        break label217;
      }
      localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localawam.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localawam.jdField_b_of_type_Int = 2;
      if (localawam.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Away.a(localawam.jdField_a_of_type_JavaLangRunnable);
        localawam.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localawam.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localawam.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localawam.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localawam.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localawam.jdField_b_of_type_Int = 1;
          }
          else
          {
            localawam.jdField_b_of_type_Int = 2;
            if (localawam.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Away.a(localawam.jdField_a_of_type_JavaLangRunnable);
              localawam.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localawam.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, akav paramakav, awap paramawap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      awam localawam = (awam)localIterator.next();
      if (paramMessageRecord.uniseq == localawam.jdField_a_of_type_Long)
      {
        localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localawam.jdField_a_of_type_Akav = paramakav;
        localawam.jdField_a_of_type_Awap = paramawap;
        localawam.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localawam.jdField_a_of_type_Int).append(", uniseq:").append(localawam.jdField_a_of_type_Long).append(", addStatus:").append(localawam.jdField_b_of_type_Int).append(", sendStatus:").append(localawam.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    awam localawam = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localawam = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localawam != null) && (localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        awaq.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localawam = a((String)paramObject);
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
      awam localawam = (awam)localIterator.next();
      if ((localawam.jdField_a_of_type_Long != 0L) && (paramLong == localawam.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localawam.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localawam.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awar
 * JD-Core Version:    0.7.0.1
 */