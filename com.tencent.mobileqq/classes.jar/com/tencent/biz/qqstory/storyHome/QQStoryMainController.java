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
import anvx;
import ayqz;
import bivu;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.view.widget.StorySimpleLoadView;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Map;
import mqq.os.MqqHandler;
import vzh;
import vzv;
import wbv;
import wcn;
import weg;
import wjp;
import wjs;
import wke;
import xbu;
import xuf;
import xug;
import xuj;
import xuk;
import xul;
import xum;
import xun;
import xuo;
import xup;
import xuq;
import xur;
import xuz;
import xve;
import yck;
import ygp;
import yhd;
import yhh;
import yhn;
import ykq;
import ykv;
import ypv;
import zcf;
import zdl;
import zgz;

public class QQStoryMainController
  implements xug, yhd, yhh
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
  private ayqz jdField_a_of_type_Ayqz = new xuo(this);
  public bivu a;
  public StoryInputBarView a;
  public QQStoryMainController.ScreenActionBroadcastReceiver a;
  public MystoryListView a;
  public NewMessageYellowBar a;
  public StorySimpleLoadView a;
  public QQAppInterface a;
  private xuf jdField_a_of_type_Xuf;
  public xur a;
  public xuz a;
  public yck a;
  public ygp a;
  public ypv a;
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
      jdField_b_of_type_ArrayOfInt = new int[] { 2131381455, 2131381454, 2131374655, 2131374679 };
      jdField_c_of_type_ArrayOfInt = new int[] { 2131381455, 2131381454, 2131374655, 2131374654 };
      return;
    }
  }
  
  public QQStoryMainController(xur paramxur, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Xuz = new xuz();
    this.jdField_a_of_type_Bivu = new xup(this);
    this.jdField_a_of_type_Xur = paramxur;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidOsHandler = new xuq(this, null);
  }
  
  public static void a(Activity paramActivity, String paramString, ImageView paramImageView, TextView paramTextView)
  {
    if ((paramTextView == null) || (paramImageView == null)) {}
    label363:
    label379:
    for (;;)
    {
      return;
      paramImageView.setVisibility(8);
      paramTextView.setVisibility(8);
      Object localObject1 = new xuj(paramString);
      ykq.d("Q.qqstory.home.QQStoryMainActivity", "initRightHallButton config = " + localObject1);
      if ((((xuj)localObject1).jdField_a_of_type_Int != 0) && (((xuj)localObject1).jdField_a_of_type_Int != 3))
      {
        Drawable localDrawable = paramActivity.getResources().getDrawable(2130846693);
        if ((!TextUtils.isEmpty(((xuj)localObject1).jdField_a_of_type_JavaLangString)) && (HttpUtil.isValidUrl(((xuj)localObject1).jdField_a_of_type_JavaLangString)))
        {
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px(paramActivity, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
          localObject2 = URLDrawable.getDrawable(((xuj)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setURLDrawableListener(new xuk(paramImageView, localDrawable));
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(anvx.a(2131710379));
          paramImageView.setImageDrawable((Drawable)localObject2);
          paramImageView.getLayoutParams().width = -2;
          paramImageView.setPadding(0, 0, DisplayUtil.dip2px(paramActivity, 5.0F), 0);
          localObject1 = new xul((xuj)localObject1, paramActivity, paramString);
          paramImageView.setOnClickListener((View.OnClickListener)localObject1);
          paramTextView.setOnClickListener((View.OnClickListener)localObject1);
          if (!"troopStoryHallConfig".equals(paramString)) {
            break label363;
          }
          ykv.a("story_grp", "exp_find_left", 0, 0, new String[] { "", "", "", "" });
        }
        for (;;)
        {
          if (!(paramActivity instanceof QQStoryMainActivity)) {
            break label379;
          }
          ykv.a("content_flow", "exp_entry", 0, 0, new String[0]);
          return;
          if (!TextUtils.isEmpty(((xuj)localObject1).b))
          {
            paramTextView.setVisibility(0);
            paramTextView.setText(((xuj)localObject1).b);
            break;
          }
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(anvx.a(2131710389));
          paramImageView.setImageDrawable(localDrawable);
          break;
          ykv.a("home_page", "push_find", 0, 0, new String[0]);
        }
      }
    }
  }
  
  private void k()
  {
    ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.4(this), 500L);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    Object localObject = (vzv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
    if ((!jdField_c_of_type_Boolean) && (localObject == null)) {
      throw new AssertionError();
    }
    c();
    localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("lebaVersion");
    String str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("redid");
    ykq.b("Q.qqstory.home.position", "story main from lebaVersion " + (String)localObject + str);
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
    yck localyck = this.jdField_a_of_type_Yck;
    boolean bool2 = "old".equals(localObject);
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = localyck.a(bool2, bool1);
      Bosses.get().postJob(new xum(this, "QQStoryMainController"));
      this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
      this.jdField_a_of_type_Yck.jdField_a_of_type_JavaUtilMap.clear();
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
      zdl.a(bool);
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
      zdl.a(bool);
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
  
  public zgz a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramString);
  }
  
  public void a()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.k();
    yck localyck = (yck)wjs.a(11);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0) != null) {
      localyck.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0).getTop();
    }
    localyck.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition();
    ykq.a("Q.qqstory.home.position", "save position:%d, offset:%d", Integer.valueOf(localyck.jdField_a_of_type_Int), Integer.valueOf(localyck.b));
    if (this.jdField_a_of_type_Ygp != null) {
      this.jdField_a_of_type_Ygp.f();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ykq.b("QQStoryMainController", "onActivityResult %d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Ygp != null) {
      this.jdField_a_of_type_Ygp.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt1 != 20000) || (paramIntent == null) || (!paramIntent.getBooleanExtra("back_when_cancel_from_shot", false)))
    {
      return;
      if (paramIntent != null) {
        a(paramIntent.getStringExtra("new_video_extra_info"));
      }
      wcn.b("QQStoryMainController onActivityResult");
      return;
      a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
      return;
      xve.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
      ThreadManager.getUIHandler().postDelayed(new QQStoryMainController.8(this), 100L);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
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
    l();
    e();
    k();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
    }
    this.jdField_a_of_type_Xur.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Ygp != null)) {
      this.jdField_a_of_type_Ygp.a(NetConnInfoCenter.getServerTimeMillis());
    }
    this.jdField_a_of_type_Xuz.b();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    SystemClock.uptimeMillis();
    paramString = zcf.a();
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("from_type");
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("capture_intent_mode", -1);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("firsttab", -1);
    int k = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("secondtab", -1);
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("itemid");
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("story_game_id");
    String str3 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("story_capture_album_id");
    Bundle localBundle = new Bundle();
    if (TextUtils.equals((CharSequence)localObject, "msgTab"))
    {
      localBundle.putInt("entrance_type", 103);
      localBundle.putString("story_default_label", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("story_default_label"));
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if (((Intent)localObject).hasExtra("story_game_capture_type")) {
        localBundle.putInt("story_game_capture_type", ((Intent)localObject).getIntExtra("story_game_capture_type", 1));
      }
      if (((Intent)localObject).hasExtra("story_game_id")) {
        localBundle.putString("story_game_id", ((Intent)localObject).getStringExtra("story_game_id"));
      }
      if (((Intent)localObject).hasExtra("story_game_pk_vid")) {
        localBundle.putString("story_game_pk_vid", ((Intent)localObject).getStringExtra("story_game_pk_vid"));
      }
      if (((Intent)localObject).hasExtra("story_game_pk_feed_id")) {
        localBundle.putString("story_game_pk_feed_id", ((Intent)localObject).getStringExtra("story_game_pk_feed_id"));
      }
      localBundle.putInt("key_finish_jump_to_page", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_finish_jump_to_page", 1));
      if (i == -1) {
        break label377;
      }
      paramString.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, 2, i, j, k, str1, str2, str3, true, 20000);
    }
    for (;;)
    {
      ykq.c("QQStoryMainController", "launchNewVideoTakeActivity by StoryPublishLauncher");
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772239, 2130772041);
      return;
      localBundle.putInt("entrance_type", paramInt);
      break;
      label377:
      paramString.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, 20000);
    }
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("action", 0);
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("action", 0);
    if ((paramBundle != null) && (paramBundle.getBoolean("bundle_has_jump"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      this.jdField_a_of_type_Xuf = new xuf(this.jdField_a_of_type_AndroidAppActivity, this);
      if ((i == 0) || (this.d)) {
        break;
      }
      bool = this.jdField_a_of_type_Xuf.a(i, this.jdField_a_of_type_AndroidAppActivity.getIntent());
      ykq.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b, result=%b", Integer.valueOf(i), Boolean.valueOf(this.d), Boolean.valueOf(bool));
      if (bool)
      {
        this.d = true;
        this.e = true;
      }
      return bool;
    }
    ykq.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b", Integer.valueOf(i), Boolean.valueOf(this.d));
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((yhn)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("FeedSegment")).c(paramString);
    return true;
  }
  
  public void b()
  {
    ykq.b("QQStoryMainController", "reInitData");
    if (this.jdField_a_of_type_Ygp != null)
    {
      this.jdField_a_of_type_Ygp.g();
      this.jdField_a_of_type_Ygp = null;
    }
    this.jdField_a_of_type_Ygp = ((ygp)weg.a(ygp.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_Ygp.a(this);
    this.jdField_a_of_type_Ygp.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.h();
    l();
  }
  
  public void b(Activity paramActivity)
  {
    this.f = true;
    QQLiveImage.onForeground(paramActivity);
    QQLiveImage.resumeAll(paramActivity);
    if (this.jdField_a_of_type_Ygp != null) {
      this.jdField_a_of_type_Ygp.e();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.p();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.o();
    if (this.e)
    {
      this.e = false;
      c(true);
      ykq.c("QQStoryMainController", "force request net");
    }
    wcn.b("QQStoryMainController onResume");
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("bundle_has_jump", this.d);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Xur.b(paramBoolean);
  }
  
  public boolean b()
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
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayqz);
    }
  }
  
  public void c(Activity paramActivity)
  {
    QQLiveImage.onBackground(paramActivity);
    QQLiveImage.pauseAll(paramActivity);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131710376), 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ygp == null)
      {
        ykq.d("QQStoryMainController", "refreshIfNecessary, myStoryListPresenter = null!");
        return;
      }
    } while ((!(this.jdField_a_of_type_Ygp.b() | paramBoolean | this.jdField_a_of_type_Ygp.c())) || (!this.jdField_a_of_type_Ygp.d()));
    ykq.a("QQStoryMainController", "refreshIfNecessary, forceUpdate: %b, redPoint: %b, overTime: %b", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Ygp.b()), Boolean.valueOf(this.jdField_a_of_type_Ygp.c()));
    f();
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayqz);
    }
  }
  
  public void d(Activity paramActivity)
  {
    this.g = true;
    ThreadManager.post(new QQStoryMainController.3(this), 5, null, false);
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
    this.jdField_a_of_type_Xuz.a();
    this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver);
    xbu.b();
    d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.l();
    if (this.jdField_a_of_type_Ygp != null) {
      this.jdField_a_of_type_Ygp.g();
    }
    wjp localwjp = (wjp)wjs.a(5);
    yck localyck = (yck)wjs.a(11);
    wke localwke = (wke)wjs.a(2);
    localyck.c();
    localwke.d();
    localwjp.c();
    ((wbv)wjs.a(6)).a(10000L);
    localyck.jdField_a_of_type_JavaUtilMap.clear();
    QQLiveImage.releaseAll(paramActivity);
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Xur.a();
    this.jdField_a_of_type_Xur.a(vzh.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131374674);
    this.jdField_a_of_type_Ypv = new ypv(new xun(this), this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374711));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDisableAutoRefresh(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setPullRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(false);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167086));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView = new StorySimpleLoadView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.j();
    this.jdField_a_of_type_Ygp = ((ygp)weg.a(ygp.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_Ygp.a(this);
    this.jdField_a_of_type_Ygp.a();
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("new_video_extra_info"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver = new QQStoryMainController.ScreenActionBroadcastReceiver();
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver, localIntentFilter);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.h();
    this.jdField_a_of_type_Xuz.b();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Xur.c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Xur.b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Ygp.d();
  }
  
  public void j()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    c();
    if (this.jdField_a_of_type_Xuz != null) {
      this.jdField_a_of_type_Xuz.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController
 * JD-Core Version:    0.7.0.1
 */