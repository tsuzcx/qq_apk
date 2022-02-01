package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class EditVideoProgressBar$1
  implements View.OnClickListener
{
  EditVideoProgressBar$1(EditVideoProgressBar paramEditVideoProgressBar) {}
  
  public void onClick(View paramView)
  {
    if (EditVideoProgressBar.a(this.a) != null)
    {
      if ((EditVideoProgressBar.a(this.a).l() == 1) && (EditVideoProgressBar.b(this.a) == 1))
      {
        EditVideoProgressBar.c(this.a);
        EditVideoProgressBar.d(this.a).setImageResource(2130849583);
        EditVideoProgressBar.a(this.a, 2);
        return;
      }
      if ((EditVideoProgressBar.a(this.a).l() == 2) && (EditVideoProgressBar.b(this.a) == 2))
      {
        EditVideoProgressBar.e(this.a);
        EditVideoProgressBar.d(this.a).setImageResource(2130849584);
        EditVideoProgressBar.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoProgressBar.1
 * JD-Core Version:    0.7.0.1
 */