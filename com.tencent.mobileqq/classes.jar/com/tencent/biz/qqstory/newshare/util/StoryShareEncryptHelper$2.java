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
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt params:" + this.jdField_a_of_type_JavaLangString);
    }
    long l = System.currentTimeMillis();
    StoryShareTranslateTokenRequest localStoryShareTranslateTokenRequest = new StoryShareTranslateTokenRequest();
    localStoryShareTranslateTokenRequest.c = 2;
    localStoryShareTranslateTokenRequest.b = this.jdField_a_of_type_JavaLangString;
    QQProgressDialog localQQProgressDialog1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      QQProgressDialog localQQProgressDialog2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      localQQProgressDialog1 = localQQProgressDialog2;
      if (!localQQProgressDialog2.isShowing())
      {
        localQQProgressDialog2.show();
        localQQProgressDialog1 = localQQProgressDialog2;
      }
    }
    for (;;)
    {
      CmdTaskManger.a().a(localStoryShareTranslateTokenRequest, new StoryShareEncryptHelper.2.1(this, l, localQQProgressDialog1));
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localQQProgressDialog1 = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
        localQQProgressDialog1.a(HardCodeUtil.a(2131714437));
        localQQProgressDialog1.show();
      }
      else
      {
        localQQProgressDialog1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2
 * JD-Core Version:    0.7.0.1
 */