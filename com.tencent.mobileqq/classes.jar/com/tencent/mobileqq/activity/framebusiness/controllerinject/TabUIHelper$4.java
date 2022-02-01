package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

final class TabUIHelper$4
  extends DialogUtil.DialogOnClickAdapter
{
  TabUIHelper$4(String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TabControlReporter.a(false, this.a.contains("“频道”"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper.4
 * JD-Core Version:    0.7.0.1
 */