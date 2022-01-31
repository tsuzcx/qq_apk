package com.tencent.biz.qqstory.storyHome;

import ajyc;
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
import atzm;
import bbev;
import bcpw;
import bcsv;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.biz.qqstory.view.widget.StorySimpleLoadView;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.Map;
import mqq.os.MqqHandler;
import nam;
import ssi;
import ssw;
import suw;
import svo;
import sxp;
import tcz;
import tdc;
import tdo;
import tvk;
import unv;
import unw;
import unz;
import uoa;
import uob;
import uoc;
import uod;
import uoe;
import uof;
import uog;
import uoh;
import uop;
import uou;
import uwa;
import vaf;
import vat;
import vax;
import vbd;
import veg;
import vel;
import vjp;
import vpp;
import vwm;
import vxs;
import wcr;

public class QQStoryMainController
  implements unw, vat, vax
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
  private atzm jdField_a_of_type_Atzm = new uoe(this);
  public bcsv a;
  public StoryInputBarView a;
  public QQStoryMainController.ScreenActionBroadcastReceiver a;
  public MystoryListView a;
  public NewMessageYellowBar a;
  public StorySimpleLoadView a;
  public QQAppInterface a;
  private unv jdField_a_of_type_Unv;
  public uoh a;
  public uop a;
  public uwa a;
  public vaf a;
  public vjp a;
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
      jdField_b_of_type_ArrayOfInt = new int[] { 2131379438, 2131379437, 2131373308, 2131373332 };
      jdField_c_of_type_ArrayOfInt = new int[] { 2131379438, 2131379437, 2131373308, 2131373307 };
      return;
    }
  }
  
  public QQStoryMainController(uoh paramuoh, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Uop = new uop();
    this.jdField_a_of_type_Bcsv = new uof(this);
    this.jdField_a_of_type_Uoh = paramuoh;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidOsHandler = new uog(this, null);
  }
  
  public static void a(Activity paramActivity, String paramString, ImageView paramImageView, TextView paramTextView)
  {
    if ((paramTextView == null) || (paramImageView == null)) {}
    label362:
    label378:
    for (;;)
    {
      return;
      paramImageView.setVisibility(8);
      paramTextView.setVisibility(8);
      Object localObject1 = new unz(paramString);
      veg.d("Q.qqstory.home.QQStoryMainActivity", "initRightHallButton config = " + localObject1);
      if ((((unz)localObject1).jdField_a_of_type_Int != 0) && (((unz)localObject1).jdField_a_of_type_Int != 3))
      {
        Drawable localDrawable = paramActivity.getResources().getDrawable(2130845775);
        if ((!TextUtils.isEmpty(((unz)localObject1).jdField_a_of_type_JavaLangString)) && (nam.a(((unz)localObject1).jdField_a_of_type_JavaLangString)))
        {
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = vpp.b(paramActivity, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
          localObject2 = URLDrawable.getDrawable(((unz)localObject1).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setURLDrawableListener(new uoa(paramImageView, localDrawable));
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(ajyc.a(2131710920));
          paramImageView.setImageDrawable((Drawable)localObject2);
          paramImageView.getLayoutParams().width = -2;
          paramImageView.setPadding(0, 0, vpp.b(paramActivity, 5.0F), 0);
          localObject1 = new uob((unz)localObject1, paramActivity, paramString);
          paramImageView.setOnClickListener((View.OnClickListener)localObject1);
          paramTextView.setOnClickListener((View.OnClickListener)localObject1);
          if (!"troopStoryHallConfig".equals(paramString)) {
            break label362;
          }
          vel.a("story_grp", "exp_find_left", 0, 0, new String[] { "", "", "", "" });
        }
        for (;;)
        {
          if (!(paramActivity instanceof QQStoryMainActivity)) {
            break label378;
          }
          vel.a("content_flow", "exp_entry", 0, 0, new String[0]);
          return;
          if (!TextUtils.isEmpty(((unz)localObject1).b))
          {
            paramTextView.setVisibility(0);
            paramTextView.setText(((unz)localObject1).b);
            break;
          }
          paramImageView.setVisibility(0);
          paramImageView.setContentDescription(ajyc.a(2131710930));
          paramImageView.setImageDrawable(localDrawable);
          break;
          vel.a("home_page", "push_find", 0, 0, new String[0]);
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
    Object localObject = (ssw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
    if ((!jdField_c_of_type_Boolean) && (localObject == null)) {
      throw new AssertionError();
    }
    c();
    localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("lebaVersion");
    String str = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("redid");
    veg.b("Q.qqstory.home.position", "story main from lebaVersion " + (String)localObject + str);
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    uwa localuwa = this.jdField_a_of_type_Uwa;
    boolean bool2 = "old".equals(localObject);
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = localuwa.a(bool2, bool1);
      Bosses.get().postJob(new uoc(this, "QQStoryMainController"));
      this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
      this.jdField_a_of_type_Uwa.jdField_a_of_type_JavaUtilMap.clear();
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
      vxs.a(bool);
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
      vxs.a(bool);
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
  
  public wcr a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramString);
  }
  
  public void a()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.k();
    uwa localuwa = (uwa)tdc.a(11);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0) != null) {
      localuwa.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getChildAt(0).getTop();
    }
    localuwa.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition();
    veg.a("Q.qqstory.home.position", "save position:%d, offset:%d", Integer.valueOf(localuwa.jdField_a_of_type_Int), Integer.valueOf(localuwa.b));
    if (this.jdField_a_of_type_Vaf != null) {
      this.jdField_a_of_type_Vaf.f();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    veg.b("QQStoryMainController", "onActivityResult %d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Vaf != null) {
      this.jdField_a_of_type_Vaf.a(paramInt1, paramInt2, paramIntent);
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
      svo.b("QQStoryMainController onActivityResult");
      return;
      a(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
      return;
      uou.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
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
    this.jdField_a_of_type_Uoh.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Vaf != null)) {
      this.jdField_a_of_type_Vaf.a(NetConnInfoCenter.getServerTimeMillis());
    }
    this.jdField_a_of_type_Uop.b();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    SystemClock.uptimeMillis();
    paramString = vwm.a();
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
      veg.c("QQStoryMainController", "launchNewVideoTakeActivity by StoryPublishLauncher");
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772217, 2130772038);
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
      this.jdField_a_of_type_Unv = new unv(this.jdField_a_of_type_AndroidAppActivity, this);
      if ((i == 0) || (this.d)) {
        break;
      }
      bool = this.jdField_a_of_type_Unv.a(i, this.jdField_a_of_type_AndroidAppActivity.getIntent());
      veg.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b, result=%b", Integer.valueOf(i), Boolean.valueOf(this.d), Boolean.valueOf(bool));
      if (bool)
      {
        this.d = true;
        this.e = true;
      }
      return bool;
    }
    veg.a("QQStoryMainController", "handleAction pass action=%d, hasJump=%b", Integer.valueOf(i), Boolean.valueOf(this.d));
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((vbd)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("FeedSegment")).c(paramString);
    return true;
  }
  
  public void b()
  {
    veg.b("QQStoryMainController", "reInitData");
    if (this.jdField_a_of_type_Vaf != null)
    {
      this.jdField_a_of_type_Vaf.g();
      this.jdField_a_of_type_Vaf = null;
    }
    this.jdField_a_of_type_Vaf = ((vaf)sxp.a(vaf.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_Vaf.a(this);
    this.jdField_a_of_type_Vaf.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.h();
    l();
  }
  
  public void b(Activity paramActivity)
  {
    this.f = true;
    QQLiveImage.onForeground(paramActivity);
    QQLiveImage.resumeAll(paramActivity);
    if (this.jdField_a_of_type_Vaf != null) {
      this.jdField_a_of_type_Vaf.e();
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
      veg.c("QQStoryMainController", "force request net");
    }
    svo.b("QQStoryMainController onResume");
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("bundle_has_jump", this.d);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Uoh.b(paramBoolean);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atzm);
    }
  }
  
  public void c(Activity paramActivity)
  {
    QQLiveImage.onBackground(paramActivity);
    QQLiveImage.pauseAll(paramActivity);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidAppActivity)) {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131710917), 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Vaf == null)
      {
        veg.d("QQStoryMainController", "refreshIfNecessary, myStoryListPresenter = null!");
        return;
      }
    } while ((!(this.jdField_a_of_type_Vaf.b() | paramBoolean | this.jdField_a_of_type_Vaf.c())) || (!this.jdField_a_of_type_Vaf.d()));
    veg.a("QQStoryMainController", "refreshIfNecessary, forceUpdate: %b, redPoint: %b, overTime: %b", Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Vaf.b()), Boolean.valueOf(this.jdField_a_of_type_Vaf.c()));
    f();
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atzm);
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
    this.jdField_a_of_type_Uop.a();
    this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$ScreenActionBroadcastReceiver);
    tvk.b();
    d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.l();
    if (this.jdField_a_of_type_Vaf != null) {
      this.jdField_a_of_type_Vaf.g();
    }
    tcz localtcz = (tcz)tdc.a(5);
    uwa localuwa = (uwa)tdc.a(11);
    tdo localtdo = (tdo)tdc.a(2);
    localuwa.c();
    localtdo.d();
    localtcz.c();
    ((suw)tdc.a(6)).a(10000L);
    localuwa.jdField_a_of_type_JavaUtilMap.clear();
    QQLiveImage.releaseAll(paramActivity);
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Uoh.a();
    this.jdField_a_of_type_Uoh.a(ssi.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131373327);
    this.jdField_a_of_type_Vjp = new vjp(new uod(this), this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373364));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDisableAutoRefresh(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setPullRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(false);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166912));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView = new StorySimpleLoadView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStorySimpleLoadView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.j();
    this.jdField_a_of_type_Vaf = ((vaf)sxp.a(vaf.class, new Object[] { this.jdField_a_of_type_AndroidAppActivity }));
    this.jdField_a_of_type_Vaf.a(this);
    this.jdField_a_of_type_Vaf.a();
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
    this.jdField_a_of_type_Uop.b();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Uoh.c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Uoh.b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Vaf.d();
  }
  
  public void j()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = QQStoryContext.a();
    c();
    if (this.jdField_a_of_type_Uop != null) {
      this.jdField_a_of_type_Uop.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController
 * JD-Core Version:    0.7.0.1
 */