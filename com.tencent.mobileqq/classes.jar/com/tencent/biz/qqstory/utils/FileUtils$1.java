package com.tencent.biz.qqstory.utils;

import ajjy;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import babr;
import bafb;
import vln;
import vlo;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bafb localbafb = babr.a(this.a, 230);
    localbafb.setMessage(ajjy.a(2131638789));
    localbafb.setNegativeButton(ajjy.a(2131638791), new vln(this));
    localbafb.setPositiveButton(ajjy.a(2131638790), new vlo(this));
    localbafb.setCancelable(false);
    localbafb.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbafb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */