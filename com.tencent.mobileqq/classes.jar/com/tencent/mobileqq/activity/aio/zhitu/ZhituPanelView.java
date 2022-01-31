package com.tencent.mobileqq.activity.aio.zhitu;

import actj;
import acup;
import aezl;
import aezw;
import aezx;
import afac;
import ajya;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apzf;
import axqy;
import bbll;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "ZhituManager.PanelView";
  private static String jdField_b_of_type_JavaLangString = ajya.a(2131717046);
  private aezx jdField_a_of_type_Aezx;
  private afac jdField_a_of_type_Afac;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, Button paramButton)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    setClipToPadding(false);
    this.jdField_b_of_type_Int = (bbll.a() / 3);
    this.c = (this.jdField_b_of_type_Int - bbll.b(2.0F));
    a();
  }
  
  private View a()
  {
    apzf localapzf = apzf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    jdField_b_of_type_JavaLangString = localapzf.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localapzf.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131379599);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localapzf.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, actj.a(8.0F, getResources()), 0, actj.a(6.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131379597);
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.parseColor("#878B99"));
    localTextView.setTextSize(2, 14.0F);
    localTextView.setGravity(17);
    localTextView.setVisibility(8);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    return localTextView;
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    View localView = a();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131379599);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Aezx = new aezx(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aezx);
    if (localView != null) {
      this.jdField_a_of_type_Aezx.a(localView);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new aezw(this));
  }
  
  public void a(boolean paramBoolean)
  {
    aezl localaezl = aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      localaezl.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localaezl.jdField_a_of_type_Aezx = this.jdField_a_of_type_Aezx;
      localaezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acup.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(), false);
      return;
    }
    localaezl.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localaezl.jdField_a_of_type_Aezx = null;
  }
  
  public void b()
  {
    afac localafac = this.jdField_a_of_type_Afac;
    if ((localafac == null) || (localafac.jdField_a_of_type_JavaLangString == null) || (localafac.jdField_a_of_type_Afad == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localafac), 8, null, false);
    aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localafac);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */