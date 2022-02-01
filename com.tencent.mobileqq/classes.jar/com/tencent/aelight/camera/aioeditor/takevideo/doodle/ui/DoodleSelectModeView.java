package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager;

public class DoodleSelectModeView
  extends FrameLayout
{
  private static final int[][] a = { { 2131429954 }, { 2131430002 } };
  private static final int[][] b;
  private int c;
  private DoodleSelectModeView.ISelectModeListener d;
  
  static
  {
    int[] arrayOfInt1 = { 2131430034 };
    int[] arrayOfInt2 = { 2131429829 };
    int[] arrayOfInt3 = { 2131429924 };
    b = new int[][] { arrayOfInt1, arrayOfInt2, { 2131429803 }, arrayOfInt3 };
  }
  
  public DoodleSelectModeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.c = paramInt;
    LayoutInflater.from(getContext()).inflate(2131624072, this);
    if (this.c == 1) {
      paramContext = b;
    } else {
      paramContext = a;
    }
    new EditButtonManager(this, paramContext).a(new DoodleSelectModeView.1(this));
  }
  
  public void setSelectModeListener(DoodleSelectModeView.ISelectModeListener paramISelectModeListener)
  {
    this.d = paramISelectModeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView
 * JD-Core Version:    0.7.0.1
 */