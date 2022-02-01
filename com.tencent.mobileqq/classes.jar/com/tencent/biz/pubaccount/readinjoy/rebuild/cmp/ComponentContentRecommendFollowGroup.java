package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhkv;
import bhnv;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ocd;
import oyu;
import ozs;
import pfa;
import pfd;
import pfh;
import pow;
import ppu;
import pra;
import qjf;
import qjp;
import qov;
import qow;
import qox;
import qoy;
import qwy;
import sel;
import sxi;
import zft;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements qjf, sxi
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  protected pfh a;
  private ppu jdField_a_of_type_Ppu;
  private qoy jdField_a_of_type_Qoy;
  private View b;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Pfh = new qox(this);
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
      ocd.a(null, ozs.a() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560112, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131376344));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376353));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369723);
    this.b = paramView.findViewById(2131376347);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363389);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_Qoy = new qoy(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(zft.b(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_Qoy);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.b.setOnClickListener(new qov(this));
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!bhnv.g(getContext())) {
      QQToast.a(getContext(), 1, 2131717203, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowGroup", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = oyu.k + bhkv.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(localIntent, 1);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
  }
  
  public void a(Object paramObject)
  {
    jdField_a_of_type_Int = ozs.d();
    if ((paramObject instanceof ppu))
    {
      this.jdField_a_of_type_Ppu = ((ppu)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Ppu.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Qoy.a(paramObject.jdField_b_of_type_JavaUtilList);
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
    if (this.jdField_a_of_type_Ppu != null)
    {
      i = j;
      if (this.jdField_a_of_type_Ppu.a() != null) {
        i = this.jdField_a_of_type_Ppu.a().a();
      }
    }
    paramList = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 3, paramInt2, jdField_a_of_type_Int, paramList);
    ocd.a(null, ozs.a() + "", paramString, paramString, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", paramList, false);
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
        localArrayList1.add(new pow(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
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
      paramList = new qow(this, paramList, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      pfa.a().a().a(localArrayList1, paramList, 2);
      return;
      label174:
      a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    pfa.a().a().b(localArrayList1, paramList, 2);
  }
  
  public void a(qjp paramqjp) {}
  
  public void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    pfa.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  public void c()
  {
    a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pfd.a().b(this.jdField_a_of_type_Pfh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */