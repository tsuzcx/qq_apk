import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class axxb
  implements axxj
{
  public static String a;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  alwx jdField_a_of_type_Alwx = new axxd(this);
  private axwv jdField_a_of_type_Axwv;
  private axxe jdField_a_of_type_Axxe;
  private axxf jdField_a_of_type_Axxf;
  protected axxh a;
  private axxi jdField_a_of_type_Axxi;
  private Iterator<axww> jdField_a_of_type_JavaUtilIterator;
  private ConcurrentLinkedQueue<axww> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OrderMediaMsgSessionQueue";
  }
  
  public axxb(String paramString, axwv paramaxwv)
  {
    this.jdField_a_of_type_Axxh = new axxc(this);
    this.b = paramString;
    this.jdField_a_of_type_Axwv = paramaxwv;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Axxf = new axxf(this.b);
    this.jdField_a_of_type_Axxf.a(this.jdField_a_of_type_Axxh);
    this.jdField_a_of_type_Axxi = new axxi(this);
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
        localObject = (axww)localIterator.next();
        if (paramLong != ((axww)localObject).jdField_a_of_type_Long) {
          break label67;
        }
        localMessageRecord = ((axww)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void a(axww paramaxww)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramaxww.jdField_a_of_type_Int).append(", uniseq:").append(paramaxww.jdField_a_of_type_Long).append(", addStatus:").append(paramaxww.jdField_b_of_type_Int).append(", sendStatus:").append(paramaxww.c);
      QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Axxf.b(paramaxww.jdField_a_of_type_Long);
    if (paramaxww.a()) {
      this.jdField_a_of_type_Axwv.a(paramaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    if (paramaxww.c()) {
      this.jdField_a_of_type_Axwv.a(paramaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramaxww.jdField_a_of_type_Alwx, paramaxww.jdField_a_of_type_Axwz);
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
          axww localaxww = (axww)((Iterator)localObject2).next();
          if (!localaxww.a()) {
            break;
          }
          localaxww.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Axxf.a(localaxww.jdField_a_of_type_Long);
          this.jdField_a_of_type_Axwv.a(localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localaxww.jdField_a_of_type_Int).append(", uniseq:").append(localaxww.jdField_a_of_type_Long).append(", path:").append(localaxww.jdField_a_of_type_JavaLangString).append(", status:").append(localaxww.jdField_b_of_type_Int);
            QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          }
          if (localaxww.jdField_a_of_type_JavaLangRunnable != null)
          {
            this.jdField_a_of_type_Axxi.a(localaxww.jdField_a_of_type_JavaLangRunnable);
            localaxww.jdField_a_of_type_JavaLangRunnable = null;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable1 uniseq:" + localaxww.jdField_a_of_type_Long);
            }
          }
          if (localaxww.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalid msg:" + localaxww.jdField_a_of_type_Long);
            }
            a(localaxww.jdField_a_of_type_Long);
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
          axxa.a(this.jdField_a_of_type_Int, System.currentTimeMillis() - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Axxe != null) {
            this.jdField_a_of_type_Axxe.a(this.b);
          }
          this.jdField_a_of_type_Axxi.b();
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_Int = 0;
          return;
        }
        axww localaxww = (axww)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
        if (localaxww == null) {
          continue;
        }
        if (localaxww.c())
        {
          localaxww.c = 4;
          this.jdField_a_of_type_Axxi.a();
          this.jdField_a_of_type_Axwv.a(localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Alwx, localaxww.jdField_a_of_type_Axwz);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localaxww.jdField_a_of_type_Int).append(", uniseq:").append(localaxww.jdField_a_of_type_Long).append(", dest:").append(localaxww.jdField_a_of_type_JavaLangString).append(", status:").append(localaxww.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.d()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Axwv.c(localObject.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        localObject.jdField_a_of_type_Boolean = true;
      }
      boolean bool = this.jdField_a_of_type_Axxi.a(localObject.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.jdField_a_of_type_Int).append(", uniseq:").append(localObject.jdField_a_of_type_Long).append(", dest:").append(localObject.jdField_a_of_type_JavaLangString).append(", status:").append(localObject.c).append(", needCompress:").append(localObject.jdField_a_of_type_Boolean).append(", addSuccess:").append(bool);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public axww a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      axww localaxww = (axww)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramLong == localaxww.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localaxww.jdField_a_of_type_Int).append(", uniseq:").append(localaxww.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localaxww);
        return localaxww;
      }
    }
    return null;
  }
  
  public axww a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      axww localaxww = (axww)this.jdField_a_of_type_JavaUtilIterator.next();
      if (paramString.equals(localaxww.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localaxww.jdField_a_of_type_Int).append(", uniseq:").append(localaxww.jdField_a_of_type_Long);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
        }
        this.jdField_a_of_type_JavaUtilIterator.remove();
        a(localaxww);
        return localaxww;
      }
    }
    return null;
  }
  
  public axxf a()
  {
    return this.jdField_a_of_type_Axxf;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axxf != null)
    {
      this.jdField_a_of_type_Axxf.a();
      this.jdField_a_of_type_Axxf = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = null;
    }
    if (this.jdField_a_of_type_Axxi != null)
    {
      this.jdField_a_of_type_Axxi.b();
      this.jdField_a_of_type_Axxi = null;
    }
    this.jdField_a_of_type_Axxe = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Axxi.a();
    axww localaxww = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Axwv.a(a(paramLong))) {
        localaxww = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localaxww != null) {
        if (localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
        {
          i = 0;
          bool = true;
          label56:
          axxa.a(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Axwv.b(a(paramLong));
            this.jdField_a_of_type_Axxi.a(paramLong, j, 3);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
            continue;
          }
          localaxww = (axww)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.peek();
          if ((localaxww == null) || (!this.jdField_a_of_type_Axwv.a(localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localaxww = a(localaxww.jdField_a_of_type_Long);; localaxww = null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axxi.a(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Axwv.b(a(paramLong));
      this.jdField_a_of_type_Axxi.a(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Axwv.b(a(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Axxi.a(paramLong, i, paramInt2);
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
            axww localaxww = (axww)localIterator.next();
            if (paramLong1 == localaxww.jdField_a_of_type_Long)
            {
              localaxww.jdField_a_of_type_Long = paramLong2;
              if (localaxww.jdField_a_of_type_JavaLangRunnable != null)
              {
                this.jdField_a_of_type_Axxi.a(localaxww.jdField_a_of_type_JavaLangRunnable);
                localaxww.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axxi.a(paramLong2);
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
    Object localObject = new axww();
    ((axww)localObject).jdField_a_of_type_Long = paramLong;
    ((axww)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((axww)localObject).jdField_b_of_type_Boolean = paramBoolean;
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ((axww)localObject).jdField_a_of_type_Int = i;
    ((axww)localObject).jdField_b_of_type_Int = 0;
    ((axww)localObject).c = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    if (paramLong != 0L) {}
    for (((axww)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axxi.a(paramLong);; ((axww)localObject).jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_Axxi.a(paramString))
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
  
  public void a(axxe paramaxxe)
  {
    this.jdField_a_of_type_Axxe = paramaxxe;
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
    axww localaxww;
    if (((Iterator)localObject).hasNext())
    {
      localaxww = (axww)((Iterator)localObject).next();
      if ((localaxww.jdField_a_of_type_Long == 0L) || (paramLong != localaxww.jdField_a_of_type_Long)) {
        break label217;
      }
      localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localaxww.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        b();
      }
      return;
      label145:
      localaxww.jdField_b_of_type_Int = 2;
      if (localaxww.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_Axxi.a(localaxww.jdField_a_of_type_JavaLangRunnable);
        localaxww.jdField_a_of_type_JavaLangRunnable = null;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable2 uniseq:" + localaxww.jdField_a_of_type_Long);
          continue;
          label217:
          if ((localaxww.jdField_a_of_type_Long != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localaxww.jdField_a_of_type_JavaLangString))) {
            break;
          }
          localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
          localaxww.jdField_a_of_type_Long = paramLong;
          if (paramBoolean)
          {
            localaxww.jdField_b_of_type_Int = 1;
          }
          else
          {
            localaxww.jdField_b_of_type_Int = 2;
            if (localaxww.jdField_a_of_type_JavaLangRunnable != null)
            {
              this.jdField_a_of_type_Axxi.a(localaxww.jdField_a_of_type_JavaLangRunnable);
              localaxww.jdField_a_of_type_JavaLangRunnable = null;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "remove mAddTimeoutRunable3 uniseq:" + localaxww.jdField_a_of_type_Long);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, alwx paramalwx, axwz paramaxwz)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      axww localaxww = (axww)localIterator.next();
      if (paramMessageRecord.uniseq == localaxww.jdField_a_of_type_Long)
      {
        localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
        localaxww.jdField_a_of_type_Alwx = paramalwx;
        localaxww.jdField_a_of_type_Axwz = paramaxwz;
        localaxww.c = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localaxww.jdField_a_of_type_Int).append(", uniseq:").append(localaxww.jdField_a_of_type_Long).append(", addStatus:").append(localaxww.jdField_b_of_type_Int).append(", sendStatus:").append(localaxww.c);
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramMessageRecord.toString());
        }
      }
    }
    c();
  }
  
  public void a(Object paramObject)
  {
    axww localaxww = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localaxww = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localaxww != null) && (localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)) {}
      for (int j = localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype;; j = -1)
      {
        axxa.a(j, i);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localaxww = a((String)paramObject);
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
      axww localaxww = (axww)localIterator.next();
      if ((localaxww.jdField_a_of_type_Long != 0L) && (paramLong == localaxww.jdField_a_of_type_Long)) {
        return true;
      }
      if ((localaxww.jdField_a_of_type_Long == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localaxww.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxb
 * JD-Core Version:    0.7.0.1
 */