package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class BusinessBrowser$BusinessBrowserFragment$2
  extends BroadcastReceiver
{
  BusinessBrowser$BusinessBrowserFragment$2(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action_decode_finish".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = (Bitmap)paramIntent.getParcelableExtra("bitmap");
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramContext)) && (paramIntent != null)) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!"action_follow_status_finish".equals(paramContext)) || (!String.valueOf(paramIntent.getStringExtra("uin")).equals(this.a.jdField_a_of_type_JavaLangString)));
      this.a.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isFollow", false);
    } while (this.a.jdField_a_of_type_AndroidWidgetTextView == null);
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701333));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701345));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */