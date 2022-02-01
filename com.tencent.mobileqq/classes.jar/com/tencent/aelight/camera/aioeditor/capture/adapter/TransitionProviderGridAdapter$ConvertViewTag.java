package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.image.URLImageView;

public class TransitionProviderGridAdapter$ConvertViewTag
{
  URLImageView a;
  View b;
  TextView c;
  TransitionCategoryItem d;
  boolean e = false;
  
  public void a(boolean paramBoolean)
  {
    View localView = this.b;
    if ((localView != null) && (this.d != null))
    {
      if (paramBoolean)
      {
        if (this.e)
        {
          localView.setBackgroundResource(2130845869);
          return;
        }
        localView.setBackgroundResource(2130845888);
        return;
      }
      if (this.e)
      {
        localView.setBackgroundResource(0);
        return;
      }
      localView.setBackgroundResource(2130845885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderGridAdapter.ConvertViewTag
 * JD-Core Version:    0.7.0.1
 */