import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class axxc
  implements axxh
{
  axxc(axxb paramaxxb) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = axxb.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      axww localaxww = (axww)localIterator.next();
      if ((paramLong != localaxww.jdField_a_of_type_Long) || (!axxb.a(this.a).a(localaxww.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(axxb.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(axxb.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxc
 * JD-Core Version:    0.7.0.1
 */