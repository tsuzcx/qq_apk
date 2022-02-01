package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import aaak;
import aaam;
import aaek;
import aafe;
import aafk;
import aafm;
import aafo;
import aagb;
import abbe;
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
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class RecommendBannerViewNew
  extends LinearLayout
  implements aaam, View.OnClickListener
{
  private aafm jdField_a_of_type_Aafm;
  private aafo jdField_a_of_type_Aafo;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
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
    if (paramInt < this.jdField_a_of_type_Aafm.getItemCount())
    {
      this.jdField_a_of_type_Aafm.a(paramInt);
      if ((!this.jdField_a_of_type_Aafm.c()) && (!this.jdField_a_of_type_Aafm.b()) && (this.jdField_a_of_type_Aafo != null)) {
        this.jdField_a_of_type_Aafo.a();
      }
      a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aafm.b()) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<aagb> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aafm != null)
    {
      this.jdField_a_of_type_Aafm.d(paramBoolean);
      this.jdField_a_of_type_Aafm.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = aaek.a();
    setOrientation(1);
    inflate(paramContext, 2131558795, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363284));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aafe());
    this.jdField_a_of_type_Aafm = new aafm(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Aafm.b(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aafm.c(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aafm);
    this.jdField_a_of_type_Aafm.a(new aafk(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369171));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365642);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376352));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376308));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376309));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839037));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838982));
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
    aaak.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if ((this.jdField_a_of_type_Aafm != null) && (this.jdField_a_of_type_Aafo != null))
    {
      if ((this.jdField_a_of_type_Aafm.a()) || (this.jdField_a_of_type_Aafm.b())) {
        break label108;
      }
      this.jdField_a_of_type_Aafo.a();
    }
    for (;;)
    {
      a();
      abbe.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
      break;
      label108:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_Aafm == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_Aafm.a().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((aagb)this.jdField_a_of_type_Aafm.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
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
          if (TextUtils.equals(((aagb)this.jdField_a_of_type_Aafm.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
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
  
  public void setPresenter(aafo paramaafo)
  {
    this.jdField_a_of_type_Aafo = paramaafo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */