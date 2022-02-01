package com.tencent.av.wtogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.av.wtogether.view.QBaseContentView;

class AVGroupFileSelectFragment$5
  implements DialogInterface.OnDismissListener
{
  AVGroupFileSelectFragment$5(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AVGroupFileSelectFragment.e(this.c).offsetTopAndBottom(-this.a);
    AVGroupFileSelectFragment.f(this.c).setVisibility(0);
    AVGroupFileSelectFragment.e(this.c).startAnimation(this.b);
    AVGroupFileSelectFragment.a(this.c, null);
    AVGroupFileSelectFragment.g(this.c).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.5
 * JD-Core Version:    0.7.0.1
 */