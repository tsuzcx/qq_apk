package com.dataline.activities;

import akpg;
import android.content.Context;
import android.text.ClipboardManager;
import cl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.XListView;
import fk;

public class LiteActivity$27$7
  implements Runnable
{
  public LiteActivity$27$7(cl paramcl, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Cl.a.jdField_a_of_type_Fk.notifyDataSetChanged();
    try
    {
      ((ClipboardManager)this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      label41:
      LiteActivity.a(this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.jdField_a_of_type_Cl.a.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_Cl.a.app.a().a(this.jdField_a_of_type_Int).e();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.7
 * JD-Core Version:    0.7.0.1
 */