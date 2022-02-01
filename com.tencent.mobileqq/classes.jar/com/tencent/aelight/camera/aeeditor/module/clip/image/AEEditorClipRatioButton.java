package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class AEEditorClipRatioButton
  extends FrameLayout
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private ImageView e;
  
  public AEEditorClipRatioButton(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorClipRatioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorClipRatioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2064056437, this);
    this.a = ((ImageView)paramContext.findViewById(2063990902));
    this.b = ((ImageView)paramContext.findViewById(2063991112));
    this.c = ((ImageView)paramContext.findViewById(2063990975));
    this.d = ((TextView)paramContext.findViewById(2063991478));
    this.e = ((ImageView)paramContext.findViewById(2063991290));
  }
  
  public void setBackImg(int paramInt)
  {
    this.a.setVisibility(0);
    this.a.setImageResource(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  public void setText(String paramString)
  {
    this.d.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipRatioButton
 * JD-Core Version:    0.7.0.1
 */