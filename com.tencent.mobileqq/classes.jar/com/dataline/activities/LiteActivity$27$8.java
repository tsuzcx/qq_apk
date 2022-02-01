package com.dataline.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.widget.XListView;

class LiteActivity$27$8
  implements Runnable
{
  LiteActivity$27$8(LiteActivity.27 param27, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    ClipboardManager localClipboardManager = (ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard");
    ClipData localClipData = ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString);
    ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
    localClipboardManager.setPrimaryClip(localClipData);
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$27.a.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.8
 * JD-Core Version:    0.7.0.1
 */