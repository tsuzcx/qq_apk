package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import ajhg;
import ajhh;
import ajhn;
import ajho;
import ajhp;
import ajhq;
import ajhr;
import ajhs;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import bduy;
import bhgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import nle;
import nlf;
import nlh;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  private ajhg jdField_a_of_type_Ajhg;
  private ajhh jdField_a_of_type_Ajhh;
  public ajho a;
  private ajhp jdField_a_of_type_Ajhp;
  private ajhq jdField_a_of_type_Ajhq;
  private ajhs jdField_a_of_type_Ajhs;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private nlf jdField_a_of_type_Nlf = new ajhn(this);
  
  public GroupSearchRecommendView(Context paramContext, ajho paramajho, ajhh paramajhh, ajhs paramajhs)
  {
    super(paramContext);
    this.jdField_a_of_type_Ajho = paramajho;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ajhh = paramajhh;
    this.jdField_a_of_type_Ajhs = paramajhs;
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
    if (bduy.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramBoolean) {
      return;
    }
    nlh localnlh = (nlh)this.jdField_a_of_type_Ajho.a().getManager(80);
    if ((localnlh.a() != null) && (localnlh.a().rpt_pop_items.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Ajhq.a();
      int i = 0;
      while (i < localnlh.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Ajhq.a(new ajhr(((popclassifc.HotWordItem)localnlh.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localnlh.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Ajhq.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajhp = new ajhp(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131370437));
    this.jdField_a_of_type_Ajhg = new ajhg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_Ajho.a().c());
    this.jdField_a_of_type_Ajhg.a(this.jdField_a_of_type_Ajhh);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850084);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Ajhg);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379897));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131366742));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370184));
    this.jdField_a_of_type_Ajhq = new ajhq(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ajhq.a(this.jdField_a_of_type_Ajhs);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Ajhq);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (bduy.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ajhp.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new nle(this.jdField_a_of_type_Ajho.a()).a(this.jdField_a_of_type_Nlf);
  }
  
  public void a()
  {
    a(2131561633);
    c();
    d();
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajhg != null) {
      this.jdField_a_of_type_Ajhg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */