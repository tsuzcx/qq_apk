package com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShortVideoPlayActivity$3
  implements DialogInterface.OnClickListener
{
  ShortVideoPlayActivity$3(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(this.a.e);
    }
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.3
 * JD-Core Version:    0.7.0.1
 */