package com.tencent.biz.qqstory.storyHome;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class QQStoryMainController$5
  extends SimpleJob<Void>
{
  QQStoryMainController$5(QQStoryMainController paramQQStoryMainController, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).c();
    VideoViewFactory.a(this.a.a).b(this.a.a);
    PngQuantUtils.a(QQStoryContext.k());
    ((VideoServerInfoManager)SuperManager.a(4)).c();
    StoryUploadProcessor.checkUploadSessionKey();
    ((StoryConfigManager)SuperManager.a(10)).c();
    SLog.d("QQStoryMainController", "onCreate : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(StoryVideoUploadManager.c()) });
    StoryMsgNotification.a().a(this.a.a, 3);
    SLog.b("QQStoryMainController", "queueIdle loadShortVideoSo start");
    ShortVideoUtils.loadShortVideoSo(this.a.d);
    SLog.b("QQStoryMainController", "queueIdle loadShortVideoSo end");
    SLog.b("QQStoryMainController", "queueIdle startDownloadFilterSo start");
    paramJobContext = this.a;
    paramJobContext.n = PtvFilterSoLoad.a(paramJobContext.d, BaseApplicationImpl.getContext());
    SLog.b("QQStoryMainController", "queueIdle startDownloadFilterSo end");
    SLog.b("QQStoryMainController", "queueIdle preloadFrameDrawable start");
    QQStoryLoadingView.a(this.a.a);
    SLog.b("QQStoryMainController", "queueIdle preloadFrameDrawable end");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.5
 * JD-Core Version:    0.7.0.1
 */