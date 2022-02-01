package com.dataline.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import anla;
import ay;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import dy;

public class LiteActivity$27$8
  implements Runnable
{
  public LiteActivity$27$8(ay paramay, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ay.a.jdField_a_of_type_Dy.notifyDataSetChanged();
    ((ClipboardManager)this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.jdField_a_of_type_JavaLangString));
    LiteActivity.a(this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_Ay.a.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Ay.a.app.getMessageFacade().getDatalineMessageManager(this.jdField_a_of_type_Int).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.8
 * JD-Core Version:    0.7.0.1
 */