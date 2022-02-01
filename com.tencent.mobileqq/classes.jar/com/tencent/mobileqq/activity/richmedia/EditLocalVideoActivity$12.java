package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EditLocalVideoActivity$12
  implements ActionSheet.OnButtonClickListener
{
  EditLocalVideoActivity$12(EditLocalVideoActivity paramEditLocalVideoActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.a("608", "4", "2", true);
      EditLocalVideoActivity.b(this.b, 0);
      EditLocalVideoActivity.c(this.b, 0);
      paramView = this.b;
      EditLocalVideoActivity.d(paramView, EditLocalVideoActivity.p(paramView));
      EditLocalVideoActivity.q(this.b).postDelayed(new EditLocalVideoActivity.12.1(this), 300L);
      EditLocalVideoActivity.b(this.b, false);
      EditLocalVideoActivity.c(this.b, false);
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.12
 * JD-Core Version:    0.7.0.1
 */