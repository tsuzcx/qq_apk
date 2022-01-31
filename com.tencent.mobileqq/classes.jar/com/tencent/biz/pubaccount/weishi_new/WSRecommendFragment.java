package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGlobalConfig;
import UserGrowth.stH5OpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import abtq;
import akwu;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import axlk;
import bbbm;
import bcuc;
import bdle;
import bfzl;
import bfzx;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Integer;LUserGrowth.stSimpleMetaFeed;>;
import java.util.Map<Ljava.lang.Integer;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import otm;
import rpg;
import siy;
import sjb;
import sjf;
import sjh;
import sji;
import sjj;
import sjk;
import sjl;
import sjm;
import sjn;
import sjo;
import sjp;
import sjq;
import sjv;
import sjy;
import skq;
import sli;
import slp;
import slw;
import smn;
import smp;
import smr;
import smy;
import sna;
import snb;
import snc;
import snd;
import snf;
import snk;
import vzw;
import wpt;
import wpv;
import yyt;
import yyu;

public class WSRecommendFragment
  extends PublicBaseFragment
  implements wpv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private stNotificationRsp jdField_a_of_type_UserGrowthStNotificationRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSRecommendFragment.InternetDynamicBroadCastReceiver jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  private WeiShiNoticeView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private XRecyclerView jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  private String jdField_a_of_type_JavaLangString;
  private volatile HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private siy jdField_a_of_type_Siy;
  private sjf jdField_a_of_type_Sjf;
  private slw jdField_a_of_type_Slw;
  private sna jdField_a_of_type_Sna;
  public snk a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  
  public WSRecommendFragment()
  {
    this.jdField_a_of_type_Snk = new sjh(this);
  }
  
  private int a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return 102;
    }
    switch (paramstNotificationRsp.type)
    {
    case 4: 
    case 5: 
    default: 
      return 102;
    case 1: 
    case 2: 
    case 3: 
      return 101;
    }
    return 103;
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label39;
      }
      i = k;
    }
    label39:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = paramInt;
    localWSDownloadParams.mEventId = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    localWSDownloadParams.mTestId = snf.a(4);
    stReportItem localstReportItem = smn.a();
    localstReportItem.pagetype = 4;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    localWSDownloadParams.mScheme = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    return localWSDownloadParams;
  }
  
  private String a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return "weishi://main";
    }
    if (!TextUtils.isEmpty(paramstNotificationRsp.scheme_url)) {
      return paramstNotificationRsp.scheme_url;
    }
    switch (paramstNotificationRsp.type)
    {
    default: 
      return "weishi://main";
    case 1: 
    case 2: 
    case 3: 
      return "weishi://message";
    case 4: 
      return "weishi://main";
    case 6: 
      return "weishi://main";
    }
    return "weishi://main";
  }
  
  private String a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null)
    {
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mFeedIds;
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mPushId;
    }
    for (boolean bool = snf.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);; bool = false)
    {
      String str3 = str1;
      if (!paramBoolean)
      {
        str3 = str1;
        if (TextUtils.isEmpty(str1))
        {
          str3 = str1;
          if (paramstSimpleMetaFeed != null) {
            str3 = paramstSimpleMetaFeed.id;
          }
        }
      }
      int i;
      int j;
      if (bool)
      {
        i = sjv.a().a();
        if (!bool) {
          break label178;
        }
        j = 1;
        label89:
        if (!paramBoolean) {
          break label184;
        }
      }
      label178:
      label184:
      for (int k = 1;; k = 2)
      {
        str1 = "-";
        stReportItem localstReportItem = smn.a(paramstSimpleMetaFeed, 0);
        paramstSimpleMetaFeed = str1;
        if (localstReportItem != null) {
          paramstSimpleMetaFeed = localstReportItem.authorid;
        }
        smp.a(301, new Object[] { Integer.valueOf(paramInt), smp.a(str2, str3, i, j, k) });
        WSPublicAccReport.getInstance().reportPublicAccDataExposure(str3, paramstSimpleMetaFeed, j, k, i);
        return str3;
        i = 0;
        break;
        j = 0;
        break label89;
      }
      str2 = "0";
      str1 = "";
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, -1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramInt);
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WSRecommendFragment.7(this, paramInt, paramstSimpleMetaFeed));
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, Integer paramInteger, stReportItem paramstReportItem, ArrayList<stReportItem> paramArrayList)
  {
    stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
    if ((localstH5OpInfo != null) && (localstH5OpInfo.type > 0))
    {
      stReportItem localstReportItem = smn.a(paramstSimpleMetaFeed, paramInteger.intValue());
      if (localstH5OpInfo.type == 1) {}
      for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
      {
        localstReportItem.optype = 6;
        paramArrayList.add(localstReportItem);
        smp.a(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_exposure", 0, paramstSimpleMetaFeed.h5_op_info.id);
        snb.a("weishi-report", "luopan report H5");
        paramstReportItem.pagetype = 1;
        return;
      }
    }
    if (paramstSimpleMetaFeed.video_type == 6)
    {
      paramstReportItem.pagetype = 1;
      smp.a(false);
      snb.a("weishi-report", "luopan report NOW");
      return;
    }
    paramstReportItem.pagetype = 1;
    snb.b("weishi-report", "luopan normal is no need report");
  }
  
  public static void a(Context paramContext)
  {
    abtq.a(paramContext, PublicFragmentActivity.class, WSRecommendFragment.class);
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (paramstGlobalConfig != null) {
      snb.d("WSRecommendFragment", "RockDownloader:" + paramstGlobalConfig.download);
    }
    for (int i = paramstGlobalConfig.link_strategy_type;; i = 1)
    {
      skq.a().a(getActivity(), i, (stSimpleMetaFeed)paramList.get(0));
      if (paramBoolean) {
        skq.a().a();
      }
      if (i == 7)
      {
        if ((paramstGlobalConfig.jumpinfo == null) || (TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url))) {
          break label168;
        }
        sjp.a(this.jdField_a_of_type_AndroidContentContext, paramstGlobalConfig.jumpinfo.h5url);
      }
      label168:
      for (i = j;; i = 2)
      {
        smp.a(i, 2, paramString);
        do
        {
          return;
          if (i == 3)
          {
            b(paramList);
            return;
          }
          if (i != 4) {
            break;
          }
        } while (!vzw.a(this.jdField_a_of_type_AndroidContentContext));
        a(paramList);
        return;
        a(paramList);
        return;
      }
    }
  }
  
  private void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    try
    {
      i = a();
      int j = b();
      i = i - j + 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        snb.d("WSRecommendFragment", "exposeRefreshCard getLastVisiblePosition error: " + localException.getMessage());
        int i = 4;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WSRecommendFragment.8(this, i, paramList, paramBoolean));
  }
  
  private void a(Map<Integer, stSimpleMetaFeed> paramMap, Map<Integer, String> paramMap1)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject4 = (Map.Entry)paramMap.next();
        localObject3 = (Integer)((Map.Entry)localObject4).getKey();
        localObject4 = (stSimpleMetaFeed)((Map.Entry)localObject4).getValue();
        stReportItem localstReportItem = smn.a((stSimpleMetaFeed)localObject4, ((Integer)localObject3).intValue());
        a((stSimpleMetaFeed)localObject4, (Integer)localObject3, localstReportItem, (ArrayList)localObject2);
        localstReportItem.optype = 6;
        snb.a("weishi-report", "推荐实时上报:" + localstReportItem.feedid + ", upos:" + localstReportItem.upos);
        ((ArrayList)localObject2).add(localstReportItem);
        localObject3 = snf.a((stSimpleMetaFeed)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("_");
          localStringBuilder.append("0");
          localStringBuilder.append("_");
        }
      }
      if (((StringBuilder)localObject1).length() <= 1) {
        break label599;
      }
    }
    label590:
    label599:
    for (paramMap = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1)
    {
      if (localStringBuilder.length() > 1) {
        localStringBuilder = new StringBuilder(localStringBuilder.substring(0, localStringBuilder.length() - 1));
      }
      for (;;)
      {
        smn.a((ArrayList)localObject2);
        while ((paramMap1 != null) && (paramMap1.size() > 0))
        {
          localObject1 = new StringBuilder();
          paramMap1 = paramMap1.entrySet().iterator();
          for (;;)
          {
            if (paramMap1.hasNext())
            {
              localObject3 = (Map.Entry)paramMap1.next();
              localObject2 = (Integer)((Map.Entry)localObject3).getKey();
              localObject3 = (String)((Map.Entry)localObject3).getValue();
              snb.a("weishi-report", "898实时上报:" + (String)localObject3 + ", upos:" + localObject2);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                ((StringBuilder)localObject1).append((String)localObject3);
                ((StringBuilder)localObject1).append("_");
                continue;
                snb.c("weishi-report", "推荐上报的feeds为0个");
                paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
                break;
              }
            }
          }
          if (((StringBuilder)localObject1).length() <= 1) {
            break label590;
          }
        }
        for (paramMap1 = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap1 = (Map<Integer, String>)localObject1)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("feedid", paramMap1.toString());
          ((Map)localObject1).put("cover_type", paramMap.toString());
          ((Map)localObject1).put("dynamic_cover", localStringBuilder.toString());
          paramMap = new JSONObject((Map)localObject1);
          snb.c("weishi-report", "jsonObj:" + paramMap);
          smp.a(303, paramMap.toString());
          return;
          snb.c("weishi-report", "898上报的feeds为0个");
          return;
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = 9216;
    if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.d()) && (!bbbm.b())) {
      if (paramBoolean) {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      }
    }
    do
    {
      return paramBoolean;
      i = 1280;
      break;
      if (!ImmersiveUtils.a()) {
        break label110;
      }
      ImmersiveUtils.a(getActivity().getWindow(), paramBoolean);
    } while ((Build.VERSION.SDK_INT < 23) || (!bbbm.b()));
    if (paramBoolean) {}
    for (;;)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      return paramBoolean;
      i = 1280;
    }
    label110:
    return false;
  }
  
  private int b()
  {
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if ((localRecyclerViewWithHeaderFooter == null) || (localRecyclerViewWithHeaderFooter.getAdapter() == null) || (this.jdField_a_of_type_Sjf == null)) {
      return 0;
    }
    return ((bfzx)localRecyclerViewWithHeaderFooter.getAdapter()).a();
  }
  
  private void b(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() > 0)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(0);
      localArrayList.add(paramList.get(0));
      snf.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, 0, localstSimpleMetaFeed.poster_id, this.jdField_a_of_type_UserGrowthStGlobalConfig, 2);
    }
  }
  
  private void c()
  {
    otm localotm = snf.a();
    if (localotm != null) {
      localotm.a(getActivity());
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(0);
      a(false);
      return;
    }
    if (a(true))
    {
      a(-1);
      return;
    }
    a(-2368549);
  }
  
  private void d()
  {
    smy.a().b();
    boolean bool = smy.a().a();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "WSRecommendFragment onAttach start!! preloadInWsRecommend = " + bool);
    if (bool) {
      smy.a().a();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_e_of_type_Long;
    snb.c("weishi-report", "瀑布流拿到Notification的时间点：" + l1 + ",请求接口耗时：" + l2 + "毫秒");
    smr.a().c(paramBoolean, l2);
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void e()
  {
    snb.d("weishi-report", "hasClickFuceng:" + snf.jdField_a_of_type_Boolean + ",mHasRefresh:" + this.jdField_c_of_type_Boolean + ",mHasScroll:" + this.jdField_d_of_type_Boolean);
    if ((!this.jdField_b_of_type_Boolean) || ((!snf.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))) {
      smn.a(137, 1, null);
    }
  }
  
  private void f()
  {
    int i = 2;
    if (!sjq.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      snb.a("weishi-report", "用户退出公众号，一共使用:" + this.jdField_b_of_type_Long + "毫秒");
      this.jdField_c_of_type_Long = 0L;
    }
    smp.a(117, new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    smr.a().a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Slw.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap.size(), snf.jdField_a_of_type_Boolean, snd.jdField_a_of_type_Boolean);
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      WSPublicAccReport.getInstance().closePublicAccReport(i);
      g();
      return;
      if ((!snf.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
  
  private void g()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Sna != null)
    {
      this.jdField_a_of_type_Sna.a();
      this.jdField_a_of_type_Sna = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  private void i()
  {
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      snb.a("weishi-815", "is night mode");
      c(true);
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374821)).inflate();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849070);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842605);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    do
    {
      return;
      snb.a("weishi-815", "is day mode");
      c(false);
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372612));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372608));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372610));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372611));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new sji(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new sjj(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559784, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new sjk(this));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375021));
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (localObject != null) {
      ((bfzl)localObject).a(12);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new sjl(this));
    localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_Sjf = new sjf(getActivity(), (RecyclerViewWithHeaderFooter)localObject);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.jdField_a_of_type_Sjf);
    this.jdField_a_of_type_Sjf.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
    this.jdField_a_of_type_Sjf.a(new sjm(this));
    sjo localsjo = new sjo(2, 1);
    localsjo.setGapStrategy(0);
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(localsjo);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new sjb());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371404);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369469));
    int i = axlk.a(this.jdField_a_of_type_AndroidContentContext);
    if (i > 1920) {}
    try
    {
      this.jdField_a_of_type_Sna = new sna();
      localObject = this.jdField_a_of_type_Sna.a();
      if (!((HandlerThread)localObject).isAlive()) {
        ((HandlerThread)localObject).start();
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
      return;
    }
    catch (Exception localException)
    {
      snb.b("WSRecommendFragment", "HandlerThread Exception.");
    }
  }
  
  private void k()
  {
    snb.b("WSRecommendFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(8);
    smn.a(135, 1, null);
    smp.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new sjn(this));
  }
  
  private void l()
  {
    ThreadManager.getSubThreadHandler().post(new WSRecommendFragment.10(this));
  }
  
  public int a()
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a() != null)
      {
        RecyclerView.LayoutManager localLayoutManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getLayoutManager();
        i = j;
        if ((localLayoutManager instanceof StaggeredGridLayoutManager))
        {
          int[] arrayOfInt = new int[((StaggeredGridLayoutManager)localLayoutManager).getSpanCount()];
          ((StaggeredGridLayoutManager)localLayoutManager).findLastVisibleItemPositions(arrayOfInt);
          i = a(arrayOfInt);
        }
      }
    }
    return i;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ForeBackgroundEvent.class);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt, String paramString)
  {
    snb.b("WSRecommendFragment", "onGetNotificationFailed" + paramInt + " | " + paramString);
    this.jdField_e_of_type_Long = 0L;
    skq.b(2);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    snb.d("WSRecommendFragment", "onLoadDataFailed:" + paramInt + " | " + paramString);
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Slw.a())
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
        return;
      }
      k();
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false, true);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, sli paramsli)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    d(true);
    b(true);
    skq.a(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a(paramstNotificationRsp, paramsli);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ForeBackgroundEvent))
    {
      if (((ForeBackgroundEvent)paramSimpleBaseEvent).mIsBackground)
      {
        WSPublicAccReport.getInstance().backgroundPublicAccReport();
        l();
      }
    }
    else {
      return;
    }
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    if (this.jdField_a_of_type_Siy == null) {
      this.jdField_a_of_type_Siy = new siy(getActivity());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (stSimpleMetaFeed)paramList.get(0);
      if (paramList != null)
      {
        paramList = "weishi://feed?feed_id=" + paramList.id;
        this.jdField_a_of_type_Siy.a(paramList);
      }
    }
    this.jdField_a_of_type_Siy.a(this.jdField_a_of_type_UserGrowthStGlobalConfig);
    this.jdField_a_of_type_Siy.a(getActivity(), 0);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, sli paramsli, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    snb.b("WSRecommendFragment", "onLoadDataSuccess:" + paramList.size() + ", isFirstFromService:" + paramBoolean1);
    if (paramsli != null)
    {
      this.jdField_b_of_type_Boolean = true;
      snb.b("WSRecommendFragment", "onLoadDataSuccess AbTestId = " + paramsli.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_UserGrowthStGlobalConfig = sjy.a().a();
    snb.b("WSRecommendFragment", "mStGlobalConfig from WSGlobalConfig");
    int i;
    if (paramBoolean1) {
      if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
      {
        i = this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
        paramsli = a(false, i, (stSimpleMetaFeed)paramList.get(0));
        a(paramList, this.jdField_a_of_type_UserGrowthStGlobalConfig, paramsli, paramBoolean4);
        if (!paramBoolean4) {
          break label236;
        }
        paramList.remove(0);
        this.jdField_a_of_type_Sjf.a(paramList);
      }
    }
    for (;;)
    {
      if ((paramBoolean2) || (paramBoolean1))
      {
        this.jdField_a_of_type_Int = paramList.size();
        if (!paramBoolean4) {
          a(paramList, paramBoolean1);
        }
      }
      if ((paramBoolean3) || (paramBoolean4)) {
        snf.a(paramList);
      }
      if (paramBoolean1)
      {
        snc.a();
        snc.a(sjy.a().a());
      }
      return;
      i = 1;
      break;
      label236:
      b();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
      if (this.jdField_a_of_type_Slw.a()) {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
      }
      this.jdField_a_of_type_Sjf.a(paramList);
      this.jdField_a_of_type_Slw.a(false, false, "");
      continue;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
        this.jdField_a_of_type_Sjf.a(paramList);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, paramBoolean3);
        this.jdField_a_of_type_Sjf.a(paramList);
      }
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    b();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
    if (paramBoolean2) {
      a(true, -1, null);
    }
    if (paramBoolean1) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null) {
        break label99;
      }
    }
    label99:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      this.jdField_a_of_type_Slw.a(false, true, true, str);
      a(paramList, false);
      this.jdField_a_of_type_Sjf.a(paramList);
      this.jdField_a_of_type_Int = paramList.size();
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.b();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      ((bfzx)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
    for (;;)
    {
      ((bfzx)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).notifyDataSetChanged();
      return;
      ((bfzx)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if (!this.f)
    {
      this.f = true;
      skq.a().b();
      l();
      h();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver != null) {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver);
      }
      rpg.a().a();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_Sjf != null)
      {
        List localList = this.jdField_a_of_type_Sjf.a();
        sjv.a().a(localList, this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Sjf.jdField_a_of_type_Skm != null) {
          this.jdField_a_of_type_Sjf.jdField_a_of_type_Skm = null;
        }
        if (this.jdField_a_of_type_Sjf.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
          this.jdField_a_of_type_Sjf.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
        }
      }
      sjf.b = 0;
      wpt.a().b(this);
      snf.jdField_a_of_type_AndroidUtilSparseArray.clear();
      slp.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg == null) {}
    for (paramBundle = "";; paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      skq.a().a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Slw.a(paramBundle);
      this.jdField_a_of_type_Slw.b(paramBundle);
      return;
    }
  }
  
  public boolean onBackEvent()
  {
    snb.b("weishi-beacon", "onBackEvent");
    f();
    e();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bdle.a();
    d();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    snb.a("weishi-report", "进入瀑布流的时间：" + this.jdField_d_of_type_Long);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    paramBundle = new IntentFilter();
    paramBundle.addAction("weishi_public_account_ding_state_change");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver = new WSRecommendFragment.InternetDynamicBroadCastReceiver(this);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver, paramBundle);
    paramBundle = new yyu();
    yyt.a().a(this.jdField_a_of_type_AndroidContentContext, paramBundle);
    slw.c("");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = snf.a();
    this.jdField_a_of_type_JavaLangString = snf.b();
    c();
    wpt.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131559782, paramViewGroup, false));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDetach()
  {
    super.onDetach();
    bcuc.a(BaseApplicationImpl.getContext(), true);
  }
  
  public void onPause()
  {
    super.onPause();
    akwu.a(getActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    if (!sjq.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      smp.a(6, smp.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg));
      if (this.jdField_d_of_type_Long > 0L)
      {
        long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
        this.jdField_d_of_type_Long = 0L;
        snb.b("weishi-report", "page init cost：" + l);
        smn.a();
        smr.a().a(true, l);
      }
      bcuc.a(BaseApplicationImpl.getContext(), false);
      return;
      sjq.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    j();
    this.jdField_a_of_type_Slw = new slw(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */