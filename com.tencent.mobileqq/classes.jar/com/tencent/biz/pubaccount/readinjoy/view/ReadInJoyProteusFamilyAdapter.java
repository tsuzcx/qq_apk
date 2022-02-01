package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerFactory;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyProteusFamilyAdapter
  extends ReadInJoyBaseAdapter
{
  private static DynamicItemViewHelper jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper = new DynamicItemViewHelper();
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<BaseHandler> jdField_a_of_type_AndroidUtilSparseArray;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
  private Activity jdField_b_of_type_AndroidAppActivity;
  
  public ReadInJoyProteusFamilyAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<BaseHandler> paramSparseArray, Context paramContext)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    a(this.jdField_a_of_type_AndroidUtilSparseArray);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
  }
  
  private void a(SparseArray<BaseHandler> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a(this);
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    return RIJItemViewType.a((ArticleInfo)getItem(paramInt));
  }
  
  public Activity a()
  {
    return this.jdField_b_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return null;
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return null;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList) {}
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1) {}
  
  public void a(List<BaseArticleInfo> paramList)
  {
    if ((a() != null) && (paramList != null)) {
      a().addAll(paramList);
    }
    HandlerFactory.a(this.jdField_a_of_type_AndroidUtilSparseArray, new ReadInJoyProteusFamilyAdapter.1(this, "onSetData", paramList));
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return false;
  }
  
  public int getCount()
  {
    if (a() != null) {
      return a().size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return super.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((a() == null) || (a().size() == 0)) {}
    int i;
    for (Object localObject = null;; localObject = (View)HandlerFactory.a(this.jdField_a_of_type_AndroidUtilSparseArray, new ReadInJoyProteusFamilyAdapter.2(this, "onAdapterGetView", i, (BaseArticleInfo)localObject, paramInt, paramViewGroup)))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = b(paramInt);
      i = getItemViewType(paramInt);
      QLog.d("ReadInJoyProteusFamilyAdapter", 2, "getView | position : " + paramInt + " type : " + i + " article_title = " + ((BaseArticleInfo)localObject).mTitle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyAdapter
 * JD-Core Version:    0.7.0.1
 */