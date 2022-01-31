package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdbi;
import bdee;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import nrt;
import oqu;
import ors;
import owy;
import oxb;
import oxe;
import pgd;
import phg;
import pxj;
import pxt;
import qde;
import qdf;
import qdg;
import qdh;
import qdi;
import qdj;
import qlt;
import rqj;
import shx;
import xee;

public class ComponentContentRecommendFollowList
  extends RelativeLayout
  implements pxj, shx
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  protected oxe a;
  private pgd jdField_a_of_type_Pgd;
  private qdj jdField_a_of_type_Qdj;
  private View b;
  
  public ComponentContentRecommendFollowList(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Oxe = new qdi(this);
    a(paramContext);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mRecommendFollowInfos == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 2, 0, jdField_a_of_type_Int, null);
      nrt.a(null, ors.a() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559954, this, true);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.b;
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131375429));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375438));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369221);
    this.b = paramView.findViewById(2131375432);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363178);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Qdj = new qdj(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(xee.b(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Qdj);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.b.setOnClickListener(new qde(this));
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    owy.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowList.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (bdee.g(getContext()))
    {
      if (paramBoolean)
      {
        a("0X80094DC", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
        if (paramRecommendFollowInfo.type != 1) {
          break label79;
        }
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_Qdj.notifyDataSetChanged();
        return;
        a("0X80094DD", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
        break;
        label79:
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e("ComponentContentRecommendFollowList", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    QQToast.a(getContext(), 1, 2131718949, 0).a();
  }
  
  public void a(Object paramObject)
  {
    jdField_a_of_type_Int = ors.d();
    if ((paramObject instanceof pgd))
    {
      this.jdField_a_of_type_Pgd = ((pgd)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Pgd.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Qdj.a(paramObject.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Pgd != null)
    {
      i = j;
      if (this.jdField_a_of_type_Pgd.a() != null) {
        i = this.jdField_a_of_type_Pgd.a().a();
      }
    }
    String str = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 2, paramInt2, jdField_a_of_type_Int, null);
    nrt.a(null, ors.a() + "", paramString, paramString, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", str, false);
  }
  
  public void a(pxt parampxt) {}
  
  public void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!bdee.g(getContext())) {
      QQToast.a(getContext(), 1, 2131718949, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowList", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = oqu.k + bdbi.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    getContext().startActivity(localIntent);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    owy.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new qdf(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    a();
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      owy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new qdg(this, paramRecommendFollowInfo), 1);
      return;
    }
    owy.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new qdh(this, paramRecommendFollowInfo), 1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    oxb.a().a(this.jdField_a_of_type_Oxe);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList
 * JD-Core Version:    0.7.0.1
 */