import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bbnv
  implements bbod
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  aocj jdField_a_of_type_Aocj = new bbnx(this);
  private bbnp jdField_a_of_type_Bbnp;
  private bbny jdField_a_of_type_Bbny;
  private bbnz jdField_a_of_type_Bbnz;
  protected bbob a;
  private bboc jdField_a_of_type_Bboc;
  private Iterator<bbnq> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<bbnq> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public bbnv(String paramString, bbnp parambbnp)
  {
    this.jdField_a_of_type_Bbob = new bbnw(this);
    this.b = paramString;
    this.jdField_a_of_type_Bbnp = parambbnp;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Bbnz = new bbnz(this.b);
    this.jdField_a_of_type_Bbnz.a(this.jdField_a_of_type_Bbob);
    this.jdField_a_of_type_Bboc = new bboc(this);
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
        localObject = (bbnq)localIterator.next();
        if (paramLong != ((bbnq)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((bbnq)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(bbnq parambbnq)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(parambbnq.jdField_a_of_type_Int).append(", uniseq:").append(parambbnq.jdField_a_of_type_Long).append(", addStatus:").append(parambbnq.jdField_b_of_type_Int).append(", sendStatus:").append(parambbnq.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Bbnz.b(parambbnq.jdField_a_of_type_Long);
    if (parambbnq.a()) {
      this.jdField_a_of_type_Bbnp.a(parambbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (parambbnq.c()) {
      this.jdField_a_of_type_Bbnp.a(parambbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, parambbnq.jdField_a_of_type_Aocj, parambbnq.jdField_a_of_type_Bbnt);
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
          bbnq localbbnq = (bbnq)((Iterator)localObject2).next();
          if (!localbbnq.a()) {
            break;
          }
          localbbnq.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Bbnz.a(localbbnq.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bbnp.a(localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localbbnq.jdField_a_of_type_Int).append(", uniseq:").append(localbbnq.jdField_a_of_type_Long).append(", path:").append(localbbnq.jdField_a_of_type_JavaLangString).append(", status:").append(localbbnq.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localbbnq.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Bboc.a(localbbnq.jdField_a_of_type_JavaLangRunnable);
            localbbnq.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localbbnq.jdField_a_of_type_Long);
            }
          }
          if (localbbnq.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localbbnq.jdField_a_of_type_Long);
            }
            a(localbbnq.jdField_a_of_type_Long);
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
          bbnu.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Bbny != null) {
            this.jdField_a_of_type_Bbny.a(this.b);
          }
          this.jdField_a_of_type_Bboc.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        bbnq localbbnq = (bbnq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localbbnq == null) {
          continue;
        }
        if (localbbnq.c())
        {
          localbbnq.c = 4;
          this.jdField_a_of_type_Bboc.a();
          this.jdField_a_of_type_Bbnp.a(localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Aocj, localbbnq.jdField_a_of_type_Bbnt);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localbbnq.jdField_a_of_type_Int).append(", uniseq:").append(localbbnq.jdField_a_of_type_Long).append(", dest:").append(localbbnq.jdField_a_of_type_JavaLangString).append(", status:").append(localbbnq.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Bbnp.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Bboc.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public bbnq a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bbnq localbbnq = (bbnq)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localbbnq.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localbbnq.jdField_a_of_type_Int).append(", uniseq:").append(localbbnq.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbbnq);
        return localbbnq;
      }
    }
    return null;
  }
  
  public bbnq a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bbnq localbbnq = (bbnq)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localbbnq.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localbbnq.jdField_a_of_type_Int).append(", uniseq:").append(localbbnq.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbbnq);
        return localbbnq;
      }
    }
    return null;
  }
  
  public bbnz a()
  {
    return this.jdField_a_of_type_Bbnz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbnz != null)
    {
      this.jdField_a_of_type_Bbnz.a();
      this.jdField_a_of_type_Bbnz = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Bboc != null)
    {
      this.jdField_a_of_type_Bboc.b();
      this.jdField_a_of_type_Bboc = null;
    }
    this.jdField_a_of_type_Bbny = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bboc.a();
    bbnq localbbnq = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Bbnp.a(a(paramLong))) {
        localbbnq = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localbbnq != null) {
        if (localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          bbnu.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Bbnp.b(a(paramLong));
            this.jdField_a_of_type_Bboc.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localbbnq = (bbnq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localbbnq == null) || (!this.jdField_a_of_type_Bbnp.a(localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localbbnq = a(localbbnq.jdField_a_of_type_Long);; localbbnq = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bboc.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Bbnp.b(a(paramLong));
      this.jdField_a_of_type_Bboc.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Bbnp.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Bboc.a(paramLong, i, paramInt2);
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
            bbnq localbbnq = (bbnq)localIterator.next();
            if (paramLong1 == localbbnq.jdField_a_of_type_Long)
            {
              localbbnq.jdField_a_of_type_Long = paramLong2;
              if (localbbnq.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Bboc.a(localbbnq.jdField_a_of_type_JavaLangRunnable);
                localbbnq.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bboc.a(paramLong2);
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
    Object localObject = new bbnq();
    ((bbnq)localObject).jdField_a_of_type_Long = paramLong;
    ((bbnq)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((bbnq)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((bbnq)localObject).jdField_a_of_type_Int = i;
    ((bbnq)localObject).jdField_b_of_type_Int = 0;
    ((bbnq)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((bbnq)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bboc.a(paramLong);; ((bbnq)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bboc.a(paramString))
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
  
  public void a(bbny parambbny)
  {
    this.jdField_a_of_type_Bbny = parambbny;
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
    bbnq localbbnq;
    if (((Iterator)localObject).hasNext())
    {
      localbbnq = (bbnq)((Iterator)localObject).next();
      if ((localbbnq.jdField_a_of_type_Long == 0L) || (paramLong != localbbnq.jdField_a_of_type_Long)) {
        break label217;
      }
      localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localbbnq.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localbbnq.jdField_b_of_type_Int = 2;
      if (localbbnq.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Bboc.a(localbbnq.jdField_a_of_type_JavaLangRunnable);
        localbbnq.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localbbnq.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localbbnq.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localbbnq.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localbbnq.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localbbnq.jdField_b_of_type_Int = 1;
          }
          else
          {
            localbbnq.jdField_b_of_type_Int = 2;
            if (localbbnq.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Bboc.a(localbbnq.jdField_a_of_type_JavaLangRunnable);
              localbbnq.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localbbnq.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, aocj paramaocj, bbnt parambbnt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bbnq localbbnq = (bbnq)localIterator.next();
      if (paramMessageRecord.uniseq == localbbnq.jdField_a_of_type_Long)
      {
        localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localbbnq.jdField_a_of_type_Aocj = paramaocj;
        localbbnq.jdField_a_of_type_Bbnt = parambbnt;
        localbbnq.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localbbnq.jdField_a_of_type_Int).append(", uniseq:").append(localbbnq.jdField_a_of_type_Long).append(", addStatus:").append(localbbnq.jdField_b_of_type_Int).append(", sendStatus:").append(localbbnq.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    bbnq localbbnq = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localbbnq = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localbbnq != null) && (localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localbbnq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        bbnu.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localbbnq = a((String)paramObject);
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
      bbnq localbbnq = (bbnq)localIterator.next();
      if ((localbbnq.jdField_a_of_type_Long != 0L) && (paramLong == localbbnq.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localbbnq.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localbbnq.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnv
 * JD-Core Version:    0.7.0.1
 */