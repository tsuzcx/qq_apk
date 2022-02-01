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
    localObject = new StoryPlayerImpl.StoryPlayerContextImpl(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui, localStoryPlayerGlobalHolder.a, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data, (IDataProvider.StartInfo)localObject, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl = ((StoryPlayerImpl.StoryPlayerContextImpl)localObject);
    localStoryPlayerGlobalHolder.a((StoryPlayerContext)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131370360));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131380703));
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
      String str;
      if (paramString == null) {
        str = "";
      } else {
        str = paramString;
      }
      SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "notifyGroupChangeEvent, send group change event to msgtab groupId=%s, targetVid=%s, paramVid=%s", paramGroupId, paramString, str);
    }
  }
  
  private void a(VideoHolderBase paramVideoHolderBase)
  {
    if (paramVideoHolderBase == null) {
      return;
    }
    int i = paramVideoHolderBase.jdField_a_of_type_Int;
    int j = paramVideoHolderBase.jdField_b_of_type_Int;
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i), Integer.valueOf(j), paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a();
    if ((localObject != null) && (((List)localObject).size() > i))
    {
      localObject = (IDataProvider.GroupInfo)((List)localObject).get(i);
      if (!(localObject instanceof UIGroupInfo))
      {
        localObject = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        if (localObject != null)
        {
          if (!((IDataProvider.GroupId)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId))
          {
            a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupId)localObject);
          }
          SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo });
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        }
        else
        {
          SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        }
      }
      else
      {
        this.d = true;
        this.e = ((UIGroupInfo)localObject).jdField_a_of_type_Boolean;
      }
    }
    if (paramVideoHolderBase.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.c())
    {
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
      if ((!str.equals(this.jdField_a_of_type_JavaLangString)) || (!((IDataProvider.GroupId)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId)))
      {
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
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString))
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
          localObject = new ArrayList();
          IDataProvider.Data localData = new IDataProvider.Data();
          if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
            ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo);
            localData.jdField_a_of_type_Boolean = false;
            localData.jdField_b_of_type_Boolean = false;
          }
          else
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
            IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
            localGroupInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
            localGroupInfo.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
            localGroupInfo.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.b);
            localGroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
            ((ArrayList)localObject).add(localGroupInfo);
            localData.jdField_a_of_type_Boolean = false;
            localData.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
          bool1 = true;
          localData.c = true;
          localData.jdField_a_of_type_JavaUtilList = ((List)localObject);
          if (!((ArrayList)localObject).isEmpty()) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(localData, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
        }
      }
    }
    return bool1;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider = PlayerDataProviderFactory.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo);
    IDataProvider localIDataProvider = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider;
    if (localIDataProvider == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.finish();
      return;
    }
    localIDataProvider.a();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader = new PlayerDataPreLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader.b();
  }
  
  private void j()
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, 3);
    if (((((IDataProvider.Data)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (((IDataProvider.Data)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) || ((((IDataProvider.Data)localObject).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (((IDataProvider.Data)localObject).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.isEmpty())))
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { ((IDataProvider.Data)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, ((IDataProvider.Data)localObject).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage });
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Int = 9;
      if (((IDataProvider.Data)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {}
      for (localObject = ((IDataProvider.Data)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;; localObject = ((IDataProvider.Data)localObject).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage)
      {
        i = ((ErrorMessage)localObject).errorCode;
        break label154;
        if (((IDataProvider.Data)localObject).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
          break;
        }
      }
      i = 0;
      label154:
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new StoryPlayerImpl.5(this));
      return;
    }
    if (((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.isEmpty())
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(((IDataProvider.Data)localObject).jdField_a_of_type_Boolean), Boolean.valueOf(((IDataProvider.Data)localObject).jdField_b_of_type_Boolean) });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    int j = ((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.get(i);
      if (TextUtils.equals(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, localGroupInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localGroupInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString))) {
          localGroupInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString;
        }
        if (!this.d) {
          break;
        }
        if (this.e)
        {
          i -= 1;
          if ((i <= 0) || (i >= j)) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
          this.d = false;
          break;
        }
        i += 1;
        if (i >= j) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = ((IDataProvider.GroupInfo)((IDataProvider.Data)localObject).jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
        this.d = false;
        break;
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
    }
    ((IDataProvider.Data)localObject).c = false;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a((IDataProvider.Data)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
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
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
    int i;
    if ((localObject != null) && ((((QQStoryLoadingView)localObject).getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.a() == 0)))
    {
      i = 200;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("11");
      ((StringBuilder)localObject).append("*");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
      if ((localObject != null) && (((QQStoryVideoPlayerErrorView)localObject).getVisibility() == 0))
      {
        i = this.jdField_a_of_type_Int;
        localObject = String.valueOf(this.jdField_b_of_type_Int);
      }
      else
      {
        localObject = "0";
        i = 0;
      }
    }
    if (i != 0) {
      StoryReportor.b("play_video", "play_result", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a().mReportData.from, i, new String[] { localObject, "0", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl.a()), "NO_VID" });
    }
  }
  
  public void a()
  {
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager == null) {
      return;
    }
    try
    {
      int j = localAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
    if (localObject == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.finish();
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(((OpenPlayerBuilder.Data)localObject).mReportData.from), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mInfo, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mUIStyle });
    if (jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper = new StoryPlayerTVKWrapper(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.getContext());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp == 0L) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.startActivityTimeStamp = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data.mReportData.activityOnCreateTimeStamp;
    }
    i();
    a((RelativeLayout)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.a().findViewById(2131376809));
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBundle1.a())
    {
      paramBundle1.c();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.getContext().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new StoryPlayerImpl.6(this));
  }
  
  public void a(StoryPlayerImpl.Ui paramUi)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui == null) && (paramUi != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui = paramUi;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.c();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo;
    if (localObject != null)
    {
      a(((IDataProvider.StartInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$StartInfo.jdField_a_of_type_JavaLangString);
      SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
    if (localObject != null) {
      ((StoryPlayerGlobalHolder)localObject).b();
    }
  }
  
  public void c()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.c();
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void d()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.jdField_a_of_type_Boolean = true;
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.d();
    }
    a();
    VideoViewFactory.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$Ui.getContext()).a();
  }
  
  public void e()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).e();
    }
    localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  public void f()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localStoryPlayerContextImpl != null)
    {
      localStoryPlayerContextImpl.f();
      l();
    }
  }
  
  public void g()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
    if (localObject != null) {
      ((StoryPlayerGlobalHolder)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider;
    if (localObject != null) {
      ((IDataProvider)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPreloadPlayerDataPreLoader;
    if (localObject != null) {
      ((PlayerDataPreLoader)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl$StoryPlayerContextImpl;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl
 * JD-Core Version:    0.7.0.1
 */