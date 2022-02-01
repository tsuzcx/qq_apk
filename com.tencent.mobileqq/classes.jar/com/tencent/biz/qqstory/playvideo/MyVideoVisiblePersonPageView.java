package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anyw;
import anzj;
import bhnv;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wja;
import wjd;
import wnu;
import wth;
import wtt;
import xiz;
import xka;
import xkb;
import xkc;
import xkd;
import xke;
import xkf;
import xzw;
import yop;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  public Dialog a;
  public Context a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anyw jdField_a_of_type_Anyw;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  wjd jdField_a_of_type_Wjd = new xkd(this);
  xzw jdField_a_of_type_Xzw;
  protected yop a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Yop = new xke(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new xkf(this));
    LayoutInflater.from(paramContext).inflate(2131561921, this, true);
    this.jdField_a_of_type_Anyw = ((anyw)xiz.a().getManager(51));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = xiz.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wjd);
    a();
    paramDialog = ((wtt)wth.a(2)).b(QQStoryContext.a().b());
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
    String str = anzj.a(2131705950);
    if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) {
      str = anzj.a(2131705952);
    }
    while (this.jdField_a_of_type_Int != 3) {
      return str;
    }
    return anzj.a(2131705951);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370012));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374554);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374640));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376597));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131381435));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376901);
    this.jdField_a_of_type_Xzw = new xzw(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Xzw.a(2131561920);
    this.jdField_a_of_type_Xzw.a(this.jdField_a_of_type_Yop);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xzw);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new xka(this));
    xkb localxkb = new xkb(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(localxkb);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(localxkb);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(localxkb);
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if ((this.jdField_a_of_type_Xzw != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.jdField_a_of_type_Anyw.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new xkc(this));
      this.jdField_a_of_type_Xzw.a(paramList);
      this.jdField_a_of_type_Xzw.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wjd);
  }
  
  void c()
  {
    if (bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      d();
      ((wja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).b(this.jdField_a_of_type_JavaLangString);
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
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846905), null, null);
    this.c.setText(anzj.a(2131705949));
  }
  
  void g()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846903), null, null);
    this.c.setText(wnu.a(2131698596));
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846907), null, null);
    this.c.setText(anzj.a(2131705953));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */