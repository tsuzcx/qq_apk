package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent;
import com.tencent.biz.qqstory.playvideo.dataprovider.GetPollInfoHandlerWithFreqController;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.ICallBack;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.entrance.PlayerDataProviderFactory;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.OnSuperPageChangeListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerContext;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.UIGroupInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoHolderBase;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoryPlayerImpl
  implements ActivityLifeCycle
{
  private static StoryPlayerTVKWrapper jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private QQStoryVideoPlayerErrorView jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
  private StoryPlayerImpl.StoryPlayerContextImpl jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
  private StoryPlayerImpl.Ui jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui;
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  IDataProvider.ICallBack jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$ICallBack = new StoryPlayerImpl.1(this);
  private IDataProvider.StartInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
  private IDataProvider jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider;
  private OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  OnSuperPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener = new StoryPlayerImpl.2(this);
  private StoryPlayerGlobalHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
  private PlayerDataPreLoader jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader;
  private FeedManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = (FeedManager)SuperManager.a(11);
  private QQStoryLoadingView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryPlayerImpl.4(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  
  public StoryPlayerImpl()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new StoryPlayerImpl.3(this);
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo = new IDataProvider.StartInfo((IDataProvider.StartInfo)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder = new StoryPlayerGlobalHolder(paramRelativeLayout);
    StoryPlayerGlobalHolder localStoryPlayerGlobalHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
    localObject = new StoryPlayerImpl.StoryPlayerContextImpl(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (IDataProvider.StartInfo)localObject, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl = ((StoryPlayerImpl.StoryPlayerContextImpl)localObject);
    localStoryPlayerGlobalHolder.a((StoryPlayerContext)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370723));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131381447));
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.playerFastStartup = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo });
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibilityDelay(0, 1000L, "wait feed data");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private void a(IDataProvider.GroupId paramGroupId, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StoryDispatcher.a().dispatch(new MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent(paramGroupId, paramString));
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (String str = "";; str = paramString)
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramGroupId, paramString, str);
      return;
    }
  }
  
  private void a(VideoHolderBase paramVideoHolderBase)
  {
    if (paramVideoHolderBase == null) {}
    label403:
    label414:
    label432:
    for (;;)
    {
      return;
      int i = paramVideoHolderBase.jdField_a_of_type_Int;
      int j = paramVideoHolderBase.jdField_b_of_type_Int;
      SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a();
      if ((localObject != null) && (((List)localObject).size() > i))
      {
        localObject = (IDataProvider.GroupInfo)((List)localObject).get(i);
        if ((localObject instanceof UIGroupInfo)) {
          break label414;
        }
        localObject = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        if (localObject == null) {
          break label403;
        }
        if (!((IDataProvider.GroupId)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId))
        {
          a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupId)localObject);
        }
        SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo });
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      }
      for (;;)
      {
        if (!paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.c()) {
          break label432;
        }
        localObject = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        String str = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.b;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString = paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
        if ((localObject instanceof MsgTabPlayPageLoader.MsgTabGroupId))
        {
          ((MsgTabPlayPageLoader.MsgTabGroupId)localObject).jdField_a_of_type_Int = j;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_Int = j;
          }
        }
        if ((str.equals(this.jdField_a_of_type_JavaLangString)) && (((IDataProvider.GroupId)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId))) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupId)localObject);
        this.jdField_a_of_type_JavaLangString = str;
        SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((IDataProvider.GroupId)localObject).jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a((IDataProvider.GroupId)localObject, str);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader.a((IDataProvider.GroupId)localObject, str);
        paramVideoHolderBase = (VideoCoverListGroupHolder)paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b(VideoCoverListGroupHolder.class);
        if (paramVideoHolderBase != null) {
          paramVideoHolderBase.a(str);
        }
        StoryDispatcher.a().dispatch(new PlayVideoChangeEvent(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.openSessionId, (IDataProvider.GroupId)localObject, str));
        return;
        SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        continue;
        this.d = true;
        this.e = ((UIGroupInfo)localObject).jdField_a_of_type_Boolean;
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString)))
    {
      SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
      ArrayList localArrayList = new ArrayList();
      IDataProvider.Data localData = new IDataProvider.Data();
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
        localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo);
        localData.jdField_a_of_type_Boolean = false;
      }
      for (localData.jdField_b_of_type_Boolean = false;; localData.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        localData.c = true;
        localData.jdField_a_of_type_JavaUtilList = localArrayList;
        if (!localArrayList.isEmpty()) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(localData, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
        return true;
        SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
        IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
        localGroupInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        localGroupInfo.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
        localGroupInfo.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b);
        localGroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
        localArrayList.add(localGroupInfo);
        localData.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider = PlayerDataProviderFactory.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader = new PlayerDataPreLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader.b();
  }
  
  private void j()
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo);
    IDataProvider.Data localData = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 3);
    if (((localData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((localData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (localData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (localData.jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { localData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, localData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (localData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
        i = localData.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new StoryPlayerImpl.5(this));
        return;
        if (localData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
          i = localData.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
        } else {
          i = 0;
        }
      }
    }
    if (localData.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(localData.jdField_a_of_type_Boolean), Boolean.valueOf(localData.jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = localData.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localData.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.equals(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) {
          break label521;
        }
        SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localGroupInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString))) {
          localGroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
        }
        if (this.d)
        {
          if (!this.e) {
            break label481;
          }
          if ((i - 1 > 0) && (i - 1 < j))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)localData.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
            this.d = false;
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
        }
        localData.c = false;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(localData, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
        return;
        label481:
        if (i + 1 < j)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)localData.jdField_a_of_type_JavaUtilList.get(i + 1)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
          this.d = false;
        }
      }
      label521:
      i += 1;
    }
  }
  
  private void k()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo });
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$ICallBack);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 2, 5, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 0, 5, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b, true);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString))
    {
      ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
      GetPollInfoHandlerWithFreqController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void l()
  {
    String str = "0";
    int i;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a() == 0)))
    {
      i = 200;
      str = "11" + "*";
      str = str + String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (i != 0) {
        StoryReportor.b("play_video", "play_result", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a().mReportData.from, i, new String[] { str, "0", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a()), "NO_VID" });
      }
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
      {
        i = this.jdField_a_of_type_Int;
        str = String.valueOf(this.jdField_b_of_type_Int);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      try
      {
        int j = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        int i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.finish();
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper = new StoryPlayerTVKWrapper(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.a().findViewById(2131377356));
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.a().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new StoryPlayerImpl.6(this));
  }
  
  public void a(StoryPlayerImpl.Ui paramUi)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui != null) || (paramUi == null)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui = paramUi;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
      SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.b();
    }
  }
  
  public void c()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.d();
    }
    a();
    VideoViewFactory.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.a()).a();
  }
  
  public void e()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.e();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.f();
      l();
    }
  }
  
  public void g()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.d();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.b();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader.c();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.g();
    }
    if (this.jdField_b_of_type_Boolean) {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
    }
    CacheCleaner.a().a();
  }
  
  public void h()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    TVKPreloader.b();
    if (jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper != null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper.a();
      jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl
 * JD-Core Version:    0.7.0.1
 */