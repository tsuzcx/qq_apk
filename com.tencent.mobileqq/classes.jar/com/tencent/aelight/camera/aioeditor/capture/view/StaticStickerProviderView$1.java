package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;

class StaticStickerProviderView$1
  implements FaceListPage.FacePackagePageEventListener
{
  StaticStickerProviderView$1(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void a()
  {
    SLog.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((PasterDataManager)QIMManager.a(4)).a(true, this.a);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("用户点击下载：");
    localStringBuilder.append(paramString);
    SLog.b("StaticStickerProviderView", localStringBuilder.toString());
    VideoEditReport.b("0X80075DD");
    if (!((DoodleEmojiManager)QIMManager.a(14)).a(paramString, true)) {
      SLog.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("用户点击下载取消：");
    localStringBuilder.append(paramString);
    SLog.b("StaticStickerProviderView", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView.1
 * JD-Core Version:    0.7.0.1
 */