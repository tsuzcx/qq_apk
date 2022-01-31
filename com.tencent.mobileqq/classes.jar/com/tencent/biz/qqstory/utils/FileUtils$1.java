package com.tencent.biz.qqstory.utils;

import ajya;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import bbdj;
import bbgu;
import vyg;
import vyh;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bbgu localbbgu = bbdj.a(this.a, 230);
    localbbgu.setMessage(ajya.a(2131704585));
    localbbgu.setNegativeButton(ajya.a(2131704587), new vyg(this));
    localbbgu.setPositiveButton(ajya.a(2131704586), new vyh(this));
    localbbgu.setCancelable(false);
    localbbgu.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */