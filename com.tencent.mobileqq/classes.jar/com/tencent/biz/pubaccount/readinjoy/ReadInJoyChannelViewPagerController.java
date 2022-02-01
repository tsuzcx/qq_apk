package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.channelCover.RIJMainChannelUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelHelper;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTabAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.CallHotwordChange;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyChannelViewPagerController
  implements KandianSubscribeManager.KandianSubscribeMessageObserver
{
  public static int a;
  public static TabChannelCoverInfo a;
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  public static boolean a;
  private static final int jdField_b_of_type_Int = ViewUtils.b(0.0F);
  private static HashMap<Integer, Boolean> jdField_b_of_type_JavaUtilHashMap;
  public static boolean b;
  private static final int jdField_c_of_type_Int = ViewUtils.b(0.0F);
  private static boolean jdField_c_of_type_Boolean;
  private float jdField_a_of_type_Float = 0.4F;
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new ReadInJoyChannelViewPagerController.9(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInJoyChannelViewPagerController.OnChannelChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController$OnChannelChangeListener;
  private ReadInJoyChannelViewPagerController.OnDataChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController$OnDataChangeListener;
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyChannelViewPagerController.4(this);
  private ReadInJoyTabAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter;
  ReadinjoyTabFrame.CallHotwordChange jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, BaseReportData> jdField_a_of_type_JavaUtilMap = new HashMap();
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private List<TabChannelCoverInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int f = 1;
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_a_of_type_Boolean = false;
    jdField_c_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ReadInJoyChannelViewPagerController(Context paramContext, View paramView, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = ((TabLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378858));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369722));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369789));
    this.jdField_a_of_type_AndroidViewView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
    p();
    g();
  }
  
  private TabChannelCoverInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (localTabChannelCoverInfo.mChannelCoverId == paramInt) {
        return localTabChannelCoverInfo;
      }
    }
    return null;
  }
  
  public static Integer a(int paramInt)
  {
    return (Integer)jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
  }
  
  private List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (localTabChannelCoverInfo != null) {
        paramList.add(localTabChannelCoverInfo.clone());
      }
    }
    return paramList;
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsTabLayout == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "mChannelTabLayout null");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
    if (i >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "currentPosition larger than tablayout childsize, currentPosition " + i + " childsize: " + this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a());
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
    View localView2;
    float f2;
    float f1;
    View localView1;
    if (localViewGroup != null)
    {
      localView2 = localViewGroup.findViewById(2131369369);
      paramInt2 = 0;
      if (paramInt1 != i - 1) {
        break label272;
      }
      f2 = (1.0F - paramFloat) * this.jdField_b_of_type_Float;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      paramInt2 = jdField_b_of_type_Int;
      paramInt1 = i - 1;
      if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())) {
        break label255;
      }
      localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt1);
      paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt1);
      paramInt2 = (int)(jdField_b_of_type_Int - f1 * paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.5(this, paramFloat, i, localViewGroup, localView1));
      paramInt1 = 0;
    }
    for (;;)
    {
      a(localView2, paramInt2, paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.8(this, localView1, localView2));
      return;
      localView2 = null;
      break;
      label255:
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt1 = 0;
      continue;
      label272:
      if (paramInt1 == i)
      {
        f2 = this.jdField_b_of_type_Float * paramFloat;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramInt1 = jdField_c_of_type_Int;
        paramInt2 = i + 1;
        if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt2);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt2);
          paramInt1 = (int)(jdField_c_of_type_Int - f1 * paramInt1);
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.6(this, paramFloat, paramInt2, localView1, localViewGroup, i));
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          paramInt1 = 1;
          break;
          QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
          localView1 = null;
        }
      }
      if (paramInt1 == i + 1)
      {
        i += 1;
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
        }
        for (paramInt1 = jdField_c_of_type_Int - paramInt1;; paramInt1 = paramInt2)
        {
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.7(this, i, localView1, localViewGroup));
          paramInt2 = paramInt1;
          paramInt1 = 1;
          break;
          localView1 = null;
        }
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "line null");
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (paramInt2 == 0)
    {
      localMarginLayoutParams.leftMargin = paramInt1;
      localMarginLayoutParams.rightMargin = jdField_c_of_type_Int;
    }
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "changeChannelLineMargin: left " + localMarginLayoutParams.leftMargin + " right: " + localMarginLayoutParams.rightMargin);
      paramView.setLayoutParams(localMarginLayoutParams);
      return;
      localMarginLayoutParams.rightMargin = paramInt1;
      localMarginLayoutParams.leftMargin = jdField_b_of_type_Int;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "tvSelectTab or tvUnselectTab null");
      return;
    }
    paramView1 = (TextView)paramView1.findViewById(2131380651);
    paramView2 = (TextView)paramView2.findViewById(2131380651);
    a(paramView1);
    b(paramView2);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166919));
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", paramString2, ", r5 = ", paramString3 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, paramString2, "", "", paramString3, false);
  }
  
  private void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "channel list size is 0");
      return;
    }
    jdField_a_of_type_Int = e();
    List localList = a(paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localList);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController$OnDataChangeListener != null)
    {
      paramList = a(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController$OnDataChangeListener.a(paramList);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyChannelViewPagerController.2(this));
    l();
    m();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(localList);
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId) != null)) {
      c(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
    }
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "setAdapterData: " + localList);
      return;
      a();
    }
  }
  
  private void a(Map<Integer, BaseReportData> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int j = ChannelCoverView.jdField_b_of_type_Int;
        if ((localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int i = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; i = 0)
        {
          ChannelCoverView.a("0X8009495", localTabChannelCoverInfo, j, i, localBaseReportData.l);
          break;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isNeedRefreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      return (Boolean)jdField_b_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt)) != null;
    }
    return false;
  }
  
  private boolean a(List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    paramList = b(paramList);
    if (paramList.size() == this.jdField_a_of_type_JavaUtilList.size())
    {
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramList.size())
        {
          if (((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId != ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private List<TabChannelCoverInfo> b(List<TabChannelCoverInfo> paramList)
  {
    int j = 0;
    int m = paramList.size();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = localList.iterator();
    label99:
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label99;
        }
        if (localTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId)
        {
          localIterator.remove();
          break;
        }
        i += 1;
      }
    }
    int k = 0;
    int i = j;
    j = k;
    while (i <= m - 1)
    {
      localList.add(jdField_a_of_type_Int + j, paramList.get(i));
      j += 1;
      i += 1;
    }
    return localList;
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166920));
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
    TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
    localRedPoint.jdField_a_of_type_Long = 0L;
    localRedPoint.b = 9223372036854775807L;
    localRedPoint.jdField_a_of_type_Boolean = localKandianSubscribeManager.a();
    paramTabChannelCoverInfo.redPoint = localRedPoint;
    a(paramTabChannelCoverInfo);
  }
  
  private void b(List<TabChannelCoverInfo> paramList)
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a();
    if ((localList != null) && (localList.size() > 0))
    {
      ((ChannelSection)localList.get(0)).jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a(localList, 1, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "updateMyChannelData channelCoverSectionList is null");
  }
  
  public static boolean b()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private void c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (paramTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i)).mChannelCoverId) {
          this.jdField_b_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.reason == 4) {
          break;
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramTabChannelCoverInfo);
        return;
      }
      i += 1;
    }
  }
  
  public static void d(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  private int e()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.b();
    int k;
    if ((localList == null) || (localList.size() == 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "No channel Cache info.");
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelViewPagerController", 2, "getChannelLockCount lockCount：" + k);
      }
      return k;
    }
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= localList.size()) {
        break;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(j);
      k = i;
      if (localTabChannelCoverInfo != null)
      {
        k = i;
        if (localTabChannelCoverInfo.reason != 4) {
          break;
        }
        k = i + 1;
      }
      j += 1;
    }
  }
  
  private void e(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean));
    localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
    a(localTabChannelCoverInfo);
  }
  
  private void f(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) || (RIJChannelStayTimeMonitor.a.b(localTabChannelCoverInfo.mChannelCoverId))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "checkBackToTopAndRefresh, position = ", Integer.valueOf(paramInt), ", channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", isNeedRefresh = ", Boolean.valueOf(bool) });
      if (bool)
      {
        Fragment localFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
        if (!(localFragment instanceof ReadInJoyBaseFragment)) {
          break;
        }
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isShowingSelf = ", Boolean.valueOf(((ReadInJoyBaseFragment)localFragment).c()) });
        ((ReadInJoyBaseFragment)localFragment).a(3);
      }
      return;
    }
    d(localTabChannelCoverInfo.mChannelCoverId);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getSupportFragmentManager();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter = new ReadInJoyTabAdapter(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getAdapter());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    i();
    a();
    k();
    jdField_a_of_type_Int = e();
    RIJChannelStayTimeMonitor.a.a();
    h();
  }
  
  private void h()
  {
    VideoReport.setElementId(this.jdField_a_of_type_AndroidWidgetImageView, "more_channel_button");
    VideoReport.setElementParams(this.jdField_a_of_type_AndroidWidgetImageView, new RIJDtParamBuilder().a("14").c("click_more_channel").b("channel_bar").a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_AndroidWidgetImageView, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void i()
  {
    Object localObject = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    List localList;
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).a();
      if (localObject != null)
      {
        localList = ((ReadInJoyLogicEngine)localObject).b();
        if ((localList != null) && (localList.size() != 0)) {
          break label62;
        }
        ((ReadInJoyLogicEngine)localObject).m();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "No channel Cache info.");
      }
    }
    for (;;)
    {
      j();
      return;
      label62:
      a(localList);
    }
  }
  
  private void j()
  {
    if (ChannelModeConfigHandler.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849805);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843138);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyChannelViewPagerController.1(this));
  }
  
  private void l()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a(0);
    if (localTabChannelCoverInfo == null) {}
    while ((localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {
      return;
    }
    localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
    a(localTabChannelCoverInfo);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
    n();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOverScrollMode(2);
    int j = c();
    if (this.f == j)
    {
      QLog.i("ReadInJoyChannelViewPagerController", 1, "mLastCenterPosition = " + this.f + ", no need to move again.");
      return;
    }
    this.f = j;
    int i = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(j);
    int k = (int)(DeviceInfoUtil.m() - i) / 2 - ViewUtils.a(12.0F);
    i = 200;
    if ((j < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getFirstVisiblePosition()) || (j > this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getLastVisiblePosition())) {
      i = 0;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "smoothScrollToPosition, position = ", Integer.valueOf(j), ", offset = ", Integer.valueOf(k) });
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.smoothScrollToPositionFromLeftOrRight(j, -k, i);
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener == null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new ReadInJoyChannelViewPagerController.11(this);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
  }
  
  private void o()
  {
    if (!jdField_c_of_type_Boolean)
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (localKandianMergeManager != null)
      {
        localKandianMergeManager.r();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "clearKandianRedPoint");
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a();
  }
  
  public void C_()
  {
    QLog.i("ReadInJoyChannelViewPagerController", 1, "[onReceiveKandianSubscribeMessage] ");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = a(70);
    } while (localTabChannelCoverInfo == null);
    TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
    localRedPoint.jdField_a_of_type_Boolean = true;
    localRedPoint.jdField_a_of_type_Long = 0L;
    localRedPoint.b = 9223372036854775807L;
    localTabChannelCoverInfo.redPoint = localRedPoint;
    a(localTabChannelCoverInfo);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
  }
  
  public TabChannelCoverInfo a()
  {
    int i = c();
    if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  public void a()
  {
    int i = RIJMainChannelUtil.a.a();
    if (i != -1) {}
    for (;;)
    {
      c(i);
      return;
      i = 0;
    }
  }
  
  public void a(int paramInt)
  {
    int j = 1;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localObject != null) && (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null))
      {
        a(((TabChannelCoverInfo)localObject).mChannelCoverId, 1);
        RIJChannelReporter.a(((TabChannelCoverInfo)localObject).mChannelCoverId, "302");
      }
    }
    if (c() == paramInt)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        ((ReadInJoyBaseFragment)localObject).a(5);
      }
      localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        a("0X8009665", "", RIJTransMergeKanDianReport.a().a(((TabChannelCoverInfo)localObject).mChannelCoverId).m(RIJChannelHelper.a((ChannelCoverInfo)localObject)).n(RIJChannelHelper.a((TabChannelCoverInfo)localObject)).a());
        boolean bool = ReadInJoyHelper.C();
        if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
          if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).dynamicSort == 1)
          {
            i = 1;
            if ((!bool) || (i == 0)) {
              continue;
            }
            i = j;
            if ((paramInt < jdField_a_of_type_Int) || (i == 0)) {
              continue;
            }
            if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
            {
              localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
              if ((localObject != null) && (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null)) {
                a(((TabChannelCoverInfo)localObject).mChannelCoverId, 0);
              }
            }
            e(paramInt);
            this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.postDelayed(new ReadInJoyChannelViewPagerController.10(this, paramInt), 0L);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyChannelViewPagerController", 1, "report channel title click again exception, e = ", localJSONException);
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        b(paramInt);
        return;
      }
      int i = 0;
    }
  }
  
  public void a(ReadInJoyChannelViewPagerController.OnChannelChangeListener paramOnChannelChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController$OnChannelChangeListener = paramOnChannelChangeListener;
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "updateChannelToCacheAndDB channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
        localObject = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      } while (localObject == null);
      localObject = ((ReadInJoyLogicManager)localObject).a();
    } while (localObject == null);
    if (RIJThreadHandler.a())
    {
      ((ReadInJoyLogicEngine)localObject).a(paramTabChannelCoverInfo);
      return;
    }
    RIJThreadHandler.b().post(new ReadInJoyChannelViewPagerController.3(this, (ReadInJoyLogicEngine)localObject, paramTabChannelCoverInfo));
  }
  
  public void a(ReadinjoyTabFrame.CallHotwordChange paramCallHotwordChange)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange = paramCallHotwordChange;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onTabChanged, visible = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      a(this.jdField_a_of_type_JavaUtilMap);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      if (paramBoolean) {
        FrameHelperActivity.x();
      }
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break label247;
      }
      boolean bool1 = a(this.jdField_b_of_type_JavaUtilList);
      boolean bool2 = ReadInJoyHelper.D();
      QLog.d("ReadInJoyChannelViewPagerController", 1, "has changed :" + bool1 + " ,isDynamicOrderSwitchOn : " + bool2);
      if ((!bool1) || (!bool2) || (paramBoolean)) {
        break label236;
      }
      int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
      while (i > 0)
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i);
        a(localTabChannelCoverInfo.mChannelCoverId, 2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a(localTabChannelCoverInfo.mChannelCoverId, 5, false, false);
        i -= 1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter.notifyDataSetChanged();
    }
    b(b(this.jdField_b_of_type_JavaUtilList));
    a(b(this.jdField_b_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList.clear();
    label236:
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
      label247:
      if (paramBoolean) {
        break;
      }
      jdField_a_of_type_Boolean = false;
      n();
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int b()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a();
    if (localTabChannelCoverInfo != null) {
      return localTabChannelCoverInfo.mChannelCoverId;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, "current channel id is null, return -1");
    return -1;
  }
  
  public void b()
  {
    jdField_a_of_type_Int = e();
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
    j();
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
        a(localTabChannelCoverInfo.mChannelCoverId, 0);
      }
    }
    e(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setCurrentItem(paramInt, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
  }
  
  public void c()
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
  }
  
  public void c(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId != paramInt) {}
    }
    for (;;)
    {
      if (i == -1) {
        QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "setCurrentItemByChannelID error,channelID= ", Integer.valueOf(paramInt), " recommendIndex=", Integer.valueOf(j) });
      }
      for (;;)
      {
        b(j);
        this.jdField_e_of_type_Int = j;
        return;
        if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == 0) {
          j = i;
        }
        i += 1;
        break;
        j = i;
      }
      i = -1;
    }
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ((KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.removeOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) && (!((SplashActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
    if (jdField_b_of_type_JavaUtilHashMap != null) {
      jdField_b_of_type_JavaUtilHashMap.clear();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null)
    {
      jdField_a_of_type_JavaUtilHashMap.clear();
      ReadInJoyBaseFragment.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    RIJChannelStayTimeMonitor.a.b();
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = null;
    this.jdField_a_of_type_AndroidViewView = null;
    jdField_c_of_type_Boolean = true;
  }
  
  public void e()
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter = new ReadInJoyTabAdapter(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
      i();
      a();
      p();
      j();
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getSupportFragmentManager());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController
 * JD-Core Version:    0.7.0.1
 */