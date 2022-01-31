import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aylg
  implements ajte
{
  protected void a(boolean paramBoolean, List<String> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      try
      {
        if ((paramObject instanceof List))
        {
          a(paramBoolean, (List)paramObject);
          return;
        }
        if (!paramBoolean)
        {
          a(false, null);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("ParticipleObserver", 1, paramObject, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aylg
 * JD-Core Version:    0.7.0.1
 */