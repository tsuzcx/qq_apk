package com.tencent.aelight.camera.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class AEEditorToolBar
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String b = "AEEditorToolBar";
  protected AEEditorToolBar.ToolBarBaseListener a;
  private List<AECompoundButton> c = new ArrayList();
  
  public AEEditorToolBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    a();
  }
  
  abstract void a();
  
  protected void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AECompoundButton localAECompoundButton = new AECompoundButton(getContext());
    localAECompoundButton.setTag(paramString);
    localAECompoundButton.setOnClickListener(this);
    localAECompoundButton.setBackgroundResource(paramInt3);
    localAECompoundButton.setForegroundResource(paramInt2);
    localAECompoundButton.setForegroundSize(ViewUtils.dip2px(32.0F), ViewUtils.dip2px(32.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.width = ViewUtils.dip2px(56.0F);
    localLayoutParams.height = ViewUtils.dip2px(56.0F);
    if ((b(paramString)) && (!c(paramString))) {
      localAECompoundButton.addView(LayoutInflater.from(getContext()).inflate(2064056454, localAECompoundButton, false));
    }
    addView(localAECompoundButton, paramInt1, localLayoutParams);
    this.c.add(paramInt1, localAECompoundButton);
  }
  
  abstract void a(String paramString);
  
  protected boolean b(String paramString)
  {
    return false;
  }
  
  protected boolean c(String paramString)
  {
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ae_editor_tool_bar_red_dot_");
    localStringBuilder.append(paramString);
    return localAECameraPrefsUtil.b(localStringBuilder.toString(), false, 0);
  }
  
  public void onClick(View paramView)
  {
    a((String)paramView.getTag());
  }
  
  public void setToolBarListener(AEEditorToolBar.ToolBarBaseListener paramToolBarBaseListener)
  {
    this.a = paramToolBarBaseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.toolbar.AEEditorToolBar
 * JD-Core Version:    0.7.0.1
 */