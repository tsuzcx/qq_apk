package com.tencent.av.wtogether;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class WTogetherRealNameVideoProcessHelper$1
  implements DialogInterface.OnClickListener
{
  WTogetherRealNameVideoProcessHelper$1(WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      WTogetherRealNameVideoProcessHelper.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper);
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=watchtogether");
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramDialogInterface, 21001);
      if (QLog.isColorLevel())
      {
        QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click confirm.");
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper.1
 * JD-Core Version:    0.7.0.1
 */