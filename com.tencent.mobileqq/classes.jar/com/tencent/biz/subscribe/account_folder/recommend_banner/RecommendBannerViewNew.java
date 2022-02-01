package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
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

public class RecommendBannerViewNew
  extends LinearLayout
  implements View.OnClickListener, SimpleEventReceiver
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopRecommendBannerAdapter jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter;
  private TopPanelContract.Presenter jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public RecommendBannerViewNew(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecommendBannerViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.getItemCount())
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(paramInt);
      if ((!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.c()) && (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b()))
      {
        TopPanelContract.Presenter localPresenter = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter;
        if (localPresenter != null) {
          localPresenter.a();
        }
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
    TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter;
    if (localTopRecommendBannerAdapter != null)
    {
      localTopRecommendBannerAdapter.d(paramBoolean);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = SubscribeUtils.a();
    setOrientation(1);
    inflate(paramContext, 2131558766, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363391));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new RecommendBannerItemDecoration());
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter = new TopRecommendBannerAdapter(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.c(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a(new RecommendBannerViewNew.1(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369319));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365768);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376258));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376215));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376216));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839013));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838958));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-9211021);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10132123);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(RecommendFeedbackEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376215: 
    case 2131376216: 
      TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter;
      if ((localTopRecommendBannerAdapter != null) && (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter != null))
      {
        if ((!localTopRecommendBannerAdapter.a()) && (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.b())) {
          this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter.a();
        } else {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
        }
        a();
      }
      VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof RecommendFeedbackEvent))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter == null) {
        return;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().size())
      {
        RecommendFeedbackEvent localRecommendFeedbackEvent = (RecommendFeedbackEvent)paramSimpleBaseEvent;
        if (((localRecommendFeedbackEvent.type == 1) && (localRecommendFeedbackEvent.user != null) && (TextUtils.equals(((RecommendInfoItem)this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), localRecommendFeedbackEvent.user.id.get()))) || ((localRecommendFeedbackEvent.type == 2) && (localRecommendFeedbackEvent.feed != null) && (TextUtils.equals(((RecommendInfoItem)this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendBannerAdapter.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), localRecommendFeedbackEvent.feed.id.get())))) {
          break label165;
        }
        i += 1;
      }
      i = -1;
      label165:
      if (i != -1) {
        a(i);
      }
    }
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter = paramPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */