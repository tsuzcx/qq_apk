package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import aiwo;
import aiwp;
import aiwv;
import aiww;
import aiwx;
import aiwy;
import aiwz;
import aixa;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdvn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ScrollView;
import ntt;
import ntu;
import ntw;
import tencent.im.troop_search_popclassifc.popclassifc.HotWordItem;
import tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard;

public class GroupSearchRecommendView
  extends ScrollView
{
  private aiwo jdField_a_of_type_Aiwo;
  private aiwp jdField_a_of_type_Aiwp;
  public aiww a;
  private aiwx jdField_a_of_type_Aiwx;
  private aiwy jdField_a_of_type_Aiwy;
  private aixa jdField_a_of_type_Aixa;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotRecommendGroupFlowLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout;
  private MeasureListView jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView;
  private ntu jdField_a_of_type_Ntu = new aiwv(this);
  
  public GroupSearchRecommendView(Context paramContext, aiww paramaiww, aiwp paramaiwp, aixa paramaixa)
  {
    super(paramContext);
    this.jdField_a_of_type_Aiww = paramaiww;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aiwp = paramaiwp;
    this.jdField_a_of_type_Aixa = paramaixa;
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
    if (bdvn.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    while (paramBoolean) {
      return;
    }
    ntw localntw = (ntw)this.jdField_a_of_type_Aiww.a().getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
    if ((localntw.a() != null) && (localntw.a().rpt_pop_items.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Aiwy.a();
      int i = 0;
      while (i < localntw.a().rpt_pop_items.size())
      {
        this.jdField_a_of_type_Aiwy.a(new aiwz(((popclassifc.HotWordItem)localntw.a().rpt_pop_items.get(i)).str_hot_word.get(), ((popclassifc.HotWordItem)localntw.a().rpt_pop_items.get(i)).str_text_color.get()));
        i += 1;
      }
      this.jdField_a_of_type_Aiwy.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Aiwx = new aiwx(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)findViewById(2131370588));
    this.jdField_a_of_type_Aiwo = new aiwo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView, this.jdField_a_of_type_Aiww.a().getCurrentUin());
    this.jdField_a_of_type_Aiwo.a(this.jdField_a_of_type_Aiwp);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850094);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setFastScrollEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(localLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Aiwo);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379983));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout = ((HotRecommendGroupFlowLayout)findViewById(2131366885));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370344));
    this.jdField_a_of_type_Aiwy = new aiwy(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Aiwy.a(this.jdField_a_of_type_Aixa);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setAdapter(this.jdField_a_of_type_Aiwy);
    a(false);
    setOverScrollMode(0);
    setVerticalScrollBarEnabled(false);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    if (bdvn.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchHotRecommendGroupFlowLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aiwx.sendEmptyMessage(1);
  }
  
  private void e()
  {
    new ntt(this.jdField_a_of_type_Aiww.a()).a(this.jdField_a_of_type_Ntu);
  }
  
  public void a()
  {
    a(2131561575);
    c();
    d();
  }
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aiwo != null) {
      this.jdField_a_of_type_Aiwo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView
 * JD-Core Version:    0.7.0.1
 */