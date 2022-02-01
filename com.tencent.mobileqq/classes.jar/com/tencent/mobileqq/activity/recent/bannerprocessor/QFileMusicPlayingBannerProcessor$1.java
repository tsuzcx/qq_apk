package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileMusicPlayingBannerProcessor$1
  implements View.OnClickListener
{
  QFileMusicPlayingBannerProcessor$1(QFileMusicPlayingBannerProcessor paramQFileMusicPlayingBannerProcessor, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!FileUtil.a(FileViewMusicService.a().b()))
    {
      FileViewMusicService.a().c();
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10008);
      Intent localIntent = new Intent(QFileMusicPlayingBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorQFileMusicPlayingBannerProcessor), FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      QFileMusicPlayingBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorQFileMusicPlayingBannerProcessor).startActivity(localIntent);
      FileManagerReporter.a("0X8004BFE");
      ReportController.a(QFileMusicPlayingBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorQFileMusicPlayingBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QFileMusicPlayingBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */