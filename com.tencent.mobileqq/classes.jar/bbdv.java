import com.tencent.mobileqq.app.BusinessObserver;

public class bbdv
  implements BusinessObserver
{
  public void a(boolean paramBoolean, bbdw parambbdw) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, (bbdw)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdv
 * JD-Core Version:    0.7.0.1
 */