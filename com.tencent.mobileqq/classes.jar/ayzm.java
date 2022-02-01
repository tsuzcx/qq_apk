import com.tencent.mobileqq.app.BusinessObserver;

public class ayzm
  implements BusinessObserver
{
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, ((Integer)paramObject).intValue());
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2) {}
    try
    {
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    catch (Exception paramObject)
    {
      azeu.a("HelloQQWake", "onUpdate_onGetQQAssistantValue error:" + paramObject.getMessage());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzm
 * JD-Core Version:    0.7.0.1
 */