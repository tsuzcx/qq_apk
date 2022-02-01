import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;

class bkfv
  extends bkfq
{
  public bkfv()
  {
    nmj.a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    bkfs.a.set(true);
    nmj.b(paramString, BaseApplicationImpl.getApplication().getRuntime(), new bkfw(this, paramString, paramBoolean), true, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfv
 * JD-Core Version:    0.7.0.1
 */