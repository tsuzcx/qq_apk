package com.tencent.biz.pubaccount.readinjoy.activity;

import alpo;
import android.annotation.TargetApi;
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
import aynt;
import azmz;
import bdag;
import bdcb;
import bdcq;
import bdcs;
import bdee;
import bdiv;
import bjxj;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
import nrt;
import ntd;
import nxf;
import nzj;
import nzo;
import nzr;
import nzs;
import nzt;
import ocq;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owq;
import owr;
import owy;
import oxb;
import oxd;
import oxe;
import oxi;
import ozn;
import pga;
import qhl;
import qio;
import qip;
import qir;
import qiu;
import qja;
import qjn;
import qjo;
import qlc;
import qzi;
import rjg;
import rkp;
import rlb;
import row;
import rox;
import rsb;
import ruv;
import rxi;
import sfh;
import suv;
import swy;
import syp;
import szp;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, TopGestureLayout.OnGestureListener, Observer, owq, owr, qjn
{
  public static List<String> a;
  public static ConcurrentHashMap<Integer, nzt> a;
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
  public nxf a;
  protected oxe a;
  protected qjo a;
  row jdField_a_of_type_Row = new nzr(this);
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
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new nzt(alpo.a(2131693817), 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new nzt(alpo.a(2131713268), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new nzt(alpo.a(2131713425), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new nzt(alpo.a(2131713172), 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_Oxe = new nzj(this);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
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
      paramBundle = ors.a();
      paramBundle.put("kandian_mode", ors.e());
      paramBundle.put("tab_source", 3);
      nrt.a(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), paramBundle.toString(), false);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a().get(3);
  }
  
  public static void h(int paramInt)
  {
    if (paramInt == 7)
    {
      ors.d(2);
      return;
    }
    if (paramInt == 5)
    {
      ors.d(1);
      return;
    }
    if (paramInt == 1)
    {
      ors.d(4);
      return;
    }
    if ((paramInt == 6) || (paramInt == 9))
    {
      ors.d(7);
      return;
    }
    ors.d(5);
  }
  
  private void m()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (qja)((AppInterface)localObject).getManager(261);
      if (localObject != null) {
        ((qja)localObject).a(this);
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (qja)((AppInterface)localObject).getManager(261);
      ((qja)localObject).b(this);
      ((qja)localObject).a();
    }
  }
  
  private void o()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
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
          JSONObject localJSONObject = ors.a();
          localJSONObject.put("kandian_mode", ors.e());
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
          nrt.a(null, "CliOper", "", str2, "0X80081C6", "0X80081C6", 0, 1, null, null, str1, localJSONObject.toString(), false);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName = alpo.a(2131713355);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelType = 0;
  }
  
  private void q()
  {
    if (this.jdField_e_of_type_Int == 3) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_e_of_type_Int == 0) {
        bool = ors.a;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.jdField_e_of_type_Int + "and rednums is" + b());
        return;
        if (this.jdField_e_of_type_Int == 1) {
          bool = ors.a;
        }
      }
    }
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
      i = 0;
    }
    for (;;)
    {
      this.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
      boolean bool = a(paramInt1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelection(i, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, getIntent(), paramInt2, paramBundle);
      Object localObject2 = (qja)this.app.getManager(261);
      if (((qja)localObject2).a() != 0)
      {
        paramBundle = ((qja)localObject2).a(i + 4);
        if (paramBundle != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(paramBundle.a());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a.c.setSelected(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setSelected(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
      }
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this.jdField_e_of_type_Int, i)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i);
      }
      setTitle(((nzt)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (i == 0)
      {
        a(0);
        label240:
        e(i);
        if ((i != 2) || (this.jdField_d_of_type_AndroidViewView == null)) {
          break label878;
        }
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(jdField_d_of_type_Int);
        label269:
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewFeedsActivity", 2, "setSelection from tab " + this.jdField_e_of_type_Int + " to tab " + i + ", jumpType:" + paramInt2);
        }
        if (i != 1) {}
      }
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("has_redpoint", j);
        nrt.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", ntd.a(paramBundle), false);
        if (this.jdField_e_of_type_Int == i)
        {
          paramInt1 = 1;
          this.jdField_e_of_type_Int = i;
          jdField_c_of_type_Int = this.jdField_e_of_type_Int;
          k();
          if ((this.jdField_e_of_type_Int == 2) && (ors.g())) {
            d(2130842467);
          }
          if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData != null))
          {
            paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData = null;
            ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, paramBundle), 8, null, true);
          }
          paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b();
          if (paramInt2 == 3) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(paramInt2);
          }
          if (i == 3) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(3);
          }
          if (paramBoolean) {
            localObject1 = "";
          }
        }
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", ors.jdField_d_of_type_Int);
          if (j <= 0) {
            break label909;
          }
          paramBundle = "2";
          ((JSONObject)localObject3).put("reddot", paramBundle);
          ((JSONObject)localObject3).put("kandian_mode", ors.e());
          ((JSONObject)localObject3).put("kandian_mode_new", ntd.a());
          if ((((qja)localObject2).a() != 1) || (TextUtils.isEmpty(((qja)localObject2).a()))) {
            break label916;
          }
          paramBundle = ((qja)localObject2).a();
          ((JSONObject)localObject3).put("skin_id", paramBundle);
          if (!bool) {
            break label923;
          }
          paramInt2 = 1;
          ((JSONObject)localObject3).put("button_state", paramInt2);
          if (a().a() == 0)
          {
            paramBundle = qiu.b(getActivity(), 0);
            if ((paramBundle == null) || (!paramBundle.isAD)) {
              break label928;
            }
            paramInt2 = 1;
            ((JSONObject)localObject3).put("ad_page", paramInt2);
          }
          paramBundle = ((JSONObject)localObject3).toString();
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Object localObject3;
            String str;
            long l;
            label878:
            paramBundle.printStackTrace();
            paramBundle = (Bundle)localObject1;
            continue;
            if (!this.jdField_c_of_type_Boolean)
            {
              nrt.a(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(i + 1), "", "", paramBundle, false);
              continue;
              syp.a(null, "recommend_tab_cost");
              continue;
              syp.a(null, "video_tab_cost");
              continue;
              syp.a(null, "subscribe_tab_cost");
              continue;
              syp.a(null, "self_tab_cost");
              continue;
              ruv.a(this).a(0, 0);
              continue;
              ruv.a(this).a(3, 56);
            }
          }
        }
        if (paramInt1 == 0)
        {
          localObject3 = "";
          str = "";
          localObject2 = localObject3;
          localObject1 = str;
          if (i == 2)
          {
            localObject2 = localObject3;
            localObject1 = str;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
            {
              l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
              localObject2 = localObject3;
              localObject1 = str;
              if (l != 0L)
              {
                localObject2 = String.valueOf(l);
                localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b());
              }
            }
          }
          nrt.a(this.app, (String)localObject2, "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(i + 1), "", (String)localObject1, paramBundle, false);
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              ruv.a(this).a();
              this.jdField_c_of_type_Boolean = false;
              sfh.b(a().a());
              return;
              i = paramInt1;
              continue;
              a(8);
              break label240;
              if (this.jdField_d_of_type_AndroidViewView == null) {
                break label269;
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
          paramInt1 = 0;
          continue;
          label909:
          paramBundle = "1";
          continue;
          label916:
          paramBundle = "0";
          continue;
          label923:
          paramInt2 = 0;
          continue;
          label928:
          paramInt2 = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    qir localqir = (qir)this.app.getManager(paramInt);
    String str;
    if (localqir.a(paramString, paramBaseResData))
    {
      str = localqir.b(paramString, paramBaseResData.id);
      if (!localqir.b(paramString, paramBaseResData)) {
        break label157;
      }
      if ((261 != paramInt) || (bdiv.g(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      bdcs.a(str);
      localqir.c(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localqir.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
    return;
    label157:
    localqir.c(paramString, paramBaseResData);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    e();
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
    if (paramInt == qlc.k) {
      if (this.mIsResume)
      {
        q();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i())) {
          qzi.a().a(this.app.getCurrentAccountUin(), 1);
        }
      }
    }
    while (paramInt != qlc.l) {
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    h();
    i();
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
    syp.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setOnFlingGesture(this);
    }
    setContentView(2131559831);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131377336));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377313);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131378099);
    p();
    g();
    f();
    if (ThemeUtil.isInNightMode(this.app)) {
      a();
    }
    ozn.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690623));
    }
    QQMessageFacade localQQMessageFacade = this.app.a();
    if (localQQMessageFacade != null) {
      f(localQQMessageFacade.b());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366276));
    syp.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_Nxf = new nxf(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new nzs(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_Nxf.jdField_a_of_type_Int = getTitleBarHeight();
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
      if ((!bdag.b()) && (!bdag.d()))
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bdag.b()) && (!bdag.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      return;
    }
    if (!bdag.d())
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
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
      if (((nzt)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int != 1) {
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
            ((QQToast)localObject).c(2131692401);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692402);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!ors.f());
    if (!TextUtils.isEmpty(swy.h)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(swy.h).optInt("releaseServiceMinMem", 80);
          long l = bdcb.e();
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
            ((HashMap)localObject).put("param_totalMem", String.valueOf(bdcb.d()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(bdcb.b()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(bdcb.a()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            azmz.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
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
    syp.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    syp.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    rlb.a().a(this);
    super.doOnCreate(paramBundle);
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    qiu.jdField_b_of_type_Boolean = false;
    szp.a(this.app);
    bjxj.c(this.app);
    bjxj.d(this.app);
    oxi.b();
    oxi.c();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(162)).g();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if (6 == this.jdField_f_of_type_Int)
    {
      ors.a(3);
      ors.f();
    }
    for (;;)
    {
      oxb.a().a();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      int i = bdee.a(getApplication());
      if ((i == 4) || (i == 1)) {
        ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
      c();
      getWindow().setBackgroundDrawable(null);
      paramBundle = (oxd)this.app.getManager(163);
      owy.a().h();
      owy.a().d();
      if (this.app.a() != null) {
        this.app.a().addObserver(this);
      }
      if (bjxj.a(this.app)) {
        suv.a().c(this.app);
      }
      oxb.a().a(this.jdField_a_of_type_Oxe);
      bjxj.a(this.app);
      this.jdField_b_of_type_Int = ors.jdField_d_of_type_Int;
      szp.a(szp.a(), true, 0L, this.jdField_b_of_type_Int, 0);
      ors.g(this.app);
      q();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        qzi.a().a(this.app.getCurrentAccountUin(), 1);
      }
      syp.a("KANDIAN_NEW_FEEDS_CREATE", null);
      syp.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = ors.e();
      int j = ors.jdField_d_of_type_Int;
      sfh.a().a(this.app, l, i, j);
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
      m();
      this.jdField_a_of_type_Qjo = new qjo(this.app, 0);
      this.jdField_a_of_type_Qjo.a(new nzo(this));
      this.jdField_a_of_type_Qjo.a();
      d();
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
      sfh.b(0);
      ors.i();
      return true;
      if (9 == this.jdField_f_of_type_Int) {
        ors.a(3);
      } else if (1 == this.jdField_f_of_type_Int) {
        ors.a(8);
      } else if (2 == this.jdField_f_of_type_Int) {
        ors.a(8);
      } else if (11 == this.jdField_f_of_type_Int) {
        oxb.a().a("onConversationJumpRestoreStack");
      }
    }
  }
  
  public void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a();
      ((oxd)this.app.getManager(163)).a().h(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ((ocq)this.app.getManager(307)).a(getActivity());
      ruv.a(this).b();
      oxb.a().b(this.jdField_a_of_type_Oxe);
      ozn.a().a();
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
        nrt.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", ors.d(), false);
      }
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this);
      }
      Object localObject = (oxd)this.app.getManager(163);
      if ((localObject != null) && (((oxd)localObject).a() != null))
      {
        localObject = ((oxd)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.p();
      owy.a().i();
      rlb.a().b(this);
      PreloadManager.a().b();
      PreloadManager.a().e();
      szp.a(szp.a(), false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.h);
      syp.a();
      WebProcessManager.g();
      WebProcessManager.h();
      qzi.a();
      qzi.a().b();
      j();
      ((qja)this.app.getManager(261)).b(this);
      this.jdField_a_of_type_Qjo.b();
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        bdcs.a(qip.a(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
      }
      sfh.a().a();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
      if (this.jdField_a_of_type_Nxf != null) {
        this.jdField_a_of_type_Nxf.b();
      }
      localObject = owy.a().a();
      if (localObject != null) {
        ((pga)localObject).a(false);
      }
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      qhl.a().c();
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690623));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(3);
    ruv.a(this).a();
    owy.n();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  public void doOnResume()
  {
    syp.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    syp.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    ozn.a().a(this);
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
        if ((!str.isEmpty()) && (ors.k() == 2) && (ors.m() == 2)) {
          ((KandianMergeManager)this.app.getManager(162)).a(2, str);
        }
        getIntent().removeExtra("notification_message_id");
        if ((ors.m() == 1) || (ors.k() != 2)) {
          a(str);
        }
      }
      e();
      if (this.jdField_b_of_type_Boolean) {
        break label300;
      }
      bool = true;
      label189:
      d(bool);
      i();
      o();
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        syp.a("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        ruv.a(this).a();
      }
    }
    for (;;)
    {
      syp.a("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      a(8);
      break;
      label300:
      bool = false;
      break label189;
      ruv.a(this).a(0, 0);
      continue;
      ruv.a(this).a(3, 56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    owy.a().j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    rlb.a().a(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    owy.a().k();
  }
  
  protected void e()
  {
    e(this.jdField_e_of_type_Int);
    qja localqja = (qja)this.app.getManager(261);
    int i = 0;
    while (i < 4)
    {
      qio localqio = localqja.a(i + 4);
      if (localqio != null)
      {
        rox localrox = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a;
        localrox.c.setImageDrawable(localqio.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localrox.c.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, i);
        }
      }
      if (localqja.a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    if (bdag.c())
    {
      b(((nzt)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      qio localqio = ((qja)this.app.getManager(261)).a(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localqio.a());
      return;
    }
    ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131713386));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131375814).setOnClickListener(this);
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
    qja localqja = (qja)this.app.getManager(261);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((nzt)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localqja.a() != 0)
      {
        qio localqio = localqja.a(i + 4);
        if (localqio != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(localqio.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_Row);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()) || (System.currentTimeMillis() - bjxj.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
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
      if ((i == 0) && (ors.b(b()))) {
        this.jdField_e_of_type_Int = ((oxd)this.app.getManager(163)).a().d();
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
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(162));
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b())
          {
            i = 1;
            ors.b().post(new ReadInJoyNewFeedsActivity.7(this, i));
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
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Nxf != null) && (this.jdField_a_of_type_Nxf.a()))
    {
      this.jdField_a_of_type_Nxf.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((rjg)localObject).a() != null) && (((rjg)localObject).a().a()))
        {
          ((rjg)localObject).a().i();
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
    if ((!bjxj.i()) && (getIntent() != null) && (getIntent().getBooleanExtra("from_lock_screen", false)))
    {
      rsb.a(this);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368627: 
      if ((this.jdField_e_of_type_Int == 2) && (ors.g()))
      {
        ors.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
        nrt.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", ors.e(), false);
        return;
      }
      ors.a(this);
      aynt.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
      return;
    case 2131368659: 
    case 2131368660: 
    case 2131368661: 
      if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Nxf != null))
      {
        if (this.jdField_a_of_type_Nxf.a())
        {
          this.jdField_a_of_type_Nxf.a(null);
          return;
        }
        if ((a() instanceof ReadInJoySubChannelFragment))
        {
          this.jdField_a_of_type_Nxf.a(((ReadInJoySubChannelFragment)a()).a());
          return;
        }
        this.jdField_a_of_type_Nxf.a(0);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().e();
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
        return;
      }
    }
    a().f();
    ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
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