package com.tencent.biz.qqstory.utils;

import alpo;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import bdcd;
import bdfq;
import xmy;
import xmz;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bdfq localbdfq = bdcd.a(this.a, 230);
    localbdfq.setMessage(alpo.a(2131704957));
    localbdfq.setNegativeButton(alpo.a(2131704959), new xmy(this));
    localbdfq.setPositiveButton(alpo.a(2131704958), new xmz(this));
    localbdfq.setCancelable(false);
    localbdfq.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbdfq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */