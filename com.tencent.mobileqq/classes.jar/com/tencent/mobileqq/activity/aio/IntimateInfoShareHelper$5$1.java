package com.tencent.mobileqq.activity.aio;

import aens;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class IntimateInfoShareHelper$5$1
  implements Runnable
{
  IntimateInfoShareHelper$5$1(IntimateInfoShareHelper.5 param5, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0).sendBroadcast(localIntent);
      QQToast.a(aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0), 2, aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0).getString(2131695349), 1).b(aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0).getTitleBarHeight());
      return;
    }
    QQToast.a(aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0), 1, aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0).getString(2131695348), 1).b(aens.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper$5.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.5.1
 * JD-Core Version:    0.7.0.1
 */