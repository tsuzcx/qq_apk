package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import anni;
import bglp;
import bgpa;
import zks;
import zkt;

public final class FileUtils$1
  implements Runnable
{
  public FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    bgpa localbgpa = bglp.a(this.a, 230);
    localbgpa.setMessage(anni.a(2131703365));
    localbgpa.setNegativeButton(anni.a(2131703367), new zks(this));
    localbgpa.setPositiveButton(anni.a(2131703366), new zkt(this));
    localbgpa.setCancelable(false);
    localbgpa.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localbgpa.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */