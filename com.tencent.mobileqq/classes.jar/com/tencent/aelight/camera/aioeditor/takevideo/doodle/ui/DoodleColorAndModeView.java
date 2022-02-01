package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class DoodleColorAndModeView
  extends FrameLayout
{
  private RecyclerView a;
  private DoodleColorAndModeView.ColorListAdapter b;
  private int c = 0;
  private Boolean d = Boolean.valueOf(false);
  private boolean e = false;
  private int f;
  private final List<Integer> g = new ArrayList();
  private boolean h;
  private int i;
  private boolean j = false;
  private DoodleColorAndModeView.IColorSelectListener k;
  
  public DoodleColorAndModeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DoodleColorAndModeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DoodleColorAndModeView);
      this.c = paramContext.getInt(2, 0);
      this.e = paramContext.getBoolean(0, false);
      this.d = Boolean.valueOf(paramContext.getBoolean(1, false));
      paramContext.recycle();
    }
    this.f = 0;
    if (this.e) {
      this.f += 1;
    }
    if (this.d.booleanValue()) {
      this.f += 1;
    }
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131624068, this);
    this.a = ((RecyclerView)findViewById(2131445202));
    this.a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.b = new DoodleColorAndModeView.ColorListAdapter(this, null);
    this.a.setAdapter(this.b);
    this.a.addItemDecoration(new DoodleColorAndModeView.1(this));
  }
  
  public void a(List<Integer> paramList, boolean paramBoolean, int paramInt)
  {
    this.h = paramBoolean;
    this.i = paramInt;
    this.g.clear();
    this.g.addAll(paramList);
    this.b.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.j == paramBoolean)
    {
      this.j = (paramBoolean ^ true);
      this.b.notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return this.h ^ true;
  }
  
  public void setColorSelectListener(DoodleColorAndModeView.IColorSelectListener paramIColorSelectListener)
  {
    this.k = paramIColorSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
 * JD-Core Version:    0.7.0.1
 */