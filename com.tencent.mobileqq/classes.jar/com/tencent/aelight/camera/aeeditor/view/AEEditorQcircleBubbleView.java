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
  private LayoutInflater a;
  private View b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  
  public AEEditorQcircleBubbleView(Context paramContext)
  {
    super(paramContext);
    this.a = LayoutInflater.from(paramContext);
    a(2064056426);
    setOutsideTouchable(true);
    setFocusable(true);
    setTouchable(true);
  }
  
  public void a(int paramInt)
  {
    this.b = this.a.inflate(paramInt, null);
    this.c = ((ImageView)this.b.findViewById(2063990841));
    this.e = ((ImageView)this.b.findViewById(2063990845));
    this.d = ((ImageView)this.b.findViewById(2063990844));
    this.f = ((ImageView)this.b.findViewById(2063990842));
    this.g = ((ImageView)this.b.findViewById(2063990843));
    this.h = ((TextView)this.b.findViewById(2063990790));
    setBackgroundDrawable(new ColorDrawable(0));
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.b.setOnClickListener(this);
    super.setContentView(this.b);
  }
  
  public void a(String paramString)
  {
    this.h.setText(paramString);
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
              this.d.setVisibility(8);
              this.c.setVisibility(8);
              this.e.setVisibility(8);
              this.f.setVisibility(8);
              this.g.setVisibility(8);
              return;
            }
            this.f.setVisibility(0);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
            return;
          }
          this.g.setVisibility(0);
          this.d.setVisibility(8);
          this.c.setVisibility(8);
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          return;
        }
        this.e.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        return;
      }
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.h.setText(paramInt);
  }
  
  public void onClick(View paramView)
  {
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView
 * JD-Core Version:    0.7.0.1
 */