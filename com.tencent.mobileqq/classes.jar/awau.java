import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class awau
  implements awaz
{
  awau(awat paramawat) {}
  
  public void a(long paramLong)
  {
    Iterator localIterator = awat.a(this.a).iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      awao localawao = (awao)localIterator.next();
      if ((paramLong != localawao.jdField_a_of_type_Long) || (!awat.a(this.a).a(localawao.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))) {
        break label114;
      }
      this.a.a(paramLong);
      bool = true;
    }
    label114:
    for (;;)
    {
      break;
      QLog.d(awat.a, 1, new Object[] { "notifyCheckStatus uniseq:", Long.valueOf(paramLong), ", invalid:", Boolean.valueOf(bool) });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d(awat.a, 1, new Object[] { "notifyError uniseq:", Long.valueOf(paramLong), ", errCode:", Integer.valueOf(paramInt) });
    this.a.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awau
 * JD-Core Version:    0.7.0.1
 */