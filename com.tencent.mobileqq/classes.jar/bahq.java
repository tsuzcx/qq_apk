import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bahq
  implements bahy
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  amwl jdField_a_of_type_Amwl = new bahs(this);
  private bahk jdField_a_of_type_Bahk;
  private baht jdField_a_of_type_Baht;
  private bahu jdField_a_of_type_Bahu;
  protected bahw a;
  private bahx jdField_a_of_type_Bahx;
  private Iterator<bahl> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<bahl> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public bahq(String paramString, bahk parambahk)
  {
    this.jdField_a_of_type_Bahw = new bahr(this);
    this.b = paramString;
    this.jdField_a_of_type_Bahk = parambahk;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Bahu = new bahu(this.b);
    this.jdField_a_of_type_Bahu.a(this.jdField_a_of_type_Bahw);
    this.jdField_a_of_type_Bahx = new bahx(this);
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
        localObject = (bahl)localIterator.next();
        if (paramLong != ((bahl)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((bahl)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(bahl parambahl)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(parambahl.jdField_a_of_type_Int).append(", uniseq:").append(parambahl.jdField_a_of_type_Long).append(", addStatus:").append(parambahl.jdField_b_of_type_Int).append(", sendStatus:").append(parambahl.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Bahu.b(parambahl.jdField_a_of_type_Long);
    if (parambahl.a()) {
      this.jdField_a_of_type_Bahk.a(parambahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (parambahl.c()) {
      this.jdField_a_of_type_Bahk.a(parambahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, parambahl.jdField_a_of_type_Amwl, parambahl.jdField_a_of_type_Baho);
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
          bahl localbahl = (bahl)((Iterator)localObject2).next();
          if (!localbahl.a()) {
            break;
          }
          localbahl.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Bahu.a(localbahl.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bahk.a(localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localbahl.jdField_a_of_type_Int).append(", uniseq:").append(localbahl.jdField_a_of_type_Long).append(", path:").append(localbahl.jdField_a_of_type_JavaLangString).append(", status:").append(localbahl.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localbahl.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Bahx.a(localbahl.jdField_a_of_type_JavaLangRunnable);
            localbahl.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localbahl.jdField_a_of_type_Long);
            }
          }
          if (localbahl.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localbahl.jdField_a_of_type_Long);
            }
            a(localbahl.jdField_a_of_type_Long);
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
          bahp.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Baht != null) {
            this.jdField_a_of_type_Baht.a(this.b);
          }
          this.jdField_a_of_type_Bahx.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        bahl localbahl = (bahl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localbahl == null) {
          continue;
        }
        if (localbahl.c())
        {
          localbahl.c = 4;
          this.jdField_a_of_type_Bahx.a();
          this.jdField_a_of_type_Bahk.a(localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Amwl, localbahl.jdField_a_of_type_Baho);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localbahl.jdField_a_of_type_Int).append(", uniseq:").append(localbahl.jdField_a_of_type_Long).append(", dest:").append(localbahl.jdField_a_of_type_JavaLangString).append(", status:").append(localbahl.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Bahk.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Bahx.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public bahl a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bahl localbahl = (bahl)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localbahl.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localbahl.jdField_a_of_type_Int).append(", uniseq:").append(localbahl.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbahl);
        return localbahl;
      }
    }
    return null;
  }
  
  public bahl a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bahl localbahl = (bahl)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localbahl.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localbahl.jdField_a_of_type_Int).append(", uniseq:").append(localbahl.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbahl);
        return localbahl;
      }
    }
    return null;
  }
  
  public bahu a()
  {
    return this.jdField_a_of_type_Bahu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bahu != null)
    {
      this.jdField_a_of_type_Bahu.a();
      this.jdField_a_of_type_Bahu = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Bahx != null)
    {
      this.jdField_a_of_type_Bahx.b();
      this.jdField_a_of_type_Bahx = null;
    }
    this.jdField_a_of_type_Baht = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bahx.a();
    bahl localbahl = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Bahk.a(a(paramLong))) {
        localbahl = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localbahl != null) {
        if (localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          bahp.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Bahk.b(a(paramLong));
            this.jdField_a_of_type_Bahx.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localbahl = (bahl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localbahl == null) || (!this.jdField_a_of_type_Bahk.a(localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localbahl = a(localbahl.jdField_a_of_type_Long);; localbahl = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bahx.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Bahk.b(a(paramLong));
      this.jdField_a_of_type_Bahx.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Bahk.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Bahx.a(paramLong, i, paramInt2);
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
            bahl localbahl = (bahl)localIterator.next();
            if (paramLong1 == localbahl.jdField_a_of_type_Long)
            {
              localbahl.jdField_a_of_type_Long = paramLong2;
              if (localbahl.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Bahx.a(localbahl.jdField_a_of_type_JavaLangRunnable);
                localbahl.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bahx.a(paramLong2);
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
    Object localObject = new bahl();
    ((bahl)localObject).jdField_a_of_type_Long = paramLong;
    ((bahl)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((bahl)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((bahl)localObject).jdField_a_of_type_Int = i;
    ((bahl)localObject).jdField_b_of_type_Int = 0;
    ((bahl)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((bahl)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bahx.a(paramLong);; ((bahl)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bahx.a(paramString))
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
  
  public void a(baht parambaht)
  {
    this.jdField_a_of_type_Baht = parambaht;
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
    bahl localbahl;
    if (((Iterator)localObject).hasNext())
    {
      localbahl = (bahl)((Iterator)localObject).next();
      if ((localbahl.jdField_a_of_type_Long == 0L) || (paramLong != localbahl.jdField_a_of_type_Long)) {
        break label217;
      }
      localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localbahl.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localbahl.jdField_b_of_type_Int = 2;
      if (localbahl.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Bahx.a(localbahl.jdField_a_of_type_JavaLangRunnable);
        localbahl.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localbahl.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localbahl.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localbahl.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localbahl.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localbahl.jdField_b_of_type_Int = 1;
          }
          else
          {
            localbahl.jdField_b_of_type_Int = 2;
            if (localbahl.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Bahx.a(localbahl.jdField_a_of_type_JavaLangRunnable);
              localbahl.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localbahl.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, amwl paramamwl, baho parambaho)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bahl localbahl = (bahl)localIterator.next();
      if (paramMessageRecord.uniseq == localbahl.jdField_a_of_type_Long)
      {
        localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localbahl.jdField_a_of_type_Amwl = paramamwl;
        localbahl.jdField_a_of_type_Baho = parambaho;
        localbahl.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localbahl.jdField_a_of_type_Int).append(", uniseq:").append(localbahl.jdField_a_of_type_Long).append(", addStatus:").append(localbahl.jdField_b_of_type_Int).append(", sendStatus:").append(localbahl.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    bahl localbahl = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localbahl = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localbahl != null) && (localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        bahp.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localbahl = a((String)paramObject);
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
      bahl localbahl = (bahl)localIterator.next();
      if ((localbahl.jdField_a_of_type_Long != 0L) && (paramLong == localbahl.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localbahl.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localbahl.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahq
 * JD-Core Version:    0.7.0.1
 */