package com.tencent.aelight.camera.aeeditor.module.topbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.mobileqq.app.HardCodeUtil;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  private AEEditorTopBar.TopBarClickListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public AEEditorTopBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    paramContext = View.inflate(paramContext, 2064318586, this);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton = ((AECompoundButton)paramContext.findViewById(2064121892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2064121893));
    this.b = ((TextView)paramContext.findViewById(2064121896));
    this.c = ((TextView)paramContext.findViewById(2064121894));
    this.d = ((TextView)paramContext.findViewById(2064121895));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void a()
  {
    setTitle(getResources().getString(2064515159));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void b()
  {
    setTitle(getResources().getString(2064515153));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(4);
    this.c.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2064121894: 
    case 2064121895: 
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener;
      if (paramView != null)
      {
        paramView.u();
        return;
      }
      break;
    case 2064121892: 
    case 2064121893: 
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener;
      if (paramView != null) {
        paramView.t();
      }
      break;
    }
  }
  
  public void setLeftButtonAsBackArray()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(0);
    this.d.setVisibility(4);
    this.c.setText(HardCodeUtil.a(2064515175));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setForegroundResource(2130844116);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setVisibility(4);
    this.b.setText(2064515197);
    this.d.setVisibility(0);
    this.d.setText(HardCodeUtil.a(2064515156));
  }
  
  public void setTitle(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTopBarClickListener(AEEditorTopBar.TopBarClickListener paramTopBarClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar$TopBarClickListener = paramTopBarClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */