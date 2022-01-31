import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class awas
  implements awax
{
  awas(awar paramawar) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = awar.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      awam localawam = (awam)localIterator.next();
      if ((paramLong != localawam.jdField_a_of_type_Long) || (!awar.a(this.a).a(localawam.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(awar.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(awar.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awas
 * JD-Core Version:    0.7.0.1
 */