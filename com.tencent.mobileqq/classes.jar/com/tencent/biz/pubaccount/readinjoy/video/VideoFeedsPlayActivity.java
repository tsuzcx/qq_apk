package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import babr;
import bacc;
import bafb;
import bbmy;
import befo;
import bgmq;
import bjeh;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import ndn;
import new;
import nez;
import nji;
import obz;
import org.json.JSONObject;
import pxr;
import pxt;
import pxu;
import pyw;
import qaq;
import qbo;
import qcn;
import qej;
import qek;
import qeq;
import qfe;
import qft;
import qfy;
import qgl;
import qjz;
import qmu;
import qmv;
import qsq;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, pxu, qfe, qgl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pxt jdField_a_of_type_Pxt;
  private qbo jdField_a_of_type_Qbo;
  private qft jdField_a_of_type_Qft;
  private qfy jdField_a_of_type_Qfy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private pxt a()
  {
    if (this.jdField_a_of_type_Pxt == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Pxt;
      this.jdField_a_of_type_Pxt = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Pxt = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_Pxt = new qjz(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    qcn.a(paramActivity);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString);
    }
  }
  
  static void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString, paramException);
    }
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayActivity.2(this, paramVideoInfo));
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      VideoInfo localVideoInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      VideoInfo localVideoInfo1 = localVideoInfo2;
      if (localVideoInfo2 == null) {
        localVideoInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      }
      ThreadManager.excute(new VideoFeedsPlayActivity.5(this, localVideoInfo1, paramString), 16, null, true);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    int i;
    label31:
    VideoInfo localVideoInfo;
    label160:
    Object localObject2;
    label172:
    label207:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label362;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b();
      Object localObject4 = new qmv("", "", "", "").b(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if (localObject1 != null) {
        ((qmv)localObject4).e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).r).l(i).r(((VideoInfo)localObject1).d()).s(this.jdField_b_of_type_Int + 1).d(((VideoInfo)localObject1).j).e(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject1).g);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label367;
      }
      localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
      if (localVideoInfo == null) {
        break label373;
      }
      localObject2 = localVideoInfo.g;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((qmv)localObject4).g((String)localObject2).F(j).N(0);
      if (!paramBoolean) {
        break label379;
      }
      localObject2 = "1";
      if (!this.jdField_a_of_type_Boolean) {
        break label387;
      }
      localObject3 = "0X8009501";
      label218:
      ndn.a(null, "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject2, "", "", ((qmv)localObject4).a().a(), false);
      String str1 = "";
      localObject3 = "";
      localObject4 = "";
      localObject2 = str1;
      if (localObject1 != null)
      {
        String str2 = String.valueOf(i + 1);
        localObject2 = str1;
        localObject3 = str2;
        if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
        {
          localObject2 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
          localObject3 = str2;
        }
      }
      localObject1 = localObject4;
      if (localVideoInfo != null) {
        if (localVideoInfo.jdField_b_of_type_Int < localVideoInfo.c) {
          break label395;
        }
      }
    }
    label387:
    label395:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      ndn.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "", false);
      return;
      localObject1 = null;
      break;
      label362:
      i = 0;
      break label31;
      label367:
      localVideoInfo = null;
      break label160;
      label373:
      localObject2 = null;
      break label172;
      label379:
      localObject2 = "0";
      break label207;
      localObject3 = "0X8007DBB";
      break label218;
    }
  }
  
  private void g()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Int = i;
    if ((i == 9) || (i == 12) || (i == 21) || (i == 20) || (i == 22) || (i == 23)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", this.jdField_a_of_type_Boolean);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", this.jdField_a_of_type_Boolean);
      this.d = bgmq.f(this.jdField_a_of_type_Int);
      return;
    }
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str2;
    if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0) && (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      str2 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      String str3;
      label76:
      String str1;
      label88:
      String str4;
      label100:
      long l;
      label116:
      JSONObject localJSONObject;
      if (localObject != null)
      {
        str3 = ((VideoInfo)localObject).j;
        if (localObject == null) {
          break label222;
        }
        str1 = ((VideoInfo)localObject).g;
        if (localObject == null) {
          break label228;
        }
        str4 = ((VideoInfo)localObject).jdField_a_of_type_JavaLangString;
        if (localObject == null) {
          break label234;
        }
        l = ((VideoInfo)localObject).a() * 1000L;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
        label151:
        if (!TextUtils.isEmpty(str1)) {}
        for (localObject = str1;; localObject = "0")
        {
          ndn.a(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, new.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b(), l, localJSONObject), false);
          return;
          str2 = null;
          break;
          str3 = null;
          break label76;
          label222:
          str1 = null;
          break label88;
          label228:
          str4 = null;
          break label100;
          label234:
          l = 0L;
          break label116;
        }
      }
      catch (Exception localException)
      {
        break label151;
      }
    }
  }
  
  @TargetApi(11)
  private void j()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_Qft = new qft(this);
    this.jdField_a_of_type_Qft.a(i, this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131299813));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131309746));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301831));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131301830));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131301832));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131304244));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131302561);
    if (bjeh.b())
    {
      i = bjeh.b(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131304232));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      c(false);
    }
  }
  
  private void k()
  {
    FlingGestureHandler localFlingGestureHandler;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        break label71;
      }
      localFlingGestureHandler.setTopLayout(new TopEdgeGestureLayout(this));
    }
    for (;;)
    {
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new qej(this));
      return;
      label71:
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      bbmy.a(BaseApplicationImpl.getContext(), nez.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    if (pxr.a(this))
    {
      n();
      return;
    }
    babr.a(this, 230, getString(2131652716), getString(2131652714), getString(2131652713), getString(2131652715), new qek(this), null).show();
  }
  
  private void m()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = localObject1.getClass().getDeclaredField("mExecCommit");
      if (localObject2 != null)
      {
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Field)localObject2).get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = FragmentActivity.class.getDeclaredField("mHandler");
          if (localObject2 != null)
          {
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(this);
            if (localObject2 != null)
            {
              ((Handler)localObject2).removeCallbacks((Runnable)localObject1);
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    VideoInfo localVideoInfo;
    int i;
    if ((paramViewHolder instanceof qaq))
    {
      paramViewHolder = (qaq)paramViewHolder;
      localVideoInfo = paramViewHolder.a.a;
      if (this.jdField_a_of_type_Qfy != null) {
        this.jdField_a_of_type_Qfy.a(localVideoInfo);
      }
      i = paramViewHolder.c;
      if (i <= this.jdField_b_of_type_Int) {
        break label118;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(localVideoInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          b("0X8009A26");
        }
      }
      b(localVideoInfo);
      return;
      label118:
      i = this.jdField_b_of_type_Int;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(false);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    } while (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat));
    ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
  }
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      c(bool);
      if (paramBoolean) {
        break label46;
      }
      a(this);
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(true);
      }
    }
    label46:
    while (!(this.jdField_b_of_type_AndroidViewViewGroup instanceof ViewPagerCompat))
    {
      return;
      bool = false;
      break;
    }
    ((ViewPagerCompat)this.jdField_b_of_type_AndroidViewViewGroup).setScrollable(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(true);
    }
    if (((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof qaq)) && (((qaq)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a != null) && (((qaq)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).c == 0)) {
      b(((qaq)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a);
    }
  }
  
  protected void b()
  {
    super.setContentView(2131494481);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {}
    for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");; this.jdField_a_of_type_JavaLangString = qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID")))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
      h();
      j();
      g();
      k();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.d())) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (!this.d));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (this.jdField_a_of_type_Qbo == null);
    this.jdField_a_of_type_Qbo.a();
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Qfy = new qfy(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_Qfy.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a());
    }
    i();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131310248));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131304243));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.d()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.d)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_Qbo = new qbo(this);
        this.jdField_a_of_type_Qbo.a(this.jdField_c_of_type_AndroidWidgetImageView);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.d)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      } while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (!this.d));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (this.jdField_a_of_type_Qbo == null);
    this.jdField_a_of_type_Qbo.a();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null))
    {
      finish();
      overridePendingTransition(0, 2130772011);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean(nez.jdField_a_of_type_JavaLangString)) {
        nji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    long l = localVideoFeedsPlayManager.a();
    Object localObject = localVideoFeedsPlayManager.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == localObject)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.a());
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject);
      finish();
      overridePendingTransition(0, 2130772011);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        nji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 14, 0);
      }
      a("finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.a());
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.b(paramBoolean);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      if (this.jdField_a_of_type_Qfy != null) {
        this.jdField_a_of_type_Qfy.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
        continue;
        if (paramInt2 == -1)
        {
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new bbmy(getActivity().getApplicationContext());
          ((bbmy)localObject).d(2000);
          if (i != 0)
          {
            ((bbmy)localObject).a(bbmy.a(2));
            ((bbmy)localObject).c(2131626723);
            ((bbmy)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(getActivity().getApplicationContext(), 5.0F));
          }
          else
          {
            ((bbmy)localObject).a(bbmy.a(1));
            ((bbmy)localObject).c(2131626724);
            ((bbmy)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(getActivity().getApplicationContext(), 5.0F));
            continue;
            if (paramInt2 == -1) {
              bbmy.a(getActivity(), 2131653676, 0).a();
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c())) {
      return;
    }
    e(false);
    d();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      obz.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (befo.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    bjeh.a(this);
    if (bjeh.b()) {
      bjeh.c(this);
    }
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "doOnCreate: " + paramBundle);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
      return true;
    }
    b();
    if (paramBundle != null)
    {
      overridePendingTransition(2130772200, 0);
      return true;
    }
    a().a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
    return true;
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.jdField_c_of_type_Boolean = true;
      pxt localpxt = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.c();
        localpxt.a(localVideoInfo);
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
        }
        if (this.jdField_a_of_type_Qfy != null) {
          this.jdField_a_of_type_Qfy.d();
        }
        if (this.jdField_a_of_type_Qbo != null) {
          this.jdField_a_of_type_Qbo.b();
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_Qft != null) {
          this.jdField_a_of_type_Qft.a();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        pyw.a().a();
        qsq.a(this).b();
        a("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a("super.doOnDestroy failed. \n", localIllegalArgumentException);
        m();
        continue;
        Object localObject = null;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Qfy != null) {
      this.jdField_a_of_type_Qfy.c();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.6(this), 500L);
    if (this.jdField_a_of_type_Qfy != null) {
      this.jdField_a_of_type_Qfy.b();
    }
    qsq.a(this).a(-1, -1);
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    qsq.a(getActivity()).a();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    a(this);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.h();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.i();
    }
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        e(false);
        d();
        return;
      } while (this.jdField_a_of_type_Qfy == null);
      this.jdField_a_of_type_Qfy.a(0);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null));
    l();
    b("0X8009A27");
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onRestoreInstanceState: ");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onSaveInstanceState: ");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */