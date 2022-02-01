package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

public class AEHorizontalSelectColorLayout
  extends FrameLayout
{
  private RecyclerView a;
  private AEHorizontalSelectColorLayout.ColorListAdapter b;
  private Boolean c;
  
  public AEHorizontalSelectColorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEHorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131624068, this);
    this.a = ((RecyclerView)findViewById(2131445202));
    this.a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.b = new AEHorizontalSelectColorLayout.ColorListAdapter(null);
    this.a.setAdapter(this.b);
  }
  
  public void a(List<Integer> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.b == null)
    {
      AEQLog.d("AEHorizontalSelectColorLayout", "color adapter null.");
      return;
    }
    this.c = Boolean.valueOf(paramBoolean);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.b, paramBoolean);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.b, paramInt);
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.b, paramList);
    this.b.notifyDataSetChanged();
  }
  
  public void setColorSelectListener(AEHorizontalSelectColorLayout.IColorSelectListener paramIColorSelectListener)
  {
    AEHorizontalSelectColorLayout.ColorListAdapter localColorListAdapter = this.b;
    if (localColorListAdapter != null) {
      AEHorizontalSelectColorLayout.ColorListAdapter.a(localColorListAdapter, paramIColorSelectListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */