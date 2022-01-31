import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class awat
  extends akav
{
  awat(awar paramawar) {}
  
  public void a(boolean paramBoolean, long paramLong, akaw paramakaw)
  {
    if (awar.a(this.a) == null)
    {
      QLog.d(awar.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    awam localawam = (awam)awar.a(this.a).peek();
    if (localawam != null) {
      if ((paramLong == localawam.jdField_a_of_type_Long) && (localawam.c == 4))
      {
        localawam.c = 5;
        awar.a(this.a).remove(localawam);
        if (localawam.jdField_a_of_type_Akav != null) {
          localawam.jdField_a_of_type_Akav.a(paramBoolean, paramLong, paramakaw);
        }
        if (localawam.jdField_a_of_type_Awap != null) {
          localawam.jdField_a_of_type_Awap.a(paramBoolean, paramLong);
        }
        if (localawam.jdField_a_of_type_Boolean) {
          axfg.a().a(paramLong);
        }
        awar.a(this.a).b(localawam.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramakaw = new StringBuilder();
          paramakaw.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(awar.a(this.a).size()).append(", mNeedCompress:").append(localawam.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(awar.a, 2, paramakaw.toString());
        }
      }
    }
    for (;;)
    {
      awar.a(this.a);
      return;
      QLog.d(awar.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localawam.c), ", uniseq:", Long.valueOf(localawam.jdField_a_of_type_Long) });
      continue;
      QLog.d(awar.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awat
 * JD-Core Version:    0.7.0.1
 */