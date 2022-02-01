package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FileUtils$1
  implements Runnable
{
  FileUtils$1(Context paramContext) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    localQQCustomDialog.setMessage(HardCodeUtil.a(2131704601));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131704603), new FileUtils.1.1(this));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131704602), new FileUtils.1.2(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1
 * JD-Core Version:    0.7.0.1
 */