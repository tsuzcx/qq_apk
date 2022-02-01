package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  HorizontalListView a;
  HorizontalSelectColorLayout.SelectColorAdapter b;
  ImageView c;
  ArrayList<HorizontalStroke> d = new ArrayList();
  int e;
  boolean f;
  boolean g = false;
  HorizontalSelectColorLayout.OnStrokeSelectedListener h;
  HorizontalSelectColorLayout.OnUndoViewClickListener i;
  private long j = 0L;
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131628063, this);
    this.a = ((HorizontalListView)super.findViewById(2131430938));
    this.a.setStayDisplayOffsetZero(true);
    this.a.setOverScrollMode(2);
    this.a.setOnItemClickListener(new HorizontalSelectColorLayout.1(this));
    this.a.setOnItemSelectedListener(new HorizontalSelectColorLayout.2(this));
    this.b = new HorizontalSelectColorLayout.SelectColorAdapter(this, getContext());
    this.a.setAdapter(this.b);
    this.c = ((ImageView)super.findViewById(2131449078));
    this.c.setOnClickListener(new HorizontalSelectColorLayout.3(this));
    this.f = false;
    this.c.setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    if (this.j > System.currentTimeMillis()) {
      return;
    }
    this.b.a(paramInt);
    this.e = paramInt;
    HorizontalSelectColorLayout.OnStrokeSelectedListener localOnStrokeSelectedListener = this.h;
    if (localOnStrokeSelectedListener != null) {
      localOnStrokeSelectedListener.a(getCurrentStroke());
    }
  }
  
  public HorizontalStroke getCurrentStroke()
  {
    return (HorizontalStroke)this.d.get(this.e);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void setEditDialogMode(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnStrokeSelectedListener(HorizontalSelectColorLayout.OnStrokeSelectedListener paramOnStrokeSelectedListener)
  {
    this.h = paramOnStrokeSelectedListener;
  }
  
  public void setOnUndoViewClickListener(HorizontalSelectColorLayout.OnUndoViewClickListener paramOnUndoViewClickListener)
  {
    this.i = paramOnUndoViewClickListener;
  }
  
  public void setSelectedStroke(int paramInt1, int paramInt2)
  {
    if (!this.d.isEmpty())
    {
      int k = 0;
      while (k < this.d.size())
      {
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.d.get(k);
        if ((localHorizontalStroke.c == paramInt1) && (localHorizontalStroke.d == paramInt2))
        {
          a(k);
          if (k <= 5) {
            break;
          }
          this.a.smoothScrollToPosition(k);
          return;
        }
        k += 1;
      }
    }
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    if (!this.d.isEmpty())
    {
      int k = 0;
      while (k < this.d.size())
      {
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.d.get(k);
        if ((localHorizontalStroke.c == 0) && (localHorizontalStroke.d == paramInt))
        {
          a(k);
          return;
        }
        k += 1;
      }
    }
  }
  
  public void setStrokeStrategy(StrokeStrategy paramStrokeStrategy, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.c;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject).setVisibility(k);
    localObject = super.findViewById(2131449079);
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    ((View)localObject).setVisibility(k);
    localObject = super.findViewById(2131447733);
    View localView = super.findViewById(2131429675);
    if (paramInt == 1)
    {
      ((View)localObject).setVisibility(0);
    }
    else if (paramInt == 2)
    {
      localView.setVisibility(0);
    }
    else if (paramInt == 3)
    {
      ((View)localObject).setVisibility(0);
      localView.setVisibility(0);
    }
    if (paramStrokeStrategy != null)
    {
      this.d.clear();
      paramStrokeStrategy.a(this.d, getContext());
      paramStrokeStrategy = this.b;
      if (paramStrokeStrategy != null) {
        paramStrokeStrategy.a(this.d);
      }
    }
    else
    {
      setVisibility(8);
    }
  }
  
  public void setUndoViewEnable(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      this.c.setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */