import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.task.MainThreadTask.1;

public abstract class bhhp
  extends bhhn
{
  public bhhp(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, 3, parambgqg);
  }
  
  public abstract void a();
  
  public void d() {}
  
  public void f()
  {
    d();
    this.b.post(new MainThreadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhp
 * JD-Core Version:    0.7.0.1
 */