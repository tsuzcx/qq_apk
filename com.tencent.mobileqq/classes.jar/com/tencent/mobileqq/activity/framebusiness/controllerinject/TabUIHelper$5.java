package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

final class TabUIHelper$5
  extends DialogUtil.DialogOnClickAdapter
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TabControlReporter.a(true);
    TabUIHelper.a().d();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper.5
 * JD-Core Version:    0.7.0.1
 */