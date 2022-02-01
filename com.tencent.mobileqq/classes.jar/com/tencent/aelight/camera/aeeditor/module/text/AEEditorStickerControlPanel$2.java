package com.tencent.aelight.camera.aeeditor.module.text;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialCategoryAdapter;

class AEEditorStickerControlPanel$2
  extends RecyclerView.OnScrollListener
{
  AEEditorStickerControlPanel$2(AEEditorStickerControlPanel paramAEEditorStickerControlPanel) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AEEditorStickerControlPanel.a(this.a, false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!AEEditorStickerControlPanel.b(this.a))
    {
      paramInt1 = AEEditorStickerControlPanel.a(this.a).findFirstVisibleItemPosition();
      paramInt1 = MetaMaterialKt.a(AEEditorStickerControlPanel.a(this.a), AEEditorStickerControlPanel.b(this.a), paramInt1);
      AEEditorStickerControlPanel.a(this.a).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel.2
 * JD-Core Version:    0.7.0.1
 */