import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

class bapu
  extends bapx
{
  private long jdField_a_of_type_Long;
  private WeakReference<Map<Long, bapx>> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<QQAppInterface> b;
  private WeakReference<bapv> c;
  
  public bapu(long paramLong, WeakReference<Map<Long, bapx>> paramWeakReference, WeakReference<QQAppInterface> paramWeakReference1, WeakReference<bapv> paramWeakReference2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.b = paramWeakReference1;
    this.c = paramWeakReference2;
  }
  
  private boolean a()
  {
    return (this.c == null) || (this.c.get() == null);
  }
  
  private boolean a(long paramLong)
  {
    return paramLong != this.jdField_a_of_type_Long;
  }
  
  private boolean a(Map<Long, bapx> paramMap, QQAppInterface paramQQAppInterface)
  {
    QLog.d("QuickLoginObserver", 1, "wrapper.remove");
    paramMap = (bapx)paramMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
    if (paramMap == null)
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: observer not exist");
      return true;
    }
    QLog.d("QuickLoginObserver", 1, "appInterface.removeObserver");
    paramQQAppInterface.removeObserver(paramMap);
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.b == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.b.get() == null);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    QLog.d("QuickLoginObserver", 1, "onSetPCVerify isSuccess: " + paramBoolean + " mark: " + paramLong);
    if (a(paramLong))
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: observer not match mark: " + paramLong + " mPbMark: " + this.jdField_a_of_type_Long);
      return;
    }
    if (b())
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: sanity check fail");
      return;
    }
    if (a((Map)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (QQAppInterface)this.b.get()))
    {
      QLog.e("QuickLoginObserver", 1, "cleanObserverAndCheckEmpty observer empty");
      return;
    }
    if (a())
    {
      QLog.e("QuickLoginObserver", 1, "onSetPCVerify fail: mProxy == null");
      return;
    }
    ((bapv)this.c.get()).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapu
 * JD-Core Version:    0.7.0.1
 */