package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.together.ui.TogetherPopupDialog;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.AtPanelTouchListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.lang.reflect.Method;

public class DraggablePopup
  extends PopupWindow
  implements View.OnClickListener, AtPanelTouchController.AtPanelTouchListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Button b;
  
  private DraggablePopup(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static DraggablePopup a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    DraggablePopup localDraggablePopup = new DraggablePopup(LayoutInflater.from(paramActivity).inflate(2131561297, null), paramInt1, paramInt2);
    localDraggablePopup.a(localDraggablePopup, paramActivity);
    localDraggablePopup.setFocusable(true);
    localDraggablePopup.setInputMethodMode(1);
    localDraggablePopup.setSoftInputMode(16);
    localDraggablePopup.setClippingEnabled(false);
    localDraggablePopup.getContentView().setOnKeyListener(new DraggablePopup.1(localDraggablePopup));
    localDraggablePopup.setOutsideTouchable(true);
    if (AppSetting.d) {
      a(localDraggablePopup);
    }
    return localDraggablePopup;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("setTouchModal")) {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  private void a(DraggablePopup paramDraggablePopup, Activity paramActivity)
  {
    View localView = paramDraggablePopup.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131365169));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(true);
    int i = ViewUtils.b(24.0F);
    int j = TogetherPopupDialog.a(paramActivity);
    localView.findViewById(2131379076).setOnClickListener(this);
    localView.findViewById(2131369756).setBackgroundColor(localView.getResources().getColor(2131167028));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365190));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(paramDraggablePopup);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(2);
    paramDraggablePopup = localView.findViewById(2131364601);
    if (paramDraggablePopup != null)
    {
      paramDraggablePopup.setVisibility(0);
      paramDraggablePopup.setPadding(paramDraggablePopup.getPaddingLeft(), paramDraggablePopup.getPaddingTop(), paramDraggablePopup.getPaddingRight(), i + j);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362668));
    this.b = ((Button)localView.findViewById(2131372089));
  }
  
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public XListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public Button b()
  {
    return this.b;
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379076) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.browser.DraggablePopup
 * JD-Core Version:    0.7.0.1
 */