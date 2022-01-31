import com.tencent.mobileqq.dating.FansEntity;
import java.util.List;

public class ause
  implements alkr
{
  public void a(String paramString1, String paramString2, Object paramObject) {}
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString1, List<auwl> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, List<FansEntity> paramList) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 9: 
    case 10: 
    case 11: 
    case 13: 
    default: 
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 12: 
      a(paramBoolean);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      if ((paramBoolean) && (paramObject != null) && (paramObject.length == 1))
      {
        a(paramBoolean, (List)paramObject[0]);
        return;
      }
      a(false, null);
      return;
    case 6: 
      c(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    case 7: 
      b(paramBoolean);
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], (String)paramObject[1], paramObject[2]);
      return;
    case 14: 
      b(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    }
    a(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ause
 * JD-Core Version:    0.7.0.1
 */