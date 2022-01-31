import android.content.Context;

public abstract class besb
{
  public static final String TAG = "BaselibLoader";
  protected besc mBaselibContent;
  
  public besc getBaselib()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    return (this.mBaselibContent != null) && (this.mBaselibContent.a());
  }
  
  public abstract void loadBaselib(Context paramContext, besd parambesd);
  
  public void setBaselib(besc parambesc)
  {
    if ((parambesc != null) && (parambesc.a())) {
      this.mBaselibContent = parambesc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besb
 * JD-Core Version:    0.7.0.1
 */