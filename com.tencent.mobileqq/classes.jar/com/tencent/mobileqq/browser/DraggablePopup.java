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
  private AtPanelTouchController a;
  private XListView b;
  private Button c;
  private Button d;
  
  private DraggablePopup(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static DraggablePopup a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    DraggablePopup localDraggablePopup = new DraggablePopup(LayoutInflater.from(paramActivity).inflate(2131627653, null), paramInt1, paramInt2);
    localDraggablePopup.a(localDraggablePopup, paramActivity);
    localDraggablePopup.setFocusable(true);
    localDraggablePopup.setInputMethodMode(1);
    localDraggablePopup.setSoftInputMode(16);
    localDraggablePopup.setClippingEnabled(false);
    localDraggablePopup.getContentView().setOnKeyListener(new DraggablePopup.1(localDraggablePopup));
    localDraggablePopup.setOutsideTouchable(true);
    if (AppSetting.e) {
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
    this.a = ((AtPanelTouchController)localView.findViewById(2131431322));
    this.a.setDisableMinScrollY(true);
    this.a.setControlLitTongue(true);
    int i = ViewUtils.dpToPx(24.0F);
    int j = TogetherPopupDialog.a(paramActivity);
    localView.findViewById(2131447803).setOnClickListener(this);
    localView.findViewById(2131436882).setBackgroundColor(localView.getResources().getColor(2131167964));
    this.b = ((XListView)localView.findViewById(2131431352));
    this.b.setOverScrollMode(2);
    this.a.setAtPanelTouchListener(paramDraggablePopup);
    this.a.setMode(2);
    paramDraggablePopup = localView.findViewById(2131430671);
    if (paramDraggablePopup != null)
    {
      paramDraggablePopup.setVisibility(0);
      paramDraggablePopup.setPadding(paramDraggablePopup.getPaddingLeft(), paramDraggablePopup.getPaddingTop(), paramDraggablePopup.getPaddingRight(), i + j);
    }
    this.c = ((Button)localView.findViewById(2131428293));
    this.d = ((Button)localView.findViewById(2131439555));
  }
  
  public XListView a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public Button b()
  {
    return this.c;
  }
  
  public Button c()
  {
    return this.d;
  }
  
  public void d() {}
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131447803) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.browser.DraggablePopup
 * JD-Core Version:    0.7.0.1
 */