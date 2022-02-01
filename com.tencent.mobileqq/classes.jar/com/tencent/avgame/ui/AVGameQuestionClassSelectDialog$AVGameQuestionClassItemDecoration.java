package com.tencent.avgame.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class AVGameQuestionClassSelectDialog$AVGameQuestionClassItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public AVGameQuestionClassSelectDialog$AVGameQuestionClassItemDecoration(AVGameQuestionClassSelectDialog paramAVGameQuestionClassSelectDialog, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.bottom = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.left = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.AVGameQuestionClassItemDecoration
 * JD-Core Version:    0.7.0.1
 */