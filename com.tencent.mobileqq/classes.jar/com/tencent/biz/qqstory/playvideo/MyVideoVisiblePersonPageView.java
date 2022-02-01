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
import anvk;
import anvx;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vzu;
import vzx;
import weg;
import wjs;
import wke;
import wzk;
import xag;
import xah;
import xai;
import xaj;
import xak;
import xal;
import xqc;
import yev;

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
  anvk jdField_a_of_type_Anvk;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  vzx jdField_a_of_type_Vzx = new xaj(this);
  xqc jdField_a_of_type_Xqc;
  protected yev a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Yev = new xak(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new xal(this));
    LayoutInflater.from(paramContext).inflate(2131561866, this, true);
    this.jdField_a_of_type_Anvk = ((anvk)wzk.a().getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = wzk.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Vzx);
    a();
    paramDialog = ((wke)wjs.a(2)).b(QQStoryContext.a().b());
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
    String str = anvx.a(2131706532);
    if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) {
      str = anvx.a(2131706534);
    }
    while (this.jdField_a_of_type_Int != 3) {
      return str;
    }
    return anvx.a(2131706533);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370180));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374560);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374646));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376618));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131381514));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376917);
    this.jdField_a_of_type_Xqc = new xqc(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Xqc.a(2131561865);
    this.jdField_a_of_type_Xqc.a(this.jdField_a_of_type_Yev);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xqc);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new xag(this));
    xah localxah = new xah(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(localxah);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(localxah);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(localxah);
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if ((this.jdField_a_of_type_Xqc != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.jdField_a_of_type_Anvk.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new xai(this));
      this.jdField_a_of_type_Xqc.a(paramList);
      this.jdField_a_of_type_Xqc.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vzx);
  }
  
  void c()
  {
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      d();
      ((vzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).b(this.jdField_a_of_type_JavaLangString);
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
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846909), null, null);
    this.c.setText(anvx.a(2131706531));
  }
  
  void g()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846907), null, null);
    this.c.setText(weg.a(2131699182));
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846911), null, null);
    this.c.setText(anvx.a(2131706535));
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