import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class axsu
  extends alsi
{
  axsu(axss paramaxss) {}
  
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
    if (axss.a(this.a) == null)
    {
      QLog.d(axss.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    axsn localaxsn = (axsn)axss.a(this.a).peek();
    if (localaxsn != null) {
      if ((paramLong == localaxsn.jdField_a_of_type_Long) && (localaxsn.c == 4))
      {
        localaxsn.c = 5;
        axss.a(this.a).remove(localaxsn);
        if (localaxsn.jdField_a_of_type_Alsi != null) {
          localaxsn.jdField_a_of_type_Alsi.a(paramBoolean, paramLong, paramalsj);
        }
        if (localaxsn.jdField_a_of_type_Axsq != null) {
          localaxsn.jdField_a_of_type_Axsq.a(paramBoolean, paramLong);
        }
        if (localaxsn.jdField_a_of_type_Boolean) {
          azao.a().a(paramLong);
        }
        axss.a(this.a).b(localaxsn.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramalsj = new StringBuilder();
          paramalsj.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(axss.a(this.a).size()).append(", mNeedCompress:").append(localaxsn.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(axss.a, 2, paramalsj.toString());
        }
      }
    }
    for (;;)
    {
      axss.a(this.a);
      return;
      QLog.d(axss.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localaxsn.c), ", uniseq:", Long.valueOf(localaxsn.jdField_a_of_type_Long) });
      continue;
      QLog.d(axss.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsu
 * JD-Core Version:    0.7.0.1
 */