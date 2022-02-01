import com.tencent.mobileqq.app.BusinessObserver;

public class amvn
  implements BusinessObserver
{
  public void a(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvn
 * JD-Core Version:    0.7.0.1
 */