package com.tencent.biz.qqstory.utils;

import ajyc;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import bbcv;
import bbgg;
import vyj;
import vyk;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bbgg localbbgg = bbcv.a(this.a, 230);
    localbbgg.setMessage(ajyc.a(2131704574));
    localbbgg.setNegativeButton(ajyc.a(2131704576), new vyj(this));
    localbbgg.setPositiveButton(ajyc.a(2131704575), new vyk(this));
    localbbgg.setCancelable(false);
    localbbgg.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbbgg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */