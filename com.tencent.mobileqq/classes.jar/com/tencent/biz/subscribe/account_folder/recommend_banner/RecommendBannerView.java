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
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import ybu;
import yco;
import yct;
import ycw;
import ycy;
import ydn;
import yiw;
import yiy;
import zaj;

public class RecommendBannerView
  extends LinearLayout
  implements View.OnClickListener, yiy
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ycw jdField_a_of_type_Ycw;
  private ycy jdField_a_of_type_Ycy;
  
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
    if (paramInt < this.jdField_a_of_type_Ycw.getItemCount())
    {
      this.jdField_a_of_type_Ycw.a(paramInt);
      if ((!this.jdField_a_of_type_Ycw.c()) && (!this.jdField_a_of_type_Ycw.b()) && (this.jdField_a_of_type_Ycy != null)) {
        this.jdField_a_of_type_Ycy.a();
      }
      a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Ycw.b()) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<ydn> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ycw != null)
    {
      this.jdField_a_of_type_Ycw.d(paramBoolean);
      this.jdField_a_of_type_Ycw.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(1);
    inflate(paramContext, 2131558727, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363076));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new yco());
    this.jdField_a_of_type_Ycw = new ycw(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Ycw.b(ybu.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ycw);
    this.jdField_a_of_type_Ycw.a(new yct(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375444));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375445));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
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
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Ycw != null) && (this.jdField_a_of_type_Ycy != null))
    {
      if ((this.jdField_a_of_type_Ycw.a()) || (this.jdField_a_of_type_Ycw.b())) {
        break label99;
      }
      this.jdField_a_of_type_Ycy.a();
    }
    for (;;)
    {
      a();
      zaj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_change", 0, 0, new String[0]);
      return;
      label99:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_Ycw == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_Ycw.a().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((ydn)this.jdField_a_of_type_Ycw.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
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
          if (TextUtils.equals(((ydn)this.jdField_a_of_type_Ycw.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
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
  
  public void setPresenter(ycy paramycy)
  {
    this.jdField_a_of_type_Ycy = paramycy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView
 * JD-Core Version:    0.7.0.1
 */