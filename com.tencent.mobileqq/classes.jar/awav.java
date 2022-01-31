import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class awav
  extends akat
{
  awav(awat paramawat) {}
  
  public void a(boolean paramBoolean, long paramLong, akau paramakau)
  {
    if (awat.a(this.a) == null)
    {
      QLog.d(awat.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    awao localawao = (awao)awat.a(this.a).peek();
    if (localawao != null) {
      if ((paramLong == localawao.jdField_a_of_type_Long) && (localawao.c == 4))
      {
        localawao.c = 5;
        awat.a(this.a).remove(localawao);
        if (localawao.jdField_a_of_type_Akat != null) {
          localawao.jdField_a_of_type_Akat.a(paramBoolean, paramLong, paramakau);
        }
        if (localawao.jdField_a_of_type_Awar != null) {
          localawao.jdField_a_of_type_Awar.a(paramBoolean, paramLong);
        }
        if (localawao.jdField_a_of_type_Boolean) {
          axfi.a().a(paramLong);
        }
        awat.a(this.a).b(localawao.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramakau = new StringBuilder();
          paramakau.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(awat.a(this.a).size()).append(", mNeedCompress:").append(localawao.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(awat.a, 2, paramakau.toString());
        }
      }
    }
    for (;;)
    {
      awat.a(this.a);
      return;
      QLog.d(awat.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localawao.c), ", uniseq:", Long.valueOf(localawao.jdField_a_of_type_Long) });
      continue;
      QLog.d(awat.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awav
 * JD-Core Version:    0.7.0.1
 */