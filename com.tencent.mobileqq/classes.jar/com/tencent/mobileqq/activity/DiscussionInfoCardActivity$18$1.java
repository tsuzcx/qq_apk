package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bbmy;
import bfqn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DiscussionInfoCardActivity$18$1
  implements Runnable
{
  DiscussionInfoCardActivity$18$1(DiscussionInfoCardActivity.18 param18, String paramString) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.a))
      {
        bbmy.a(this.this$0.jdField_a_of_type_AndroidAppActivity, 1, 2131651443, 0).b(this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766));
        return;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.a)) {
        localArrayList.add(this.a);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", this.this$0.c);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", this.this$0.b);
      localBundle.putStringArrayList("image_url", localArrayList);
      bfqn.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidAppActivity, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i("DiscussionInfoCardActivity", 2, "shareToQzone.title:" + this.this$0.c + " filePath:" + this.a + " shareLink:" + this.this$0.b + " desc:" + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.18.1
 * JD-Core Version:    0.7.0.1
 */