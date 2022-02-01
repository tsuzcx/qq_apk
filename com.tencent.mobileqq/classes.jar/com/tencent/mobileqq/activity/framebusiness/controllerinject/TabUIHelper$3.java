package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

final class TabUIHelper$3
  extends DialogUtil.DialogOnClickAdapter
{
  TabUIHelper$3(String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TabControlReporter.a(true, this.a.contains("“频道”"));
    TabUIHelper.a().d();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper.3
 * JD-Core Version:    0.7.0.1
 */