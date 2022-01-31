import android.content.Context;

@begt(a="GameRuntimeCreateTask")
public class bewb
  extends bfet
{
  private beuh a;
  
  public bewb(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public beuh a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      c();
      return;
    }
    try
    {
      this.a = new beuh();
      this.a.a(a());
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("GameRuntimeCreateTask", "Failed execute GameRuntimeCreateTask", localThrowable);
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewb
 * JD-Core Version:    0.7.0.1
 */