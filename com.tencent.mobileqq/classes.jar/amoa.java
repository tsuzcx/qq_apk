import com.tencent.qphone.base.util.QLog;

public abstract class amoa
  implements alkr
{
  public abstract void a(amwl paramamwl);
  
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
      a((amwl)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new amwl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoa
 * JD-Core Version:    0.7.0.1
 */