import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.task.MainThreadTask.1;

public abstract class bffk
  extends bffi
{
  public bffk(Context paramContext, beqm parambeqm)
  {
    super(paramContext, 3, parambeqm);
  }
  
  public abstract void a();
  
  public void aU_() {}
  
  public void d()
  {
    aU_();
    this.a.post(new MainThreadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bffk
 * JD-Core Version:    0.7.0.1
 */