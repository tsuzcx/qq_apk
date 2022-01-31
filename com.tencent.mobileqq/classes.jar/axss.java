import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class axss
  implements axta
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  alsi jdField_a_of_type_Alsi = new axsu(this);
  private axsm jdField_a_of_type_Axsm;
  private axsv jdField_a_of_type_Axsv;
  private axsw jdField_a_of_type_Axsw;
  protected axsy a;
  private axsz jdField_a_of_type_Axsz;
  private Iterator<axsn> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<axsn> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public axss(String paramString, axsm paramaxsm)
  {
    this.jdField_a_of_type_Axsy = new axst(this);
    this.b = paramString;
    this.jdField_a_of_type_Axsm = paramaxsm;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Axsw = new axsw(this.b);
    this.jdField_a_of_type_Axsw.a(this.jdField_a_of_type_Axsy);
    this.jdField_a_of_type_Axsz = new axsz(this);
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
        localObject = (axsn)localIterator.next();
        if (paramLong != ((axsn)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((axsn)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(axsn paramaxsn)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramaxsn.jdField_a_of_type_Int).append(", uniseq:").append(paramaxsn.jdField_a_of_type_Long).append(", addStatus:").append(paramaxsn.jdField_b_of_type_Int).append(", sendStatus:").append(paramaxsn.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Axsw.b(paramaxsn.jdField_a_of_type_Long);
    if (paramaxsn.a()) {
      this.jdField_a_of_type_Axsm.a(paramaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramaxsn.c()) {
      this.jdField_a_of_type_Axsm.a(paramaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramaxsn.jdField_a_of_type_Alsi, paramaxsn.jdField_a_of_type_Axsq);
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
          axsn localaxsn = (axsn)((Iterator)localObject2).next();
          if (!localaxsn.a()) {
            break;
          }
          localaxsn.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Axsw.a(localaxsn.jdField_a_of_type_Long);
          this.jdField_a_of_type_Axsm.a(localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localaxsn.jdField_a_of_type_Int).append(", uniseq:").append(localaxsn.jdField_a_of_type_Long).append(", path:").append(localaxsn.jdField_a_of_type_JavaLangString).append(", status:").append(localaxsn.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localaxsn.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Axsz.a(localaxsn.jdField_a_of_type_JavaLangRunnable);
            localaxsn.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localaxsn.jdField_a_of_type_Long);
            }
          }
          if (localaxsn.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localaxsn.jdField_a_of_type_Long);
            }
            a(localaxsn.jdField_a_of_type_Long);
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
          axsr.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Axsv != null) {
            this.jdField_a_of_type_Axsv.a(this.b);
          }
          this.jdField_a_of_type_Axsz.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        axsn localaxsn = (axsn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localaxsn == null) {
          continue;
        }
        if (localaxsn.c())
        {
          localaxsn.c = 4;
          this.jdField_a_of_type_Axsz.a();
          this.jdField_a_of_type_Axsm.a(localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Alsi, localaxsn.jdField_a_of_type_Axsq);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localaxsn.jdField_a_of_type_Int).append(", uniseq:").append(localaxsn.jdField_a_of_type_Long).append(", dest:").append(localaxsn.jdField_a_of_type_JavaLangString).append(", status:").append(localaxsn.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Axsm.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Axsz.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public axsn a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      axsn localaxsn = (axsn)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localaxsn.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localaxsn.jdField_a_of_type_Int).append(", uniseq:").append(localaxsn.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localaxsn);
        return localaxsn;
      }
    }
    return null;
  }
  
  public axsn a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      axsn localaxsn = (axsn)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localaxsn.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localaxsn.jdField_a_of_type_Int).append(", uniseq:").append(localaxsn.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localaxsn);
        return localaxsn;
      }
    }
    return null;
  }
  
  public axsw a()
  {
    return this.jdField_a_of_type_Axsw;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axsw != null)
    {
      this.jdField_a_of_type_Axsw.a();
      this.jdField_a_of_type_Axsw = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Axsz != null)
    {
      this.jdField_a_of_type_Axsz.b();
      this.jdField_a_of_type_Axsz = null;
    }
    this.jdField_a_of_type_Axsv = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Axsz.a();
    axsn localaxsn = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Axsm.a(a(paramLong))) {
        localaxsn = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localaxsn != null) {
        if (localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          axsr.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Axsm.b(a(paramLong));
            this.jdField_a_of_type_Axsz.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localaxsn = (axsn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localaxsn == null) || (!this.jdField_a_of_type_Axsm.a(localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localaxsn = a(localaxsn.jdField_a_of_type_Long);; localaxsn = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axsz.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Axsm.b(a(paramLong));
      this.jdField_a_of_type_Axsz.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Axsm.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Axsz.a(paramLong, i, paramInt2);
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
            axsn localaxsn = (axsn)localIterator.next();
            if (paramLong1 == localaxsn.jdField_a_of_type_Long)
            {
              localaxsn.jdField_a_of_type_Long = paramLong2;
              if (localaxsn.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Axsz.a(localaxsn.jdField_a_of_type_JavaLangRunnable);
                localaxsn.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axsz.a(paramLong2);
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
    Object localObject = new axsn();
    ((axsn)localObject).jdField_a_of_type_Long = paramLong;
    ((axsn)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((axsn)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((axsn)localObject).jdField_a_of_type_Int = i;
    ((axsn)localObject).jdField_b_of_type_Int = 0;
    ((axsn)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((axsn)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axsz.a(paramLong);; ((axsn)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axsz.a(paramString))
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
  
  public void a(axsv paramaxsv)
  {
    this.jdField_a_of_type_Axsv = paramaxsv;
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
    axsn localaxsn;
    if (((Iterator)localObject).hasNext())
    {
      localaxsn = (axsn)((Iterator)localObject).next();
      if ((localaxsn.jdField_a_of_type_Long == 0L) || (paramLong != localaxsn.jdField_a_of_type_Long)) {
        break label217;
      }
      localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localaxsn.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localaxsn.jdField_b_of_type_Int = 2;
      if (localaxsn.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Axsz.a(localaxsn.jdField_a_of_type_JavaLangRunnable);
        localaxsn.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localaxsn.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localaxsn.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localaxsn.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localaxsn.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localaxsn.jdField_b_of_type_Int = 1;
          }
          else
          {
            localaxsn.jdField_b_of_type_Int = 2;
            if (localaxsn.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Axsz.a(localaxsn.jdField_a_of_type_JavaLangRunnable);
              localaxsn.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localaxsn.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, alsi paramalsi, axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      axsn localaxsn = (axsn)localIterator.next();
      if (paramMessageRecord.uniseq == localaxsn.jdField_a_of_type_Long)
      {
        localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localaxsn.jdField_a_of_type_Alsi = paramalsi;
        localaxsn.jdField_a_of_type_Axsq = paramaxsq;
        localaxsn.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localaxsn.jdField_a_of_type_Int).append(", uniseq:").append(localaxsn.jdField_a_of_type_Long).append(", addStatus:").append(localaxsn.jdField_b_of_type_Int).append(", sendStatus:").append(localaxsn.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    axsn localaxsn = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localaxsn = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localaxsn != null) && (localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        axsr.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localaxsn = a((String)paramObject);
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
      axsn localaxsn = (axsn)localIterator.next();
      if ((localaxsn.jdField_a_of_type_Long != 0L) && (paramLong == localaxsn.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localaxsn.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localaxsn.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axss
 * JD-Core Version:    0.7.0.1
 */