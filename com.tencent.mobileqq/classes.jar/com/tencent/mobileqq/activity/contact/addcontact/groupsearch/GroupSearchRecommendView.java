package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import aewt;
import aewu;
import aexa;
import aexb;
import aexc;
import aexd;
import aexe;
import aexf;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import azvv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import mna;
import mnb;
import mnd;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  private aewt jdField_a_of_type_Aewt;
  private aewu jdField_a_of_type_Aewu;
  public aexb a;
  private aexc jdField_a_of_type_Aexc;
  private aexd jdField_a_of_type_Aexd;
  private aexf jdField_a_of_type_Aexf;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private mnb jdField_a_of_type_Mnb = new aexa(this);
  
  public GroupSearchRecommendView(Context paramContext, aexb paramaexb, aewu paramaewu, aexf paramaexf)
  {
    super(paramContext);
    this.jdField_a_of_type_Aexb = paramaexb;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aewu = paramaewu;
    this.jdField_a_of_type_Aexf = paramaexf;
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
    mnd localmnd = (mnd)this.jdField_a_of_type_Aexb.a().getManager(80);
    if ((localmnd.a() != null) && (localmnd.a().rpt_pop_items.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Aexd.a();
      int i = 0;
      while (i < localmnd.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Aexd.a(new aexe(((popclassifc.HotWordItem)localmnd.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localmnd.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Aexd.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Aexc = new aexc(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131303935));
    this.jdField_a_of_type_Aewt = new aewt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_Aexb.a().c());
    this.jdField_a_of_type_Aewt.a(this.jdField_a_of_type_Aewu);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848786);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, azvv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Aewt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312390));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131300724));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303734));
    this.jdField_a_of_type_Aexd = new aexd(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Aexd.a(this.jdField_a_of_type_Aexf);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Aexd);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aexc.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new mna(this.jdField_a_of_type_Aexb.a()).a(this.jdField_a_of_type_Mnb);
  }
  
  public void a()
  {
    a(2131495565);
    c();
    d();
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aewt != null) {
      this.jdField_a_of_type_Aewt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */