package com.tencent.biz.qqstory.shareGroup.addvideo;

import android.content.Context;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddVideoController$1
  implements ActionSheet.OnButtonClickListener
{
  AddVideoController$1(AddVideoController paramAddVideoController, ActionSheet paramActionSheet, Context paramContext, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.superDismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.i.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    this.i.a(this.b, this.c, this.d, this.e, this.f, true, this.g, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController.1
 * JD-Core Version:    0.7.0.1
 */