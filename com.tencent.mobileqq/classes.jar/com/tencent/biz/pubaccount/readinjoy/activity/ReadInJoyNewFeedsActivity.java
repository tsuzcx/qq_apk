package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvx;
import bcjs;
import bhdz;
import bhhr;
import bmhv;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import olh;
import omx;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import otu;
import otz;
import ouc;
import ouf;
import oug;
import pkh;
import pno;
import pqf;
import pqg;
import pqq;
import pqt;
import pqu;
import prm;
import pro;
import prp;
import prq;
import prs;
import pvb;
import pvd;
import pvj;
import pvm;
import pvp;
import pvq;
import pvu;
import pyi;
import qft;
import rjm;
import rmo;
import rmp;
import rmr;
import rmu;
import rna;
import rnn;
import rno;
import rpl;
import set;
import seu;
import sfq;
import spg;
import sqd;
import sqp;
import sxr;
import sxs;
import szq;
import tbh;
import tdu;
import tlx;
import uhx;
import uqx;
import usu;
import uuq;
import uvs;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, TopGestureLayout.OnGestureListener, Observer, pvb, pvd, rnn
{
  public static List<String> a;
  public static ConcurrentHashMap<Integer, oug> a;
  public static int c;
  private static final int jdField_d_of_type_Int = Color.parseColor("#dedfe0");
  private long jdField_a_of_type_Long;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  protected FrameLayout a;
  protected AccountDetailTopGestureLayout a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  public ReadInJoySkinGuideView a;
  private ReadinjoyTabbar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyNewFeedsActivity.1(this);
  protected String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public ors a;
  protected pvq a;
  protected rno a;
  sxr jdField_a_of_type_Sxr = new ouc(this);
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
  private int h;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new oug(anvx.a(2131693417), 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new oug(anvx.a(2131712347), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new oug(anvx.a(2131712504), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new oug(anvx.a(2131712251), 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_Pvq = new otu(this);
  }
  
  private void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelection(paramInt1, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, getIntent(), paramInt2, paramBundle);
    paramBundle = (rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if (paramBundle.a() != 0)
    {
      paramBundle = paramBundle.a(paramInt1 + 4);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setImageDrawable(paramBundle.a());
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a.c.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setSelected(true);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this.jdField_e_of_type_Int, paramInt1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1);
    }
    paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b();
    if (paramInt1 == 3) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(paramInt1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    pqg localpqg = new pqg();
    localpqg.b().e().f();
    int i;
    Object localObject;
    if (paramBoolean2)
    {
      i = 1;
      localpqg.b("button_state", i);
      if (paramInt2 <= 0) {
        break label242;
      }
      localObject = "2";
      label50:
      localpqg.b("reddot", (String)localObject);
      localObject = (rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((((rna)localObject).a() != 1) || (TextUtils.isEmpty(((rna)localObject).a()))) {
        break label250;
      }
      localObject = ((rna)localObject).a();
      label102:
      localpqg.b("skin_id", (String)localObject);
      if (a().a() == 0)
      {
        localObject = rmu.b(getActivity(), 0);
        if ((localObject == null) || (!((RefreshData)localObject).isAD)) {
          break label258;
        }
        paramInt2 = j;
        label148:
        localpqg.b("ad_page", paramInt2);
      }
      if (paramBoolean1) {
        break label263;
      }
      localObject = "";
      str = "";
      if (paramInt1 == 2)
      {
        localObject = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a());
        str = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b());
      }
      olh.a(this.app, (String)localObject, "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(paramInt1 + 1), "", str, localpqg.a(), false);
    }
    label242:
    label250:
    while (this.jdField_c_of_type_Boolean)
    {
      String str;
      return;
      i = 0;
      break;
      localObject = "1";
      break label50;
      localObject = "0";
      break label102;
      paramInt2 = 0;
      break label148;
    }
    label258:
    label263:
    olh.a(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(paramInt1 + 1), "", "", localpqg.a(), false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    pqg localpqg = new pqg();
    localpqg.b("has_redpoint", paramInt);
    olh.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", omx.a(localpqg.a()), false);
    tbh.a(this).a(3, 56);
    if (paramBoolean) {
      uuq.a(null, "video_tab_cost");
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    long l;
    if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
    {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "reportSubscribeTabRedInfo.");
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
      if (l == 0L) {}
    }
    try
    {
      paramBundle = pqf.a();
      paramBundle.put("kandian_mode", pqu.a());
      paramBundle.put("tab_source", 3);
      olh.a(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), paramBundle.toString(), false);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    getWindow().getDecorView().post(new ReadInJoyNewFeedsActivity.11(this, paramString));
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a().get(3);
  }
  
  private void e(boolean paramBoolean)
  {
    a(0);
    q();
    tbh.a(this).a(0, 0);
    if (paramBoolean) {
      uuq.a(null, "recommend_tab_cost");
    }
  }
  
  private void f(boolean paramBoolean)
  {
    i(jdField_d_of_type_Int);
    if (pqq.a()) {
      d(2130842905);
    }
    tbh.a(this).a();
    if (paramBoolean) {
      uuq.a(null, "subscribe_tab_cost");
    }
  }
  
  public static void h(int paramInt)
  {
    if (paramInt == 7)
    {
      pqu.a(2);
      return;
    }
    if (paramInt == 5)
    {
      pqu.a(1);
      return;
    }
    if (paramInt == 1)
    {
      pqu.a(4);
      return;
    }
    if ((paramInt == 6) || (paramInt == 9))
    {
      pqu.a(7);
      return;
    }
    pqu.a(5);
  }
  
  private void i(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(paramInt);
    }
  }
  
  private void m()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (rna)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if (localObject != null) {
        ((rna)localObject).a(this);
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (rna)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      ((rna)localObject).b(this);
      ((rna)localObject).b();
    }
  }
  
  private void o()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
    if (localSparseIntArray.get(0) <= 0) {
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f());
    }
    localSparseIntArray.put(3, 0);
    int i = 0;
    if (i < 4)
    {
      if (localSparseIntArray.get(i) <= 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = pqf.a();
          localJSONObject.put("kandian_mode", pqu.a());
          localJSONObject.put("tab_source", i + 1);
          String str3 = "";
          String str4 = "";
          String str2 = str3;
          String str1 = str4;
          if (i == 2)
          {
            long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
            str2 = str3;
            str1 = str4;
            if (l != 0L)
            {
              str2 = String.valueOf(l);
              str1 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b());
            }
          }
          olh.a(null, "CliOper", "", str2, "0X80081C6", "0X80081C6", 0, 1, null, null, str1, localJSONObject.toString(), false);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = new ChannelCoverInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName = anvx.a(2131712434);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelType = 0;
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData != null)
    {
      GuideData localGuideData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData = null;
      ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, localGuideData), 8, null, true);
    }
  }
  
  private void r()
  {
    if (this.jdField_e_of_type_Int == 3) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_e_of_type_Int == 0) {
        bool = pkh.a;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.jdField_e_of_type_Int + "and rednums is" + b());
        return;
        if (this.jdField_e_of_type_Int == 1) {
          bool = pkh.a;
        }
      }
    }
  }
  
  public void E_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    h();
    i();
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
    int i;
    boolean bool1;
    if ((paramInt1 < 0) || (paramInt1 >= 4))
    {
      i = 0;
      this.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
      boolean bool2 = a(paramInt1);
      paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(i);
      a(i, paramInt2, paramBundle);
      setTitle(((oug)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      a(8);
      e(i);
      i(-1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "setSelection from tab " + this.jdField_e_of_type_Int + " to tab " + i + ", jumpType:" + paramInt2);
      }
      if (this.jdField_e_of_type_Int != i) {
        break label238;
      }
      bool1 = true;
      label152:
      this.jdField_e_of_type_Int = i;
      jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      k();
      if (paramBoolean) {
        a(i, paramInt1, bool1, bool2);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      tlx.b(a().a());
      this.jdField_c_of_type_Boolean = false;
      return;
      i = paramInt1;
      break;
      label238:
      bool1 = false;
      break label152;
      e(paramBoolean);
      continue;
      a(paramInt1, paramBoolean);
      continue;
      f(paramBoolean);
      continue;
      uuq.a(null, "self_tab_cost");
      tbh.a(this).a();
    }
  }
  
  public void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    rmr localrmr = (rmr)this.app.getManager(paramInt);
    String str;
    if (localrmr.b(paramString, paramBaseResData))
    {
      str = localrmr.a(paramString, paramBaseResData.id);
      if (!localrmr.c(paramString, paramBaseResData)) {
        break label158;
      }
      if ((QQManagerFactory.READ_INJOY_SKIN_MANAGER != paramInt) || (bhhr.g(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      FileUtils.deleteDirectory(str);
      localrmr.a(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localrmr.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
    return;
    label158:
    localrmr.a(paramString, paramBaseResData);
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
    i();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == rpl.k) {
      if (this.mIsResume)
      {
        r();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i())) {
          sfq.a().a(this.app.getCurrentAccountUin(), 1);
        }
      }
    }
    while (paramInt != rpl.l) {
      for (;;)
      {
        return;
        this.jdField_g_of_type_Boolean = true;
      }
    }
    a(paramBundle);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt).jdField_b_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
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
    i();
  }
  
  public boolean b()
  {
    return this.h != 0;
  }
  
  public void c()
  {
    uuq.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setOnFlingGesture(this);
    }
    setContentView(2131560020);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131378427));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378404);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379227);
    p();
    g();
    f();
    if (ThemeUtil.isInNightMode(this.app)) {
      a();
    }
    pyi.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690676));
    }
    QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
    if (localQQMessageFacade != null) {
      f(localQQMessageFacade.getUnreadMsgsNum());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366719));
    uuq.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_Ors = new ors(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new ouf(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_Ors.jdField_a_of_type_Int = getTitleBarHeight();
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
  
  public void d()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label135;
      }
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
      {
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label135:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  protected void d(int paramInt)
  {
    super.c(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
    int i;
    label71:
    ReadinjoyTabbar localReadinjoyTabbar;
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.f());
      localSparseIntArray.put(3, 0);
      i = 0;
      if (i >= 4) {
        return;
      }
      localReadinjoyTabbar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
      if (((oug)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int != 1) {
        break label132;
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadinjoyTabbar.a(i, paramBoolean, localSparseIntArray.get(i));
      i += 1;
      break label71;
      localSparseIntArray.put(0, 0);
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        break label240;
      }
      switch (paramInt2)
      {
      }
    }
    Object localObject;
    label240:
    do
    {
      do
      {
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().a(paramInt1, paramInt2, paramIntent);
          }
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
            ((QQToast)localObject).c(2131692127);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692128);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!prm.a());
    if (!TextUtils.isEmpty(usu.h)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(usu.h).optInt("releaseServiceMinMem", 80);
          long l = DeviceInfoUtil.getSystemAvaialbeMemory();
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
            ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.getCpuNumber()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.getCpuFrequency()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
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
    uuq.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    uuq.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    sqp.a().a(this);
    VideoReport.addToDetectionWhitelist(this);
    super.doOnCreate(paramBundle);
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    rmu.jdField_b_of_type_Boolean = false;
    uvs.a(this.app);
    bmhv.c(this.app);
    bmhv.d(this.app);
    pvu.b();
    pvu.c();
    set.a.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if (6 == this.jdField_f_of_type_Int)
    {
      prp.a(3);
      prq.a();
    }
    for (;;)
    {
      pvm.a().a();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      int i = NetworkUtil.getSystemNetwork(getApplication());
      if ((i == 4) || (i == 1)) {
        ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
      c();
      getWindow().setBackgroundDrawable(null);
      paramBundle = (pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      pvj.a().h();
      pvj.a().d();
      if (this.app.getMessageFacade() != null) {
        this.app.getMessageFacade().addObserver(this);
      }
      if (bmhv.a(this.app)) {
        uqx.a().c(this.app);
      }
      pvm.a().a(this.jdField_a_of_type_Pvq);
      bmhv.a(this.app);
      this.jdField_b_of_type_Int = prp.jdField_a_of_type_Int;
      uvs.a(uvs.a(), true, 0L, this.jdField_b_of_type_Int, 0);
      pno.a(this.app);
      r();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        sfq.a().a(this.app.getCurrentAccountUin(), 1);
      }
      uuq.a("KANDIAN_NEW_FEEDS_CREATE", null);
      uuq.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = pqu.a();
      int j = prp.jdField_a_of_type_Int;
      tlx.a().a(this.app, l, i, j);
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
      m();
      this.jdField_a_of_type_Rno = new rno(this.app, 0);
      this.jdField_a_of_type_Rno.a(new otz(this));
      this.jdField_a_of_type_Rno.a();
      d();
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
      tlx.b(0);
      prs.a();
      return true;
      if (9 == this.jdField_f_of_type_Int) {
        prp.a(3);
      } else if (1 == this.jdField_f_of_type_Int) {
        prp.a(8);
      } else if (2 == this.jdField_f_of_type_Int) {
        prp.a(8);
      } else if (11 == this.jdField_f_of_type_Int) {
        pvm.a().b("onConversationJumpRestoreStack");
      }
    }
  }
  
  public void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a();
      ((pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().h(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ((uhx)this.app.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(getActivity());
      tbh.a(this).b();
      pvm.a().b(this.jdField_a_of_type_Pvq);
      pyi.a().a();
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
      n();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      }
      jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
      super.doOnDestroy();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      if (l > 0L) {
        olh.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", pqf.b(), false);
      }
      if (this.app.getMessageFacade() != null) {
        this.app.getMessageFacade().deleteObserver(this);
      }
      Object localObject = (pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((pvp)localObject).a() != null))
      {
        localObject = ((pvp)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.p();
      pvj.a().i();
      sqp.a().b(this);
      PreloadManager.a().b();
      PreloadManager.a().e();
      uvs.a(uvs.a(), false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.h);
      uuq.a();
      WebProcessManager.g();
      WebProcessManager.h();
      sfq.a();
      sfq.a().b();
      j();
      ((rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      this.jdField_a_of_type_Rno.b();
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        FileUtils.deleteDirectory(rmp.a(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
      }
      tlx.a().a();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
      if (this.jdField_a_of_type_Ors != null) {
        this.jdField_a_of_type_Ors.b();
      }
      localObject = pvj.a().a();
      if (localObject != null) {
        ((qft)localObject).a(false);
      }
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      rjm.a().c();
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
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690676));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(3);
    tbh.a(this).a();
    pvj.n();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  public void doOnResume()
  {
    uuq.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    uuq.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    pyi.a().a(this);
    super.doOnResume();
    if (this.jdField_f_of_type_Boolean)
    {
      a(this.jdField_g_of_type_Int, 257, null, false);
      this.jdField_f_of_type_Boolean = false;
    }
    boolean bool;
    if (this.jdField_e_of_type_Int == 0)
    {
      a(0);
      if ((getIntent() != null) && (getIntent().getExtras() != null) && (getIntent().hasExtra("notification_message_id")))
      {
        String str = getIntent().getExtras().getString("notification_message_id", "");
        if ((!str.isEmpty()) && (pro.b() == 2) && (pqt.c() == 2)) {
          ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
        }
        getIntent().removeExtra("notification_message_id");
        if ((pqt.c() == 1) || (pro.b() != 2)) {
          a(str);
        }
      }
      e();
      if (this.jdField_b_of_type_Boolean) {
        break label300;
      }
      bool = true;
      label190:
      d(bool);
      i();
      o();
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        uuq.a("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        tbh.a(this).a();
      }
    }
    for (;;)
    {
      uuq.a("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      a(8);
      break;
      label300:
      bool = false;
      break label190;
      tbh.a(this).a(0, 0);
      continue;
      tbh.a(this).a(3, 56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    pvj.a().j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    sqp.a().a(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    pvj.a().k();
  }
  
  protected void e()
  {
    e(this.jdField_e_of_type_Int);
    rna localrna = (rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i = 0;
    while (i < 4)
    {
      rmo localrmo = localrna.a(i + 4);
      if (localrmo != null)
      {
        sxs localsxs = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a;
        localsxs.c.setImageDrawable(localrmo.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localsxs.c.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, i);
        }
      }
      if (localrna.a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    if (SystemUtil.isCheckMiui())
    {
      b(((oug)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      rmo localrmo = ((rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8);
      if (localrmo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localrmo.a());
      }
      return;
    }
    ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131712465));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131376762).setOnClickListener(this);
  }
  
  public void f(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_f_of_type_Int != 5) || (this.jdField_d_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyNewFeedsActivity.16(this, paramInt));
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.e())) {
      onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setCurrentActivity(this);
    rna localrna = (rna)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((oug)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localrna.a() != 0)
      {
        rmo localrmo = localrna.a(i + 4);
        if (localrmo != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(localrmo.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_Sxr);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()) || (System.currentTimeMillis() - bmhv.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
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
      if ((i == 0) && (pqu.a(b()))) {
        this.jdField_e_of_type_Int = ((pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().d();
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
  
  public void g(int paramInt)
  {
    this.h |= paramInt;
  }
  
  public void h()
  {
    d(false);
  }
  
  public void i()
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
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b())
          {
            i = 1;
            pno.b().post(new ReadInJoyNewFeedsActivity.7(this, i));
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
  
  public void j()
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
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
      super.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().d());
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.15(this), 5, null, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Ors != null) && (this.jdField_a_of_type_Ors.a()))
    {
      this.jdField_a_of_type_Ors.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((spg)localObject).a() != null) && (((spg)localObject).a().a()))
        {
          ((spg)localObject).a().j();
          return true;
        }
      }
      else if (((localObject instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localObject).f()))
      {
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onBackEvent())) {
      return true;
    }
    if ((!bmhv.l()) && (getIntent() != null) && (getIntent().getBooleanExtra("from_lock_screen", false)))
    {
      szq.a(this);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_e_of_type_Int == 2) && (pqq.a()))
      {
        pqq.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
        olh.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", pqf.c(), false);
      }
      else
      {
        prm.a(this);
        bcjs.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
        continue;
        if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Ors != null))
        {
          if (this.jdField_a_of_type_Ors.a()) {
            this.jdField_a_of_type_Ors.a(null);
          } else if ((a() instanceof ReadInJoySubChannelFragment)) {
            this.jdField_a_of_type_Ors.a(a().a());
          } else {
            this.jdField_a_of_type_Ors.a(0);
          }
        }
        else
        {
          try
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().e();
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
          }
          continue;
          a().f();
          ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (((MessageRecord)paramObject).extInt != 5) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */