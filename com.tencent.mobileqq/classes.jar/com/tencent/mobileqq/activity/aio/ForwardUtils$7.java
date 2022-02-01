package com.tencent.mobileqq.activity.aio;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class ForwardUtils$7
  implements Runnable
{
  ForwardUtils$7(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
      QQToast.a(this.a.getApp(), 2, 2131692645, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.7
 * JD-Core Version:    0.7.0.1
 */