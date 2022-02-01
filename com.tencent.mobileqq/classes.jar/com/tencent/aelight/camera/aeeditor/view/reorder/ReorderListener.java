package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.graphics.Point;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderListener;", "", "onEnterReorder", "", "uuid", "", "motionEvent", "Landroid/graphics/Point;", "onExitReorder", "targetIndex", "", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ReorderListener
{
  public abstract void a(@NotNull String paramString, int paramInt);
  
  public abstract void a(@NotNull String paramString, @NotNull Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderListener
 * JD-Core Version:    0.7.0.1
 */