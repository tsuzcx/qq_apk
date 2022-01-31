package com.tencent.biz.pubaccount.readinjoy.view;

import actj;
import ajwc;
import ajwk;
import ajya;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import axlk;
import axmv;
import axrn;
import baxn;
import bbbm;
import bbdh;
import bbdj;
import bbdx;
import bbfj;
import bbgu;
import bbkb;
import bfnz;
import bfut;
import bfuw;
import bhvy;
import bhwh;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MainService;
import mqq.os.MqqHandler;
import nol;
import npu;
import nsp;
import nsy;
import nth;
import nuq;
import nzg;
import nzk;
import nzn;
import oat;
import oeg;
import ofw;
import omr;
import onh;
import ono;
import org.json.JSONObject;
import ory;
import orz;
import osg;
import osj;
import osl;
import osm;
import osq;
import osx;
import otl;
import otu;
import ozy;
import par;
import pbg;
import pcw;
import pyn;
import pyu;
import pyw;
import pyz;
import pze;
import pzf;
import qbi;
import qjl;
import qkb;
import qmz;
import qoi;
import qtr;
import qva;
import qvk;
import qwq;
import qza;
import qzb;
import qzo;
import rce;
import rgm;
import rgs;
import rgt;
import rgu;
import rgx;
import rgy;
import rgz;
import rha;
import rhb;
import rhc;
import rhd;
import rhe;
import rhf;
import rhg;
import rhh;
import rhi;
import rhj;
import rhk;
import rhl;
import rhr;
import rif;
import rig;
import rou;
import rpi;
import ruf;
import rux;
import sea;
import sgu;
import shu;
import yyt;
import yyu;

public class ReadinjoyTabFrame
  extends ajwk
  implements ViewTreeObserver.OnGlobalLayoutListener, ory, orz, otu, pbg, rgm, rhr
{
  public static int a;
  public static boolean a;
  private static boolean jdField_c_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new rgu(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private DuplicateEventLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  private ReadInJoySkinGuideView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView;
  private ReadinjoySlidingIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator;
  private ReadinjoyTabFrame.InitWebProcessRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private nsp jdField_a_of_type_Nsp;
  private nth jdField_a_of_type_Nth;
  private osm jdField_a_of_type_Osm = new rgx(this);
  private pze jdField_a_of_type_Pze = new rhc(this);
  private qmz jdField_a_of_type_Qmz;
  private qwq jdField_a_of_type_Qwq;
  protected rou a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ReadinjoyTabFrame.1(this);
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private final int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private long jdField_g_of_type_Long;
  private View jdField_g_of_type_AndroidViewView;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.16(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  private void C()
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajya.a(2131693701);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374826;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajya.a(2131712992);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374834;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajya.a(2131712920);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374847;
      }
    }
  }
  
  private void D()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297171);
    }
  }
  
  private void E()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void F()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bfuw();
    ((bfuw)localObject).jdField_a_of_type_Int = 0;
    ((bfuw)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131712906);
    ((bfuw)localObject).jdField_b_of_type_Int = 2130842020;
    localArrayList.add(localObject);
    localObject = new bfuw();
    ((bfuw)localObject).jdField_a_of_type_Int = 1;
    ((bfuw)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131713099);
    ((bfuw)localObject).jdField_b_of_type_Int = 2130842020;
    localArrayList.add(localObject);
    localObject = new bfuw();
    ((bfuw)localObject).jdField_a_of_type_Int = 2;
    ((bfuw)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131713037);
    ((bfuw)localObject).jdField_a_of_type_Float = 14.0F;
    ((bfuw)localObject).jdField_b_of_type_Int = 2130842020;
    localArrayList.add(localObject);
    localObject = new bfuw();
    ((bfuw)localObject).jdField_a_of_type_Int = 3;
    ((bfuw)localObject).jdField_a_of_type_JavaLangString = ajya.a(2131712962);
    ((bfuw)localObject).jdField_b_of_type_Int = 2130842020;
    localArrayList.add(localObject);
    bfuw localbfuw = new bfuw();
    localbfuw.jdField_a_of_type_Int = 4;
    if (!onh.l())
    {
      localObject = "打开预加载UI";
      localbfuw.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuw.jdField_b_of_type_Int = 2130842020;
      localArrayList.add(localbfuw);
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 5;
      if (((Boolean)bhvy.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label360;
      }
      localObject = "打开动态频道feeds";
      label249:
      localbfuw.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuw.jdField_a_of_type_Float = 12.0F;
      localbfuw.jdField_b_of_type_Int = 2130842020;
      localArrayList.add(localbfuw);
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 6;
      if (bhvy.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label367;
      }
    }
    label360:
    label367:
    for (localObject = ajya.a(2131712861);; localObject = "切换到Web")
    {
      localbfuw.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuw.jdField_a_of_type_Float = 12.0F;
      localbfuw.jdField_b_of_type_Int = 2130842020;
      localArrayList.add(localbfuw);
      bfut.a(a(), localArrayList, new rhe(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      localObject = "取消动态频道feeds";
      break label249;
    }
  }
  
  private void G()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      boolean bool = ((Boolean)bhvy.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
      if (!bool) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("should video entrance when change account: ");
        if (!bool) {
          break label115;
        }
      }
    }
    label95:
    label115:
    for (String str = "true";; str = "false")
    {
      QLog.d("ReadInJoyTabFrame", 2, str);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
      break;
    }
  }
  
  private void H()
  {
    boolean bool = true;
    if ((NetConnInfoCenter.getServerTime() - bbkb.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > nzk.jdField_a_of_type_Long) || (oat.a().d()) || (MainService.isDebugVersion)) {
      ThreadManagerV2.excute(new ReadinjoyTabFrame.33(this), 128, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("previewMode: ").append(oat.a().d()).append(" Aladdin: ").append(oat.c()).append("   interval:");
    if (NetConnInfoCenter.getServerTime() - bbkb.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > nzk.jdField_a_of_type_Long) {}
    for (;;)
    {
      QLog.i("ReadInJoyTabFrame", 2, bool);
      return;
      bool = false;
    }
  }
  
  private VideoInfo a()
  {
    boolean bool1 = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(bbdh.i() * 0.4D);
    int j = (int)(bbdh.j() * 0.4D);
    Object localObject1 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject1);
    int k = localObject1[0];
    int m = this.jdField_a_of_type_AndroidViewView.getWidth();
    int n = localObject1[1];
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    localBundle.putInt("item_x", k + m - i);
    localBundle.putInt("item_y", n + i1 - j);
    localBundle.putInt("item_width", i);
    localBundle.putInt("item_height", j);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      localBundle.putInt("item_image_width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      localBundle.putInt("item_image_height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.b());
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    Object localObject2 = null;
    localObject1 = localObject2;
    boolean bool2;
    if ((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Qmz != null)
      {
        bool2 = this.jdField_a_of_type_Qmz.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bhvy.e() != 1) {
          break label297;
        }
        localObject2 = qjl.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    nuq.a(a(), 56, a().getString(2131719552), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      qoi.a((Activity)localObject2, localBundle, bool1, 11);
      d(3);
      return localObject1;
      bool1 = false;
    }
  }
  
  private void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    Object localObject = a();
    switch (paramInt)
    {
    default: 
      QLog.e("ReadInJoyTabFrame", 2, "showLocationChangedDialog invalid type = " + paramInt);
      return;
    case 1: 
      localObject = bbdj.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bbgu)localObject).setPositiveButton("确认", new rgy(this, paramPositionData));
      ((bbgu)localObject).setNegativeButton("取消", new rgz(this));
      ((bbgu)localObject).setCanceledOnTouchOutside(true);
      ((bbgu)localObject).show();
      return;
    }
    paramPositionData = rce.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new rha(this));
    paramPositionData.setNegativeButton("取消", new rhb(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bfuw> paramList)
  {
    bfuw localbfuw;
    if ((paramInt & 0x1) != 0)
    {
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 0;
      localbfuw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718429);
      localbfuw.jdField_b_of_type_Int = 2130842287;
      paramList.add(localbfuw);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 1;
      localbfuw.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718433);
      localbfuw.jdField_b_of_type_Int = 2130842291;
      paramList.add(localbfuw);
    }
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (paramActivity == null)
    {
      QLog.e("ReadInJoyTabFrame", 1, "openMsgBoxPage failed, activity = null");
      return;
    }
    onh.jdField_d_of_type_Boolean = true;
    paramActivity.getWindow().getDecorView().postDelayed(new ReadinjoyTabFrame.12(this, paramActivity, paramInt, paramString), paramLong);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.22(this, paramVideoInfo, (pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      onh.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt == 5)
      {
        a(true, false);
        localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bhvy.k()) {
          ((KandianMergeManager)localObject).g();
        }
        shu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        osx.a().a.a(true);
        localObject = onh.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label227;
        }
        paramInt = pyn.jdField_d_of_type_Int;
        label104:
        pyn.a().a(paramInt, 1);
      }
    }
    for (;;)
    {
      if (bhvy.i())
      {
        if (!paramBoolean) {
          break label256;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = onh.e();
        int i = onh.jdField_d_of_type_Int;
        rpi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramInt, i);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13(this, l, paramInt, i));
      }
      return;
      if (paramInt == 6)
      {
        onh.f();
        break;
      }
      if (paramInt != 13) {
        break;
      }
      localObject = a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        onh.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      onh.a(-1);
      break;
      label227:
      if (paramInt == 13)
      {
        paramInt = pyn.f;
        break label104;
      }
      paramInt = pyn.e;
      break label104;
      pyn.a().c();
    }
    label256:
    rpi.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = onh.a();
    if (paramBoolean1) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
        Object localObject3;
        long l2;
        if (localObject1 == null)
        {
          i = 1;
          localObject3 = onh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = onh.a.jdField_a_of_type_JavaLangString;
          String str3 = onh.g(onh.a.c);
          l2 = 0L;
          if (i == 1)
          {
            l1 = 0L;
            ((JSONObject)localObject2).put("costtime_type", l2);
            ((JSONObject)localObject2).put("tab_status", i);
            ((JSONObject)localObject2).put("strategy_id", localObject3);
            ((JSONObject)localObject2).put("costtime", l1);
            ((JSONObject)localObject2).put("algorithm_id", str2);
            if (i != 3) {
              break label939;
            }
            ((JSONObject)localObject2).put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
            break label939;
            ((JSONObject)localObject2).put("current_page", j);
            if (!bbfj.h(a())) {
              break label960;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", npu.a());
            if (onh.g != 0) {
              break label966;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", npu.jdField_a_of_type_JavaLangString);
            if (nth.a != null) {
              ((JSONObject)localObject2).put("channel_id", nth.a.mChannelCoverId);
            }
            onh.a(true, (JSONObject)localObject2);
            nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              onh.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              shu.a(false);
              localObject1 = (pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((pzf)localObject1).a() != 1) || (TextUtils.isEmpty(((pzf)localObject1).a()))) {
                break label972;
              }
              localObject1 = ((pzf)localObject1).a();
              localObject2 = (pyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = pyz.b(a(), 0);
              localObject3 = new ono();
              localObject1 = ((ono)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label980;
              }
              paramBoolean1 = true;
              localObject1 = ((ono)localObject1).a(paramBoolean1);
              if (onh.g != 0) {
                break label985;
              }
              paramBoolean1 = true;
              ((ono)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label990;
                }
                i = 1;
                ((ono)localObject3).a("ad_page", i);
              }
              nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((ono)localObject3).a(), false);
            }
            if (bbfj.h(a())) {
              H();
            }
            if (!bhvy.k()) {
              break label931;
            }
            localObject1 = "recommend_tab_cost";
            sgu.a(null, (String)localObject1);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5) {
            break label949;
          }
          i = 3;
          continue;
        }
        if (onh.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - onh.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - onh.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", onh.e());
          ((JSONObject)localObject2).put("kandian_mode_new", npu.a());
          localObject1 = (pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((pzf)localObject1).a() != 1) || (TextUtils.isEmpty(((pzf)localObject1).a()))) {
            break label886;
          }
          localObject1 = ((pzf)localObject1).a();
          localObject3 = (pyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = pyz.b(a(), 0);
          ((JSONObject)localObject2).put("skin_id", localObject1);
          localObject1 = a();
          if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
          {
            if ((localObject3 == null) || (!((RefreshData)localObject3).isAD)) {
              break label1003;
            }
            i = 1;
            ((JSONObject)localObject2).put("ad_page", i);
          }
          ((JSONObject)localObject2).put("button_state", 0);
        }
        switch (0)
        {
        default: 
          if (paramBoolean2) {
            break label894;
          }
          nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      label886:
      String str1 = "0";
      continue;
      label894:
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
      continue;
      label931:
      str1 = "video_tab_cost";
      continue;
      label939:
      if (!paramBoolean2)
      {
        j = 0;
        continue;
        label949:
        i = 2;
      }
      else
      {
        j = 1;
        continue;
        label960:
        j = 1;
        continue;
        label966:
        j = 1;
        continue;
        label972:
        str1 = "0";
        continue;
        label980:
        paramBoolean1 = false;
        continue;
        label985:
        paramBoolean1 = false;
        continue;
        label990:
        i = 0;
        continue;
        str1 = "";
        continue;
        label1003:
        i = 0;
        continue;
        str1 = "1";
        continue;
        str1 = "2";
        continue;
        str1 = "3";
      }
    }
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    oeg.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772217, 2130772038);
  }
  
  private void c(int paramInt)
  {
    QLog.d("ReadInJoyTabFrame", 2, "checkIfShowMsgBoxWithFloatingWindow | launchFrom : " + paramInt);
    if (paramInt != 5) {
      return;
    }
    Object localObject = ((KandianMergeManager)onh.a().getManager(162)).a();
    if ((localObject == null) || (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt <= 0))
    {
      QLog.d("ReadInJoyTabFrame", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
      return;
    }
    boolean bool = ((Boolean)bhvy.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
    QLog.d("ReadInJoyTabFrame", 1, "checkIfShowMsgBoxWithFloatingWindow | sp showFloatingWin " + bool);
    localObject = Aladdin.getConfig(262);
    if (localObject != null) {
      if (((AladdinConfig)localObject).getIntegerFromString("kandian_msg_box_popup_window_cfg", 0) != 1) {
        break label223;
      }
    }
    label223:
    for (bool = true;; bool = false)
    {
      bhvy.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
      QLog.d("ReadInJoyTabFrame", 1, "checkIfShowMsgBoxWithFloatingWindow | aladdin cfg showFloatingWin " + bool);
      QLog.d("ReadInJoyTabFrame", 1, "checkIfShowMsgBoxWithFloatingWindow | showFloatingWindow " + bool);
      if (!bool) {
        break;
      }
      a(a(), 6, "", 0L);
      return;
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool3 = onh.w();
    Object localObject = a();
    if ((localObject instanceof ReadInJoyRecommendFeedsFragment))
    {
      localObject = ((ReadInJoyRecommendFeedsFragment)localObject).a();
      if (localObject != null)
      {
        localObject = ((nsy)localObject).a();
        if (!(localObject instanceof ReadInJoyListViewGroup)) {}
      }
    }
    for (boolean bool1 = ((ReadInJoyListViewGroup)localObject).f();; bool1 = false)
    {
      QLog.i("ReadInJoyTabFrame", 1, "isOpenFloatWindow, isOpenMsgBoxFloatWindow=" + bool3 + ",isOpenReadInJoyDailyFloatWindow=" + bool1);
      if ((bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public static boolean c_()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Qmz != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Qmz.a(paramInt);
    }
  }
  
  private void n()
  {
    a(2131377581).setBackgroundDrawable(null);
    this.jdField_a_of_type_Rou = new rou(a(), (ViewGroup)a(2131377581));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131374765));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131374782));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131374763));
    this.jdField_b_of_type_AndroidViewView = a(2131377369);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131376283));
    C();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131377439));
    this.jdField_d_of_type_AndroidViewView = a(2131376469);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131374838));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131374837));
    label270:
    label278:
    Object localObject;
    if (onh.p())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167134));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167087));
      }
      if (bhvy.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label530;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (onh.j() != 0) {
        break label542;
      }
      i = 1;
      localObject = a(2131370507);
      if (i == 0) {
        break label547;
      }
    }
    label530:
    label542:
    label547:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131374815);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370461));
      i = actj.a(3.0F, a());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new rgt(this));
      u();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131370960)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new rhd(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new rhh(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      J_();
      b();
      r();
      q();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131364641);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new rhi(this));
      }
      c();
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label270;
      i = 0;
      break label278;
    }
  }
  
  private void o()
  {
    SelectPositionModule localSelectPositionModule = osg.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void q()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Rou);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Nth = new nth(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Nth.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Nsp = new nsp(this.jdField_a_of_type_Nth, a(2131374790));
    this.jdField_a_of_type_Nth.a(this.jdField_a_of_type_Nsp);
    this.jdField_a_of_type_Nth.a(new rhj(this));
  }
  
  private void r()
  {
    s();
  }
  
  private void s()
  {
    if (bhvy.k()) {}
    while (!bhvy.j()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rhk(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rhl(this));
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
  
  private void t()
  {
    rux localrux;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localrux = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localrux instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localrux).a != null))
      {
        localObject1 = (VideoInfo.EntranceDownloadInfo)localrux;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        qoi.a(a(), ((VideoInfo.EntranceDownloadInfo)localObject1).a);
        if (this.jdField_a_of_type_Qmz != null)
        {
          localObject2 = this.jdField_a_of_type_Qmz;
          qmz.b((rux)localObject1);
          this.jdField_a_of_type_Qmz.a();
        }
      }
    }
    for (;;)
    {
      if (onh.r()) {
        a(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
      }
      return;
      if ((localrux instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
      {
        localObject2 = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrux).c;
        QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + (String)localObject2);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrux).jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          onh.a(a(), (String)localObject1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
        }
      }
      else
      {
        a(a());
        continue;
        int i = RecommendFeedsDiandianEntranceManager.a().a();
        if ((i == 2) || (i == 1)) {
          a(a());
        } else {
          onh.a(a(), RecommendFeedsDiandianEntranceManager.a(i));
        }
      }
    }
  }
  
  private void u()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131372620);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297171);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new rgs(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = ((Boolean)bhvy.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bhvy.e())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Qmz = new qmz(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848426));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848393));
    }
  }
  
  private void v()
  {
    int i = RecommendFeedsDiandianEntranceManager.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      Drawable localDrawable = a().getDrawable(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
  }
  
  private void w()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bbkb.e((Context)localObject1);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) {
          bool2 = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTabFrame", 2, "initBubblePopWindow mEntranceLayout:" + bool1 + "   btnVisible:" + bool2);
        }
        if ((bbkb.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bhvy.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bbkb.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = baxn.a((Context)localObject1, 12.0F);
          int j = baxn.a((Context)localObject1, 9.0F);
          qwq localqwq = new qwq((Context)localObject1);
          this.jdField_a_of_type_Qwq = localqwq;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localqwq.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131718648));
          localqwq.setAnimationStyle(2131755811);
          localqwq.b(-16777216);
          localqwq.setSoftInputMode(1);
          localqwq.setInputMethodMode(2);
          localqwq.a(localqwq.b() / 2 - baxn.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = axlk.jdField_a_of_type_Int;
          j = baxn.a((Context)localObject1, 15.0F);
          int k = localqwq.b();
          int m = localObject2[1];
          int n = localqwq.a();
          int i1 = localqwq.c();
          int i2 = baxn.a((Context)localObject1, 5.0F);
          localqwq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          nol.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new qzb(null, null, null, null).a().a(), false);
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Qwq != null) {
      this.jdField_a_of_type_Qwq.dismiss();
    }
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131374823)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559985, null);
          }
        }
      }
      if (this.jdField_f_of_type_AndroidViewView != null)
      {
        if ((this.jdField_f_of_type_AndroidViewView.getParent() == null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_f_of_type_AndroidViewView);
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
  
  public void J_()
  {
    Drawable localDrawable = a().getDrawable(2130842372);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842294);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842290);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166750, 2131166751, 2131166749);
      localDrawable.setColorFilter(a().getColor(2131165275), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
    }
    for (;;)
    {
      y();
      c(true);
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      osj.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849072);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839740);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849032);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166851, 2131166851, 2131166851);
      localDrawable.setColorFilter(a().getColor(2131166851), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void K_()
  {
    if (this.jdField_a_of_type_Nth != null)
    {
      if (ozy.a() != -1) {
        this.jdField_a_of_type_Nth.c(ozy.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Nth.c(0);
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
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559955, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout = new DuplicateEventLayout(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  }
  
  public ReadInJoyBaseFragment a()
  {
    if (this.jdField_a_of_type_Nth != null)
    {
      localObject = this.jdField_a_of_type_Nth.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      axrn.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.9(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public String a()
  {
    return ajya.a(2131693701);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (onh.j() == 0)
    {
      i = 1;
      localObject = a(2131370507);
      if (i == 0) {
        break label158;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pze);
      if (bhvy.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label164;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      G();
      osj.a().k();
      v();
      RecommendFeedsDiandianEntranceManager.a().b();
      if (this.jdField_a_of_type_Qmz != null) {
        this.jdField_a_of_type_Qmz.d();
      }
      nzn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      return;
      i = 0;
      break;
      label158:
      i = 8;
      break label50;
      label164:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      shu.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (a() != null) {
      a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (c()) {
      QLog.i("ReadInJoyTabFrame", 1, "showSkinGuide return, isOpenFloatWindow is true");
    }
    pyw localpyw;
    String str;
    do
    {
      do
      {
        return;
        localpyw = (pyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(paramInt);
      } while (!localpyw.a(paramString, paramBaseResData));
      str = localpyw.b(paramString, paramBaseResData.id);
      if (!localpyw.b(paramString, paramBaseResData)) {
        break;
      }
      if (261 == paramInt)
      {
        if (bbkb.g(a(), paramBaseResData.id) != paramBaseResData.seq)
        {
          bbdx.a(str);
          localpyw.c(paramString, paramBaseResData);
          return;
        }
        bbkb.s(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
        bbkb.C(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      localpyw.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_AndroidOsHandler.post(new ReadinjoyTabFrame.23(this, paramString, str, paramInt));
    return;
    localpyw.c(paramString, paramBaseResData);
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bhvy.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bfut.a(paramActivity, localArrayList, new rhf(this, paramActivity), new rhg(this), actj.a(125.0F, paramActivity.getResources()), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298619) - paramActivity.getResources().getDimensionPixelSize(2131298615) + actj.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131297957));
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = ajwc.a() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyTabFrame", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.a(paramView);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    b();
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((pyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
    osj.a().k();
  }
  
  public void a(rux paramrux)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrux);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrux != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrux);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      x();
    }
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      qtr localqtr = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localqtr != null) && (localqtr.a() != null) && (localqtr.a().a()))
      {
        localqtr.a().g();
        return true;
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
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
        i = 2131374826;
        continue;
        i = 2131374847;
        continue;
        i = 2131374834;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.19(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      onh.c(6);
      Object localObject = a().getIntent().getExtras();
      if (qzo.a((Bundle)localObject))
      {
        localObject = qzo.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((rux)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((rux)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.34(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void b(rux paramrux)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrux);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrux != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrux);
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      s();
      if (this.jdField_a_of_type_Nth != null) {
        this.jdField_a_of_type_Nth.e();
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
  
  public void c()
  {
    Object localObject = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a();
    if (localObject != null)
    {
      int i = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      localObject = i + "";
      if (i > 99) {
        localObject = "99+";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 9216;
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (paramBoolean))
    {
      if (ImmersiveUtils.a())
      {
        ImmersiveUtils.a(a().getWindow(), true);
        if ((bfnz.l()) && (bbbm.b())) {
          if (!paramBoolean) {
            break label72;
          }
        }
        for (;;)
        {
          a().getWindow().getDecorView().setSystemUiVisibility(i);
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
          return;
          label72:
          i = 1280;
        }
      }
      if ((bfnz.l()) && (!bbbm.b()) && (!bbbm.d()))
      {
        a().getWindow().getDecorView().setSystemUiVisibility(9216);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
      return;
    }
    if ((ImmersiveUtils.a()) && ((!bfnz.l()) || (!bbbm.b()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (a() != null) {
      a().a(this);
    }
    Object localObject = a().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.a((View)localObject);
    }
    jdField_a_of_type_Boolean = true;
    ApngImage.playByTag(8);
    String str;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.e();
      if (paramBoolean) {
        d(1);
      }
    }
    else
    {
      if (paramBoolean)
      {
        localObject = osg.a().a();
        if (localObject != null) {
          ((par)localObject).a(false);
        }
        onh.g();
      }
      this.jdField_a_of_type_Rou.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Nth != null) {
          this.jdField_a_of_type_Nth.c(i);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      onh.jdField_d_of_type_Boolean = false;
      if (((Intent)localObject).hasExtra("notification_message_id"))
      {
        str = ((Intent)localObject).getStringExtra("notification_message_id");
        if ((onh.k() == 2) && (onh.m() == 2))
        {
          if (str.isEmpty()) {
            break label347;
          }
          ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a(2, str);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).removeExtra("notification_message_id");
      if ((onh.m() == 1) || (onh.k() != 2)) {
        a(a(), 5, str, 200L);
      }
      if (this.jdField_a_of_type_Nth != null) {
        this.jdField_a_of_type_Nth.b();
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        o();
        this.jdField_d_of_type_Boolean = true;
      }
      if (jdField_c_of_type_Boolean) {
        onh.b(true);
      }
      return;
      if (this.jdField_a_of_type_Qmz == null) {
        break;
      }
      localObject = this.jdField_a_of_type_Qmz;
      qmz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      break;
      label347:
      QLog.i("ReadInJoyTabFrame", 1, "readInJoy lock push, notificationMessageId is empty");
    }
  }
  
  public void e(boolean paramBoolean)
  {
    int k;
    long l1;
    long l2;
    KandianMergeManager localKandianMergeManager;
    Object localObject1;
    if (paramBoolean)
    {
      sea.a();
      jdField_c_of_type_Boolean = paramBoolean;
      c(paramBoolean);
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      k = a().getIntent().getIntExtra("launch_from", 5);
      a(paramBoolean, k);
      l1 = NetConnInfoCenter.getServerTime();
      l2 = onh.a.jdField_a_of_type_Long;
      localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      if ((paramBoolean) && ((localKandianMergeManager.b()) || (localKandianMergeManager.f() > 0)))
      {
        i = 0;
        if (k == 6)
        {
          i = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
          localObject1 = new JSONObject();
        }
      }
    }
    Object localObject2;
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("source", "304");
        if (!nsp.a()) {
          continue;
        }
        j = 1;
        ((JSONObject)localObject1).put("style", j);
        nol.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
      }
      catch (Exception localException)
      {
        int j;
        long l3;
        long l4;
        continue;
        localException.g();
        continue;
        onh.d(3);
        continue;
        if (k != 13) {
          continue;
        }
        i = 6;
        continue;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_Long);
        if (this.jdField_e_of_type_Long == 0L) {
          continue;
        }
        this.jdField_e_of_type_Long += this.jdField_a_of_type_Long - this.jdField_c_of_type_Long;
        i = 0;
        if (i >= 1) {
          continue;
        }
        localObject2 = a();
        if (localObject2 == null) {
          continue;
        }
        ((ReadInJoyBaseFragment)localObject2).i();
        i += 1;
        continue;
        this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
        continue;
        localKandianMergeManager.o();
        l1 = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
        if (l1 <= 0L) {
          continue;
        }
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.18(this, l1));
        qkb.a();
        qkb.a().b();
        qvk.a().b(a());
        qvk.a().a(false, "readInjoy doOnPause");
        i = 2;
        if (k == 9) {
          break label936;
        }
      }
      if ((i == 0) || (i == ozy.a())) {
        K_();
      }
      QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
      if ((paramBoolean) && (localKandianMergeManager.f() > 0)) {
        c(k);
      }
      ((nzg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
      localObject1 = a();
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          nth.a(((ReadInJoyBaseFragment)localObject1).a(), 0);
          ((ReadInJoyBaseFragment)localObject1).a(false, a(), null);
        }
      }
      else
      {
        if (!paramBoolean) {
          continue;
        }
        pcw.a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_e_of_type_Long = 0L;
        this.jdField_b_of_type_Int = 0;
        shu.b();
        b(k);
        bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        osq.c();
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
        l3 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        onh.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bhvy.j()) {
          continue;
        }
        onh.d(6);
        qvk.a().a(a());
        l4 = bhvy.g(onh.a());
        if ((l3 >= l4) && (this.jdField_a_of_type_Long != 0L) && (a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
        {
          this.jdField_e_of_type_Boolean = true;
          K_();
          osj.a().n();
          QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l3, ", timeLimit = ", Long.valueOf(l4) });
        }
        RecommendFeedsDiandianEntranceManager.a().a();
        if (rif.a() != 8) {
          rif.a(5);
        }
        rig.a().a(false);
        if ((localKandianMergeManager.i()) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
        {
          qkb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
          this.jdField_f_of_type_Long = System.currentTimeMillis();
        }
        i = 2;
        if ((k != 9) && (k != 6)) {
          continue;
        }
        i = 5;
        shu.a(i, true, l1 - l2, onh.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
        oat.a().a(0);
        if (onh.x()) {
          E();
        }
        if (this.jdField_a_of_type_Nth != null) {
          this.jdField_a_of_type_Nth.b(paramBoolean);
        }
        osj.a().e(paramBoolean);
        if ((paramBoolean) && (!e())) {
          B();
        }
        QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + k);
        return;
        sea.b();
        break;
        j = 0;
        continue;
      }
      if (k != 6) {
        break label1092;
      }
    }
    label936:
    int i = 5;
    for (;;)
    {
      shu.a(i, false, this.jdField_b_of_type_Long, onh.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      a().getIntent().removeExtra("launch_from");
      localObject2 = (osl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
      if ((localObject2 != null) && (((osl)localObject2).a() != null))
      {
        localObject2 = ((osl)localObject2).a().a();
        if (localObject2 != null) {
          ((ReadInJoyUserInfoModule)localObject2).b();
        }
      }
      onh.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      onh.c();
      omr.a();
      if (bfnz.l()) {
        a().getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      oat.a().a(4);
      localKandianMergeManager.p();
      break;
      label1092:
      if (k == 13) {
        i = 6;
      }
    }
  }
  
  public void f()
  {
    super.f();
    osj.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        yyt.a().a((Context)localObject, new yyu());
      }
      n();
      E();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pze);
      osj.a().a(this.jdField_a_of_type_Osm);
      nzn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      return;
      if ((localObject instanceof FragmentActivity)) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)localObject).getSupportFragmentManager();
      }
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      D();
    }
    jdField_a_of_type_Boolean = false;
    x();
    ApngImage.pauseByTag(8);
    osg.n();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      bbdx.a(pyu.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
    this.jdField_a_of_type_Rou.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Nth != null) {
      this.jdField_a_of_type_Nth.c();
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (long l1 = this.jdField_c_of_type_Long;; l1 = this.jdField_b_of_type_Long)
    {
      this.jdField_e_of_type_Long = (l3 - l1 + l2);
      qvk.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  public void j()
  {
    super.j();
    ((pzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Pze);
    osj.a().b(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_Rou.c();
    if (this.jdField_a_of_type_Nth != null)
    {
      this.jdField_a_of_type_Nth.d();
      this.jdField_a_of_type_Nth = null;
    }
    if (this.jdField_a_of_type_Qmz != null) {
      this.jdField_a_of_type_Qmz.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_c_of_type_Boolean = false;
    ofw.a().a();
    bhwh.a().a();
    KandianVideoUploadService.a(null);
    oat.a().jdField_a_of_type_Boolean = true;
    RecommendFeedsDiandianEntranceManager.a().b(this);
    pyn.a().c();
  }
  
  public void k()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bhvy.j()) {
      nol.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", npu.a(null), false);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)a().findViewById(2131364694)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView = null;
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */