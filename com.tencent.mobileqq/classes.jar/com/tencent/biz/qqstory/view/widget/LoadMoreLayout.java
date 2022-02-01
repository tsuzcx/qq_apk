package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;

public class LoadMoreLayout
  extends FrameLayout
  implements ILoadMoreLayout
{
  protected Context a;
  protected LinearLayout b;
  protected ProgressBar c;
  protected TextView d;
  protected int e = -1;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  
  public LoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
    b();
  }
  
  public LoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
    b();
  }
  
  private void a()
  {
    this.f = HardCodeUtil.a(2131904193);
    this.h = HardCodeUtil.a(2131904195);
    this.i = HardCodeUtil.a(2131904192);
    this.g = StoryApi.b(2131897968);
    this.j = HardCodeUtil.a(2131904194);
  }
  
  private boolean a(int paramInt)
  {
    if (!a(this.e, paramInt)) {
      return false;
    }
    this.e = paramInt;
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
              if (paramInt != 5) {
                return true;
              }
              this.c.setVisibility(8);
              this.d.setText(this.j);
              this.b.setVisibility(0);
              return true;
            }
            this.b.setVisibility(8);
            return true;
          }
          this.c.setVisibility(8);
          this.d.setText(this.f);
          this.b.setVisibility(0);
          return true;
        }
        this.c.setVisibility(0);
        this.d.setText(this.h);
        this.b.setVisibility(0);
        return true;
      }
      this.c.setVisibility(0);
      this.d.setText(this.g);
      this.b.setVisibility(0);
      return true;
    }
    this.b.setVisibility(8);
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if ((paramInt1 == 5) && ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3))) {
                return true;
              }
            }
            else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3)) {
              return true;
            }
          }
          else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4) || (paramInt2 == 5)) {
            return true;
          }
        }
        else if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) {
          return true;
        }
      }
      else
      {
        if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
          break label145;
        }
        if (paramInt2 == 5) {
          return true;
        }
      }
      return false;
    }
    label145:
    return true;
  }
  
  private void b()
  {
    this.b = ((LinearLayout)LayoutInflater.from(this.a).inflate(2131628219, null));
    this.c = ((ProgressBar)this.b.findViewById(2131440737));
    this.d = ((TextView)this.b.findViewById(2131447062));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    super.addView(this.b, localLayoutParams);
    a(0);
  }
  
  public boolean checkState(int paramInt)
  {
    return a(this.e, paramInt);
  }
  
  public int getState()
  {
    return this.e;
  }
  
  public boolean setState(int paramInt)
  {
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */