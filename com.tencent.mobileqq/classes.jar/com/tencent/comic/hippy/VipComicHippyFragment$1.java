package com.tencent.comic.hippy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.comic.ui.ComicCancelRedPointPopDialog;

class VipComicHippyFragment$1
  implements DialogInterface.OnDismissListener
{
  VipComicHippyFragment$1(VipComicHippyFragment paramVipComicHippyFragment, ComicCancelRedPointPopDialog paramComicCancelRedPointPopDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.val$finalDialog.a) {
      VipComicHippyFragment.access$001(this.this$0);
    } else {
      VipComicHippyFragment.access$102(this.this$0, false);
    }
    VipComicHippyFragment.access$200(this.this$0, this.val$finalDialog.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.hippy.VipComicHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */