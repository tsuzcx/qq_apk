package com.tencent.biz.qqstory.playvideo;

import ajxl;
import ajya;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbfj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sss;
import ssv;
import sxm;
import tcz;
import tdl;
import tsr;
import tts;
import ttt;
import ttu;
import ttv;
import ttw;
import ttx;
import ujp;
import uyi;

public class MyVideoVisiblePersonPageView
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  ajxl jdField_a_of_type_Ajxl;
  public Dialog a;
  public Context a;
  public GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  ssv jdField_a_of_type_Ssv = new ttv(this);
  ujp jdField_a_of_type_Ujp;
  protected uyi a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public MyVideoVisiblePersonPageView(Dialog paramDialog, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Uyi = new ttw(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new ttx(this));
    LayoutInflater.from(paramContext).inflate(2131561438, this, true);
    this.jdField_a_of_type_Ajxl = ((ajxl)tsr.a().getManager(51));
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = tsr.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ssv);
    a();
    paramDialog = ((tdl)tcz.a(2)).b(QQStoryContext.a().b());
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
    String str = ajya.a(2131707068);
    if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) {
      str = ajya.a(2131707070);
    }
    while (this.jdField_a_of_type_Int != 3) {
      return str;
    }
    return ajya.a(2131707069);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369266));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373214);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373301));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375205));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131379499));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375472);
    this.jdField_a_of_type_Ujp = new ujp(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Ujp.a(2131561437);
    this.jdField_a_of_type_Ujp.a(this.jdField_a_of_type_Uyi);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ujp);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new tts(this));
    ttt localttt = new ttt(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(localttt);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(localttt);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(localttt);
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if ((this.jdField_a_of_type_Ujp != null) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
        Friends localFriends = this.jdField_a_of_type_Ajxl.e(String.valueOf(localQQUserUIItem.qq));
        if (localFriends != null)
        {
          localQQUserUIItem.mComparePartInt = localFriends.mComparePartInt;
          localQQUserUIItem.mCompareSpell = localFriends.mCompareSpell;
        }
      }
      Collections.sort(paramList, new ttu(this));
      this.jdField_a_of_type_Ujp.a(paramList);
      this.jdField_a_of_type_Ujp.notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssv);
  }
  
  void c()
  {
    if (bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      d();
      ((sss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).b(this.jdField_a_of_type_JavaLangString);
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
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130845998), null, null);
    this.c.setText(ajya.a(2131707067));
  }
  
  void g()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130845996), null, null);
    this.c.setText(sxm.a(2131699683));
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.c.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130846000), null, null);
    this.c.setText(ajya.a(2131707071));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView
 * JD-Core Version:    0.7.0.1
 */