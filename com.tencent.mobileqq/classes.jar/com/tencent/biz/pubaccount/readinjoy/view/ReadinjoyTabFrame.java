package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler.ReadInJoySkinObserver;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import min;
import mio;
import miq;
import miv;
import miw;
import mix;
import miy;
import miz;
import mja;
import mjb;
import mjc;
import mjd;
import mje;
import mjf;
import mjg;
import mjj;
import mjl;
import mjm;
import mjn;
import mjo;
import mjp;
import mjr;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadinjoyTabFrame
  extends Frame
  implements KandianMergeManager.MessageObserver, KandianMergeManager.OnTabRedNumsChangeListenner, ReadInJoySkinManager.OnSkinChangedListener, ReadinjoySlidingIndicator.onIndicatorChangeListener
{
  public final float a;
  public final int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new mjf(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInJoyNaviController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver = new mjj(this);
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private ReadInJoyNavigationGridview jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview;
  private ReadInJoySkinGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView;
  private ReadinjoySlidingIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator;
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  public final float b;
  public final int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ReadInJoyBaseFragment jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private boolean jdField_b_of_type_Boolean;
  public final float c;
  public int c;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ReadInJoyBaseFragment jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private boolean jdField_c_of_type_Boolean;
  public final float d;
  private final int jdField_d_of_type_Int = 1;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private ImageView g;
  
  public ReadinjoyTabFrame()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Float = 0.1F;
    this.jdField_b_of_type_Float = 0.72F;
    this.jdField_c_of_type_Float = 0.95F;
    this.jdField_d_of_type_Float = 1.05F;
  }
  
  private void A()
  {
    for (;;)
    {
      try
      {
        Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
        JSONObject localJSONObject = ReadInJoyUtils.a();
        if (((KandianMergeManager)localObject).a() == 0L)
        {
          i = 1;
          localJSONObject.put("reddot", i);
          localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
          if ((((ReadInJoySkinManager)localObject).a() == 1) && (!TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a())))
          {
            localObject = ((ReadInJoySkinManager)localObject).a();
            localJSONObject.put("skin_id", localObject);
            PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "3", "", "", localJSONObject.toString(), false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.4tab", 2, "bbCircleClickReport has finished,  r5: " + localJSONObject.toString());
            }
          }
          else
          {
            localObject = "0";
            continue;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      int i = 2;
    }
  }
  
  private void B()
  {
    if (!WebProcessManager.c()) {
      ThreadManager.getUIHandler().postDelayed(new mjr(this), 1000L);
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      paramView.startAnimation(localScaleAnimation);
      localScaleAnimation.setAnimationListener(new mjp(this, paramView, paramContext));
      A();
    }
  }
  
  private void a(View paramView1, View paramView2, View paramView3, View paramView4, int paramInt)
  {
    if ((paramView1 == null) || (paramView2 == null) || (paramView3 == null) || (paramView4 == null)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView4 = new ScaleAnimation(1.0F, 0.42F, 1.0F, 0.42F, 1, 0.92F, 1, 0.92F);
      paramView4.setDuration(333L);
      paramView4.setFillEnabled(true);
      paramView4.setFillAfter(true);
      paramView1.startAnimation(paramView4);
      paramView1 = new ScaleAnimation(0.2F, 1.1F, 0.2F, 1.1F, 1, 0.5F, 1, 0.5F);
      paramView1.setDuration(233L);
      paramView1.setStartTime(133L);
      paramView1.setAnimationListener(new mio(this, paramView2, paramView3));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(paramView1);
      return;
    }
    paramView1 = new ScaleAnimation(0.1F, 1.05F, 0.1F, 1.05F, 1, 0.5F, 1, 0.5F);
    paramView1.setDuration(170L);
    paramView1.setAnimationListener(new miq(this, paramView3));
    paramView3.startAnimation(paramView1);
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < 1)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = paramString;
      this.jdField_a_of_type_ArrayOfInt[i] = 2131362407;
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ReadInJoyUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt == 5) {
        a(true, false);
      }
      if (ReadInJoyHelper.h()) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).e();
      }
    }
    if (ReadInJoyHelper.f())
    {
      if (paramBoolean) {
        ThreadManager.executeOnSubThread(new mix(this));
      }
    }
    else {
      return;
    }
    ReadInJoyGlobalReporter.a().a();
    ThreadManager.executeOnSubThread(new miy(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONObject localJSONObject = ReadInJoyUtils.a();
    if (paramBoolean1) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
        long l2;
        if (localObject == null)
        {
          i = 1;
          String str2 = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str3 = ReadInJoyUtils.a.jdField_a_of_type_JavaLangString;
          String str4 = ReadInJoyUtils.a.c;
          l2 = 0L;
          if (i == 1)
          {
            l1 = 0L;
            localJSONObject.put("costtime_type", l2);
            localJSONObject.put("tab_status", i);
            localJSONObject.put("strategy_id", str2);
            localJSONObject.put("costtime", l1);
            localJSONObject.put("algorithm_id", str3);
            if (i != 3) {
              break label574;
            }
            localJSONObject.put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get());
            break label574;
            localJSONObject.put("current_page", i);
            if (!NetworkUtil.h(a())) {
              break label596;
            }
            i = 2;
            localJSONObject.put("network_type", i);
            localJSONObject.put("kandian_mode_new", VideoReporter.a());
            if (ReadInJoyUtils.f != 0) {
              break label601;
            }
            i = 0;
            localJSONObject.put("button_state", i);
            PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str4, str2, localJSONObject.toString(), false);
            if (localObject == null) {
              break label583;
            }
            ReadInJoyUtils.a(21, str4, str2, str3, "", -1);
            break label583;
            if (!ReadInJoyHelper.h()) {
              break label566;
            }
            localObject = "recommend_tab_cost";
            PublicTracker.a(null, (String)localObject);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() != 5) {
            break label586;
          }
          i = 3;
          continue;
        }
        if (ReadInJoyUtils.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - ReadInJoyUtils.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - ReadInJoyUtils.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          localJSONObject.put("reddot", i);
          localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
          if ((((ReadInJoySkinManager)localObject).a() != 1) || (TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a()))) {
            break label525;
          }
          localObject = ((ReadInJoySkinManager)localObject).a();
          localJSONObject.put("skin_id", localObject);
          localJSONObject.put("button_state", 0);
        }
        switch (0)
        {
        default: 
          if (paramBoolean2) {
            break label532;
          }
          PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject, null, null, localJSONObject.toString(), false);
          continue;
          i = 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label525:
      String str1 = "0";
      continue;
      label532:
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, localJSONObject.toString(), false);
      continue;
      label566:
      str1 = "video_tab_cost";
      continue;
      label574:
      if (!paramBoolean2)
      {
        i = 0;
        continue;
        label583:
        continue;
        label586:
        i = 2;
      }
      else
      {
        i = 1;
        continue;
        label596:
        i = 1;
        continue;
        label601:
        i = 1;
        continue;
        str1 = "";
        continue;
        str1 = "1";
        continue;
        str1 = "2";
        continue;
        str1 = "3";
      }
    }
  }
  
  private void o()
  {
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131367187));
    this.jdField_b_of_type_AndroidViewView = a(2131362577);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131363813));
    u();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidViewView = a(2131363361);
    this.jdField_d_of_type_AndroidViewView = a(2131363802);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367186));
    s();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131367185)).a(53).c(3).d(3).a();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new mjd(this));
    IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidViewView);
    IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
    z_();
    b();
    q();
    p();
  }
  
  private void p()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ReadInJoyFragmentFactory.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = ReadInJoyNaviController.a();
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      localReadInJoyBaseFragment.jdField_a_of_type_Boolean = true;
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      localFragmentTransaction.setCustomAnimations(2131034165, 2131034167);
      localFragmentTransaction.add(2131367187, localReadInJoyBaseFragment);
      localFragmentTransaction.show(localReadInJoyBaseFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      a(localReadInJoyBaseFragment);
    }
    d();
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview = new ReadInJoyNavigationGridview(a(), new mjl(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController = new ReadInJoyNaviController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.jdField_a_of_type_Int = (AIOUtils.a(50.0F, a()) + ImmersiveUtils.a(a()));
    r();
  }
  
  private void r()
  {
    if (ReadInJoyHelper.h()) {}
    while (!ReadInJoyHelper.g()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new mjm(this));
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(4);
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new mjn(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
        return;
      }
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
    }
  }
  
  private void s()
  {
    Object localObject1 = a();
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
    this.jdField_e_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout((Context)localObject1);
    this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout((Context)localObject1);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setId(2131362327);
    Object localObject2 = new FrameLayout.LayoutParams(-2, -2, 85);
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = ViewUtils.a(7.0F);
    ((FrameLayout.LayoutParams)localObject2).rightMargin = ViewUtils.a(-1.0F);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(-2, -2, 17);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout.LayoutParams(ViewUtils.a(55.0F), ViewUtils.a(55.0F), 17);
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840679);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840680);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new mjo(this, (Context)localObject1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout);
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView((Context)localObject1);
    localObject2 = new FrameLayout.LayoutParams(ViewUtils.a(100.0F), ViewUtils.a(100.0F));
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = ViewUtils.a(17.0F);
    ((FrameLayout.LayoutParams)localObject2).rightMargin = ViewUtils.a(17.0F);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
    BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)localObject2).a(3);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(localBaseSkinRes.a());
    this.g = new ImageView((Context)localObject1);
    localObject1 = new FrameLayout.LayoutParams(ViewUtils.a(100.0F), ViewUtils.a(100.0F));
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.a(17.0F);
    ((FrameLayout.LayoutParams)localObject1).rightMargin = ViewUtils.a(17.0F);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.g, 0, (ViewGroup.LayoutParams)localObject1);
    localObject1 = ((ReadInJoySkinManager)localObject2).a(2);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(((BaseSkinRes)localObject1).a());
  }
  
  private void t()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131366777)).inflate();
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_f_of_type_AndroidViewView == null)
      {
        Object localObject = a();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2130969633, null);
          }
        }
      }
      if (this.jdField_f_of_type_AndroidViewView != null)
      {
        if ((this.jdField_f_of_type_AndroidViewView.getParent() == null) && (this.jdField_b_of_type_AndroidWidgetFrameLayout != null)) {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_f_of_type_AndroidViewView);
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_f_of_type_AndroidViewView == null);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void u()
  {
    int i = 0;
    if (i < 1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = "看点";
        this.jdField_a_of_type_ArrayOfInt[i] = 2131362407;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = "关注";
        this.jdField_a_of_type_ArrayOfInt[i] = 2131362408;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = "视频";
        this.jdField_a_of_type_ArrayOfInt[i] = 2131362406;
      }
    }
  }
  
  private void x()
  {
    long l = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
    if (l != 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder((QQAppInterface)ReadInJoyUtils.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a((QQAppInterface)ReadInJoyUtils.a());
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(new mje(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(l), 1));
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_c_of_type_AndroidWidgetImageView.getAlpha() > 0.0F) {
          a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetFrameLayout, 1);
        }
      }
      else {
        return;
      }
      a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetFrameLayout, 0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 1.0F);
    localScaleAnimation.setDuration(0L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
  }
  
  private void y()
  {
    long l = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
    if ((l != 0L) && (this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(l), 1));
      if ((this.jdField_b_of_type_Boolean) && ((this.jdField_c_of_type_AndroidWidgetImageView.getDrawable() instanceof BitmapDrawable))) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(((BitmapDrawable)this.jdField_c_of_type_AndroidWidgetImageView.getDrawable()).getBitmap());
      }
    }
  }
  
  private void z()
  {
    try
    {
      if (((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a() != 0L)
      {
        JSONObject localJSONObject = ReadInJoyUtils.a();
        localJSONObject.put("kandian_mode", 3);
        localJSONObject.put("tab_source", 3);
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C6", "0X80081C6", 0, 0, "", "", "", localJSONObject.toString(), false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.4tab", 2, "bbCircleRedDotExposureReport has finished, r5: " + localJSONObject.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void A_()
  {
    ChannelCoverInfo localChannelCoverInfo = ReadInJoyNaviController.a();
    a("看点");
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo == null) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId != localChannelCoverInfo.mChannelCoverId))) {
      a(localChannelCoverInfo, 3);
    }
  }
  
  public void B_()
  {
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260);
    BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)localObject).a(3);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(localBaseSkinRes.a());
    localObject = ((ReadInJoySkinManager)localObject).a(2);
    this.g.setImageDrawable(((BaseSkinRes)localObject).a());
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return 0;
    }
    if (paramInt1 != paramInt2)
    {
      a(false, false);
      return 0;
    }
    a(false, true);
    return 0;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969622, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_AndroidViewView);
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  }
  
  public ReadInJoyBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  }
  
  public ReadInJoyBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null)
    {
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.a(1);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = localReadInJoyVideoChannelFragment;
    }
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  protected String a()
  {
    return "看点";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
    }
    try
    {
      r();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a();
      }
      if (ReadInJoyHelper.f()) {
        A_();
      }
      if (a() != null) {
        a().f();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "initChannelEntry failed.");
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (a() != null) {
      a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (!this.v) {}
    ReadInJoyBaseResManager localReadInJoyBaseResManager;
    String str;
    do
    {
      do
      {
        return;
        localReadInJoyBaseResManager = (ReadInJoyBaseResManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(paramInt);
      } while (!localReadInJoyBaseResManager.b(paramString, paramBaseResData));
      str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (!localReadInJoyBaseResManager.c(paramString, paramBaseResData)) {
        break;
      }
      if (260 == paramInt)
      {
        if (SharedPreUtils.h(a(), paramBaseResData.id) != paramBaseResData.seq)
        {
          FileUtils.a(str);
          localReadInJoyBaseResManager.a(paramString, paramBaseResData);
          return;
        }
        SharedPreUtils.w(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
        SharedPreUtils.H(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      localReadInJoyBaseResManager.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_AndroidOsHandler.post(new mjg(this, paramString, str, paramInt));
    return;
    localReadInJoyBaseResManager.a(paramString, paramBaseResData);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.a(paramView);
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = paramReadInJoyBaseFragment;
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo != null) {}
    for (;;)
    {
      ChannelCoverInfo localChannelCoverInfo;
      Object localObject;
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId == paramChannelCoverInfo.mChannelCoverId) && (a() != null))
        {
          a().e();
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = paramChannelCoverInfo;
        localChannelCoverInfo = ReadInJoyNaviController.a();
        if (paramChannelCoverInfo.mChannelCoverId != 0) {
          break label257;
        }
        localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
        if (paramChannelCoverInfo.mChannelCoverId == localChannelCoverInfo.mChannelCoverId)
        {
          a("看点");
          paramChannelCoverInfo = (ChannelCoverInfo)localObject;
          if ((paramChannelCoverInfo == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager == null)) {
            continue;
          }
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
        }
        switch (paramInt)
        {
        case 0: 
          if ((a() == null) || (a() == paramChannelCoverInfo)) {
            continue;
          }
          ((FragmentTransaction)localObject).hide(a());
          if (!(a() instanceof ReadInJoySubChannelFragment)) {
            break label374;
          }
          ((FragmentTransaction)localObject).remove(a());
          ((ReadInJoySubChannelFragment)a()).jdField_a_of_type_Boolean = false;
          if ((!(paramChannelCoverInfo instanceof ReadInJoySubChannelFragment)) || (((ReadInJoySubChannelFragment)paramChannelCoverInfo).jdField_a_of_type_Boolean)) {
            break label404;
          }
          ((FragmentTransaction)localObject).add(2131367187, paramChannelCoverInfo);
          ((ReadInJoySubChannelFragment)paramChannelCoverInfo).jdField_a_of_type_Boolean = true;
          ((FragmentTransaction)localObject).show(paramChannelCoverInfo);
          ((FragmentTransaction)localObject).commitAllowingStateLoss();
          a(paramChannelCoverInfo);
          continue;
          a(paramChannelCoverInfo.mChannelCoverName);
        }
      }
      finally {}
      paramChannelCoverInfo = (ChannelCoverInfo)localObject;
      continue;
      label257:
      label404:
      if (paramChannelCoverInfo.mChannelCoverId != localChannelCoverInfo.mChannelCoverId)
      {
        localObject = ReadInJoySubChannelFragment.a(paramChannelCoverInfo.mChannelCoverId, paramChannelCoverInfo.mChannelType, paramChannelCoverInfo.mChannelCoverName);
        a(paramChannelCoverInfo.mChannelCoverName);
        paramChannelCoverInfo = (ChannelCoverInfo)localObject;
      }
      else
      {
        paramChannelCoverInfo = a(localChannelCoverInfo.mChannelCoverId);
        a("看点");
        continue;
        ((FragmentTransaction)localObject).setCustomAnimations(2131034392, 2131034396);
        continue;
        ((FragmentTransaction)localObject).setCustomAnimations(2131034391, 2131034394);
        continue;
        ((FragmentTransaction)localObject).setCustomAnimations(2131034393, 2131034395);
        continue;
        ((FragmentTransaction)localObject).setCustomAnimations(2131034165, 2131034167);
        continue;
        label374:
        if (((a() instanceof ReadInJoyRecommendFeedsFragment)) || ((a() instanceof ReadInJoyVideoChannelFragment)))
        {
          a().d();
          continue;
          if (((paramChannelCoverInfo instanceof ReadInJoyRecommendFeedsFragment)) || ((paramChannelCoverInfo instanceof ReadInJoyVideoChannelFragment)))
          {
            paramChannelCoverInfo.a(false, a(), null);
            if (!paramChannelCoverInfo.jdField_a_of_type_Boolean)
            {
              ((FragmentTransaction)localObject).add(2131367187, paramChannelCoverInfo);
              paramChannelCoverInfo.jdField_a_of_type_Boolean = true;
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    b();
    if (paramInt == KandianOx210MsgInfo.k) {
      if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
      {
        l = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
        if (l != 0L)
        {
          this.jdField_b_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.4tab", 2, "get0x210MsgNotificaiotn and BBUin: " + String.valueOf(l));
          }
          ThreadManager.getUIHandler().post(new mjb(this));
          if (this.jdField_a_of_type_Boolean) {
            z();
          }
        }
      }
    }
    while ((paramInt != KandianOx210MsgInfo.j) || (((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).b() <= 0))
    {
      long l;
      return;
    }
    ReadInJoyWebDataManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (a() != null) {
      a().onResume();
    }
    ApngImage.playByTag(8);
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new miv(this));
    }
    z();
    if (ReadInJoyHelper.f()) {
      ThreadManager.post(new miw(this), 5, null, true);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
      return true;
    }
    Object localObject = a();
    if ((localObject instanceof ReadInJoyVideoChannelFragment))
    {
      localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
      if ((localObject != null) && (((VideoPlayManager)localObject).a() != null) && (((VideoPlayManager)localObject).a().a()))
      {
        ((VideoPlayManager)localObject).a().d();
        return true;
      }
    }
    return super.a();
  }
  
  public void b()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    SparseIntArray localSparseIntArray = localKandianMergeManager.a();
    int j = 0;
    if (j < localSparseIntArray.size())
    {
      int k = localSparseIntArray.keyAt(j);
      int m = localSparseIntArray.valueAt(j);
      int i;
      switch (k)
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localMessage.arg1 = m;
        localMessage.arg2 = i;
        localMessage.obj = Integer.valueOf(k);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        j += 1;
        break;
        i = 2131362407;
        continue;
        i = 2131362406;
        continue;
        i = 2131362408;
      }
    }
    if ((localKandianMergeManager.c() == null) || (localKandianMergeManager.a() == 0L)) {
      ThreadManager.getUIHandler().post(new mjc(this));
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void b(boolean paramBoolean)
  {
    int j = a().getIntent().getIntExtra("readinjoy_tab_open_from", 5);
    a(paramBoolean, j);
    long l1 = NetConnInfoCenter.getServerTime() - ReadInJoyUtils.a.jdField_a_of_type_Long;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    if ((paramBoolean) && (localKandianMergeManager.a())) {
      A_();
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    long l2;
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean) {
        localReadInJoyBaseFragment.a(false, a(), null);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
      }
      if (!paramBoolean) {
        break label411;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_e_of_type_Long = 0L;
      ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyWebRenderEngine.a();
      l2 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l2 >= 900000L) {
        ReadInJoyUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (!ReadInJoyHelper.g()) {
        break label404;
      }
      ReadInJoyUtils.c(6);
      VideoVolumeControl.a().a(a());
      label188:
      if ((l2 >= 900000L) && (this.jdField_a_of_type_Long != 0L) && (a() != null) && ((a() instanceof ReadInJoySubChannelFragment)))
      {
        this.jdField_d_of_type_Boolean = true;
        A_();
        QLog.d("Q.readinjoy.4tab", 2, "auto focus on recommend channel, exitTime : " + l2);
      }
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().post(new miz(this));
      if (AppInPushNotification.a() != 8) {
        AppInPushNotification.a(5);
      }
      KandianAppInPush.a().a(false);
      if ((localKandianMergeManager.b() > 0) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
      {
        ReadInJoyWebDataManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
        this.jdField_f_of_type_Long = System.currentTimeMillis();
      }
      ReadinjoyReportUtils.a(2, true, l1, ReadInJoyUtils.a.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + j);
      return;
      localReadInJoyBaseFragment.d();
      break;
      label404:
      ReadInJoyUtils.c(3);
      break label188;
      label411:
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_e_of_type_Long != 0L) {}
      for (this.jdField_e_of_type_Long += this.jdField_a_of_type_Long - this.jdField_c_of_type_Long;; this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long))
      {
        int i = 0;
        while (i < 1)
        {
          localReadInJoyBaseFragment = a();
          if (localReadInJoyBaseFragment != null) {
            localReadInJoyBaseFragment.g();
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_Boolean = false;
      localKandianMergeManager.o();
      l2 = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
      if (l2 > 0L) {
        ThreadManager.executeOnSubThread(new mja(this, l2));
      }
      ReadInJoyWebDataManager.a();
      ReadInJoyWebDataManager.a().b();
      VideoVolumeControl.a().b(a());
      VideoVolumeControl.a().a(false, "readInjoy doOnPause");
      ReadinjoyReportUtils.a(2, false, l1, ReadInJoyUtils.a.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      a().getIntent().removeExtra("readinjoy_tab_open_from");
    }
  }
  
  protected void c()
  {
    super.c();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    localKandianMergeManager.a(this);
    localKandianMergeManager.a(this);
    ThreadManager.getUIHandler().post(new min(this));
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void g()
  {
    super.g();
    ReadInJoyLogicEngineEventDispatcher.a().a();
    if ((BaseActivity.sTopActivity instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)BaseActivity.sTopActivity).getSupportFragmentManager();
    }
    o();
    B();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    localKandianMergeManager.a(this);
    localKandianMergeManager.a(this);
    ((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
  }
  
  protected void h()
  {
    super.h();
    if (a() != null) {
      a().onStart();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_c_of_type_Long - this.jdField_d_of_type_Long > 900000L) {
      A_();
    }
  }
  
  public void i()
  {
    super.i();
    if (a() != null) {
      a().onPause();
    }
    ApngImage.pauseByTag(8);
    ReadInJoyLogicEngine.m();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      FileUtils.a(CommonSkinRes.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  public void j()
  {
    super.j();
    if (a() != null) {
      a().onStop();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (long l1 = this.jdField_c_of_type_Long;; l1 = this.jdField_b_of_type_Long)
    {
      this.jdField_e_of_type_Long = (l3 - l1 + l2);
      VideoVolumeControl.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  protected void k()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    super.k();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    ((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onDestroy();
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onDestroy();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.b();
    }
  }
  
  public void l()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.e();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
    }
    if (((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a()) {
      A_();
    }
    if (ReadInJoyHelper.g()) {
      PublicAccountReportUtils.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", VideoReporter.a(null), false);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)a().findViewById(2131364912)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = null;
    }
  }
  
  public void z_()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_c_of_type_AndroidViewView, true);
      a(this.jdField_d_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131493393, 2131493395, 2131493394);
      if (!ThemeUtil.isDefaultTheme()) {
        break label109;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840788);
    }
    for (;;)
    {
      t();
      return;
      a(this.jdField_c_of_type_AndroidViewView, false);
      a(this.jdField_d_of_type_AndroidViewView, false);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845743);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131494205, 2131494205, 2131494205);
      break;
      label109:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */