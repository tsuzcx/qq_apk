package com.tencent.mobileqq.activity.aio.zhitu;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.hiboom.RichTextPanelExtendHelper;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.hiboom.RichTextPanelView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.XEditTextEx;

public class ZhituPanelView
  extends RichTextPanelView
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "ZhituManager.PanelView";
  private static String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131716856);
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ZhituPanelView.ZhituPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter;
  private ZhituPicData jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData;
  private RichTextPanelExtendHelper jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper;
  RichTextPanelRecyclerView jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper, Button paramButton)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidWidgetButton = paramButton;
    setClipToPadding(false);
    this.jdField_b_of_type_Int = (ViewUtils.a() / 3);
    this.c = (this.jdField_b_of_type_Int - ViewUtils.b(2.0F));
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper = paramRichTextPanelExtendHelper;
    a();
  }
  
  private View a()
  {
    RichTextChatManager localRichTextChatManager = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    jdField_b_of_type_JavaLangString = localRichTextChatManager.a();
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    if (localRichTextChatManager.b())
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131382142);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localRichTextChatManager.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(8.0F, getResources()), 0, AIOUtils.a(6.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    localLinearLayout.addView(a(""), new LinearLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setId(2131382140);
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
      i = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).a();
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
    localLayoutParams.addRule(3, 2131382142);
    addView(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter = new ZhituPanelView.ZhituPanelAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter);
    if (localView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter.a(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.addOnScrollListener(new ZhituPanelView.ZhituOnScrollListener(this));
    this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelRecyclerView.setPanelExtendHelper(this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanelExtendHelper);
  }
  
  public void a(boolean paramBoolean)
  {
    ZhituManager localZhituManager = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = this;
      localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter;
      localZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), false);
      return;
    }
    localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter = null;
  }
  
  public void b()
  {
    ZhituPicData localZhituPicData = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData;
    if ((localZhituPicData == null) || (localZhituPicData.jdField_a_of_type_JavaLangString == null) || (localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData == null)) {
      return;
    }
    ThreadManager.post(new ZhituPanelView.1(this, localZhituPicData), 8, null, false);
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localZhituPicData);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D5", "0X80094D5", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ax();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ZhituManager localZhituManager = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
    localZhituManager.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView
 * JD-Core Version:    0.7.0.1
 */