package com.tencent.biz.pubaccount.readinjoy.view;

import actn;
import ajwe;
import ajwm;
import ajyc;
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
import axli;
import axmt;
import axrl;
import bawz;
import bbay;
import bbct;
import bbcv;
import bbdj;
import bbev;
import bbgg;
import bbjn;
import bfni;
import bfuc;
import bfuf;
import bhvh;
import bhvq;
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
import noo;
import npx;
import nss;
import ntb;
import ntk;
import nut;
import nzj;
import nzn;
import nzq;
import oaw;
import oej;
import ofz;
import omu;
import onk;
import onr;
import org.json.JSONObject;
import osb;
import osc;
import osj;
import osm;
import oso;
import osp;
import ost;
import ota;
import oto;
import otx;
import pab;
import pau;
import pbj;
import pcz;
import pyq;
import pyx;
import pyz;
import pzc;
import pzh;
import pzi;
import qbl;
import qjo;
import qke;
import qnc;
import qol;
import qtu;
import qvd;
import qvn;
import qwt;
import qzd;
import qze;
import qzr;
import rch;
import rgp;
import rgv;
import rgw;
import rgx;
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
import rhm;
import rhn;
import rho;
import rhu;
import rii;
import rij;
import rox;
import rpl;
import rui;
import rva;
import sed;
import sgx;
import shx;
import yyw;
import yyx;

public class ReadinjoyTabFrame
  extends ajwm
  implements ViewTreeObserver.OnGlobalLayoutListener, osb, osc, otx, pbj, rgp, rhu
{
  public static int a;
  public static boolean a;
  private static boolean jdField_c_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new rgx(this);
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
  private nss jdField_a_of_type_Nss;
  private ntk jdField_a_of_type_Ntk;
  private osp jdField_a_of_type_Osp = new rha(this);
  private pzh jdField_a_of_type_Pzh = new rhf(this);
  private qnc jdField_a_of_type_Qnc;
  private qwt jdField_a_of_type_Qwt;
  protected rox a;
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajyc.a(2131693700);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374824;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajyc.a(2131712981);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374832;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajyc.a(2131712909);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131374845;
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
    Object localObject = new bfuf();
    ((bfuf)localObject).jdField_a_of_type_Int = 0;
    ((bfuf)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131712895);
    ((bfuf)localObject).jdField_b_of_type_Int = 2130842019;
    localArrayList.add(localObject);
    localObject = new bfuf();
    ((bfuf)localObject).jdField_a_of_type_Int = 1;
    ((bfuf)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131713088);
    ((bfuf)localObject).jdField_b_of_type_Int = 2130842019;
    localArrayList.add(localObject);
    localObject = new bfuf();
    ((bfuf)localObject).jdField_a_of_type_Int = 2;
    ((bfuf)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131713026);
    ((bfuf)localObject).jdField_a_of_type_Float = 14.0F;
    ((bfuf)localObject).jdField_b_of_type_Int = 2130842019;
    localArrayList.add(localObject);
    localObject = new bfuf();
    ((bfuf)localObject).jdField_a_of_type_Int = 3;
    ((bfuf)localObject).jdField_a_of_type_JavaLangString = ajyc.a(2131712951);
    ((bfuf)localObject).jdField_b_of_type_Int = 2130842019;
    localArrayList.add(localObject);
    bfuf localbfuf = new bfuf();
    localbfuf.jdField_a_of_type_Int = 4;
    if (!onk.l())
    {
      localObject = "打开预加载UI";
      localbfuf.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuf.jdField_b_of_type_Int = 2130842019;
      localArrayList.add(localbfuf);
      localbfuf = new bfuf();
      localbfuf.jdField_a_of_type_Int = 5;
      if (((Boolean)bhvh.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label360;
      }
      localObject = "打开动态频道feeds";
      label249:
      localbfuf.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuf.jdField_a_of_type_Float = 12.0F;
      localbfuf.jdField_b_of_type_Int = 2130842019;
      localArrayList.add(localbfuf);
      localbfuf = new bfuf();
      localbfuf.jdField_a_of_type_Int = 6;
      if (bhvh.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label367;
      }
    }
    label360:
    label367:
    for (localObject = ajyc.a(2131712850);; localObject = "切换到Web")
    {
      localbfuf.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfuf.jdField_a_of_type_Float = 12.0F;
      localbfuf.jdField_b_of_type_Int = 2130842019;
      localArrayList.add(localbfuf);
      bfuc.a(a(), localArrayList, new rhh(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
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
      boolean bool = ((Boolean)bhvh.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
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
    if ((NetConnInfoCenter.getServerTime() - bbjn.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > nzn.jdField_a_of_type_Long) || (oaw.a().d()) || (MainService.isDebugVersion)) {
      ThreadManagerV2.excute(new ReadinjoyTabFrame.33(this), 128, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("previewMode: ").append(oaw.a().d()).append(" Aladdin: ").append(oaw.c()).append("   interval:");
    if (NetConnInfoCenter.getServerTime() - bbjn.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > nzn.jdField_a_of_type_Long) {}
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
    int i = (int)(bbct.i() * 0.4D);
    int j = (int)(bbct.j() * 0.4D);
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
      if (this.jdField_a_of_type_Qnc != null)
      {
        bool2 = this.jdField_a_of_type_Qnc.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bhvh.e() != 1) {
          break label297;
        }
        localObject2 = qjo.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    nut.a(a(), 56, a().getString(2131719541), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      qol.a((Activity)localObject2, localBundle, bool1, 11);
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
      localObject = bbcv.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bbgg)localObject).setPositiveButton("确认", new rhb(this, paramPositionData));
      ((bbgg)localObject).setNegativeButton("取消", new rhc(this));
      ((bbgg)localObject).setCanceledOnTouchOutside(true);
      ((bbgg)localObject).show();
      return;
    }
    paramPositionData = rch.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new rhd(this));
    paramPositionData.setNegativeButton("取消", new rhe(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bfuf> paramList)
  {
    bfuf localbfuf;
    if ((paramInt & 0x1) != 0)
    {
      localbfuf = new bfuf();
      localbfuf.jdField_a_of_type_Int = 0;
      localbfuf.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718418);
      localbfuf.jdField_b_of_type_Int = 2130842286;
      paramList.add(localbfuf);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbfuf = new bfuf();
      localbfuf.jdField_a_of_type_Int = 1;
      localbfuf.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131718422);
      localbfuf.jdField_b_of_type_Int = 2130842290;
      paramList.add(localbfuf);
    }
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (paramActivity == null)
    {
      QLog.e("ReadInJoyTabFrame", 1, "openMsgBoxPage failed, activity = null");
      return;
    }
    onk.jdField_d_of_type_Boolean = true;
    paramActivity.getWindow().getDecorView().postDelayed(new ReadinjoyTabFrame.12(this, paramActivity, paramInt, paramString), paramLong);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.22(this, paramVideoInfo, (pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      onk.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt == 5)
      {
        a(true, false);
        localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bhvh.k()) {
          ((KandianMergeManager)localObject).g();
        }
        shx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        ota.a().a.a(true);
        localObject = onk.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label227;
        }
        paramInt = pyq.jdField_d_of_type_Int;
        label104:
        pyq.a().a(paramInt, 1);
      }
    }
    for (;;)
    {
      if (bhvh.i())
      {
        if (!paramBoolean) {
          break label256;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = onk.e();
        int i = onk.jdField_d_of_type_Int;
        rpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramInt, i);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13(this, l, paramInt, i));
      }
      return;
      if (paramInt == 6)
      {
        onk.f();
        break;
      }
      if (paramInt != 13) {
        break;
      }
      localObject = a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        onk.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      onk.a(-1);
      break;
      label227:
      if (paramInt == 13)
      {
        paramInt = pyq.f;
        break label104;
      }
      paramInt = pyq.e;
      break label104;
      pyq.a().c();
    }
    label256:
    rpl.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = onk.a();
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
          localObject3 = onk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = onk.a.jdField_a_of_type_JavaLangString;
          String str3 = onk.g(onk.a.c);
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
            if (!bbev.h(a())) {
              break label960;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", npx.a());
            if (onk.g != 0) {
              break label966;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", npx.jdField_a_of_type_JavaLangString);
            if (ntk.a != null) {
              ((JSONObject)localObject2).put("channel_id", ntk.a.mChannelCoverId);
            }
            onk.a(true, (JSONObject)localObject2);
            noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              onk.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              shx.a(false);
              localObject1 = (pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((pzi)localObject1).a() != 1) || (TextUtils.isEmpty(((pzi)localObject1).a()))) {
                break label972;
              }
              localObject1 = ((pzi)localObject1).a();
              localObject2 = (pzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = pzc.b(a(), 0);
              localObject3 = new onr();
              localObject1 = ((onr)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label980;
              }
              paramBoolean1 = true;
              localObject1 = ((onr)localObject1).a(paramBoolean1);
              if (onk.g != 0) {
                break label985;
              }
              paramBoolean1 = true;
              ((onr)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label990;
                }
                i = 1;
                ((onr)localObject3).a("ad_page", i);
              }
              noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((onr)localObject3).a(), false);
            }
            if (bbev.h(a())) {
              H();
            }
            if (!bhvh.k()) {
              break label931;
            }
            localObject1 = "recommend_tab_cost";
            sgx.a(null, (String)localObject1);
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
        if (onk.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - onk.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - onk.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", onk.e());
          ((JSONObject)localObject2).put("kandian_mode_new", npx.a());
          localObject1 = (pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((pzi)localObject1).a() != 1) || (TextUtils.isEmpty(((pzi)localObject1).a()))) {
            break label886;
          }
          localObject1 = ((pzi)localObject1).a();
          localObject3 = (pzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = pzc.b(a(), 0);
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
          noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
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
    oej.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772217, 2130772038);
  }
  
  private void c(int paramInt)
  {
    QLog.d("ReadInJoyTabFrame", 2, "checkIfShowMsgBoxWithFloatingWindow | launchFrom : " + paramInt);
    if (paramInt != 5) {
      return;
    }
    Object localObject = ((KandianMergeManager)onk.a().getManager(162)).a();
    if ((localObject == null) || (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt <= 0))
    {
      QLog.d("ReadInJoyTabFrame", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
      return;
    }
    boolean bool = ((Boolean)bhvh.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
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
      bhvh.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
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
    boolean bool3 = onk.w();
    Object localObject = a();
    if ((localObject instanceof ReadInJoyRecommendFeedsFragment))
    {
      localObject = ((ReadInJoyRecommendFeedsFragment)localObject).a();
      if (localObject != null)
      {
        localObject = ((ntb)localObject).a();
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
    if ((this.jdField_a_of_type_Qnc != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Qnc.a(paramInt);
    }
  }
  
  private void n()
  {
    a(2131377581).setBackgroundDrawable(null);
    this.jdField_a_of_type_Rox = new rox(a(), (ViewGroup)a(2131377581));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131374763));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131374780));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131374761));
    this.jdField_b_of_type_AndroidViewView = a(2131377369);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131376281));
    C();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131377439));
    this.jdField_d_of_type_AndroidViewView = a(2131376467);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131374836));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131374835));
    label270:
    label278:
    Object localObject;
    if (onk.p())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167134));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167087));
      }
      if (bhvh.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label530;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (onk.j() != 0) {
        break label542;
      }
      i = 1;
      localObject = a(2131370508);
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
      this.jdField_g_of_type_AndroidViewView = a(2131374813);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370462));
      i = actn.a(3.0F, a());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new rgw(this));
      u();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131370960)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new rhg(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new rhk(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      J_();
      b();
      r();
      q();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131364642);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new rhl(this));
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
    SelectPositionModule localSelectPositionModule = osj.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void q()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Rox);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Ntk = new ntk(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Ntk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Nss = new nss(this.jdField_a_of_type_Ntk, a(2131374788));
    this.jdField_a_of_type_Ntk.a(this.jdField_a_of_type_Nss);
    this.jdField_a_of_type_Ntk.a(new rhm(this));
  }
  
  private void r()
  {
    s();
  }
  
  private void s()
  {
    if (bhvh.k()) {}
    while (!bhvh.j()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rhn(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rho(this));
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
    rva localrva;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localrva = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localrva instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localrva).a != null))
      {
        localObject1 = (VideoInfo.EntranceDownloadInfo)localrva;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        qol.a(a(), ((VideoInfo.EntranceDownloadInfo)localObject1).a);
        if (this.jdField_a_of_type_Qnc != null)
        {
          localObject2 = this.jdField_a_of_type_Qnc;
          qnc.b((rva)localObject1);
          this.jdField_a_of_type_Qnc.a();
        }
      }
    }
    for (;;)
    {
      if (onk.r()) {
        a(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
      }
      return;
      if ((localrva instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
      {
        localObject2 = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrva).c;
        QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + (String)localObject2);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrva).jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          onk.a(a(), (String)localObject1);
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
          onk.a(a(), RecommendFeedsDiandianEntranceManager.a(i));
        }
      }
    }
  }
  
  private void u()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131372618);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297171);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new rgv(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = ((Boolean)bhvh.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bhvh.e())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Qnc = new qnc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848420));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848387));
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
    int i = bbjn.e((Context)localObject1);
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
        if ((bbjn.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bhvh.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bbjn.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = bawz.a((Context)localObject1, 12.0F);
          int j = bawz.a((Context)localObject1, 9.0F);
          qwt localqwt = new qwt((Context)localObject1);
          this.jdField_a_of_type_Qwt = localqwt;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localqwt.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131718637));
          localqwt.setAnimationStyle(2131755811);
          localqwt.b(-16777216);
          localqwt.setSoftInputMode(1);
          localqwt.setInputMethodMode(2);
          localqwt.a(localqwt.b() / 2 - bawz.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = axli.jdField_a_of_type_Int;
          j = bawz.a((Context)localObject1, 15.0F);
          int k = localqwt.b();
          int m = localObject2[1];
          int n = localqwt.a();
          int i1 = localqwt.c();
          int i2 = bawz.a((Context)localObject1, 5.0F);
          localqwt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          noo.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new qze(null, null, null, null).a().a(), false);
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
    if (this.jdField_a_of_type_Qwt != null) {
      this.jdField_a_of_type_Qwt.dismiss();
    }
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131374821)).inflate();
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
    Drawable localDrawable = a().getDrawable(2130842371);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842293);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842289);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166750, 2131166751, 2131166749);
      localDrawable.setColorFilter(a().getColor(2131165275), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
    }
    for (;;)
    {
      y();
      c(true);
      axmt.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      osm.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849066);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839740);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849026);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166851, 2131166851, 2131166851);
      localDrawable.setColorFilter(a().getColor(2131166851), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void K_()
  {
    if (this.jdField_a_of_type_Ntk != null)
    {
      if (pab.a() != -1) {
        this.jdField_a_of_type_Ntk.c(pab.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ntk.c(0);
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
    if (this.jdField_a_of_type_Ntk != null)
    {
      localObject = this.jdField_a_of_type_Ntk.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      axrl.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
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
    return ajyc.a(2131693700);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (onk.j() == 0)
    {
      i = 1;
      localObject = a(2131370508);
      if (i == 0) {
        break label158;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pzh);
      if (bhvh.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label164;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      G();
      osm.a().k();
      v();
      RecommendFeedsDiandianEntranceManager.a().b();
      if (this.jdField_a_of_type_Qnc != null) {
        this.jdField_a_of_type_Qnc.d();
      }
      nzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
      shx.a(paramInt);
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
    pyz localpyz;
    String str;
    do
    {
      do
      {
        return;
        localpyz = (pyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(paramInt);
      } while (!localpyz.a(paramString, paramBaseResData));
      str = localpyz.b(paramString, paramBaseResData.id);
      if (!localpyz.b(paramString, paramBaseResData)) {
        break;
      }
      if (261 == paramInt)
      {
        if (bbjn.g(a(), paramBaseResData.id) != paramBaseResData.seq)
        {
          bbdj.a(str);
          localpyz.c(paramString, paramBaseResData);
          return;
        }
        bbjn.s(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
        bbjn.C(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      localpyz.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_AndroidOsHandler.post(new ReadinjoyTabFrame.23(this, paramString, str, paramInt));
    return;
    localpyz.c(paramString, paramBaseResData);
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bhvh.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bfuc.a(paramActivity, localArrayList, new rhi(this, paramActivity), new rhj(this), actn.a(125.0F, paramActivity.getResources()), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298619) - paramActivity.getResources().getDimensionPixelSize(2131298615) + actn.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131297957));
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = ajwe.a() / 16.0F;
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
    ((pzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
    osm.a().k();
  }
  
  public void a(rva paramrva)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrva);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrva != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrva);
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
      qtu localqtu = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localqtu != null) && (localqtu.a() != null) && (localqtu.a().a()))
      {
        localqtu.a().g();
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
        i = 2131374824;
        continue;
        i = 2131374845;
        continue;
        i = 2131374832;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.19(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      onk.c(6);
      Object localObject = a().getIntent().getExtras();
      if (qzr.a((Bundle)localObject))
      {
        localObject = qzr.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((rva)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((rva)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.34(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void b(rva paramrva)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrva);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrva != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrva);
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
      if (this.jdField_a_of_type_Ntk != null) {
        this.jdField_a_of_type_Ntk.e();
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
        if ((bfni.l()) && (bbay.b())) {
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
      if ((bfni.l()) && (!bbay.b()) && (!bbay.d()))
      {
        a().getWindow().getDecorView().setSystemUiVisibility(9216);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
      return;
    }
    if ((ImmersiveUtils.a()) && ((!bfni.l()) || (!bbay.b()))) {
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
        localObject = osj.a().a();
        if (localObject != null) {
          ((pau)localObject).a(false);
        }
        onk.g();
      }
      this.jdField_a_of_type_Rox.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Ntk != null) {
          this.jdField_a_of_type_Ntk.c(i);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      onk.jdField_d_of_type_Boolean = false;
      if (((Intent)localObject).hasExtra("notification_message_id"))
      {
        str = ((Intent)localObject).getStringExtra("notification_message_id");
        if ((onk.k() == 2) && (onk.m() == 2))
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
      if ((onk.m() == 1) || (onk.k() != 2)) {
        a(a(), 5, str, 200L);
      }
      if (this.jdField_a_of_type_Ntk != null) {
        this.jdField_a_of_type_Ntk.b();
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        o();
        this.jdField_d_of_type_Boolean = true;
      }
      if (jdField_c_of_type_Boolean) {
        onk.b(true);
      }
      return;
      if (this.jdField_a_of_type_Qnc == null) {
        break;
      }
      localObject = this.jdField_a_of_type_Qnc;
      qnc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
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
      sed.a();
      jdField_c_of_type_Boolean = paramBoolean;
      c(paramBoolean);
      axmt.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      k = a().getIntent().getIntExtra("launch_from", 5);
      a(paramBoolean, k);
      l1 = NetConnInfoCenter.getServerTime();
      l2 = onk.a.jdField_a_of_type_Long;
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
        if (!nss.a()) {
          continue;
        }
        j = 1;
        ((JSONObject)localObject1).put("style", j);
        noo.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
      }
      catch (Exception localException)
      {
        int j;
        long l3;
        long l4;
        continue;
        localException.g();
        continue;
        onk.d(3);
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
        qke.a();
        qke.a().b();
        qvn.a().b(a());
        qvn.a().a(false, "readInjoy doOnPause");
        i = 2;
        if (k == 9) {
          break label936;
        }
      }
      if ((i == 0) || (i == pab.a())) {
        K_();
      }
      QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
      if ((paramBoolean) && (localKandianMergeManager.f() > 0)) {
        c(k);
      }
      ((nzj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
      localObject1 = a();
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          ntk.a(((ReadInJoyBaseFragment)localObject1).a(), 0);
          ((ReadInJoyBaseFragment)localObject1).a(false, a(), null);
        }
      }
      else
      {
        if (!paramBoolean) {
          continue;
        }
        pcz.a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_e_of_type_Long = 0L;
        this.jdField_b_of_type_Int = 0;
        shx.b();
        b(k);
        bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ost.c();
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
        l3 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        onk.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bhvh.j()) {
          continue;
        }
        onk.d(6);
        qvn.a().a(a());
        l4 = bhvh.g(onk.a());
        if ((l3 >= l4) && (this.jdField_a_of_type_Long != 0L) && (a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
        {
          this.jdField_e_of_type_Boolean = true;
          K_();
          osm.a().n();
          QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l3, ", timeLimit = ", Long.valueOf(l4) });
        }
        RecommendFeedsDiandianEntranceManager.a().a();
        if (rii.a() != 8) {
          rii.a(5);
        }
        rij.a().a(false);
        if ((localKandianMergeManager.i()) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
        {
          qke.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
          this.jdField_f_of_type_Long = System.currentTimeMillis();
        }
        i = 2;
        if ((k != 9) && (k != 6)) {
          continue;
        }
        i = 5;
        shx.a(i, true, l1 - l2, onk.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
        oaw.a().a(0);
        if (onk.x()) {
          E();
        }
        if (this.jdField_a_of_type_Ntk != null) {
          this.jdField_a_of_type_Ntk.b(paramBoolean);
        }
        osm.a().e(paramBoolean);
        if ((paramBoolean) && (!e())) {
          B();
        }
        QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + k);
        return;
        sed.b();
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
      shx.a(i, false, this.jdField_b_of_type_Long, onk.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      a().getIntent().removeExtra("launch_from");
      localObject2 = (oso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
      if ((localObject2 != null) && (((oso)localObject2).a() != null))
      {
        localObject2 = ((oso)localObject2).a().a();
        if (localObject2 != null) {
          ((ReadInJoyUserInfoModule)localObject2).b();
        }
      }
      onk.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      onk.c();
      omu.a();
      if (bfni.l()) {
        a().getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      axmt.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      oaw.a().a(4);
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
    osm.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        yyw.a().a((Context)localObject, new yyx());
      }
      n();
      E();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pzh);
      osm.a().a(this.jdField_a_of_type_Osp);
      nzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
    osj.n();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      bbdj.a(pyx.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
    this.jdField_a_of_type_Rox.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Ntk != null) {
      this.jdField_a_of_type_Ntk.c();
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
      qvn.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  public void j()
  {
    super.j();
    ((pzi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Pzh);
    osm.a().b(this.jdField_a_of_type_Osp);
    this.jdField_a_of_type_Rox.c();
    if (this.jdField_a_of_type_Ntk != null)
    {
      this.jdField_a_of_type_Ntk.d();
      this.jdField_a_of_type_Ntk = null;
    }
    if (this.jdField_a_of_type_Qnc != null) {
      this.jdField_a_of_type_Qnc.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_c_of_type_Boolean = false;
    ofz.a().a();
    bhvq.a().a();
    KandianVideoUploadService.a(null);
    oaw.a().jdField_a_of_type_Boolean = true;
    RecommendFeedsDiandianEntranceManager.a().b(this);
    pyq.a().c();
  }
  
  public void k()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bhvh.j()) {
      noo.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", npx.a(null), false);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)a().findViewById(2131364695)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
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