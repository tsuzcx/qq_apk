import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bavc
  implements bavk
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  anqd jdField_a_of_type_Anqd = new bave(this);
  private bauw jdField_a_of_type_Bauw;
  private bavf jdField_a_of_type_Bavf;
  private bavg jdField_a_of_type_Bavg;
  protected bavi a;
  private bavj jdField_a_of_type_Bavj;
  private Iterator<baux> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<baux> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public bavc(String paramString, bauw parambauw)
  {
    this.jdField_a_of_type_Bavi = new bavd(this);
    this.b = paramString;
    this.jdField_a_of_type_Bauw = parambauw;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Bavg = new bavg(this.b);
    this.jdField_a_of_type_Bavg.a(this.jdField_a_of_type_Bavi);
    this.jdField_a_of_type_Bavj = new bavj(this);
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
        localObject = (baux)localIterator.next();
        if (paramLong != ((baux)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((baux)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(baux parambaux)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(parambaux.jdField_a_of_type_Int).append(", uniseq:").append(parambaux.jdField_a_of_type_Long).append(", addStatus:").append(parambaux.jdField_b_of_type_Int).append(", sendStatus:").append(parambaux.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Bavg.b(parambaux.jdField_a_of_type_Long);
    if (parambaux.a()) {
      this.jdField_a_of_type_Bauw.a(parambaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (parambaux.c()) {
      this.jdField_a_of_type_Bauw.a(parambaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, parambaux.jdField_a_of_type_Anqd, parambaux.jdField_a_of_type_Bava);
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
          baux localbaux = (baux)((Iterator)localObject2).next();
          if (!localbaux.a()) {
            break;
          }
          localbaux.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Bavg.a(localbaux.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bauw.a(localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localbaux.jdField_a_of_type_Int).append(", uniseq:").append(localbaux.jdField_a_of_type_Long).append(", path:").append(localbaux.jdField_a_of_type_JavaLangString).append(", status:").append(localbaux.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localbaux.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Bavj.a(localbaux.jdField_a_of_type_JavaLangRunnable);
            localbaux.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localbaux.jdField_a_of_type_Long);
            }
          }
          if (localbaux.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localbaux.jdField_a_of_type_Long);
            }
            a(localbaux.jdField_a_of_type_Long);
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
          bavb.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Bavf != null) {
            this.jdField_a_of_type_Bavf.a(this.b);
          }
          this.jdField_a_of_type_Bavj.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        baux localbaux = (baux)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localbaux == null) {
          continue;
        }
        if (localbaux.c())
        {
          localbaux.c = 4;
          this.jdField_a_of_type_Bavj.a();
          this.jdField_a_of_type_Bauw.a(localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Anqd, localbaux.jdField_a_of_type_Bava);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localbaux.jdField_a_of_type_Int).append(", uniseq:").append(localbaux.jdField_a_of_type_Long).append(", dest:").append(localbaux.jdField_a_of_type_JavaLangString).append(", status:").append(localbaux.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Bauw.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Bavj.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public baux a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      baux localbaux = (baux)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localbaux.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localbaux.jdField_a_of_type_Int).append(", uniseq:").append(localbaux.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbaux);
        return localbaux;
      }
    }
    return null;
  }
  
  public baux a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      baux localbaux = (baux)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localbaux.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localbaux.jdField_a_of_type_Int).append(", uniseq:").append(localbaux.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbaux);
        return localbaux;
      }
    }
    return null;
  }
  
  public bavg a()
  {
    return this.jdField_a_of_type_Bavg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bavg != null)
    {
      this.jdField_a_of_type_Bavg.a();
      this.jdField_a_of_type_Bavg = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Bavj != null)
    {
      this.jdField_a_of_type_Bavj.b();
      this.jdField_a_of_type_Bavj = null;
    }
    this.jdField_a_of_type_Bavf = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bavj.a();
    baux localbaux = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Bauw.a(a(paramLong))) {
        localbaux = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localbaux != null) {
        if (localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          bavb.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Bauw.b(a(paramLong));
            this.jdField_a_of_type_Bavj.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localbaux = (baux)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localbaux == null) || (!this.jdField_a_of_type_Bauw.a(localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localbaux = a(localbaux.jdField_a_of_type_Long);; localbaux = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bavj.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Bauw.b(a(paramLong));
      this.jdField_a_of_type_Bavj.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Bauw.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Bavj.a(paramLong, i, paramInt2);
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
            baux localbaux = (baux)localIterator.next();
            if (paramLong1 == localbaux.jdField_a_of_type_Long)
            {
              localbaux.jdField_a_of_type_Long = paramLong2;
              if (localbaux.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Bavj.a(localbaux.jdField_a_of_type_JavaLangRunnable);
                localbaux.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bavj.a(paramLong2);
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
    Object localObject = new baux();
    ((baux)localObject).jdField_a_of_type_Long = paramLong;
    ((baux)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((baux)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((baux)localObject).jdField_a_of_type_Int = i;
    ((baux)localObject).jdField_b_of_type_Int = 0;
    ((baux)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((baux)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bavj.a(paramLong);; ((baux)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bavj.a(paramString))
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
  
  public void a(bavf parambavf)
  {
    this.jdField_a_of_type_Bavf = parambavf;
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
    baux localbaux;
    if (((Iterator)localObject).hasNext())
    {
      localbaux = (baux)((Iterator)localObject).next();
      if ((localbaux.jdField_a_of_type_Long == 0L) || (paramLong != localbaux.jdField_a_of_type_Long)) {
        break label217;
      }
      localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localbaux.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localbaux.jdField_b_of_type_Int = 2;
      if (localbaux.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Bavj.a(localbaux.jdField_a_of_type_JavaLangRunnable);
        localbaux.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localbaux.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localbaux.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localbaux.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localbaux.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localbaux.jdField_b_of_type_Int = 1;
          }
          else
          {
            localbaux.jdField_b_of_type_Int = 2;
            if (localbaux.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Bavj.a(localbaux.jdField_a_of_type_JavaLangRunnable);
              localbaux.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localbaux.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, anqd paramanqd, bava parambava)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      baux localbaux = (baux)localIterator.next();
      if (paramMessageRecord.uniseq == localbaux.jdField_a_of_type_Long)
      {
        localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localbaux.jdField_a_of_type_Anqd = paramanqd;
        localbaux.jdField_a_of_type_Bava = parambava;
        localbaux.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localbaux.jdField_a_of_type_Int).append(", uniseq:").append(localbaux.jdField_a_of_type_Long).append(", addStatus:").append(localbaux.jdField_b_of_type_Int).append(", sendStatus:").append(localbaux.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    baux localbaux = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localbaux = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localbaux != null) && (localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        bavb.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localbaux = a((String)paramObject);
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
      baux localbaux = (baux)localIterator.next();
      if ((localbaux.jdField_a_of_type_Long != 0L) && (paramLong == localbaux.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localbaux.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localbaux.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavc
 * JD-Core Version:    0.7.0.1
 */