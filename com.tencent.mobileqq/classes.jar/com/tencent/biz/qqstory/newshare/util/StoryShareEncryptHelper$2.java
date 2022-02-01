package com.tencent.biz.qqstory.newshare.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class StoryShareEncryptHelper$2
  implements Runnable
{
  StoryShareEncryptHelper$2(String paramString, QQProgressDialog paramQQProgressDialog, Context paramContext, StoryShareEncryptHelper.DecryptCallback paramDecryptCallback) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decrypt params:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.qqstory.share.trans.helper", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    StoryShareTranslateTokenRequest localStoryShareTranslateTokenRequest = new StoryShareTranslateTokenRequest();
    localStoryShareTranslateTokenRequest.g = 2;
    localStoryShareTranslateTokenRequest.f = this.a;
    QQProgressDialog localQQProgressDialog = this.b;
    if (localQQProgressDialog != null)
    {
      localObject = localQQProgressDialog;
      if (!localQQProgressDialog.isShowing())
      {
        localQQProgressDialog.show();
        localObject = localQQProgressDialog;
      }
    }
    else
    {
      localObject = this.c;
      if ((localObject instanceof Activity))
      {
        localObject = new QQProgressDialog((Context)localObject);
        ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131911872));
        ((QQProgressDialog)localObject).show();
      }
      else
      {
        localObject = null;
      }
    }
    CmdTaskManger.a().a(localStoryShareTranslateTokenRequest, new StoryShareEncryptHelper.2.1(this, l, (QQProgressDialog)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2
 * JD-Core Version:    0.7.0.1
 */