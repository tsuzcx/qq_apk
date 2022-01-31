package com.tencent.biz.qqstory.storyHome;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.implement.StoryConfigImplement;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.PullRefreshListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.StorySimpleLoadView;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Map;
import mqq.os.MqqHandler;
import ntn;
import nto;
import ntp;
import ntq;
import ntr;
import nts;
import ntt;
import ntu;
import ntv;
import ntw;

public class QQStoryMainController
  implements QQStoryHomeJumpHelper.JumpListener, IMyStoryListView, MystoryListView.PullRefreshListener
{
  public static final int[] b;
  public static final int[] c;
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  public Activity a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public StoryInputBarView a;
  private QQStoryHomeJumpHelper jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryHomeJumpHelper;
  public QQStoryMainController.QQStoryMainView a;
  public QQStoryMainController.ScreenActionBroadcastReceiver a;
  public QQStoryTakeVideoActivityLauncher a;
  public StoryHomePushYellowBarHandler a;
  public FeedManager a;
  public StoryListPresenter a;
  public MystoryListView a;
  public NewMessageYellowBar a;
  public TakeVideoButtonMainPart a;
  public StorySimpleLoadView a;
  public QQAppInterface a;
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new ntt(this);
  public OnItemSelectListener a;
  public boolean a;
  public int[] a;
  public View b;
  public boolean b;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  static
  {
    if (!QQStoryMainController.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_ArrayOfInt = new int[] { 2131371857, 2131371816, 2131371856, 2131372029 };
      jdField_c_of_type_ArrayOfInt = new int[] { 2131371857, 2131371816, 2131371856, 2131371797 };
      return;
    }
  }
  
  public QQStoryMainController(QQStoryMainController.QQStoryMainView paramQQStoryMainView, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler = new StoryHomePushYellowBarHandler();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarOnItemSelectListener = new ntv(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView = paramQQStoryMainView;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidOsHandler = new ntw(this, null);
  }
  
  public static void a(Activity paramActivity, String paramString, ImageView paramImageView, TextView paramTextView)
  {
    if ((paramTextView == null) || (paramImageView == null)) {}
    label353:
    label369:
    for (;;)
    {
      return;
      paramImageView.setVisibility(8);
      paramTextView.setVisibility(8);
      Object localObject1 = new QQStoryMainActivity.ButtonConfig(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "initRightHallButton config = " + localObject1);
      }
      if (((QQStoryMainActivity.ButtonConfig)localObject1).jdField_a_of_type_Int != 0)
      {
        Drawable localDrawable = paramActivity.getResources().getDrawable(2130843610);
        if ((!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject1).jdField_a_of_type_JavaLangString)) && (HttpUtil.a(((QQStoryMainActivity.ButtonConfig)localObject1).jdField_a_of_type_JavaLangString)))
        {
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a(paramActivity, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
          localObject2 = URLDrawable.getDrawable(((QQStoryMainActivity.ButtonConfig)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setURLDrawableListener(new ntn(paramImageView, localDrawable));
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription("发现");
          paramImageView.setImageDrawable((Drawable)localObject2);
          paramImageView.getLayoutParams().width = -2;
          paramImageView.setPadding(0, 0, DisplayUtil.a(paramActivity, 5.0F), 0);
          localObject1 = new nto((QQStoryMainActivity.ButtonConfig)localObject1, paramActivity, paramString);
          paramImageView.setOnClickListener((View.OnClickListener)localObject1);
          paramTextView.setOnClickListener((View.OnClickListener)localObject1);
          if (!"troopStoryHallConfig".equals(paramString)) {
            break label353;
          }
          StoryReportor.a("story_grp", "exp_find_left", 0, 0, new String[] { "", "", "", "" });
        }
        for (;;)
        {
          if (!(paramActivity instanceof QQStoryMainActivity)) {
            break label369;
          }
          StoryReportor.a("content_flow", "exp_entry", 0, 0, new String[0]);
          return;
          if (!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject1).b))
          {
            paramTextView.setVisibility(0);
            paramTextView.setText(((QQStoryMainActivity.ButtonConfig)localObject1).b);
            break;
          }
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription("发现");
          paramImageView.setImageDrawable(localDrawable);
          break;
          StoryReportor.a("home_page", "push_find", 0, 0, new String[0]);
        }
      }
    }
  }
  
  private void o()
  {
    ThreadManager.getUIHandler().postDelayed(new ntq(this), 500L);
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    Object localObject = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
    if ((!jdField_c_of_type_Boolean) && (localObject == null)) {
      throw new AssertionError();
    }
    f();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher = new QQStoryTakeVideoActivityLauncher(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("lebaVersion");
    String str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("redid");
    SLog.b("Q.qqstory.home.position", "story main from lebaVersion " + (String)localObject + str);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    FeedManager localFeedManager = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager;
    boolean bool2 = "old".equals(localObject);
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = localFeedManager.a(bool2, bool1);
      Bosses.get().postJob(new ntr(this));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public StoryInputBarView a()
  {
    boolean bool;
    ViewStub localViewStub;
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      bool = true;
      AssertUtils.a(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView == null)
      {
        localViewStub = (ViewStub)this.jdField_b_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[2]);
        if (localViewStub == null) {
          break label62;
        }
      }
    }
    label62:
    for (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)localViewStub.inflate());; this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.jdField_b_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[3])))
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
      bool = false;
      break;
    }
  }
  
  public NewMessageYellowBar a()
  {
    boolean bool;
    ViewStub localViewStub;
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      bool = true;
      AssertUtils.a(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar == null)
      {
        localViewStub = (ViewStub)this.jdField_b_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[0]);
        if (localViewStub == null) {
          break label62;
        }
      }
    }
    label62:
    for (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)localViewStub.inflate());; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)this.jdField_b_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[1])))
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar;
      bool = false;
      break;
    }
  }
  
  public SegmentView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramString);
  }
  
  public void a()
  {
    this.f = true;
    QQLiveImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.e();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.q();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.p();
    if (this.e)
    {
      this.e = false;
      c(true);
      SLog.c("QQStoryMainController", "force request net");
    }
    StoryVideoUploadManager.b("QQStoryMainController onResume");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.b("QQStoryMainController", "onActivityResult %d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 10006: 
    case 20000: 
    case 20003: 
      if (paramIntent != null) {
        a(paramIntent.getStringExtra("new_video_extra_info"));
      }
      StoryVideoUploadManager.b("QQStoryMainController onActivityResult");
      return;
    case 20001: 
      a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
      return;
    }
    AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
    ThreadManager.getUIHandler().postDelayed(new ntu(this), 100L);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(Intent paramIntent)
  {
    a(null);
    a(paramIntent.getStringExtra("new_video_extra_info"));
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      throw new IllegalStateException("mContext should not be null! should call onAttach() pass the activity");
    }
    a(paramBundle);
    p();
    h();
    o();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a(NetConnInfoCenter.getServerTimeMillis());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler.b();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = StoryPublishLauncher.a();
    if (((StoryPublishLauncher)localObject).a())
    {
      SLog.d("QQStoryMainController", "launchNewVideoTakeActivity by StoryPublishLauncher");
      paramString = new Bundle();
      paramString.putInt("entrance_type", paramInt);
      paramString.putString("story_default_label", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("story_default_label"));
      ((StoryPublishLauncher)localObject).a(this.jdField_a_of_type_AndroidAppActivity, paramString, 20000);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2131034327, 2131034167);
      return;
    }
    boolean bool;
    if ((!paramBoolean2) || (a()))
    {
      bool = true;
      localObject = new QQStoryTakeVideoActivityLauncher(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean1, bool);
      ((Intent)localObject).putExtra("entrance_type", paramInt);
      if (paramString != null) {
        ((Intent)localObject).putExtra("launch_take_video_view_extra_value_key", paramString);
      }
      if (!bool) {
        break label264;
      }
      ((Intent)localObject).putExtra("start_time", l);
      ((Intent)localObject).putExtra("extra_now_tab", StoryConfigImplement.a());
      ((Intent)localObject).putExtra("story_default_label", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("story_default_label"));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 20000);
      if (!paramBoolean2) {
        break label252;
      }
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2131034327, 2131034167);
    }
    for (;;)
    {
      SLog.b("QQStoryMainController", "launchNewVideoTakeActivity end");
      return;
      bool = false;
      break;
      label252:
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
    label264:
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 20001);
  }
  
  public boolean a()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("action", 0);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("action", 0);
    if ((paramBundle != null) && (paramBundle.getBoolean("bundle_has_jump"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryHomeJumpHelper = new QQStoryHomeJumpHelper(this.jdField_a_of_type_AndroidAppActivity, this);
      if ((i == 0) || (this.d)) {
        break;
      }
      bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryHomeJumpHelper.a(i, this.jdField_a_of_type_AndroidAppActivity.getIntent());
      SLog.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b, result=%b", Integer.valueOf(i), Boolean.valueOf(this.d), Boolean.valueOf(bool));
      if (bool)
      {
        this.d = true;
        this.e = true;
      }
      return bool;
    }
    SLog.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b", Integer.valueOf(i), Boolean.valueOf(this.d));
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((FeedSegment)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("FeedSegment")).c(paramString);
    return true;
  }
  
  public void b()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.l();
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0) != null) {
      localFeedManager.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0).getTop();
    }
    localFeedManager.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition();
    SLog.a("Q.qqstory.home.position", "save position:%d, offset:%d", Integer.valueOf(localFeedManager.jdField_a_of_type_Int), Integer.valueOf(localFeedManager.b));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.f();
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("bundle_has_jump", this.d);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.b(paramBoolean);
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter == null)
      {
        SLog.d("QQStoryMainController", "refreshIfNecessary, myStoryListPresenter = null!");
        return;
      }
    } while ((!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a() | paramBoolean | this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.b())) || (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.c()));
    SLog.a("QQStoryMainController", "refreshIfNecessary, forceUpdate: %b, redPoint: %b, overTime: %b", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.b()));
    i();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = a();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.g = true;
    ThreadManager.post(new ntp(this), 5, null, false);
    if (this.jdField_a_of_type_Long > 0L)
    {
      int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = -1L;
      Now.a((int)(l1 - l2), i);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.d();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler.a();
    this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver);
    VideoViewFactory.a(this.jdField_a_of_type_AndroidAppActivity).a();
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.m();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.g();
    }
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    localFeedManager.c();
    localUserManager.d();
    localStoryManager.c();
    ((PreloadDownloaderManager)SuperManager.a(6)).a(10000L);
    localFeedManager.jdField_a_of_type_JavaUtilMap.clear();
    QQLiveImage.releaseAll();
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public void e()
  {
    SLog.b("QQStoryMainController", "reInitData");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.g();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter = null;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter = ((StoryListPresenter)StoryApi.a(StoryListPresenter.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.i();
    p();
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.a("日迹");
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371825);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart = new TakeVideoButtonMainPart(new nts(this), this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371757));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDisableAutoRefresh(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setPullRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(false);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131494255));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView = new StorySimpleLoadView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.k();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter = ((StoryListPresenter)StoryApi.a(StoryListPresenter.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.a();
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("new_video_extra_info"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver = new QQStoryMainController.ScreenActionBroadcastReceiver();
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver, localIntentFilter);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.i();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler.b();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.c();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.b();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.d();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterStoryListPresenter.c();
  }
  
  public void n()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    f();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController
 * JD-Core Version:    0.7.0.1
 */