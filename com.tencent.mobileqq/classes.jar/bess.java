import android.content.Context;

public abstract class bess
{
  public static final String TAG = "BaselibLoader";
  protected best mBaselibContent;
  
  public best getBaselib()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    return (this.mBaselibContent != null) && (this.mBaselibContent.a());
  }
  
  public abstract void loadBaselib(Context paramContext, besu parambesu);
  
  public void setBaselib(best parambest)
  {
    if ((parambest != null) && (parambest.a())) {
      this.mBaselibContent = parambest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bess
 * JD-Core Version:    0.7.0.1
 */