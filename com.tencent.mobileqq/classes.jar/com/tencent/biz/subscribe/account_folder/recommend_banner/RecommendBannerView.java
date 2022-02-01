package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelContract.Presenter;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class RecommendBannerView
  extends LinearLayout
  implements View.OnClickListener, SimpleEventReceiver
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopRecommendBannerAdapter jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter;
  private TopPanelContract.Presenter jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter;
  
  public RecommendBannerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecommendBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.getItemCount())
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(paramInt);
      if ((!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.c()) && (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b()) && (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter != null)) {
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter.a();
      }
      a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b()) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.d(paramBoolean);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131558864, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363464));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new RecommendBannerItemDecoration());
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter = new TopRecommendBannerAdapter(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b(SubscribeUtils.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(new RecommendBannerView.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376716));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376717));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(RecommendFeedbackEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter != null) && (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a()) || (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b())) {
        break label108;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter.a();
    }
    for (;;)
    {
      a();
      VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_change", 0, 0, new String[0]);
      break;
      label108:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((RecommendInfoItem)this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
          j = i;
        }
      }
      for (;;)
      {
        if (j == -1) {
          break label188;
        }
        a(j);
        return;
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 2) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).feed != null))
        {
          j = i;
          if (TextUtils.equals(((RecommendInfoItem)this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
        }
        else
        {
          i += 1;
          break;
          j = -1;
        }
      }
    }
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter = paramPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView
 * JD-Core Version:    0.7.0.1
 */