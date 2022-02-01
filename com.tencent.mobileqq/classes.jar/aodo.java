import com.tencent.mobileqq.app.BusinessObserver;

public class aodo
  implements BusinessObserver
{
  public static final int OBSERVER_TYPE_CHECK_REALNAME = 1;
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[]))) {}
    for (paramObject = (Object[])paramObject;; paramObject = null)
    {
      switch (paramInt)
      {
      }
      do
      {
        return;
      } while (paramObject == null);
      onCheckRealNameRsp(paramBoolean, ((Integer)paramObject[0]).intValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodo
 * JD-Core Version:    0.7.0.1
 */