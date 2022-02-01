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
import bhdz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import olh;
import org.json.JSONObject;
import pkh;
import pnr;
import pnu;
import ppe;
import pqw;
import prp;
import qfw;
import rbn;
import rbx;
import rfw;
import rjc;
import rjd;
import rps;
import rpt;
import rpu;
import rpv;
import szd;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, HorizontalListView.OnScrollStateChangedListener, rbn
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BezierSideBarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView;
  private List<BaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rfw jdField_a_of_type_Rfw;
  private rjc jdField_a_of_type_Rjc;
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
  
  public static boolean a(qfw paramqfw)
  {
    return pqw.r(paramqfw.a());
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Rfw = new rfw();
    a(a(paramContext));
    this.jdField_a_of_type_Int = ((int)bhdz.a(paramContext, 28.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView init mJumpAccountPageThreshold = " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_Rjc = new rjc(this, null);
    setAdapter(this.jdField_a_of_type_Rjc);
    setDividerWidth(AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public void a(Object paramObject)
  {
    paramObject = (qfw)paramObject;
    this.jdField_a_of_type_Rfw.a(paramObject);
    ArticleInfo localArticleInfo = paramObject.a();
    this.jdField_b_of_type_Int = ppe.a(localArticleInfo);
    this.jdField_b_of_type_Boolean = pqw.r(localArticleInfo);
    this.c = pqw.m(localArticleInfo);
    boolean bool;
    List localList;
    if ((pqw.o(localArticleInfo)) || (pqw.p(localArticleInfo)))
    {
      bool = true;
      this.d = bool;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView bindData mIsNewPolymeric = " + this.jdField_b_of_type_Boolean);
      }
      localList = localArticleInfo.mGroupSubArticleList;
      if ((localList == null) || ((localList.size() <= 2) && (!pqw.r(paramObject.a())))) {
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
      this.jdField_a_of_type_Rjc.notifyDataSetChanged();
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
  
  public void a(rbx paramrbx) {}
  
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
          String str = rjd.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Rfw.a().a());
          if (!TextUtils.isEmpty(str))
          {
            pkh.a(this.jdField_a_of_type_AndroidContentContext, str);
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
    this.jdField_a_of_type_Rfw.a.a().a().a().a(localBaseArticleInfo, paramView, paramInt, paramLong);
    if (!pqw.g(localBaseArticleInfo)) {
      localObject1 = prp.a(localBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("rowkey", localBaseArticleInfo.innerUniqueID);
        i = 0;
        switch (this.jdField_a_of_type_Rjc.getItemViewType(paramInt))
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
      olh.a(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramInt + "", localBaseArticleInfo.mArticleID + "", localBaseArticleInfo.mStrategyId + "", ((JSONObject)localObject1).toString(), false);
      if (this.d) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localObject2 = (rpt)localBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
        localJSONObject.put("channel_id", this.jdField_a_of_type_Rfw.a.e());
        if (((rpt)localObject2).jdField_a_of_type_Rpu == null) {
          continue;
        }
        localObject1 = ((rpt)localObject2).jdField_a_of_type_Rpu.a;
        localJSONObject.put("rowkey", localObject1);
        if (((rpt)localObject2).jdField_a_of_type_Rpv == null) {
          continue;
        }
        i = ((rpt)localObject2).jdField_a_of_type_Rpv.jdField_b_of_type_Int;
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
      if (!pqw.o(localBaseArticleInfo)) {
        continue;
      }
      localObject1 = "1";
      olh.a(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, (String)localObject2, (String)localObject1, localBaseArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
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
      Object localObject = this.jdField_a_of_type_Rfw.a();
      if (localObject != null)
      {
        localObject = ((qfw)localObject).a();
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