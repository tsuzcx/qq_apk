package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.SimpleActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class BottomVideoInfoWidget$MyActivityLifeCycle
  extends SimpleActivityLifeCycle
{
  public BottomVideoInfoWidget$MyActivityLifeCycle(BottomVideoInfoWidget paramBottomVideoInfoWidget) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject == null) || (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(localObject))) {}
    do
    {
      return;
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
        StoryVideoUploadManager.b(this.a.b + " onActivityResult");
        QQToast.a(this.a.b(), this.a.b().getString(2131719317), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (BottomVideoInfoWidget.a(this.a) != null)) {
        BottomVideoInfoWidget.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "BottomVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare == null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void d()
  {
    super.d();
    if ((LiuHaiUtils.a) && (!ScreenUtil.checkDeviceHasNavigationBar(this.a.jdField_a_of_type_AndroidViewView.getContext())) && (BottomVideoInfoWidget.a(this.a) - UIUtils.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 9.0F) > 0))
    {
      Object localObject = BottomVideoInfoWidget.a(this.a).getBackground();
      if ((localObject instanceof StateListDrawable))
      {
        localObject = (DrawableContainer.DrawableContainerState)((StateListDrawable)localObject).getConstantState();
        if (localObject != null) {
          ((GradientDrawable)localObject.getChildren()[0]).setColor(this.a.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167380));
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (BottomVideoInfoWidget.a(this.a) != null) {
      BottomVideoInfoWidget.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.MyActivityLifeCycle
 * JD-Core Version:    0.7.0.1
 */