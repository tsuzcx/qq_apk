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
import bfuc;
import bfvh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import odq;
import org.json.JSONObject;
import paa;
import pay;
import peo;
import per;
import pgb;
import pvc;
import qpi;
import qps;
import qtr;
import qwx;
import rdm;
import rdn;
import rdo;
import rdp;
import rer;
import rfj;
import rga;
import rgc;
import slt;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, HorizontalListView.OnScrollStateChangedListener, qpi
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private qtr jdField_a_of_type_Qtr;
  private qwx jdField_a_of_type_Qwx;
  private boolean jdField_a_of_type_Boolean;
  private Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
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
          i = j - AIOUtils.dp2px(18.0F, getResources());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.a(paramInt, i);
    }
  }
  
  public static boolean a(pvc parampvc)
  {
    return pay.r(parampvc.a());
  }
  
  private void b()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qtr.a().a();
    if (localArticleInfo == null) {
      return;
    }
    Object localObject3 = "";
    long l2 = 0L;
    Object localObject1;
    if (this.jdField_b_of_type_Int == 79)
    {
      if ((localArticleInfo.mTopicRecommendFeedsInfo == null) || (localArticleInfo.mTopicRecommendFeedsInfo.a == null) || (localArticleInfo.mTopicRecommendFeedsInfo.a.isEmpty()))
      {
        QLog.d("HorizontalListView", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
        return;
      }
      localObject1 = ((rgc)localArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b;
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView TYPE_NEW_POLYMERIC_CONTAINER_TOPIC jump account url =" + (String)localObject1);
        localObject3 = localObject1;
      }
    }
    long l1;
    if ((pgb.a(localArticleInfo)) || (pgb.h(localArticleInfo)) || (this.jdField_b_of_type_Int == 77) || (this.jdField_b_of_type_Int == 78))
    {
      localObject1 = localObject3;
      l1 = l2;
      if (TextUtils.isEmpty(localArticleInfo.mSubscribeID)) {}
    }
    label849:
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(localArticleInfo.mSubscribeID);
        localObject1 = paa.k + bfuc.encodeToString(String.valueOf(l1).getBytes(), 2);
        if (!QLog.isColorLevel()) {
          break label849;
        }
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView PGC jump account url =" + (String)localObject1 + " uin = " + l1);
        localObject3 = localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(localArticleInfo.mSubscribeID))) {
          break label611;
        }
        try
        {
          l2 = Long.parseLong(localArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          Object localObject2;
          localNumberFormatException2.printStackTrace();
          continue;
        }
        localObject1 = paa.k + bfuc.encodeToString(String.valueOf(l1).getBytes(), 2);
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + (String)localObject1 + " mSubscribeID = " + l1);
          localObject3 = localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break;
        }
        pay.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView jump to person page url =" + (String)localObject3);
        return;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        l1 = 0L;
        continue;
      }
      if (!pgb.g(localArticleInfo))
      {
        localObject2 = localObject3;
        l1 = l2;
        if (this.jdField_b_of_type_Int != 76) {}
      }
      else
      {
        localObject2 = localObject3;
        l1 = l2;
        if (localArticleInfo.mSocialFeedInfo != null)
        {
          localObject2 = localObject3;
          l1 = l2;
          if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null)
          {
            l2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.a;
            localObject3 = paa.g + bfuc.encodeToString(String.valueOf(l2).getBytes(), 2);
            localObject2 = localObject3;
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView UGC jump account url =" + (String)localObject3 + " uin = " + l2);
              localObject2 = localObject3;
              l1 = l2;
              continue;
              label611:
              String str;
              if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null))
              {
                l1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.a;
                str = paa.g + bfuc.encodeToString(String.valueOf(l1).getBytes(), 2);
                localObject3 = str;
                if (QLog.isColorLevel())
                {
                  QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str + " mUGCFeedsInfo.cuin = " + l1);
                  localObject3 = str;
                }
              }
              else
              {
                localObject3 = str;
                if (localArticleInfo.mSocialFeedInfo != null)
                {
                  localObject3 = str;
                  if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null)
                  {
                    l1 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.a;
                    str = paa.g + bfuc.encodeToString(String.valueOf(l1).getBytes(), 2);
                    localObject3 = str;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView empty url jump account url =" + str + " mMasterUser.uin = " + l1);
                      localObject3 = str;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Qtr = new qtr();
    a(a(paramContext));
    this.jdField_a_of_type_Int = ((int)bfvh.a(paramContext, 28.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView init mJumpAccountPageThreshold = " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_Qwx = new qwx(this, null);
    setAdapter(this.jdField_a_of_type_Qwx);
    setDividerWidth(AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public void a(Object paramObject)
  {
    paramObject = (pvc)paramObject;
    this.jdField_a_of_type_Qtr.a(paramObject);
    ArticleInfo localArticleInfo = paramObject.a();
    this.jdField_b_of_type_Int = pgb.a(localArticleInfo);
    this.jdField_b_of_type_Boolean = pay.r(localArticleInfo);
    this.c = pay.m(localArticleInfo);
    boolean bool;
    List localList;
    if ((pay.o(localArticleInfo)) || (pay.p(localArticleInfo)))
    {
      bool = true;
      this.d = bool;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView bindData mIsNewPolymeric = " + this.jdField_b_of_type_Boolean);
      }
      localList = localArticleInfo.mGroupSubArticleList;
      if ((localList == null) || ((localList.size() <= 2) && (!pay.r(paramObject.a())))) {
        break label237;
      }
      setOverScrollMode(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = localList;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[this.jdField_a_of_type_JavaUtilList.size()];
      }
      this.jdField_a_of_type_Qwx.notifyDataSetChanged();
      resetCurrentX(localArticleInfo.mCurrentX);
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "articleID = " + localArticleInfo.mArticleID + "bindData resetCurrentX currentX = " + localArticleInfo.mCurrentX);
      }
      return;
      bool = false;
      break;
      label237:
      setOverScrollMode(2);
    }
  }
  
  public void a(qps paramqps) {}
  
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
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.dip2px(getContext(), 5.0F)))
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
          b();
        }
        a();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_Qtr.a.a().a().a().a(localBaseArticleInfo, paramView, paramInt, paramLong);
    if (!pay.s(localBaseArticleInfo)) {
      localObject1 = pay.a(localBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("rowkey", localBaseArticleInfo.innerUniqueID);
        i = 0;
        switch (this.jdField_a_of_type_Qwx.getItemViewType(paramInt))
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
      odq.a(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramInt + "", localBaseArticleInfo.mArticleID + "", localBaseArticleInfo.mStrategyId + "", ((JSONObject)localObject1).toString(), false);
      if (this.d) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localObject2 = (rdn)localBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
        localJSONObject.put("channel_id", this.jdField_a_of_type_Qtr.a.e());
        if (((rdn)localObject2).jdField_a_of_type_Rdo == null) {
          continue;
        }
        localObject1 = ((rdn)localObject2).jdField_a_of_type_Rdo.a;
        localJSONObject.put("rowkey", localObject1);
        if (((rdn)localObject2).jdField_a_of_type_Rdp == null) {
          continue;
        }
        i = ((rdn)localObject2).jdField_a_of_type_Rdp.jdField_b_of_type_Int;
        localJSONObject.put("topicid", i);
      }
      catch (Exception localException1)
      {
        Object localObject2;
        localException1.printStackTrace();
        continue;
        String str = "2";
        continue;
      }
      localObject2 = localBaseArticleInfo.mFeedId + "";
      if (!pay.o(localBaseArticleInfo)) {
        continue;
      }
      localObject1 = "1";
      odq.a(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, (String)localObject2, (String)localObject1, localBaseArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
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
      Object localObject = this.jdField_a_of_type_Qtr.a();
      if (localObject != null)
      {
        localObject = ((pvc)localObject).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */