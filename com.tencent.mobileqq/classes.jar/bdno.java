import com.tencent.open.model.AppInfo;
import java.util.List;

public class bdno
  implements ajte
{
  protected void a(boolean paramBoolean, List<AppInfo> paramList) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (paramBoolean)
      {
        a(paramBoolean, (List)paramObject, null);
        return;
      }
      a(paramBoolean, null, (String)paramObject);
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, (List)paramObject);
      return;
    }
    a(paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdno
 * JD-Core Version:    0.7.0.1
 */