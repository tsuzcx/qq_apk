package com.tencent.biz.common.util;

import android.app.Activity;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FileChooserHelper$4
  implements ActionSheet.OnButtonClickListener
{
  FileChooserHelper$4(FileChooserHelper paramFileChooserHelper, Activity paramActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        FileChooserHelper.a(this.d, this.a, this.b);
      }
    }
    else {
      FileChooserHelper.b(this.d, this.a);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.FileChooserHelper.4
 * JD-Core Version:    0.7.0.1
 */