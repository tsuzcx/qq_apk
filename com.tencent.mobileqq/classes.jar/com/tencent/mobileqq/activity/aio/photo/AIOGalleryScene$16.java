package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class AIOGalleryScene$16
  implements ActionSheet.OnButtonClickListener
{
  AIOGalleryScene$16(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    paramView = this.a.getContent(paramInt);
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.a.dismiss();
      return;
    }
    this.d.a(paramView, this.b, this.c);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.16
 * JD-Core Version:    0.7.0.1
 */