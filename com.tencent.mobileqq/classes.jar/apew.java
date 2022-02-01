import com.tencent.qphone.base.util.QLog;

public abstract class apew
  implements anui
{
  public abstract void a(apnb paramapnb);
  
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
      a((apnb)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new apnb());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apew
 * JD-Core Version:    0.7.0.1
 */