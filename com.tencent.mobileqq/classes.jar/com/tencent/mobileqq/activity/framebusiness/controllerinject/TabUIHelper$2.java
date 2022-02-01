package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

final class TabUIHelper$2
  extends DialogUtil.DialogOnClickAdapter
{
  TabUIHelper$2(String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TabControlReporter.a(this.a, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper.2
 * JD-Core Version:    0.7.0.1
 */