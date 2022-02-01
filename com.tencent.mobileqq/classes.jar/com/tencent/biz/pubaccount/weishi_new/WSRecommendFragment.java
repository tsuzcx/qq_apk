package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGlobalConfig;
import UserGrowth.stH5OpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import acim;
import acin;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import apau;
import bjna;
import blig;
import blip;
import bljb;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
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
import pws;
import tlv;
import uxa;
import uxt;
import uyd;
import uyf;
import uyg;
import uyh;
import uyi;
import uyj;
import uyk;
import uyl;
import uyn;
import uyt;
import uyu;
import uzc;
import uzf;
import vau;
import vbt;
import vbw;
import vbz;
import vfh;
import vij;
import vjl;
import vjm;
import vjx;
import vkf;
import vkk;
import vmc;
import vmg;
import vml;
import vmm;
import vmp;
import vmq;
import vmr;
import vnd;
import vnn;
import zfn;

public class WSRecommendFragment
  extends WSBaseHomeFragment<vjm, vjl, List<stSimpleMetaFeed>>
  implements vbz, vjm
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
  private uxa jdField_a_of_type_Uxa;
  private uyd jdField_a_of_type_Uyd;
  private vml jdField_a_of_type_Vml;
  public vnn a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public WSRecommendFragment()
  {
    this.jdField_a_of_type_Vnn = new uyf(this);
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
  
  public static Fragment a()
  {
    return new WSRecommendFragment();
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = paramInt;
    localWSDownloadParams.mEventId = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    localWSDownloadParams.mTestId = vnd.a(4);
    stReportItem localstReportItem = vjx.a();
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
    for (boolean bool = vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);; bool = false)
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
          i = uzf.a().a();
          if (!bool) {
            break label166;
          }
          j = 1;
          label77:
          if (!paramBoolean) {
            break label172;
          }
        }
        label166:
        label172:
        for (int k = 1;; k = 2)
        {
          vkf.a(301, new Object[] { Integer.valueOf(paramInt), str2, str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(1) });
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
      stReportItem localstReportItem = vjx.a(paramstSimpleMetaFeed, paramInteger.intValue());
      if (localstH5OpInfo.type == 1) {}
      for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
      {
        localstReportItem.optype = 6;
        paramArrayList.add(localstReportItem);
        vkf.a(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_exposure", 0, paramstSimpleMetaFeed);
        vmp.a("weishi-report", "luopan report H5");
        paramstReportItem.pagetype = 1;
        return;
      }
    }
    if (paramstSimpleMetaFeed.video_type == 6)
    {
      paramstReportItem.pagetype = 1;
      vkf.a(false);
      vmp.a("weishi-report", "luopan report NOW");
      return;
    }
    paramstReportItem.pagetype = 1;
    vmp.b("weishi-report", "luopan normal is no need report");
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (paramstGlobalConfig != null) {
      vmp.d("WSRecommendFragment", "RockDownloader:" + paramstGlobalConfig.download);
    }
    for (int i = paramstGlobalConfig.link_strategy_type;; i = 1)
    {
      vbt.a().a(getActivity(), i, (stSimpleMetaFeed)paramList.get(0));
      if (paramBoolean) {
        vbt.a().a();
      }
      if (i == 7)
      {
        if ((paramstGlobalConfig.jumpinfo == null) || (TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url))) {
          break label156;
        }
        uyt.a(this.jdField_a_of_type_AndroidContentContext, paramstGlobalConfig.jumpinfo.h5url);
      }
      label156:
      for (i = j;; i = 2)
      {
        vkf.a(i, 2, paramString);
        do
        {
          return;
          if (i != 4) {
            break;
          }
        } while (!zfn.a(this.jdField_a_of_type_AndroidContentContext));
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
        vmp.d("WSRecommendFragment", "exposeRefreshCard getLastVisiblePosition error: " + localException.getMessage());
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
        stReportItem localstReportItem = vjx.a((stSimpleMetaFeed)localObject4, ((Integer)localObject3).intValue());
        a((stSimpleMetaFeed)localObject4, (Integer)localObject3, localstReportItem, (ArrayList)localObject2);
        localstReportItem.optype = 6;
        vmp.a("weishi-report", "推荐实时上报:" + localstReportItem.feedid + ", upos:" + localstReportItem.upos);
        ((ArrayList)localObject2).add(localstReportItem);
        localObject3 = vnd.a((stSimpleMetaFeed)localObject4);
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
        vjx.a((ArrayList)localObject2);
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
              vmp.a("weishi-report", "898实时上报:" + (String)localObject3 + ", upos:" + localObject2);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                ((StringBuilder)localObject1).append((String)localObject3);
                ((StringBuilder)localObject1).append("_");
                continue;
                vmp.c("weishi-report", "推荐上报的feeds为0个");
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
          vmp.c("weishi-report", "jsonObj:" + paramMap);
          vkf.a(303, paramMap.toString());
          return;
          vmp.c("weishi-report", "898上报的feeds为0个");
          return;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_e_of_type_Long;
    vmp.c("weishi-report", "瀑布流拿到Notification的时间点：" + l1 + ",请求接口耗时：" + l2 + "毫秒");
    vkk.a().d(paramBoolean, l2);
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void f()
  {
    bjna.a();
    h();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    vmp.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_d_of_type_Long);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("weishi_public_account_ding_state_change");
    ((IntentFilter)localObject).addAction("weishi_public_account_follow_state_change");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver = new WSRecommendFragment.InternetDynamicBroadCastReceiver(this);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver, (IntentFilter)localObject);
    localObject = new acin();
    acim.a().a(this.jdField_a_of_type_AndroidContentContext, (acin)localObject);
    vij.c("");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = vnd.a();
    this.jdField_a_of_type_JavaLangString = vnd.b();
    g();
    vbw.a().a(this);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg == null) {}
    for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      vbt.a().a(this.jdField_a_of_type_AndroidContentContext);
      ((vjl)b()).a((String)localObject);
      ((vjl)b()).b((String)localObject);
      try
      {
        this.jdField_a_of_type_Vml = new vml();
        localObject = this.jdField_a_of_type_Vml.a();
        if (!((HandlerThread)localObject).isAlive()) {
          ((HandlerThread)localObject).start();
        }
        this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
        return;
      }
      catch (Exception localException)
      {
        vmp.b("WSRecommendFragment", "HandlerThread Exception.");
      }
    }
  }
  
  private void g()
  {
    pws localpws = vnd.a();
    if (localpws != null) {
      localpws.a(getActivity());
    }
  }
  
  private void h()
  {
    vmc.a().b();
    boolean bool = vmc.a().a();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "WSRecommendFragment onAttach start!! preloadInWsRecommend = " + bool);
    if (bool) {
      vmc.a().a();
    }
  }
  
  private void i()
  {
    vmp.d("weishi-report", "hasClickFuceng:" + vnd.jdField_a_of_type_Boolean + ",mHasRefresh:" + this.jdField_e_of_type_Boolean + ",mHasScroll:" + this.f);
    if ((!this.jdField_d_of_type_Boolean) || ((!vnd.jdField_a_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && (!this.f))) {
      vjx.a(137, 1, null);
    }
  }
  
  private void j()
  {
    if (!uyu.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      vmp.a("weishi-report", "用户退出公众号，一共使用:" + this.jdField_b_of_type_Long + "毫秒");
      this.jdField_c_of_type_Long = 0L;
    }
    vkf.a(117, new Object[] { Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    vkk.a().a(this.jdField_b_of_type_Long, ((vjl)b()).a(), this.jdField_a_of_type_JavaUtilHashMap.size(), vnd.jdField_a_of_type_Boolean, vmr.jdField_a_of_type_Boolean, 1);
    k();
    l();
  }
  
  private void k()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      vki.jdField_a_of_type_Int = 2;
      return;
    }
    if ((!vnd.jdField_a_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && (!this.f))
    {
      vki.jdField_a_of_type_Int = 3;
      return;
    }
    vki.jdField_a_of_type_Int = 1;
  }
  
  private void l()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Vml != null)
    {
      this.jdField_a_of_type_Vml.a();
      this.jdField_a_of_type_Vml = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  private void n()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366859));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560063, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new uyg(this));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376421));
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (localObject != null) {
      ((blip)localObject).a(12);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new uyh(this));
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new uyi(this));
    localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_Uyd = new uyd(getActivity(), (RecyclerViewWithHeaderFooter)localObject);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.jdField_a_of_type_Uyd);
    this.jdField_a_of_type_Uyd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
    this.jdField_a_of_type_Uyd.a(new uyj(this));
    uyl localuyl = new uyl(2, 1);
    localuyl.setGapStrategy(0);
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(localuyl);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new uxt());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372588);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370426));
    int i = ScreenUtil.getInstantScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    if (i > 1920) {}
  }
  
  private void o()
  {
    vmp.b("WSRecommendFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(8);
    vjx.a(135, 1, null);
    vkf.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new uyk(this));
  }
  
  private void p()
  {
    vmp.e("WSRecommendFragment", "[onBackEvent][handleCacheData] saveFeed and cache");
    if (this.jdField_a_of_type_Uyd == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      List localList = this.jdField_a_of_type_Uyd.b();
      uzf.a().a(localList, this.jdField_a_of_type_Int);
      localObject2 = vmm.a().a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = vmg.a(localList);
      }
      localObject2 = vnd.a();
    } while ((localObject2 == null) || (localObject1 == null));
    ((pws)localObject2).a((stSimpleMetaFeed)localObject1);
    uzc.a((stSimpleMetaFeed)localObject1);
  }
  
  private void q()
  {
    ThreadManager.getSubThreadHandler().post(new WSRecommendFragment.9(this));
  }
  
  protected int a()
  {
    return 2131560055;
  }
  
  protected RecyclerView.LayoutManager a()
  {
    return null;
  }
  
  protected blig a()
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
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    return localArrayList;
  }
  
  @NonNull
  public vjl a()
  {
    return new vij();
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    vmp.d("WSRecommendFragment", "onLoadDataFailed:" + paramInt + " | " + paramString);
    if (paramBoolean1)
    {
      if (((vjl)b()).a())
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
        return;
      }
      o();
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(false, true);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, vfh paramvfh)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    c(true);
    b(true);
    vbt.a(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a(paramstNotificationRsp, paramvfh);
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    n();
    f();
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    b(paramWSSimpleBaseEvent);
    ((vjl)b()).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt) {}
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean) {}
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    if ((uyn.a()) || (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.windows_config == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.windows_config.size() == 0)) {
      return;
    }
    if (this.jdField_a_of_type_Uxa == null) {
      this.jdField_a_of_type_Uxa = new uxa(getActivity(), 0);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (stSimpleMetaFeed)paramList.get(0);
      if (paramList != null)
      {
        paramList = "weishi://feed?feed_id=" + paramList.id;
        this.jdField_a_of_type_Uxa.a(paramList);
      }
    }
    this.jdField_a_of_type_Uxa.a(this.jdField_a_of_type_UserGrowthStGlobalConfig);
    this.jdField_a_of_type_Uxa.a(getActivity());
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_d_of_type_Boolean = paramBoolean1;
    e();
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
      ((vjl)this.jdField_a_of_type_Uwz).a(false, true, true, str);
      a(paramList, false);
      this.jdField_a_of_type_Uyd.a(paramList);
      this.jdField_a_of_type_Int = paramList.size();
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
      return;
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    vmp.f("WSRecommendFragment", "onLoadDataSuccess:" + paramList.size() + ", isFirstFromService:" + paramBoolean1);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_UserGrowthStGlobalConfig = vau.a().a(1);
    int i;
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
    {
      i = this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
      vmp.a("WeishiDownloadUtil", "WeishiDownloadUtil link_strategy_type:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        if (uyn.a()) {
          vbw.a().a(new WSUserAuthEvent());
        }
        String str = a(false, i, (stSimpleMetaFeed)paramList.get(0));
        a(paramList, this.jdField_a_of_type_UserGrowthStGlobalConfig, str, paramBoolean4);
        if (paramBoolean4)
        {
          paramList.remove(0);
          this.jdField_a_of_type_Uyd.a(paramList);
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
        if ((((vjl)b()).b()) || (paramBoolean4)) {
          vnd.a(paramList, true);
        }
        if (paramBoolean1)
        {
          vmq.a();
          vmq.a(i);
        }
        return;
        e();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
        if (((vjl)b()).a()) {
          this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
        }
        this.jdField_a_of_type_Uyd.a(paramList);
        ((vjl)b()).a(false, false, "");
        continue;
        if (paramBoolean2)
        {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true);
          this.jdField_a_of_type_Uyd.a(paramList);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, ((vjl)b()).b());
          this.jdField_a_of_type_Uyd.a(paramList);
        }
      }
      i = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.b();
    }
  }
  
  public blig b()
  {
    return this.jdField_a_of_type_Uyd;
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      vnd.d("feeds");
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    vmp.b("WSRecommendFragment", "onGetNotificationFailed" + paramInt + " | " + paramString);
    this.jdField_e_of_type_Long = 0L;
    vbt.b(2);
  }
  
  public void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (this.h)) {}
    while ((!(paramWSSimpleBaseEvent instanceof ForeBackgroundEvent)) || (!((ForeBackgroundEvent)paramWSSimpleBaseEvent).mIsBackground)) {
      return;
    }
    q();
  }
  
  public void b(List<stSimpleMetaFeed> paramList) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (paramBoolean) {
      ((bljb)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
    for (;;)
    {
      ((bljb)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).notifyDataSetChanged();
      return;
      ((bljb)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean onBackEvent()
  {
    p();
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!this.h)
    {
      this.h = true;
      j();
      i();
      vbt.a().b();
      q();
      m();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver != null) {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver);
      }
      tlv.a().a();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_Uyd != null)
      {
        if (this.jdField_a_of_type_Uyd.jdField_a_of_type_Vbp != null) {
          this.jdField_a_of_type_Uyd.jdField_a_of_type_Vbp = null;
        }
        if (this.jdField_a_of_type_Uyd.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
          this.jdField_a_of_type_Uyd.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
        }
      }
      vbw.a().b(this);
      uyd.b = 0;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    apau.a(getActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!uyu.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      vkf.a(6, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      if (this.jdField_d_of_type_Long > 0L)
      {
        long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
        this.jdField_d_of_type_Long = 0L;
        vmp.a("weishi-beacon", "瀑布流初始化耗时page init cost：" + l);
        vjx.a();
        vkk.a().a(true, l);
        vkk.a().a(true, l, "feeds", "feeds");
      }
      if (this.jdField_a_of_type_Boolean) {
        WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
      }
      return;
      uyu.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */