package com.tencent.biz.pubaccount.readinjoy.view;

import aaos;
import aaot;
import aekt;
import alnq;
import alny;
import alpo;
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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextPaint;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import azgq;
import azib;
import azmz;
import azwu;
import bcwh;
import bdag;
import bdcb;
import bdcd;
import bdee;
import bdfq;
import bdiv;
import bhou;
import bhvq;
import bhvt;
import bjxj;
import bjxs;
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
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.LogoutReason;
import mqq.app.MainService;
import mqq.os.MqqHandler;
import nrt;
import ntd;
import nwm;
import nxu;
import ocq;
import ocu;
import ocx;
import oeh;
import oek;
import ois;
import oki;
import orc;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import ors;
import orz;
import owq;
import owr;
import owy;
import oxb;
import oxd;
import oxe;
import oxi;
import oxp;
import oyd;
import oyy;
import pdy;
import pfg;
import pga;
import pgr;
import piy;
import qfz;
import qgf;
import qgk;
import qgm;
import qgo;
import qgu;
import qgy;
import qhb;
import qhl;
import qiu;
import qja;
import qle;
import qok;
import qys;
import qzi;
import rcd;
import rdm;
import rjg;
import rkp;
import rlb;
import rmf;
import rom;
import ron;
import rpk;
import rsb;
import rwi;
import rwo;
import rwp;
import rwq;
import rwr;
import rws;
import rwt;
import rwu;
import rwv;
import rww;
import rwx;
import rwy;
import rwz;
import rxa;
import rxb;
import rxc;
import rxd;
import rxe;
import rxf;
import rxl;
import rxz;
import rya;
import set;
import sfh;
import sks;
import slk;
import sro;
import svt;
import syp;
import szp;

