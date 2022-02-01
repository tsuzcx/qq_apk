package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper;
import com.tencent.hippy.qq.view.tkd.fragment.TKDCommentFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer, ReadInJoyCommentUtils.CommentListListener
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager;
  private ReadInJoyCommentHelper.ISecondCommentViewStateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentHelper$ISecondCommentViewStateListener = null;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter;
  private ReadInJoyCommentListFragment.HippyCommentPageListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$HippyCommentPageListener = new ReadInJoyCommentListFragment.1(this);
  private ReadInJoyCommentListFragment.OnCreateViewListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$OnCreateViewListener = null;
  private ReadInJoyCommentListFragment.ViewParams jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams = null;
  private ReadInJoyCommentListView.MultiScrollListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$MultiScrollListener = null;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoyCommentUtils.FirstCommentEvent jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent;
  private ReadInJoyCommentUtils.OnFragmentViewCreateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$OnFragmentViewCreateListener;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private GuidePopuppWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow;
  private TimeSliceHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper = new TimeSliceHelper();
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyCommentListFragment.5(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private TKDCommentDispatcher.HippyCommentEvent jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent = new ReadInJoyCommentListFragment.11(this);
  private TKDCommentFragment jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadInJoyCommentListFragment.2(this);
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "huawei_vog-al00", "huawei_vog-al10", "huawei_ele-al00", "samsung_sm-g9750" };
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 5;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView = null;
  private boolean jdField_g_of_type_Boolean = false;
  private View jdField_h_of_type_AndroidViewView = null;
  private boolean jdField_h_of_type_Boolean = false;
  private View jdField_i_of_type_AndroidViewView = null;
  private boolean jdField_i_of_type_Boolean = false;
  private View jdField_j_of_type_AndroidViewView = null;
  private boolean jdField_j_of_type_Boolean = false;
  private boolean k = true;
  
  public ReadInJoyCommentListFragment()
  {
    this.jdField_a_of_type_Int = 2131377654;
  }
  
  private FragmentTransaction a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_j_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (getChildFragmentManager() != null) {
        localObject1 = getChildFragmentManager().beginTransaction();
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (getActivity() == null);
      localObject1 = localObject2;
    } while (getActivity().getSupportFragmentManager() == null);
    return getActivity().getSupportFragmentManager().beginTransaction();
  }
  
  public static void a(Intent paramIntent, RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager, int paramInt1, boolean paramBoolean, ArticleInfo paramArticleInfo, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    QLog.d("ReadInJoyCommentListFragment", 1, "contentSrc = " + paramInt1 + " isBiu = " + paramBoolean);
    String str = paramIntent.getStringExtra("arg_result_json");
    paramIntent = "";
    Object localObject4 = "";
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject5 = new JSONObject(str);
        str = ((JSONObject)localObject5).optString("comment");
        Object localObject1;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          bool1 = ((JSONObject)localObject5).optBoolean("select_to_friend");
          bool2 = bool3;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            bool1 = false;
          }
        }
        try
        {
          localObject1 = ((JSONObject)localObject5).optString("commentId");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          bool3 = ((JSONObject)localObject5).optBoolean("isSecondReply");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          localObject5 = ((JSONObject)localObject5).optString("replyUin");
          localObject4 = localObject5;
          paramIntent = (Intent)localObject1;
          bool2 = bool3;
          localObject1 = localObject4;
          if (!TextUtils.isEmpty(str))
          {
            localObject4 = new RIJBiuAndCommentRequestData();
            ((RIJBiuAndCommentRequestData)localObject4).setBiu(paramBoolean);
            ((RIJBiuAndCommentRequestData)localObject4).setContentSrc(paramInt1);
            ((RIJBiuAndCommentRequestData)localObject4).setContentString(str);
            ((RIJBiuAndCommentRequestData)localObject4).setDiffuseToFriends(bool1);
            if (paramArticleInfo != null) {
              break label278;
            }
            str = "";
            ((RIJBiuAndCommentRequestData)localObject4).setRowKey(str);
            ((RIJBiuAndCommentRequestData)localObject4).setListShowType(paramInt2);
            ((RIJBiuAndCommentRequestData)localObject4).setCommentType(paramInt3);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyCommentId(paramIntent);
            ((RIJBiuAndCommentRequestData)localObject4).setIsSecondReply(bool2);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyUin((String)localObject1);
            paramRIJBiuAndCommentMixDataManager.a(paramArticleInfo, (RIJBiuAndCommentRequestData)localObject4);
          }
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label266;
        }
        localJSONException1 = localJSONException1;
        str = "";
        bool1 = false;
      }
      label266:
      localObject2 = localObject4;
      continue;
      label278:
      str = paramArticleInfo.innerUniqueID;
      continue;
      str = "";
      bool3 = false;
      Object localObject3 = localObject4;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null)
    {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setArticleInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setEdit(this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setContentSrc(ReadInJoyCommentHelper.a(this.jdField_c_of_type_Int));
      if ((this.jdField_a_of_type_AndroidViewView instanceof ReadInJoyCommentTopGestureLayout))
      {
        h(paramView);
        this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setCommentTopGestureLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
        this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setAnchorData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentHelper$ISecondCommentViewStateListener != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean) {}
        for (String str = "1";; str = "2")
        {
          localJSONObject.put("replyViewStatus", str);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentHelper$ISecondCommentViewStateListener.onViewState(paramBoolean, localJSONObject.toString());
          QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged | visible " + paramBoolean + "; jsonStr " + localJSONObject.toString());
          return;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged " + localJSONException.getMessage());
      }
    }
  }
  
  private boolean a(AnchorData paramAnchorData)
  {
    if ((paramAnchorData == null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData == null)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) && (paramAnchorData != null) && (paramAnchorData.jdField_a_of_type_JavaLangString != null) && (paramAnchorData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramArticleInfo.innerUniqueID != null) && (paramArticleInfo.innerUniqueID.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID));
  }
  
  private boolean a(boolean paramBoolean, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (getActivity() == null) {
      QLog.d("ReadInJoyCommentListFragment", 0, "showGuidePopupWindow | activity is null");
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow = new GuidePopuppWindow(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    } while ((paramBoolean) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) || (!CommentGuideConfigHandler.b())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(new ReadInJoyCommentListFragment.9(this, paramOnGuideDismissListener));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentGuideGuidePopuppWindow.a(getActivity().getWindow().getDecorView());
    return true;
  }
  
  private void b(View paramView)
  {
    boolean bool = TKDCommentFragmentHelper.enableHippyComment();
    QLog.d("ReadInJoyCommentListFragment", 1, "enableHippyComment: " + bool);
    if (bool)
    {
      c(paramView);
      if (this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment == null) {
        e(paramView);
      }
      TKDCommentDispatcher.INSTANCE.addEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
      return;
    }
    e(paramView);
  }
  
  private void b(AnchorData paramAnchorData)
  {
    if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "initAnchor " + paramAnchorData.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramAnchorData.jdField_b_of_type_JavaLangString)) && (!paramAnchorData.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
        FragmentTransaction localFragmentTransaction = a();
        if (localFragmentTransaction != null)
        {
          localFragmentTransaction.setCustomAnimations(2130772355, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramAnchorData.jdField_a_of_type_JavaLangString, paramAnchorData.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
          localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          localFragmentTransaction.commitAllowingStateLoss();
        }
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.3(this), 1000L);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(new ReadInJoyCommentListFragment.4(this));
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramArticleInfo.innerUniqueID).c("click_write_comment").a().a());
  }
  
  private int c()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localReadInJoyCommentDataManager != null) {
      return (int)localReadInJoyCommentDataManager.a();
    }
    return -1;
  }
  
  private void c(View paramView)
  {
    q();
    this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment = TKDCommentFragmentHelper.nestHippyCommentFragment(2131368437, getChildFragmentManager());
    if (this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null)
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment success");
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setHippyCommentPageListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$HippyCommentPageListener);
      d(paramView);
      a(paramView);
      j();
      return;
    }
    QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment failed");
  }
  
  private void d(View paramView)
  {
    if (this.k)
    {
      paramView.setFitsSystemWindows(false);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup;
    }
  }
  
  private void e(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380273));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363785));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramView.findViewById(2131365086));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366896));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373363));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370689));
    q();
    d(paramView);
    b(1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams != null)
    {
      n();
      r();
      m();
    }
    i(paramView);
    p();
    o();
    h(paramView);
    g(paramView);
    if (this.jdField_d_of_type_Boolean) {
      d();
    }
    k();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$OnCreateViewListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$OnCreateViewListener.onViewCreated(this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.jdField_h_of_type_Boolean))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, this.jdField_c_of_type_Boolean, 5, this.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
    }
    f(paramView);
    l();
  }
  
  private boolean e()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      a(false, null, null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(c());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_b_of_type_Int = 0;
    }
    s();
    return false;
  }
  
  private void f(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372316);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372332);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131374174);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
  }
  
  private void g(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$MultiScrollListener = new ReadInJoyCommentListView.MultiScrollListener();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$MultiScrollListener.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$MultiScrollListener);
    paramView.findViewById(2131364823).setOnClickListener(this);
    paramView.findViewById(2131369141).setOnClickListener(this);
    paramView.findViewById(2131379432).setOnClickListener(this);
    paramView.findViewById(2131372317).setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$OnFragmentViewCreateListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$OnFragmentViewCreateListener.a(paramView);
    }
    ReadInJoyDropFrameHelper.a().a(6666, this);
  }
  
  private void h(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, this.k);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    if (this.k) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setBackgroundResource(2130841876);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null)
    {
      HashMap localHashMap = this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.getPerformanceData();
      if (localHashMap != null)
      {
        long l1 = ((Long)localHashMap.get("openPageStart")).longValue();
        long l2 = ((Long)localHashMap.get("loadModuleEnd")).longValue();
        QLog.d("ReadInJoyCommentListFragment", 1, "hippy cost: " + (l2 - l1));
      }
    }
  }
  
  private void i(View paramView)
  {
    View localView;
    if (this.jdField_e_of_type_Boolean)
    {
      localView = paramView.findViewById(2131365057);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localView = paramView.findViewById(2131377952);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.jdField_f_of_type_Boolean)
    {
      paramView = paramView.findViewById(2131363720);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void j()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377246)).setVisibility(8);
  }
  
  private void j(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      d();
      if (paramView.getId() == 2131369141)
      {
        paramView = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getActivity().getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, paramView, false);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    }
  }
  
  private void k()
  {
    Object localObject = getActivity();
    if ((localObject != null) && (ThemeUtil.isInNightMode(((FragmentActivity)localObject).app)))
    {
      localObject = new View(getActivity());
      ((View)localObject).setBackgroundColor(1996488704);
      getActivity().addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void l()
  {
    this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131562883, null, false);
    this.jdField_h_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131372316);
    this.jdField_j_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131372332);
    this.jdField_i_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131370745);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.addHeaderView(this.jdField_g_of_type_AndroidViewView);
    }
  }
  
  private void m()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int > 0))
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "setPaddingTop : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int);
    }
  }
  
  private void n()
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void o()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Int);
      QLog.d("ReadInJoyCommentListFragment", 0, "initSubCommentFragment | setMarginTop " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new ReadInJoyCommentListFragment.6(this));
    localObject = a();
    if (localObject != null)
    {
      ((FragmentTransaction)localObject).add(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.initFooterView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideFooterView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = new ReadInJoyCommentListAdapter(getActivity(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void q()
  {
    boolean bool2 = true;
    Bundle localBundle = getArguments();
    if (localBundle == null) {}
    do
    {
      return;
      this.jdField_j_of_type_Boolean = localBundle.getBoolean("arg_comment_is_fragment_container", false);
      this.jdField_e_of_type_Boolean = localBundle.getBoolean("arg_comment_list_comment_btn", false);
      this.jdField_f_of_type_Boolean = localBundle.getBoolean("arg_comment_list_biu_btn", false);
      this.jdField_g_of_type_Boolean = localBundle.getBoolean("arg_comment_list_share_btn", false);
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
      localObject = getActivity();
      if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
        this.k = ((Activity)localObject).getIntent().getBooleanExtra(CommentInfoConstants.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
      }
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("fromViola");
      this.jdField_i_of_type_Boolean = localBundle.getBoolean("is_from_viola");
      this.jdField_e_of_type_Int = localBundle.getInt("bigT_report_entry", this.jdField_c_of_type_Int);
    } while (!this.jdField_h_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams = new ReadInJoyCommentListFragment.ViewParams();
    }
    this.k = false;
    this.jdField_d_of_type_Int = localBundle.getInt("serviceType");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams;
    if (!localBundle.getBoolean("isHiddenFirstPageEditorBar", false))
    {
      bool1 = true;
      ((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_a_of_type_Boolean = bool1;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams;
      if (localBundle.getBoolean("isHiddenHeaderRow", false)) {
        break label387;
      }
      bool1 = true;
      label229:
      ((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_b_of_type_Boolean = bool1;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams;
      if (localBundle.getBoolean("isHiddenSecPageEditorBar", false)) {
        break label392;
      }
      bool1 = true;
      label254:
      ((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Int = localBundle.getInt("padding_top");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Int = localBundle.getInt("margin_bottom");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_c_of_type_Int = localBundle.getInt("secPageOffsetY");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_d_of_type_Int = localBundle.getInt("secPageShowDirection", 2);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) != 0) {
        break label397;
      }
    }
    label387:
    label392:
    label397:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ReadInJoyCommentListFragment.ViewParams)localObject).jdField_d_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.getParcelable("articleInfo"));
      this.jdField_c_of_type_Int = localBundle.getInt("source");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label229;
      bool1 = false;
      break label254;
    }
  }
  
  private void r()
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_a_of_type_Boolean)) {
        break label37;
      }
    }
    label37:
    for (int m = 0;; m = 8)
    {
      localLinearLayout.setVisibility(m);
      return;
    }
  }
  
  private void s()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (localObject != null)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "onPanelClose", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      String str = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(this.jdField_e_of_type_Int).d(1).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a(new ReadInJoyCommentListFragment.10(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper != null)
    {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.c();
    }
    return l;
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  ReadInJoyCommentUtils.FirstCommentEvent a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      if (this.jdField_d_of_type_Int == 0) {
        break label74;
      }
    }
    label74:
    for (int m = this.jdField_d_of_type_Int;; m = 5)
    {
      QLog.d("ReadInJoyCommentListFragment", 0, "fetchCommentDataByViola by viola feedstype " + m + "contentSrc " + this.jdField_c_of_type_Int);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, true, m, this.jdField_c_of_type_Int);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int m = 1;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    QQAppInterface localQQAppInterface;
    String str2;
    if (paramInt1 == 2)
    {
      a(false, null, null);
      if (this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null) {
        this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.onBackPress();
      }
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localQQAppInterface = (QQAppInterface)getActivity().getAppInterface();
      str2 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (this.jdField_c_of_type_Int != 2) {
        break label150;
      }
    }
    label150:
    for (String str1 = "1";; str1 = "2")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localQQAppInterface, str2, "0X800920E", "0X800920E", 0, 0, str1, String.valueOf(paramInt1), "", "", false);
      return;
      if ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent == null)) {
        break;
      }
      if (paramInt2 > 0) {}
      for (paramInt2 = m;; paramInt2 = 2)
      {
        RIJTransMergeKanDianReport.a(0, this.jdField_e_of_type_Int, paramInt2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(false);
        break;
      }
    }
  }
  
  public void a(Bundle paramBundle, ReadInJoyCommentUtils.FirstCommentEvent paramFirstCommentEvent, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent = paramFirstCommentEvent;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(ReadInJoyCommentHelper.ISecondCommentViewStateListener paramISecondCommentViewStateListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentHelper$ISecondCommentViewStateListener = paramISecondCommentViewStateListener;
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(paramOnScrollYOffsetListener);
    }
  }
  
  public void a(ReadInJoyCommentListFragment.OnCreateViewListener paramOnCreateViewListener)
  {
    if (paramOnCreateViewListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$OnCreateViewListener = paramOnCreateViewListener;
    }
  }
  
  public void a(AnchorData paramAnchorData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = paramAnchorData;
    if ((this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null) && (paramAnchorData != null)) {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setAnchorData(paramAnchorData);
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    if ((this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null) && (paramArticleInfo != null)) {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.setArticleInfo(paramArticleInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt)
  {
    if ((!a()) && (!TKDCommentFragmentHelper.enableHippyComment()) && (a(paramArticleInfo)) && (a(paramAnchorData)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "cache fragment data");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a(paramArticleInfo, paramAnchorData, paramBoolean, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localReadInJoyCommentDataManager != null) {
        localReadInJoyCommentDataManager.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      }
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = paramAnchorData;
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if (!a())
      {
        if (!NetworkUtil.g(getActivity())) {
          b(3);
        }
        for (;;)
        {
          b(paramAnchorData);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(paramArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2);
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.resetState();
          }
          u();
          v();
          return;
          b(1);
        }
      }
    } while (!this.jdField_i_of_type_Boolean);
    TKDCommentDispatcher.INSTANCE.getEvent().refreshNewAndHotData(this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.getJsPropsMap());
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyCommentListFragment", 0, "setSubCommentFragmentVisible | visible " + paramBoolean);
    a(paramBoolean);
    int m;
    int n;
    if (!paramBoolean)
    {
      paramString1 = a();
      if (paramString1 != null)
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          m = 1;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_d_of_type_Int != 2)) {
            break label187;
          }
          n = 1;
          label75:
          if ((m == 0) && (n == 0)) {
            break label193;
          }
          paramString1.setCustomAnimations(2130772354, 0);
          label94:
          paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
          paramString1.commitAllowingStateLoss();
        }
      }
      else
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.notifyDataSetChanged();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
      }
    }
    label187:
    label193:
    do
    {
      return;
      m = 0;
      break;
      n = 0;
      break label75;
      paramString1.setCustomAnimations(2130771983, 2130772015);
      break label94;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
    FragmentTransaction localFragmentTransaction = a();
    if (localFragmentTransaction != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_d_of_type_Int != 2)) {
        break label340;
      }
      localFragmentTransaction.setCustomAnimations(2130772354, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, this.jdField_c_of_type_Int);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      if (!this.jdField_h_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      label340:
      localFragmentTransaction.setCustomAnimations(2130771983, 2130772015);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment != null;
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null)) {
      return;
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeaderViewsCount() > 0)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        if (this.jdField_i_of_type_AndroidViewView != null) {
          this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader loadingView");
        return;
      case 3: 
        if (this.jdField_j_of_type_AndroidViewView != null) {
          this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noNetworkView");
        return;
      case 2: 
        if (this.jdField_h_of_type_AndroidViewView != null) {
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.loadingMoreComplete(false);
        }
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noCommentView");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader loadingView");
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noNetworkView");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_e_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_e_of_type_AndroidViewView);
    QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373363).setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$ViewParams.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while (a(true, new ReadInJoyCommentListFragment.7(this))) {
      return;
    }
    int m = 4;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      m = 2;
    }
    for (;;)
    {
      ReadInJoyCommentUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, m, "", this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent, -1, this.jdField_c_of_type_Boolean);
      return;
      if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          m = 9;
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGallery != 0) {
        m = 17;
      }
    }
  }
  
  public boolean d()
  {
    if (a())
    {
      s();
      return this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.onBackPress();
    }
    return e();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a().b(a(), 2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a().a();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.f();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.e();
  }
  
  public void g()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.getDispatcher().onActivityResumed(getActivity());
    }
  }
  
  public void h()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.getDispatcher().onActivityPaused(getActivity());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int m = 2;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (a()) {
      this.jdField_a_of_type_ComTencentHippyQqViewTkdFragmentTKDCommentFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != -1)) {
              break;
            }
            str = paramIntent.getStringExtra("arg_result_json");
            paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
            paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
            paramIntent = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          } while (paramIntent == null);
          if (paramInt2 == 1)
          {
            a(false, new ReadInJoyCommentListFragment.8(this));
            return;
          }
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter == null);
        if (paramInt1 == 2)
        {
          paramIntent.d(str, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b());
          return;
        }
      } while (paramInt1 != 3);
      paramIntent.c(str, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b());
      return;
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    paramInt1 = m;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager, this.jdField_c_of_type_Int, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b(), paramInt1);
  }
  
  public boolean onBackEvent()
  {
    return d();
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.onClick(paramView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(c());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_b_of_type_Int = 0;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
        continue;
        j(paramView);
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null)
        {
          b(1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a();
          continue;
          t();
          continue;
          a(false, null, null);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560228, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560228, paramViewGroup, false))
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
      b(paramLayoutInflater);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$OnCreateViewListener = null;
    Bundle localBundle = getActivity().getIntent().getBundleExtra("bundle");
    if (localBundle != null) {
      ReadInJoyLogicEngineEventDispatcher.a().d(localBundle.getInt("seq"));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
    }
    ReadInJoyDropFrameHelper.a().b(6666, this);
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    QLog.d("ReadInJoyCommentListFragment", 0, "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b();
    }
    if ((getActivity() != null) && (getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null))
    {
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b());
      QLog.d("ReadInJoyCommentListFragment", 1, "onStop | removeCommentDataManager feedsType " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */