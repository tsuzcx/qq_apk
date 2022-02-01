package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;

class MaterialClassifierView$1
  extends RecyclerView.OnScrollListener
{
  MaterialClassifierView$1(MaterialClassifierView paramMaterialClassifierView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      MaterialClassifierView.a(this.a, false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!MaterialClassifierView.a(this.a))
    {
      paramInt1 = MaterialClassifierView.b(this.a).findFirstVisibleItemPosition();
      paramInt1 = MetaMaterialKt.a(MaterialClassifierView.c(this.a), MaterialClassifierView.d(this.a), paramInt1);
      MaterialClassifierView.e(this.a).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.1
 * JD-Core Version:    0.7.0.1
 */