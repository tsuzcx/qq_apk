package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.List;

public class VerticalStepView
  extends LinearLayout
  implements VerticalStepViewIndicator.a
{
  private RelativeLayout a;
  private VerticalStepViewIndicator b;
  private List<c> c;
  private int d;
  private int e = ContextCompat.getColor(getContext(), 2131168415);
  private int f = ContextCompat.getColor(getContext(), 17170443);
  private int g = 14;
  private TextView h;
  
  public VerticalStepView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131629673, this);
    this.b = ((VerticalStepViewIndicator)localView.findViewById(2131446384));
    this.b.setOnDrawListener(this);
    this.a = ((RelativeLayout)localView.findViewById(2131445036));
  }
  
  public VerticalStepView a(List<c> paramList)
  {
    this.c = paramList;
    this.b.setSteps(paramList);
    return this;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).removeAllViews();
      localObject = this.b.getCircleCenterPointPositionList();
      if ((this.c != null) && (localObject != null) && (((List)localObject).size() > 0))
      {
        int i = 0;
        while (i < this.c.size())
        {
          this.h = new TextView(getContext());
          this.h.setTextSize(2, this.g);
          this.h.setText(((c)this.c.get(i)).a());
          this.h.setY(((Float)((List)localObject).get(i)).floatValue() - this.b.getCircleRadius() / 2.0F);
          this.h.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          if (i <= this.d)
          {
            this.h.setTypeface(null, 1);
            this.h.setTextColor(this.f);
          }
          else
          {
            this.h.setTextColor(this.e);
          }
          this.a.addView(this.h);
          i += 1;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepView
 * JD-Core Version:    0.7.0.1
 */