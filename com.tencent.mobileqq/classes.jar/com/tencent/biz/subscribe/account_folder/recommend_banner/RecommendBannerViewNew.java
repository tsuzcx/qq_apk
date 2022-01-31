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
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import wit;
import wjn;
import wjt;
import wjv;
import wjx;
import wkl;
import wpt;
import wpv;
import xhb;

public class RecommendBannerViewNew
  extends LinearLayout
  implements View.OnClickListener, wpv
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private wjv jdField_a_of_type_Wjv;
  private wjx jdField_a_of_type_Wjx;
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
    if (paramInt < this.jdField_a_of_type_Wjv.getItemCount())
    {
      this.jdField_a_of_type_Wjv.a(paramInt);
      if ((!this.jdField_a_of_type_Wjv.c()) && (!this.jdField_a_of_type_Wjv.b()) && (this.jdField_a_of_type_Wjx != null)) {
        this.jdField_a_of_type_Wjx.a();
      }
      a();
    }
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(RecommendFeedbackEvent.class);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Wjv.b()) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<wkl> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wjv != null)
    {
      this.jdField_a_of_type_Wjv.d(paramBoolean);
      this.jdField_a_of_type_Wjv.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = wit.a();
    setOrientation(1);
    inflate(paramContext, 2131558696, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363040));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new wjn());
    this.jdField_a_of_type_Wjv = new wjv(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Wjv.b(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wjv.c(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wjv);
    this.jdField_a_of_type_Wjv.a(new wjt(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368532));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365275);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374967));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374925));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374926));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838700));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838645));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-9211021);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10132123);
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_Wjv == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_Wjv.a().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((wkl)this.jdField_a_of_type_Wjv.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
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
          if (TextUtils.equals(((wkl)this.jdField_a_of_type_Wjv.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    wpt.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Wjv != null) && (this.jdField_a_of_type_Wjx != null))
    {
      if ((this.jdField_a_of_type_Wjv.a()) || (this.jdField_a_of_type_Wjv.b())) {
        break label101;
      }
      this.jdField_a_of_type_Wjx.a();
    }
    for (;;)
    {
      a();
      xhb.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
      return;
      label101:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    wpt.a().b(this);
  }
  
  public void setPresenter(wjx paramwjx)
  {
    this.jdField_a_of_type_Wjx = paramwjx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */