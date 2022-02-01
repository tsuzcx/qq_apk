import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class apbk
  implements BusinessObserver
{
  public abstract void a(apjq paramapjq);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSObserver", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      a((apjq)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new apjq());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbk
 * JD-Core Version:    0.7.0.1
 */