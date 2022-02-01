import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class bbnx
  extends aocj
{
  bbnx(bbnv parambbnv) {}
  
  public void a(boolean paramBoolean, long paramLong, aock paramaock)
  {
    if (bbnv.a(this.a) == null)
    {
      QLog.d(bbnv.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    bbnq localbbnq = (bbnq)bbnv.a(this.a).peek();
    if (localbbnq != null) {
      if ((paramLong == localbbnq.jdField_a_of_type_Long) && (localbbnq.c == 4))
      {
        localbbnq.c = 5;
        bbnv.a(this.a).remove(localbbnq);
        if (localbbnq.jdField_a_of_type_Aocj != null) {
          localbbnq.jdField_a_of_type_Aocj.a(paramBoolean, paramLong, paramaock);
        }
        if (localbbnq.jdField_a_of_type_Bbnt != null) {
          localbbnq.jdField_a_of_type_Bbnt.a(paramBoolean, paramLong);
        }
        if (localbbnq.jdField_a_of_type_Boolean) {
          bcyp.a().a(paramLong);
        }
        bbnv.a(this.a).b(localbbnq.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramaock = new StringBuilder();
          paramaock.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(bbnv.a(this.a).size()).append(", mNeedCompress:").append(localbbnq.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(bbnv.a, 2, paramaock.toString());
        }
      }
    }
    for (;;)
    {
      bbnv.a(this.a);
      return;
      QLog.d(bbnv.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localbbnq.c), ", uniseq:", Long.valueOf(localbbnq.jdField_a_of_type_Long) });
      continue;
      QLog.d(bbnv.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnx
 * JD-Core Version:    0.7.0.1
 */