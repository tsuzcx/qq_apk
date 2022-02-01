package com.tencent.mobileqq.app.qim;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QIMUndecideNotifyDialog$2
  implements View.OnClickListener
{
  QIMUndecideNotifyDialog$2(QIMUndecideNotifyDialog paramQIMUndecideNotifyDialog, ArrayList paramArrayList, QIMNotifyAddFriend.VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend$VideoInfo.videoVid), 120);
    localOpenPlayerBuilder.a();
    StoryPlayerLauncher.a(this.jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.a, localOpenPlayerBuilder.a(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog.2
 * JD-Core Version:    0.7.0.1
 */