package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopPhotoController$5
  implements ActionSheet.OnButtonClickListener
{
  TroopPhotoController$5(TroopPhotoController paramTroopPhotoController, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.this$0.mCurShowItemIndex == null) || (paramInt >= this.this$0.mCurShowItemIndex.length)) {
      return;
    }
    switch (this.this$0.mCurShowItemIndex[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.this$0.mActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
          ((BaseActivity)this.this$0.mActivity).requestPermissions(new TroopPhotoController.5.1(this), 1, new String[] { "android.permission.CAMERA" });
        } else {
          TroopPhotoController.access$000(this.this$0);
        }
      }
      else
      {
        TroopPhotoController.access$000(this.this$0);
        continue;
        TroopPhotoUtil.b(this.this$0.mActivity, TroopPhotoUtil.d(this.this$0.mType));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.5
 * JD-Core Version:    0.7.0.1
 */