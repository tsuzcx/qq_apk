package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnHorizontalSubArticleClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, ComponentInheritView, HorizontalListView.OnScrollStateChangedListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private ComponentPolymericView.ReadinjoyHorizontalAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$ReadinjoyHorizontalAdapter;
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  
  public ComponentPolymericView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) && (this.jdField_b_of_type_Boolean))
    {
      int j = getMeasuredHeight() / 2;
      int i = j;
      if (!this.c)
      {
        i = j;
        if (!this.d) {
          i = j - AIOUtils.a(18.0F, getResources());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.a(paramInt, i);
    }
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    return RIJFeedsType.r(paramIReadInJoyModel.a());
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(a(paramContext));
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(paramContext, 28.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView init mJumpAccountPageThreshold = " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$ReadinjoyHorizontalAdapter = new ComponentPolymericView.ReadinjoyHorizontalAdapter(this, null);
    setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$ReadinjoyHorizontalAdapter);
    setDividerWidth(AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    paramObject = (IReadInJoyModel)paramObject;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
    ArticleInfo localArticleInfo = paramObject.a();
    this.jdField_b_of_type_Int = RIJItemViewType.a(localArticleInfo);
    this.jdField_b_of_type_Boolean = RIJFeedsType.r(localArticleInfo);
    this.c = RIJFeedsType.m(localArticleInfo);
    boolean bool;
    List localList;
    if ((RIJFeedsType.o(localArticleInfo)) || (RIJFeedsType.p(localArticleInfo)))
    {
      bool = true;
      this.d = bool;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView bindData mIsNewPolymeric = " + this.jdField_b_of_type_Boolean);
      }
      localList = localArticleInfo.mGroupSubArticleList;
      if ((localList == null) || ((localList.size() <= 2) && (!RIJFeedsType.r(paramObject.a())))) {
        break label234;
      }
      setOverScrollMode(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = localList;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[this.jdField_a_of_type_JavaUtilList.size()];
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$ReadinjoyHorizontalAdapter.notifyDataSetChanged();
      resetCurrentX(localArticleInfo.mCurrentX);
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "articleID = " + localArticleInfo.mArticleID + "bindData resetCurrentX currentX = " + localArticleInfo.mCurrentX);
      }
      return;
      bool = false;
      break;
      label234:
      setOverScrollMode(2);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (j == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.jdField_a_of_type_Boolean);
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.jdField_b_of_type_Float;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F)))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        a(getScrollX() - this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      break;
      if ((j == 3) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + j + " mIsPress=" + this.jdField_a_of_type_Boolean);
        }
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView != null) {
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.c();
        }
        if ((j == 1) && (this.jdField_b_of_type_Boolean) && (getScrollX() > i + this.jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView before jump to account page");
          }
          String str = ComponentPolymericViewJumpUrlGenerator.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a().a());
          if (!TextUtils.isEmpty(str))
          {
            ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, str);
            if (QLog.isColorLevel()) {
              QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView jump to person page url =" + str);
            }
          }
        }
        a();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().a().a().a(localBaseArticleInfo, paramView, paramInt, paramLong);
    if (!RIJFeedsType.g(localBaseArticleInfo)) {
      localObject1 = RIJKanDianFolderStatus.a(localBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("rowkey", localBaseArticleInfo.innerUniqueID);
        i = 0;
        switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView$ReadinjoyHorizontalAdapter.getItemViewType(paramInt))
        {
        }
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        localException2.printStackTrace();
        continue;
        localObject1 = Integer.valueOf(0);
        continue;
        int i = 0;
        continue;
        continue;
      }
      ((JSONObject)localObject1).put("content_type", i);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramInt + "", localBaseArticleInfo.mArticleID + "", localBaseArticleInfo.mStrategyId + "", ((JSONObject)localObject1).toString(), false);
      if (this.d) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localObject2 = (NewPolymericInfo.PackArticleInfo)localBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
        localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
        if (((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackQuestionAnswerExtraInfo == null) {
          continue;
        }
        localObject1 = ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackQuestionAnswerExtraInfo.a;
        localJSONObject.put("rowkey", localObject1);
        if (((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo == null) {
          continue;
        }
        i = ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_Int;
        localJSONObject.put("topicid", i);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        String str2;
        localException1.printStackTrace();
        continue;
        String str1 = "2";
        continue;
      }
      localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = localBaseArticleInfo.mFeedId + "";
      if (!RIJFeedsType.o(localBaseArticleInfo)) {
        continue;
      }
      localObject1 = "1";
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, str2, (String)localObject1, localBaseArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView scrollx" + paramInt1);
    }
    if (paramInt1 <= 2)
    {
      a();
      return;
    }
    a(paramInt1 - this.jdField_a_of_type_Int);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a();
      if (localObject != null)
      {
        localObject = ((IReadInJoyModel)localObject).a();
        paramInt = getCurrentX();
        ((ArticleInfo)localObject).mCurrentX = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "articleID = " + ((ArticleInfo)localObject).mArticleID + "onScrollStateChanged currentX = " + paramInt);
        }
      }
    }
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */