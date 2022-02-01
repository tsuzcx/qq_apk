import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.lang.reflect.Method;

public class apdt
  extends PopupWindow
  implements View.OnClickListener, besr
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Button b;
  
  private apdt(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static apdt a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    apdt localapdt = new apdt(LayoutInflater.from(paramActivity).inflate(2131561287, null), paramInt1, paramInt2);
    localapdt.a(localapdt, paramActivity);
    localapdt.setFocusable(true);
    localapdt.setInputMethodMode(1);
    localapdt.setSoftInputMode(16);
    localapdt.setClippingEnabled(false);
    localapdt.getContentView().setOnKeyListener(new apdu(localapdt));
    localapdt.setOutsideTouchable(true);
    if (AppSetting.c) {
      a(localapdt);
    }
    return localapdt;
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
  
  private void a(apdt paramapdt, Activity paramActivity)
  {
    View localView = paramapdt.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131365073));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(true);
    int i = ViewUtils.dpToPx(24.0F);
    int j = bdfv.a(paramActivity);
    localView.findViewById(2131379019).setOnClickListener(this);
    localView.findViewById(2131369640).setBackgroundColor(localView.getResources().getColor(2131166984));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365093));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(paramapdt);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(2);
    paramapdt = localView.findViewById(2131364518);
    if (paramapdt != null)
    {
      paramapdt.setVisibility(0);
      paramapdt.setPadding(paramapdt.getPaddingLeft(), paramapdt.getPaddingTop(), paramapdt.getPaddingRight(), j + i);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362671));
    this.b = ((Button)localView.findViewById(2131372011));
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
    if (paramView.getId() == 2131379019) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdt
 * JD-Core Version:    0.7.0.1
 */