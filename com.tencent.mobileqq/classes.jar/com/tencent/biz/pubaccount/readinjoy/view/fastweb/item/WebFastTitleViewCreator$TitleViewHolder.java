package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.util.PublicDrawableUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebFastTitleViewCreator$TitleViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public WebFastTitleViewCreator$TitleViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380651));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380180));
    this.d = ((TextView)paramView.findViewById(2131380200));
    this.c = ((TextView)paramView.findViewById(2131380199));
    this.e = ((TextView)paramView.findViewById(2131380201));
    this.f = ((TextView)paramView.findViewById(2131380365));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369573));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369690));
    paramView.findViewById(2131377221).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setRound(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370603));
    paramBaseData = PublicDrawableUtil.a(null, AIOUtils.a(12.0F, paramView.getResources()), Color.parseColor("#e9ebec"));
    paramView = PublicDrawableUtil.a(null, AIOUtils.a(12.0F, paramView.getResources()), Color.parseColor("#12B7F5"));
    PublicDrawableUtil.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.f.setOnClickListener(this);
    if (paramBoolean)
    {
      this.f.setText(HardCodeUtil.a(2131716713));
      this.f.setTextColor(-4473925);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      return;
    }
    this.f.setText(HardCodeUtil.a(2131716714));
    this.f.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(true);
  }
  
  private void b()
  {
    Object localObject;
    UserOperationModule localUserOperationModule;
    long l;
    WebFastTitleViewCreator.TitleViewHolder.1 local1;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localUserOperationModule = ReadInJoyLogicEngine.a().a();
      localObject = ((QQAppInterface)localObject).getAccount();
      l = a();
      local1 = new WebFastTitleViewCreator.TitleViewHolder.1(this);
      if (!RIJItemViewType.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b)) {
        break label83;
      }
    }
    label83:
    for (int i = 2;; i = 1)
    {
      localUserOperationModule.a((String)localObject, l, true, "", local1, i);
      return;
    }
  }
  
  private void c() {}
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastTitleViewCreator.TitleViewHolder
 * JD-Core Version:    0.7.0.1
 */