package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryPromoteTaskManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tencent.biz.qqstory.playvideo.dataprovider.FeedIdBasePlayPageLoader.FeedBaseGroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebToolFragment;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PromoteWidgetController
  extends SimpleActivityLifeCycle
{
  public StoryPlayerGlobalHolder a;
  public boolean b = false;
  public String c;
  public String d;
  public int e;
  public long f = -1L;
  public StoryPlayerGroupHolder g;
  public String h;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == StoryPlayerActivity.a) {
      b();
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void a(@NonNull IDataProvider.Data paramData, String paramString)
  {
    int i = this.a.v().i().mReportData.from;
    SLog.a("PromoteWidgetController", "onViewHolderBindData() from: %d, groupId: %s, isFinish: %b, isFastData: %b", Integer.valueOf(i), paramString, Boolean.valueOf(this.a.a().isFinishing()), Boolean.valueOf(paramData.f));
    if (paramData.f)
    {
      SLog.b("PromoteWidgetController", "onViewHolderBindData() fastData will ignore");
      return;
    }
    this.e = 0;
    if (i != 74)
    {
      if (i != 106)
      {
        SLog.a("PromoteWidgetController", "onViewHolderBindData() from(%d) mismatch, will not promote!", Integer.valueOf(i));
        return;
      }
      this.e = 1;
    }
    else
    {
      this.e = 2;
    }
    if (TextUtils.equals(this.d, paramString))
    {
      SLog.b("PromoteWidgetController", "onViewHolderBindData() not first bind");
      return;
    }
    int j = paramData.c.size();
    i = 0;
    while (i < j)
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)paramData.c.get(i);
      SLog.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: %s", Integer.valueOf(i), Integer.valueOf(j), localGroupInfo);
      String str = localGroupInfo.b.b;
      Object localObject;
      if ((localGroupInfo.b instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId))
      {
        localObject = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)localGroupInfo.b).a;
        if (localObject != null) {
          localObject = ((FeedIdListSeqInfo)localObject).c;
        } else {
          AssertUtils.fail("groupInfo FeedIdListSeqInfo is null!", new Object[0]);
        }
      }
      else
      {
        localObject = str;
      }
      ArrayList localArrayList = new ArrayList(new HashSet(localGroupInfo.d.values()));
      SLog.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: groupId: %s, feedId: %s", Integer.valueOf(i), Integer.valueOf(j), str, localArrayList);
      if (TextUtils.equals(str, paramString))
      {
        SLog.d("PromoteWidgetController", "onViewHolderBindData() Find groupId: %s, feeds: %s, unionId: %s", new Object[] { str, localArrayList, localObject });
        if ((!localArrayList.isEmpty()) && (!TextUtils.equals(this.d, paramString)))
        {
          if ((localArrayList.size() > 1) && (this.e == 2)) {
            SLog.d("PromoteWidgetController", "onViewHolderBindData(), feedIds size > 1, unexpected!");
          } else {
            a(localArrayList, (String)localObject, localGroupInfo.c.size());
          }
          this.d = paramString;
        }
      }
      i += 1;
    }
  }
  
  public void a(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    SLog.a("PromoteWidgetController", "attachHolder(%s)", paramStoryPlayerGlobalHolder);
    this.a = paramStoryPlayerGlobalHolder;
    ((StoryPromoteTaskManager)SuperManager.a(29)).a(false);
    this.a.a(this);
  }
  
  public void a(ArrayList<String> paramArrayList, String paramString, int paramInt)
  {
    ThreadManager.executeOnSubThread(new PromoteWidgetController.1(this, paramArrayList, paramString, paramInt));
  }
  
  protected boolean a()
  {
    SLog.b("PromoteWidgetController", "preloadWebProcessAndUrl()");
    Object localObject1 = ((StoryPromoteTaskManager)SuperManager.a(29)).g;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      SLog.a("PromoteWidgetController", "preloadWebProcessAndUrl() url is null! %s", localObject1);
      this.h = "";
      return false;
    }
    Object localObject2 = URLUtil.a((String)localObject1);
    if (!((Map)localObject2).containsKey("sonic")) {
      this.h = URLUtil.a((String)localObject1, "sonic", "1");
    }
    if (!((Map)localObject2).containsKey("vid")) {
      this.h = URLUtil.a((String)localObject1, "vid", this.c);
    }
    localObject1 = (IWebProcessManagerService)QQStoryContext.k().getRuntimeService(IWebProcessManagerService.class, "multi");
    if (localObject1 == null) {
      return false;
    }
    if (((IWebProcessManagerService)localObject1).isNeedPreloadWebProcess()) {
      ((IWebProcessManagerService)localObject1).startWebProcess(203, new PromoteWidgetController.2(this));
    } else {
      this.b = true;
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic()) {
      return false;
    }
    localObject2 = new SonicPreloadData(1003, this.h, true, 0L, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    boolean bool = ((IWebProcessManagerService)localObject1).preloadSonicSession(localArrayList);
    SLog.a("PromoteWidgetController", "preloadSonicSession() load url %s: return %b.", this.h, Boolean.valueOf(bool));
    return bool;
  }
  
  protected boolean a(long paramLong)
  {
    if (TextUtils.isEmpty(this.h))
    {
      SLog.b("PromoteWidgetController", "tryStartPromoteWebActivity() url is null, ignore!");
      return false;
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic())
    {
      SLog.b("PromoteWidgetController", "tryStartPromoteWebActivity() network not ready, ignore!");
      return false;
    }
    StoryReportor.a("weishi_share", "video_cover_exp", 0, 0, new String[] { "", this.c });
    Intent localIntent = StoryPlayerWebFragment.a(this.a.a(), this.h);
    PublicFragmentActivity.Launcher.a(this.a.a(), localIntent, PublicFragmentActivityForTool.class, StoryPlayerWebToolFragment.class, StoryPlayerActivity.a);
    ThreadManager.executeOnSubThread(new PromoteWidgetController.3(this, paramLong));
    return true;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, boolean paramBoolean)
  {
    SLog.a("PromoteWidgetController", "handleVideoCompletion(%s, %s, %b)", paramVideoViewVideoHolder, paramIVideoView, Boolean.valueOf(paramBoolean));
    paramVideoViewVideoHolder = this.a.f();
    int i = 0;
    int j = -1;
    while (i < paramVideoViewVideoHolder.size())
    {
      if (TextUtils.equals(((IDataProvider.GroupInfo)paramVideoViewVideoHolder.get(i)).b.b, this.d)) {
        j = i;
      }
      i += 1;
    }
    if (j >= 0)
    {
      this.g = this.a.a(j);
      paramVideoViewVideoHolder = this.g;
      if ((paramVideoViewVideoHolder != null) && (paramVideoViewVideoHolder.j.getAdapter().getCount() - 1 == this.g.j.getCurrentItem()))
      {
        SLog.a("PromoteWidgetController", "handleVideoCompletion() match last video!! promoteTaskId: %d, fragmentLoaded: %b", Long.valueOf(this.f), Boolean.valueOf(this.b));
        if ((this.b) && (this.f != -1L) && (!TextUtils.isEmpty(this.h)))
        {
          paramBoolean = a(this.f);
          if (!paramBoolean) {
            this.f = -1L;
          }
          return paramBoolean;
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    SLog.b("PromoteWidgetController", "closePromoteWidget()");
    if (!TextUtils.isEmpty(this.c)) {
      StoryReportor.a("weishi_share", "video_cover_close", 0, 0, new String[] { "", this.c });
    }
    this.d = "";
    this.f = -1L;
    this.c = "";
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).c();
      if (((XViewPager)localObject).getCurrentItem() < ((XViewPager)localObject).getAdapter().getCount() - 1)
      {
        ((XViewPager)localObject).setCurrentItem(((XViewPager)localObject).getCurrentItem() + 1, true);
        return true;
      }
      this.a.a().finish();
      StoryReportor.a("play_video", "auto_quit", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController
 * JD-Core Version:    0.7.0.1
 */