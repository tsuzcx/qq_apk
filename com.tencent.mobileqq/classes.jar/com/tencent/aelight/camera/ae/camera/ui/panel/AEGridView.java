package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AEGridView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private int b;
  
  public AEGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.b(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Int = ((m - k) / (i + k));
    int n = this.jdField_a_of_type_Int;
    setPadding((m - i * n) / (n + 1), 0, 0, j * 4);
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), this.jdField_a_of_type_Int));
    addItemDecoration(new AEGridView.SpacingItemDecoration(this, this.jdField_a_of_type_Int, k));
    this.b = i;
  }
  
  public void a(int paramInt)
  {
    int i = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    i = (paramInt / this.jdField_a_of_type_Int - 1) * (this.b + i);
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView
 * JD-Core Version:    0.7.0.1
 */