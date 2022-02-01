package com.tencent.TMG.ptt;

import android.util.Log;

class PttManager$4
  implements Recorder.OnQQRecorderListener
{
  PttManager$4(PttManager paramPttManager) {}
  
  public void onBeginReceiveData() {}
  
  public void onRecorderAbnormal(int paramInt)
  {
    Log.e("PTTManager", "on recorder abnormal!");
    PttManager.access$000(this.this$0).onCompleted(4100, null);
  }
  
  public void onRecorderEnd()
  {
    Log.e("PTTManager", "on recorder end!");
    PttManager.access$000(this.this$0).onCompleted(0, PttManager.access$100(this.this$0).recorderPath);
  }
  
  public void onRecorderError(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on recorder error : path = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" , reason = ");
    localStringBuilder.append(paramString2);
    Log.e("PTTManager", localStringBuilder.toString());
    PttManager.access$000(this.this$0).onCompleted(4101, null);
  }
  
  public void onRecorderFailed(String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("on recorder failed! reason = ");
    paramString.append(paramInt);
    Log.e("PTTManager", paramString.toString());
    if (paramInt == 3)
    {
      PttManager.access$000(this.this$0).onCompleted(4102, null);
      return;
    }
    if (paramInt == 2)
    {
      PttManager.access$000(this.this$0).onCompleted(4101, null);
      return;
    }
    if (paramInt == 4)
    {
      PttManager.access$000(this.this$0).onCompleted(4098, null);
      return;
    }
    if (paramInt == 1)
    {
      PttManager.access$000(this.this$0).onCompleted(4099, null);
      return;
    }
    if (paramInt == 5) {
      PttManager.access$000(this.this$0).onCompleted(4103, null);
    }
  }
  
  public void onRecorderPrepare(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on recorder prepare : path = ");
    localStringBuilder.append(paramString);
    Log.d("PTTManager", localStringBuilder.toString());
  }
  
  public void onRecorderStart()
  {
    Log.d("PTTManager", "on recorder start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.4
 * JD-Core Version:    0.7.0.1
 */