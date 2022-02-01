package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class MoreVideoInfoWidget$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public MoreVideoInfoWidget$MyActivityLifeCycle(MoreVideoInfoWidget paramMoreVideoInfoWidget) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.o();
    if (localObject != null)
    {
      if (!this.a.e.equals(localObject)) {
        return;
      }
      if (paramInt1 == this.a.hashCode())
      {
        SLog.b(this.a.i, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.d()).r();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(false);
        }
        if (paramInt2 == -1) {
          SendVideoToFriendHelper.a().a(paramIntent.getExtras());
        }
      }
      if ((paramInt1 == 10002) && (paramInt2 == -1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.i);
        ((StringBuilder)localObject).append(" onActivityResult");
        StoryVideoUploadManager.b(((StringBuilder)localObject).toString());
        QQToast.makeText(this.a.y(), this.a.y().getString(2131916571), 1).show();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (MoreVideoInfoWidget.b(this.a) != null)) {
        MoreVideoInfoWidget.b(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.i, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
      if (this.a.s != null) {
        this.a.s.a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void h()
  {
    super.h();
    if (MoreVideoInfoWidget.a(this.a) != null) {
      MoreVideoInfoWidget.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */