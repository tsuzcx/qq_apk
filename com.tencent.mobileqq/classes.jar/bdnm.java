import android.content.Context;

public abstract class bdnm
{
  public static final String TAG = "BaselibLoader";
  protected bdnn mBaselibContent;
  
  public bdnn getBaselib()
  {
    return this.mBaselibContent;
  }
  
  public boolean isBaseLibInit()
  {
    return (this.mBaselibContent != null) && (this.mBaselibContent.a());
  }
  
  public abstract void loadBaselib(Context paramContext, bdno parambdno);
  
  public void setBaselib(bdnn parambdnn)
  {
    if ((parambdnn != null) && (parambdnn.a())) {
      this.mBaselibContent = parambdnn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnm
 * JD-Core Version:    0.7.0.1
 */