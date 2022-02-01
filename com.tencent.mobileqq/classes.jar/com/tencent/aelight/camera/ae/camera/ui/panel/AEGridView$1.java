package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;

class AEGridView$1
  extends RecyclerView.OnScrollListener
{
  AEGridView$1(AEGridView paramAEGridView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScrollStateChanged-");
    localStringBuilder.append(paramInt);
    Log.d("dtexpose", localStringBuilder.toString());
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2)) {
      this.a.a(paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView.1
 * JD-Core Version:    0.7.0.1
 */