public class ReadinjoyTabFrame
  extends alny
  implements ViewTreeObserver.OnGlobalLayoutListener, owq, owr, oyy, pgr, qgu, rwi, rxl
{
  public static int a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new rwq(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private DuplicateEventLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
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
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private nwm jdField_a_of_type_Nwm;
  private oxe jdField_a_of_type_Oxe = new rwr(this);
  private qhb jdField_a_of_type_Qhb;
  private rcd jdField_a_of_type_Rcd;
  private rmf jdField_a_of_type_Rmf;
  protected set a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new ReadinjoyTabFrame.1(this);
  private final int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
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
  
  private void D()
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
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = alpo.a(2131693817);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375290;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = alpo.a(2131713364);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375299;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = alpo.a(2131713292);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131375312;
      }
    }
  }
  
  private void E()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297190);
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable.a(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable);
  }
  
  private void G()
  {
    if (!"2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bhvt();
    ((bhvt)localObject).jdField_a_of_type_Int = 0;
    ((bhvt)localObject).jdField_a_of_type_JavaLangString = alpo.a(2131713278);
    ((bhvt)localObject).jdField_b_of_type_Int = 2130842172;
    localArrayList.add(localObject);
    localObject = new bhvt();
    ((bhvt)localObject).jdField_a_of_type_Int = 1;
    ((bhvt)localObject).jdField_a_of_type_JavaLangString = alpo.a(2131713471);
    ((bhvt)localObject).jdField_b_of_type_Int = 2130842172;
    localArrayList.add(localObject);
    localObject = new bhvt();
    ((bhvt)localObject).jdField_a_of_type_Int = 2;
    ((bhvt)localObject).jdField_a_of_type_JavaLangString = alpo.a(2131713409);
    ((bhvt)localObject).jdField_a_of_type_Float = 14.0F;
    ((bhvt)localObject).jdField_b_of_type_Int = 2130842172;
    localArrayList.add(localObject);
    localObject = new bhvt();
    ((bhvt)localObject).jdField_a_of_type_Int = 3;
    ((bhvt)localObject).jdField_a_of_type_JavaLangString = alpo.a(2131713334);
    ((bhvt)localObject).jdField_b_of_type_Int = 2130842172;
    localArrayList.add(localObject);
    bhvt localbhvt = new bhvt();
    localbhvt.jdField_a_of_type_Int = 4;
    if (!ors.l())
    {
      localObject = "打开预加载UI";
      localbhvt.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbhvt.jdField_b_of_type_Int = 2130842172;
      localArrayList.add(localbhvt);
      localbhvt = new bhvt();
      localbhvt.jdField_a_of_type_Int = 5;
      if (((Boolean)bjxj.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label359;
      }
      localObject = "打开动态频道feeds";
      label249:
      localbhvt.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbhvt.jdField_a_of_type_Float = 12.0F;
      localbhvt.jdField_b_of_type_Int = 2130842172;
      localArrayList.add(localbhvt);
      localbhvt = new bhvt();
      localbhvt.jdField_a_of_type_Int = 6;
      if (bjxj.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label366;
      }
    }
    label359:
    label366:
    for (localObject = alpo.a(2131713233);; localObject = "切换到Web")
    {
      localbhvt.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbhvt.jdField_a_of_type_Float = 12.0F;
      localbhvt.jdField_b_of_type_Int = 2130842172;
      localArrayList.add(localbhvt);
      bhvq.a(a(), localArrayList, new rww(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      localObject = "取消动态频道feeds";
      break label249;
    }
  }
  
  private void H()
  {
    a("0X800AC6C", 0);
  }
  
  private void I()
  {
    a("0X800AC6E", 2);
  }
  
  private void J()
  {
    a("0X800AC6D", 3);
  }
  
  private void K()
  {
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      boolean bool = bjxj.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
      if (!bool) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("should video entrance when change account: ");
        if (!bool) {
          break label106;
        }
      }
    }
    label86:
    label106:
    for (String str = "true";; str = "false")
    {
      QLog.d("ReadInJoyTabFrame", 2, str);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
      break;
    }
  }
  
  private void L()
  {
    boolean bool = true;
    if ((NetConnInfoCenter.getServerTime() - bdiv.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > ocu.jdField_a_of_type_Long) || (oek.a().d()) || (MainService.isDebugVersion)) {
      ThreadManagerV2.excute(new ReadinjoyTabFrame.31(this), 128, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("previewMode: ").append(oek.a().d()).append(" Aladdin: ").append(oek.c()).append("   interval:");
    if (NetConnInfoCenter.getServerTime() - bdiv.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) > ocu.jdField_a_of_type_Long) {}
    for (;;)
    {
      QLog.i("ReadInJoyTabFrame", 2, bool);
      return;
      bool = false;
    }
  }
  
  private void M()
  {
    int i = 8;
    boolean bool1 = false;
    boolean bool2 = azwu.a();
    if (bool2 == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool2;
    int j;
    if (azwu.a()) {
      j = 0;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null)
      {
        ReadInJoyChannelViewPager localReadInJoyChannelViewPager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
        if (!this.jdField_e_of_type_Boolean) {
          bool1 = true;
        }
        localReadInJoyChannelViewPager.setSlideLeftAndRight(bool1);
      }
      if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
        K();
      }
      QLog.d("ReadInJoyTabFrame", 1, "updateStudyModelUI, isStudyMode= " + this.jdField_e_of_type_Boolean);
      return;
      j = 8;
      i = 0;
    }
  }
  
  private void N()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
    nxu.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = ors.a();
        localJSONObject.put("folder_status", ors.jdField_d_of_type_Int);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", ors.e());
        localJSONObject.put("kandian_mode_new", ntd.a());
        localObject = (qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
        if ((((qja)localObject).a() != 1) || (TextUtils.isEmpty(((qja)localObject).a()))) {
          continue;
        }
        localObject = ((qja)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
      }
      catch (Exception localException)
      {
        int i;
        Object localObject;
        localException.printStackTrace();
        continue;
      }
      syp.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private int a(@NotNull Context paramContext, List<bhvt> paramList)
  {
    int i = aekt.a(125.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 15.0F);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      bhvt localbhvt = (bhvt)paramList.next();
      int j = (int)Math.ceil(localTextView.getPaint().measureText(localbhvt.jdField_a_of_type_JavaLangString)) + aekt.a(71.0F, paramContext.getResources());
      if (j <= i) {
        break label102;
      }
      i = j;
    }
    label102:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private bhvt a(int paramInt, String paramString, Drawable paramDrawable)
  {
    bhvt localbhvt = new bhvt();
    localbhvt.jdField_a_of_type_Int = paramInt;
    localbhvt.jdField_a_of_type_JavaLangString = paramString;
    localbhvt.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return localbhvt;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(bdcb.i() * 0.4D);
    int j = (int)(bdcb.j() * 0.4D);
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
      if (this.jdField_a_of_type_Rcd != null)
      {
        bool2 = this.jdField_a_of_type_Rcd.a(localBundle);
        localObject1 = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
        if (bjxj.e() != 1) {
          break label297;
        }
        localObject2 = qys.a((VideoInfo)localObject1);
        if ((localObject2 == null) || (!(localObject2 instanceof ArticleInfo))) {
          break label271;
        }
        ReadInJoyListViewGroup.a(a(), null, (ArticleInfo)localObject2, 1004);
      }
    }
    return localObject1;
    label271:
    nxu.a(a(), 56, a().getString(2131720084), 3, 1004);
    return localObject1;
    label297:
    localObject2 = a();
    if (!bool2) {}
    for (;;)
    {
      rdm.a((Activity)localObject2, localBundle, bool1, 11);
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
      localObject = bdcd.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((bdfq)localObject).setPositiveButton("确认", new rws(this, paramPositionData));
      ((bdfq)localObject).setNegativeButton("取消", new rwt(this));
      ((bdfq)localObject).setCanceledOnTouchOutside(true);
      ((bdfq)localObject).show();
      return;
    }
    paramPositionData = rsb.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new rwu(this));
    paramPositionData.setNegativeButton("取消", new rwv(this));
    paramPositionData.show();
  }
  
  private void a(int paramInt, List<bhvt> paramList)
  {
    Drawable localDrawable;
    if ((paramInt & 0x1) != 0)
    {
      localDrawable = a().getDrawable(2130842455).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(0, BaseApplicationImpl.getApplication().getString(2131718851), localDrawable));
    }
    if ((paramInt & 0x2) != 0)
    {
      localDrawable = a().getDrawable(2130842456).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(1, BaseApplicationImpl.getApplication().getString(2131718855), localDrawable));
    }
    if (qok.a())
    {
      localDrawable = a().getDrawable(2130842636).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(2, qok.a(BaseApplicationImpl.getContext()), localDrawable));
    }
    if (qok.b())
    {
      localDrawable = a().getDrawable(2130842640).mutate();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      paramList.add(a(3, qok.b(BaseApplicationImpl.getContext()), localDrawable));
    }
  }
  
  private void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList = new ArrayList();
    a(bjxj.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    bhvq.a(paramActivity, localArrayList, new rwx(this, paramActivity), new rwz(this), a(paramActivity, localArrayList), false).showAsDropDown(paramViewGroup, paramViewGroup.getWidth() - paramActivity.getResources().getDimensionPixelSize(2131298647) - paramActivity.getResources().getDimensionPixelSize(2131298643) + aekt.a(40.0F, paramActivity.getResources()), paramActivity.getResources().getDimensionPixelSize(2131297978));
    H();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.22(this, paramVideoInfo, (qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)), 16, null, true);
  }
  
  private void a(String paramString, int paramInt)
  {
    int j = 1;
    orz localorz1 = new orz();
    orz localorz2;
    if (qok.b())
    {
      i = 1;
      localorz2 = localorz1.a("ugc_video_flag", Integer.valueOf(i));
      if (!qok.a()) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = 0)
    {
      localorz2.a("ugc_column_flag", Integer.valueOf(i));
      if (paramInt != 0) {
        localorz1.a("from", Integer.valueOf(paramInt));
      }
      nrt.a(paramString, localorz1.a());
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      ors.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt == 5)
      {
        b(true, false);
        localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bjxj.k()) {
          ((KandianMergeManager)localObject).g();
        }
        szp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        oxp.a().a.a(true);
        localObject = ors.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label227;
        }
        paramInt = qhl.jdField_d_of_type_Int;
        label104:
        qhl.a().a(paramInt, 1);
      }
    }
    for (;;)
    {
      if (bjxj.i())
      {
        if (!paramBoolean) {
          break label256;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = ors.e();
        int i = ors.jdField_d_of_type_Int;
        sfh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramInt, i);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13(this, l, paramInt, i));
      }
      return;
      if (paramInt == 6)
      {
        ors.f();
        break;
      }
      if (paramInt != 13) {
        break;
      }
      localObject = a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        ors.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      ors.a(-1);
      break;
      label227:
      if (paramInt == 13)
      {
        paramInt = qhl.f;
        break label104;
      }
      paramInt = qhl.e;
      break label104;
      qhl.a().c();
    }
    label256:
    sfh.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14(this));
  }
  
  private static void b(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_kan_dian", true);
    ois.a(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772232, 2130772038);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = ors.a();
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
          localObject3 = ors.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          String str2 = ors.a.jdField_a_of_type_JavaLangString;
          String str3 = ors.g(ors.a.c);
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
            if (!bdee.h(a())) {
              break label960;
            }
            j = 2;
            ((JSONObject)localObject2).put("network_type", j);
            ((JSONObject)localObject2).put("kandian_mode_new", ntd.a());
            if (ors.g != 0) {
              break label966;
            }
            j = 0;
            ((JSONObject)localObject2).put("button_state", j);
            ((JSONObject)localObject2).put("os", 1);
            ((JSONObject)localObject2).put("version", ntd.jdField_a_of_type_JavaLangString);
            if (nwm.a != null) {
              ((JSONObject)localObject2).put("channel_id", nwm.a.mChannelCoverId);
            }
            ors.a(true, (JSONObject)localObject2);
            nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, (String)localObject3, ((JSONObject)localObject2).toString(), false);
            if (localObject1 != null) {
              ors.a(21, str3, (String)localObject3, str2, "", -1);
            }
            if (paramBoolean2)
            {
              szp.a(false);
              localObject1 = (qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
              if ((((qja)localObject1).a() != 1) || (TextUtils.isEmpty(((qja)localObject1).a()))) {
                break label972;
              }
              localObject1 = ((qja)localObject1).a();
              localObject2 = (qiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
              localObject2 = qiu.b(a(), 0);
              localObject3 = new orz();
              localObject1 = ((orz)localObject3).e().f().a((String)localObject1);
              if (i == 1) {
                break label980;
              }
              paramBoolean1 = true;
              localObject1 = ((orz)localObject1).a(paramBoolean1);
              if (ors.g != 0) {
                break label985;
              }
              paramBoolean1 = true;
              ((orz)localObject1).b(paramBoolean1);
              localObject1 = a();
              if ((localObject1 != null) && (((ReadInJoyBaseFragment)localObject1).a() == 0))
              {
                if ((localObject2 == null) || (!((RefreshData)localObject2).isAD)) {
                  break label990;
                }
                i = 1;
                ((orz)localObject3).a("ad_page", i);
              }
              nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, ((orz)localObject3).a(), false);
            }
            if (bdee.h(a())) {
              L();
            }
            if (!bjxj.k()) {
              break label931;
            }
            localObject1 = "recommend_tab_cost";
            syp.a(null, (String)localObject1);
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
        if (ors.a.jdField_a_of_type_Long == 0L)
        {
          l1 = NetConnInfoCenter.getServerTime() - ors.a.jdField_b_of_type_Long;
          l2 = 1L;
          continue;
        }
        long l1 = NetConnInfoCenter.getServerTime() - ors.a.jdField_a_of_type_Long;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(0))
        {
          i = 2;
          ((JSONObject)localObject2).put("reddot", i);
          ((JSONObject)localObject2).put("kandian_mode", ors.e());
          ((JSONObject)localObject2).put("kandian_mode_new", ntd.a());
          localObject1 = (qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);
          if ((((qja)localObject1).a() != 1) || (TextUtils.isEmpty(((qja)localObject1).a()))) {
            break label886;
          }
          localObject1 = ((qja)localObject1).a();
          localObject3 = (qiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
          localObject3 = qiu.b(a(), 0);
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
          nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 1, (String)localObject1, null, null, ((JSONObject)localObject2).toString(), false);
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
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, str1, null, null, ((JSONObject)localObject2).toString(), false);
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
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Rcd != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_Rcd.a(paramInt);
    }
  }
  
  public static boolean c_()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private void n()
  {
    a(2131378118).setBackgroundDrawable(null);
    this.jdField_a_of_type_Set = new set(a(), (ViewGroup)a(2131378118));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131375228));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131375245));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131375226));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131377123));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131375791));
    this.jdField_b_of_type_AndroidViewView = a(2131377903);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131376786));
    D();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131377976));
    this.jdField_d_of_type_AndroidViewView = a(2131376969);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131375303));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131375302));
    label298:
    label306:
    Object localObject;
    if (ors.p())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167192));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167138));
      }
      if (!qok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label634;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (ors.j() != 0) {
        break label646;
      }
      i = 1;
      localObject = a(2131370813);
      if (i == 0) {
        break label651;
      }
    }
    label646:
    label651:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.jdField_g_of_type_AndroidViewView = a(2131375278);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370767));
      i = aekt.a(3.0F, a());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new rwp(this));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131375507));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)a(2131375506));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setOnClickListener(new rwy(this));
      v();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a().getBaseContext(), a(2131371271)).a(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnClickListener(new rxa(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new rxb(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new rxc(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      J_();
      b();
      s();
      r();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131364720);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      if ("2225164739".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setOnLongClickListener(new rxd(this));
      }
      c();
      this.jdField_a_of_type_Qhb = new qhb(new qgy());
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      label634:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label298;
      i = 0;
      break label306;
    }
  }
  
  private void o()
  {
    if ((RIJRedPacketManager.a().c()) && (c_()) && (RIJRedPacketManager.a().e()))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.a(1, false, null);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void q()
  {
    SelectPositionModule localSelectPositionModule = owy.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void r()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_Set);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_Nwm = new nwm(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_Nwm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
  }
  
  private void s()
  {
    t();
  }
  
  private void t()
  {
    if (bjxj.k()) {}
    while (!bjxj.j()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rxe(this));
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new rxf(this));
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
  
  private void u()
  {
    slk localslk;
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      localslk = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localslk instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localslk).a != null))
      {
        localObject1 = (VideoInfo.EntranceDownloadInfo)localslk;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        rdm.a(a(), ((VideoInfo.EntranceDownloadInfo)localObject1).a);
        if (this.jdField_a_of_type_Rcd != null)
        {
          localObject2 = this.jdField_a_of_type_Rcd;
          rcd.b((slk)localObject1);
          this.jdField_a_of_type_Rcd.a();
        }
      }
    }
    for (;;)
    {
      if (ors.r()) {
        a(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
      }
      return;
      if ((localslk instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
      {
        localObject2 = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localslk).c;
        QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo jumpSchema " + (String)localObject2);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localslk).jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ors.a(a(), (String)localObject1);
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
          ors.a(a(), RecommendFeedsDiandianEntranceManager.a(i));
        }
      }
    }
  }
  
  private void v()
  {
    BaseActivity localBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131372976);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297190);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new rwo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    boolean bool = bjxj.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    switch (bjxj.e())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_Rcd = new rcd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localBaseActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "is show video entrance button: " + bool);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848838));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130848806));
    }
  }
  
  private void w()
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
  
  private void x()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = bdiv.e((Context)localObject1);
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
        if ((bdiv.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (bjxj.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          bdiv.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = bcwh.a((Context)localObject1, 12.0F);
          int j = bcwh.a((Context)localObject1, 9.0F);
          rmf localrmf = new rmf((Context)localObject1);
          this.jdField_a_of_type_Rmf = localrmf;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localrmf.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131719121));
          localrmf.setAnimationStyle(2131755821);
          localrmf.b(-16777216);
          localrmf.setSoftInputMode(1);
          localrmf.setInputMethodMode(2);
          localrmf.a(localrmf.b() / 2 - bcwh.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = azgq.jdField_a_of_type_Int;
          j = bcwh.a((Context)localObject1, 15.0F);
          int k = localrmf.b();
          int m = localObject2[1];
          int n = localrmf.a();
          int i1 = localrmf.c();
          int i2 = bcwh.a((Context)localObject1, 5.0F);
          localrmf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.12(this), 3000L);
          nrt.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new ron(null, null, null, null).a().a(), false);
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
  
  private void y()
  {
    if (this.jdField_a_of_type_Rmf != null) {
      this.jdField_a_of_type_Rmf.dismiss();
    }
  }
  
  private void z()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131375286)).inflate();
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
            this.jdField_f_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560084, null);
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
    Drawable localDrawable = a().getDrawable(2130842543);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842463);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842460);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166797, 2131166798, 2131166796);
      localDrawable.setColorFilter(a().getColor(2131165307), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
    }
    for (;;)
    {
      z();
      c(true);
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      oxb.a().g();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849503);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840088);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849463);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166898, 2131166898, 2131166898);
      localDrawable.setColorFilter(a().getColor(2131166898), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.jdField_g_of_type_AndroidViewView).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
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
      b(false, false);
      return 0;
    }
    b(false, true);
    return 0;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560053, null);
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
    if (this.jdField_a_of_type_Nwm != null)
    {
      localObject = this.jdField_a_of_type_Nwm.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      azmz.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.10(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public RIJRedPacketProgressView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public String a()
  {
    return alpo.a(2131693817);
  }
  
  public void a()
  {
    super.a();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (ors.j() == 0)
    {
      i = 1;
      localObject = a(2131370813);
      if (i == 0) {
        break label147;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      c();
      ((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!qok.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label153;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      K();
      oxb.a().j();
      w();
      RecommendFeedsDiandianEntranceManager.a().b();
      if (this.jdField_a_of_type_Rcd != null) {
        this.jdField_a_of_type_Rcd.d();
      }
      ocx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      return;
      i = 0;
      break;
      label147:
      i = 8;
      break label50;
      label153:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int |= paramInt;
    QLog.d("ReadInJoyTabFrame", 2, "set operation flag : " + paramInt);
    if (paramInt != 1) {
      szp.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog");
    new qgm((ViewGroup)a().getWindow().getDecorView(), BaseApplicationImpl.getContext().getString(2131718911), BaseApplicationImpl.getContext().getString(2131719097), paramInt1, paramInt2, null).a(false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (a() != null) {
      a().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(long paramLong, String paramString1, @Nullable qfz paramqfz, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOpenRedPacketDialog");
    ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
    if (paramqfz == null) {}
    for (paramString1 = new qgk(localViewGroup, paramLong, paramString2, paramString1, paramInt1, paramInt2, paramInt3, null);; paramString1 = new qgo(localViewGroup, paramLong, paramString1, paramqfz, paramString2, paramInt1, paramInt2, paramInt3, null))
    {
      paramString1.a(false);
      return;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = alnq.a() / 16.0F;
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
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showErrorRedPacketDialog, wording = " + paramString1);
    new qgm((ViewGroup)a().getWindow().getDecorView(), paramString1, paramString2, paramInt1, paramInt2, null).a(false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QLog.d("ReadInJoyTabFrame", 1, "showRedPacketDialog");
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((qiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
    oxb.a().j();
  }
  
  public void a(slk paramslk)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramslk);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramslk != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramslk);
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
      y();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("ReadInJoyTabFrame", 1, "haveWallet = " + paramBoolean1 + " hasOpen = " + paramBoolean2);
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      rjg localrjg = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localrjg != null) && (localrjg.a() != null))
      {
        if (localrjg.a().a())
        {
          localrjg.a().i();
          localrjg.a().c();
          return true;
        }
        if (oeh.a(localrjg.a())) {
          localrjg.a().c();
        }
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
        i = 2131375290;
        continue;
        i = 2131375312;
        continue;
        i = 2131375299;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.19(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 13)
    {
      ors.c(6);
      Object localObject = a().getIntent().getExtras();
      if (rpk.a((Bundle)localObject))
      {
        localObject = rpk.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((slk)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((slk)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.32(this), 1000L);
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    b();
  }
  
  public void b(slk paramslk)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramslk);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramslk != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramslk);
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
      t();
      if (this.jdField_a_of_type_Nwm != null) {
        this.jdField_a_of_type_Nwm.e();
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
        if ((bhou.k()) && (bdag.b())) {
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
      if ((bhou.k()) && (!bdag.b()) && (!bdag.d()))
      {
        a().getWindow().getDecorView().setSystemUiVisibility(9216);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-16777216);
      return;
    }
    if ((ImmersiveUtils.a()) && ((!bhou.k()) || (!bdag.b()))) {
      ImmersiveUtils.a(a().getWindow(), false);
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nwm != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (pfg.a() != -1) {
          i = pfg.a();
        }
      }
      this.jdField_a_of_type_Nwm.c(i);
    }
  }
  
  public void e()
  {
    super.e();
    oxb.a().a();
    Object localObject = a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        aaos.a().a((Context)localObject, new aaot());
      }
      n();
      F();
      localObject = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      oxb.a().a(this.jdField_a_of_type_Oxe);
      ocx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      sro.a();
      RIJRedPacketManager.a().e();
      this.jdField_a_of_type_Qhb.a(this);
      return;
      if ((localObject instanceof FragmentActivity)) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)localObject).getSupportFragmentManager();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
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
        break label285;
      }
      c(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = owy.a().a();
        if (localObject != null) {
          ((pga)localObject).a(false);
        }
        ors.i();
      }
      this.jdField_a_of_type_Set.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (((Intent)localObject).hasExtra("arg_channel_cover_id"))
      {
        int i = ((Intent)localObject).getIntExtra("arg_channel_cover_id", 0);
        ((Intent)localObject).getIntExtra("launch_from", 5);
        if (this.jdField_a_of_type_Nwm != null) {
          this.jdField_a_of_type_Nwm.c(i);
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      if (this.jdField_a_of_type_Nwm != null) {
        this.jdField_a_of_type_Nwm.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        q();
        this.jdField_c_of_type_Boolean = true;
      }
      if (jdField_b_of_type_Boolean) {
        ors.b(true);
      }
      owy.a().r();
      if (((Boolean)bjxj.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        bjxj.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      o();
      M();
      return;
      label285:
      if (this.jdField_a_of_type_Rcd != null)
      {
        localObject = this.jdField_a_of_type_Rcd;
        rcd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      }
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      svt.a();
    }
    for (;;)
    {
      jdField_b_of_type_Boolean = paramBoolean;
      c(paramBoolean);
      azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      int m = a().getIntent().getIntExtra("launch_from", 5);
      a(paramBoolean, m);
      long l1 = NetConnInfoCenter.getServerTime();
      long l2 = ors.a.jdField_a_of_type_Long;
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      int i;
      Object localObject1;
      if ((paramBoolean) && ((localKandianMergeManager.b()) || (localKandianMergeManager.f() > 0)))
      {
        i = 0;
        if (m == 6)
        {
          i = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
          localObject1 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject1).put("source", "304");
        ((JSONObject)localObject1).put("style", 0);
        nrt.a(null, "", "0X8009B94", "0X8009B94", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
        if ((i == 0) || (i == pfg.a())) {
          d(false);
        }
        QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + i);
        ((ocq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(307)).a(a());
        localObject1 = a();
        if (localObject1 != null)
        {
          if (paramBoolean)
          {
            nwm.a(((ReadInJoyBaseFragment)localObject1).a(), 0);
            ((ReadInJoyBaseFragment)localObject1).a(false, a(), null);
          }
        }
        else
        {
          if (!paramBoolean) {
            break label780;
          }
          piy.a();
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          this.jdField_e_of_type_Long = 0L;
          this.jdField_b_of_type_Int = 0;
          szp.b();
          b(m);
          bjxj.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          oxi.c();
          ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.17(this));
          long l3 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          ors.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (!bjxj.j()) {
            break label760;
          }
          ors.d(6);
          rlb.a().a(a());
          int k = 0;
          int j = 0;
          i = k;
          if (a() == null) {
            break label1120;
          }
          i = k;
          if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
            break label1120;
          }
          long l4 = bjxj.g(ors.a());
          i = j;
          if (l3 >= l4)
          {
            i = j;
            if (this.jdField_a_of_type_Long != 0L)
            {
              this.jdField_d_of_type_Boolean = true;
              i = 1;
              oxb.a().m();
              QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l3, ", timeLimit = ", Long.valueOf(l4) });
            }
          }
          if (!azwu.a()) {
            break label1120;
          }
          i = 1;
          bool = true;
          if (i != 0) {
            d(bool);
          }
          RecommendFeedsDiandianEntranceManager.a().a();
          if (rxz.a() != 8) {
            rxz.a(5);
          }
          rya.a().a(false);
          if ((localKandianMergeManager.i()) && (System.currentTimeMillis() - this.jdField_f_of_type_Long > 180000L))
          {
            qzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
            this.jdField_f_of_type_Long = System.currentTimeMillis();
          }
          i = 2;
          if ((m != 9) && (m != 6)) {
            break label767;
          }
          i = 5;
          szp.a(i, true, l1 - l2, ors.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          ThreadManager.getFileThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20000L);
          oek.a().a(0);
          if (ors.x()) {
            F();
          }
          pdy.a();
          if (this.jdField_a_of_type_Nwm != null) {
            this.jdField_a_of_type_Nwm.a(paramBoolean);
          }
          oxb.a().d(paramBoolean);
          if ((paramBoolean) && (!e())) {
            C();
          }
          o();
          QLog.d("Q.readinjoy.4tab", 2, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + m);
          M();
          return;
          svt.b();
        }
      }
      catch (Exception localException)
      {
        label780:
        label1120:
        for (;;)
        {
          boolean bool;
          continue;
          localException.g();
          continue;
          label760:
          ors.d(3);
          continue;
          label767:
          if (m == 13)
          {
            i = 6;
            continue;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            RecommendFeedsDiandianEntranceManager.a().a(this.jdField_a_of_type_Long);
            if (this.jdField_e_of_type_Long != 0L) {}
            Object localObject2;
            for (this.jdField_e_of_type_Long += this.jdField_a_of_type_Long - this.jdField_c_of_type_Long;; this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long))
            {
              i = 0;
              while (i < 1)
              {
                localObject2 = a();
                if (localObject2 != null) {
                  ((ReadInJoyBaseFragment)localObject2).i();
                }
                i += 1;
              }
            }
            localKandianMergeManager.o();
            l1 = this.jdField_a_of_type_Long - this.jdField_b_of_type_Long;
            if (l1 > 0L) {
              ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.18(this, l1));
            }
            qzi.a();
            qzi.a().b();
            rlb.a().b(a());
            rlb.a().a(false, "readInjoy doOnPause");
            i = 2;
            if ((m == 9) || (m == 6)) {
              i = 5;
            }
            for (;;)
            {
              szp.a(i, false, this.jdField_b_of_type_Long, ors.a.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              a().getIntent().removeExtra("launch_from");
              localObject2 = (oxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
              if ((localObject2 != null) && (((oxd)localObject2).a() != null))
              {
                localObject2 = ((oxd)localObject2).a().a();
                if (localObject2 != null) {
                  ((ReadInJoyUserInfoModule)localObject2).b();
                }
              }
              ors.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              ors.c();
              orc.a();
              if (bhou.k()) {
                a().getWindow().getDecorView().setSystemUiVisibility(1024);
              }
              azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
              ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
              oek.a().a(4);
              localKandianMergeManager.p();
              break;
              if (m == 13) {
                i = 6;
              }
            }
            bool = false;
          }
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.b() != this) {
      E();
    }
    jdField_a_of_type_Boolean = false;
    y();
    ApngImage.pauseByTag(8);
    owy.n();
    this.jdField_a_of_type_Set.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_Nwm != null) {
      this.jdField_a_of_type_Nwm.c();
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l2 = this.jdField_e_of_type_Long;
    long l3 = this.jdField_d_of_type_Long;
    if (this.jdField_c_of_type_Long > 0L) {}
    for (long l1 = this.jdField_c_of_type_Long;; l1 = this.jdField_b_of_type_Long)
    {
      this.jdField_e_of_type_Long = (l3 - l1 + l2);
      rlb.a().a(false, "readInjoy onStop");
      return;
    }
  }
  
  public void i()
  {
    QLog.d("ReadInJoyTabFrame", 1, "dismissRedPacketDialog");
  }
  
  public void j()
  {
    QLog.d("ReadInJoyTabFrame", 1, "showOtherPopupView");
  }
  
  public void k()
  {
    super.k();
    ((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    oxb.a().b(this.jdField_a_of_type_Oxe);
    this.jdField_a_of_type_Set.c();
    if (this.jdField_a_of_type_Nwm != null)
    {
      this.jdField_a_of_type_Nwm.d();
      this.jdField_a_of_type_Nwm = null;
    }
    if (this.jdField_a_of_type_Rcd != null) {
      this.jdField_a_of_type_Rcd.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    jdField_b_of_type_Boolean = false;
    oki.a().a();
    bjxs.a().a();
    KandianVideoUploadService.a(null);
    oek.a().jdField_a_of_type_Boolean = true;
    RecommendFeedsDiandianEntranceManager.a().b(this);
    qhl.a().c();
    this.jdField_a_of_type_Qhb.a();
  }
  
  public void l()
  {
    b(true, true);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    if (bjxj.j()) {
      nrt.a(null, "", "0X8008B65", "0X8008B65", 0, 0, "", "", "", ntd.a(null), false);
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */