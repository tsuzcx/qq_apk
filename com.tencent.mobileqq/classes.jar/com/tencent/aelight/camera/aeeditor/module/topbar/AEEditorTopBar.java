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
  private AECompoundButton a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private AEEditorTopBar.TopBarClickListener f;
  private boolean g = false;
  
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
    this.g = AEThemeUtil.b();
    paramContext = View.inflate(paramContext, 2064056458, this);
    this.a = ((AECompoundButton)paramContext.findViewById(2063990819));
    this.b = ((TextView)paramContext.findViewById(2063990820));
    this.c = ((TextView)paramContext.findViewById(2063990823));
    this.d = ((TextView)paramContext.findViewById(2063990821));
    this.e = ((TextView)paramContext.findViewById(2063990822));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void a()
  {
    setTitle(getResources().getString(2064187501));
    this.a.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void b()
  {
    setTitle(getResources().getString(2064187495));
    this.a.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  public void c()
  {
    this.a.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  public void d()
  {
    this.a.setVisibility(4);
    this.d.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2063990821: 
    case 2063990822: 
      paramView = this.f;
      if (paramView != null)
      {
        paramView.F();
        return;
      }
      break;
    case 2063990819: 
    case 2063990820: 
      paramView = this.f;
      if (paramView != null) {
        paramView.E();
      }
      break;
    }
  }
  
  public void setLeftButtonAsBackArray()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(4);
    this.d.setVisibility(0);
    this.e.setVisibility(4);
    this.d.setText(HardCodeUtil.a(2064187517));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.a.setVisibility(0);
    this.a.setForegroundResource(2130845157);
    this.b.setVisibility(4);
    this.d.setVisibility(4);
    this.c.setText(2064187543);
    this.e.setVisibility(0);
    this.e.setText(HardCodeUtil.a(2064187498));
  }
  
  public void setTitle(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void setTopBarClickListener(AEEditorTopBar.TopBarClickListener paramTopBarClickListener)
  {
    this.f = paramTopBarClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */