import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class bboh
  extends anyz
{
  bboh(bbof parambbof) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    if (bbof.a(this.a) == null)
    {
      QLog.d(bbof.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    bboa localbboa = (bboa)bbof.a(this.a).peek();
    if (localbboa != null) {
      if ((paramLong == localbboa.jdField_a_of_type_Long) && (localbboa.c == 4))
      {
        localbboa.c = 5;
        bbof.a(this.a).remove(localbboa);
        if (localbboa.jdField_a_of_type_Anyz != null) {
          localbboa.jdField_a_of_type_Anyz.onNotifyResultAfterSendRich(paramBoolean, paramLong, paramanza);
        }
        if (localbboa.jdField_a_of_type_Bbod != null) {
          localbboa.jdField_a_of_type_Bbod.onSendEnd(paramBoolean, paramLong);
        }
        if (localbboa.jdField_a_of_type_Boolean) {
          bcys.a().a(paramLong);
        }
        bbof.a(this.a).b(localbboa.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramanza = new StringBuilder();
          paramanza.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(bbof.a(this.a).size()).append(", mNeedCompress:").append(localbboa.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(bbof.a, 2, paramanza.toString());
        }
      }
    }
    for (;;)
    {
      bbof.a(this.a);
      return;
      QLog.d(bbof.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localbboa.c), ", uniseq:", Long.valueOf(localbboa.jdField_a_of_type_Long) });
      continue;
      QLog.d(bbof.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboh
 * JD-Core Version:    0.7.0.1
 */