package com.tencent.mobileqq.activity.aio.zhitu;

import aezn;
import ahtj;
import ahtu;
import ahtv;
import ahua;
import amtj;
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
import atid;
import aufg;
import bcef;
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
  private static String jdField_b_of_type_JavaLangString = amtj.a(2131716042);
  private ahtv jdField_a_of_type_Ahtv;
  private ahua jdField_a_of_type_Ahua;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aufg jdField_a_of_type_Aufg;
  public BaseChatPie a;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, aufg paramaufg, Button paramButton)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    setClipToPadding(false);
    this.jdField_b_of_type_Int = (ViewUtils.getScreenWidth() / 3);
    this.c = (this.jdField_b_of_type_Int - ViewUtils.dpToPx(2.0F));
    this.jdField_a_of_type_Aufg = paramaufg;
    a();
  }
  
  private View a()
  {
    atid localatid = atid.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp());
    jdField_b_of_type_JavaLangString = localatid.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localatid.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131381314);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localatid.b());
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
    localTextView.setId(2131381312);
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
      i = atid.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp()).a();
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
    localLayoutParams.addRule(3, 2131381314);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_Ahtv = new ahtv(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_Ahtv);
    if (localView != null) {
      this.jdField_a_of_type_Ahtv.a(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.addOnScrollListener(new ahtu(this));
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_Aufg);
  }
  
  public void a(boolean paramBoolean)
  {
    ahtj localahtj = ahtj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    if (paramBoolean)
    {
      localahtj.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localahtj.jdField_a_of_type_Ahtv = this.jdField_a_of_type_Ahtv;
      localahtj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType(), false);
      return;
    }
    localahtj.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localahtj.jdField_a_of_type_Ahtv = null;
  }
  
  public void b()
  {
    ahua localahua = this.jdField_a_of_type_Ahua;
    if ((localahua == null) || (localahua.jdField_a_of_type_JavaLangString == null) || (localahua.jdField_a_of_type_Ahub == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localahua), 8, null, false);
    ahtj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(localahua);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showInputPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */