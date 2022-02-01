package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import anzj;
import bhlq;
import bhpc;
import zon;
import zoo;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bhpc localbhpc = bhlq.a(this.a, 230);
    localbhpc.setMessage(anzj.a(2131703472));
    localbhpc.setNegativeButton(anzj.a(2131703474), new zon(this));
    localbhpc.setPositiveButton(anzj.a(2131703473), new zoo(this));
    localbhpc.setCancelable(false);
    localbhpc.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbhpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */