package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;

public class MaterialContentAdapter$ContentItemVH
  extends RecyclerView.ViewHolder
{
  public ImageView c;
  public TextView d;
  public ImageView e;
  public ImageView f;
  public ImageView g;
  public ImageView h;
  public ImageView i;
  public AEDownLoadingView j;
  public TextView k;
  
  public MaterialContentAdapter$ContentItemVH(View paramView)
  {
    super(paramView);
    this.c = ((ImageView)paramView.findViewById(2063991213));
    this.d = ((TextView)paramView.findViewById(2063991570));
    this.e = ((ImageView)paramView.findViewById(2063991207));
    this.f = ((ImageView)paramView.findViewById(2063991209));
    this.g = ((ImageView)paramView.findViewById(2063991174));
    this.h = ((ImageView)paramView.findViewById(2063991194));
    this.i = ((ImageView)paramView.findViewById(2063991186));
    this.j = ((AEDownLoadingView)paramView.findViewById(2063991328));
    this.k = ((TextView)paramView.findViewById(2063991551));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j.setBgCorner(paramInt3 / 2);
    this.j.setMinimumHeight(paramInt3);
    this.j.setMinimumWidth(paramInt3);
    this.j.setProgressSizeAndMode(paramInt1, paramInt2, false);
    this.j.setBgColor(0);
    this.j.setProgressColor(-1);
    this.j.a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.i.getVisibility() != 0))
    {
      this.i.setVisibility(0);
      return;
    }
    if ((!paramBoolean) && (this.i.getVisibility() != 4)) {
      this.i.setVisibility(4);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.h.getVisibility() != 0)
      {
        this.h.setVisibility(0);
        this.j.setVisibility(0);
      }
      a(false);
    }
    else if (this.h.getVisibility() != 4)
    {
      this.h.setVisibility(4);
      this.j.setVisibility(4);
    }
    this.j.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH
 * JD-Core Version:    0.7.0.1
 */