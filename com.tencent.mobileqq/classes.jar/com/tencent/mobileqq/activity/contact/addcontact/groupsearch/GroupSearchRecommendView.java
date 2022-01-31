package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import afij;
import afik;
import afiq;
import afir;
import afis;
import afit;
import afiu;
import afiv;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import bawz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import mxz;
import mya;
import myc;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  private afij jdField_a_of_type_Afij;
  private afik jdField_a_of_type_Afik;
  public afir a;
  private afis jdField_a_of_type_Afis;
  private afit jdField_a_of_type_Afit;
  private afiv jdField_a_of_type_Afiv;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private mya jdField_a_of_type_Mya = new afiq(this);
  
  public GroupSearchRecommendView(Context paramContext, afir paramafir, afik paramafik, afiv paramafiv)
  {
    super(paramContext);
    this.jdField_a_of_type_Afir = paramafir;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Afik = paramafik;
    this.jdField_a_of_type_Afiv = paramafiv;
  }
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GroupSearchRecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    myc localmyc = (myc)this.jdField_a_of_type_Afir.a().getManager(80);
    if ((localmyc.a() != null) && (localmyc.a().rpt_pop_items.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Afit.a();
      int i = 0;
      while (i < localmyc.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Afit.a(new afiu(((popclassifc.HotWordItem)localmyc.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localmyc.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Afit.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Afis = new afis(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131369611));
    this.jdField_a_of_type_Afij = new afij(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_Afir.a().c());
    this.jdField_a_of_type_Afij.a(this.jdField_a_of_type_Afik);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849011);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, bawz.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Afij);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378216));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131366332));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369404));
    this.jdField_a_of_type_Afit = new afit(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Afit.a(this.jdField_a_of_type_Afiv);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Afit);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Afis.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new mxz(this.jdField_a_of_type_Afir.a()).a(this.jdField_a_of_type_Mya);
  }
  
  public void a()
  {
    a(2131561154);
    c();
    d();
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afij != null) {
      this.jdField_a_of_type_Afij.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */