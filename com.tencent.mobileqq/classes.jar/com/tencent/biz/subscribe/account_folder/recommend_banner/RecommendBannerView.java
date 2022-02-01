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
  private RecyclerView a;
  private ImageView b;
  private TextView c;
  private TopPanelContract.Presenter d;
  private TopRecommendBannerAdapter e;
  
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
    if (paramInt < this.e.getItemCount())
    {
      this.e.a(paramInt);
      if ((!this.e.e()) && (!this.e.d()))
      {
        TopPanelContract.Presenter localPresenter = this.d;
        if (localPresenter != null) {
          localPresenter.a();
        }
      }
      a();
    }
  }
  
  public void a()
  {
    if ((this.e.d()) && (this.c.getVisibility() == 0))
    {
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.e;
    if (localTopRecommendBannerAdapter != null)
    {
      localTopRecommendBannerAdapter.d(paramBoolean);
      this.e.a(paramStEntry, paramList);
      this.a.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131624382, this);
    this.a = ((RecyclerView)findViewById(2131429281));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.a.setLayoutManager(paramContext);
    this.a.addItemDecoration(new RecommendBannerItemDecoration());
    this.e = new TopRecommendBannerAdapter(this.a);
    this.e.b(SubscribeUtils.a());
    this.a.setAdapter(this.e);
    this.e.a(new RecommendBannerView.1(this));
    this.b = ((ImageView)findViewById(2131444423));
    this.c = ((TextView)findViewById(2131444424));
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
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
    case 2131444423: 
    case 2131444424: 
      TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.e;
      if ((localTopRecommendBannerAdapter != null) && (this.d != null))
      {
        if ((!localTopRecommendBannerAdapter.c()) && (!this.e.d())) {
          this.d.a();
        } else {
          this.a.smoothScrollToPosition(0);
        }
        a();
      }
      VSReporter.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_change", 0, 0, new String[0]);
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
      if (this.e == null) {
        return;
      }
      int i = 0;
      while (i < this.e.a().size())
      {
        RecommendFeedbackEvent localRecommendFeedbackEvent = (RecommendFeedbackEvent)paramSimpleBaseEvent;
        if (((localRecommendFeedbackEvent.type == 1) && (localRecommendFeedbackEvent.user != null) && (TextUtils.equals(((RecommendInfoItem)this.e.a().get(i)).b.id.get(), localRecommendFeedbackEvent.user.id.get()))) || ((localRecommendFeedbackEvent.type == 2) && (localRecommendFeedbackEvent.feed != null) && (TextUtils.equals(((RecommendInfoItem)this.e.a().get(i)).c.id.get(), localRecommendFeedbackEvent.feed.id.get())))) {
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
    this.d = paramPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView
 * JD-Core Version:    0.7.0.1
 */