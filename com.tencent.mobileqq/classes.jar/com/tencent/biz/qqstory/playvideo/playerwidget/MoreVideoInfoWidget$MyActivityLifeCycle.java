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
    Object localObject = this.a.a();
    if (localObject != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(localObject)) {
        return;
      }
      if (paramInt1 == this.a.hashCode())
      {
        SLog.b(this.a.b, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
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
        ((StringBuilder)localObject).append(this.a.b);
        ((StringBuilder)localObject).append(" onActivityResult");
        StoryVideoUploadManager.b(((StringBuilder)localObject).toString());
        QQToast.a(this.a.b(), this.a.b().getString(2131719035), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (MoreVideoInfoWidget.a(this.a) != null)) {
        MoreVideoInfoWidget.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (MoreVideoInfoWidget.a(this.a) != null) {
      MoreVideoInfoWidget.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */