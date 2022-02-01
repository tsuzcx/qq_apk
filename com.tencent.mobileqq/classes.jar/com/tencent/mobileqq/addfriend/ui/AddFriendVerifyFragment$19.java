package com.tencent.mobileqq.addfriend.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;

class AddFriendVerifyFragment$19
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AddFriendVerifyFragment$19(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public void onGlobalLayout()
  {
    if (AddFriendVerifyFragment.b(this.a)) {
      return;
    }
    Object localObject = new Rect();
    this.a.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    int i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i - (((Rect)localObject).bottom - ((Rect)localObject).top) > i / 3) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.a.getActivity().getCurrentFocus();
    if (i == 0)
    {
      if ((localObject instanceof EditText)) {
        ((EditText)localObject).setCursorVisible(false);
      }
    }
    else if ((localObject instanceof EditText)) {
      ((EditText)localObject).setCursorVisible(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.19
 * JD-Core Version:    0.7.0.1
 */