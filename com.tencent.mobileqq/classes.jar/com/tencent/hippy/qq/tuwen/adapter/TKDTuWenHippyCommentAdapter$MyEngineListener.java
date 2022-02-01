package com.tencent.hippy.qq.tuwen.adapter;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TKDTuWenHippyCommentAdapter$MyEngineListener
  implements HippyQQEngine.HippyQQEngineListener
{
  private final WeakReference<TKDTuWenHippyCommentAdapter> adapterWeakReference;
  
  private TKDTuWenHippyCommentAdapter$MyEngineListener(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter)
  {
    this.adapterWeakReference = new WeakReference(paramTKDTuWenHippyCommentAdapter);
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    paramString = (TKDTuWenHippyCommentAdapter)this.adapterWeakReference.get();
    if (paramString != null) {
      TKDTuWenHippyCommentAdapter.access$800(paramString, false);
    }
  }
  
  public void onSuccess()
  {
    QLog.d("TKDTuWenHippyCommentAdapter", 1, "Hippy: initHippy success");
    TKDTuWenHippyCommentAdapter localTKDTuWenHippyCommentAdapter = (TKDTuWenHippyCommentAdapter)this.adapterWeakReference.get();
    if (localTKDTuWenHippyCommentAdapter != null) {
      TKDTuWenHippyCommentAdapter.access$900(localTKDTuWenHippyCommentAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.MyEngineListener
 * JD-Core Version:    0.7.0.1
 */