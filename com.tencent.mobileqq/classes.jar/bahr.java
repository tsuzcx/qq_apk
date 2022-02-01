import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class bahr
  implements bahw
{
  bahr(bahq parambahq) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = bahq.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      bahl localbahl = (bahl)localIterator.next();
      if ((paramLong != localbahl.jdField_a_of_type_Long) || (!bahq.a(this.a).a(localbahl.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(bahq.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(bahq.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahr
 * JD-Core Version:    0.7.0.1
 */