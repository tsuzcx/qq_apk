package com.tencent.biz.qqstory.storyHome.qqstorylist.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPhotographyGuideInfoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.CompletedListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.Response;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ParallelStepExecutor;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.ReportWatchVideoListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.EventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class StoryListPresenter
  implements Handler.Callback, KeepConstructor, GetUserGuideInfoStep.CompletedListener, IMyStoryPresenter, LocalVideoPushSegment.EventListener
{
  protected Activity a;
  protected boolean b = false;
  protected IMyStoryListView c;
  protected StoryConfigManager d;
  protected Handler e;
  protected ParallelStepExecutor f;
  protected QQCustomDialog g = null;
  protected GuideInfoDialog h = null;
  private int i = -1;
  
  public StoryListPresenter(Activity paramActivity)
  {
    this.a = paramActivity;
    this.d = ((StoryConfigManager)SuperManager.a(10));
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.b = true;
    this.e = new Handler(this);
    this.i = -1;
    this.f = new ParallelStepExecutor(ThreadManager.getSubThreadLooper());
    b();
    if (d()) {
      this.d.d("key_story_has_show_rename_guide", Boolean.valueOf(true));
    } else {
      e();
    }
    k();
    l();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 80001) {
      return;
    }
    m();
  }
  
  public void a(long paramLong)
  {
    this.d.d("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(GetUserGuideInfoStep.Response paramResponse)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing()))
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
      return;
    }
    localObject = this.h;
    if ((localObject != null) && (((GuideInfoDialog)localObject).isShowing()))
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
      return;
    }
    if (paramResponse == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
      return;
    }
    int j = ((Integer)this.d.c("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
    SLog.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(j), Integer.valueOf(paramResponse.e));
    if (paramResponse.e > j)
    {
      this.d.d("qqstory_guide_info_seqno", Integer.valueOf(paramResponse.e));
      localObject = new GuideInfoDialog(this.a, 2131953428);
      ((GuideInfoDialog)localObject).b(paramResponse.a).c(paramResponse.b).d(paramResponse.g).b(new StoryListPresenter.6(this, (GuideInfoDialog)localObject)).e(paramResponse.f).a(new StoryListPresenter.5(this, (GuideInfoDialog)localObject)).setCancelable(true);
      ((GuideInfoDialog)localObject).c(new StoryListPresenter.7(this, (GuideInfoDialog)localObject));
      ((GuideInfoDialog)localObject).setCanceledOnTouchOutside(true);
      ((GuideInfoDialog)localObject).show();
      StoryReportor.a("home_page", "guide_cnt", 0, 0, new String[0]);
    }
  }
  
  public void a(IMyStoryListView paramIMyStoryListView)
  {
    this.c = paramIMyStoryListView;
  }
  
  protected void b()
  {
    LocalVideoPushSegment localLocalVideoPushSegment = (LocalVideoPushSegment)this.c.b("LocalVideoPushSegment");
    if (localLocalVideoPushSegment != null) {
      localLocalVideoPushSegment.a(this);
    }
  }
  
  protected void c()
  {
    if (!(this.a instanceof BaseActivity))
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
      return;
    }
    long l = ((StoryConfigManager)SuperManager.a(10)).k();
    if (System.currentTimeMillis() - l > 7200000L)
    {
      SLog.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
      ((QQStoryHandler)((QQAppInterface)((BaseActivity)this.a).getAppInterface()).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a();
    }
  }
  
  protected boolean d()
  {
    int j = ((Integer)this.d.c("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    SLog.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(j) });
    if (j == 0)
    {
      this.d.d("qqstory_is_story_new_user", Integer.valueOf(1));
      this.g = DialogUtil.a(this.a, 230);
      this.g.setTitle(HardCodeUtil.a(2131911794));
      this.g.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.g.setNegativeButton(HardCodeUtil.a(2131911779), new StoryListPresenter.2(this)).setPositiveButton("立即拍摄", new StoryListPresenter.1(this));
      this.g.getBtnight().setTextColor(this.a.getResources().getColor(2131167370));
      this.g.setOnDismissListener(new StoryListPresenter.3(this));
      this.g.show();
      StoryReportor.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
  }
  
  public void e()
  {
    boolean bool = ((Boolean)this.d.c("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    SLog.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public void f() {}
  
  public void g()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((GuideInfoDialog)localObject).dismiss();
      this.h = null;
    }
  }
  
  public void h()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.b = false;
    Object localObject = this.g;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((GuideInfoDialog)localObject).dismiss();
      this.h = null;
    }
    localObject = this.f;
    if (localObject != null) {
      ((ParallelStepExecutor)localObject).f();
    }
    this.e.removeMessages(2);
    this.e.removeMessages(3);
    this.e.removeMessages(4);
    this.e.removeMessages(5);
    UIUtils.a();
    UIUtils.a(false);
    StoryQIMBadgeView.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean i()
  {
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)QQStoryContext.j().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localTroopRedTouchManager == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo2 = localTroopRedTouchManager.q();
    oidb_0x791.RedDotInfo localRedDotInfo1 = localRedDotInfo2;
    if (localRedDotInfo2 == null)
    {
      localRedDotInfo1 = localRedDotInfo2;
      if (((MsgTabStoryNodeConfigManager)((QQAppInterface)((BaseActivity)this.a).getAppInterface()).getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a)
      {
        SLog.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
        localRedDotInfo2 = localTroopRedTouchManager.e(52);
        localRedDotInfo1 = localRedDotInfo2;
        if (localRedDotInfo2 == null) {
          localRedDotInfo1 = localTroopRedTouchManager.e(35);
        }
      }
    }
    if (localRedDotInfo1 != null)
    {
      SLog.b("Q.qqstory.home.StoryListPresenter", "it have red point");
      int j = localRedDotInfo1.uint32_last_time.get();
      if ((j > 0) && (j > this.i))
      {
        this.i = j;
        return true;
      }
    }
    return false;
  }
  
  public boolean isValidate()
  {
    return this.b;
  }
  
  public boolean j()
  {
    long l = ((Long)this.d.c("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      SLog.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    SLog.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  protected void k()
  {
    SLog.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    ((LocalVideoPushSegment)this.c.b("LocalVideoPushSegment")).c(true);
  }
  
  public boolean l()
  {
    if (NetworkUtils.a(this.a))
    {
      this.f.f();
      this.f.a(new GetUserSelfInfoStep(null)).a(new ReportWatchVideoListStep(this)).a(new GetPhotographyGuideInfoStep()).a(new GetUserGuideInfoStep(this)).a(new StoryListPresenter.9(this)).a(new StoryListPresenter.8(this)).b();
      GetUserInfoHandler.e();
      return true;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911769), 0).show();
    return false;
  }
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter
 * JD-Core Version:    0.7.0.1
 */