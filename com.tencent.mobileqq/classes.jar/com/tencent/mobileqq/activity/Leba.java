package com.tencent.mobileqq.activity;

import aabg;
import abkd;
import abke;
import abkf;
import abkg;
import abkh;
import abki;
import abkj;
import abkk;
import abkl;
import abkm;
import abkn;
import abko;
import abkp;
import abkq;
import abkr;
import abku;
import abkx;
import ablb;
import abxm;
import agby;
import agcc;
import ajto;
import ajwk;
import ajxj;
import ajya;
import ajzm;
import ajzo;
import akdn;
import akuc;
import amnj;
import amnn;
import amnr;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anec;
import aoez;
import aqyf;
import arpn;
import arpo;
import arps;
import arpt;
import arpv;
import arqf;
import arqg;
import asbh;
import askp;
import aszf;
import aszi;
import aszk;
import atau;
import atbi;
import atbr;
import atxd;
import atzn;
import atzo;
import atzq;
import avps;
import awvx;
import axbv;
import axcj;
import axmv;
import axpz;
import axqy;
import axrc;
import axrn;
import axrv;
import axtj;
import baww;
import bbdv;
import bbeg;
import bbex;
import bbkb;
import bbqd;
import bbrd;
import bcji;
import bdij;
import bfnk;
import bfnp;
import bfnx;
import bfos;
import bfwr;
import bhem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import mxn;
import mxu;
import nde;
import nrf;
import org.json.JSONException;
import org.json.JSONObject;
import osx;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import tfz;
import ved;
import vei;

public class Leba
  extends ajwk
  implements abkx, agcc, View.OnClickListener, ViewStub.OnInflateListener, arpv, bfos
{
  public static int a;
  static long jdField_b_of_type_Long;
  private static List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  protected final long a;
  private ablb jdField_a_of_type_Ablb;
  private ajto jdField_a_of_type_Ajto = new abkq(this);
  ajxj jdField_a_of_type_Ajxj = new abko(this);
  private akdn jdField_a_of_type_Akdn = new abkn(this);
  private akuc jdField_a_of_type_Akuc = new abkm(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abke(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoez jdField_a_of_type_Aoez = new abkr(this);
  private aqyf jdField_a_of_type_Aqyf = new aqyf("qzone_leba", "com.tencent.mobileqq:qzone");
  private arpo jdField_a_of_type_Arpo;
  private arps jdField_a_of_type_Arps;
  aszk jdField_a_of_type_Aszk = new abkp(this);
  private atzn jdField_a_of_type_Atzn = new abkl(this);
  private atzo jdField_a_of_type_Atzo = new abkk(this);
  private atzq jdField_a_of_type_Atzq = new abkj(this);
  public bfnk a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new abkd(this);
  FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  protected TimerTaskManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private Runnable jdField_a_of_type_JavaLangRunnable = new Leba.1(this);
  protected final String a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageSwitcher jdField_b_of_type_AndroidWidgetImageSwitcher;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private aqyf jdField_b_of_type_Aqyf = new aqyf("web_leba", "com.tencent.mobileqq:tool");
  private List<anec> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h = true;
  
  static
  {
    jdField_c_of_type_JavaUtilList.add("jiankang.qq.com");
    jdField_c_of_type_JavaUtilList.add("guahao.com");
    jdField_c_of_type_JavaUtilList.add("91160.com");
    jdField_d_of_type_JavaUtilList.add("m.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("web.gamecenter.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_d_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_d_of_type_JavaUtilList.add("youxi.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("cdn.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("comic.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("reader.sh.vip.qq.com");
    jdField_e_of_type_JavaUtilList.add("ac.tc.qq.com");
    jdField_e_of_type_JavaUtilList.add("img-qq.ac.qq.com");
  }
  
  public Leba()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = asbh.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bfnk = new bfnk(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void C()
  {
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(81), Integer.valueOf(1), Integer.valueOf(6), "nearbyClick1", null }, null);
    }
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - jdField_b_of_type_Long);
    if ((l2 >= 0L) && (l2 < 2000L)) {
      return;
    }
    jdField_b_of_type_Long = l1;
    Object localObject3 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject2 = ((avps)localObject3).a(String.valueOf(100510));
    ((atxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).a(100510);
    agby.jdField_a_of_type_Int |= 0x1;
    Object localObject1 = ((avps)localObject3).a("100510.100517");
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.has()) {}
    int i;
    for (localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + (String)localObject1);
      }
      if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.has()) || (!((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.has())) {
        break label1066;
      }
      Object localObject4 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label1066;
      }
      localObject4 = ((List)localObject4).iterator();
      for (i = 2; ((Iterator)localObject4).hasNext(); i = 1) {
        if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject4).next()).red_type.get() != 3) {
          break label1063;
        }
      }
    }
    for (;;)
    {
      ((avps)localObject3).b("100510.100517");
      localObject3 = (mxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(43);
      ((mxn)localObject3).a(60);
      ((mxn)localObject3).a(59);
      localObject3 = (mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
      if ((((mxu)localObject3).a()) && (this.jdField_c_of_type_Int != 0)) {
        ThreadManagerV2.excute(new Leba.21(this, (aszf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      }
      ((mxu)localObject3).a(false);
      int j;
      boolean bool;
      if (this.jdField_a_of_type_Arps == null)
      {
        j = -1;
        this.jdField_a_of_type_Bfnk.post(new Leba.22(this));
        ThreadManagerV2.excute(new Leba.23(this, (aszf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        if ((!((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1)) {
          break label1057;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        axqy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          atbr.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        atau.b(0);
        if (!atbi.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          localObject2 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          if ((j == 56) || (j == 57)) {
            ((Intent)localObject2).putExtra("nearby_main_init_tab", 1);
          }
          NearbyFakeActivity.a(a(), (Intent)localObject2);
          label695:
          if (j != 59) {
            break label893;
          }
          new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_clk_red").a();
        }
        for (;;)
        {
          aszi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
          if (bool) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          osx.a().a("FuJin", bool);
          return;
          j = this.jdField_a_of_type_Arps.a();
          break;
          localObject2 = new Intent(a(), NearbyGuideActivity.class);
          ((Intent)localObject2).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject2).putExtra("FROM_WHERE", 0);
          ((Intent)localObject2).putExtra("RANK_BANNER_PUSH", (String)localObject1);
          ((Intent)localObject2).putExtra("NEARBY_IS_HAS_ICON", i);
          a().startActivity((Intent)localObject2);
          break label695;
          label893:
          if (j == 60)
          {
            localObject1 = ((mxu)localObject3).a(60);
            if ((localObject1 != null) && (((oidb_0x791.RedDotInfo)localObject1).uint64_cmd_uin.get() == 1822701914L)) {
              new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_clk_red").a();
            } else {
              new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_clk_red").a();
            }
          }
          else if (j == 61)
          {
            new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_clk_red").a();
          }
        }
        label1057:
        bool = false;
      }
      label1063:
      break;
      label1066:
      i = 2;
    }
  }
  
  private void D()
  {
    if ((a() != null) && (a().app != null))
    {
      askp localaskp = (askp)a().app.getManager(10);
      if (localaskp != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localaskp.a(3);
        }
        localaskp.a(false);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void E()
  {
    agby.a().jdField_a_of_type_Boolean = true;
    ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("100600");
    a(new Intent(a(), LebaListMgrActivity.class));
  }
  
  private void F()
  {
    G();
    this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1134006, 200L);
    H();
    if ((this.jdField_a_of_type_Arps != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Arps.b();
    }
  }
  
  private void G()
  {
    ThreadManager.post(new Leba.34(this), 5, null, false);
  }
  
  private void H()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a("100600");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(10).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void I()
  {
    Object localObject = (mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((mxu)localObject).a(1);
      if (localRedDotInfo != null) {
        mxn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((mxu)localObject).a(6);
      if (localObject != null) {
        mxn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.gamecenter.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.music");
    this.jdField_a_of_type_JavaUtilSet.add("com.qq.yijianfankui");
    this.jdField_a_of_type_JavaUtilSet.add("com.life.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.citylife.android");
    this.jdField_a_of_type_JavaUtilSet.add("com.tx.android.txnews.new2");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.Health");
    this.jdField_a_of_type_JavaUtilSet.add("com.android.ketang");
    this.jdField_a_of_type_JavaUtilSet.add("com.tencent.zhibojian");
    this.jdField_a_of_type_JavaUtilSet.add("qzone_feedlist");
  }
  
  private void K()
  {
    arqf localarqf = new arqf();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    for (boolean bool = true;; bool = false)
    {
      localarqf.jdField_a_of_type_Boolean = bool;
      localarqf.jdField_a_of_type_Long = 10000L;
      localarqf.jdField_a_of_type_Int = 0;
      localarqf.jdField_b_of_type_Int = a();
      a(localarqf);
      return;
    }
  }
  
  private int a()
  {
    int j = 0;
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 1;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          return 2;
        }
        i = j;
      } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
      i = j;
    } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
    return 3;
  }
  
  private anec a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        anec localanec = (anec)localIterator.next();
        if ((localanec != null) && (localanec.a != null) && (localanec.a.strPkgName != null) && (localanec.a.strResName != null) && ((localanec.a.strPkgName.equals("com.tx.gamecenter.android")) || (localanec.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692923))))) {
          return localanec;
        }
      }
    }
    return null;
  }
  
  private void a(arqf paramarqf)
  {
    if (paramarqf == null)
    {
      QLog.i("Q.lebatab.leba", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("Q.lebatab.leba", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b", new Object[] { Long.valueOf(paramarqf.jdField_a_of_type_Long), Integer.valueOf(paramarqf.jdField_a_of_type_Int), Integer.valueOf(paramarqf.jdField_b_of_type_Int), Boolean.valueOf(paramarqf.jdField_a_of_type_Boolean) }));
    if (paramarqf.jdField_a_of_type_Boolean)
    {
      axtj localaxtj = arqg.a("plugin_clk");
      localaxtj.jdField_a_of_type_JavaLangString = String.valueOf(paramarqf.jdField_a_of_type_Long);
      localaxtj.c = String.valueOf(paramarqf.jdField_a_of_type_Int);
      localaxtj.d = String.valueOf(paramarqf.jdField_b_of_type_Int);
      axpz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaxtj);
      return;
    }
    axqy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramarqf.jdField_a_of_type_Long), String.valueOf(paramarqf.jdField_a_of_type_Int), String.valueOf(paramarqf.jdField_b_of_type_Int), "");
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private String b()
  {
    Object localObject2 = bbqd.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((anec)localObject3).a == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((anec)localObject3).a.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bbeg)localObject3).b("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
        }
      }
      return localObject2;
    }
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393";
  }
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    t();
    int i = arqg.a(paramBoolean, paramRedTypeInfo);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(i), "");
    paramRedTypeInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    LebaPluginInfo localLebaPluginInfo;
    if (paramRedTypeInfo != null)
    {
      i = 0;
      if (i < paramRedTypeInfo.size())
      {
        localLebaPluginInfo = (LebaPluginInfo)paramRedTypeInfo.get(i);
        if (localLebaPluginInfo == null) {}
        while ((TextUtils.isEmpty(localLebaPluginInfo.strPkgName)) || (!localLebaPluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localLebaPluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new Leba.7(this, l), null, false);
      r();
      return;
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadWebProcess");
    }
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localWebProcessManager == null) {
      return;
    }
    if (localWebProcessManager.d()) {
      localWebProcessManager.a(202);
    }
    u();
  }
  
  private void u()
  {
    ThreadManager.executeOnSubThread(new Leba.8(this));
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter");
    }
    if (!SonicPreloader.isWifiOrG3OrG4())
    {
      QLog.d("Q.lebatab.leba", 1, "preloadForGameCenter, net type not match, abort");
      return;
    }
    String str = b();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("Q.lebatab.leba", 1, "preloadForGameCenter, gameCenterUrl null");
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = a();
    if ((localObject1 != null) && (((anec)localObject1).a != null)) {}
    for (long l1 = ((anec)localObject1).a.uiResId;; l1 = 489L)
    {
      localObject1 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      Object localObject2 = ((avps)localObject1).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject1).a(String.valueOf(l1));
      Object localObject3 = SonicPreloader.getSonicPreloadDataList((BusinessInfoCheckUpdate.AppInfo)localObject2, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(localAppInfo, 1002);
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
      {
        i = 0;
        if (i < ((SparseArray)localObject3).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject3).valueAt(i);
          if (localSonicPreloadData.id != 1002) {
            break label370;
          }
          localSonicPreloadData.url = str;
          ((ArrayList)localObject2).add(localSonicPreloadData);
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject3 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject3).url = str;
        localArrayList.add(localObject3);
      }
      localObject3 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject3).a((ArrayList)localObject2)) {
        ((avps)localObject1).b(String.valueOf("200010.200011"));
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if (((WebProcessManager)localObject3).a(localArrayList)) {
          localAppInfo.preload_ts.set(System.currentTimeMillis());
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label427;
        }
        QLog.d("Q.lebatab.leba", 2, "preloadForGameCenter cost:" + (System.currentTimeMillis() - l2));
        return;
        label370:
        i += 1;
        break;
        QLog.d("Q.lebatab.leba", 1, new Object[] { "preload for gamecenter, gameCenterUrl=", str });
        localArrayList.add(new SonicPreloadData(0, str, true, 0L, 1));
        ((WebProcessManager)localObject3).a(localArrayList);
      }
      label427:
      break;
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131377439));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377369));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131375329));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369088));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131368472));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131720039);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368441));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (axmv.a()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).a(53).d(10).a();
    H();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849032);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166851));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atzq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atzo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atzn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akuc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akdn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aszk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoez);
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369090));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369081));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130849142));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      Object localObject;
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131560813, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131374125);
        localObject = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369144);
        if ((localObject instanceof ThemeImageView)) {
          ((ThemeImageView)localObject).setMaskShape(bfwr.jdField_c_of_type_Int);
        }
        ((ImageView)localObject).setImageResource(2130844489);
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839132);
        ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369145)).setText(2131720031);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374127));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374171));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374331));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374666));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131374128));
        this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new abkf(this));
        this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374140));
        this.jdField_b_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131374129));
        this.jdField_b_of_type_AndroidWidgetImageSwitcher.setFactory(new abkg(this));
        this.jdField_a_of_type_Ablb = new ablb(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_b_of_type_AndroidWidgetImageSwitcher, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Bfnk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375493));
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369080));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365763));
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        baww.a(this.jdField_a_of_type_AndroidWidgetEditText, a(2131691158));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378337));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363479));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.g = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
        k();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new abkh(this));
        if (AppSetting.jdField_d_of_type_Boolean) {
          baww.b(this.jdField_b_of_type_AndroidViewView);
        }
        ajya.a(2131720031);
        baww.b(this.jdField_c_of_type_AndroidViewView, Button.class.getName());
      }
      if (this.jdField_a_of_type_Arps != null)
      {
        localObject = new arpt();
        ((arpt)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((arpt)localObject).jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
        ((arpt)localObject).jdField_a_of_type_AndroidContentContext = a();
        ((arpt)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        ((arpt)localObject).jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        ((arpt)localObject).jdField_a_of_type_Arpv = this;
        this.jdField_a_of_type_Arps.a((arpt)localObject);
      }
      if (this.jdField_a_of_type_Arpo == null)
      {
        this.jdField_a_of_type_Arpo = new arpo(a());
        this.jdField_a_of_type_Arpo.a(this.jdField_a_of_type_AndroidViewView);
        int i = a().getTitleBarHeight();
        int j = (int)bbdv.a(a(), 5.0F);
        this.jdField_a_of_type_Arpo.b();
        this.jdField_a_of_type_Arpo.a(i - j);
      }
      o();
    }
  }
  
  protected Intent a(Class<?> paramClass)
  {
    return new Intent(a(), paramClass);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559187, null);
    this.jdField_a_of_type_Arps = new arps();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public String a()
  {
    return ajya.a(2131706009);
  }
  
  public void a()
  {
    super.a();
    k();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_Ablb != null) {
      this.jdField_a_of_type_Ablb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    agby.a().a();
    F();
    if (this.jdField_a_of_type_Arpo != null) {
      this.jdField_a_of_type_Arpo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onIconDownload, status=" + paramInt + ", url=" + paramString);
    }
    if ((paramInt != 2) || (paramDrawable == null) || (paramVarArgs == null) || (paramVarArgs.length < 1)) {}
    while ((paramVarArgs[0] == null) || (!(paramVarArgs[0] instanceof Integer))) {
      return;
    }
    ((Integer)paramVarArgs[0]).intValue();
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      nrf localnrf = (nrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = bfnx.a(str2, "code", paramMessage.auth_code.get());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", str3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.i("AuthCode", 2, "newUrl:" + str3);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          a(str2);
          if (localnrf != null) {
            localnrf.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localnrf != null) {
            localnrf.a(134246777, null, "not_jump", str1, "", 0L, false);
          }
          this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp = paramMessage;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
        return;
      }
      finally
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (localnrf != null) {
            localnrf.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, anec paramanec)
  {
    if (c()) {
      ThreadManager.post(new Leba.16(this, paramView, paramanec), 8, null, true);
    }
  }
  
  public void a(View paramView, anec paramanec, arqf paramarqf)
  {
    if ((paramanec == null) || (paramanec.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "onPluginClick item == null || item.info == null");
      return;
    }
    for (;;)
    {
      try
      {
        QLog.i("Q.lebatab.leba", 1, "onPluginClick item = " + paramanec.a.toString());
        a(paramarqf);
        paramarqf = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        if ((paramanec != null) && (paramanec.a != null) && (paramanec.a.uiResId == nde.jdField_a_of_type_Int))
        {
          vei.a("dynamic", "clk_story", 0, ((mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).c(), new String[0]);
          a(paramView, paramanec);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.w("Q.lebatab.leba", 1, "onPluginClick", paramView);
        return;
      }
      if ((paramanec != null) && (paramanec.a != null) && (7719L == paramanec.a.uiResId))
      {
        C();
        paramarqf.a(100510, 31);
        return;
      }
      if ((paramanec != null) && (paramanec.a != null) && (826L == paramanec.a.uiResId))
      {
        c(paramView, paramanec);
        return;
      }
      if ((paramanec != null) && (paramanec.a != null) && (7720L == paramanec.a.uiResId))
      {
        PublicFragmentActivity.a(a(), ExtendFriendFragment.class);
        if ((paramanec.a == null) || (paramanec.a.uiResId <= 0L)) {
          break;
        }
        paramarqf.a((int)paramanec.a.uiResId, 31);
        return;
      }
      if ((paramanec != null) && (paramanec.a != null) && (7759L == paramanec.a.uiResId))
      {
        amnj localamnj = ((amnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
        String str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramarqf = str;
        if (localamnj != null)
        {
          paramarqf = str;
          if (!TextUtils.isEmpty(localamnj.l)) {
            paramarqf = localamnj.l;
          }
        }
        paramanec.a.strGotoUrl = paramarqf;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, anec paramanec)
  {
    if ((paramanec == null) || (paramanec.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    Object localObject1 = paramanec.a.strGotoUrl;
    if ("com.cmshow.game.android".equals(paramanec.a.strPkgName)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0, new String[0]);
    }
    String str1 = paramanec.a.strResName;
    int i = paramanec.a.sResSubType;
    boolean bool3 = false;
    boolean bool1 = false;
    if ((paramView != null) && ((paramView instanceof RedTouch))) {}
    for (boolean bool2 = ((RedTouch)paramView).a();; bool2 = false)
    {
      Object localObject2;
      Object localObject4;
      int j;
      if ((paramanec.a.strPkgName.equals("com.tx.gamecenter.android")) || (paramanec.a.strResName.contains(a(2131692923))))
      {
        paramView = bbqd.a("vipGameCenter");
        if (TextUtils.isEmpty(paramView))
        {
          paramView = paramanec.a.strGotoUrl;
          QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use plugin info url=" + paramView);
          if (!bool2) {
            break label3494;
          }
          localObject2 = "-1";
          localObject4 = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(paramanec.a.uiResId)).missions.get();
          localObject1 = localObject2;
          if (localObject4 == null) {
            break label399;
          }
          localObject1 = localObject2;
          if (((List)localObject4).size() <= 0) {
            break label399;
          }
          localObject1 = "-1";
          j = 0;
          label272:
          if (j >= ((List)localObject4).size()) {
            break label399;
          }
          if (j != 0) {
            break label358;
          }
        }
        label358:
        for (localObject1 = (String)((List)localObject4).get(j);; localObject1 = (String)localObject1 + "_" + (String)((List)localObject4).get(j))
        {
          j += 1;
          break label272;
          if (paramView.startsWith("http")) {
            i = 0;
          }
          for (;;)
          {
            QLog.d("Q.lebatab.leba", 1, "clickAction gamecenter use IndividuationUrl url=" + paramView);
            break;
          }
        }
        label399:
        if (i == 0)
        {
          paramView = paramView + "&missions=" + (String)localObject1;
          label430:
          QLog.i("Q.lebatab.leba", 1, "[dealGameCenterUrl] add redPointId :" + paramView);
        }
      }
      for (;;)
      {
        if (paramBoolean) {
          if (paramanec != null)
          {
            if (paramanec.a.uiResId != 0L) {
              break label3485;
            }
            if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
              break label1117;
            }
            bool1 = true;
          }
        }
        for (;;)
        {
          label497:
          osx.a().b((int)paramanec.a.uiResId, bool1);
          label513:
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str1 + ",url=" + paramView + ",type=" + i);
          }
          avps localavps = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          BusinessInfoCheckUpdate.AppInfo localAppInfo = localavps.a(paramanec.a.uiResId + "");
          if ((paramanec.a != null) && (paramanec.a.uiResId > 0L)) {
            if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
            {
              paramView = bhem.a(paramView, localAppInfo);
              if (localAppInfo.type.get() == 0) {
                bool1 = true;
              }
              if (!paramanec.a.strPkgName.equals("com.tx.gamecenter.android"))
              {
                bool2 = bool1;
                if (!paramanec.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692923))) {}
              }
              else
              {
                bool2 = bool1 | true;
              }
              new ArrayList();
              if ((localAppInfo.red_display_info == null) || (localAppInfo.red_display_info.red_type_info == null)) {
                break label3479;
              }
              localObject1 = localAppInfo.red_display_info.red_type_info.get();
              if ((localObject1 == null) || (((List)localObject1).size() < 2)) {
                break label3479;
              }
            }
          }
          label3090:
          label3479:
          for (j = ((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(1)).red_type.get();; j = 0)
          {
            int k = localAppInfo.num.get();
            localObject1 = "status=" + j + "&number=" + k + "&path=" + localAppInfo.path.get();
            bool1 = bool2;
            label866:
            localObject2 = (axbv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
            if (localObject2 != null) {
              if (((axbv)localObject2).a(paramanec.a.uiResId + "") != -1)
              {
                bool2 = true;
                label923:
                if (!paramBoolean) {
                  break label1247;
                }
                localavps.b(paramanec.a.uiResId + "");
                label958:
                paramBoolean = bool2;
                if (bool2) {
                  a(new Leba.19(this));
                }
              }
            }
            for (paramBoolean = bool2;; paramBoolean = false)
            {
              int m = k;
              bool2 = bool1;
              localObject2 = paramView;
              bool1 = paramBoolean;
              paramBoolean = bool2;
              paramView = (View)localObject1;
              k = j;
              j = m;
              localObject1 = localObject2;
              for (;;)
              {
                if ((localObject1 == null) || ("".equals(localObject1)))
                {
                  a(paramanec, localAppInfo, localavps);
                  return;
                  if (i != 2) {
                    break label3491;
                  }
                  localObject2 = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramView).b("url");
                  paramView = paramView.replace((CharSequence)localObject2, (String)localObject2 + URLEncoder.encode(new StringBuilder().append("&missions=").append((String)localObject1).toString()));
                  break label430;
                  label1117:
                  bool1 = false;
                  break label497;
                  if (paramanec == null) {
                    break label513;
                  }
                  osx.a().b((int)paramanec.a.uiResId, bool2);
                  bool1 = bool3;
                  if ("com.tx.xingqubuluo.android".equals(paramanec.a.strPkgName)) {
                    bool1 = bool2;
                  }
                  if (paramanec.a.uiResId != 7966L) {
                    break label513;
                  }
                  bool1 = bool2;
                  break label513;
                  localObject1 = "status=" + -1 + "&number=0" + "&path=" + paramanec.a.uiResId;
                  k = 0;
                  j = 0;
                  break label866;
                  bool2 = false;
                  break label923;
                  label1247:
                  localavps.a((int)paramanec.a.uiResId, 31);
                  break label958;
                  if ((paramanec.a == null) || (!paramanec.a.strPkgName.equals("qzone_feedlist"))) {
                    break label3450;
                  }
                  localObject1 = (axcj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                  if ((localObject1 == null) || ((((axcj)localObject1).a(2) <= 0) && (((axcj)localObject1).a(1) <= 0))) {
                    break label3450;
                  }
                  k = 0;
                  localObject2 = null;
                  paramBoolean = bool1;
                  bool1 = true;
                  j = 0;
                  localObject1 = paramView;
                  paramView = (View)localObject2;
                  continue;
                }
                String str2 = (String)arpn.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramanec.a.uiResId));
                if (i == 0) {
                  if (!((String)localObject1).contains("plg_uin=1")) {
                    break label3443;
                  }
                }
                label2003:
                label3160:
                label3425:
                label3437:
                label3440:
                label3443:
                for (localObject2 = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; localObject3 = localObject1)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).contains("plg_vkey=1")) {
                    localObject1 = (String)localObject2 + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
                  }
                  localObject4 = a(QQBrowserActivity.class);
                  if (((String)localObject1).contains("plg_nld=1")) {
                    ((Intent)localObject4).putExtra("reportNld", true);
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty(paramView))
                  {
                    ((Intent)localObject4).putExtra("redTouch", paramView);
                    localObject2 = localObject1;
                    if (((String)localObject1).contains("red_touch=1")) {
                      localObject2 = (String)localObject1 + "&" + paramView;
                    }
                  }
                  this.jdField_b_of_type_Aqyf.b();
                  ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  ((Intent)localObject4).putExtra("plugin_start_time", System.nanoTime());
                  ((Intent)localObject4).putExtra("click_start_time", System.currentTimeMillis());
                  ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                  ((Intent)localObject4).putExtra("is_from_leba", true);
                  ((Intent)localObject4).putExtra("leba_resid", paramanec.a.uiResId);
                  ((Intent)localObject4).putExtra("has_red_dot", paramBoolean);
                  ((Intent)localObject4).putExtra("url", (String)localObject2);
                  if (!TextUtils.isEmpty(str2)) {
                    ((Intent)localObject4).putExtra("big_brother_source_key", str2);
                  }
                  if ((paramanec.a.uiResId == 3053L) && (((String)localObject2).indexOf("fetchCode=1") > -1))
                  {
                    long l = NetConnInfoCenter.getServerTime();
                    if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
                      }
                      ((Intent)localObject4).putExtra("url", bfnx.a((String)localObject2, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
                      a((Intent)localObject4);
                      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                      a(paramanec.a.strGotoUrl);
                      paramView = (nrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
                      if (paramView == null) {
                        break;
                      }
                      paramView.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                      return;
                    }
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                    this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject4);
                    a(paramanec.a.strGotoUrl);
                    this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1134007, 1000L);
                    return;
                  }
                  if (paramanec.a.uiResId == 5647L)
                  {
                    if (!((String)localObject2).contains("?"))
                    {
                      paramView = (String)localObject2 + "?hasRedDot=" + paramBoolean;
                      if ((!paramBoolean) || (localAppInfo == null)) {
                        break label3440;
                      }
                      localObject1 = new StringBuilder();
                      localObject2 = localAppInfo.missions.get();
                      if (((List)localObject2).size() <= 0) {
                        break label2112;
                      }
                      i = 0;
                      if (i >= ((List)localObject2).size()) {
                        break label2112;
                      }
                      if (i != ((List)localObject2).size() - 1) {
                        break label2085;
                      }
                      ((StringBuilder)localObject1).append((String)((List)localObject2).get(i));
                    }
                    for (;;)
                    {
                      i += 1;
                      break label2003;
                      paramView = (String)localObject2 + "&hasRedDot=" + paramBoolean;
                      break;
                      ((StringBuilder)localObject1).append((String)((List)localObject2).get(i)).append("_");
                    }
                    paramView = paramView + "&missions=" + ((StringBuilder)localObject1).toString();
                  }
                  for (;;)
                  {
                    ((Intent)localObject4).putExtra("url", paramView);
                    if ("com.cmshow.game.android".equals(paramanec.a.strPkgName))
                    {
                      ((Intent)localObject4).putExtra("fragment_class", CmGameFragment.class.getCanonicalName());
                      ((Intent)localObject4).putExtra("hide_operation_bar", true);
                      ((Intent)localObject4).putExtra("hide_more_button", true);
                      ((Intent)localObject4).putExtra("portraitOnly", true);
                    }
                    a((Intent)localObject4);
                    do
                    {
                      a(paramanec, localAppInfo, localavps);
                      if ((paramanec.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (paramanec.a.strResName.contains(a(2131692923)))) {
                        axrn.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                      }
                      a(new Leba.20(this));
                      if (paramanec.a.strPkgName.equals("qzone_feedlist")) {
                        break;
                      }
                      this.jdField_a_of_type_Boolean = true;
                      return;
                    } while (i != 2);
                    localObject4 = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
                    if (localObject4 != null)
                    {
                      if ((!paramanec.a.strPkgName.equals("com.tx.gamecenter.android")) && (!paramanec.a.strResName.contains(a(2131692923)))) {
                        break label2757;
                      }
                      ((bbeg)localObject4).d("platformId=qq_m");
                      localObject2 = localObject4;
                    }
                    label2557:
                    do
                    {
                      for (;;)
                      {
                        ((bbeg)localObject2).a("from_leba", "fromleba");
                        ((bbeg)localObject2).a("leba_resid", String.valueOf(paramanec.a.uiResId));
                        ((bbeg)localObject2).a("config_res_plugin_item_name", str1);
                        ((bbeg)localObject2).a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                        ((bbeg)localObject2).a(bool1);
                        ((bbeg)localObject2).b(paramanec.a.strPkgName);
                        ((bbeg)localObject2).e(paramView);
                        ((bbeg)localObject2).b(paramBoolean);
                        ((bbeg)localObject2).a(localAppInfo);
                        if (!TextUtils.isEmpty(str2)) {
                          ((bbeg)localObject2).a("download_sourceid", str2);
                        }
                        if ((paramanec.a.uiResId != 8059L) || (!MiniAppLauncher.isMiniAppUrl((String)localObject1))) {
                          break label3425;
                        }
                        MiniAppLauncher.startMiniApp(a(), (String)localObject1, 2050, null);
                        bfnp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramanec, k, j);
                        if (this.jdField_a_of_type_JavaUtilSet.contains(paramanec.a.strPkgName)) {
                          this.jdField_b_of_type_Aqyf.b();
                        }
                        if (!paramanec.a.strPkgName.equals("qzone_feedlist")) {
                          break;
                        }
                        axrv.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        axrv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        this.jdField_a_of_type_Aqyf.b();
                        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
                        paramView = (axcj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
                        if (paramView != null)
                        {
                          if (QLog.isDevelopLevel()) {
                            QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                          }
                          paramView.a(true);
                        }
                        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                        break;
                        if (paramanec.a.strPkgName.equals("com.tx.xingqubuluo.android"))
                        {
                          localObject2 = (mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                          localObject5 = new StringBuffer();
                          i = ((mxu)localObject2).d();
                          if (i > 0) {
                            ((StringBuffer)localObject5).append("redid=" + i);
                          }
                          if (QLog.isDevelopLevel()) {
                            QLog.d("xingqubuluo", 4, "***redid=" + i);
                          }
                          i = ((mxu)localObject2).a();
                          if (i > 0) {
                            if (((StringBuffer)localObject5).length() != 0) {
                              break label3090;
                            }
                          }
                          for (localObject2 = "";; localObject2 = "&rpnumber=" + i)
                          {
                            ((StringBuffer)localObject5).append((String)localObject2);
                            if (QLog.isDevelopLevel()) {
                              QLog.d("xingqubuluo", 4, "***rpnumber=" + i);
                            }
                            try
                            {
                              localObject2 = new JSONObject(localAppInfo.buffer.get());
                              if (localObject2 != null)
                              {
                                localObject2 = ((JSONObject)localObject2).optJSONObject("param");
                                if (localObject2 != null)
                                {
                                  localObject6 = ((JSONObject)localObject2).optJSONObject((String)localAppInfo.missions.get(0));
                                  if (localObject6 != null)
                                  {
                                    localObject2 = ((JSONObject)localObject6).optString("_red_ext_bid");
                                    localObject6 = ((JSONObject)localObject6).optString("_red_ext_pid");
                                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                                      ((StringBuffer)localObject5).append("&bid=").append((String)localObject2);
                                    }
                                    if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                                      ((StringBuffer)localObject5).append("&pid=").append((String)localObject6);
                                    }
                                  }
                                }
                              }
                            }
                            catch (JSONException localJSONException)
                            {
                              for (;;)
                              {
                                localJSONException.printStackTrace();
                              }
                            }
                            localObject2 = localObject4;
                            if (((StringBuffer)localObject5).length() <= 0) {
                              break;
                            }
                            ((bbeg)localObject4).d(((StringBuffer)localObject5).toString());
                            localObject2 = localObject4;
                            break;
                          }
                        }
                        if (!paramanec.a.strPkgName.equals("com.read.android")) {
                          break label3160;
                        }
                        ((bbeg)localObject4).a("ChannelID", "100020");
                        localObject3 = localObject4;
                      }
                      localObject3 = localObject4;
                    } while (paramanec.a.uiResId != nde.jdField_a_of_type_Int);
                    Object localObject6 = (mxu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
                    Object localObject5 = ((mxu)localObject6).a();
                    localObject3 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject3 = localObject5;
                      if (((tfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
                        }
                        localObject3 = ((mxu)localObject6).a(52);
                        if (localObject3 != null) {
                          break label3437;
                        }
                        localObject3 = ((mxu)localObject6).a(35);
                      }
                    }
                    for (;;)
                    {
                      if ((localObject3 != null) && (((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get() == 37))
                      {
                        localObject5 = null;
                        try
                        {
                          localObject6 = new JSONObject(((oidb_0x791.RedDotInfo)localObject3).str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
                          localObject5 = localObject6;
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            ved.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
                            continue;
                            localObject3 = String.valueOf(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get());
                          }
                        }
                        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                          localObject4 = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject5);
                        }
                      }
                      for (;;)
                      {
                        if (localObject3 == null)
                        {
                          localObject3 = "";
                          ((bbeg)localObject4).a("redid", (String)localObject3);
                          ((bbeg)localObject4).a("lebaVersion", "old");
                          localObject3 = localObject4;
                          break;
                        }
                        a((bbeg)localObject3);
                        break label2557;
                      }
                    }
                  }
                }
                label2085:
                label2112:
                label2757:
                label3450:
                k = 0;
                Object localObject3 = null;
                paramBoolean = bool1;
                bool1 = false;
                j = 0;
                localObject1 = paramView;
                paramView = (View)localObject3;
              }
            }
          }
          label3485:
          bool1 = false;
        }
        label3491:
        break label430;
        label3494:
        continue;
        paramView = (View)localObject1;
      }
    }
  }
  
  protected void a(anec paramanec, BusinessInfoCheckUpdate.AppInfo paramAppInfo, avps paramavps)
  {
    if ((paramanec.a != null) && (paramanec.a.uiResId > 0L))
    {
      paramavps = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      String str = String.valueOf(paramanec.a.uiResId);
      if ((paramAppInfo != null) && (paramavps != null) && (paramavps.a(str))) {
        ThreadManager.getFileThreadHandler().post(new Leba.24(this, str, paramAppInfo));
      }
      if (paramanec.a.strPkgName.equals(bcji.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new Leba.25(this), 5, null, false);
      }
      if (paramanec.a.uiResId == 7759L) {
        amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(bbeg parambbeg)
  {
    if (parambbeg != null) {
      parambbeg.c();
    }
  }
  
  void a(String paramString)
  {
    ((bbrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, abku paramabku)
  {
    if (paramabku == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramabku.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.lebatab.leba", 1, paramString, new Object[0]);
      paramabku.a();
      return;
    }
    String str1;
    int i;
    if (paramString.equals(a().getString(2131693744)))
    {
      str1 = a().getString(2131693741);
      paramString = a().getString(2131693746);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        SharedPreferences localSharedPreferences = a().getSharedPreferences("laba_and_qwallet_check_enter", 4);
        if (localSharedPreferences != null)
        {
          String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          str2 = bdij.a("check_app_exemption__" + str2 + "_" + paramString);
          boolean bool = localSharedPreferences.getBoolean(str2, false);
          QLog.i("Q.lebatab.leba", 1, "checkEnterApp..checkKey:" + str2 + ",hasCheck:" + bool + "，checkName：" + paramString);
          if (!bool)
          {
            a(new Leba.37(this, str1, localSharedPreferences, str2, paramabku));
            return;
            if (paramString.equals(a().getString(2131693743)))
            {
              str1 = a().getString(2131693740);
              paramString = a().getString(2131693745);
              i = 1;
              continue;
            }
            if (!paramString.equals(a().getString(2131693742))) {
              break label320;
            }
            str1 = a().getString(2131693739);
            i = 1;
            continue;
          }
        }
      }
      paramabku.a();
      return;
      label320:
      paramString = null;
      str1 = null;
      i = 0;
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onLogout");
    }
  }
  
  public void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    osx.a().a(3, paramBoolean);
    this.jdField_a_of_type_Bfnk.postDelayed(new Leba.9(this, paramBoolean, paramRedTypeInfo), 150L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSwitchOutofLeba");
    }
  }
  
  public void b(View paramView, anec paramanec)
  {
    if ((paramanec == null) || (paramanec.a == null))
    {
      QLog.i("Q.lebatab.leba", 1, "item == null || item.info == null");
      return;
    }
    a(paramanec.a.strResName, new abki(this, paramView, paramanec));
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      y();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bfnk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atzq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atzo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atzn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akuc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akdn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aszk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoez);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.lebatab.leba", 1, "leba fillData->initLebaView exception:" + localException, localException);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bfnk.post(new Leba.2(this));
  }
  
  void c(View paramView, anec paramanec)
  {
    if (paramanec == null) {
      return;
    }
    paramanec.a.strGotoUrl = ajzm.jdField_a_of_type_JavaLangString;
    String str = bbkb.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {
      paramanec.a.strGotoUrl = str.trim();
    }
    if (QLog.isColorLevel()) {
      QLog.i("enterXQBL", 2, "跳转url = " + paramanec.a.strGotoUrl);
    }
    b(paramView, paramanec);
    I();
    axqy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
  }
  
  boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.h;
      if (this.h)
      {
        this.h = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.17(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onResume");
    }
    AbstractGifImage.resumeAll();
    osx.a().c();
    if (this.f)
    {
      ThreadRegulator.a().b(4);
      this.f = false;
    }
    abxm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ablb != null) {
      this.jdField_a_of_type_Ablb.c();
    }
    ThreadManager.post(new Leba.4(this), 5, null, false);
    ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(System.currentTimeMillis());
    if ((!this.jdField_b_of_type_Boolean) || ((agby.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_Bfnk.postDelayed(new Leba.5(this), 100L);
      ThreadManagerV2.excute(new Leba.6(this, (aszf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      H();
      Object localObject;
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691116));
        localObject = a(2131694071);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131694071));
      }
      if (this.jdField_a_of_type_Arps != null) {
        this.jdField_a_of_type_Arps.a();
      }
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.a(true);
      }
      ApngImage.playByTag(4);
      if ((paramBoolean) && (!this.jdField_e_of_type_Boolean) && (a() != null))
      {
        this.jdField_e_of_type_Boolean = true;
        ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      if (agby.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        ajzo.a((List)localObject, agby.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_Arps != null)
          {
            this.jdField_a_of_type_Arps.b();
            F();
          }
        }
        agby.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void e()
  {
    super.e();
    x();
    if (this.jdField_a_of_type_Ablb != null) {
      this.jdField_a_of_type_Ablb.d();
    }
  }
  
  public void f()
  {
    super.f();
    w();
    J();
    ((ViewStub)a(2131376613)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131364545)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void h()
  {
    ApngImage.pauseByTag(4);
    super.h();
    WebProcessManager.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b();
    }
    this.jdField_a_of_type_Aqyf.d();
    this.jdField_b_of_type_Aqyf.d();
    atau.c(0);
    this.jdField_a_of_type_Bfnk.removeMessages(1134010);
    if (this.jdField_a_of_type_Ablb != null) {
      this.jdField_a_of_type_Ablb.b();
    }
    if (this.jdField_a_of_type_Arps != null) {
      this.jdField_a_of_type_Arps.a(a());
    }
    if (this.jdField_a_of_type_Arpo != null) {
      this.jdField_a_of_type_Arpo.c();
    }
    this.jdField_a_of_type_Bfnk.postDelayed(new Leba.3(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "leba.java onPause");
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onStop");
    }
  }
  
  public void j()
  {
    x();
    if (this.jdField_a_of_type_Ablb != null) {
      this.jdField_a_of_type_Ablb.d();
    }
    if (this.jdField_a_of_type_Arpo != null) {
      this.jdField_a_of_type_Arpo.d();
    }
    super.j();
  }
  
  protected void k()
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!awvx.a()) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.10(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202);
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  protected void n()
  {
    Object localObject = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((avps)localObject).a("886.100171");
          i = j;
          if (localAppInfo != null)
          {
            i = j;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = j;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        j = i;
        if (i == -1)
        {
          localObject = ((avps)localObject).a("886.100172");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                j = 2;
              }
            }
          }
        }
        if (j != -1) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + j);
      }
      return;
      j = -1;
      break;
      j = -1;
    }
  }
  
  void o()
  {
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 4, 2130838515, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368441: 
    case 2131368457: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
      E();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HardCoder", 2, "launch qzone");
    }
    jdField_a_of_type_Int = aabg.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootQzone");
    paramView = (anec)agby.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
    QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
    ThreadManager.postImmediately(new Leba.32(this, paramView), null, true);
    K();
    baww.a(this.jdField_c_of_type_AndroidViewView, ajya.a(2131720031));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (this.jdField_d_of_type_Boolean)
      {
        if (paramInt != 0)
        {
          ApngImage.pauseByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
          }
        }
        if (paramInt == 0)
        {
          ApngImage.playByTag(4);
          if (QLog.isColorLevel()) {
            QLog.e("Q.lebatab.leba", 2, "onScrollStateChanged SCROLL_STATE_IDLE");
          }
        }
      }
    } while (this.jdField_a_of_type_Arps == null);
    this.jdField_a_of_type_Arps.a(paramAbsListView, paramInt);
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    o();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      axmv.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(11340002, 0L);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!axmv.a()) {
          break label215;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Arps != null) {
        this.jdField_a_of_type_Arps.c();
      }
      if (this.jdField_a_of_type_Ablb != null) {
        this.jdField_a_of_type_Ablb.e();
      }
      if (this.jdField_a_of_type_Arpo != null) {
        this.jdField_a_of_type_Arpo.f();
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849032);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131166851));
      break;
      label215:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      askp localaskp = (askp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      axcl.jdField_a_of_type_Boolean = true;
      if (localaskp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localaskp.a(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
    if (!e()) {
      B();
    }
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    nrf localnrf;
    do
    {
      return;
      localnrf = (nrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localnrf == null);
    localnrf.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */