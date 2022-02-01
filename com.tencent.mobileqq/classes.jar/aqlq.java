import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

public class aqlq
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, List<aqla> paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
        return;
      }
      if (paramInt == 3)
      {
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
    } while (paramInt != 6);
    a(paramBoolean, ((Long)((Object[])(Object[])paramObject)[0]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlq
 * JD-Core Version:    0.7.0.1
 */