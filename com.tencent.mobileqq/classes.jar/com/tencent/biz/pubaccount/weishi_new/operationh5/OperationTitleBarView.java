package com.tencent.biz.pubaccount.weishi_new.operationh5;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;

public class OperationTitleBarView
  extends FrameLayout
{
  private RelativeLayout a;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private ImageView e;
  private boolean f;
  
  public OperationTitleBarView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OperationTitleBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(1929773085, this, false));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, Utils.a(getTotalHeight(), getResources()));
    addView(this.a, localLayoutParams);
    b();
  }
  
  private void b()
  {
    this.b = ((ImageView)this.a.findViewById(1929707559));
    this.c = ((ImageView)this.a.findViewById(1929707561));
    this.d = ((TextView)this.a.findViewById(1929707562));
    this.e = ((ImageView)this.a.findViewById(1929707560));
  }
  
  private float getTotalHeight()
  {
    float f2 = Utils.a(ViewUtils.getStatusBarHeight(getContext()), getResources());
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 25.0F;
    }
    return f1 + 48.0F;
  }
  
  public void a(int paramInt)
  {
    float f1 = Utils.a(100.0F, getResources());
    float f2 = paramInt;
    if (f2 < f1)
    {
      this.b.setAlpha(f2 / f1);
      if (!this.f) {
        return;
      }
      this.c.setImageResource(1929641993);
      this.d.setTextColor(getResources().getColor(1929510918));
      this.e.setImageResource(1929641984);
      this.f = false;
      return;
    }
    if (this.f) {
      return;
    }
    this.b.setAlpha(1.0F);
    this.c.setImageResource(1929641994);
    this.d.setTextColor(getResources().getColor(1929510912));
    this.e.setImageResource(1929641985);
    this.f = true;
  }
  
  public void setOperationTitleClickListener(OperationTitleBarView.OperationTitleClickListener paramOperationTitleClickListener)
  {
    this.c.setOnClickListener(new OperationTitleBarView.1(this, paramOperationTitleClickListener));
    this.d.setOnClickListener(new OperationTitleBarView.2(this, paramOperationTitleClickListener));
    this.e.setOnClickListener(new OperationTitleBarView.3(this, paramOperationTitleClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.OperationTitleBarView
 * JD-Core Version:    0.7.0.1
 */