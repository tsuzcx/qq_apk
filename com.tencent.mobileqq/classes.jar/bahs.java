import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class bahs
  extends amwl
{
  bahs(bahq parambahq) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm)
  {
    if (bahq.a(this.a) == null)
    {
      QLog.d(bahq.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    bahl localbahl = (bahl)bahq.a(this.a).peek();
    if (localbahl != null) {
      if ((paramLong == localbahl.jdField_a_of_type_Long) && (localbahl.c == 4))
      {
        localbahl.c = 5;
        bahq.a(this.a).remove(localbahl);
        if (localbahl.jdField_a_of_type_Amwl != null) {
          localbahl.jdField_a_of_type_Amwl.onNotifyResultAfterSendRich(paramBoolean, paramLong, paramamwm);
        }
        if (localbahl.jdField_a_of_type_Baho != null) {
          localbahl.jdField_a_of_type_Baho.onSendEnd(paramBoolean, paramLong);
        }
        if (localbahl.jdField_a_of_type_Boolean) {
          bbry.a().a(paramLong);
        }
        bahq.a(this.a).b(localbahl.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramamwm = new StringBuilder();
          paramamwm.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(bahq.a(this.a).size()).append(", mNeedCompress:").append(localbahl.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(bahq.a, 2, paramamwm.toString());
        }
      }
    }
    for (;;)
    {
      bahq.a(this.a);
      return;
      QLog.d(bahq.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localbahl.c), ", uniseq:", Long.valueOf(localbahl.jdField_a_of_type_Long) });
      continue;
      QLog.d(bahq.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahs
 * JD-Core Version:    0.7.0.1
 */