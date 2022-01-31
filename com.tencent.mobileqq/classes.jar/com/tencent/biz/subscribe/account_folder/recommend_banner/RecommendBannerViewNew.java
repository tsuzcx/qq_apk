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
import xxl;
import xyf;
import xyl;
import xyn;
import xyp;
import xze;
import yej;
import yel;
import yvu;

public class RecommendBannerViewNew
  extends LinearLayout
  implements View.OnClickListener, yel
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private xyn jdField_a_of_type_Xyn;
  private xyp jdField_a_of_type_Xyp;
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
    if (paramInt < this.jdField_a_of_type_Xyn.getItemCount())
    {
      this.jdField_a_of_type_Xyn.a(paramInt);
      if ((!this.jdField_a_of_type_Xyn.c()) && (!this.jdField_a_of_type_Xyn.b()) && (this.jdField_a_of_type_Xyp != null)) {
        this.jdField_a_of_type_Xyp.a();
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
    if ((this.jdField_a_of_type_Xyn.b()) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<xze> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xyn != null)
    {
      this.jdField_a_of_type_Xyn.d(paramBoolean);
      this.jdField_a_of_type_Xyn.a(paramStEntry, paramList);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = xxl.a();
    setOrientation(1);
    inflate(paramContext, 2131558732, this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131363076));
    paramContext = new LinearLayoutManager(paramContext);
    paramContext.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new xyf());
    this.jdField_a_of_type_Xyn = new xyn(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Xyn.b(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xyn.c(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Xyn);
    this.jdField_a_of_type_Xyn.a(new xyl(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368728));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365360);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375437));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375393));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375394));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838777));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838722));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-9211021);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10132123);
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((!(paramSimpleBaseEvent instanceof RecommendFeedbackEvent)) || (this.jdField_a_of_type_Xyn == null)) {}
    label188:
    for (;;)
    {
      return;
      int i = 0;
      int j;
      if (i < this.jdField_a_of_type_Xyn.a().size()) {
        if ((((RecommendFeedbackEvent)paramSimpleBaseEvent).type == 1) && (((RecommendFeedbackEvent)paramSimpleBaseEvent).user != null) && (TextUtils.equals(((xze)this.jdField_a_of_type_Xyn.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).user.id.get()))) {
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
          if (TextUtils.equals(((xze)this.jdField_a_of_type_Xyn.a().get(i)).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), ((RecommendFeedbackEvent)paramSimpleBaseEvent).feed.id.get())) {}
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
    yej.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Xyn != null) && (this.jdField_a_of_type_Xyp != null))
    {
      if ((this.jdField_a_of_type_Xyn.a()) || (this.jdField_a_of_type_Xyn.b())) {
        break label101;
      }
      this.jdField_a_of_type_Xyp.a();
    }
    for (;;)
    {
      a();
      yvu.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_discover", "change_clk", 0, 0, new String[0]);
      return;
      label101:
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
  }
  
  public void setPresenter(xyp paramxyp)
  {
    this.jdField_a_of_type_Xyp = paramxyp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew
 * JD-Core Version:    0.7.0.1
 */