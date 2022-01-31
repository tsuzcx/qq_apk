package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import afih;
import afii;
import afio;
import afip;
import afiq;
import afir;
import afis;
import afit;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import baxn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import mxw;
import mxx;
import mxz;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  private afih jdField_a_of_type_Afih;
  private afii jdField_a_of_type_Afii;
  public afip a;
  private afiq jdField_a_of_type_Afiq;
  private afir jdField_a_of_type_Afir;
  private afit jdField_a_of_type_Afit;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private mxx jdField_a_of_type_Mxx = new afio(this);
  
  public GroupSearchRecommendView(Context paramContext, afip paramafip, afii paramafii, afit paramafit)
  {
    super(paramContext);
    this.jdField_a_of_type_Afip = paramafip;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Afii = paramafii;
    this.jdField_a_of_type_Afit = paramafit;
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
    mxz localmxz = (mxz)this.jdField_a_of_type_Afip.a().getManager(80);
    if ((localmxz.a() != null) && (localmxz.a().rpt_pop_items.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Afir.a();
      int i = 0;
      while (i < localmxz.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Afir.a(new afis(((popclassifc.HotWordItem)localmxz.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localmxz.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Afir.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Afiq = new afiq(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131369610));
    this.jdField_a_of_type_Afih = new afih(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_Afip.a().c());
    this.jdField_a_of_type_Afih.a(this.jdField_a_of_type_Afii);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849017);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, baxn.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Afih);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378219));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131366332));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369403));
    this.jdField_a_of_type_Afir = new afir(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Afir.a(this.jdField_a_of_type_Afit);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Afir);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Afiq.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new mxw(this.jdField_a_of_type_Afip.a()).a(this.jdField_a_of_type_Mxx);
  }
  
  public void a()
  {
    a(2131561153);
    c();
    d();
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afih != null) {
      this.jdField_a_of_type_Afih.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */