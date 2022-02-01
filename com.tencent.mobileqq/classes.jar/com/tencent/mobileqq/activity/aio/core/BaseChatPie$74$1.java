package com.tencent.mobileqq.activity.aio.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.AppRuntime;

class BaseChatPie$74$1
  implements DialogInterface.OnClickListener
{
  BaseChatPie$74$1(BaseChatPie.74 param74) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$1.this$0.getActivity() != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.sApplication.getRuntime().getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://h5.qianbao.qq.com/auth?_wv=1027&_wvx=10&_wwv=4");
      this.this$1.this$0.getActivity().startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.74.1
 * JD-Core Version:    0.7.0.1
 */