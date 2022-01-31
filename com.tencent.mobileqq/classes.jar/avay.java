import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class avay
  implements avbg
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  ajmm jdField_a_of_type_Ajmm = new avba(this);
  private avas jdField_a_of_type_Avas;
  private avbb jdField_a_of_type_Avbb;
  private avbc jdField_a_of_type_Avbc;
  protected avbe a;
  private avbf jdField_a_of_type_Avbf;
  private Iterator<avat> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<avat> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public avay(String paramString, avas paramavas)
  {
    this.jdField_a_of_type_Avbe = new avaz(this);
    this.b = paramString;
    this.jdField_a_of_type_Avas = paramavas;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Avbc = new avbc(this.b);
    this.jdField_a_of_type_Avbc.a(this.jdField_a_of_type_Avbe);
    this.jdField_a_of_type_Avbf = new avbf(this);
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
        localObject = (avat)localIterator.next();
        if (paramLong != ((avat)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((avat)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(avat paramavat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramavat.jdField_a_of_type_Int).append(", uniseq:").append(paramavat.jdField_a_of_type_Long).append(", addStatus:").append(paramavat.jdField_b_of_type_Int).append(", sendStatus:").append(paramavat.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Avbc.b(paramavat.jdField_a_of_type_Long);
    if (paramavat.a()) {
      this.jdField_a_of_type_Avbb.a(paramavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramavat.c()) {
      this.jdField_a_of_type_Avbb.a(paramavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramavat.jdField_a_of_type_Ajmm, paramavat.jdField_a_of_type_Avaw);
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
            break label327;
          }
          avat localavat = (avat)((Iterator)localObject2).next();
          if (!localavat.a()) {
            break;
          }
          localavat.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Avbc.a(localavat.jdField_a_of_type_Long);
          this.jdField_a_of_type_Avbb.a(localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localavat.jdField_a_of_type_Int).append(", uniseq:").append(localavat.jdField_a_of_type_Long).append(", path:").append(localavat.jdField_a_of_type_JavaLangString).append(", status:").append(localavat.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localavat.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Avbf.a(localavat.jdField_a_of_type_JavaLangRunnable);
            localavat.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localavat.jdField_a_of_type_Long);
            }
          }
          if (localavat.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localavat.jdField_a_of_type_Long);
            }
            a(localavat.jdField_a_of_type_Long);
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
    label327:
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
          avax.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          this.jdField_a_of_type_Avbb.a(this.b);
          this.jdField_a_of_type_Avbf.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        avat localavat = (avat)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localavat == null) {
          continue;
        }
        if (localavat.c())
        {
          localavat.c = 4;
          this.jdField_a_of_type_Avbf.a();
          this.jdField_a_of_type_Avbb.a(localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Ajmm, localavat.jdField_a_of_type_Avaw);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localavat.jdField_a_of_type_Int).append(", uniseq:").append(localavat.jdField_a_of_type_Long).append(", dest:").append(localavat.jdField_a_of_type_JavaLangString).append(", status:").append(localavat.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Avbb.a(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Avbf.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public avat a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      avat localavat = (avat)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localavat.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localavat.jdField_a_of_type_Int).append(", uniseq:").append(localavat.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localavat);
        return localavat;
      }
    }
    return null;
  }
  
  public avat a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      avat localavat = (avat)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localavat.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localavat.jdField_a_of_type_Int).append(", uniseq:").append(localavat.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localavat);
        return localavat;
      }
    }
    return null;
  }
  
  public avbc a()
  {
    return this.jdField_a_of_type_Avbc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avbc != null)
    {
      this.jdField_a_of_type_Avbc.a();
      this.jdField_a_of_type_Avbc = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Avbf != null)
    {
      this.jdField_a_of_type_Avbf.b();
      this.jdField_a_of_type_Avbf = null;
    }
    this.jdField_a_of_type_Avbb = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Avbf.a();
    avat localavat = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Avas.a(a(paramLong))) {
        localavat = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localavat != null) {
        if (localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          avax.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Avas.b(a(paramLong));
            this.jdField_a_of_type_Avbf.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localavat = (avat)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localavat == null) || (!this.jdField_a_of_type_Avas.a(localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localavat = a(localavat.jdField_a_of_type_Long);; localavat = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Avbf.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Avas.b(a(paramLong));
      this.jdField_a_of_type_Avbf.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Avas.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Avbf.a(paramLong, i, paramInt2);
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
            avat localavat = (avat)localIterator.next();
            if (paramLong1 == localavat.jdField_a_of_type_Long)
            {
              localavat.jdField_a_of_type_Long = paramLong2;
              if (localavat.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Avbf.a(localavat.jdField_a_of_type_JavaLangRunnable);
                localavat.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Avbf.a(paramLong2);
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
    Object localObject = new avat();
    ((avat)localObject).jdField_a_of_type_Long = paramLong;
    ((avat)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((avat)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((avat)localObject).jdField_a_of_type_Int = i;
    ((avat)localObject).jdField_b_of_type_Int = 0;
    ((avat)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((avat)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Avbf.a(paramLong);; ((avat)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Avbf.a(paramString))
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
  
  public void a(avbb paramavbb)
  {
    this.jdField_a_of_type_Avbb = paramavbb;
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
    avat localavat;
    if (((Iterator)localObject).hasNext())
    {
      localavat = (avat)((Iterator)localObject).next();
      if ((localavat.jdField_a_of_type_Long == 0L) || (paramLong != localavat.jdField_a_of_type_Long)) {
        break label217;
      }
      localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localavat.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localavat.jdField_b_of_type_Int = 2;
      if (localavat.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Avbf.a(localavat.jdField_a_of_type_JavaLangRunnable);
        localavat.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localavat.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localavat.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localavat.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localavat.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localavat.jdField_b_of_type_Int = 1;
          }
          else
          {
            localavat.jdField_b_of_type_Int = 2;
            if (localavat.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Avbf.a(localavat.jdField_a_of_type_JavaLangRunnable);
              localavat.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localavat.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, ajmm paramajmm, avaw paramavaw)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      avat localavat = (avat)localIterator.next();
      if (paramMessageRecord.uniseq == localavat.jdField_a_of_type_Long)
      {
        localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localavat.jdField_a_of_type_Ajmm = paramajmm;
        localavat.jdField_a_of_type_Avaw = paramavaw;
        localavat.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localavat.jdField_a_of_type_Int).append(", uniseq:").append(localavat.jdField_a_of_type_Long).append(", addStatus:").append(localavat.jdField_b_of_type_Int).append(", sendStatus:").append(localavat.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    avat localavat = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localavat = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localavat != null) && (localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localavat.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        avax.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localavat = a((String)paramObject);
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
      avat localavat = (avat)localIterator.next();
      if ((localavat.jdField_a_of_type_Long != 0L) && (paramLong == localavat.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localavat.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localavat.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avay
 * JD-Core Version:    0.7.0.1
 */