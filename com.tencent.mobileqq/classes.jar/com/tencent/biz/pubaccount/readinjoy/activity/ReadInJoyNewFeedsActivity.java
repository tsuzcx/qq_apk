package com.tencent.biz.pubaccount.readinjoy.activity;

import ajya;
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
import awsq;
import axrn;
import bbbm;
import bbdh;
import bbdv;
import bbdx;
import bbfj;
import bbkb;
import bcql;
import bhvy;
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
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
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
import nol;
import npu;
import nua;
import nwf;
import nwk;
import nwn;
import nwo;
import nwp;
import nzg;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import ory;
import orz;
import osg;
import osj;
import osl;
import osm;
import osq;
import ouj;
import par;
import pyn;
import pyt;
import pyu;
import pyw;
import pyz;
import pzf;
import pzs;
import pzt;
import qbg;
import qkb;
import qtr;
import qva;
import qvk;
import qzf;
import qzg;
import rez;
import rho;
import rpi;
import sdc;
import sfe;
import sgu;
import shu;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, TopGestureLayout.OnGestureListener, Observer, ory, orz, pzs
{
  public static List<String> a;
  public static ConcurrentHashMap<Integer, nwp> a;
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
  public nua a;
  protected osm a;
  protected pzt a;
  qzf jdField_a_of_type_Qzf = new nwn(this);
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
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new nwp(ajya.a(2131693701), 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new nwp(ajya.a(2131712896), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new nwp(ajya.a(2131713053), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new nwp(ajya.a(2131712800), 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_Osm = new nwf(this);
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
      paramBundle = onh.a();
      paramBundle.put("kandian_mode", onh.e());
      paramBundle.put("tab_source", 3);
      nol.a(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), paramBundle.toString(), false);
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
      onh.d(2);
      return;
    }
    if (paramInt == 5)
    {
      onh.d(1);
      return;
    }
    if (paramInt == 1)
    {
      onh.d(4);
      return;
    }
    if ((paramInt == 6) || (paramInt == 9))
    {
      onh.d(7);
      return;
    }
    onh.d(5);
  }
  
  private void m()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (pzf)((AppInterface)localObject).getManager(261);
      if (localObject != null) {
        ((pzf)localObject).a(this);
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (pzf)((AppInterface)localObject).getManager(261);
      ((pzf)localObject).b(this);
      ((pzf)localObject).a();
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
          JSONObject localJSONObject = onh.a();
          localJSONObject.put("kandian_mode", onh.e());
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
          nol.a(null, "CliOper", "", str2, "0X80081C6", "0X80081C6", 0, 1, null, null, str1, localJSONObject.toString(), false);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName = ajya.a(2131712983);
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
        bool = onh.a;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.jdField_e_of_type_Int + "and rednums is" + b());
        return;
        if (this.jdField_e_of_type_Int == 1) {
          bool = onh.a;
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
      Object localObject2 = (pzf)this.app.getManager(261);
      if (((pzf)localObject2).a() != 0)
      {
        paramBundle = ((pzf)localObject2).a(i + 4);
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
      setTitle(((nwp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
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
        nol.a(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", npu.a(paramBundle), false);
        if (this.jdField_e_of_type_Int == i)
        {
          paramInt1 = 1;
          this.jdField_e_of_type_Int = i;
          jdField_c_of_type_Int = this.jdField_e_of_type_Int;
          k();
          if ((this.jdField_e_of_type_Int == 2) && (onh.g())) {
            d(2130842298);
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
          ((JSONObject)localObject3).put("folder_status", onh.jdField_d_of_type_Int);
          if (j <= 0) {
            break label909;
          }
          paramBundle = "2";
          ((JSONObject)localObject3).put("reddot", paramBundle);
          ((JSONObject)localObject3).put("kandian_mode", onh.e());
          ((JSONObject)localObject3).put("kandian_mode_new", npu.a());
          if ((((pzf)localObject2).a() != 1) || (TextUtils.isEmpty(((pzf)localObject2).a()))) {
            break label916;
          }
          paramBundle = ((pzf)localObject2).a();
          ((JSONObject)localObject3).put("skin_id", paramBundle);
          if (!bool) {
            break label923;
          }
          paramInt2 = 1;
          ((JSONObject)localObject3).put("button_state", paramInt2);
          if (a().a() == 0)
          {
            paramBundle = pyz.b(getActivity(), 0);
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
              nol.a(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(i + 1), "", "", paramBundle, false);
              continue;
              sgu.a(null, "recommend_tab_cost");
              continue;
              sgu.a(null, "video_tab_cost");
              continue;
              sgu.a(null, "subscribe_tab_cost");
              continue;
              sgu.a(null, "self_tab_cost");
              continue;
              rez.a(this).a(0, 0);
              continue;
              rez.a(this).a(3, 56);
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
          nol.a(this.app, (String)localObject2, "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(i + 1), "", (String)localObject1, paramBundle, false);
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              rez.a(this).a();
              this.jdField_c_of_type_Boolean = false;
              rpi.b(a().a());
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
    pyw localpyw = (pyw)this.app.getManager(paramInt);
    String str;
    if (localpyw.a(paramString, paramBaseResData))
    {
      str = localpyw.b(paramString, paramBaseResData.id);
      if (!localpyw.b(paramString, paramBaseResData)) {
        break label157;
      }
      if ((261 != paramInt) || (bbkb.g(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      bbdx.a(str);
      localpyw.c(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localpyw.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
    return;
    label157:
    localpyw.c(paramString, paramBaseResData);
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
    if (paramInt == qbg.k) {
      if (this.mIsResume)
      {
        q();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i())) {
          qkb.a().a(this.app.getCurrentAccountUin(), 1);
        }
      }
    }
    while (paramInt != qbg.l) {
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
    sgu.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setOnFlingGesture(this);
    }
    setContentView(2131559770);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131376823));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131376800);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131377562);
    p();
    g();
    f();
    if (ThemeUtil.isInNightMode(this.app)) {
      a();
    }
    ouj.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690572));
    }
    QQMessageFacade localQQMessageFacade = this.app.a();
    if (localQQMessageFacade != null) {
      f(localQQMessageFacade.b());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366188));
    sgu.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_Nua = new nua(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new nwo(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_Nua.jdField_a_of_type_Int = getTitleBarHeight();
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
      if ((!bbbm.b()) && (!bbbm.d()))
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      return;
    }
    if (!bbbm.d())
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
      if (((nwp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int != 1) {
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
          localObject = new bcql(this);
          ((bcql)localObject).d(2000);
          if (i != 0)
          {
            ((bcql)localObject).a(bcql.a(2));
            ((bcql)localObject).c(2131692325);
            ((bcql)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((bcql)localObject).a(bcql.a(1));
            ((bcql)localObject).c(2131692326);
            ((bcql)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131298865) - (int)bbdv.a(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!onh.f());
    if (!TextUtils.isEmpty(sfe.h)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(sfe.h).optInt("releaseServiceMinMem", 80);
          long l = bbdh.e();
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
            ((HashMap)localObject).put("param_totalMem", String.valueOf(bbdh.d()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(bbdh.b()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(bbdh.a()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            axrn.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
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
    sgu.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    sgu.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    qvk.a().a(this);
    super.doOnCreate(paramBundle);
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    pyz.jdField_b_of_type_Boolean = false;
    shu.a(this.app);
    bhvy.c(this.app);
    bhvy.d(this.app);
    osq.b();
    osq.c();
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
      onh.a(3);
      onh.f();
    }
    for (;;)
    {
      osj.a().a();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      int i = bbfj.a(getApplication());
      if ((i == 4) || (i == 1)) {
        ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
      c();
      getWindow().setBackgroundDrawable(null);
      paramBundle = (osl)this.app.getManager(163);
      osg.a().h();
      osg.a().d();
      if (this.app.a() != null) {
        this.app.a().addObserver(this);
      }
      if (bhvy.a(this.app)) {
        sdc.a().c(this.app);
      }
      osj.a().a(this.jdField_a_of_type_Osm);
      bhvy.a(this.app);
      this.jdField_b_of_type_Int = onh.jdField_d_of_type_Int;
      shu.a(shu.a(), true, 0L, this.jdField_b_of_type_Int, 0);
      onh.g(this.app);
      q();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        qkb.a().a(this.app.getCurrentAccountUin(), 1);
      }
      sgu.a("KANDIAN_NEW_FEEDS_CREATE", null);
      sgu.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = onh.e();
      int j = onh.jdField_d_of_type_Int;
      rpi.a().a(this.app, l, i, j);
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
      m();
      this.jdField_a_of_type_Pzt = new pzt(this.app, 0);
      this.jdField_a_of_type_Pzt.a(new nwk(this));
      this.jdField_a_of_type_Pzt.a();
      d();
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
      rpi.b(0);
      onh.g();
      return true;
      if (9 == this.jdField_f_of_type_Int) {
        onh.a(3);
      } else if (1 == this.jdField_f_of_type_Int) {
        onh.a(8);
      } else if (2 == this.jdField_f_of_type_Int) {
        onh.a(8);
      } else if (11 == this.jdField_f_of_type_Int) {
        osj.a().a("onConversationJumpRestoreStack");
      }
    }
  }
  
  public void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a();
      ((osl)this.app.getManager(163)).a().h(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ((nzg)this.app.getManager(307)).a(getActivity());
      rez.a(this).b();
      osj.a().b(this.jdField_a_of_type_Osm);
      ouj.a().a();
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
        nol.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", onh.d(), false);
      }
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this);
      }
      Object localObject = (osl)this.app.getManager(163);
      if ((localObject != null) && (((osl)localObject).a() != null))
      {
        localObject = ((osl)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.p();
      osg.a().i();
      qvk.a().b(this);
      PreloadManager.a().b();
      PreloadManager.a().e();
      shu.a(shu.a(), false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.h);
      sgu.a();
      WebProcessManager.g();
      WebProcessManager.h();
      qkb.a();
      qkb.a().b();
      j();
      ((pzf)this.app.getManager(261)).b(this);
      this.jdField_a_of_type_Pzt.b();
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        bbdx.a(pyu.a(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
      }
      rpi.a().a();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
      if (this.jdField_a_of_type_Nua != null) {
        this.jdField_a_of_type_Nua.b();
      }
      localObject = osg.a().a();
      if (localObject != null) {
        ((par)localObject).a(false);
      }
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      pyn.a().c();
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690572));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(3);
    rez.a(this).a();
    osg.n();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  public void doOnResume()
  {
    sgu.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    sgu.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    ouj.a().a(this);
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
        if ((!str.isEmpty()) && (onh.k() == 2) && (onh.m() == 2)) {
          ((KandianMergeManager)this.app.getManager(162)).a(2, str);
        }
        getIntent().removeExtra("notification_message_id");
        if ((onh.m() == 1) || (onh.k() != 2)) {
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
        sgu.a("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        rez.a(this).a();
      }
    }
    for (;;)
    {
      sgu.a("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      a(8);
      break;
      label300:
      bool = false;
      break label189;
      rez.a(this).a(0, 0);
      continue;
      rez.a(this).a(3, 56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    osg.a().j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    qvk.a().a(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    osg.a().k();
  }
  
  protected void e()
  {
    e(this.jdField_e_of_type_Int);
    pzf localpzf = (pzf)this.app.getManager(261);
    int i = 0;
    while (i < 4)
    {
      pyt localpyt = localpzf.a(i + 4);
      if (localpyt != null)
      {
        qzg localqzg = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a;
        localqzg.c.setImageDrawable(localpyt.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localqzg.c.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, i);
        }
      }
      if (localpzf.a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    if (bbbm.c())
    {
      b(((nwp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      pyt localpyt = ((pzf)this.app.getManager(261)).a(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localpyt.a());
      return;
    }
    ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131713014));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131375331).setOnClickListener(this);
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
    pzf localpzf = (pzf)this.app.getManager(261);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((nwp)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localpzf.a() != 0)
      {
        pyt localpyt = localpzf.a(i + 4);
        if (localpyt != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(localpyt.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_Qzf);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()) || (System.currentTimeMillis() - bhvy.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
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
      if ((i == 0) && (onh.b(b()))) {
        this.jdField_e_of_type_Int = ((osl)this.app.getManager(163)).a().d();
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
            onh.b().post(new ReadInJoyNewFeedsActivity.7(this, i));
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
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Nua != null) && (this.jdField_a_of_type_Nua.a()))
    {
      this.jdField_a_of_type_Nua.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((qtr)localObject).a() != null) && (((qtr)localObject).a().a()))
        {
          ((qtr)localObject).a().g();
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
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368441: 
      if ((this.jdField_e_of_type_Int == 2) && (onh.g()))
      {
        onh.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
        nol.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", onh.e(), false);
        return;
      }
      onh.a(this);
      awsq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
      return;
    case 2131368472: 
    case 2131368473: 
    case 2131368474: 
      if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Nua != null))
      {
        if (this.jdField_a_of_type_Nua.a())
        {
          this.jdField_a_of_type_Nua.a(null);
          return;
        }
        if ((a() instanceof ReadInJoySubChannelFragment))
        {
          this.jdField_a_of_type_Nua.a(((ReadInJoySubChannelFragment)a()).a());
          return;
        }
        this.jdField_a_of_type_Nua.a(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */