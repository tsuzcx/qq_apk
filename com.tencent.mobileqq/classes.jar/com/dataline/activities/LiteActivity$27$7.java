package com.dataline.activities;

import amkn;
import android.content.Context;
import android.text.ClipboardManager;
import at;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import dt;

public class LiteActivity$27$7
  implements Runnable
{
  public LiteActivity$27$7(at paramat, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_At.a.jdField_a_of_type_Dt.notifyDataSetChanged();
    try
    {
      ((ClipboardManager)this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.jdField_a_of_type_At.a.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_At.a.app.a().a(this.jdField_a_of_type_Int).e();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.7
 * JD-Core Version:    0.7.0.1
 */