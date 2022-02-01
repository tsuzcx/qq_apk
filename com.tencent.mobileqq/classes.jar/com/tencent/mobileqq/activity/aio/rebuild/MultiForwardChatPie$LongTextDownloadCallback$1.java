package com.tencent.mobileqq.activity.aio.rebuild;

import afqz;
import aict;
import aidb;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;

public class MultiForwardChatPie$LongTextDownloadCallback$1
  implements Runnable
{
  public MultiForwardChatPie$LongTextDownloadCallback$1(aidb paramaidb, aict paramaict, CharSequence paramCharSequence) {}
  
  public void run()
  {
    aict.a(this.jdField_a_of_type_Aict).setVisibility(8);
    aict.a(this.jdField_a_of_type_Aict).setVisibility(0);
    aict.a(this.jdField_a_of_type_Aict).setVisibility(0);
    this.jdField_a_of_type_Aict.mTitleText.setText(this.jdField_a_of_type_Aict.c);
    aict.a(this.jdField_a_of_type_Aict).a(aict.a(this.jdField_a_of_type_Aict), this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_Aict.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1
 * JD-Core Version:    0.7.0.1
 */