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
  private RecyclerView a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private TopPanelContract.Presenter f;
  private TopRecommendBannerAdapter g;
  private View h;
  private boolean i = false;
  
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
    if (paramInt < this.g.getItemCount())
    {
      this.g.a(paramInt);
      if ((!this.g.e()) && (!this.g.d()))
      {
        TopPanelContract.Presenter localPresenter = this.f;
        if (localPresenter != null) {
          localPresenter.a();
        }
      }
      a();
    }
  }
  
  public void a()
  {
    if ((this.g.d()) && (this.d.getVisibility() == 0))
    {
      this.b.setVisibility(8);
      this.d.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.g;
    if (localTopRecommendBannerAdapter != null)
    {
      localTopRecommendBannerAdapter.d(paramBoolean);
      this.g.a(paramStEntry, paramList);
      this.a.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.i = SubscribeUtils.a();
    setOrientation(1);
    inflate(paramContext, 2131624386, this);
    this.a = ((RecyclerView)findViewById(2131429281));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.a.setLayoutManager(paramContext);
    this.a.addItemDecoration(new RecommendBannerItemDecoration());
    this.g = new TopRecommendBannerAdapter(this.a);
    this.g.b(this.i);
    this.g.c(true);
    this.a.setAdapter(this.g);
    this.g.a(new RecommendBannerViewNew.1(this));
    this.c = ((ImageView)findViewById(2131436318));
    this.h = findViewById(2131432025);
    this.e = ((TextView)findViewById(2131444466));
    this.b = ((ImageView)findViewById(2131444423));
    this.d = ((TextView)findViewById(2131444424));
    this.d.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (this.i)
    {
      this.b.setImageDrawable(getResources().getDrawable(2130839167));
      this.c.setImageDrawable(getResources().getDrawable(2130839112));
      this.h.setBackgroundColor(-9211021);
      this.e.setTextColor(-10132123);
      this.d.setTextColor(-10132123);
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
    case 2131444423: 
    case 2131444424: 
      TopRecommendBannerAdapter localTopRecommendBannerAdapter = this.g;
      if ((localTopRecommendBannerAdapter != null) && (this.f != null))
      {
        if ((!localTopRecommendBannerAdapter.c()) && (!this.g.d())) {
          this.f.a();
        } else {
          this.a.smoothScrollToPosition(0);
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
      if (this.g == null) {
        return;
      }
      int j = 0;
      while (j < this.g.a().size())
      {
        RecommendFeedbackEvent localRecommendFeedbackEvent = (RecommendFeedbackEvent)paramSimpleBaseEvent;
        if (((localRecommendFeedbackEvent.type == 1) && (localRecommendFeedbackEvent.user != null) && (TextUtils.equals(((RecommendInfoItem)this.g.a().get(j)).b.id.get(), localRecommendFeedbackEvent.user.id.get()))) || ((localRecommendFeedbackEvent.type == 2) && (localRecommendFeedbackEvent.feed != null) && (TextUtils.equals(((RecommendInfoItem)this.g.a().get(j)).c.id.get(), localRecommendFeedbackEvent.feed.id.get())))) {
          break label165;
        }
        j += 1;
      }
      j = -1;
      label165:
      if (j != -1) {
        a(j);
      }
    }
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.f = paramPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */