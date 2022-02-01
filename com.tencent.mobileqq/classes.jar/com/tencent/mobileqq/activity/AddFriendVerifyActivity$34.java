package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;

class AddFriendVerifyActivity$34
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AddFriendVerifyActivity$34(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    int i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i - (((Rect)localObject).bottom - ((Rect)localObject).top) > i / 3) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.a.getCurrentFocus();
    if (i == 0)
    {
      if ((localObject != null) && ((localObject instanceof EditText))) {
        ((EditText)localObject).setCursorVisible(false);
      }
    }
    else if ((localObject != null) && ((localObject instanceof EditText))) {
      ((EditText)localObject).setCursorVisible(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.34
 * JD-Core Version:    0.7.0.1
 */