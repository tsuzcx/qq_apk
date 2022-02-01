package android.support.v8.renderscript;

class RenderScript$2
  extends android.renderscript.RenderScript.RSErrorHandler
{
  RenderScript$2(RenderScript paramRenderScript) {}
  
  public void run()
  {
    this.this$0.mErrorCallback.mErrorMessage = this.mErrorMessage;
    this.this$0.mErrorCallback.mErrorNum = this.mErrorNum;
    this.this$0.mErrorCallback.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript.2
 * JD-Core Version:    0.7.0.1
 */