package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseHandler
{
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = null;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = null;
  
  public abstract int a();
  
  public final Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a();
  }
  
  public RIJDataManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public final ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  }
  
  public ReadInJoyBaseListViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public final IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public AbsListView a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    }
    return null;
  }
  
  public Boolean a()
  {
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItemViewType(paramInt));
  }
  
  public final Object a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItem(paramInt);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, int paramInt) {}
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt) {}
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(View paramView, ListView paramListView) {}
  
  public void a(View paramView, ListView paramListView, long paramLong) {}
  
  public final void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public final void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = paramReadInJoyBaseListViewGroup;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void a(List<BaseArticleInfo> paramList) {}
  
  public void a(Map<Integer, BaseReportData> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean) {}
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
  }
  
  public void b() {}
  
  public void b(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList) {}
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2) {}
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b();
  }
  
  public void c() {}
  
  public final int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler
 * JD-Core Version:    0.7.0.1
 */