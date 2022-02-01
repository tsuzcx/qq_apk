package com.tencent.mobileqq.activity.aio.zhitu;

import afqz;
import aioi;
import aiot;
import aiou;
import aioz;
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
import anvx;
import aumk;
import avla;
import bdla;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "ZhituManager.PanelView";
  private static String jdField_b_of_type_JavaLangString = anvx.a(2131716390);
  private aiou jdField_a_of_type_Aiou;
  private aioz jdField_a_of_type_Aioz;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private avla jdField_a_of_type_Avla;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, avla paramavla, Button paramButton)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    setClipToPadding(false);
    this.jdField_b_of_type_Int = (ViewUtils.getScreenWidth() / 3);
    this.c = (this.jdField_b_of_type_Int - ViewUtils.dpToPx(2.0F));
    this.jdField_a_of_type_Avla = paramavla;
    a();
  }
  
  private View a()
  {
    aumk localaumk = aumk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp());
    jdField_b_of_type_JavaLangString = localaumk.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localaumk.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131381677);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localaumk.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.dp2px(8.0F, getResources()), 0, AIOUtils.dp2px(6.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131381675);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      i = aumk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp()).a();
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
    localLayoutParams.addRule(3, 2131381677);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Aiou = new aiou(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Aiou);
    if (localView != null) {
      this.jdField_a_of_type_Aiou.a(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.addOnScrollListener(new aiot(this));
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Avla);
  }
  
  public void a(boolean paramBoolean)
  {
    aioi localaioi = aioi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    if (paramBoolean)
    {
      localaioi.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localaioi.jdField_a_of_type_Aiou = this.jdField_a_of_type_Aiou;
      localaioi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType(), false);
      return;
    }
    localaioi.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localaioi.jdField_a_of_type_Aiou = null;
  }
  
  public void b()
  {
    aioz localaioz = this.jdField_a_of_type_Aioz;
    if ((localaioz == null) || (localaioz.jdField_a_of_type_JavaLangString == null) || (localaioz.jdField_a_of_type_Aipa == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localaioz), 8, null, false);
    aioi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(localaioz);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showInputPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */