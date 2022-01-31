import com.tencent.qphone.base.util.QLog;

public abstract class amsp
  implements alpg
{
  public abstract void a(anau paramanau);
  
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
      a((anau)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new anau());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsp
 * JD-Core Version:    0.7.0.1
 */