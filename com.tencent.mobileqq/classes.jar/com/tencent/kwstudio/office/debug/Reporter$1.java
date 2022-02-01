package com.tencent.kwstudio.office.debug;

import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;

final class Reporter$1
  implements IHostInterface.IHttpListener
{
  Reporter$1(int paramInt) {}
  
  public void onResponse(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report: type=");
    localStringBuilder.append(this.val$type);
    localStringBuilder.append(", status=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", rsp=");
    localStringBuilder.append(paramString);
    Log.d("Reporter", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Reporter.1
 * JD-Core Version:    0.7.0.1
 */