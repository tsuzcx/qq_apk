package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.LinkData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebFastLinkViewCreator$TextViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private TextView a;
  
  public WebFastLinkViewCreator$TextViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380639));
    paramView.setOnClickListener(this);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.s)
    {
    default: 
      return;
    }
    paramBaseData1 = (LinkData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramBaseData1.a));
  }
  
  public void onClick(View paramView)
  {
    LinkData localLinkData = (LinkData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), localLinkData.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLinkViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */