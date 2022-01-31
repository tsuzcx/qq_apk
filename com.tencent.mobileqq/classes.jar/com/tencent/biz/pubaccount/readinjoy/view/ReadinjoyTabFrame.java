package com.tencent.biz.pubaccount.readinjoy.view;

import aciy;
import ajia;
import ajii;
import ajjy;
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
import awmc;
import awnu;
import awrn;
import azvv;
import azzu;
import babp;
import babr;
import bace;
import badq;
import bafb;
import baig;
import befo;
import bemi;
import beml;
import bgmq;
import bgmy;
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
import mqq.app.Constants.LogoutReason;
import mqq.app.MainService;
import mqq.os.MqqHandler;
import ndn;
import new;
import nhi;
import nia;
import nji;
import nny;
import noc;
import nof;
import npl;
import nsz;
import nuo;
import obj;
import obz;
import ocg;
import ogq;
import ogr;
import ogy;
import ohb;
import ohd;
import ohe;
import ohi;
import ohp;
import oid;
import oim;
import opa;
import opt;
import oqi;
import org.json.JSONObject;
import orx;
import pmv;
import pnc;
import pne;
import pnh;
import pnm;
import pnn;
import ppp;
import pxq;
import pye;
import qbe;
import qcn;
import qhp;
import qiy;
import qji;
import qko;
import qmu;
import qmv;
import qni;
import qpw;
import qud;
import quj;
import quk;
import qul;
import quo;
import qup;
import quq;
import qur;
import qus;
import qut;
import quu;
import quv;
import quw;
import qux;
import quy;
import quz;
import qva;
import qvb;
import qvc;
import qvi;
import qvw;
import qvx;
import rcf;
import rcx;
import rhs;
import rik;
import rrl;
import ruf;
import rvf;
import ypc;
import ypd;

public class ReadinjoyTabFrame
  extends ajii
  implements ViewTreeObserver.OnGlobalLayoutListener, ogq, ogr, oim, oqi, qud, qvi
{
  public static int a;
  public static boolean a;
  private static boolean jdField_c_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new qul(this);
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
  private nhi jdField_a_of_type_Nhi;
  private nia jdField_a_of_type_Nia;
  private ohe jdField_a_of_type_Ohe = new quo(this);
  private pnm jdField_a_of_type_Pnm = new qut(this);
  private qbe jdField_a_of_type_Qbe;
  private qko jdField_a_of_type_Qko;
  protected rcf a;
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
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.15(this);
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajjy.a(2131628059);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131309082;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajjy.a(2131647193);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131309090;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ajjy.a(2131647121);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131309103;
      }
    }
  }
  
  private void D()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131166093);
    }
  }
  
  private void E()
  {
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.InitWebProcessRunnable(this));
  }
  
  private void F()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new beml();
    ((beml)localObject).jdField_a_of_type_Int = 0;
    ((beml)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131647107);
    ((beml)localObject).jdField_b_of_type_Int = 2130841926;
    localArrayList.add(localObject);
    localObject = new beml();
    ((beml)localObject).jdField_a_of_type_Int = 1;
    ((beml)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131647300);
    ((beml)localObject).jdField_b_of_type_Int = 2130841926;
    localArrayList.add(localObject);
    localObject = new beml();
    ((beml)localObject).jdField_a_of_type_Int = 2;
    ((beml)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131647238);
    ((beml)localObject).jdField_a_of_type_Float = 14.0F;
    ((beml)localObject).jdField_b_of_type_Int = 2130841926;
    localArrayList.add(localObject);
    localObject = new beml();
    ((beml)localObject).jdField_a_of_type_Int = 3;
    ((beml)localObject).jdField_a_of_type_JavaLangString = ajjy.a(2131647163);
    ((beml)localObject).jdField_b_of_type_Int = 2130841926;
    localArrayList.add(localObject);
    beml localbeml = new beml();
    localbeml.jdField_a_of_type_Int = 4;
    if (!obz.m())
    {
      localObject = "打开预加载UI";
      localbeml.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbeml.jdField_b_of_type_Int = 2130841926;
      localArrayList.add(localbeml);
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 5;
      if (((Boolean)bgmq.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label359;
      }
      localObject = "打开动态频道feeds";
      label249:
      localbeml.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbeml.jdField_a_of_type_Float = 12.0F;
      localbeml.jdField_b_of_type_Int = 2130841926;
      localArrayList.add(localbeml);
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 6;
      if (bgmq.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label365;
      }
    }
    label359:
    label365:
    for (localObject = ajjy.a(2131647062);; localObject = "切换到Web")
    {
      localbeml.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbeml.jdField_a_of_type_Float = 12.0F;
      localbeml.jdField_b_of_type_Int = 2130841926;
      localArrayList.add(localbeml);
      bemi.a(a(), localArrayList, new quu(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
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
      boolean bool = ((Boolean)bgmq.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
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
    if ((NetConnInfoCenter.getServerTime() - baig.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > noc.jdField_a_of_type_Long) || (npl.a().d()) || (MainService.isDebugVersion)) {
      ThreadManagerV2.excute(new ReadinjoyTabFrame.32(this), 128, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("previewMode: ").append(npl.a().d()).append(" Aladdin: ").append(npl.c()).append("   interval:");
    if (NetConnInfoCenter.getServerTime() - baig.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > noc.jdField_a_of_type_Long) {}
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
    int i = (int)(babp.i() * 0.4D);
    int j = (int)(babp.j() * 0.4D);
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
      if (this.jdField_a_of_type_Qbe != null)
      {
        bool2 = this.jdField_a_of_type_Qbe.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bgmq.e() != 1) {
          break label297;
        }
        localObject2 = pxq.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    nji.a(a(), 56, a().getString(2131653657), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      qcn.a((Activity)localObject2, localBundle, bool1, 11);
      c(3);
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
      localObject = babr.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bafb)localObject).setPositiveButton("确认", new qup(this, paramPositionData));
      ((bafb)localObject).setNegativeButton("取消", new quq(this));
      ((bafb)localObject).setCanceledOnTouchOutside(true);
      ((bafb)localObject).show();
      return;
    }
    paramPositionData = qpw.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new qur(this));
    paramPositionData.setNegativeButton("取消", new qus(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<beml> paramList)
  {
    beml localbeml;
    if ((paramInt & 0x1) != 0)
    {
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 0;
      localbeml.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131652599);
      localbeml.jdField_b_of_type_Int = 2130842202;
      paramList.add(localbeml);
    }
    if ((paramInt & 0x2) != 0)
    {
      localbeml = new beml();
      localbeml.jdField_a_of_type_Int = 1;
      localbeml.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131652603);
      localbeml.jdField_b_of_type_Int = 2130842206;
      paramList.add(localbeml);
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.21(this, paramVideoInfo, (pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      obz.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt == 5)
      {
        a(true, false);
        localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bgmq.k()) {
          ((KandianMergeManager)localObject).g();
        }
        rvf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        ohp.a().a.a(true);
        localObject = obz.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label227;
        }
        paramInt = pmv.jdField_d_of_type_Int;
        label104:
        pmv.a().a(paramInt, 1);
      }
    }
    for (;;)
    {
      if (bgmq.i())
      {
        if (!paramBoolean) {
          break label256;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = obz.e();
        int i = obz.jdField_d_of_type_Int;
        rcx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramInt, i);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.12(this, l, paramInt, i));
      }
      return;
      if (paramInt == 6)
      {
        obz.f();
        break;
      }
      if (paramInt != 13) {
        break;
      }
      localObject = a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        obz.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      obz.a(-1);
      break;
      label227:
      if (paramInt == 13)
      {
        paramInt = pmv.f;
        break label104;
      }
      paramInt = pmv.e;
      break label104;
      pmv.a().c();
    }
    label256:
    rcx.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = obz.a();
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
          localObject3 = obz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = obz.a.jdField_a_of_type_JavaLangString;
          String str3 = obz.g(obz.a.c);
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
              break label915;
            }
            ((JSONObject)localObject2).put("reddot_num", ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get());
            break label915;
            ((JSONObject)localObject2).put("current_page", j);
            if (!badq.h(a())) {
              break label936;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", new.a());
            if (obz.g != 0) {
              break label942;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", new.jdField_a_of_type_JavaLangString);
            obz.a(true, (JSONObject)localObject2);
            ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              obz.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              rvf.a(false);
              localObject1 = (pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((pnn)localObject1).a() != 1) || (TextUtils.isEmpty(((pnn)localObject1).a()))) {
                break label948;
              }
              localObject1 = ((pnn)localObject1).a();
              localObject2 = (pnh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = pnh.b(a(), 0);
              localObject3 = new ocg();
              localObject1 = ((ocg)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label956;
              }
              paramBoolean1 = true;
              localObject1 = ((ocg)localObject1).a(paramBoolean1);
              if (obz.g != 0) {
                break label961;
              }
              paramBoolean1 = true;
              ((ocg)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label966;
                }
                i = 1;
                ((ocg)localObject3).a("ad_page", i);
              }
              ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((ocg)localObject3).a(), false);
            }
            if (badq.h(a())) {
              H();
            }
            if (!bgmq.k()) {
              break label907;
            }
            localObject1 = "recommend_tab_cost";
            ruf.a(null, (String)localObject1);
          }
        }
        else
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.get() != 5) {
            break label925;
          }
          i = 3;
          continue;
        }
        if (obz.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - obz.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - obz.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", obz.e());
          ((JSONObject)localObject2).put("kandian_mode_new", new.a());
          localObject1 = (pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((pnn)localObject1).a() != 1) || (TextUtils.isEmpty(((pnn)localObject1).a()))) {
            break label862;
          }
          localObject1 = ((pnn)localObject1).a();
          localObject3 = (pnh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = pnh.b(a(), 0);
          ((JSONObject)localObject2).put("skin_id", localObject1);
          localObject1 = a();
          if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
          {
            if ((localObject3 == null) || (!((RefreshData)localObject3).isAD)) {
              break label979;
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
            break label870;
          }
          ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      label862:
      String str1 = "0";
      continue;
      label870:
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
      continue;
      label907:
      str1 = "video_tab_cost";
      continue;
      label915:
      if (!paramBoolean2)
      {
        j = 0;
        continue;
        label925:
        i = 2;
      }
      else
      {
        j = 1;
        continue;
        label936:
        j = 1;
        continue;
        label942:
        j = 1;
        continue;
        label948:
        str1 = "0";
        continue;
        label956:
        paramBoolean1 = false;
        continue;
        label961:
        paramBoolean1 = false;
        continue;
        label966:
        i = 0;
        continue;
        str1 = "";
        continue;
        label979:
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
    nsz.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772217, 2130772038);
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Qbe != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Qbe.a(paramInt);
    }
  }
  
  public static boolean c_()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private void n()
  {
    a(2131311768).setBackgroundDrawable(null);
    this.jdField_a_of_type_Rcf = new rcf(a(), (ViewGroup)a(2131311768));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131309022));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131309039));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131309020));
    this.jdField_b_of_type_AndroidViewView = a(2131311553);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131310489));
    C();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131311626));
    this.jdField_d_of_type_AndroidViewView = a(2131310674);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131309094));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131309093));
    label270:
    label278:
    Object localObject;
    if (obz.q())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131101537));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131101491));
      }
      if (bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label530;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (obz.j() != 0) {
        break label542;
      }
      i = 1;
      localObject = a(2131304842);
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
      this.jdField_g_of_type_AndroidViewView = a(2131309071);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131304801));
      i = aciy.a(3.0F, a());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new quk(this));
      u();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131305285)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new quv(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new quy(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      L_();
      b();
      r();
      q();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131299082);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new quz(this));
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
    SelectPositionModule localSelectPositionModule = ogy.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void q()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Rcf);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Nia = new nia(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Nia.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_Nhi = new nhi(this.jdField_a_of_type_Nia, a(2131309048));
    this.jdField_a_of_type_Nia.a(this.jdField_a_of_type_Nhi);
    this.jdField_a_of_type_Nia.a(new qva(this));
  }
  
  private void r()
  {
    s();
  }
  
  private void s()
  {
    if (bgmq.k()) {}
    while (!bgmq.j()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new qvb(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new qvc(this));
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
    rik localrik;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localrik = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localrik instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localrik).a != null))
      {
        localObject1 = (VideoInfo.EntranceDownloadInfo)localrik;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        qcn.a(a(), ((VideoInfo.EntranceDownloadInfo)localObject1).a);
        if (this.jdField_a_of_type_Qbe != null)
        {
          localObject2 = this.jdField_a_of_type_Qbe;
          qbe.b((rik)localObject1);
          this.jdField_a_of_type_Qbe.a();
        }
      }
    }
    for (;;)
    {
      if (obz.s()) {
        a(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
      }
      return;
      if ((localrik instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
      {
        localObject2 = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrik).c;
        QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + (String)localObject2);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localrik).jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          obz.a(a(), (String)localObject1);
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
          obz.a(a(), RecommendFeedsDiandianEntranceManager.a(i));
        }
      }
    }
  }
  
  private void u()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131306906);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131166093);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new quj(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = ((Boolean)bgmq.a("sp_key_readinjoy_video_entrance_reddot_button_switch", Boolean.valueOf(true))).booleanValue();
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bgmq.e())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Qbe = new qbe(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848190));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848155));
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
    int i = baig.e((Context)localObject1);
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
        if ((baig.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bgmq.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          baig.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = azvv.a((Context)localObject1, 12.0F);
          int j = azvv.a((Context)localObject1, 9.0F);
          qko localqko = new qko((Context)localObject1);
          this.jdField_a_of_type_Qko = localqko;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localqko.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131652812));
          localqko.setAnimationStyle(2131690201);
          localqko.b(-16777216);
          localqko.setSoftInputMode(1);
          localqko.setInputMethodMode(2);
          localqko.a(localqko.b() / 2 - azvv.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = awmc.jdField_a_of_type_Int;
          j = azvv.a((Context)localObject1, 15.0F);
          int k = localqko.b();
          int m = localObject2[1];
          int n = localqko.a();
          int i1 = localqko.c();
          int i2 = azvv.a((Context)localObject1, 5.0F);
          localqko.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          ndn.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new qmv(null, null, null, null).a().a(), false);
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
    if (this.jdField_a_of_type_Qko != null) {
      this.jdField_a_of_type_Qko.dismiss();
    }
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131309079)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131494415, null);
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
  
  public void L_()
  {
    Drawable localDrawable = a().getDrawable(2130842288);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842209);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842205);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131101156, 2131101157, 2131101155);
      localDrawable.setColorFilter(a().getColor(2131099738), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
    }
    for (;;)
    {
      y();
      c(true);
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      ohb.a().h();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848841);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839691);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130848801);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131101257, 2131101257, 2131101257);
      localDrawable.setColorFilter(a().getColor(2131101257), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void M_()
  {
    if (this.jdField_a_of_type_Nia != null)
    {
      if (opa.a() != -1) {
        this.jdField_a_of_type_Nia.c(opa.a());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Nia.c(0);
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494385, null);
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
    if (this.jdField_a_of_type_Nia != null)
    {
      localObject = this.jdField_a_of_type_Nia.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      awrn.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
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
    return ajjy.a(2131628059);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (obz.j() == 0)
    {
      i = 1;
      localObject = a(2131304842);
      if (i == 0) {
        break label167;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pnm);
      if (bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
        break label173;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      G();
      ohb.a().k();
      v();
      RecommendFeedsDiandianEntranceManager.a().b();
      if ((RecommendFeedsDiandianEntranceManager.a().a()) && (this.jdField_a_of_type_Qbe != null)) {
        this.jdField_a_of_type_Qbe.d();
      }
      nof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      return;
      i = 0;
      break;
      label167:
      i = 8;
      break label50;
      label173:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      rvf.a(paramInt);
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
    pne localpne = (pne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(paramInt);
    String str;
    if (localpne.a(paramString, paramBaseResData))
    {
      str = localpne.b(paramString, paramBaseResData.id);
      if (!localpne.b(paramString, paramBaseResData)) {
        break label193;
      }
      if (261 != paramInt) {
        break label117;
      }
      if (baig.g(a(), paramBaseResData.id) == paramBaseResData.seq) {
        break label85;
      }
      bace.a(str);
      localpne.c(paramString, paramBaseResData);
    }
    label85:
    label117:
    do
    {
      return;
      baig.s(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBaseResData.id);
      baig.C(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localpne.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_AndroidOsHandler.post(new ReadinjoyTabFrame.22(this, paramString, str, paramInt));
    return;
    label193:
    localpne.c(paramString, paramBaseResData);
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bgmq.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bemi.a(paramActivity, localArrayList, new quw(this, paramActivity), new qux(this), aciy.a(125.0F, paramActivity.getResources()), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131167526) - paramActivity.getResources().getDimensionPixelSize(2131167522) + aciy.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131166867));
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = ajia.a() / 16.0F;
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
    ((pnh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
    ohb.a().k();
  }
  
  public void a(rik paramrik)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrik);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrik != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrik);
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
      qhp localqhp = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localqhp != null) && (localqhp.a() != null) && (localqhp.a().a()))
      {
        localqhp.a().g();
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
        i = 2131309082;
        continue;
        i = 2131309103;
        continue;
        i = 2131309090;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.18(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      obz.c(6);
      Object localObject = a().getIntent().getExtras();
      if (qni.a((Bundle)localObject))
      {
        localObject = qni.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((rik)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((rik)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.33(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void b(rik paramrik)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramrik);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramrik != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramrik);
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
      if (this.jdField_a_of_type_Nia != null) {
        this.jdField_a_of_type_Nia.e();
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
        if ((befo.k()) && (azzu.b())) {
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
      if ((befo.k()) && (!azzu.b()) && (!azzu.d()))
      {
        a().getWindow().getDecorView().setSystemUiVisibility(9216);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
      return;
    }
    if ((ImmersiveUtils.a()) && ((!befo.k()) || (!azzu.b()))) {
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.e();
      if (!paramBoolean) {
        break label220;
      }
      c(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = ogy.a().a();
        if (localObject != null) {
          ((opt)localObject).a(false);
        }
      }
      this.jdField_a_of_type_Rcf.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Nia != null) {
          this.jdField_a_of_type_Nia.c(i);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Nia != null) {
        this.jdField_a_of_type_Nia.b();
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        o();
        this.jdField_d_of_type_Boolean = true;
      }
      if (jdField_c_of_type_Boolean) {
        obz.b(true);
      }
      return;
      label220:
      if (this.jdField_a_of_type_Qbe != null)
      {
        localObject = this.jdField_a_of_type_Qbe;
        qbe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      }
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
      rrl.a();
      jdField_c_of_type_Boolean = paramBoolean;
      c(paramBoolean);
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      k = a().getIntent().getIntExtra("launch_from", 5);
      a(paramBoolean, k);
      l1 = NetConnInfoCenter.getServerTime();
      l2 = obz.a.jdField_a_of_type_Long;
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
        if (!nhi.a()) {
          continue;
        }
        j = 1;
        ((JSONObject)localObject1).put("style", j);
        ndn.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
      }
      catch (Exception localException)
      {
        int j;
        long l3;
        long l4;
        continue;
        localException.g();
        continue;
        obz.d(3);
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
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this, l1));
        pye.a();
        pye.a().b();
        qji.a().b(a());
        qji.a().a(false, "readInjoy doOnPause");
        i = 2;
        if (k == 9) {
          break label908;
        }
      }
      if ((i == 0) || (i == opa.a())) {
        M_();
      }
      QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
      ((nny)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
      localObject1 = a();
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          nia.a(((ReadInJoyBaseFragment)localObject1).a(), 0);
          ((ReadInJoyBaseFragment)localObject1).a(false, a(), null);
        }
      }
      else
      {
        if (!paramBoolean) {
          continue;
        }
        orx.a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_e_of_type_Long = 0L;
        this.jdField_b_of_type_Int = 0;
        rvf.b();
        b(k);
        bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ohi.c();
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.16(this));
        l3 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        obz.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!bgmq.j()) {
          continue;
        }
        obz.d(6);
        qji.a().a(a());
        l4 = bgmq.g(obz.a());
        if ((l3 >= l4) && (this.jdField_a_of_type_Long != 0L) && (a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
        {
          this.jdField_e_of_type_Boolean = true;
          M_();
          ohb.a().n();
          QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l3, ", timeLimit = ", Long.valueOf(l4) });
        }
        RecommendFeedsDiandianEntranceManager.a().a();
        if (qvw.a() != 8) {
          qvw.a(5);
        }
        qvx.a().a(false);
        if ((localKandianMergeManager.i()) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
        {
          pye.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
          this.jdField_f_of_type_Long = System.currentTimeMillis();
        }
        i = 2;
        if ((k != 9) && (k != 6)) {
          continue;
        }
        i = 5;
        rvf.a(i, true, l1 - l2, obz.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
        npl.a().a(0);
        if (this.jdField_a_of_type_Nia != null) {
          this.jdField_a_of_type_Nia.b(paramBoolean);
        }
        ohb.a().e(paramBoolean);
        if ((paramBoolean) && (!e())) {
          B();
        }
        QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + k);
        return;
        rrl.b();
        break;
        j = 0;
        continue;
      }
      if (k != 6) {
        break label1064;
      }
    }
    label908:
    int i = 5;
    for (;;)
    {
      rvf.a(i, false, this.jdField_b_of_type_Long, obz.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      a().getIntent().removeExtra("launch_from");
      localObject2 = (ohd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
      if ((localObject2 != null) && (((ohd)localObject2).a() != null))
      {
        localObject2 = ((ohd)localObject2).a().a();
        if (localObject2 != null) {
          ((ReadInJoyUserInfoModule)localObject2).b();
        }
      }
      obz.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      obz.c();
      obj.a();
      if (befo.k()) {
        a().getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      awnu.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      npl.a().a(4);
      localKandianMergeManager.p();
      break;
      label1064:
      if (k == 13) {
        i = 6;
      }
    }
  }
  
  public void f()
  {
    super.f();
    ohb.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        ypc.a().a((Context)localObject, new ypd());
      }
      n();
      E();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Pnm);
      ohb.a().a(this.jdField_a_of_type_Ohe);
      nof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
    ogy.n();
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      bace.a(pnc.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
    this.jdField_a_of_type_Rcf.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Nia != null) {
      this.jdField_a_of_type_Nia.c();
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
      qji.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  public void j()
  {
    super.j();
    ((pnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Pnm);
    ohb.a().b(this.jdField_a_of_type_Ohe);
    this.jdField_a_of_type_Rcf.c();
    if (this.jdField_a_of_type_Nia != null)
    {
      this.jdField_a_of_type_Nia.d();
      this.jdField_a_of_type_Nia = null;
    }
    if (this.jdField_a_of_type_Qbe != null) {
      this.jdField_a_of_type_Qbe.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_c_of_type_Boolean = false;
    nuo.a().a();
    bgmy.a().a();
    KandianVideoUploadService.a(null);
    npl.a().jdField_a_of_type_Boolean = true;
    RecommendFeedsDiandianEntranceManager.a().b(this);
  }
  
  public void k()
  {
    a(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bgmq.j()) {
      ndn.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", new.a(null), false);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      ((FrameLayout)a().findViewById(2131299135)).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView);
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