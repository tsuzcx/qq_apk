package com.tencent.biz.expand.ui;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandDebugFragment$Companion$createApngDrawable$3", "Lcom/tencent/image/URLDrawable$DownloadListener;", "onFileDownloadFailed", "", "p0", "", "onFileDownloadStarted", "onFileDownloadSucceed", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandDebugFragment$Companion$createApngDrawable$3
  implements URLDrawable.DownloadListener
{
  ExpandDebugFragment$Companion$createApngDrawable$3(String paramString1, String paramString2) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onFileDownloadFailed(" + paramInt + ") (" + this.b + ")!");
    }
  }
  
  public void onFileDownloadStarted()
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onFileDownloadStarted! (" + this.b + ')');
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandDebugFragment", 2, '[' + this.a + "] onFileDownloadSucceed(" + paramLong + ") (" + this.b + ")!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandDebugFragment.Companion.createApngDrawable.3
 * JD-Core Version:    0.7.0.1
 */