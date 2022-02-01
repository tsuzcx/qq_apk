package com.tencent.mobileqq.activity.aio;

import afbf;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
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
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).sendBroadcast(localIntent);
      QQToast.a(afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 2, afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694485), 1).b(afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
      return;
    }
    QQToast.a(afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 1, afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694484), 1).b(afbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */