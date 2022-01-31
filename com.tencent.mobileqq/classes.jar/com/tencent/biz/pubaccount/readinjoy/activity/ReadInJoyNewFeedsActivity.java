package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory;
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
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.OnTabChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.TabHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.Tab;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ldr;
import ldv;
import ldw;
import ldy;
import ldz;
import lea;
import lec;
import lee;
import lef;
import leg;
import lej;
import lek;
import lel;
import lem;
import len;
import leo;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, KandianMergeManager.MessageObserver, KandianMergeManager.OnTabRedNumsChangeListenner, ReadInJoySkinManager.OnSkinChangedListener, Observer
{
  public static ConcurrentHashMap a;
  public static int c;
  private static final int jdField_d_of_type_Int = Color.parseColor("#dedfe0");
  private long jdField_a_of_type_Long;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  protected FrameLayout a;
  protected AccountDetailTopGestureLayout a;
  public ReadInJoyNaviController a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  protected ReadInJoyObserver a;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver = new lec(this);
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  BaseTabbar.OnTabChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$OnTabChangeListener = new lel(this);
  public ReadInJoySkinGuideView a;
  private ReadinjoyTabbar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  public String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean b;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new ReadInJoyNewFeedsActivity.TabInfo("看点", 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new ReadInJoyNewFeedsActivity.TabInfo("视频", 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new ReadInJoyNewFeedsActivity.TabInfo("点点", 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new ReadInJoyNewFeedsActivity.TabInfo("我的", 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lea(this);
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(161));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a().get(3);
  }
  
  public static void h(int paramInt)
  {
    if (paramInt == 7)
    {
      ReadInJoyUtils.c(2);
      return;
    }
    if (paramInt == 5)
    {
      ReadInJoyUtils.c(1);
      return;
    }
    if (paramInt == 1)
    {
      ReadInJoyUtils.c(4);
      return;
    }
    ReadInJoyUtils.c(5);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = new ChannelCoverInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName = "推荐";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelType = 0;
  }
  
  private void n()
  {
    if (this.jdField_e_of_type_Int == 3) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_e_of_type_Int == 0) {
        bool = ReadInJoyUtils.a;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.jdField_e_of_type_Int + "and rednums is" + b());
        return;
        if (this.jdField_e_of_type_Int == 1) {
          bool = ReadInJoyUtils.a;
        }
      }
    }
  }
  
  public void B_()
  {
    d();
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public ReadInJoyBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  }
  
  public ReadinjoyTabbar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 4)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelection(paramInt1, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, getIntent(), paramInt2, paramBundle);
      ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(260);
      if (localReadInJoySkinManager.a() != 0)
      {
        paramBundle = localReadInJoySkinManager.a(paramInt1 + 4);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setImageDrawable(paramBundle.a());
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a.c.setSelected(false);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setSelected(true);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(161));
      }
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(paramInt1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this.jdField_e_of_type_Int, paramInt1)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1);
      }
      setTitle(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1))).jdField_a_of_type_JavaLangString);
      if (paramInt1 == 0)
      {
        a(0);
        label215:
        e(paramInt1);
        if ((paramInt1 != 2) || (this.jdField_d_of_type_AndroidViewView == null)) {
          break label713;
        }
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(jdField_d_of_type_Int);
        label242:
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "setSelection from tab " + this.jdField_e_of_type_Int + " to tab " + paramInt1 + ", jumpType:" + paramInt2);
        }
        if (paramInt1 != 1) {}
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("has_redpoint", i);
        PublicAccountReportUtils.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", VideoReporter.a(paramBundle), false);
        if (this.jdField_e_of_type_Int == paramInt1)
        {
          paramInt2 = 1;
          this.jdField_e_of_type_Int = paramInt1;
          jdField_c_of_type_Int = this.jdField_e_of_type_Int;
          j();
          if ((this.jdField_e_of_type_Int == 2) && (ReadInJoyUtils.g())) {
            d(2130840741);
          }
          if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData != null))
          {
            paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData = null;
            ThreadManager.post(new lek(this, paramBundle), 8, null, true);
          }
          int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b();
          if (j == 3) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(j);
          }
          if (paramBoolean) {
            str = "";
          }
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
          if (i <= 0) {
            break label744;
          }
          paramBundle = "2";
          localJSONObject.put("reddot", paramBundle);
          localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if ((localReadInJoySkinManager.a() != 1) || (TextUtils.isEmpty(localReadInJoySkinManager.a()))) {
            break label751;
          }
          paramBundle = localReadInJoySkinManager.a();
          localJSONObject.put("skin_id", paramBundle);
          if (!a(0)) {
            break label758;
          }
          i = 1;
          localJSONObject.put("button_state", i);
          paramBundle = localJSONObject.toString();
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            label713:
            paramBundle.printStackTrace();
            paramBundle = str;
            continue;
            if (!this.jdField_c_of_type_Boolean)
            {
              PublicAccountReportUtils.a(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(paramInt1 + 1), "", "", paramBundle, false);
              continue;
              PublicTracker.a(null, "recommend_tab_cost");
              continue;
              PublicTracker.a(null, "video_tab_cost");
              continue;
              PublicTracker.a(null, "subscribe_tab_cost");
              continue;
              PublicTracker.a(null, "self_tab_cost");
              continue;
              ReadInJoyScreenShotReporter.a(this).a(0, 0);
              continue;
              ReadInJoyScreenShotReporter.a(this).a(3, 56);
            }
          }
        }
        if (paramInt2 == 0)
        {
          PublicAccountReportUtils.a(this.app, "", "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(paramInt1 + 1), "", "", paramBundle, false);
          switch (paramInt1)
          {
          default: 
            switch (paramInt1)
            {
            default: 
              ReadInJoyScreenShotReporter.a(this).a();
              this.jdField_c_of_type_Boolean = false;
              return;
              continue;
              a(8);
              break label215;
              if (this.jdField_d_of_type_AndroidViewView == null) {
                break label242;
              }
              this.jdField_d_of_type_AndroidViewView.setBackgroundColor(-1);
            }
            break;
          }
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          paramInt2 = 0;
          continue;
          label744:
          paramBundle = "1";
          continue;
          label751:
          paramBundle = "0";
          continue;
          label758:
          i = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)this.app.getManager(paramInt);
    String str;
    if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
    {
      str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (!localReadInJoyBaseResManager.c(paramString, paramBaseResData)) {
        break label157;
      }
      if ((260 != paramInt) || (SharedPreUtils.h(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      FileUtils.a(str);
      localReadInJoyBaseResManager.a(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localReadInJoyBaseResManager.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new leg(this, paramString, str, paramInt));
    return;
    label157:
    localReadInJoyBaseResManager.a(paramString, paramBaseResData);
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = paramReadInJoyBaseFragment;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onKandianMsgNotification.");
    }
    h();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == KandianOx210MsgInfo.j)
    {
      if (!this.mIsResume) {
        break label50;
      }
      n();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0)) {
        ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
      }
      return;
      label50:
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Int != 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt).jdField_b_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    g();
    h();
  }
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(paramView);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onSubscribeMsgNotification.");
    }
    h();
  }
  
  public void c()
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    setContentView(2130969513);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131363495));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366775);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131366774);
    l();
    f();
    e();
    if (ThemeUtil.isInNightMode(this.app)) {
      a();
    }
    ReadInJoyFragmentFactory.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433681));
    }
    QQMessageFacade localQQMessageFacade = this.app.a();
    if (localQQMessageFacade != null) {
      f(localQQMessageFacade.b());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366773));
    PublicTracker.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController = new ReadInJoyNaviController(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new leo(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "init ReadInJoyNavigationGridView Exception or Error.");
      localThrowable.printStackTrace();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(0, paramBoolean);
    }
  }
  
  protected void d()
  {
    e(this.jdField_e_of_type_Int);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(260);
    int i = 0;
    while (i < 4)
    {
      BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
      if (localBaseSkinRes != null)
      {
        BaseTabbar.TabHolder localTabHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a;
        localTabHolder.c.setImageDrawable(localBaseSkinRes.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localTabHolder.c.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, i);
        }
      }
      if (localReadInJoySkinManager.a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  protected void d(int paramInt)
  {
    super.c(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(161));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
    int i;
    label74:
    ReadinjoyTabbar localReadinjoyTabbar;
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f().jdField_a_of_type_Int);
      localSparseIntArray.put(3, 0);
      i = 0;
      if (i >= 4) {
        return;
      }
      localReadinjoyTabbar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
      if (((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int != 1) {
        break label135;
      }
    }
    label135:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadinjoyTabbar.a(i, paramBoolean, localSparseIntArray.get(i));
      i += 1;
      break label74;
      localSparseIntArray.put(0, 0);
      break;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else
    {
      if (paramInt1 != 101) {
        break label223;
      }
      switch (paramInt2)
      {
      }
    }
    Object localObject;
    label223:
    do
    {
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().a(paramInt1, paramInt2, paramIntent);
          super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
          return;
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(this);
          ((QQToast)localObject).d(2000);
          if (i != 0)
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131431555);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131431563);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!ReadInJoyUtils.f());
    if (!TextUtils.isEmpty(PublicAccountConfigUtil.j)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(PublicAccountConfigUtil.j).optInt("releaseServiceMinMem", 80);
          long l = DeviceInfoUtil.f();
          if (l >>> 20 > i) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail, release web core service");
          }
          WebProcessManager.g();
          try
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
            ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.e()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.a()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            StatisticCollector.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        i = 80;
        continue;
      }
      i = 80;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    VideoVolumeControl.a().a(this);
    super.doOnCreate(paramBundle);
    ReadInJoyHelper.c(this.app);
    ReadInJoyHelper.d(this.app);
    ReadInJoyWebRenderEngine.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Object localObject1 = paramBundle.getExtras();
    if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(161)).e();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(161));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    Object localObject2;
    if (6 == this.jdField_f_of_type_Int)
    {
      ReadInJoyUtils.a(3);
      paramBundle = "";
      localObject1 = "0";
      localObject2 = "";
    }
    label1036:
    label1050:
    label1065:
    label1071:
    for (;;)
    {
      try
      {
        localMessageRecord = this.app.a().b(AppConstants.as, 7220);
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label1065;
        }
        localMessageForStructing = (MessageForStructing)localMessageRecord;
        if (localMessageForStructing.structingMsg != null) {
          break label1071;
        }
        localMessageForStructing.parse();
      }
      catch (JSONException paramBundle)
      {
        MessageRecord localMessageRecord;
        Object localObject3;
        String[] arrayOfString;
        int j;
        int i;
        paramBundle.printStackTrace();
        continue;
      }
      if ((localMessageForStructing != null) && (localMessageForStructing.extInt == 1))
      {
        localObject5 = localObject2;
        localObject4 = paramBundle;
        localObject3 = localObject1;
        if (localMessageForStructing.structingMsg == null) {
          break label1050;
        }
        if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
          paramBundle = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
        }
        if (localMessageForStructing.structingMsg.mStrategyIds != null) {
          localObject1 = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
        }
        if (localMessageForStructing.structingMsg.mAlgorithmIds != null) {
          localObject2 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
        }
        localObject5 = localObject2;
        localObject4 = paramBundle;
        localObject3 = localObject1;
        if (TextUtils.isEmpty(localMessageForStructing.structingMsg.mInnerUniqIds)) {
          break label1050;
        }
        arrayOfString = localMessageForStructing.structingMsg.mInnerUniqIds.split("\\|");
        j = arrayOfString.length;
        i = 0;
        localObject5 = localObject2;
        localObject4 = paramBundle;
        localObject3 = localObject1;
        if (i >= j) {
          break label1050;
        }
        localObject5 = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          localObject2 = localObject5;
          if ((!"300".equals(localObject3)) || (ReadInJoyUtils.a(localMessageRecord))) {
            break label1036;
          }
          localObject1 = ((KandianMergeManager)this.app.getManager(161)).a();
          if ((localObject1 != null) && (((List)localObject1).size() > 0) && (!String.valueOf(((List)localObject1).get(0)).equals(paramBundle)))
          {
            localObject1 = String.valueOf(((List)localObject1).get(0));
            paramBundle = "";
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("algorithm_id", localObject4);
            ((JSONObject)localObject5).put("rowkey", localObject2);
            if (!TextUtils.isEmpty(paramBundle)) {
              ((JSONObject)localObject5).put("articleID", paramBundle);
            }
            PublicAccountReportUtils.a(null, "CliOper", "", localMessageForStructing.senderuin, "0X80081DB", "0X80081DB", 0, 0, "", (String)localObject1, localObject3, ((JSONObject)localObject5).toString(), false);
            ReadInJoyLogicEngineEventDispatcher.a().a();
            if (Build.VERSION.SDK_INT >= 11) {
              getWindow().setFlags(16777216, 16777216);
            }
            i = NetworkUtil.a(getApplication());
            if ((i == 4) || (i == 1)) {
              ThreadManager.post(new ldr(this), 5, null, true);
            }
            ThreadManager.executeOnSubThread(new len(this, this));
            c();
            getWindow().setBackgroundDrawable(null);
            paramBundle = (ReadInJoyLogicManager)this.app.getManager(162);
            ReadInJoyLogicEngine.a().i();
            ReadInJoyLogicEngine.a().d();
            if (this.app.a() != null) {
              this.app.a().addObserver(this);
            }
            if (ReadInJoyHelper.a(this.app)) {
              TroopBarAssistantManager.a().c(this.app);
            }
            ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
            ReadInJoyHelper.a(this.app);
            this.jdField_b_of_type_Int = ReadInJoyUtils.jdField_d_of_type_Int;
            ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), true, 0L, this.jdField_b_of_type_Int, 0);
            ReadInJoyUtils.g(this.app);
            n();
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0) {
              ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
            }
            PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE", null);
            PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
            ThreadManager.post(new lee(this), 8, null, true);
            ThreadManager.executeOnSubThread(new lef(this));
            return true;
          }
        }
        else
        {
          i += 1;
          continue;
        }
        localObject1 = "0";
        continue;
      }
      else
      {
        if ((localMessageRecord.extInt != 5) || (localMessageForStructing == null)) {
          continue;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", localMessageForStructing.senderuin, "0X80081DB", "0X80081DB", 0, 0, "", "0", "0", null, false);
        continue;
        if (9 == this.jdField_f_of_type_Int)
        {
          ReadInJoyUtils.a(3);
          continue;
        }
        if (1 == this.jdField_f_of_type_Int)
        {
          ReadInJoyUtils.a(8);
          continue;
        }
        if (2 == this.jdField_f_of_type_Int)
        {
          ReadInJoyUtils.a(8);
          continue;
        }
        if (11 != this.jdField_f_of_type_Int) {
          continue;
        }
        ReadInJoyLogicEngineEventDispatcher.a().a("onConversationJumpRestoreStack");
        continue;
      }
      Object localObject5 = "";
      localObject1 = paramBundle;
      paramBundle = (Bundle)localObject5;
      continue;
      paramBundle = (Bundle)localObject4;
      localObject2 = "";
      Object localObject4 = localObject5;
      continue;
      MessageForStructing localMessageForStructing = null;
    }
  }
  
  protected void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a();
      ((ReadInJoyLogicManager)this.app.getManager(162)).a().i(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ReadInJoyScreenShotReporter.a(this).b();
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      ReadInJoyFragmentFactory.a().a();
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      }
      super.doOnDestroy();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      if (l > 0L) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", ReadInJoyUtils.d(), false);
      }
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this);
      }
      ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.app.getManager(162);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      ReadInJoyLogicEngine.a().j();
      VideoVolumeControl.a().b(this);
      PreloadManager.a().b();
      PreloadManager.a().e();
      ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), false, l, this.jdField_b_of_type_Int, this.jdField_g_of_type_Int);
      ReadInJoyArkViewController.a().a();
      PublicTracker.a();
      WebProcessManager.g();
      WebProcessManager.h();
      ReadInJoyWebDataManager.a();
      ReadInJoyWebDataManager.a().b();
      i();
      VideoBrightnessControl.a().b(this);
      ((ReadInJoySkinManager)this.app.getManager(260)).b(this);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        FileUtils.a(CommonSkinRes.a(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
      }
      ReadInJoyGlobalReporter.a().a();
      ThreadManager.executeOnSubThread(new ldv(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.b();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "saveLeaveKanDianTab throw Exception.");
        localException.printStackTrace();
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433681));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(3);
    ReadInJoyScreenShotReporter.a(this).a();
    ReadInJoyLogicEngine.m();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  protected void doOnResume()
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    ReadInJoyFragmentFactory.a().a(this);
    super.doOnResume();
    boolean bool;
    if (this.jdField_e_of_type_Int == 0)
    {
      a(0);
      e(this.jdField_e_of_type_Int);
      if (this.jdField_b_of_type_Boolean) {
        break label160;
      }
      bool = true;
      label54:
      d(bool);
      h();
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lem(this), 1000L);
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        ReadInJoyScreenShotReporter.a(this).a();
      }
    }
    for (;;)
    {
      PublicTracker.a("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      a(8);
      break;
      label160:
      bool = false;
      break label54;
      ReadInJoyScreenShotReporter.a(this).a(0, 0);
      continue;
      ReadInJoyScreenShotReporter.a(this).a(3, 56);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().k();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.a().a(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().l();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("搜索");
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void e(int paramInt)
  {
    if (SystemUtil.c())
    {
      b(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)this.app.getManager(260)).a(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localBaseSkinRes.a());
      return;
    }
    ThreadManager.post(new ldw(this, paramInt), 5, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setCurrentActivity(this);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(260);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localReadInJoySkinManager.a() != 0)
      {
        BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
        if (localBaseSkinRes != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(localBaseSkinRes.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$OnTabChangeListener);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a()) || (System.currentTimeMillis() - ReadInJoyHelper.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
          continue;
        }
        if (this.jdField_f_of_type_Int != 9) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "restoreHistoryKanDianTab throw Exception.");
        localException.printStackTrace();
        continue;
        i = 1;
        continue;
      }
      if ((i == 0) && (ReadInJoyUtils.a(b()))) {
        this.jdField_e_of_type_Int = ((ReadInJoyLogicManager)this.app.getManager(162)).a().e();
      }
      jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectedTab(this.jdField_e_of_type_Int, false);
      return;
      this.jdField_e_of_type_Int = 0;
      continue;
      i = 0;
    }
  }
  
  public void f(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_f_of_type_Int != 5) || (this.jdField_d_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ldz(this, paramInt));
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    d(false);
  }
  
  public void g(int paramInt)
  {
    this.jdField_g_of_type_Int |= paramInt;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "setRecommendRedDotInfo.");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId == 0)) {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(161));
          }
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f().jdField_a_of_type_Int > 0)) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a())
          {
            i = 1;
            ReadInJoyUtils.b().post(new lej(this, i));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        int i = 0;
      }
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void j()
  {
    super.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().a());
  }
  
  void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ldy(this), 5, null, true);
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((VideoPlayManager)localObject).a() != null) && (((VideoPlayManager)localObject).a().a()))
        {
          ((VideoPlayManager)localObject).a().d();
          return true;
        }
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363456: 
      if ((this.jdField_e_of_type_Int == 2) && (ReadInJoyUtils.g()))
      {
        ReadInJoyUtils.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
        PublicAccountReportUtils.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", ReadInJoyUtils.e(), false);
        return;
      }
      ReadInJoyUtils.a(this);
      UniteSearchReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
      return;
    }
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
        return;
      }
      if ((a() instanceof ReadInJoySubChannelFragment))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(((ReadInJoySubChannelFragment)a()).a());
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(0);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().c();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (((MessageRecord)paramObject).extInt != 5) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */