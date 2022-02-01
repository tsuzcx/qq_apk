package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
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
  public int a;
  public long a;
  public StoryPlayerGlobalHolder a;
  public StoryPlayerGroupHolder a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public PromoteWidgetController()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == StoryPlayerActivity.jdField_a_of_type_Int) {
      b();
    }
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void a(@NonNull IDataProvider.Data paramData, String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().a().mReportData.from;
    SLog.a("PromoteWidgetController", "onViewHolderBindData() from: %d, groupId: %s, isFinish: %b, isFastData: %b", Integer.valueOf(i), paramString, Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().isFinishing()), Boolean.valueOf(paramData.c));
    if (paramData.c)
    {
      SLog.b("PromoteWidgetController", "onViewHolderBindData() fastData will ignore");
      return;
    }
    this.jdField_a_of_type_Int = 0;
    switch (i)
    {
    default: 
      SLog.a("PromoteWidgetController", "onViewHolderBindData() from(%d) mismatch, will not promote!", Integer.valueOf(i));
      return;
    }
    for (this.jdField_a_of_type_Int = 1; TextUtils.equals(this.b, paramString); this.jdField_a_of_type_Int = 2)
    {
      SLog.b("PromoteWidgetController", "onViewHolderBindData() not first bind");
      return;
    }
    int j = paramData.jdField_a_of_type_JavaUtilList.size();
    i = 0;
    label153:
    IDataProvider.GroupInfo localGroupInfo;
    String str;
    Object localObject;
    label238:
    ArrayList localArrayList;
    if (i < j)
    {
      localGroupInfo = (IDataProvider.GroupInfo)paramData.jdField_a_of_type_JavaUtilList.get(i);
      SLog.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: %s", Integer.valueOf(i), Integer.valueOf(j), localGroupInfo);
      str = localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString;
      if (!(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof FeedIdBasePlayPageLoader.FeedBaseGroupId)) {
        break label383;
      }
      localObject = ((FeedIdBasePlayPageLoader.FeedBaseGroupId)localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a;
      if (localObject == null) {
        break label374;
      }
      localObject = ((FeedIdListSeqInfo)localObject).b;
      localArrayList = new ArrayList(new HashSet(localGroupInfo.jdField_a_of_type_JavaUtilMap.values()));
      SLog.a("PromoteWidgetController", "onViewHolderBindData() [%d/%d]: groupId: %s, feedId: %s", Integer.valueOf(i), Integer.valueOf(j), str, localArrayList);
      if (TextUtils.equals(str, paramString))
      {
        SLog.d("PromoteWidgetController", "onViewHolderBindData() Find groupId: %s, feeds: %s, unionId: %s", new Object[] { str, localArrayList, localObject });
        if ((!localArrayList.isEmpty()) && (!TextUtils.equals(this.b, paramString)))
        {
          if ((localArrayList.size() <= 1) || (this.jdField_a_of_type_Int != 2)) {
            break label390;
          }
          SLog.d("PromoteWidgetController", "onViewHolderBindData(), feedIds size > 1, unexpected!");
        }
      }
    }
    for (;;)
    {
      this.b = paramString;
      i += 1;
      break label153;
      break;
      label374:
      AssertUtils.a("groupInfo FeedIdListSeqInfo is null!", new Object[0]);
      label383:
      localObject = str;
      break label238;
      label390:
      a(localArrayList, (String)localObject, localGroupInfo.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    SLog.a("PromoteWidgetController", "attachHolder(%s)", paramStoryPlayerGlobalHolder);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder = paramStoryPlayerGlobalHolder;
    ((StoryPromoteTaskManager)SuperManager.a(29)).a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(this);
  }
  
  public void a(ArrayList<String> paramArrayList, String paramString, int paramInt)
  {
    ThreadManager.executeOnSubThread(new PromoteWidgetController.1(this, paramArrayList, paramString, paramInt));
  }
  
  protected boolean a()
  {
    SLog.b("PromoteWidgetController", "preloadWebProcessAndUrl()");
    Object localObject1 = ((StoryPromoteTaskManager)SuperManager.a(29)).b;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      SLog.a("PromoteWidgetController", "preloadWebProcessAndUrl() url is null! %s", localObject1);
      this.c = "";
    }
    for (;;)
    {
      return false;
      Object localObject2 = URLUtil.a((String)localObject1);
      if (!((Map)localObject2).containsKey("sonic")) {
        this.c = URLUtil.a((String)localObject1, "sonic", "1");
      }
      if (!((Map)localObject2).containsKey("vid")) {
        this.c = URLUtil.a((String)localObject1, "vid", this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = (IWebProcessManagerService)QQStoryContext.a().getRuntimeService(IWebProcessManagerService.class, "multi");
      if (localObject1 != null)
      {
        if (((IWebProcessManagerService)localObject1).isNeedPreloadWebProcess()) {
          ((IWebProcessManagerService)localObject1).startWebProcess(203, new PromoteWidgetController.2(this));
        }
        while (((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic())
        {
          localObject2 = new SonicPreloadData(1003, this.c, true, 0L, 0);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject2);
          boolean bool = ((IWebProcessManagerService)localObject1).preloadSonicSession(localArrayList);
          SLog.a("PromoteWidgetController", "preloadSonicSession() load url %s: return %b.", this.c, Boolean.valueOf(bool));
          return bool;
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected boolean a(long paramLong)
  {
    if (TextUtils.isEmpty(this.c))
    {
      SLog.b("PromoteWidgetController", "tryStartPromoteWebActivity() url is null, ignore!");
      return false;
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic())
    {
      SLog.b("PromoteWidgetController", "tryStartPromoteWebActivity() network not ready, ignore!");
      return false;
    }
    StoryReportor.a("weishi_share", "video_cover_exp", 0, 0, new String[] { "", this.jdField_a_of_type_JavaLangString });
    Intent localIntent = StoryPlayerWebFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(), this.c);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(), localIntent, PublicFragmentActivityForTool.class, StoryPlayerWebToolFragment.class, StoryPlayerActivity.jdField_a_of_type_Int);
    ThreadManager.executeOnSubThread(new PromoteWidgetController.3(this, paramLong));
    return true;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, boolean paramBoolean)
  {
    boolean bool = false;
    SLog.a("PromoteWidgetController", "handleVideoCompletion(%s, %s, %b)", paramVideoViewVideoHolder, paramIVideoView, Boolean.valueOf(paramBoolean));
    paramVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a();
    int i = 0;
    int j = -1;
    while (i < paramVideoViewVideoHolder.size())
    {
      if (TextUtils.equals(((IDataProvider.GroupInfo)paramVideoViewVideoHolder.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, this.b)) {
        j = i;
      }
      i += 1;
    }
    paramBoolean = bool;
    if (j >= 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(j);
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder != null)
      {
        paramBoolean = bool;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.a().getCount() - 1 == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a.c())
        {
          SLog.a("PromoteWidgetController", "handleVideoCompletion() match last video!! promoteTaskId: %d, fragmentLoaded: %b", Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean));
          paramBoolean = bool;
          if (this.jdField_a_of_type_Boolean)
          {
            paramBoolean = bool;
            if (this.jdField_a_of_type_Long != -1L)
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(this.c))
              {
                bool = a(this.jdField_a_of_type_Long);
                paramBoolean = bool;
                if (!bool)
                {
                  this.jdField_a_of_type_Long = -1L;
                  paramBoolean = bool;
                }
              }
            }
          }
        }
      }
    }
    return paramBoolean;
  }
  
  public boolean b()
  {
    SLog.b("PromoteWidgetController", "closePromoteWidget()");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      StoryReportor.a("weishi_share", "video_cover_close", 0, 0, new String[] { "", this.jdField_a_of_type_JavaLangString });
    }
    this.b = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder != null)
    {
      XViewPager localXViewPager = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a();
      if (localXViewPager.c() < localXViewPager.a().getCount() - 1)
      {
        localXViewPager.setCurrentItem(localXViewPager.c() + 1, true);
        return true;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().finish();
      StoryReportor.a("play_video", "auto_quit", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController
 * JD-Core Version:    0.7.0.1
 */