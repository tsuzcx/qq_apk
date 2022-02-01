package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class AEEditorQcircleBubbleView
  extends RelativePopupWindow
  implements View.OnClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public AEEditorQcircleBubbleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a(2064318554);
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121907));
    this.c = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121911));
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121910));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121908));
    this.e = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121909));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121871));
    setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              this.b.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.c.setVisibility(8);
              this.d.setVisibility(8);
              this.e.setVisibility(8);
              return;
            }
            this.d.setVisibility(0);
            this.b.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            return;
          }
          this.e.setVisibility(0);
          this.b.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          return;
        }
        this.c.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void onClick(View paramView)
  {
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView
 * JD-Core Version:    0.7.0.1
 */