import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bbof
  implements bbon
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  anyz jdField_a_of_type_Anyz = new bboh(this);
  private bbnz jdField_a_of_type_Bbnz;
  private bboi jdField_a_of_type_Bboi;
  private bboj jdField_a_of_type_Bboj;
  protected bbol a;
  private bbom jdField_a_of_type_Bbom;
  private Iterator<bboa> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<bboa> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public bbof(String paramString, bbnz parambbnz)
  {
    this.jdField_a_of_type_Bbol = new bbog(this);
    this.b = paramString;
    this.jdField_a_of_type_Bbnz = parambbnz;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Bboj = new bboj(this.b);
    this.jdField_a_of_type_Bboj.a(this.jdField_a_of_type_Bbol);
    this.jdField_a_of_type_Bbom = new bbom(this);
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
        localObject = (bboa)localIterator.next();
        if (paramLong != ((bboa)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((bboa)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(bboa parambboa)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(parambboa.jdField_a_of_type_Int).append(", uniseq:").append(parambboa.jdField_a_of_type_Long).append(", addStatus:").append(parambboa.jdField_b_of_type_Int).append(", sendStatus:").append(parambboa.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Bboj.b(parambboa.jdField_a_of_type_Long);
    if (parambboa.a()) {
      this.jdField_a_of_type_Bbnz.a(parambboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (parambboa.c()) {
      this.jdField_a_of_type_Bbnz.a(parambboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, parambboa.jdField_a_of_type_Anyz, parambboa.jdField_a_of_type_Bbod);
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
          bboa localbboa = (bboa)((Iterator)localObject2).next();
          if (!localbboa.a()) {
            break;
          }
          localbboa.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Bboj.a(localbboa.jdField_a_of_type_Long);
          this.jdField_a_of_type_Bbnz.a(localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localbboa.jdField_a_of_type_Int).append(", uniseq:").append(localbboa.jdField_a_of_type_Long).append(", path:").append(localbboa.jdField_a_of_type_JavaLangString).append(", status:").append(localbboa.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localbboa.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Bbom.a(localbboa.jdField_a_of_type_JavaLangRunnable);
            localbboa.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localbboa.jdField_a_of_type_Long);
            }
          }
          if (localbboa.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localbboa.jdField_a_of_type_Long);
            }
            a(localbboa.jdField_a_of_type_Long);
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
          bboe.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Bboi != null) {
            this.jdField_a_of_type_Bboi.a(this.b);
          }
          this.jdField_a_of_type_Bbom.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        bboa localbboa = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localbboa == null) {
          continue;
        }
        if (localbboa.c())
        {
          localbboa.c = 4;
          this.jdField_a_of_type_Bbom.a();
          this.jdField_a_of_type_Bbnz.a(localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Anyz, localbboa.jdField_a_of_type_Bbod);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localbboa.jdField_a_of_type_Int).append(", uniseq:").append(localbboa.jdField_a_of_type_Long).append(", dest:").append(localbboa.jdField_a_of_type_JavaLangString).append(", status:").append(localbboa.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Bbnz.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Bbom.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public bboa a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bboa localbboa = (bboa)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localbboa.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localbboa.jdField_a_of_type_Int).append(", uniseq:").append(localbboa.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbboa);
        return localbboa;
      }
    }
    return null;
  }
  
  public bboa a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      bboa localbboa = (bboa)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localbboa.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localbboa.jdField_a_of_type_Int).append(", uniseq:").append(localbboa.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localbboa);
        return localbboa;
      }
    }
    return null;
  }
  
  public bboj a()
  {
    return this.jdField_a_of_type_Bboj;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bboj != null)
    {
      this.jdField_a_of_type_Bboj.a();
      this.jdField_a_of_type_Bboj = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Bbom != null)
    {
      this.jdField_a_of_type_Bbom.b();
      this.jdField_a_of_type_Bbom = null;
    }
    this.jdField_a_of_type_Bboi = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bbom.a();
    bboa localbboa = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Bbnz.a(a(paramLong))) {
        localbboa = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localbboa != null) {
        if (localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          bboe.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Bbnz.b(a(paramLong));
            this.jdField_a_of_type_Bbom.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localbboa = (bboa)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localbboa == null) || (!this.jdField_a_of_type_Bbnz.a(localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localbboa = a(localbboa.jdField_a_of_type_Long);; localbboa = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bbom.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Bbnz.b(a(paramLong));
      this.jdField_a_of_type_Bbom.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Bbnz.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Bbom.a(paramLong, i, paramInt2);
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
            bboa localbboa = (bboa)localIterator.next();
            if (paramLong1 == localbboa.jdField_a_of_type_Long)
            {
              localbboa.jdField_a_of_type_Long = paramLong2;
              if (localbboa.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Bbom.a(localbboa.jdField_a_of_type_JavaLangRunnable);
                localbboa.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bbom.a(paramLong2);
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
    Object localObject = new bboa();
    ((bboa)localObject).jdField_a_of_type_Long = paramLong;
    ((bboa)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((bboa)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((bboa)localObject).jdField_a_of_type_Int = i;
    ((bboa)localObject).jdField_b_of_type_Int = 0;
    ((bboa)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((bboa)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bbom.a(paramLong);; ((bboa)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Bbom.a(paramString))
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
  
  public void a(bboi parambboi)
  {
    this.jdField_a_of_type_Bboi = parambboi;
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
    bboa localbboa;
    if (((Iterator)localObject).hasNext())
    {
      localbboa = (bboa)((Iterator)localObject).next();
      if ((localbboa.jdField_a_of_type_Long == 0L) || (paramLong != localbboa.jdField_a_of_type_Long)) {
        break label217;
      }
      localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localbboa.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localbboa.jdField_b_of_type_Int = 2;
      if (localbboa.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Bbom.a(localbboa.jdField_a_of_type_JavaLangRunnable);
        localbboa.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localbboa.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localbboa.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localbboa.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localbboa.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localbboa.jdField_b_of_type_Int = 1;
          }
          else
          {
            localbboa.jdField_b_of_type_Int = 2;
            if (localbboa.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Bbom.a(localbboa.jdField_a_of_type_JavaLangRunnable);
              localbboa.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localbboa.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, anyz paramanyz, bbod parambbod)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      bboa localbboa = (bboa)localIterator.next();
      if (paramMessageRecord.uniseq == localbboa.jdField_a_of_type_Long)
      {
        localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localbboa.jdField_a_of_type_Anyz = paramanyz;
        localbboa.jdField_a_of_type_Bbod = parambbod;
        localbboa.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localbboa.jdField_a_of_type_Int).append(", uniseq:").append(localbboa.jdField_a_of_type_Long).append(", addStatus:").append(localbboa.jdField_b_of_type_Int).append(", sendStatus:").append(localbboa.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    bboa localbboa = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localbboa = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localbboa != null) && (localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localbboa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        bboe.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localbboa = a((String)paramObject);
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
      bboa localbboa = (bboa)localIterator.next();
      if ((localbboa.jdField_a_of_type_Long != 0L) && (paramLong == localbboa.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localbboa.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localbboa.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbof
 * JD-Core Version:    0.7.0.1
 */