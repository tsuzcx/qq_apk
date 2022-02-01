import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.lang.reflect.Method;

public class aqki
  extends PopupWindow
  implements View.OnClickListener, bgjj
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Button b;
  
  private aqki(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static aqki a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    aqki localaqki = new aqki(LayoutInflater.from(paramActivity).inflate(2131561411, null), paramInt1, paramInt2);
    localaqki.a(localaqki, paramActivity);
    localaqki.setFocusable(true);
    localaqki.setInputMethodMode(1);
    localaqki.setSoftInputMode(16);
    localaqki.setClippingEnabled(false);
    localaqki.getContentView().setOnKeyListener(new aqkj(localaqki));
    localaqki.setOutsideTouchable(true);
    if (AppSetting.c) {
      a(localaqki);
    }
    return localaqki;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setTouchModal")) {}
      }
      else
      {
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
  
  private void a(aqki paramaqki, Activity paramActivity)
  {
    View localView = paramaqki.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131365046));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(true);
    int i = bhtq.b(24.0F);
    int j = beme.a(paramActivity);
    localView.findViewById(2131379249).setOnClickListener(this);
    localView.findViewById(2131369649).setBackgroundColor(localView.getResources().getColor(2131166964));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365066));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(paramaqki);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(2);
    paramaqki = localView.findViewById(2131364499);
    if (paramaqki != null)
    {
      paramaqki.setVisibility(0);
      paramaqki.setPadding(paramaqki.getPaddingLeft(), paramaqki.getPaddingTop(), paramaqki.getPaddingRight(), j + i);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362667));
    this.b = ((Button)localView.findViewById(2131372046));
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
    if (paramView.getId() == 2131379249) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqki
 * JD-Core Version:    0.7.0.1
 */