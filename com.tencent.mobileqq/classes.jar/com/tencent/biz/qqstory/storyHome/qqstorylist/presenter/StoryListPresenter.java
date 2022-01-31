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
import com.tencent.biz.qqstory.boundaries.StoryDepends.CameraFlow;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
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
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import oee;
import oef;
import oeg;
import oeh;
import oei;
import oej;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class StoryListPresenter
  implements Handler.Callback, KeepConstructor, GetUserGuideInfoStep.CompletedListener, IMyStoryPresenter, LocalVideoPushSegment.EventListener
{
  private int a;
  protected Activity a;
  protected Handler a;
  protected StoryConfigManager a;
  protected ParallelStepExecutor a;
  public IMyStoryListView a;
  protected QQCustomDialog a;
  protected boolean a;
  
  public StoryListPresenter(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "---------onCreate----------");
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor = new ParallelStepExecutor(ThreadManager.getSubThreadLooper());
    b();
    d();
    h();
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    i();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("story_list_last_update_from_net_time", Long.valueOf(paramLong));
  }
  
  public void a(GetUserGuideInfoStep.Response paramResponse)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
    }
    int i;
    do
    {
      return;
      if (paramResponse == null)
      {
        SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      SLog.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramResponse.b));
    } while (paramResponse.b <= i);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_guide_info_seqno", Integer.valueOf(paramResponse.b));
    GuideInfoDialog localGuideInfoDialog = new GuideInfoDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624193);
    localGuideInfoDialog.a(paramResponse.a).b(paramResponse.c).c(paramResponse.e).b(new oeh(this, localGuideInfoDialog)).d(paramResponse.d).a(new oeg(this, localGuideInfoDialog)).setCancelable(true);
    localGuideInfoDialog.setCanceledOnTouchOutside(true);
    localGuideInfoDialog.show();
    StoryReportor.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(IMyStoryListView paramIMyStoryListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
  }
  
  public boolean a()
  {
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)QQStoryContext.a().getManager(69);
    if (localTroopRedTouchManager == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localTroopRedTouchManager.a();
    if ((localRedDotInfo == null) && (((MsgTabStoryNodeConfigManager)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(251)).jdField_a_of_type_Boolean))
    {
      SLog.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localTroopRedTouchManager.a(49);
      if (localRedDotInfo == null) {
        localRedDotInfo = localTroopRedTouchManager.a(35);
      }
    }
    for (;;)
    {
      if (localRedDotInfo != null)
      {
        SLog.b("Q.qqstory.home.StoryListPresenter", "it have red point");
        int i = localRedDotInfo.uint32_last_time.get();
        if ((i > 0) && (i > this.jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_Int = i;
          return true;
        }
        return false;
      }
      return false;
    }
  }
  
  protected void b()
  {
    LocalVideoPushSegment localLocalVideoPushSegment = (LocalVideoPushSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a("LocalVideoPushSegment");
    if (localLocalVideoPushSegment != null) {
      localLocalVideoPushSegment.a(this);
    }
  }
  
  public boolean b()
  {
    long l = ((Long)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("story_list_last_update_from_net_time", Long.valueOf(0L))).longValue();
    if (l == 0L)
    {
      SLog.d("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime,preUpdateTime = 0!");
      return true;
    }
    l = NetConnInfoCenter.getServerTimeMillis() - l;
    SLog.a("Q.qqstory.home.StoryListPresenter", "checkStoryListUpdateOverTime gap=%s", Long.valueOf(l));
    return l > 600000L;
  }
  
  protected void c()
  {
    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get app interface failed.");
    }
    long l;
    do
    {
      return;
      l = ((StoryConfigManager)SuperManager.a(10)).b();
    } while (System.currentTimeMillis() - l <= 7200000L);
    SLog.b("Q.qqstory.home.StoryListPresenter", "need update story config from server.");
    ((QQStoryHandler)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).a(98)).d();
  }
  
  public boolean c()
  {
    if (NetworkUtils.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor.c();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor.a(new GetUserSelfInfoStep(null)).a(new ReportWatchVideoListStep(this)).a(new GetPhotographyGuideInfoStep()).a(new GetUserGuideInfoStep(this)).a(new oej(this)).a(new oei(this)).a();
      GetUserInfoHandler.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    return false;
  }
  
  protected void d()
  {
    int i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    SLog.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle("你的每一天，都值得分享");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton("我知道了", new oef(this)).setPositiveButton("开启我的一天", new oee(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493776));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      StoryReportor.a("home_page", "guide_exp", 0, 0, new String[0]);
    }
  }
  
  public boolean d()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(QQStoryContext.a());
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void g()
  {
    SLog.b("Q.qqstory.home.StoryListPresenter", "-------onDestory---------");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    UIUtils.a();
    UIUtils.a(false);
    StoryQIMBadgeView.b();
  }
  
  protected void h()
  {
    SLog.e("Q.qqstory.home.StoryListPresenter", "showLocalVideoSegmentIfNecessary");
    LocalVideoPushSegment localLocalVideoPushSegment = (LocalVideoPushSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a("LocalVideoPushSegment");
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now new User dialog is showing");
      if (localLocalVideoPushSegment != null) {
        localLocalVideoPushSegment.e_(false);
      }
    }
    while (localLocalVideoPushSegment == null) {
      return;
    }
    localLocalVideoPushSegment.e_(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.StoryListPresenter", 2, "localVideoClick");
    }
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      QLog.e("Q.qqstory.home.StoryListPresenter", 2, "context == null");
      return;
    }
    Object localObject;
    if (!d())
    {
      localObject = new QQStoryTakeVideoActivityLauncher(QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, false, false);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 80001);
      return;
    }
    try
    {
      StoryDepends.CameraFlow.a(this.jdField_a_of_type_AndroidAppActivity);
      StoryReportor.a("video_shoot", "clk_local", 0, 0, new String[0]);
      localObject = StoryPublishLauncher.a();
      if (((StoryPublishLauncher)localObject).a())
      {
        ((StoryPublishLauncher)localObject).b(this.jdField_a_of_type_AndroidAppActivity, null, 10006);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("Q.qqstory.home.StoryListPresenter", 4, "QQStoryFlowCallback ", localException);
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQStoryMainActivity)) {}
    for (String str = "from_home";; str = "from_now")
    {
      QQStoryFlowCallback.a(this.jdField_a_of_type_AndroidAppActivity, 0, "qqstory", null, LocalVideoSelectActivity.class.getName(), str, true, 99, 10006);
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter
 * JD-Core Version:    0.7.0.1
 */