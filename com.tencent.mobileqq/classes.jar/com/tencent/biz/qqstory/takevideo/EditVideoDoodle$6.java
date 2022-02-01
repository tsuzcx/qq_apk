package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;

class EditVideoDoodle$6
  implements FaceListPage.FacePackagePageEventListener
{
  EditVideoDoodle$6(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击重新拉取地理贴纸");
    EditVideoDoodle.a(this.a);
  }
  
  public void a(String paramString)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载：" + paramString);
    EditVideoPartManager localEditVideoPartManager = this.a.a;
    if (this.a.a.a()) {}
    for (String str = "2";; str = "1")
    {
      localEditVideoPartManager.a("download_face", 0, 0, new String[] { str, paramString });
      VideoEditReport.b("0X80075DD");
      if (!((DoodleEmojiManager)SuperManager.a(8)).a(paramString, true)) {
        SLog.d("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle.6
 * JD-Core Version:    0.7.0.1
 */