package com.tencent.mobileqq.activity.aio.zhitu;

import aekt;
import aelz;
import agwq;
import agxb;
import agxc;
import agxh;
import alpo;
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
import arsh;
import azmj;
import bdkf;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "ZhituManager.PanelView";
  private static String jdField_b_of_type_JavaLangString = alpo.a(2131717418);
  private agxc jdField_a_of_type_Agxc;
  private agxh jdField_a_of_type_Agxh;
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
    this.jdField_b_of_type_Int = (bdkf.a() / 3);
    this.c = (this.jdField_b_of_type_Int - bdkf.b(2.0F));
    a();
  }
  
  private View a()
  {
    arsh localarsh = arsh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    jdField_b_of_type_JavaLangString = localarsh.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localarsh.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131380343);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localarsh.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, aekt.a(8.0F, getResources()), 0, aekt.a(6.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131380341);
    localTextView.setText(paramString);
    localTextView.setTextColor(Color.parseColor("#878B99"));
    localTextView.setTextSize(2, 14.0F);
    localTextView.setGravity(17);
    localTextView.setVisibility(8);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    return localTextView;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      i = arsh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).a();
    }
    return i;
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
    localLayoutParams.addRule(3, 2131380343);
    addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Agxc = new agxc(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agxc);
    if (localView != null) {
      this.jdField_a_of_type_Agxc.a(localView);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new agxb(this));
  }
  
  public void a(boolean paramBoolean)
  {
    agwq localagwq = agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      localagwq.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localagwq.jdField_a_of_type_Agxc = this.jdField_a_of_type_Agxc;
      localagwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aelz.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(), false);
      return;
    }
    localagwq.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localagwq.jdField_a_of_type_Agxc = null;
  }
  
  public void b()
  {
    agxh localagxh = this.jdField_a_of_type_Agxh;
    if ((localagxh == null) || (localagxh.jdField_a_of_type_JavaLangString == null) || (localagxh.jdField_a_of_type_Agxi == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localagxh), 8, null, false);
    agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localagxh);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */