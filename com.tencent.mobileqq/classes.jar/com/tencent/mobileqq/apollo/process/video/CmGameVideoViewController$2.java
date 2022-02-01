package com.tencent.mobileqq.apollo.process.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;

class CmGameVideoViewController$2
  implements DialogInterface.OnClickListener
{
  CmGameVideoViewController$2(CmGameVideoViewController paramCmGameVideoViewController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (CmGameVideoViewController.a(this.a) != null)
    {
      CmGameVideoViewController.b(this.a).setVisibility(8);
      CmGameVideoViewController.c(this.a).setVisibility(8);
      CmGameVideoViewController.b(this.a, false);
      CmGameVideoViewController.a(this.a).a();
    }
    this.a.a(6, 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */