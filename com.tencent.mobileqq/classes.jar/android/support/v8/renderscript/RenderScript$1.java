package android.support.v8.renderscript;

class RenderScript$1
  extends android.renderscript.RenderScript.RSMessageHandler
{
  RenderScript$1(RenderScript paramRenderScript) {}
  
  public void run()
  {
    this.this$0.mMessageCallback.mData = this.mData;
    this.this$0.mMessageCallback.mID = this.mID;
    this.this$0.mMessageCallback.mLength = this.mLength;
    this.this$0.mMessageCallback.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript.1
 * JD-Core Version:    0.7.0.1
 */