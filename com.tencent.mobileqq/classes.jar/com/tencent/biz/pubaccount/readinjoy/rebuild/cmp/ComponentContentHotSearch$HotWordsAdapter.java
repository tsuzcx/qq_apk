package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.HotWordItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$HotWordsAdapter
  extends BaseAdapter
{
  private List<HotWordItem> jdField_a_of_type_JavaUtilList;
  
  protected ComponentContentHotSearch$HotWordsAdapter(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public HotWordItem a(int paramInt)
  {
    return (HotWordItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<HotWordItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (0 == 0)
    {
      localObject1 = new ComponentContentHotSearch.ViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch);
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560330, null);
      ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369037));
      ((ComponentContentHotSearch.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131379527));
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      paramView.setTag(localObject1);
    }
    for (;;)
    {
      HotWordItem localHotWordItem = a(paramInt);
      if (!TextUtils.isEmpty(localHotWordItem.jdField_a_of_type_JavaLangString)) {
        ((ComponentContentHotSearch.ViewHolder)localObject1).b.setText(localHotWordItem.jdField_a_of_type_JavaLangString);
      }
      ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "");
      Object localObject2 = ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      int i;
      if (!TextUtils.isEmpty(localHotWordItem.c))
      {
        i = Color.parseColor(localHotWordItem.c);
        label159:
        ((TextView)localObject2).setTextColor(i);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), 2.0F));
        if (TextUtils.isEmpty(localHotWordItem.d)) {
          break label432;
        }
        i = Color.parseColor(localHotWordItem.d);
        ((GradientDrawable)localObject2).setColor(i);
        ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
        ((ComponentContentHotSearch.ViewHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructHotWordItem = localHotWordItem;
        if (!localHotWordItem.jdField_a_of_type_Boolean)
        {
          localHotWordItem.jdField_a_of_type_Boolean = true;
          localObject1 = RIJTransMergeKanDianReport.a(localHotWordItem.jdField_a_of_type_JavaLangString, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, paramInt + 1);
        }
      }
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
        ((ReportInfo)localObject2).mOperation = 52;
        ((ReportInfo)localObject2).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
        ((ReportInfo)localObject2).mHotWord = localHotWordItem.jdField_a_of_type_JavaLangString;
        ((List)localObject1).add(localObject2);
        ReadInJoyLogicEngine.a().a((List)localObject1);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (ComponentContentHotSearch.ViewHolder)paramView.getTag();
        continue;
        i = Color.parseColor("#8C000000");
        break label159;
        label432:
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(ComponentContentHotSearch.jdField_a_of_type_JavaLangString, 1, "getView, e = " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch.HotWordsAdapter
 * JD-Core Version:    0.7.0.1
 */