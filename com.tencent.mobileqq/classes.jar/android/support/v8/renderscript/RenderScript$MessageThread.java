package android.support.v8.renderscript;

import android.util.Log;

class RenderScript$MessageThread
  extends Thread
{
  static final int RS_ERROR_FATAL_UNKNOWN = 4096;
  static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
  static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
  static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
  static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
  static final int RS_MESSAGE_TO_CLIENT_USER = 4;
  int[] mAuxData = new int[2];
  RenderScript mRS;
  boolean mRun = true;
  
  RenderScript$MessageThread(RenderScript paramRenderScript)
  {
    super("RSMessageThread");
    this.mRS = paramRenderScript;
  }
  
  public void run()
  {
    Object localObject1 = new int[16];
    this.mRS.nContextInitToClient(this.mRS.mContext);
    while (this.mRun)
    {
      localObject1[0] = 0;
      int i = this.mRS.nContextPeekMessage(this.mRS.mContext, this.mAuxData);
      int j = this.mAuxData[1];
      int k = this.mAuxData[0];
      Object localObject2;
      if (i == 4)
      {
        localObject2 = localObject1;
        if (j >> 2 >= localObject1.length) {
          localObject2 = new int[j + 3 >> 2];
        }
        if (this.mRS.nContextGetUserMessage(this.mRS.mContext, (int[])localObject2) != 4) {
          throw new RSDriverException("Error processing message from RenderScript.");
        }
        if (this.mRS.mMessageCallback != null)
        {
          this.mRS.mMessageCallback.mData = ((int[])localObject2);
          this.mRS.mMessageCallback.mID = k;
          this.mRS.mMessageCallback.mLength = j;
          this.mRS.mMessageCallback.run();
          localObject1 = localObject2;
        }
        else
        {
          throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
        }
      }
      else if (i == 3)
      {
        localObject2 = this.mRS.nContextGetErrorMessage(this.mRS.mContext);
        if (k >= 4096) {
          throw new RSRuntimeException("Fatal error " + k + ", details: " + (String)localObject2);
        }
        if (this.mRS.mErrorCallback != null)
        {
          this.mRS.mErrorCallback.mErrorMessage = ((String)localObject2);
          this.mRS.mErrorCallback.mErrorNum = k;
          this.mRS.mErrorCallback.run();
        }
        else
        {
          Log.e("RenderScript_jni", "non fatal RS error, " + (String)localObject2);
        }
      }
      else
      {
        try
        {
          sleep(1L, 0);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript.MessageThread
 * JD-Core Version:    0.7.0.1
 */