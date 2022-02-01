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
  private static StoryPlayerTVKWrapper e;
  private Runnable A = new StoryPlayerImpl.4(this);
  protected AudioManager a;
  IDataProvider.ICallBack b = new StoryPlayerImpl.1(this);
  OnSuperPageChangeListener c = new StoryPlayerImpl.2(this);
  protected AudioManager.OnAudioFocusChangeListener d = new StoryPlayerImpl.3(this);
  private StoryPlayerImpl.Ui f;
  private boolean g = false;
  private boolean h = false;
  private StoryPlayerImpl.StoryPlayerContextImpl i;
  private StoryPlayerGlobalHolder j;
  private QQStoryLoadingView k;
  private long l;
  private QQStoryVideoPlayerErrorView m;
  private int n = 0;
  private int o = 0;
  private boolean p = false;
  private OpenPlayerBuilder.Data q;
  private IDataProvider r;
  private IDataProvider.StartInfo s;
  private PlayerDataPreLoader t;
  private FeedManager u = (FeedManager)SuperManager.a(11);
  private Handler v = new Handler(Looper.getMainLooper());
  private boolean w = false;
  private boolean x = true;
  private IDataProvider.GroupId y;
  private String z;
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "initPlayerHolder, [rootView] = ");
    this.q.mReportData.initViewPagerUiTimeStamp = SystemClock.uptimeMillis();
    Object localObject = this.r.c();
    this.s = new IDataProvider.StartInfo((IDataProvider.StartInfo)localObject);
    this.j = new StoryPlayerGlobalHolder(paramRelativeLayout);
    StoryPlayerGlobalHolder localStoryPlayerGlobalHolder = this.j;
    localObject = new StoryPlayerImpl.StoryPlayerContextImpl(this, this.f, localStoryPlayerGlobalHolder.b, this.q, (IDataProvider.StartInfo)localObject, null);
    this.i = ((StoryPlayerImpl.StoryPlayerContextImpl)localObject);
    localStoryPlayerGlobalHolder.a((StoryPlayerContext)localObject);
    this.j.e();
    this.j.a(this.c);
    this.k = ((QQStoryLoadingView)paramRelativeLayout.findViewById(2131437622));
    this.m = ((QQStoryVideoPlayerErrorView)paramRelativeLayout.findViewById(2131449663));
    if (k())
    {
      this.q.mReportData.playerFastStartup = true;
      this.v.postDelayed(this.A, 1000L);
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "initLRTBPager, requestGroupData, currentInfo = %s", new Object[] { this.s });
    this.k.setVisibilityDelay(0, 1000L, "wait feed data");
    this.A.run();
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
    int i1 = paramVideoHolderBase.d;
    int i2 = paramVideoHolderBase.e;
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, GroupPos = %d, VideoPos = %d, Data = %s", Integer.valueOf(i1), Integer.valueOf(i2), paramVideoHolderBase.c);
    Object localObject = this.j.f();
    if ((localObject != null) && (((List)localObject).size() > i1))
    {
      localObject = (IDataProvider.GroupInfo)((List)localObject).get(i1);
      if (!(localObject instanceof UIGroupInfo))
      {
        localObject = ((IDataProvider.GroupInfo)localObject).b;
        if (localObject != null)
        {
          if (!((IDataProvider.GroupId)localObject).equals(this.s.a))
          {
            a(this.s.a, this.s.b);
            this.s.a = ((IDataProvider.GroupId)localObject);
          }
          SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, requestGroupData, currentInfo = %s", new Object[] { this.s });
          this.v.removeCallbacks(this.A);
          this.v.postDelayed(this.A, 500L);
        }
        else
        {
          SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "onPageSelected, groupId is null !!");
        }
      }
      else
      {
        this.w = true;
        this.x = ((UIGroupInfo)localObject).a;
      }
    }
    if (paramVideoHolderBase.c.d())
    {
      localObject = paramVideoHolderBase.f.e;
      String str = paramVideoHolderBase.c.b;
      this.s.c = paramVideoHolderBase.c.c;
      this.s.b = paramVideoHolderBase.c.b;
      if ((localObject instanceof MsgTabPlayPageLoader.MsgTabGroupId))
      {
        ((MsgTabPlayPageLoader.MsgTabGroupId)localObject).f = i2;
        if (this.s.d != null) {
          this.s.d.e = i2;
        }
      }
      if ((!str.equals(this.z)) || (!((IDataProvider.GroupId)localObject).equals(this.y)))
      {
        this.y = ((IDataProvider.GroupId)localObject);
        this.z = str;
        SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "selectedVideoChanged, groupId=%s, mVid=%s", ((IDataProvider.GroupId)localObject).b, str);
        this.r.a((IDataProvider.GroupId)localObject, str);
        this.t.a((IDataProvider.GroupId)localObject, str);
        paramVideoHolderBase = (VideoCoverListGroupHolder)paramVideoHolderBase.f.b(VideoCoverListGroupHolder.class);
        if (paramVideoHolderBase != null) {
          paramVideoHolderBase.b(str);
        }
        StoryDispatcher.a().dispatch(new PlayVideoChangeEvent(this.q.mReportData.openSessionId, (IDataProvider.GroupId)localObject, str));
      }
    }
  }
  
  private void j()
  {
    this.r = PlayerDataProviderFactory.a(this.q.mInfo);
    IDataProvider localIDataProvider = this.r;
    if (localIDataProvider == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.f.finish();
      return;
    }
    localIDataProvider.a();
    this.t = new PlayerDataPreLoader(this.r);
    this.t.b();
  }
  
  private boolean k()
  {
    Object localObject = this.s.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.s.c))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.s.b))
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, groupId=%s, vid=%s", this.s.a.b, this.s.b);
          localObject = new ArrayList();
          IDataProvider.Data localData = new IDataProvider.Data();
          if ((this.s.d != null) && (TextUtils.equals(this.s.d.b.b, this.s.a.b)) && (this.s.d.c.size() > 0))
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first feed. groupId=%s, vid=%s", this.s.a.b, this.s.b);
            this.s.d.f = this.s.b;
            ((ArrayList)localObject).add(this.s.d);
            localData.b = false;
            localData.d = false;
          }
          else
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "generateTheFirstItemAndInitViewPager, play the first vid. groupId=%s, vid=%s", this.s.a.b, this.s.b);
            IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(this.s.a);
            localGroupInfo.c = new ArrayList();
            localGroupInfo.c.add(this.s.b);
            localGroupInfo.d.put(this.s.b, this.s.c);
            localGroupInfo.f = this.s.b;
            ((ArrayList)localObject).add(localGroupInfo);
            localData.b = false;
            localData.d = false;
          }
          this.q.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
          bool1 = true;
          localData.f = true;
          localData.c = ((List)localObject);
          if (!((ArrayList)localObject).isEmpty()) {
            this.k.setVisibility(8);
          }
          this.j.a(localData, this.s.a);
        }
      }
    }
    return bool1;
  }
  
  private void l()
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, getSomeDataSnapShoot currentInfo = %s", this.s);
    Object localObject = this.r.a(this.s.a, 3);
    if (((((IDataProvider.Data)localObject).a != null) && (((IDataProvider.Data)localObject).a.isFail())) || ((((IDataProvider.Data)localObject).e != null) && (((IDataProvider.Data)localObject).e.isFail()) && (((IDataProvider.Data)localObject).c.isEmpty())))
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, and error : up=%s, down=%s", new Object[] { ((IDataProvider.Data)localObject).a, ((IDataProvider.Data)localObject).e });
      this.k.setVisibility(8);
      this.n = 9;
      if (((IDataProvider.Data)localObject).a != null) {}
      for (localObject = ((IDataProvider.Data)localObject).a;; localObject = ((IDataProvider.Data)localObject).e)
      {
        i1 = ((ErrorMessage)localObject).errorCode;
        break label154;
        if (((IDataProvider.Data)localObject).e == null) {
          break;
        }
      }
      i1 = 0;
      label154:
      this.o = i1;
      this.m.setVisibility(0);
      this.m.a(1);
      this.m.setOnTipsClickListener(new StoryPlayerImpl.5(this));
      return;
    }
    if (((IDataProvider.Data)localObject).c.isEmpty())
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData, get no any data, no error : upEnd=%s, downEnd=%s", new Object[] { Boolean.valueOf(((IDataProvider.Data)localObject).b), Boolean.valueOf(((IDataProvider.Data)localObject).d) });
      return;
    }
    this.k.setVisibility(8);
    this.m.setVisibility(8);
    int i2 = ((IDataProvider.Data)localObject).c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)((IDataProvider.Data)localObject).c.get(i1);
      if (TextUtils.equals(localGroupInfo.b.b, this.s.a.b))
      {
        SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "updateData, group=%s, firstPlayVid=%s, currentInfoVid=%s", localGroupInfo.b.b, localGroupInfo.f, this.s.b);
        if ((TextUtils.isEmpty(localGroupInfo.f)) && (!TextUtils.isEmpty(this.s.b))) {
          localGroupInfo.f = this.s.b;
        }
        if (!this.w) {
          break;
        }
        if (this.x)
        {
          i1 -= 1;
          if ((i1 <= 0) || (i1 >= i2)) {
            break;
          }
          this.s.a = ((IDataProvider.GroupInfo)((IDataProvider.Data)localObject).c.get(i1)).b;
          this.w = false;
          break;
        }
        i1 += 1;
        if (i1 >= i2) {
          break;
        }
        this.s.a = ((IDataProvider.GroupInfo)((IDataProvider.Data)localObject).c.get(i1)).b;
        this.w = false;
        break;
      }
      i1 += 1;
    }
    if (this.q.mReportData.initViewPagerDataTimeStamp == 0L) {
      this.q.mReportData.initViewPagerDataTimeStamp = SystemClock.uptimeMillis();
    }
    ((IDataProvider.Data)localObject).f = false;
    this.j.a((IDataProvider.Data)localObject, this.s.a);
  }
  
  private void m()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "requestNecessaryGroupData, requestGroupData, currentInfo = %s", new Object[] { this.s });
    if (!this.p)
    {
      this.p = true;
      this.r.a(this.b);
    }
    this.r.a(this.s.a, 2, 5, this.s.b);
    this.r.a(this.s.a, 0, 5, this.s.b);
    if (!TextUtils.isEmpty(this.s.c))
    {
      this.u.a(this.s.c, true);
      this.u.g(this.s.c);
    }
    if (!TextUtils.isEmpty(this.s.b))
    {
      ((StoryManager)SuperManager.a(5)).m(this.s.b);
      GetPollInfoHandlerWithFreqController.a(this.s.b);
    }
  }
  
  private void n()
  {
    Object localObject = this.k;
    int i1;
    if ((localObject != null) && ((((QQStoryLoadingView)localObject).getVisibility() == 0) || (this.k.getDelayVisibility() == 0)))
    {
      i1 = 200;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("11");
      ((StringBuilder)localObject).append("*");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(String.valueOf(SystemClock.uptimeMillis() - this.l));
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = this.m;
      if ((localObject != null) && (((QQStoryVideoPlayerErrorView)localObject).getVisibility() == 0))
      {
        i1 = this.n;
        localObject = String.valueOf(this.o);
      }
      else
      {
        localObject = "0";
        i1 = 0;
      }
    }
    if (i1 != 0) {
      StoryReportor.b("play_video", "play_result", this.i.i().mReportData.from, i1, new String[] { localObject, "0", StoryReportor.a(this.i.a()), "NO_VID" });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerImpl", "onActivityResult, [requestCode=%d, resultCode=%d, data=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.i;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, startBunlde=%s", new Object[] { paramBundle2 });
    if (paramBundle2 != null) {
      this.q = ((OpenPlayerBuilder.Data)paramBundle2.getSerializable("story_data"));
    }
    Object localObject = this.q;
    if (localObject == null)
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerImpl", "启动参数错误");
      this.f.finish();
      return;
    }
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onCreate, from=%d, mInfo=%s, uiParam=%s", new Object[] { Integer.valueOf(((OpenPlayerBuilder.Data)localObject).mReportData.from), this.q.mInfo, this.q.mUIStyle });
    if (e == null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "create StoryPlayerTVKWrapper");
      e = new StoryPlayerTVKWrapper(this.f.getContext());
    }
    this.q.mReportData.activityOnCreateTimeStamp = SystemClock.uptimeMillis();
    if (this.q.mReportData.startActivityTimeStamp == 0L) {
      this.q.mReportData.startActivityTimeStamp = this.q.mReportData.activityOnCreateTimeStamp;
    }
    j();
    a((RelativeLayout)this.f.a().findViewById(2131445137));
    localObject = this.i;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).a(paramBundle1, paramBundle2);
    }
    paramBundle1 = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBundle1.d())
    {
      paramBundle1.c();
      this.h = true;
    }
    this.a = ((AudioManager)this.f.getContext().getSystemService("audio"));
    Looper.myQueue().addIdleHandler(new StoryPlayerImpl.6(this));
  }
  
  public void a(StoryPlayerImpl.Ui paramUi)
  {
    if ((this.f == null) && (paramUi != null))
    {
      this.f = paramUi;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean a()
  {
    return this.j.h();
  }
  
  public void b()
  {
    AudioManager localAudioManager = this.a;
    if (localAudioManager == null) {
      return;
    }
    try
    {
      int i2 = localAudioManager.requestAudioFocus(this.d, 3, 2);
      int i1 = i2;
      if (i2 == 0) {
        i1 = this.a.requestAudioFocus(this.d, 3, 1);
      }
      if (i1 == 0)
      {
        this.a.requestAudioFocus(this.d, 3, 3);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      a(((IDataProvider.StartInfo)localObject).a, this.s.b);
      SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "uiFinishing, send group change event to msgtab");
    }
    localObject = this.j;
    if (localObject != null) {
      ((StoryPlayerGlobalHolder)localObject).d();
    }
  }
  
  public void d()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStart");
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.i;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.d();
    }
    this.l = SystemClock.uptimeMillis();
  }
  
  public void e()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onResume");
    this.g = true;
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.i;
    if (localStoryPlayerContextImpl != null) {
      localStoryPlayerContextImpl.e();
    }
    b();
    VideoViewFactory.a(this.f.getContext()).c();
  }
  
  public void f()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onPause");
    this.g = false;
    Object localObject = this.i;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).f();
    }
    localObject = this.a;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.d);
    }
  }
  
  public void g()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onStop");
    StoryPlayerImpl.StoryPlayerContextImpl localStoryPlayerContextImpl = this.i;
    if (localStoryPlayerContextImpl != null)
    {
      localStoryPlayerContextImpl.g();
      n();
    }
  }
  
  public void h()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onDestroy");
    Object localObject = this.j;
    if (localObject != null) {
      ((StoryPlayerGlobalHolder)localObject).g();
    }
    localObject = this.r;
    if (localObject != null) {
      ((IDataProvider)localObject).b();
    }
    localObject = this.t;
    if (localObject != null) {
      ((PlayerDataPreLoader)localObject).c();
    }
    localObject = this.i;
    if (localObject != null) {
      ((StoryPlayerImpl.StoryPlayerContextImpl)localObject).h();
    }
    if (this.h) {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
    }
    CacheCleaner.a().b();
  }
  
  public void i()
  {
    SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "onAllDestroy");
    TVKPreloader.b();
    if (e != null)
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "destroy StoryPlayerTVKWrapper");
      e.a();
      e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl
 * JD-Core Version:    0.7.0.1
 */