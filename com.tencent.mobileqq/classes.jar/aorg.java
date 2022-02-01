import com.tencent.qphone.base.util.QLog;

public abstract class aorg
  implements anil
{
  public abstract void a(aozl paramaozl);
  
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
      a((aozl)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new aozl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorg
 * JD-Core Version:    0.7.0.1
 */