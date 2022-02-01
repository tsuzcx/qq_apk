import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

class awji
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserverBase", 2, new Object[] { "onUpdate: invoked. ", " type: ", Integer.valueOf(paramInt), " isSuccess: ", Boolean.valueOf(paramBoolean), " data: ", paramObject });
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      g(paramBoolean, paramObject);
      return;
    case 2: 
      a(paramBoolean, paramObject);
      return;
    case 3: 
      f(paramBoolean, paramObject);
      return;
    case 4: 
      e(paramBoolean, paramObject);
      return;
    case 5: 
      d(paramBoolean, paramObject);
      return;
    case 6: 
      c(paramBoolean, paramObject);
      return;
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awji
 * JD-Core Version:    0.7.0.1
 */