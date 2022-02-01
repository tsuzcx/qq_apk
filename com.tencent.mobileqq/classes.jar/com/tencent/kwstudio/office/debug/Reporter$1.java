package com.tencent.kwstudio.office.debug;

import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;

final class Reporter$1
  implements IHostInterface.IHttpListener
{
  Reporter$1(int paramInt) {}
  
  public void onResponse(int paramInt, String paramString)
  {
    Log.d("Reporter", "report: type=" + this.val$type + ", status=" + paramInt + ", rsp=" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Reporter.1
 * JD-Core Version:    0.7.0.1
 */