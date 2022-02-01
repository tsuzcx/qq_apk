package com.tencent.hippy.qq.fragment;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;

class BaseHippyFragment$2
  implements HippyQQEngine.HippyQQEngineListener
{
  BaseHippyFragment$2(BaseHippyFragment paramBaseHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    if ((paramInt != 0) && (paramInt != -11))
    {
      if (!this.this$0.gotoErrorUrl()) {
        this.this$0.onLoadHippyError(paramInt, paramString);
      }
      this.this$0.onLoadHippyFinish(paramInt, paramString);
    }
    QLog.d("BaseHippyFragment", 1, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
  }
  
  public void onSuccess()
  {
    QLog.d("BaseHippyFragment", 1, "Hippy: initHippy success!");
    this.this$0.onLoadHippySuccess();
    this.this$0.onLoadHippyFinish(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.BaseHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */