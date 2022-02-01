package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class IntimateInfoShareHelper$6$1
  implements Runnable
{
  IntimateInfoShareHelper$6$1(IntimateInfoShareHelper.6 param6, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).sendBroadcast(localIntent);
      QQToast.a(IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 2, IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694913), 1).b(IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
      return;
    }
    QQToast.a(IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 1, IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694912), 1).b(IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */