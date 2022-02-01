import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class bave
  extends anqd
{
  bave(bavc parambavc) {}
  
  public void a(boolean paramBoolean, long paramLong, anqe paramanqe)
  {
    if (bavc.a(this.a) == null)
    {
      QLog.d(bavc.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    baux localbaux = (baux)bavc.a(this.a).peek();
    if (localbaux != null) {
      if ((paramLong == localbaux.jdField_a_of_type_Long) && (localbaux.c == 4))
      {
        localbaux.c = 5;
        bavc.a(this.a).remove(localbaux);
        if (localbaux.jdField_a_of_type_Anqd != null) {
          localbaux.jdField_a_of_type_Anqd.a(paramBoolean, paramLong, paramanqe);
        }
        if (localbaux.jdField_a_of_type_Bava != null) {
          localbaux.jdField_a_of_type_Bava.a(paramBoolean, paramLong);
        }
        if (localbaux.jdField_a_of_type_Boolean) {
          bcfx.a().a(paramLong);
        }
        bavc.a(this.a).b(localbaux.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramanqe = new StringBuilder();
          paramanqe.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(bavc.a(this.a).size()).append(", mNeedCompress:").append(localbaux.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(bavc.a, 2, paramanqe.toString());
        }
      }
    }
    for (;;)
    {
      bavc.a(this.a);
      return;
      QLog.d(bavc.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localbaux.c), ", uniseq:", Long.valueOf(localbaux.jdField_a_of_type_Long) });
      continue;
      QLog.d(bavc.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bave
 * JD-Core Version:    0.7.0.1
 */