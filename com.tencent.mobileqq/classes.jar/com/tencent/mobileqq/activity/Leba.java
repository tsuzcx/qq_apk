package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyObserver;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.util.LyricContext;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.wholepeople.WholePeopleConstant;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import swo;
import swp;
import swq;
import swr;
import sws;
import swt;
import swu;
import swv;
import swx;
import swy;
import swz;
import sxa;
import sxb;
import sxc;
import sxd;
import sxe;
import sxf;
import sxg;
import sxh;
import sxj;
import sxl;
import sxm;
import sxn;
import sxo;
import sxp;
import sxq;
import sxv;
import sxx;
import sxy;
import sxz;
import syb;
import sye;
import syf;
import syg;
import syi;
import syk;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;

public class Leba
  extends Frame
  implements View.OnClickListener, ViewStub.OnInflateListener, LebaIconDownloader.IDownloadListener, CommonLoadingView.OnFirstDrawListener, AbsListView.OnScrollListener
{
  public static boolean a;
  static long jdField_b_of_type_Long;
  private static List jdField_c_of_type_JavaUtilList = new ArrayList();
  private static List jdField_d_of_type_JavaUtilList = new ArrayList();
  private static List jdField_e_of_type_JavaUtilList = new ArrayList();
  private final int jdField_a_of_type_Int = 1;
  protected final long a;
  Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageSwitcher jdField_a_of_type_AndroidWidgetImageSwitcher;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private LebaQZoneFacePlayHelper jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper;
  public LebaListViewAdapter a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new sxy(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new sxm(this);
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new sxl(this);
  UniteSearchObserver jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new swq(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver = new sxj(this);
  public DownloadIconsListener a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new syk(this);
  public FPSXListView a;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("qzone_leba", "com.tencent.mobileqq:qzone");
  protected TimerTaskManager a;
  NearbyEnterUpdateObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver = new sxp(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new sxh(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new sxg(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new sxf(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  public AdapterView.OnItemClickListener a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected final String a;
  public List a;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public MqqHandler a;
  qqshop_code.SRsp jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private PreloadProcHitSession jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_leba", "com.tencent.mobileqq:tool");
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
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
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_JavaLangString = ("mobileMP" + System.currentTimeMillis());
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new syi(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new swp(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new swv(this);
  }
  
  private void A()
  {
    ThreadManager.post(new sxq(this), 5, null, false);
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_d_of_type_AndroidWidgetTextView != null)) {
      ThreadManager.post(new sxv(this), 8, null, true);
    }
  }
  
  private void C()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("100600");
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(10).a().a(localAppInfo);
    a(localAppInfo);
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  private void E()
  {
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localObject != null)
    {
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)localObject).a(1);
      if (localRedDotInfo != null) {
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedDotInfo);
      }
      localObject = ((TroopRedTouchManager)localObject).a(6);
      if (localObject != null) {
        TroopRedTouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (oidb_0x791.RedDotInfo)localObject);
      }
    }
  }
  
  private void F()
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
    this.jdField_a_of_type_JavaUtilSet.add("com.android.campus");
  }
  
  private void G()
  {
    ThreadManager.post(new sxz(this, new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 4)), 5, null, true);
  }
  
  private LebaViewItem a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName != null) && (localLebaViewItem.a.strResName != null) && ((localLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) || (localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131435071))))) {
          return localLebaViewItem;
        }
      }
    }
    return null;
  }
  
  private void a(ImageView paramImageView, int paramInt, Drawable paramDrawable)
  {
    if (paramInt == 1)
    {
      paramImageView.setImageDrawable(LebaIconDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDrawable));
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  private void a(LebaViewItem paramLebaViewItem, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null) || (paramInt == 0) || (paramViewGroup == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "invalid arguments in markNewFeatureUsed");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramLebaViewItem.a.isNew == 0)
        {
          paramLebaViewItem.a.isNew = 1;
          ThreadManager.post(new sxe(this, paramLebaViewItem), 5, null, true);
          try
          {
            paramLebaViewItem = paramViewGroup.findViewById(paramInt);
            if (paramLebaViewItem != null)
            {
              paramLebaViewItem.setVisibility(8);
              return;
            }
          }
          catch (NullPointerException paramLebaViewItem) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "markNewFeatureUsed", paramLebaViewItem);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "SearchProtocol.sCurHomeHotWordIndex = " + SearchProtocol.jdField_a_of_type_Int + ", hotSearchItems = " + paramList);
    }
    Object localObject = a();
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (!((BaseActivity)localObject).isResume())) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramList != null) && (paramList.size() > 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.lebatab.leba", 2, "updateHomeHotWord, hotSearchItems is null or empty");
        return;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((HotWordSearchEntryDataModel.HotSearchItem)((Iterator)localObject).next()).showType == 2) {
            ((Iterator)localObject).remove();
          }
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      if (SearchProtocol.jdField_a_of_type_Int >= paramList.size()) {
        SearchProtocol.jdField_a_of_type_Int = 0;
      }
      localObject = (HotWordSearchEntryDataModel.HotSearchItem)paramList.get(SearchProtocol.jdField_a_of_type_Int);
    } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("大家都在搜:%s", new Object[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject).title }));
    this.jdField_c_of_type_AndroidWidgetTextView.setTag(paramList.get(SearchProtocol.jdField_a_of_type_Int));
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_all_search").c("home_page").d("exp_wording").a(new String[] { ((HotWordSearchEntryDataModel.HotSearchItem)localObject).title }).a();
  }
  
  private String b()
  {
    Object localObject2 = IndividuationUrlHelper.a("vipGameCenter");
    Object localObject1 = localObject2;
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = a();
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((LebaViewItem)localObject3).a == null) {
          break label91;
        }
      }
    }
    label91:
    for (localObject1 = ((LebaViewItem)localObject3).a.strGotoUrl;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((JumpAction)localObject3).a("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject2 = "http://gamecenter.qq.com/front/release/index/index.html";
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
    return "http://gamecenter.qq.com/front/release/index/index.html";
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {}
    try
    {
      paramString = new File(this.jdField_a_of_type_ComTencentImageURLImageView.getContext().getFilesDir(), paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    WebProcessManager.c(true);
    s();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    ResourcePluginInfo localResourcePluginInfo;
    if (localList != null)
    {
      int i = 0;
      if (i < localList.size())
      {
        localResourcePluginInfo = (ResourcePluginInfo)localList.get(i);
        if (localResourcePluginInfo == null) {}
        while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localResourcePluginInfo.uiResId;; l = 0L)
    {
      ThreadManager.postImmediately(new sye(this, l), null, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d();
      q();
      return;
    }
  }
  
  private void s()
  {
    Object localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        if (((WebProcessManager)localObject1).d()) {
          ((WebProcessManager)localObject1).a(202);
        }
      } while (!SonicPreloader.a());
      localObject1 = b();
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    long l2 = System.currentTimeMillis();
    Object localObject2 = a();
    if ((localObject2 != null) && (((LebaViewItem)localObject2).a != null)) {}
    for (long l1 = ((LebaViewItem)localObject2).a.uiResId;; l1 = 489L)
    {
      localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      Object localObject3 = ((RedTouchManager)localObject2).a("200010.200011");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject2).a(String.valueOf(l1));
      Object localObject4 = SonicPreloader.a((BusinessInfoCheckUpdate.AppInfo)localObject3, 0);
      SparseArray localSparseArray = SonicPreloader.a(localAppInfo, 1002);
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localObject4 != null) && (((SparseArray)localObject4).size() > 0)) {
        i = 0;
      }
      for (;;)
      {
        if (i < ((SparseArray)localObject4).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject4).valueAt(i);
          if (localSonicPreloadData.jdField_a_of_type_Int == 1002)
          {
            localSonicPreloadData.jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((ArrayList)localObject3).add(localSonicPreloadData);
          }
        }
        else
        {
          if ((localSparseArray != null) && (localSparseArray.size() > 0))
          {
            localObject4 = (SonicPreloadData)localSparseArray.valueAt(0);
            ((SonicPreloadData)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject1);
            localArrayList.add(localObject4);
          }
          localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          if (((WebProcessManager)localObject1).a((ArrayList)localObject3)) {
            ((RedTouchManager)localObject2).b(String.valueOf("200010.200011"));
          }
          if (((WebProcessManager)localObject1).a(localArrayList)) {
            localAppInfo.preload_ts.set(System.currentTimeMillis());
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.lebatab.leba", 2, "preloadWebProcess parse cost:" + (System.currentTimeMillis() - l2));
          return;
        }
        i += 1;
      }
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131363379));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362594));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131363244));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364870));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131363381));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131433293);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131363428));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433926);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetTextView).a(53).d(10).a();
    C();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845871);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494212));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494212));
  }
  
  private void u()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131364873));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null) {
        break label777;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter = new LebaListViewAdapter(a(), this.jdField_b_of_type_JavaUtilList, 2130968940, 2130968941, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new swr(this));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
        if (this.jdField_b_of_type_AndroidViewView == null)
        {
          this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130970383, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
          this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370314);
          this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370319);
          this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370320);
          this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370322));
          this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370324);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370315));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370318));
          this.jdField_a_of_type_AndroidWidgetImageSwitcher = ((ImageSwitcher)this.jdField_b_of_type_AndroidViewView.findViewById(2131370317));
          this.jdField_a_of_type_AndroidWidgetImageSwitcher.setFactory(new sws(this));
          this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper = new LebaQZoneFacePlayHelper(this.jdField_a_of_type_AndroidWidgetImageSwitcher, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370320));
          this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370323));
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_e_of_type_AndroidViewView).a(53).a(true).d(5).a();
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370328));
          this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370327));
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362840));
          }
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131368322));
          this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131368321).setVisibility(8);
          localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131370344);
          ((View)localObject).setOnClickListener(new swt(this));
          ((View)localObject).setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368735));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131364875));
          this.g = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("has_search_bar", false);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (!this.g) {
            break label802;
          }
        }
      }
    }
    label777:
    label802:
    for (int i = 0;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new swu(this));
      if (AppSetting.jdField_b_of_type_Boolean) {
        AccessibilityUtil.b(this.jdField_b_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
      localObject = this.jdField_c_of_type_AndroidViewView;
      View localView1 = this.jdField_d_of_type_AndroidViewView;
      View localView2 = this.jdField_f_of_type_AndroidViewView;
      AccessibilityUtil.a(new String[] { "好友动态", "附近", "兴趣部落" }, new View[] { localObject, localView1, localView2 });
      AccessibilityUtil.b(this.jdField_c_of_type_AndroidViewView, Button.class.getName());
      AccessibilityUtil.b(this.jdField_d_of_type_AndroidViewView, Button.class.getName());
      AccessibilityUtil.b(this.jdField_f_of_type_AndroidViewView, Button.class.getName());
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      o();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_b_of_type_JavaUtilList);
      break;
    }
  }
  
  private void x()
  {
    if ((a() != null) && (a().app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)a().app.getManager(9);
      if (localQZoneManager != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localQZoneManager.a(3);
        }
        localQZoneManager.a(false);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void y()
  {
    A();
    int i;
    if (NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      long l3 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      long l2 = -1L;
      long l4 = System.currentTimeMillis();
      long l1 = l2;
      if (l3 >= 0L)
      {
        l1 = l2;
        if (l4 >= l3) {
          l1 = l4 - l3;
        }
      }
      if ((l1 >= 0L) && (l1 <= 28800000L))
      {
        i = 2130842670;
        this.jdField_c_of_type_Boolean = true;
        jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134006, 200L);
      B();
      C();
      z();
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      }
      return;
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_Boolean = false;
      i = 2130842669;
    }
  }
  
  private void z()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null) {}
    label146:
    label148:
    do
    {
      return;
      Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = ((TroopRedTouchManager)localObject).a();
      if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (((TroopRedTouchManager)localObject).a())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo3;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo4;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo5;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo6;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo7;
        int i;
        boolean bool;
        if (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localRedTypeInfo2 = ((TroopRedTouchManager)localObject).b();
          localRedTypeInfo3 = ((TroopRedTouchManager)localObject).d();
          localRedTypeInfo4 = ((TroopRedTouchManager)localObject).f();
          localRedTypeInfo5 = ((TroopRedTouchManager)localObject).h();
          localRedTypeInfo6 = ((TroopRedTouchManager)localObject).i();
          localRedTypeInfo7 = ((TroopRedTouchManager)localObject).g();
          localObject = ((TroopRedTouchManager)localObject).j();
          if ((localRedTypeInfo4 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1))) {
            if (localRedTypeInfo4.red_type.get() == 0)
            {
              this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo4);
              i = 1;
              bool = true;
            }
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00899", "grp_lbs", "", "nearby_entry", "exp_red", 0, 0, String.valueOf(i), "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("nearby.redpoint", 2, "leba->updateNearbyRedPoint, needShow, isNewTab=" + bool + ", redType=" + i);
          return;
          if (localRedTypeInfo4.red_type.get() != 5) {
            break label146;
          }
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
          if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
            break label146;
          }
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(localRedTypeInfo4.red_content.get());
          break label146;
          if ((localRedTypeInfo1 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo1);
            i = 2;
            break label148;
          }
          if ((localRedTypeInfo2 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo2);
            i = 3;
            break label148;
          }
          if ((localRedTypeInfo3 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo3);
            i = 4;
            break label148;
          }
          if ((localRedTypeInfo5 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo5);
            i = 5;
            break label148;
          }
          if ((localRedTypeInfo6 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo6);
            i = 6;
            break label148;
          }
          if ((localRedTypeInfo7 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo7);
            i = 7;
            break label148;
          }
          if (localObject != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
            i = 8;
            break label148;
          }
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
          i = 0;
          break label148;
          localRedTypeInfo2 = ((TroopRedTouchManager)localObject).c();
          if (localRedTypeInfo2 != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo2);
            i = 11;
            bool = false;
          }
          else if ((localRedTypeInfo1 != null) && (NearbyConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1001)))
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo1);
            i = 12;
            bool = false;
          }
          else
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
            i = 0;
            bool = false;
          }
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00899", "grp_lbs", "", "nearby_entry", "clk_red", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("nearby.redpoint", 2, "leba->updateNearbyRedPoint, don't needShow");
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969050, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected String a()
  {
    return "动态";
  }
  
  public void a()
  {
    try
    {
      u();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver);
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
  
  public void a(int paramInt)
  {
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
    if (localObject == null) {
      return;
    }
    int i;
    if (((TroopRedTouchManager)localObject).a(7)) {
      i = 7;
    }
    for (;;)
    {
      label30:
      if (paramInt == 0) {}
      for (localObject = "Clk_tribe";; localObject = "exp_tribe")
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "dynamic", (String)localObject, 0, 0, i + "", "", "", "");
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("xingqubuluo", 4, "reportTroopTribe,action=" + (String)localObject + ", appId=" + i);
        return;
        if (((TroopRedTouchManager)localObject).a(6))
        {
          i = 6;
          break label30;
        }
        if (!((TroopRedTouchManager)localObject).a(1)) {
          break label173;
        }
        i = 1;
        break label30;
        if (paramInt != 1) {
          break;
        }
      }
      label173:
      i = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
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
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_ComTencentImageURLImageView.post(new sxx(this, paramInt, paramDrawable));
  }
  
  public void a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessage == null)) {}
    for (;;)
    {
      return;
      EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      String str1 = String.valueOf(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      try
      {
        paramMessage = (qqshop_code.SRsp)paramMessage.obj;
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        String str3 = paramMessage.auth_code.get();
        if (str3 == null) {
          return;
        }
        str3 = URLUtil.a(str2, "code", paramMessage.auth_code.get());
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
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "jump", str1, "hascode", 0L, false);
          }
        }
        for (;;)
        {
          return;
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "not_jump", str1, "", 0L, false);
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
          if (localEcshopReportHandler != null) {
            localEcshopReportHandler.a(134246777, null, "jump", str1, "no_code", 0L, false);
          }
          a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt, LebaViewItem paramLebaViewItem)
  {
    LebaViewItem localLebaViewItem;
    if ((paramInt == -1) && (paramLebaViewItem != null)) {
      localLebaViewItem = paramLebaViewItem;
    }
    for (;;)
    {
      if ((localLebaViewItem == null) || (localLebaViewItem.a == null))
      {
        return;
        if (paramInt >= 0) {
          localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(paramInt);
        }
      }
      else
      {
        Object localObject1 = localLebaViewItem.a.strGotoUrl;
        if ((localLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) || (localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131435071))))
        {
          localObject1 = IndividuationUrlHelper.a("vipGameCenter");
          paramLebaViewItem = (LebaViewItem)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            QLog.d("Q.lebatab.leba", 1, "clickAction use plugin info url");
            paramLebaViewItem = localLebaViewItem.a.strGotoUrl;
          }
          localObject1 = paramLebaViewItem;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.lebatab.leba", 2, "clickAction gamecenter url = " + paramLebaViewItem);
            localObject1 = paramLebaViewItem;
          }
        }
        if ("com.cmshow.game.android".equals(localLebaViewItem.a.strPkgName)) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_tab_game", 0, 0, new String[0]);
        }
        String str = localLebaViewItem.a.strResName;
        int j = localLebaViewItem.a.sResSubType;
        boolean bool3 = false;
        boolean bool4 = false;
        boolean bool1 = false;
        boolean bool2 = bool1;
        if (paramView != null)
        {
          bool2 = bool1;
          if ((paramView instanceof RedTouch)) {
            bool2 = ((RedTouch)paramView).a();
          }
        }
        if (paramInt == -1)
        {
          bool1 = bool4;
          if (localLebaViewItem != null)
          {
            if (localLebaViewItem.a.uiResId != 0L) {
              break label823;
            }
            if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
              break label817;
            }
            bool1 = true;
          }
        }
        for (;;)
        {
          label323:
          ReadinjoySPEventReport.a().b((int)localLebaViewItem.a.uiResId, bool1);
          label340:
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str + ",url=" + (String)localObject1);
          }
          RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
          BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(localLebaViewItem.a.uiResId + "");
          label624:
          Object localObject2;
          if ((localLebaViewItem.a != null) && (localLebaViewItem.a.uiResId > 0L)) {
            if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
            {
              if (localAppInfo.type.get() == 0) {
                bool1 = true;
              }
              new ArrayList();
              int i = 0;
              paramInt = i;
              if (localAppInfo.red_display_info != null)
              {
                paramInt = i;
                if (localAppInfo.red_display_info.red_type_info != null)
                {
                  paramLebaViewItem = localAppInfo.red_display_info.red_type_info.get();
                  paramInt = i;
                  if (paramLebaViewItem != null)
                  {
                    paramInt = i;
                    if (paramLebaViewItem.size() >= 2) {
                      paramInt = ((BusinessInfoCheckUpdate.RedTypeInfo)paramLebaViewItem.get(1)).red_type.get();
                    }
                  }
                }
              }
              paramLebaViewItem = "status=" + paramInt + "&number=" + localAppInfo.num.get() + "&path=" + localAppInfo.path.get();
              localObject2 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
              if (localObject2 == null) {
                break label2653;
              }
              if (((GameCenterManagerImp)localObject2).a(localLebaViewItem.a.uiResId + "") == -1) {
                break label947;
              }
              bool3 = true;
              label682:
              localRedTouchManager.b(localLebaViewItem.a.uiResId + "");
              bool2 = bool3;
              if (bool3)
              {
                a(new swy(this));
                bool2 = bool3;
              }
            }
          }
          for (;;)
          {
            if (localLebaViewItem.a.uiResId == 4086L) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008732", "0X8008732", 0, 0, "", "", "", "");
            }
            if ((localObject1 == null) || ("".equals(localObject1)))
            {
              a(localLebaViewItem, localAppInfo, localRedTouchManager);
              return;
              label817:
              bool1 = false;
              break label323;
              label823:
              if (localLebaViewItem.a.uiResId != 826L) {
                break label2659;
              }
              if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0))
              {
                bool1 = true;
                break label323;
              }
              bool1 = false;
              break label323;
              bool1 = bool4;
              if (localLebaViewItem == null) {
                break label340;
              }
              ReadinjoySPEventReport.a().b((int)localLebaViewItem.a.uiResId, bool2);
              bool1 = bool4;
              break label340;
              paramLebaViewItem = "status=" + -1 + "&number=0" + "&path=" + localLebaViewItem.a.uiResId;
              break label624;
              label947:
              bool3 = false;
              break label682;
              if ((localLebaViewItem.a != null) && (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")))
              {
                paramLebaViewItem = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                bool2 = bool3;
                if (paramLebaViewItem != null) {
                  if (paramLebaViewItem.a(2) <= 0)
                  {
                    bool2 = bool3;
                    if (paramLebaViewItem.a(1) <= 0) {}
                  }
                  else
                  {
                    bool2 = true;
                  }
                }
                paramLebaViewItem = null;
                continue;
              }
              if (localLebaViewItem.a == null) {
                break label2645;
              }
              if (localLebaViewItem.a.isNew == 0) {}
              for (bool2 = true;; bool2 = false)
              {
                paramLebaViewItem = null;
                break;
              }
            }
            if (localLebaViewItem.a.cDataType == 0) {
              a(localLebaViewItem, 2131363702, (ViewGroup)paramView);
            }
            if (j == 0)
            {
              if (((String)localObject1).indexOf("plg_auth=1") > -1) {}
              paramView = (View)localObject1;
              if (((String)localObject1).indexOf("plg_uin=1") > -1) {
                paramView = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              }
              localObject1 = paramView;
              if (paramView.indexOf("plg_vkey=1") > -1) {
                localObject1 = paramView + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
              }
              paramView = new Intent(a(), QQBrowserActivity.class);
              if (((String)localObject1).indexOf("plg_nld=1") > -1) {
                paramView.putExtra("reportNld", true);
              }
              if (!TextUtils.isEmpty(paramLebaViewItem)) {
                paramView.putExtra("redTouch", paramLebaViewItem);
              }
              this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
              paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              paramView.putExtra("plugin_start_time", System.nanoTime());
              paramView.putExtra("click_start_time", System.currentTimeMillis());
              paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
              paramView.putExtra("is_from_leba", true);
              paramView.putExtra("leba_resid", localLebaViewItem.a.uiResId);
              paramView.putExtra("has_red_dot", bool1);
              paramView.putExtra("url", (String)localObject1);
              if ((localLebaViewItem.a.uiResId == 3053L) && (((String)localObject1).indexOf("fetchCode=1") > -1))
              {
                l = NetConnInfoCenter.getServerTime();
                if ((this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp != null) && (this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get() > l))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("AuthCode", 2, "use cache:" + this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.expired_time.get());
                  }
                  paramView.putExtra("url", URLUtil.a((String)localObject1, "code", this.jdField_a_of_type_TencentImOidbQqshopQqshop_code$SRsp.auth_code.get()));
                  a(paramView);
                  this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                  a(localLebaViewItem.a.strGotoUrl);
                  paramView = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
                  if (paramView != null) {
                    paramView.a(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                  }
                }
                for (;;)
                {
                  ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + localLebaViewItem.a.uiResId, "", "", "");
                  return;
                  this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
                  this.jdField_a_of_type_AndroidContentIntent = paramView;
                  a(localLebaViewItem.a.strGotoUrl);
                  this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134007, 1000L);
                }
              }
              a(paramView);
            }
            while (j != 2)
            {
              long l;
              a(localLebaViewItem, localAppInfo, localRedTouchManager);
              if ((localLebaViewItem.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131435071)))) {
                StatisticCollector.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
              }
              a(new swz(this));
              if (localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                break;
              }
              this.jdField_b_of_type_Boolean = true;
              return;
            }
            localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject1);
            if (localObject1 != null)
            {
              if ((!localLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) && (!localLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131435071)))) {
                break label2136;
              }
              ((JumpAction)localObject1).c("platformId=qq_m");
              paramView = (View)localObject1;
            }
            label2136:
            do
            {
              for (;;)
              {
                paramView.a("from_leba", "fromleba");
                paramView.a("leba_resid", String.valueOf(localLebaViewItem.a.uiResId));
                paramView.a("config_res_plugin_item_name", str);
                paramView.a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
                paramView.a(bool2);
                paramView.b(localLebaViewItem.a.strPkgName);
                paramView.d(paramLebaViewItem);
                paramView.b(bool1);
                paramView.a(localAppInfo);
                paramView.b();
                if (this.jdField_a_of_type_JavaUtilSet.contains(localLebaViewItem.a.strPkgName)) {
                  this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
                }
                if (!localLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                StatisticHitRateCollector.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                StatisticHitRateCollector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 2, 0, "", "", "", "");
                paramView = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                if (paramView != null)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.d("Q.unread.", 4, "qq click action and clear active feed unread");
                  }
                  paramView.a(true);
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, "0", "0", "0", "");
                break;
                if (localLebaViewItem.a.strPkgName.equals("com.tx.xingqubuluo.android"))
                {
                  paramView = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
                  localObject2 = new StringBuffer();
                  paramInt = paramView.d();
                  if (paramInt > 0) {
                    ((StringBuffer)localObject2).append("redid=" + paramInt);
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("xingqubuluo", 4, "***redid=" + paramInt);
                  }
                  paramInt = paramView.a();
                  if (paramInt > 0) {
                    if (((StringBuffer)localObject2).length() != 0) {
                      break label2331;
                    }
                  }
                  for (paramView = "";; paramView = "&rpnumber=" + paramInt)
                  {
                    ((StringBuffer)localObject2).append(paramView);
                    if (QLog.isDevelopLevel()) {
                      QLog.d("xingqubuluo", 4, "***rpnumber=" + paramInt);
                    }
                    paramView = (View)localObject1;
                    if (((StringBuffer)localObject2).length() <= 0) {
                      break;
                    }
                    ((JumpAction)localObject1).c(((StringBuffer)localObject2).toString());
                    paramView = (View)localObject1;
                    break;
                  }
                }
                if (!localLebaViewItem.a.strPkgName.equals("com.read.android")) {
                  break label2389;
                }
                ((JumpAction)localObject1).a("ChannelID", "100020");
                paramView = (View)localObject1;
              }
              paramView = (View)localObject1;
            } while (localLebaViewItem.a.uiResId != 3050L);
            label2331:
            label2389:
            Object localObject3 = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
            localObject2 = ((TroopRedTouchManager)localObject3).a();
            paramView = (View)localObject2;
            if (localObject2 == null)
            {
              paramView = (View)localObject2;
              if (((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).jdField_a_of_type_Boolean)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.lebatab.leba", 2, "check invisible red point for msgtab");
                }
                paramView = ((TroopRedTouchManager)localObject3).a(49);
                if (paramView != null) {
                  break label2642;
                }
                paramView = ((TroopRedTouchManager)localObject3).a(35);
              }
            }
            label2642:
            for (;;)
            {
              if ((paramView != null) && (paramView.uint32_appid.get() == 37))
              {
                localObject2 = null;
                try
                {
                  localObject3 = new JSONObject(paramView.str_custom_buffer.get().toStringUtf8()).getString("fake_protocol");
                  localObject2 = localObject3;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    SLog.d("Leba.qqstory.tag", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
                    continue;
                    paramView = String.valueOf(paramView.uint32_appid.get());
                  }
                }
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject2);
                }
              }
              for (;;)
              {
                if (paramView == null)
                {
                  paramView = "";
                  ((JumpAction)localObject1).a("redid", paramView);
                  ((JumpAction)localObject1).a("lebaVersion", "old");
                  paramView = (View)localObject1;
                  break;
                }
              }
            }
            label2645:
            paramLebaViewItem = null;
            bool2 = false;
            continue;
            label2653:
            bool2 = false;
          }
          label2659:
          bool1 = false;
        }
      }
      localLebaViewItem = null;
    }
  }
  
  protected void a(LebaViewItem paramLebaViewItem, BusinessInfoCheckUpdate.AppInfo paramAppInfo, RedTouchManager paramRedTouchManager)
  {
    if ((paramLebaViewItem.a != null) && (paramLebaViewItem.a.uiResId > 0L))
    {
      paramRedTouchManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      String str = String.valueOf(paramLebaViewItem.a.uiResId);
      if ((paramAppInfo != null) && (paramRedTouchManager != null) && (paramRedTouchManager.a(str))) {
        ThreadManager.getFileThreadHandler().post(new sxb(this, str, paramAppInfo));
      }
      if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0) && (paramAppInfo.icon_type.get() == 1)) {
        b(paramAppInfo.icon_url.get());
      }
      if ((paramLebaViewItem.a.strPkgName.equals("com.android.campus")) || (paramLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131438942)))) {
        ThreadManager.post(new sxc(this), 5, null, false);
      }
      if (paramLebaViewItem.a.strPkgName.equals(WholePeopleConstant.jdField_a_of_type_JavaLangString)) {
        ThreadManager.post(new sxd(this), 5, null, false);
      }
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramLebaViewItem.a.uiResId, "", "", "");
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (paramInt != 0) {
        ApngImage.pauseByTag(4);
      }
    } while (paramInt != 0);
    ApngImage.playByTag(4);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  void a(String paramString)
  {
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).c(paramString);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    AbstractGifImage.resumeAll();
    ReadinjoySPEventReport.a().c();
    if (this.jdField_f_of_type_Boolean)
    {
      ThreadRegulator.a().b(4);
      this.jdField_f_of_type_Boolean = false;
    }
    QZoneEntryReporterInLeba.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.c();
    }
    ThreadManager.post(new sxn(this), 5, null, false);
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
    if ((!this.jdField_d_of_type_Boolean) || ((LebaShowListManager.jdField_a_of_type_Int & 0x4) != 0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.c(true);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new syb(this), 100L);
      if (jdField_a_of_type_Boolean != this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = jdField_a_of_type_Boolean;
        int i = 2130842669;
        if (jdField_a_of_type_Boolean) {
          i = 2130842670;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      C();
      Object localObject;
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(a(2131427463));
        localObject = a(2131433272);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131433272));
      }
      ApngImage.playByTag(4);
      return;
      if (LebaShowListManager.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            y();
          }
        }
        LebaShowListManager.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void b()
  {
    if ((LebaShowListManager.a() == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(SearchEntryConfigManager.b());
      }
      boolean bool = LebaShowListManager.a().a();
      if (bool)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        SearchProtocol.a(a(), 10800000L, "Leba");
      }
      while (bool != this.g)
      {
        this.g = bool;
        BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("has_search_bar", bool).commit();
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ReadinjoySPEventReport.a().a(3, paramBoolean);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new syf(this, paramBoolean), 150L);
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    LebaShowListManager.a().a();
    y();
  }
  
  public boolean c()
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
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new swx(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new swo(this));
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
  }
  
  protected void g()
  {
    super.g();
    t();
    F();
    ((ViewStub)a(2131364872)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131363809)).setOnFirstDrawListener(this);
    this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void i()
  {
    ApngImage.pauseByTag(4);
    super.i();
    WebProcessManager.c(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    NearbyProcessMonitor.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new sxa(this), 10L);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.b();
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEnterUpdateObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper.e();
    }
    super.k();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new syg(this), 10, null, false);
    WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202);
    }
  }
  
  public void n()
  {
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((RedTouchManager)localObject).a("886.100171");
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
          localObject = ((RedTouchManager)localObject).a("886.100172");
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
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
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
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label48:
    label435:
    label438:
    for (;;)
    {
      return;
      ThemeBackground localThemeBackground;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getTag() instanceof ThemeBackground))
      {
        localThemeBackground = (ThemeBackground)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getTag();
        if (!ThemeUtil.isNowThemeIsDIY()) {
          break label183;
        }
        if (localThemeBackground == null) {
          break label172;
        }
      }
      int i;
      for (;;)
      {
        ThemeBackground.getThemeBackground(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getContext(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localThemeBackground);
        if (("null".equals(localThemeBackground.path)) || (localThemeBackground.img == null)) {
          break label430;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setBackgroundDrawable(localThemeBackground.img);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setTag(localThemeBackground);
        i = 1;
        label121:
        if ((i == 0) && (j == 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setBackgroundResource(2130838215);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setTag(null);
        }
        if ((j != 0) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        return;
        localThemeBackground = null;
        break label48;
        localThemeBackground = new ThemeBackground();
      }
      label183:
      label193:
      Object localObject1;
      Object localObject2;
      if (ThemeUtil.isNowThemeIsAnimate()) {
        if (localThemeBackground != null)
        {
          localObject1 = ThemeUtil.getAnimatePathByTag(2);
          localObject2 = super.a().getDrawable(2130845807);
          localThemeBackground.img = VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "-conversation-", (Drawable)localObject2, VasApngUtil.a, "-leba-", null);
          if (this.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            if (!(this.jdField_a_of_type_AndroidViewView instanceof ViewGroup)) {
              break label417;
            }
            localObject1 = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
            if (localObject1 == null) {
              break label421;
            }
            i = ((ViewGroup)localObject1).getChildCount() - 1;
            if (i < 0) {
              break label435;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != ((ViewGroup)localObject1).getChildAt(i)) {
              break label423;
            }
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label438;
        }
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getContext());
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getId());
        ((ViewGroup)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, i, (ViewGroup.LayoutParams)localObject2);
        if ((localThemeBackground.img != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setBackgroundResource(0);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setTag(localThemeBackground);
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localThemeBackground.img);
          i = 0;
          j = 1;
          break label121;
          localThemeBackground = new ThemeBackground();
          break label193;
          localObject1 = null;
          break label262;
          break;
          i -= 1;
          break label275;
        }
        i = 0;
        break label121;
        i = -1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {}
    long l1;
    long l2;
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131363428: 
      case 2131363474: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
        LebaShowListManager.a().jdField_a_of_type_Boolean = true;
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("100600");
        a(new Intent(a(), LebaListMgrActivity.class));
        return;
      case 2131370314: 
        paramView = (LebaViewItem)LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.get("qzone_feedlist");
        QLog.d("Q.lebatab.leba", 1, "user clicked qzone feed entry.");
        ThreadManager.postImmediately(new sxo(this, paramView), null, true);
        AccessibilityUtil.a(this.jdField_c_of_type_AndroidViewView, "好友动态");
        return;
      case 2131370319: 
        AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "附近");
        l1 = System.currentTimeMillis();
        l2 = Math.abs(l1 - jdField_b_of_type_Long);
      }
    } while ((l2 >= 0L) && (l2 < 2000L));
    jdField_b_of_type_Long = l1;
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject1).a(String.valueOf(100510));
    ((RedTouchManager)localObject1).b(String.valueOf(100510));
    ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(100510);
    LebaShowListManager.jdField_a_of_type_Int |= 0x1;
    AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "附近");
    paramView = ((RedTouchManager)localObject1).a("100510.100517");
    int i;
    if (paramView.buffer.has())
    {
      paramView = paramView.buffer.get();
      if (QLog.isColorLevel()) {
        QLog.i("toplist_rank", 2, "god buffer: " + paramView);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label673;
      }
      i = 1;
    }
    for (;;)
    {
      ((RedTouchManager)localObject1).b("100510.100517");
      ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a(false);
      z();
      boolean bool;
      if ((localAppInfo.iNewFlag.has()) && (localAppInfo.iNewFlag.get() == 1))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("msg0x210.SubMsgType0x6f", 2, "Nearby item is clicked zan rotTouch is display");
        }
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005247", "0X8005247", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        NearbyProcessMonitor.b(0);
        if (!NearbySPUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          localObject1 = new Intent(a(), NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool);
          ((Intent)localObject1).putExtra("FROM_WHERE", 0);
          ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramView);
          ((Intent)localObject1).putExtra("NEARBY_IS_HAS_ICON", i);
          NearbyFakeActivity.a(a(), (Intent)localObject1);
          label613:
          if (bool) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "new_thing", "clk_red", 0, 0, "", "", "", "");
          }
          ReadinjoySPEventReport.a().a("FuJin", bool);
          return;
          paramView = "";
          break;
          label673:
          if ((!localAppInfo.red_display_info.has()) || (!localAppInfo.red_display_info.red_type_info.has())) {
            break label1001;
          }
          Object localObject2 = localAppInfo.red_display_info.red_type_info.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label1001;
          }
          localObject2 = ((List)localObject2).iterator();
          i = 2;
          label737:
          if (!((Iterator)localObject2).hasNext()) {
            break label998;
          }
          if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next()).red_type.get() != 3) {
            break label995;
          }
          i = 1;
        }
      }
      label995:
      for (;;)
      {
        break label737;
        localObject1 = new Intent(a(), NearbyGuideActivity.class);
        ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", bool);
        ((Intent)localObject1).putExtra("FROM_WHERE", 0);
        ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", paramView);
        ((Intent)localObject1).putExtra("NEARBY_IS_HAS_ICON", i);
        a().startActivity((Intent)localObject1);
        break label613;
        if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
        AccessibilityUtil.a(this.jdField_f_of_type_AndroidViewView, "兴趣部落");
        paramView = (LebaViewItem)LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.get("com.tx.xingqubuluo.android");
        localObject1 = SharedPreUtils.c(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView.a.strGotoUrl = ((String)localObject1).trim();
        }
        D();
        a(null, -1, paramView);
        a(0);
        E();
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484A", "0X800484A", 0, 0, "", "", "", "");
        return;
        bool = false;
        break;
      }
      label998:
      continue;
      label1001:
      i = 2;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    a();
    if (!this.jdField_d_of_type_Boolean) {
      a(true);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void p()
  {
    o();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      return;
    }
    a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845871);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494212));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494212));
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      com.tencent.mobileqq.servlet.QZoneNotifyServlet.jdField_a_of_type_Boolean = true;
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localQZoneManager.a(3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true)) {}
    EcshopReportHandler localEcshopReportHandler;
    do
    {
      return;
      localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a(this.jdField_a_of_type_AndroidContentIntent);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localEcshopReportHandler == null);
    localEcshopReportHandler.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */