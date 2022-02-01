package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhcu;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import olh;
import pjj;
import pkh;
import pqf;
import pvj;
import pvm;
import pvq;
import qey;
import qfw;
import qia;
import rbn;
import rbx;
import rhd;
import rhe;
import rhf;
import rhg;
import rqd;
import szd;
import toq;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements rbn, toq
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  protected pvq a;
  private qfw jdField_a_of_type_Qfw;
  private rhg jdField_a_of_type_Rhg;
  private View b;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Pvq = new rhf(this);
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
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 3, 0, jdField_a_of_type_Int, null);
      olh.a(null, pkh.a() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560166, this, true);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_b_of_type_JavaLangString;
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0, null);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131376358));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376367));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369881);
    this.b = paramView.findViewById(2131376361);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363485);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Rhg = new rhg(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.dip2px(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Rhg);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.b.setOnClickListener(new rhd(this));
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(getContext())) {
      QQToast.a(getContext(), 1, 2131717802, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowGroup", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = pjj.k + bhcu.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(localIntent, 1);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
  }
  
  public void a(Object paramObject)
  {
    jdField_a_of_type_Int = pqf.a();
    if ((paramObject instanceof qfw))
    {
      this.jdField_a_of_type_Qfw = ((qfw)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Qfw.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Rhg.a(paramObject.jdField_b_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<RecommendFollowInfo> paramList)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Qfw != null)
    {
      i = j;
      if (this.jdField_a_of_type_Qfw.a() != null) {
        i = this.jdField_a_of_type_Qfw.a().a();
      }
    }
    paramList = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 3, paramInt2, jdField_a_of_type_Int, paramList);
    olh.a(null, pkh.a() + "", paramString, paramString, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", paramList, false);
  }
  
  public void a(List<RecommendFollowInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    RecommendFollowInfo localRecommendFollowInfo;
    while (i < paramList.size())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)paramList.get(i);
      if (paramBoolean != localRecommendFollowInfo.isFollowed)
      {
        localArrayList1.add(new qey(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
        localArrayList2.add(localRecommendFollowInfo);
      }
      i += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)localArrayList2.get(0);
      if (!paramBoolean) {
        break label174;
      }
      a("0X80094DC", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    for (;;)
    {
      paramList = new rhe(this, paramList, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      pvj.a().a().a(localArrayList1, paramList, 2);
      return;
      label174:
      a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    pvj.a().a().b(localArrayList1, paramList, 2);
  }
  
  public void a(rbx paramrbx) {}
  
  public void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    pvj.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  public void c()
  {
    a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */