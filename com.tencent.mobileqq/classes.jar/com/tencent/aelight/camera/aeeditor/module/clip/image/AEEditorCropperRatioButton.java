package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class AEEditorCropperRatioButton
  extends FrameLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public AEEditorCropperRatioButton(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorCropperRatioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorCropperRatioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2064318565, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2064121972));
    this.b = ((ImageView)paramContext.findViewById(2064122230));
    this.c = ((ImageView)paramContext.findViewById(2064122056));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2064122683));
    this.d = ((ImageView)paramContext.findViewById(2064122464));
  }
  
  public void setBackImg(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorCropperRatioButton
 * JD-Core Version:    0.7.0.1
 */