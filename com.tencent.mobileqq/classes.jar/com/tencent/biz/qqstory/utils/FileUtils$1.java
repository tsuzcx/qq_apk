package com.tencent.biz.qqstory.utils;

import amtj;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;
import ypj;
import ypk;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(this.a, 230);
    localQQCustomDialog.setMessage(amtj.a(2131703702));
    localQQCustomDialog.setNegativeButton(amtj.a(2131703704), new ypj(this));
    localQQCustomDialog.setPositiveButton(amtj.a(2131703703), new ypk(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */