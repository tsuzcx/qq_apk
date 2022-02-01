import java.util.ArrayList;
import java.util.List;

public class aohi
  implements anui
{
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  protected void b(boolean paramBoolean, List<Long> paramList) {}
  
  protected void b(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    int i;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramObject instanceof long[])) {
        paramObject = (long[])paramObject;
      }
      Object[] arrayOfObject;
      for (i = 0;; i = ((Integer)arrayOfObject[1]).intValue())
      {
        int k = paramObject.length;
        while (j < k)
        {
          localArrayList.add(Long.valueOf(paramObject[j]));
          j += 1;
        }
        arrayOfObject = (Object[])paramObject;
        paramObject = (long[])arrayOfObject[0];
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        a(paramBoolean);
        return;
      case 2: 
        a(paramBoolean, paramObject);
        a(paramBoolean, paramObject, i);
        return;
      case 3: 
        b(paramBoolean, paramObject);
        b(paramBoolean, paramObject, i);
        return;
      }
      a();
      return;
      paramObject = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohi
 * JD-Core Version:    0.7.0.1
 */