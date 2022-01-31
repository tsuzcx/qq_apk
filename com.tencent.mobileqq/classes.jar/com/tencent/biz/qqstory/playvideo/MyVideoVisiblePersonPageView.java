package com.tencent.biz.qqstory.playvideo;

import aloz;
import alpo;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdee;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import uhk;
import uhn;
import ume;
import urr;
import usd;
import vhj;
import vik;
import vil;
import vim;
import vin;
import vio;
import vip;
import vyh;
import wna;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  aloz jdField_a_of_type_Aloz;
  public Dialog a;
  public Context a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  uhn jdField_a_of_type_Uhn = new vin(this);
  vyh jdField_a_of_type_Vyh;
  protected wna a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Wna = new vio(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new vip(this));
    LayoutInflater.from(paramContext).inflate(2131561628, this, true);
    this.jdField_a_of_type_Aloz = ((aloz)vhj.a().getManager(51));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = vhj.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Uhn);
    a();
    paramDialog = ((usd)urr.a(2)).b(QQStoryContext.a().b());
    if ((paramDialog != null) && (paramDialog.isVip))
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_Int == 1000)
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      g();
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      f();
      return;
    }
    c();
  }
  
  public String a()
  {
    String str = alpo.a(2131707440);
    if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) {
      str = alpo.a(2131707442);
    }
    while (this.jdField_a_of_type_Int != 3) {
      return str;
    }
    return alpo.a(2131707441);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369501));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373663);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373750));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375687));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131380218));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375960);
    this.jdField_a_of_type_Vyh = new vyh(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Vyh.a(2131561627);
    this.jdField_a_of_type_Vyh.a(this.jdField_a_of_type_Wna);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Vyh);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new vik(this));
    vil localvil = new vil(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(localvil);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(localvil);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(localvil);
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if ((this.jdField_a_of_type_Vyh != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.jdField_a_of_type_Aloz.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new vim(this));
      this.jdField_a_of_type_Vyh.a(paramList);
      this.jdField_a_of_type_Vyh.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Uhn);
  }
  
  void c()
  {
    if (bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      d();
      ((uhk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    e();
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846377), null, null);
    this.c.setText(alpo.a(2131707439));
  }
  
  void g()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846375), null, null);
    this.c.setText(ume.a(2131700051));
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846379), null, null);
    this.c.setText(alpo.a(2131707443));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */