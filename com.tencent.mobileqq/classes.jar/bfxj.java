import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;

class bfxj
  extends bfxe
{
  public bfxj()
  {
    nbv.a();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    bfxg.a.set(true);
    nbv.b(paramString, BaseApplicationImpl.getApplication().getRuntime(), new bfxk(this, paramString, paramBoolean), true, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxj
 * JD-Core Version:    0.7.0.1
 */