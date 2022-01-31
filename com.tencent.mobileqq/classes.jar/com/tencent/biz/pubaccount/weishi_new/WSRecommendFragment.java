package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGlobalConfig;
import UserGrowth.stH5OpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import aaos;
import aaot;
import amnk;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import azgq;
import betl;
import bfkb;
import bhzz;
import biai;
import biau;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
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
import oye;
import sff;
import tax;
import tbp;
import tby;
import tca;
import tcb;
import tcc;
import tcd;
import tce;
import tcf;
import tcg;
import tch;
import tci;
import tcq;
import tee;
import tfd;
import tff;
import tfi;
import tgu;
import thb;
import tip;
import tjl;
import tjm;
import tjr;
import tju;
import tjz;
import tld;
import tlk;
import tlo;
import tlp;
import tlq;
import tlv;
import tmc;
import xoo;
import yej;
import yel;

public class WSRecommendFragment
  extends WSBaseHomeFragment<tjm, tjl, List<stSimpleMetaFeed>>
  implements tfi, tjm, yel
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private stNotificationRsp jdField_a_of_type_UserGrowthStNotificationRsp;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public FrameLayout a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSRecommendFragment.InternetDynamicBroadCastReceiver jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  private WeiShiNoticeView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView;
  private String jdField_a_of_type_JavaLangString;
  private volatile HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private tax jdField_a_of_type_Tax;
  private tby jdField_a_of_type_Tby;
  private tlk jdField_a_of_type_Tlk;
  public tmc a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public WSRecommendFragment()
  {
    this.jdField_a_of_type_Tmc = new tca(this);
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
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = paramInt;
    localWSDownloadParams.mEventId = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    localWSDownloadParams.mTestId = tlv.a(4);
    stReportItem localstReportItem = tjr.a();
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
    for (boolean bool = tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);; bool = false)
    {
      if ((!paramBoolean) && (TextUtils.isEmpty(str1)) && (paramstSimpleMetaFeed != null)) {
        str1 = paramstSimpleMetaFeed.id;
      }
      for (;;)
      {
        int i;
        int j;
        if (bool)
        {
          i = tcq.a().a();
          if (!bool) {
            break label158;
          }
          j = 1;
          label77:
          if (!paramBoolean) {
            break label164;
          }
        }
        label158:
        label164:
        for (int k = 1;; k = 2)
        {
          Object localObject = tjr.a(paramstSimpleMetaFeed, 0);
          if (localObject != null) {
            localObject = ((stReportItem)localObject).authorid;
          }
          tju.a(301, new Object[] { Integer.valueOf(paramInt), tju.a(str2, str1, i, j, k) });
          WSPublicAccReport.getInstance().reportPublicAccDataExposure(paramstSimpleMetaFeed, j, k, i);
          return str1;
          i = 0;
          break;
          j = 0;
          break label77;
        }
      }
      str2 = "0";
      str1 = "";
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WSRecommendFragment.6(this, paramInt, paramstSimpleMetaFeed));
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, Integer paramInteger, stReportItem paramstReportItem, ArrayList<stReportItem> paramArrayList)
  {
    stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
    if ((localstH5OpInfo != null) && (localstH5OpInfo.type > 0))
    {
      stReportItem localstReportItem = tjr.a(paramstSimpleMetaFeed, paramInteger.intValue());
      if (localstH5OpInfo.type == 1) {}
      for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
      {
        localstReportItem.optype = 6;
        paramArrayList.add(localstReportItem);
        tju.a(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_exposure", 0, paramstSimpleMetaFeed);
        tlo.a("weishi-report", "luopan report H5");
        paramstReportItem.pagetype = 1;
        return;
      }
    }
    if (paramstSimpleMetaFeed.video_type == 6)
    {
      paramstReportItem.pagetype = 1;
      tju.a(false);
      tlo.a("weishi-report", "luopan report NOW");
      return;
    }
    paramstReportItem.pagetype = 1;
    tlo.b("weishi-report", "luopan normal is no need report");
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (paramstGlobalConfig != null) {
      tlo.d("WSRecommendFragment", "RockDownloader:" + paramstGlobalConfig.download);
    }
    for (int i = paramstGlobalConfig.link_strategy_type;; i = 1)
    {
      tfd.a().a(getActivity(), i, (stSimpleMetaFeed)paramList.get(0));
      tfd.a().a();
      if (i == 7)
      {
        if ((paramstGlobalConfig.jumpinfo == null) || (TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url))) {
          break label163;
        }
        tch.a(this.jdField_a_of_type_AndroidContentContext, paramstGlobalConfig.jumpinfo.h5url);
      }
      label163:
      for (i = j;; i = 2)
      {
        tju.a(i, 2, paramString);
        do
        {
          return;
          if (i == 3)
          {
            c(paramList);
            return;
          }
          if (i != 4) {
            break;
          }
        } while (!xoo.a(this.jdField_a_of_type_AndroidContentContext));
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
      i = b();
      int j = c();
      i = i - j + 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        tlo.d("WSRecommendFragment", "exposeRefreshCard getLastVisiblePosition error: " + localException.getMessage());
        int i = 4;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WSRecommendFragment.7(this, i, paramList, paramBoolean));
  }
  
  private void a(Map<Integer, stSimpleMetaFeed> paramMap, Map<Integer, String> paramMap1)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3;
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject4 = (Map.Entry)paramMap.next();
        localObject3 = (Integer)((Map.Entry)localObject4).getKey();
        localObject4 = (stSimpleMetaFeed)((Map.Entry)localObject4).getValue();
        stReportItem localstReportItem = tjr.a((stSimpleMetaFeed)localObject4, ((Integer)localObject3).intValue());
        a((stSimpleMetaFeed)localObject4, (Integer)localObject3, localstReportItem, (ArrayList)localObject2);
        localstReportItem.optype = 6;
        tlo.a("weishi-report", "推荐实时上报:" + localstReportItem.feedid + ", upos:" + localstReportItem.upos);
        ((ArrayList)localObject2).add(localstReportItem);
        localObject3 = tlv.a((stSimpleMetaFeed)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("_");
          localStringBuilder.append("0");
          localStringBuilder.append("_");
        }
      }
      if (((StringBuilder)localObject1).length() <= 1) {
        break label591;
      }
    }
    label582:
    label591:
    for (paramMap = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1)
    {
      if (localStringBuilder.length() > 1) {
        localStringBuilder = new StringBuilder(localStringBuilder.substring(0, localStringBuilder.length() - 1));
      }
      for (;;)
      {
        tjr.a((ArrayList)localObject2);
        while (paramMap1.size() > 0)
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
              tlo.a("weishi-report", "898实时上报:" + (String)localObject3 + ", upos:" + localObject2);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                ((StringBuilder)localObject1).append((String)localObject3);
                ((StringBuilder)localObject1).append("_");
                continue;
                tlo.c("weishi-report", "推荐上报的feeds为0个");
                paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
                break;
              }
            }
          }
          if (((StringBuilder)localObject1).length() <= 1) {
            break label582;
          }
        }
        for (paramMap1 = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap1 = (Map<Integer, String>)localObject1)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("feedid", paramMap1.toString());
          ((Map)localObject1).put("cover_type", paramMap.toString());
          ((Map)localObject1).put("dynamic_cover", localStringBuilder.toString());
          paramMap = new JSONObject((Map)localObject1);
          tlo.c("weishi-report", "jsonObj:" + paramMap);
          tju.a(303, paramMap.toString());
          return;
          tlo.c("weishi-report", "898上报的feeds为0个");
          return;
        }
      }
    }
  }
  
  private void c(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() > 0)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(0);
      localArrayList.add(paramList.get(0));
      tlv.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, 0, localstSimpleMetaFeed.poster_id, this.jdField_a_of_type_UserGrowthStGlobalConfig, 2);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_e_of_type_Long;
    tlo.c("weishi-report", "瀑布流拿到Notification的时间点：" + l1 + ",请求接口耗时：" + l2 + "毫秒");
    tjz.a().c(paramBoolean, l2);
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void e()
  {
    bfkb.a();
    g();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    tlo.a("weishi-report", "进入瀑布流的时间：" + this.jdField_d_of_type_Long);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("weishi_public_account_ding_state_change");
    ((IntentFilter)localObject).addAction("weishi_public_account_follow_state_change");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver = new WSRecommendFragment.InternetDynamicBroadCastReceiver(this);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver, (IntentFilter)localObject);
    localObject = new aaot();
    aaos.a().a(this.jdField_a_of_type_AndroidContentContext, (aaot)localObject);
    tip.c("");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = tlv.a();
    this.jdField_a_of_type_JavaLangString = tlv.b();
    f();
    yej.a().a(this);
    tff.a().a(this);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg == null) {}
    for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      tfd.a().a(this.jdField_a_of_type_AndroidContentContext);
      ((tjl)b()).a((String)localObject);
      ((tjl)b()).b((String)localObject);
      try
      {
        this.jdField_a_of_type_Tlk = new tlk();
        localObject = this.jdField_a_of_type_Tlk.a();
        if (!((HandlerThread)localObject).isAlive()) {
          ((HandlerThread)localObject).start();
        }
        this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
        return;
      }
      catch (Exception localException)
      {
        tlo.b("WSRecommendFragment", "HandlerThread Exception.");
      }
    }
  }
  
  private void f()
  {
    oye localoye = tlv.a();
    if (localoye != null) {
      localoye.a(getActivity());
    }
  }
  
  private void g()
  {
    tld.a().b();
    boolean bool = tld.a().a();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "WSRecommendFragment onAttach start!! preloadInWsRecommend = " + bool);
    if (bool) {
      tld.a().a();
    }
  }
  
  private void h()
  {
    tlo.d("weishi-report", "hasClickFuceng:" + tlv.jdField_a_of_type_Boolean + ",mHasRefresh:" + this.jdField_d_of_type_Boolean + ",mHasScroll:" + this.jdField_e_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) || ((!tlv.jdField_a_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))) {
      tjr.a(137, 1, null);
    }
  }
  
  private void i()
  {
    if (!tci.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      tlo.a("weishi-report", "用户退出公众号，一共使用:" + this.jdField_b_of_type_Long + "毫秒");
      this.jdField_c_of_type_Long = 0L;
    }
    tju.a(117, new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    tjz.a().a(this.jdField_b_of_type_Long, ((tjl)b()).a(), this.jdField_a_of_type_JavaUtilHashMap.size(), tlv.jdField_a_of_type_Boolean, tlq.jdField_a_of_type_Boolean);
    j();
    k();
  }
  
  private void j()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      tjx.jdField_a_of_type_Int = 2;
      return;
    }
    if ((!tlv.jdField_a_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))
    {
      tjx.jdField_a_of_type_Int = 3;
      return;
    }
    tjx.jdField_a_of_type_Int = 1;
  }
  
  private void k()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Tlk != null)
    {
      this.jdField_a_of_type_Tlk.a();
      this.jdField_a_of_type_Tlk = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366413));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559864, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new tcb(this));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375491));
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (localObject != null) {
      ((biai)localObject).a(12);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new tcc(this));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new tcd(this));
    localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_Tby = new tby(getActivity(), (RecyclerViewWithHeaderFooter)localObject);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.jdField_a_of_type_Tby);
    this.jdField_a_of_type_Tby.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
    this.jdField_a_of_type_Tby.a(new tce(this));
    tcg localtcg = new tcg(2, 1);
    localtcg.setGapStrategy(0);
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(localtcg);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new tbp());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371720);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369729));
    int i = azgq.a(this.jdField_a_of_type_AndroidContentContext);
    if (i > 1920) {}
  }
  
  private void n()
  {
    tlo.b("WSRecommendFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(8);
    tjr.a(135, 1, null);
    tju.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tcf(this));
  }
  
  private void o()
  {
    ThreadManager.getSubThreadHandler().post(new WSRecommendFragment.9(this));
  }
  
  protected int a()
  {
    return 2131559858;
  }
  
  protected RecyclerView.LayoutManager a()
  {
    return null;
  }
  
  protected bhzz a()
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ForeBackgroundEvent.class);
    localArrayList.add(LikeRspEvent.class);
    return localArrayList;
  }
  
  @NonNull
  public tjl a()
  {
    return new tip();
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString)
  {
    tlo.b("WSRecommendFragment", "onGetNotificationFailed" + paramInt + " | " + paramString);
    this.jdField_e_of_type_Long = 0L;
    tfd.b(2);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    tlo.d("WSRecommendFragment", "onLoadDataFailed:" + paramInt + " | " + paramString);
    if (paramBoolean1)
    {
      if (((tjl)b()).a())
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
        return;
      }
      n();
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false, true);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, tgu paramtgu)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    d(true);
    c(true);
    tfd.a(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a(paramstNotificationRsp, paramtgu);
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    m();
    e();
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
      String str = paramWSSimpleBaseEvent.getFeedId();
      List localList = this.jdField_a_of_type_Tby.a();
      if (localList != null)
      {
        int i = 0;
        if (i < localList.size())
        {
          stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)localList.get(i);
          int j;
          if (TextUtils.equals(localstSimpleMetaFeed.id, str)) {
            if (paramWSSimpleBaseEvent.getRspIsDing() != localstSimpleMetaFeed.is_ding)
            {
              if (localstSimpleMetaFeed.is_ding != 1) {
                break label134;
              }
              j = 1;
              label94:
              if (j == 0) {
                break label139;
              }
            }
          }
          label134:
          label139:
          for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
          {
            localstSimpleMetaFeed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
            this.jdField_a_of_type_Tby.notifyItemChanged(i);
            i += 1;
            break;
            j = 0;
            break label94;
          }
        }
      }
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof ForeBackgroundEvent)) && (!getActivity().isFinishing()))
    {
      if (((ForeBackgroundEvent)paramSimpleBaseEvent).mIsBackground)
      {
        WSPublicAccReport.getInstance().backgroundPublicAccReport();
        o();
      }
    }
    else {
      return;
    }
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt) {}
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean) {}
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    if (this.jdField_a_of_type_Tax == null) {
      this.jdField_a_of_type_Tax = new tax(getActivity());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (stSimpleMetaFeed)paramList.get(0);
      if (paramList != null)
      {
        paramList = "weishi://feed?feed_id=" + paramList.id;
        this.jdField_a_of_type_Tax.a(paramList);
      }
    }
    this.jdField_a_of_type_Tax.a(this.jdField_a_of_type_UserGrowthStGlobalConfig);
    this.jdField_a_of_type_Tax.a(getActivity(), 0);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, tgu paramtgu, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    tlo.f("WSRecommendFragment", "onLoadDataSuccess:" + paramList.size() + ", isFirstFromService:" + paramBoolean1);
    if (paramtgu != null)
    {
      this.jdField_c_of_type_Boolean = true;
      tlo.f("WSRecommendFragment", "onLoadDataSuccess AbTestId = " + paramtgu.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_UserGrowthStGlobalConfig = tee.a().a();
    tlo.a("WeishiDownloadUtil", "WeishiDownloadUtil link_strategy_type:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type);
    int i;
    if (paramBoolean1) {
      if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
      {
        i = this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
        paramtgu = a(false, i, (stSimpleMetaFeed)paramList.get(0));
        a(paramList, this.jdField_a_of_type_UserGrowthStGlobalConfig, paramtgu, paramBoolean4);
        if (!paramBoolean4) {
          break label260;
        }
        paramList.remove(0);
        this.jdField_a_of_type_Tby.a(paramList);
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
        tlv.a(paramList, false);
      }
      if (paramBoolean1)
      {
        tlp.a();
        tlp.a(tee.a().a());
      }
      return;
      i = 1;
      break;
      label260:
      d();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
      if (((tjl)b()).a()) {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
      }
      this.jdField_a_of_type_Tby.a(paramList);
      ((tjl)b()).a(false, false, "");
      continue;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
        this.jdField_a_of_type_Tby.a(paramList);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, paramBoolean3);
        this.jdField_a_of_type_Tby.a(paramList);
      }
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
    if (paramBoolean2) {
      a(true, -1, null);
    }
    if (paramBoolean1) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null) {
        break label104;
      }
    }
    label104:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      ((tjl)this.jdField_a_of_type_Taw).a(false, true, true, str);
      a(paramList, false);
      this.jdField_a_of_type_Tby.a(paramList);
      this.jdField_a_of_type_Int = paramList.size();
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      tlv.c("feeds");
    }
  }
  
  public void b(List<stSimpleMetaFeed> paramList) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.b();
    }
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean) {
      ((biau)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
    for (;;)
    {
      ((biau)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).notifyDataSetChanged();
      return;
      ((biau)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!this.g)
    {
      this.g = true;
      i();
      h();
      tfd.a().b();
      o();
      l();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver != null) {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver);
      }
      sff.a().a();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_Tby != null)
      {
        List localList = this.jdField_a_of_type_Tby.a();
        tcq.a().a(localList, this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Tby.jdField_a_of_type_Tez != null) {
          this.jdField_a_of_type_Tby.jdField_a_of_type_Tez = null;
        }
        if (this.jdField_a_of_type_Tby.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
          this.jdField_a_of_type_Tby.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
        }
      }
      yej.a().b(this);
      tff.a().b(this);
      tlv.jdField_a_of_type_AndroidUtilSparseArray.clear();
      thb.jdField_a_of_type_JavaUtilMap.clear();
      tby.b = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    betl.a(BaseApplicationImpl.getContext(), true);
  }
  
  public void onPause()
  {
    super.onPause();
    amnk.a(getActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!tci.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      tju.a(6, tju.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg));
      if (this.jdField_d_of_type_Long > 0L)
      {
        long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
        this.jdField_d_of_type_Long = 0L;
        tlo.b("weishi-report", "page init cost：" + l);
        tjr.a();
        tjz.a().a(true, l);
      }
      betl.a(BaseApplicationImpl.getContext(), false);
      if (this.jdField_a_of_type_Boolean) {
        WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
      }
      return;
      tci.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */