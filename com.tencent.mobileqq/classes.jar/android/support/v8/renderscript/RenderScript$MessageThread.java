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
    Object localObject2 = this.mRS;
    ((RenderScript)localObject2).nContextInitToClient(((RenderScript)localObject2).mContext);
    while (this.mRun)
    {
      localObject1[0] = 0;
      localObject2 = this.mRS;
      int i = ((RenderScript)localObject2).nContextPeekMessage(((RenderScript)localObject2).mContext, this.mAuxData);
      localObject2 = this.mAuxData;
      int j = localObject2[1];
      int k = localObject2[0];
      if (i == 4)
      {
        localObject2 = localObject1;
        if (j >> 2 >= localObject1.length) {
          localObject2 = new int[j + 3 >> 2];
        }
        localObject1 = this.mRS;
        if (((RenderScript)localObject1).nContextGetUserMessage(((RenderScript)localObject1).mContext, (int[])localObject2) == 4)
        {
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
        else {
          throw new RSDriverException("Error processing message from RenderScript.");
        }
      }
      else if (i == 3)
      {
        localObject2 = this.mRS;
        localObject2 = ((RenderScript)localObject2).nContextGetErrorMessage(((RenderScript)localObject2).mContext);
        if (k < 4096)
        {
          if (this.mRS.mErrorCallback != null)
          {
            this.mRS.mErrorCallback.mErrorMessage = ((String)localObject2);
            this.mRS.mErrorCallback.mErrorNum = k;
            this.mRS.mErrorCallback.run();
            continue;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("non fatal RS error, ");
          localStringBuilder.append((String)localObject2);
          Log.e("RenderScript_jni", localStringBuilder.toString());
          continue;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Fatal error ");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", details: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        throw new RSRuntimeException(((StringBuilder)localObject1).toString());
      }
      try
      {
        sleep(1L, 0);
      }
      catch (InterruptedException localInterruptedException)
      {
        label377:
        break label377;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScript.MessageThread
 * JD-Core Version:    0.7.0.1
 */