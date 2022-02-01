package com.tencent.mobileqq.activity.aio;

import agim;
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
      agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).sendBroadcast(localIntent);
      QQToast.a(agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 2, agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694371), 1).b(agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
      return;
    }
    QQToast.a(agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0), 1, agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getString(2131694370), 1).b(agim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$6.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */