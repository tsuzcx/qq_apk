package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import anvx;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;
import zec;
import zed;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a, 230);
    localQQCustomDialog.setMessage(anvx.a(2131704053));
    localQQCustomDialog.setNegativeButton(anvx.a(2131704055), new zec(this));
    localQQCustomDialog.setPositiveButton(anvx.a(2131704054), new zed(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */