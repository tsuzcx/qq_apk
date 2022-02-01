package com.tencent.mobileqq.activity.aio.zhitu;

import agej;
import aggs;
import aiyz;
import aizk;
import aizl;
import aizq;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import auvv;
import avse;
import bdll;
import bhtq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "ZhituManager.PanelView";
  private static String jdField_b_of_type_JavaLangString = anzj.a(2131715808);
  private aizl jdField_a_of_type_Aizl;
  private aizq jdField_a_of_type_Aizq;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private avse jdField_a_of_type_Avse;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, avse paramavse, Button paramButton)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    setClipToPadding(false);
    this.jdField_b_of_type_Int = (bhtq.a() / 3);
    this.c = (this.jdField_b_of_type_Int - bhtq.b(2.0F));
    this.jdField_a_of_type_Avse = paramavse;
    a();
  }
  
  private View a()
  {
    auvv localauvv = auvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    jdField_b_of_type_JavaLangString = localauvv.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localauvv.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131381597);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localauvv.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, agej.a(8.0F, getResources()), 0, agej.a(6.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131381595);
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
      i = auvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).a();
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
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView = new RichTextPanelRecyclerView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setOverScrollMode(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131381597);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Aizl = new aizl(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Aizl);
    if (localView != null) {
      this.jdField_a_of_type_Aizl.a(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.addOnScrollListener(new aizk(this));
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avse);
  }
  
  public void a(boolean paramBoolean)
  {
    aiyz localaiyz = aiyz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      localaiyz.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localaiyz.jdField_a_of_type_Aizl = this.jdField_a_of_type_Aizl;
      localaiyz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aggs.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(), false);
      return;
    }
    localaiyz.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localaiyz.jdField_a_of_type_Aizl = null;
  }
  
  public void b()
  {
    aizq localaizq = this.jdField_a_of_type_Aizq;
    if ((localaizq == null) || (localaizq.jdField_a_of_type_JavaLangString == null) || (localaizq.jdField_a_of_type_Aizr == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localaizq), 8, null, false);
    aiyz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localaizq);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */