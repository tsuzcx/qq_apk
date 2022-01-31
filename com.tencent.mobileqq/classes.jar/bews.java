import android.content.Context;

@behk(a="GameRuntimeCreateTask")
public class bews
  extends bffk
{
  private beuy a;
  
  public bews(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public beuy a()
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
      this.a = new beuy();
      this.a.a(a());
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("GameRuntimeCreateTask", "Failed execute GameRuntimeCreateTask", localThrowable);
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bews
 * JD-Core Version:    0.7.0.1
 */