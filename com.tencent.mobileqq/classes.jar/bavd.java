import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class bavd
  implements bavi
{
  bavd(bavc parambavc) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = bavc.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      baux localbaux = (baux)localIterator.next();
      if ((paramLong != localbaux.jdField_a_of_type_Long) || (!bavc.a(this.a).a(localbaux.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(bavc.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(bavc.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavd
 * JD-Core Version:    0.7.0.1
 */