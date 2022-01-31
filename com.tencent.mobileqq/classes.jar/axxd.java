import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class axxd
  extends alwx
{
  axxd(axxb paramaxxb) {}
  
  public void a(boolean paramBoolean, long paramLong, alwy paramalwy)
  {
    if (axxb.a(this.a) == null)
    {
      QLog.d(axxb.a, 1, new Object[] { "return because queue is null, isSuccess:", Boolean.valueOf(paramBoolean), " ,uniseq:", Long.valueOf(paramLong) });
      return;
    }
    axww localaxww = (axww)axxb.a(this.a).peek();
    if (localaxww != null) {
      if ((paramLong == localaxww.jdField_a_of_type_Long) && (localaxww.c == 4))
      {
        localaxww.c = 5;
        axxb.a(this.a).remove(localaxww);
        if (localaxww.jdField_a_of_type_Alwx != null) {
          localaxww.jdField_a_of_type_Alwx.a(paramBoolean, paramLong, paramalwy);
        }
        if (localaxww.jdField_a_of_type_Axwz != null) {
          localaxww.jdField_a_of_type_Axwz.a(paramBoolean, paramLong);
        }
        if (localaxww.jdField_a_of_type_Boolean) {
          azex.a().a(paramLong);
        }
        axxb.a(this.a).b(localaxww.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          paramalwy = new StringBuilder();
          paramalwy.append("OrderSendObserver remove uniseq:").append(paramLong).append(", queue size:").append(axxb.a(this.a).size()).append(", mNeedCompress:").append(localaxww.jdField_a_of_type_Boolean).append(", issuccess:").append(paramBoolean);
          QLog.d(axxb.a, 2, paramalwy.toString());
        }
      }
    }
    for (;;)
    {
      axxb.a(this.a);
      return;
      QLog.d(axxb.a, 1, new Object[] { "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(localaxww.c), ", uniseq:", Long.valueOf(localaxww.jdField_a_of_type_Long) });
      continue;
      QLog.d(axxb.a, 1, new Object[] { "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(paramLong), ", issuccess:", Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxd
 * JD-Core Version:    0.7.0.1
 */