import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;

class bdsq
  extends bdsl
{
  public bdsq()
  {
    mze.a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    bdsn.a.set(true);
    mze.b(paramString, BaseApplicationImpl.getApplication().getRuntime(), new bdsr(this, paramString, paramBoolean), true, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsq
 * JD-Core Version:    0.7.0.1
 */