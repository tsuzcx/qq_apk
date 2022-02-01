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
  private int a;
  protected Activity a;
  protected Handler a;
  protected StoryConfigManager a;
  protected ParallelStepExecutor a;
  protected IMyStoryListView a;
  protected GuideInfoDialog a;
  protected QQCustomDialog a;
  protected boolean a;
  
  public StoryListPresenter(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog = null;
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
    if (a()) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("key_story_has_show_rename_guide", Boolean.valueOf(true));
    }
    for (;;)
    {
      h();
      d();
      return;
      d();
    }
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.isShowing()))
      {
        SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog but now upgrade dialog is showing");
        return;
      }
      if (paramResponse == null)
      {
        SLog.e("Q.qqstory.home.StoryListPresenter", "showGuideDialog userGuideInfo=null");
        return;
      }
      i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_guide_info_seqno", Integer.valueOf(0))).intValue();
      SLog.a("Q.qqstory.home.StoryListPresenter", "showGuideDialog local:%s,now:%s", Integer.valueOf(i), Integer.valueOf(paramResponse.b));
    } while (paramResponse.b <= i);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_guide_info_seqno", Integer.valueOf(paramResponse.b));
    GuideInfoDialog localGuideInfoDialog = new GuideInfoDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755921);
    localGuideInfoDialog.b(paramResponse.a).c(paramResponse.c).d(paramResponse.e).b(new StoryListPresenter.6(this, localGuideInfoDialog)).e(paramResponse.d).a(new StoryListPresenter.5(this, localGuideInfoDialog)).setCancelable(true);
    localGuideInfoDialog.c(new StoryListPresenter.7(this, localGuideInfoDialog));
    localGuideInfoDialog.setCanceledOnTouchOutside(true);
    localGuideInfoDialog.show();
    StoryReportor.a("home_page", "guide_cnt", 0, 0, new String[0]);
  }
  
  public void a(IMyStoryListView paramIMyStoryListView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
  }
  
  protected boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_is_story_new_user", Integer.valueOf(0))).intValue();
    SLog.d("Q.qqstory.home.StoryListPresenter", "showNewUserGuideIfNeccessary:%d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_is_story_new_user", Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(HardCodeUtil.a(2131714350));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("在这里，你可以拍摄小视频记录真实所见，与好友分享生活美好瞬间。\n");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131714335), new StoryListPresenter.2(this)).setPositiveButton("立即拍摄", new StoryListPresenter.1(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getBtnight().setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166499));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new StoryListPresenter.3(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      StoryReportor.a("home_page", "guide_exp", 0, 0, new String[0]);
      return true;
    }
    return false;
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
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)QQStoryContext.a().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    if (localTroopRedTouchManager == null)
    {
      SLog.e("Q.qqstory.home.StoryListPresenter", "get TroopRedTouchManager is null! so we return have no red point!");
      return false;
    }
    oidb_0x791.RedDotInfo localRedDotInfo = localTroopRedTouchManager.a();
    if ((localRedDotInfo == null) && (((MsgTabStoryNodeConfigManager)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean))
    {
      SLog.b("Q.qqstory.home.StoryListPresenter", "check invisible red point for msgtab");
      localRedDotInfo = localTroopRedTouchManager.a(52);
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
    ((QQStoryHandler)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface()).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).d();
  }
  
  public boolean c()
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
  
  public void d()
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("key_story_has_show_rename_guide", Boolean.valueOf(false))).booleanValue();
    SLog.a("Q.qqstory.home.StoryListPresenter", "showUpgradeGuideIfNeccessary:%b", Boolean.valueOf(bool));
    if (bool) {
      return;
    }
    ThreadManager.executeOnFileThread(new StoryListPresenter.4(this));
  }
  
  public boolean d()
  {
    if (NetworkUtils.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor.c();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestParallelStepExecutor.a(new GetUserSelfInfoStep(null)).a(new ReportWatchVideoListStep(this)).a(new GetPhotographyGuideInfoStep()).a(new GetUserGuideInfoStep(this)).a(new StoryListPresenter.9(this)).a(new StoryListPresenter.8(this)).a();
      GetUserInfoHandler.d();
      return true;
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714325), 0).a();
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog = null;
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog = null;
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
    ((LocalVideoPushSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a("LocalVideoPushSegment")).e_(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i() {}
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter
 * JD-Core Version:    0.7.0.1
 */