import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class axst
  implements axsy
{
  axst(axss paramaxss) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = axss.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      axsn localaxsn = (axsn)localIterator.next();
      if ((paramLong != localaxsn.jdField_a_of_type_Long) || (!axss.a(this.a).a(localaxsn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(axss.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(axss.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axst
 * JD-Core Version:    0.7.0.1
 */