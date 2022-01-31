import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.task.MainThreadTask.1;

public abstract class bfet
  extends bfer
{
  public bfet(Context paramContext, bepv parambepv)
  {
    super(paramContext, 3, parambepv);
  }
  
  public abstract void a();
  
  public void d()
  {
    this.a.post(new MainThreadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfet
 * JD-Core Version:    0.7.0.1
 */