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

public class aqgx
  extends PopupWindow
  implements View.OnClickListener, bfzx
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Button b;
  
  private aqgx(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
  }
  
  public static aqgx a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    aqgx localaqgx = new aqgx(LayoutInflater.from(paramActivity).inflate(2131561348, null), paramInt1, paramInt2);
    localaqgx.a(localaqgx, paramActivity);
    localaqgx.setFocusable(true);
    localaqgx.setInputMethodMode(1);
    localaqgx.setSoftInputMode(16);
    localaqgx.setClippingEnabled(false);
    localaqgx.getContentView().setOnKeyListener(new aqgy(localaqgx));
    localaqgx.setOutsideTouchable(true);
    if (AppSetting.c) {
      a(localaqgx);
    }
    return localaqgx;
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
  
  private void a(aqgx paramaqgx, Activity paramActivity)
  {
    View localView = paramaqgx.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(true);
    int i = ViewUtils.dpToPx(24.0F);
    int j = bemy.a(paramActivity);
    localView.findViewById(2131379315).setOnClickListener(this);
    localView.findViewById(2131369809).setBackgroundColor(localView.getResources().getColor(2131166998));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365177));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(paramaqgx);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(2);
    paramaqgx = localView.findViewById(2131364600);
    if (paramaqgx != null)
    {
      paramaqgx.setVisibility(0);
      paramaqgx.setPadding(paramaqgx.getPaddingLeft(), paramaqgx.getPaddingTop(), paramaqgx.getPaddingRight(), j + i);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131362686));
    this.b = ((Button)localView.findViewById(2131372203));
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
    if (paramView.getId() == 2131379315) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgx
 * JD-Core Version:    0.7.0.1
 */