package com.tencent.aelight.camera.education.api.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;

public class AnswerSearchEditVideoButton
  extends EditVideoButton
{
  public AnswerSearchEditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.setVisibility(8);
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      if ((paramViewGroup.getChildAt(i) instanceof ViewGroup))
      {
        paramViewGroup.getChildAt(i).setVisibility(8);
        a((ViewGroup)paramViewGroup.getChildAt(i));
      }
      else
      {
        paramViewGroup.getChildAt(i).setVisibility(8);
      }
      i += 1;
    }
  }
  
  public void a()
  {
    super.a();
    this.d.setVisibility(8);
    a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.education.api.impl.AnswerSearchEditVideoButton
 * JD-Core Version:    0.7.0.1
 */