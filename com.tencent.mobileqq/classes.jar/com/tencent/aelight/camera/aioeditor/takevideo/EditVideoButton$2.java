package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

class EditVideoButton$2
  implements ModuleDownloadListener
{
  EditVideoButton$2(EditVideoButton paramEditVideoButton) {}
  
  public void onDownloadCanceled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadCanceled ");
    localStringBuilder.append(paramString);
    QLog.i("Q.qqstory.record.EditVideoButton", 2, localStringBuilder.toString());
  }
  
  public void onDownloadFailed(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFailed ");
    localStringBuilder.append(paramString);
    QLog.i("Q.qqstory.record.EditVideoButton", 2, localStringBuilder.toString());
    if ((this.a.a != null) && (this.a.a.getActivity() != null)) {
      this.a.a.getActivity().runOnUiThread(new EditVideoButton.2.2(this));
    }
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("cyber_clink_version_2.jar")) {
      return;
    }
    if ((this.a.a != null) && (this.a.a.getActivity() != null)) {
      this.a.a.getActivity().runOnUiThread(new EditVideoButton.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton.2
 * JD-Core Version:    0.7.0.1
 */