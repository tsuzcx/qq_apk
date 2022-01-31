package com.tencent.biz.qqstory.utils;

import alud;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import bdgm;
import bdjz;
import xrh;
import xri;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bdjz localbdjz = bdgm.a(this.a, 230);
    localbdjz.setMessage(alud.a(2131704969));
    localbdjz.setNegativeButton(alud.a(2131704971), new xrh(this));
    localbdjz.setPositiveButton(alud.a(2131704970), new xri(this));
    localbdjz.setCancelable(false);
    localbdjz.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */