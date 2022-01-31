import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class avba
  extends ajmm
{
  avba(avay paramavay) {}
  
  public void a(boolean paramBoolean, long paramLong, ajmn paramajmn)
  {
    if (avay.a(this.a) == null)
    {
      QLog.d(avay.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    avat localavat = (avat)avay.a(this.a).peek();
    if (localavat != null) {
      if ((paramLong == localavat.jdField_a_of_type_Long) && (localavat.c == 4))
      {
        localavat.c = 5;
        avay.a(this.a).remove(localavat);
        if (localavat.jdField_a_of_type_Ajmm != null) {
          localavat.jdField_a_of_type_Ajmm.a(paramBoolean, paramLong, paramajmn);
        }
        if (localavat.jdField_a_of_type_Avaw != null) {
          localavat.jdField_a_of_type_Avaw.a(paramBoolean, paramLong);
        }
        if (localavat.jdField_a_of_type_Boolean) {
          awfy.a().a(paramLong);
        }
        avay.a(this.a).b(localavat.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramajmn = new StringBuilder();
          paramajmn.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(avay.a(this.a).size()).append(", mNeedCompress:").append(localavat.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(avay.a, 2, paramajmn.toString());
        }
      }
    }
    for (;;)
    {
      avay.a(this.a);
      return;
      QLog.d(avay.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localavat.c), ", uniseq:", Long.valueOf(localavat.jdField_a_of_type_Long) });
      continue;
      QLog.d(avay.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avba
 * JD-Core Version:    0.7.0.1
 */