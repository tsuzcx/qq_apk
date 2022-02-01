package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

public class WatermarkListView
  extends ScrollView
{
  private LinearLayout a;
  private RecyclerView.Adapter<RecyclerView.ViewHolder> b;
  private List<RecyclerView.ViewHolder> c;
  
  public WatermarkListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WatermarkListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    this.a = new LinearLayout(paramContext);
    this.a.setOrientation(1);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.a, paramContext);
  }
  
  public RecyclerView.ViewHolder a(int paramInt)
  {
    return (RecyclerView.ViewHolder)this.c.get(paramInt);
  }
  
  public RecyclerView.Adapter<RecyclerView.ViewHolder> getAdapter()
  {
    return this.b;
  }
  
  public int getViewHolderCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    this.b = paramAdapter;
    this.c = new ArrayList();
    this.a.removeAllViews();
    int i = 0;
    while (i < paramAdapter.getItemCount())
    {
      RecyclerView.ViewHolder localViewHolder = paramAdapter.onCreateViewHolder(this.a, 0);
      paramAdapter.onBindViewHolder(localViewHolder, i);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      this.a.addView(localViewHolder.itemView, localLayoutParams);
      this.c.add(localViewHolder);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkListView
 * JD-Core Version:    0.7.0.1
 */